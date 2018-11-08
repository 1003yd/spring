package kr.or.ddit.exception.web;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.exception.NoFileException;

@Controller
public class ExceptionController {

	
	/**  
	* Method   : view 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 : 예외를 강제로 발생시키는 URL  
	*/
	//http://localhost:8081/exception
	@RequestMapping("/exception")
	public String view() {
		
		throw new ArithmeticException();
		
	}
	
	//reponse status 테스트를 위한 url
	@RequestMapping("/responseStatus")
	public String responseStatus() throws NoFileException {
		ClassPathResource resource = new ClassPathResource("kr/or/ddit/config/db/mybatis-config.xnl");
		try {
			resource.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new NoFileException();
		}
		
		return "error/arithmetic";
	}
	
}
