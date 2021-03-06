package kr.or.ddit.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.model.UserVoJsr303;
import kr.or.ddit.user.model.UserVoValidator;

@RequestMapping("/validator")
@Controller
public class ValidatorController {

	//validator를 테스트 할 view(/WEB-INF/view/validator/view.jsp)
	//httpeMethod:get
	
	@RequestMapping(value="/view", method= RequestMethod.GET)
	public String view() {
		
		return "validator/view";
	}
	
	
	//view에서 입력한 값을 처리할 method
	//검증절차에서 문제가 있을 경우 최초 테스트 view로 가서 메세지를 출력
	//검증절차에 문제가 없을 경우 /WEB-INF/view/validator/result.jsp로 이동
	//httpMethod :post
	//BindingResult 객체는 검증하고자 하는 vo 객체 뒤에 메소드 인자로 넣어야 한다.
	//메소드 인자 순서 주의!!!
	@RequestMapping(value="/validate", method= RequestMethod.POST)
	public String validate(UserVo userVo,BindingResult bindingResult, Model model) {
		new UserVoValidator().validate(userVo, bindingResult);
		//error가 발생하는지 판단하는 조건문
		if(bindingResult.hasErrors()) {
			return "validator/view";
		}
		
		model.addAttribute("userVo",userVo);
		return "validator/result";
	}

	@RequestMapping(value="/validateJsr", method= RequestMethod.POST)
	public String validateJsr(@Valid UserVoJsr303 userVoJsr303 ,BindingResult bindingResult,Model model) {
		//error가 발생하는지 판단하는 조건문
		if(bindingResult.hasErrors()) {
			return "validator/view";
		}
		
		model.addAttribute("userVoJsr303",userVoJsr303);
		return "validator/result";
	}
}
