package kr.or.ddit.hello;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.user.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:kr/or/ddit/config/spring/servlet-context.xml" })
@WebAppConfiguration
public class HelloControllerTest {

	private Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);

	@Autowired
	private WebApplicationContext ctx; // spring ioc 컨테이너

	private MockMvc mockMvc; // dispatcher servlet(front controller)

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();

	}

	@Test
	public void helloTest() throws Exception {
		/*** Given ***/

		/*** When ***/
		// dispatcher servlet으로 요청 전송
		MvcResult result = mockMvc.perform(get("/hello/hello.do")).andReturn();

		ModelAndView mav = result.getModelAndView();

		/*** Then ***/
		// view : hello
		assertEquals("hello", mav.getViewName());

	}

	@Test
	/*** Given ***/
	public void modelTest() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/hello/model")).andReturn();
		/*** When ***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		// 아래와 같은 두가지 방법 모두 가능
		List<String> rangers = (List<String>) mav.getModel().get("rangers");
//		mav.getModelMap().get("rangers");

		for (String ranger : rangers) {
			logger.debug("ranger : {}", ranger);
		}

		/*** Then ***/
		// 1. view 이름
		assertEquals("hello", viewName);

		// 2. rangers 속성(model)
		assertEquals(3, rangers.size());
	}
	
	@Test
	public void requestTest() throws Exception {
		/*** Given ***/
		MvcResult result = mockMvc.perform(get("/hello/request").param("userId", "brown").param("pass", "brownpass"))
				.andReturn();

		/*** When ***/
		ModelAndView mav = result.getModelAndView();

		String viewName = mav.getViewName();

		String userId = (String) mav.getModel().get("userId");
		String password = (String) mav.getModel().get("pass");
		/*** Then ***/
		assertEquals("hello", viewName);
		assertEquals("brown_attr", userId);
		assertEquals("brownpass_attr", password);
	}
	
	@Test
	public void voTest() throws Exception {

		MvcResult result = mockMvc.perform(get("/hello/vo").param("userId", "brown").param("pass", "brownpass")).andReturn();
		ModelAndView mav = result.getModelAndView();
		
		UserVo userVo = (UserVo)mav.getModel().get("userVo");
		
		assertEquals("brown", userVo.getUserId());
		assertEquals("brownpass", userVo.getPass());
		
	}
	
	
	
	
	
	
	
	

}
