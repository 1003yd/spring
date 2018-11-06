package kr.or.ddit.user.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:kr/or/ddit/config/spring/servlet-context.xml"
									,  "classpath:kr/or/ddit/config/spring/root-context.xml"})
@WebAppConfiguration // Spring 컨테이너를 web 기반 컨테이너로 생성
public class UserControllerTest {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	// Test 메소드 시작전 준비작업을 실행하는 메서드
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();

	}

	@Test
	public void loginViewTest() throws Exception {
		/*** Given ***/
		MvcResult result = mockMvc.perform(get("/user/loginView")).andReturn();
		ModelAndView mav = result.getModelAndView();
		/*** When ***/

		/*** Then ***/
		// viewName

		assertEquals("login/login", mav.getViewName());

	}

	@Test
	public void loginProcessSuccessTest() throws Exception {
		MvcResult result = mockMvc
				.perform(post("/user/loginProcess").param("userId", "brown").param("password", "brownpass")).andReturn();

		ModelAndView mav = result.getModelAndView();

		assertEquals("main", mav.getViewName());

	}

	@Test
	public void loginProcessFailTest() throws Exception {
		MvcResult result = mockMvc
				.perform(post("/user/loginProcess").param("userId", "brown10").param("password", "brownpass10")).andReturn();

		ModelAndView mav = result.getModelAndView();
		assertEquals("login/login", mav.getViewName());

	}

}
