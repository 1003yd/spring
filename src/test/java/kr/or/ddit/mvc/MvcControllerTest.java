package kr.or.ddit.mvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.hello.HelloControllerTest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:kr/or/ddit/config/spring/servlet-context.xml"
									,"classpath:kr/or/ddit/config/spring/root-context.xml"})

@WebAppConfiguration
public class MvcControllerTest {
	
	  private Logger logger = LoggerFactory.getLogger(MvcControllerTest.class); 
	   
	   @Autowired
	   private WebApplicationContext ctx;   // spring ioc 컨테이너
	   
	   private MockMvc mockMvc;         // dispatcher servlet(front controller역할)

	   @Before
	   public void serup() {
	      mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	   }
	   
	   @Test
	   public void MvcControllerTest() throws Exception {
	      /***Given***/
	      
	      
	      /***When***/
	      MvcResult mvcResult =  mockMvc.perform(get("/mvc/view")).andReturn();
	      ModelAndView mav = mvcResult.getModelAndView();
	      String viewName = mav.getViewName();
	      
	      List<String> rangers = (List<String>) mav.getModel().get("rangers");
	      
	      
	      /***Then***/
	      assertEquals("mvc/view", viewName);
	      assertEquals(4, rangers.size());
	   }
	   
	   @Test
	   public void fileUploadViewTest() throws Exception {
		   MvcResult mvcResult =  mockMvc.perform(get("/mvc/fileUpload")).andReturn();
		   
		   ModelAndView mav = mvcResult.getModelAndView();
		   
		   assertEquals("mvc/fileUploadView", mav.getViewName());
	   }
}
