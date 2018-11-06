package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.test.ServiceDaoTestConfig;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVO;

import org.junit.Before;
import org.junit.Test;

/*
	 	Test클래스의 각 테스트 메서드가 수행되는 순서는 랜덤이기 때문에 알 수 가 없다.
 */

public class UserDaoTest extends ServiceDaoTestConfig{
	
	@Resource(name="userDao")
	private UserDao userDao ;
	
	
//	private final String TEST_USERID = "주연님";
	
/*	@Before
	public void setUp(){
		userDao = new UserDao();
		userDao.deleteUser(TEST_USERID);
	}*/
	
	
	@Test
	public void selectUserAllTest() {
		/***Given***/
		

		/***When***/
		int userList = userDao.selectUserAll().size();

		/***Then***/
		assertEquals(107,userList);
	}

	
	@Test
	public void selectUserTest(){
		/***Given***/
		String id = "brown";

		/***When***/
		UserVo userVo = userDao.selectUser(id);
		System.out.println(userVo.getUserId());
		
		
		/***Then***/
		assertNotNull(userVo);
		assertEquals(id, userVo.getUserId());
		assertEquals("브라운", userVo.getName());

	}
	
	@Test
	public void selectUserByVoTest(){
		/***Given***/

		/***When***/
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		userVo.setName("브라운");
		userVo.setPass("brownPass");
		
		UserVo userId = userDao.selectUser(userVo);
		
		/***Then***/
		assertNotNull(userVo);
		assertEquals(userVo.getUserId(), userId.getUserId());
		System.out.println("userVo.getUserId() :" + userVo.getUserId() + "  && userId.getUserId() :  " + userId.getUserId());
		assertEquals(userVo.getName(), userId.getName());
		System.out.println("userVo.getName() :" + userVo.getName() + "   && userId.getName() :  " + userId.getName());
		
	}
	
	@Test
	public void selectUsrPageListTest(){
		/***Given***/
		
		
		/***When***/
		PageVO page = new PageVO();
		page.setPage(1);
		page.setPageSize(10);

		List<UserVo> pageUserList = userDao.selectUserPageList(page);
		
		/***Then***/
		assertEquals(10, pageUserList.size());

	}
	
	/**  
	* Method   : getUserCntTest 
	* 작성자 : 1003yd 
	* 변경이력 :    
	* Method 설명 :  사용자 전체 건수 조회 테스트
	*/
	@Test
	public void getUserCntTest(){
		/***Given***/
		

		/***When***/
		int totalUserCnt = userDao.getUserCnt();

		/***Then***/
		assertEquals(107, totalUserCnt);
	}
	
	@Test
	public void insertUserTest(){
		/***Given***/
		//userVo 준비
		UserVo userVo = new UserVo();
		userVo.setUserId("주연님");
		userVo.setName("오늘 좀 ");
		userVo.setAddr1("이쁘시네요");
		userVo.setAddr2("물론");
		GregorianCalendar gc = new GregorianCalendar(2018,7,8);
		userVo.setBirth(new Date(gc.getTimeInMillis()));
		userVo.setEmail("안경이요");
		userVo.setPass("잘어울리시네요");
		userVo.setTel("옷도 이쁘시네요");
		userVo.setZipcd("1234");
	
		/***When***/
		//userDao.inserUser()
		int insertCnt = userDao.insertUser(userVo);
//		int deleteCnt = userDao.deleteUser(userVo.getUserId());
		
		/***Then***/
		//입력 건수 비교
		assertEquals(1, insertCnt);
//		assertEquals(1, deleteCnt);
	}
	

}
