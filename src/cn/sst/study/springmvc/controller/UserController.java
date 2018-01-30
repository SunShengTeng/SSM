package cn.sst.study.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/login.action")
    public String login(HttpSession session, String username,String password){
		session.setAttribute("username", username);
		
    	return "redirect:/item/List.action";
    }
}
