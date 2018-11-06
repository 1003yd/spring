package kr.or.ddit.file.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.file.model.FileVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml"})
public class FileDaoTest {

	//spring 사용 전에는 new 연산자를 사용했지만 지금은 annotation을 통해 사용한다.
	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	/**  
	* Method   : test 
	* 작성자 : 1003yd 
	* 변경이력 :    
	* Method 설명 : 파일 정보 입력 
	*/
	@Test
	public void test() {
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("49195e40-0a65-4cb7-8dff-48e377fa9271");
		fileVo.setOrg_file_name("sally.png");
		fileVo.setFile_path("D:\\\\A_TeachingMaterial\\\\6.JspSrpgin\\\\upload");
		fileVo.setFile_ext(".png");
		
		int insertCnt = fileDao.insertFile(fileVo);
		
		assertEquals(1, insertCnt);
		
	}

}
