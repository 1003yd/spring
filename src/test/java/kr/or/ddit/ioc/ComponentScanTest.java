package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/ioc/application-context-scan.xml"})
public class ComponentScanTest {
	
	//인자값으로는 로그를 포함하고 있는 클래스명.class 를 작성해주면 된다.
	private Logger logger = LoggerFactory.getLogger(ComponentScanTest.class);
	
	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
		
	/**  
	* Method   : componentScanTest 
	* 작성자 : 1003yd 
	* 변경이력 :    
	* Method 설명 :  Spring annotation scan을 통해 스프링 빈 생성이 정상적으로 되었는지 테스트
	*/
	@Test
	public void componentScanTest() {
		
		/***Given***/
		
		/***When***/
		List<BoardVo> boardList = boardDao.selectBoardList();
		for(BoardVo boardVo : boardList) {
			logger.debug("{}", boardVo);
		}
		/***Then***/
		assertNotNull(boardDao);

	}
	
	//boardService 빈 스캔 테스트
	@Test
	public void boardServiceScanTest() {
		/***Given***/
		
		/***When***/
		List<BoardVo> boardList = boardService.selectBoardList();
		for(BoardVo boardVo : boardList) {
			logger.debug("{}", boardVo);
		}
		/***Then***/
		assertNotNull(boardService);
	}
	
	@Test
	public void boardDaoEqualsTest() {
		/***Given***/
		
		/***When***/
		
		/***Then***/
		assertEquals(boardDao,boardService.getBoardDao());

	}

}
