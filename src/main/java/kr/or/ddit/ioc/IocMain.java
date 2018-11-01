package kr.or.ddit.ioc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

public class IocMain {
	private static Logger logger = LoggerFactory.getLogger(IocMain.class);
	public static void main(String[] args) {
		//spring 컨테이너 생성
		ApplicationContext context = new  ClassPathXmlApplicationContext(new String[] {
											"classpath:kr/or/ddit/ioc/application-context.xml"
										});
		
		//xml에서의 id 를  인자값 으로 설정해주면 되고 반환타입은 object가된다.
		//spring 컨테이너에서 boardDao Spring bean을 요청 (DL : Dependency LookUp)
		BoardDaoInf boardDao = (BoardDaoInf)context.getBean("boardDao");
		List<BoardVo> boardList = boardDao.selectBoardList();
		
		for(BoardVo boardVo : boardList) {
			logger.debug("boardVo :{}" , boardVo);
//			System.out.println("boardVo : " + boardVo);
		}
		
		
		//스프링 컨테이너에서 boardService 스프링 빈을 요청 후 selectBoardList
		//결과를 logger를 이용하여 console에 출력
		BoardServiceInf boardService = (BoardServiceInf) context.getBean("boardService");
		List<BoardVo> board = boardService.selectBoardList();
		for(BoardVo boardVo : board) {
			logger.debug("boardVo :{}" , boardVo);
//			System.out.println("boardVo : " + boardVo);
		}
		
		//생성자 주입을 통해 생성된 boardService 스프링 빈을 요청
		BoardServiceInf boardServiceConst = (BoardServiceInf) context.getBean("boardServiceConst");
		boardList = boardService.selectBoardList();
		for(BoardVo boardVo : boardList) {
			logger.debug("boardVo :{}" , boardVo);
//			System.out.println("boardVo : " + boardVo);
		}
		
		//spring scope-prototype test
		BoardDaoInf boardDaoPrototype1 = context.getBean("boardDaoPrototype1",BoardDaoInf.class);
		BoardDaoInf boardDaoPrototype2 = context.getBean("boardDaoprototype1", BoardDaoInf.class);
		
		logger.debug("spring prototype bean test : {}",boardDaoPrototype1 == boardDaoPrototype2);
		
		//spring scope-singletone test
		BoardDaoInf boardDaoSingletone1 = context.getBean("boardDaoSingletone", BoardDaoInf.class);
//		BoardDaoInf boardDaoSingletone2 = context.getBean();
		
	}
}
