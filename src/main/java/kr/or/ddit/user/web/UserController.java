package kr.or.ddit.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping("/loginView")
	public String loginView() {
		return "login/login";
	}
	
	@RequestMapping(value = "/loginProcess" , method = RequestMethod.POST)
	public String loginView(HttpServletRequest requset) {
		String userId = requset.getParameter("userId");
		String password = requset.getParameter("password");
		
		if(userId.equals("brown") && password.equals("brownpass")) {
			return "main";
		}else {
			return "login/login";
		}
		
	}
	
	

}
