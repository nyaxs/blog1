package nyaxs.blog.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import nyaxs.blog.pojo.Posts;
import nyaxs.blog.pojo.Talks;
import nyaxs.blog.pojo.TimeLineBean;
import nyaxs.blog.pojo.Users;
import nyaxs.blog.pojo.UsersRelation;
import nyaxs.blog.service.PostsService;
import nyaxs.blog.service.TalksService;
import nyaxs.blog.service.UsersRelationService;
import nyaxs.blog.service.UsersService;
import nyaxs.blog.util.DateFormat;

@SessionAttributes(value= "user")
@Controller
@RequestMapping("")
public class HomeController {
	@Autowired
	PostsService postService;
	@Autowired
	TalksService talkService;
	@Autowired
	UsersService userService;
	@Autowired
	UsersRelationService userRelationService;
	
	static Logger logger  = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value = "home")
	public ModelAndView home(@ModelAttribute("user") Users user) throws Exception {
		logger.info("接受login的传值："+ user);
		//int id = Integer.parseInt(userId);
		//Users user = userService.userGetById(id);
		ModelAndView mav = new ModelAndView("home");
		List<TimeLineBean> listTlbSelf = new ArrayList<TimeLineBean>();
		List<TimeLineBean> listTlbFollowed = new ArrayList<TimeLineBean>();
		List<Posts> listPSelf = postService.listPostsByUserId(user.getId());
		List<Talks> listTSelf = talkService.listTalksByUserId(user.getId());
		List<UsersRelation> listUr = userRelationService.getFollowedList(user.getId());
		
		logger.info("开始整理，装填数据");
		listTlbSelf = addTlbFromUser(user,listTlbSelf, listPSelf, listTSelf);
		listTlbFollowed = getFollowedTlb(listUr);
		listTlbSelf = Stream.concat(listTlbSelf.stream(), listTlbFollowed.stream()).collect(Collectors.toList());
		logger.info("数据装填完成");
		logger.info("getDate()作为识别码去重");
		logger.info("按发布时间从后向前整理列表");
		 List<Date> dates = new ArrayList<>();
		listTlbSelf = listTlbSelf.stream().filter(d->{
			boolean flag = !dates.contains(d.getDate());
			dates.add(d.getDate());
			return flag;
		}).sorted(Comparator.comparing(TimeLineBean::getDate).reversed()).collect(Collectors.toList());
		
		logger.info("向模型视图装填首页用户数据");
		mav.addObject("listTimeLine", listTlbSelf);
		mav.addObject("user",user);
		mav.addObject("userFollowed",listUr);
		logger.info("返回页面");
		return mav;
	}
	
	//装填用户关注的用户的动态
	public List<TimeLineBean> getFollowedTlb(List<UsersRelation> listUr) throws Exception{
		logger.info("开始装填用户关注的用户的动态");
		List<TimeLineBean> listTlbFollowed = new ArrayList<TimeLineBean>();
		for(UsersRelation ur:listUr){
			Users userFollowed = userService.userGetById(ur.getFollowed_id());
			List<Posts> listPFollowed = postService.listPostsByUserId(ur.getFollowed_id());
			List<Talks> listTFollowed = talkService.listTalksByUserId(ur.getFollowed_id());
			listTlbFollowed = Stream.concat(listTlbFollowed.stream(), addTlbFromUser(userFollowed,listTlbFollowed, listPFollowed, listTFollowed).stream()).collect(Collectors.toList());
		};
		return listTlbFollowed;
	}
	//装填用户的动态
	public List<TimeLineBean> addTlbFromUser(Users user,List<TimeLineBean> listTlb,List<Posts> listP,List<Talks> listT){
		logger.info("开始装填用户的动态数据");
		listP.stream().forEach((item)->{
			TimeLineBean tlb = new TimeLineBean();
			tlb.setTitle(item.getPost_title());
			tlb.setAuthor(item.getPost_author());
			tlb.setDate(item.getPost_date());
			tlb.setContent(item.getPost_content());
			tlb.setCollect_count(item.getCollect_count());
			tlb.setShare_count(item.getShare_count());
			tlb.setComment_count(item.getComment_count());
			tlb.setUpvote_count(item.getUpvote_count());
			tlb.setUserLogin(user.getUser_login());
			tlb.setNiceName(user.getUser_nicename());
			tlb.setAuthor(user.getId());
			tlb.setPostId(item.getId());
			tlb.setType("posts");
			listTlb.add(tlb);
		});
		listT.stream().forEach(item -> {
			TimeLineBean tlb = new TimeLineBean();
			tlb.setAuthor(item.getTalk_author());
			tlb.setDate(item.getTalk_date());
			tlb.setTalkDetail(item.getTalk_content());
			tlb.setCollect_count(item.getTalk_collect_count());
			tlb.setShare_count(item.getTalk_share_count());
			tlb.setComment_count(item.getTalk_comment_count());
			tlb.setUpvote_count(item.getTalk_upvote_count());
			tlb.setUserLogin(user.getUser_login());
			tlb.setNiceName(user.getUser_nicename());
			tlb.setAuthor(user.getId());
			tlb.setTalkId(item.getId());
			tlb.setType("talks");
			listTlb.add(tlb);
		});
		
		
		return listTlb;
	}

	
	@RequestMapping(value = "homeTest")
	public ModelAndView homeTest(@ModelAttribute("user") Users user) throws Exception {
		logger.info("测试session传值，来自talkPublish");
		logger.info("从session-user中获得的userId-"+user.getId());
		ModelAndView mav = new ModelAndView("test1");
		return mav;
	}
	

}
