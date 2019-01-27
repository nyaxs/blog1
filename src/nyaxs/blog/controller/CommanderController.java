package nyaxs.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import nyaxs.blog.pojo.Posts;
import nyaxs.blog.pojo.Commander;
import nyaxs.blog.service.CommanderService;

@Controller
@RequestMapping("")
public class CommanderController {
	@Autowired
	CommanderService commService;

	@RequestMapping("listCommander")
	public ModelAndView listCommander() {
		ModelAndView mav = new ModelAndView();
		List<Commander> cs = commService.list();
		mav.addObject("cs", cs);
		mav.setViewName("listCommander");
		return mav;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login", "command", new Commander());
	}

	@RequestMapping(value = "loginAction", method = RequestMethod.POST)
	public String loginAction(@ModelAttribute("commander") Commander comm, ModelMap model) {
		Commander comm1 = commService.login(comm.getName(), comm.getPassword());
		if (comm1 != null) {
			model.addAttribute("name", comm1.getName());
			model.addAttribute("password", comm1.getPassword());
			model.addAttribute("id", comm1.getId());
			return "commander";
		}
		return "error";
	}

}
