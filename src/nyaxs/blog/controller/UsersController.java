package nyaxs.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nyaxs.blog.pojo.Users;
import nyaxs.blog.service.PostsService;
import nyaxs.blog.service.TalksService;
import nyaxs.blog.service.UsersService;
import nyaxs.blog.util.DateFormat;

@Controller
@RequestMapping("")
public class UsersController {
	@Autowired
	UsersService userService;
	@Autowired
	PostsService postService;
	@Autowired
	TalksService talkService;
	

	@RequestMapping("userLogin")
	public ModelAndView userLogin(Users user) {
		ModelAndView mav = new ModelAndView();
		Users user1 = userService.userLogin(user.getUser_login(), user.getUser_pass());
		
		if (user1 != null) {
			mav.addObject("listPost", postService.listPostsByUserId(user1.getId()));
			mav.addObject("listTalk", talkService.listTalksByUserId(user1.getId()));
			mav.addObject("user", user1);
			mav.setViewName("home");
			return mav;
		}
		mav.setViewName("error");
		return mav;
	}

	@RequestMapping("userRegister")
	public ModelAndView userRegister(Users user) {
		ModelAndView mav = new ModelAndView();
		user.setUser_registered(DateFormat.getCurrentTime());
		if (userService.userRegister(user) == 1) {
			mav.addObject("user", user);
			mav.setViewName("home");
			return mav;
		}
		mav.setViewName("error");
		return mav;
	}

}
