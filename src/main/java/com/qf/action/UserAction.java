package com.qf.action;

import com.qf.pojo.Userinfo;
import com.qf.service.UserinfoService;
import javafx.scene.control.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.apache.ibatis.ognl.DynamicSubscript.all;

/**
 * Thanks for Everything.
 */
@Controller
public class UserAction {

	@Autowired
	private UserinfoService userinfoService;

	//跳转到删除页面
	@RequestMapping("/predel")
	public String preDel(){
		return "userdel";
	}

	//跳转到模糊查询页面
	@RequestMapping("/prebul")
	public String preAdd(){
		return "userbul";
	}

	//跳转到添加页面
	@RequestMapping("/preadd")
	public String preBul(){
		return "useradd";
	}

	//跳转到根据id查询页面
	@RequestMapping("/prefind")
	public String preFind(){
		return "userfind";
	}

	@RequestMapping("/adduser")
	public String adduser(HttpServletRequest request){
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		Userinfo pojo = new Userinfo();
		List<Userinfo> all = userinfoService.findAll();
		for (Userinfo userinfo : all) {
			if (userinfo.getUserName().equals(userName)){
				return "/erroruser";
			}
		}
		pojo.setUserName(userName);
		pojo.setUserPass(userPass);
		userinfoService.adduser(pojo);

		return "/listuser";
	}

	@RequestMapping("/userdel")
	public String deluser(HttpServletRequest request){
		String uid = request.getParameter("uid");
		userinfoService.deluser(Integer.valueOf(uid));
		return "/delusersu";
	}
	@RequestMapping("/userbul")
	public ModelAndView buluser(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		List<Userinfo> all = userinfoService.bluruser(userName,userPass);

		mv.addObject("userList",all);
		mv.setViewName("userlistbul");
		return mv;
	}

	@RequestMapping("/finduser")
	public ModelAndView finduser(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		String uid = request.getParameter("uid");
		Userinfo byId = userinfoService.findById(Long.parseLong(uid));
		mv.addObject("dto",byId);
		mv.setViewName("userfindsu");
		return mv;
	}


	@RequestMapping("/listuser")
	public ModelAndView listuser(){
		ModelAndView mv = new ModelAndView();
		List<Userinfo> all = userinfoService.findAll();
		mv.addObject("dto",all);
		mv.setViewName("userlist");
		return mv;
	}
}
