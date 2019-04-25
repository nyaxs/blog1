package nyaxs.blog.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import nyaxs.blog.pojo.Posts;
import nyaxs.blog.pojo.Talks;
import nyaxs.blog.pojo.Users;
import nyaxs.blog.service.PostsService;
import nyaxs.blog.service.TalksService;
import nyaxs.blog.service.UsersService;
import nyaxs.blog.util.DateFormat;

@SessionAttributes(value="user")
@Controller
@RequestMapping("")
public class TalksController {
	
	static Logger logger  = Logger.getLogger(TalksController.class);
	
	@Autowired
	TalksService talkService;
	@Autowired
	UsersService userService;
	@RequestMapping(value = "talks", method = RequestMethod.GET)
	public ModelAndView index() throws Exception {
		ModelAndView mav = new ModelAndView("talks");
		mav.addObject("listTalksAll", talkService.listTalksAll());
		return mav;
	}
	
	public ModelAndView initHomePage() {
		ModelAndView mav = new ModelAndView("talks");
		return mav;
	}
	@RequestMapping("listTalksByUser")
	public ModelAndView listTalksByUser(Users user) throws Exception {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("user",user);
		mav.addObject("listTalksByUser", talkService.listTalksByUserId(user.getId()));
		return mav;
	}

	@RequestMapping("talkPublish")
	public ModelAndView talkIssue(Talks talk) throws Exception {
		logger.info("进入talkPublish");
		logger.info("这里是talkAuthor-"+talk.getTalk_author());
		logger.info("这里是talkContent-"+talk.getTalk_content());
		ModelAndView mav = new ModelAndView();
		talk.setTalk_date(DateFormat.getCurrentTime());
		if (talkService.addTalk(talk) == 1) {
			logger.info("插入talk成功");
			logger.info("测试，重定向到home");
			mav.setViewName("redirect:home");
			Users user = userService.userGetById(talk.getTalk_author());
			mav.addObject("user",user);
			logger.info("这里是userId-"+user.getId());
			return mav;
		}
		mav.setViewName("error");
		return mav;
	}

	

}
