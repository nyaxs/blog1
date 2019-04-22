package nyaxs.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nyaxs.blog.pojo.Users;
import nyaxs.blog.service.PostsService;
import nyaxs.blog.service.UsersService;
import nyaxs.blog.util.DateFormat;

@Controller
@RequestMapping("")
public class TestController {


	@RequestMapping("test1")
	public ModelAndView testVue1() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("test1");
		return mav;
	}
	@RequestMapping("test2")
	public ModelAndView testVue2() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("test2");
		return mav;
	}

}
