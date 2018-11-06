package kr.or.ddit.file.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.file.util.FileUtil;
import kr.or.ddit.mvc.MvcController;

public class FileUploadTest {

	private Logger logger = LoggerFactory.getLogger(MvcController.class);
	
	
	//테스트 코드를 운영코드보다 먼저 작성하는 방법
	//Test Driven Development(TDD) ==> 장점: 인터페이스를 보다 쉽게 구현가능함
	/**  
	* Method   : fileUploadTest 
	* 작성자 : 1003yd 
	* 변경이력 :    
	* Method 설명 :  파일 확장자 추출(확장자 포함)
	*/
	@Test
	public void fileUploadTest() {
		String originFilName = "br.own.png";
		String ext = FileUtil.getFileExt(originFilName);
		logger.debug("fileUplodateTest: {}", ext);
		assertEquals(".png", ext);
	}
	
	/**  
	* Method   : nonExtFileUploadTest 
	* 작성자 : 1003yd 
	* 변경이력 :    
	* Method 설명 :  파일 확장자 추출(확장자 미포함)
	*/
	@Test
	public void nonExtFileUploadTest() {
		String originFileName = "brown";
		String ext = FileUtil.getFileExt(originFileName);
		logger.debug("nonExtFileUploadTest: {}", ext);
		assertEquals("", ext);		
	}

}
