package nyaxs.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nyaxs.blog.pojo.Users;
import nyaxs.blog.pojo.Talks;
import nyaxs.blog.service.TalksService;
import nyaxs.blog.service.UsersService;
// import nyaxs.blog.util.DateFormat;
import nyaxs.blog.util.DateFormat;

@Controller
@RequestMapping("")
public class TalksController {
	@Autowired
	TalksService talkService;
	@Autowired
	UsersService userService;
	
	@RequestMapping(value = "talking", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listTalkAll", talkService.listTalksAll());
		return mav;
	}
	
	public ModelAndView initHomePage() {
		ModelAndView mav = new ModelAndView("home");

		return mav;
	}
	
	@RequestMapping("listTalksByUser")
	public ModelAndView listTalksByUser(Users user) {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("user", user);
		mav.addObject("listTalk", talkService.listTalksByUserId(user.getId()));
		return mav;
	}
	
	@RequestMapping("talkIssue")
	public ModelAndView talkIssue(Talks talk) {
		ModelAndView mav = new ModelAndView();
		talk.setTalk_date(DateFormat.getCurrentTime());
		if (talkService.addTalk(talk) == 1) {
			mav.addObject("listTalkByUser", talkService.listTalksByUserId(talk.getTalk_author()));
			mav.setViewName("home");
			mav.addObject("user", userService.userGetById(talk.getTalk_author()));
			return mav;
		}
		mav.setViewName("error");
		return mav;
	}

}
