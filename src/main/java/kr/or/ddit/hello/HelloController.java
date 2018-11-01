package kr.or.ddit.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 
 Servlet
 1. HttpServlet 클래스를 상속
 2. @WebServlet 혹은 web.xml에 url-mapping 등록
 3. doGet, doPost 같은 doXXX메소드를 통해 서비스 개발

 Spring Controller
 1. @Controller annotation 적용
 2. @RequestMapping annotation 적용(class / method)

 */

@RequestMapping("/hello")
@Controller
public class HelloController {
	
	// 사용자 요청 : localhost:8081/hello/hello.do url로 요청하게 되면  아래 메소드에서 요청을 처리
	// 만약 class에 적용한 	@RequestMapping("/hello") 부분을 삭제하게 되면 localhost:8081/hello.do url 요청에 대해 hello() 메소드에서 요청을 처리하게 됨 
	@RequestMapping("/hello.do")
	public String hello() {
		//viewName을 리턴
		//internalResourceViewResolver 설정에 의해 
		//prefix + viewName + suffix 위치의 리소스로 응답 위임한다.
		//prefix : /WEB-INF/view
		//suffix : .jsp
		// viewName : hello
		// /WEB-INF/view/hello.jsp
		// 기본 : forward
		
		return "hello";
	}
	
	
	
	/*
	 servlet, doGet, doPost : 메소드 인자가 HttpServletRequest, HttpServletResponse
	 spring controller 메소드 : 비교적 자유롭게 구성이 가능
	   						  HttpServletRequest, HttpServletResponse,
	   						  HttpSession, 
	   						  ValueObject,
	   						  Model : view에서 표현할 데이터를 저장
	*/
	@RequestMapping("/model")
	public String model(Model model) {
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
		//servlet : requset.setAttribute("rangers", rangers);
		
		model.addAttribute("rangers",rangers);
		return "hello";
	}
	
	
	
	
}
