package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.test.ServiceDaoTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVO;


public class UserServiceTest extends ServiceDaoTestConfig{
	
	@Resource(name="userService")
	private UserServiceInf userSerivce;
	
	//JUnit 실행 주기
	// @BeforeClass 가 적용된 메소드 실행(최초 1회만) => 반드시 static이어야 한다.
	// @Before 가 적용된 메소드 실행(테스트 메소드 실행전 실행)
	// @Test
	// @After 가 적용된 메소드 실행(테스트 메소드 실행 후 실행)
	// @AfterClass 가 적용된 메소드 실행(최초1회)

	// beforeClass 
	// before  -> selectAllUser() -> after
	// before -> selectUser(String) -> after
	// before -> selectUser(UserVo) -> after
	
	private String test ="";
	
	
	/*@BeforeClass
	public static void beforeClass(){
		System.out.println("beforclass");
	}

	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}

	@Before
	public void before(){
		System.out.println("before");
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
	*/
	@Test
	public void selectUserAlltest() {
		/***Given***/

		/***When***/
		List<UserVo> userList = userSerivce.selectUserAll();
		/***Then***/
		assertEquals(105, userList.size());

	}

	
/*	@Test
	public void selectUserTest() {
		*//***Given***//*

		*//***When***//*
		UserVo user = userSerivce.selectUser("brown");
		*//***Then***//*
		assertEquals("brown", user.getUserId());
		
	}
	
*/	@Test
	public void selectUserByVoTest() {
		/***Given***/

		/***When***/
		UserVo userparameter = new UserVo();
		userparameter.setUserId("brown");
		userparameter.setName("브라운");
		userparameter.setPass("brown1234");
		
		UserVo user = userSerivce.selectUser(userparameter);
		/***Then***/
		assertEquals(userparameter.getUserId(), user.getUserId());
	}
	
	@Test
	public void selectUsrPageListTest(){
		/***Given***/

		/***When***/
		PageVO page = new PageVO();
		page.setPage(1);
		page.setPageSize(10);

		Map<String, Object> resultMap = userSerivce.selectUserPageList(page);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		
		int pageCnt = (Integer)resultMap.get("pageCount");
		/***Then***/
		assertEquals(10,userList.size());
		assertEquals(11, pageCnt);
	}
	
	/*@Test
	public int deleteUser(String userId) {
		// TODO Auto-generated method stub
		UserVO userVo = new UserVO();
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
		
		int deleteCnt =service.deleteUser(userVo.getUserId());
		
		assertEquals(1, deleteCnt);
		
		return deleteCnt;
	}*/
	
	

}
