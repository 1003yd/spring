package kr.or.ddit.main;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.ControllerTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/servlet-context.xml","classpath:kr/or/ddit/config/spring/root-context.xml"})
@WebAppConfiguration
public class MainTest extends ControllerTestConfig {
	
	private Logger logger = LoggerFactory.getLogger(MainTest.class);
	

	@Test
	public void mainTest() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(get("/main")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		assertEquals("main", viewName);
	}

}
