package kr.or.ddit.user.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserVoValidator implements Validator {
	private Logger logger = LoggerFactory.getLogger(UserVoValidator.class);
	//메소드 인자로 들어온 clazz 객체가 UserVo로 부터 생성 가능한지 여부를 판단
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		//clazz로 부터 UserVo가 사용가능한지 확인
		return UserVo.class.isAssignableFrom(clazz);
	}

	//실제 검증로직(ex: 값이 비어있는지, 글자수 제한, 정규식, 휴대폰 번호 포맷팅 적용??)
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		//target : 실제 validation을 할 대상 객체
//		target => userVo
		UserVo userVo = (UserVo)target;
		
		
		//사용자 아이디 공백 체크
		if(userVo.getUserId() == null || userVo.getUserId().equals("")) {
			//logger
			logger.debug("validate userId userId {}");
			errors.rejectValue("userId", "required");
		}
		
		//pass 길이가 5보다 작을때 error:lengthNotEnough
		if(userVo.getPass().length() < 5 || userVo.getPass() == null) {
			errors.rejectValue("pass", "lengthNotEnough");
		}
		
		
		if(userVo.getName() == null || userVo.getName().equals("")) {
			errors.rejectValue("name", "notValueName");
		}
		
		
	}

}
