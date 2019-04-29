package nyaxs.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nyaxs.blog.pojo.Users;
import nyaxs.blog.service.PostsService;
import nyaxs.blog.service.TalksService;
import nyaxs.blog.service.UsersRelationService;
import nyaxs.blog.service.UsersService;
import nyaxs.blog.util.DateFormat;

@SessionAttributes(value= "user")
@Controller
@RequestMapping("")
public class UsersController {
	@Autowired
	UsersService userService;
	@Autowired
	PostsService postService;
	@Autowired
	TalksService talkService;
	@Autowired
	UsersRelationService userRelationService;
	
	
	static Logger logger  = Logger.getLogger(UsersController.class);
	
	@RequestMapping("login")
	public ModelAndView login() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping("userLogin")
	public ModelAndView userLogin(Users user) throws Exception {
		ModelAndView mav = new ModelAndView();
		Users user1 = userService.userLogin(user.getUser_login(), user.getUser_pass());
		
		if (user1 != null) {
			/*
			mav.addObject("listTalksByUser", talkService.listTalksByUserId(user1.getId()));
			mav.addObject("user", user1);
			mav.setViewName("home");*/
			logger.info("验证成功");
			logger.info("添加传递对象，跳转home页");
			logger.info(user1.getId());
			mav.addObject("user",user1);
			mav.setViewName("redirect:home");
			return mav;
		}
		else {
			mav.setViewName("forward:userRegister");
			return mav;
		}
	}

	@RequestMapping("userRegister")
	public ModelAndView userRegister(Users user) throws Exception {
		ModelAndView mav = new ModelAndView();
		user.setUser_registered(DateFormat.getCurrentTime());
		if (userService.userRegister(user) == 1) {
			logger.info("注册成功");
			logger.info("转发给userLogin");
			mav.addObject("user", user);
			mav.setViewName("forward:userLogin");
			return mav;
		}
		mav.setViewName("error");
		return mav;
	}
	
	@RequestMapping("userInfo")
	public ModelAndView userInfo(@ModelAttribute("user") Users user) throws Exception {
		ModelAndView mav = new ModelAndView();
			logger.info("前往userInfo页");
			logger.info("测试user-nicename值-"+user.getUser_nicename());
			List<Users> followingList = new ArrayList<Users>();
			List<Users> followersList = new ArrayList<Users>();
			userRelationService.getFollowedList(user.getId()).stream().forEach(item->{
				try {
					Users following = userService.userGetById(item.getFollowed_id());
					logger.info("测试following userName值-"+following.getUser_nicename());
					followingList.add(following);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
			userRelationService.getFollwers(user.getId()).stream().forEach(item->{
				Users follower;
				try {
					follower = userService.userGetById(item.getId());
					logger.info("测试follower userName值-"+follower.getUser_nicename());
					followersList.add(follower);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
			mav.addObject("followingList", followingList);
			mav.addObject("followersList", followersList);
			mav.addObject("user", user);
			mav.setViewName("userInfo");
			return mav;
	}
}
