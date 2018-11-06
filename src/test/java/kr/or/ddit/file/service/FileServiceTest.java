package kr.or.ddit.file.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.file.model.FileVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml"})
public class FileServiceTest {
	
	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	@Test
	public void test() {
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("49195e40-0a65-4cb7-8dff-48e377fa9721");
		fileVo.setOrg_file_name("cony.png");
		fileVo.setFile_path("D:\\\\A_TeachingMaterial\\\\6.JspSrpgin\\\\upload");
		fileVo.setFile_ext(".png");
		
		int insertCnt = fileService.insertFile(fileVo);
		
		assertEquals(1, insertCnt);
	}

}
