package nyaxs.blog.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import nyaxs.blog.pojo.Posts;
import nyaxs.blog.pojo.Users;
import nyaxs.blog.service.PostsService;
import nyaxs.blog.service.UsersService;
import nyaxs.blog.util.DateFormat;

@SessionAttributes(value= {"user","post"})
@Controller
@RequestMapping("")
public class PostsController {
	@Autowired
	PostsService postService;
	@Autowired
	UsersService userService;
	
	
	static Logger  logger = Logger.getLogger(PostsController.class);
	
	@RequestMapping(value = "index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listPostAll", postService.listPostsAll());
		return mav;
	}
	
	@RequestMapping(value = "blog")
	public ModelAndView blog(@ModelAttribute("user") Users user) {
		logger.info("测试跳转blog页传值user。getId-"+user.getId());
		ModelAndView mav = new ModelAndView("blog");
		mav.addObject("user",user);
		mav.addObject("listPostByUser", postService.listPostsByUserId(user.getId()));
		return mav;
	}
	
	@RequestMapping(value = "postPublish")
	public ModelAndView publishBlog(@ModelAttribute("user") Users user,Posts post) throws Exception {
		logger.info("进入postPublish");
		logger.info("测试blog页发布新blog传值post.post_author-"+post.getPost_author());
		
		ModelAndView mav = new ModelAndView();
		post.setPost_date(DateFormat.getCurrentTime());
		if (postService.addPost(post) == 1) {
			logger.info("插入post成功");
			logger.info("测试，重定向到blog");
			mav.setViewName("redirect:home");
			//Users user1 = userService.userGetById(post.getPost_author());
			mav.addObject("user",user);
			logger.info("这里是userId-"+user.getId());
			return mav;
		}
		mav.setViewName("error");
		return mav;
	}
	

	@RequestMapping(value = "blogDetail")
	public ModelAndView blogDetail(@ModelAttribute("user") Users user, int postId) throws Exception {
		logger.info("测试跳转blogDetail页传值user.getId-"+user.getId());
		logger.info("测试跳转blogDetail页传值postId-"+postId);
		ModelAndView mav = new ModelAndView("blogDetail");
		mav.addObject("user",user);
		mav.addObject("post", postService.getPostById(postId));
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
