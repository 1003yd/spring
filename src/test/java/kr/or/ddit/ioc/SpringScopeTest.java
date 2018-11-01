package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.BoardDaoInf;

//ApplicationContext 컨테이너 설정
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/ioc/application-context.xml"})
public class SpringScopeTest {
	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="boardDaoSingletone")
	private BoardDaoInf boardDaoSingletone;
	
	
	@Resource(name="boardDaoSingletone")
	private BoardDaoInf boardDaoSingletone2;
	
	/**  
	* Method   : springBeanSopeSingletoneTest 
	* 작성자 : 1003yd 
	* 변경이력 :    
	* Method 설명 :  스프링의  scope singletone 테스트
	*/
	@Test
	public void springBeanSopeSingletoneTest() {
		/***Given***/
		
		
		/***When***/

		/***Then***/
		assertNotEquals(boardDao, boardDaoSingletone);
		assertEquals(boardDaoSingletone, boardDaoSingletone2);
	}

}
