package nyaxs.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nyaxs.blog.pojo.Posts;
import nyaxs.blog.pojo.Users;
import nyaxs.blog.service.PostsService;
import nyaxs.blog.service.UsersService;
import nyaxs.blog.util.DateFormat;

@Controller
@RequestMapping("")
public class PostsController {
	@Autowired
	PostsService postService;
	@Autowired
	UsersService userService;
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listPostAll", postService.listPostsAll());
		return mav;
	}
	
	@RequestMapping(value = "blog", method = RequestMethod.GET)
	public ModelAndView blog(int userId) {
		ModelAndView mav = new ModelAndView("blog");
		mav.addObject("listPostAll", postService.listPostsAll());
		mav.addObject("listPostByUser", postService.listPostsByUserId(userId));
		return mav;
	}
	
	public ModelAndView initHomePage() {
		ModelAndView mav = new ModelAndView("home");

		return mav;
	}
	@RequestMapping("listPostsByUser")
	public ModelAndView listPostsByUser(Users user) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("user",user);
		mav.addObject("listPost", postService.listPostsByUserId(user.getId()));
		return mav;
	}

	@RequestMapping("postIssue")
	public ModelAndView postIssue(Posts post) throws Exception {
		ModelAndView mav = new ModelAndView();
		post.setPost_date(DateFormat.getCurrentTime());
		if (postService.addPost(post) == 1) {
			mav.addObject("listPostByUser", postService.listPostsByUserId(post.getPost_author()));
			mav.setViewName("home");
			mav.addObject("user",userService.userGetById(post.getPost_author()));
			return mav;
		}
		mav.setViewName("error");
		return mav;
	}

	@RequestMapping("postGetByTitle")
	public ModelAndView postGetByTitle(Posts post) {
		ModelAndView mav = new ModelAndView();
			mav.addObject("listPostByTitle", postService.getPostByTitle(post.getPost_title()));
			mav.setViewName("home");
			return mav;
	}

}
