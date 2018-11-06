package kr.or.ddit.mvc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.sun.org.apache.regexp.internal.REUtil;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.file.util.FileUtil;

//@ModelAtrribute에 의해 저장된 속성이 있을 경우
// 재요청시 @ModelAttribute가 적용된 메서드를 실행하지않고
// 세션에 저장하여 값을 재활용(잘 변경되지 않는 값을 저장할 경우 메서드가 매번 호출되는 과부하를 줄일 수 있다.)
@SessionAttributes("rangers")
@Controller
public class MvcController {
	
	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	private Logger logger = LoggerFactory.getLogger(MvcController.class);
	
	//@RequsetMapping이 붙은 메소드가 실행되기 전에 먼저 실행됨
	//해당 컨트롤러에서 공통적으로 사용될 속성이 있을 경우
	//중복을 피하기 위해 @ModelAttribute 어노테이션을 적용한
	//메소드를 통해 코드 중복을 막을 수 있음
	//모델 객체명을 설정해준다.
	//실행될때마다 같이 수행이된다 => 부하가 큰 것을 설정하면 안좋겠지..?
	@ModelAttribute(value="rangers")
	public List<String> setUp(Model model) {
		
		logger.debug("{}","setup");
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
//		model.addAttribute("rangers",rangers);
		return rangers;
	}
	
	@RequestMapping("/mvc/view")
	public String mvcView(@ModelAttribute("rangers")List<String> rangers) {
		for(String ranger : rangers) {
//			logger.debug("ranger : {}" , ranger);
		}
		rangers.add("james");
		return "mvc/view";
	}
	
	
	//@PathVariable : 요청 url의 일부를 메소드 인자로 쉽게 받을 수 있는 어노테이션
	//http://localhost:8081/mvc/central :  central
	//http://localhost:8081/mvc/left	   : left
	@RequestMapping("/mvc/{libcd}")
	public String pathvariavle(@PathVariable("libcd") String libcd) {
		
		logger.debug("libcd: {}", libcd);
		return "mvc/view";
	}
	
	
	//fileUploadTest를 위한 view(get)
	@RequestMapping(value="/mvc/fileUpload", method= {RequestMethod.GET})
	public String fileUpload(){
		return "mvc/fileUploadView";
	}

	//fileUploadTest를 위한 view(get)
	@RequestMapping(value="/mvc/fileUpload", method= {RequestMethod.POST})		//@RequestParam : 파라미터를 받을때 annotation을 사용한다.
	public String fileUploadView(@RequestPart("uploadFile") MultipartFile part, @RequestParam("userId") String userId){
		
		logger.debug("userId {}" , userId);
		logger.debug("partSize : {}" ,part.getSize());
		logger.debug("OriginalFilename : {}" ,part.getOriginalFilename());
		
		//1.File 객체 생성(경로 + 파일명==>파일명 충돌방지를 위해서 유니크한 임의의 파일명을 생성 )
		//
		
		String path = "D:\\A_TeachingMaterial\\6.JspSrpgin\\upload";
		String originalFileName = part.getOriginalFilename(); 	//사용자가 업로드한 실제 파일명
		String fileExt = FileUtil.getFileExt(originalFileName);
		String fileName = UUID.randomUUID().toString();		//충돌방지를 위한 임의의 파일명
		File file = new File(path + File.separator + fileName);
		
		FileVo fileVo = new FileVo();
		fileVo.setFile_name(fileName + fileExt);
		fileVo.setFile_path(path);
		fileVo.setOrg_file_name(originalFileName);
		fileVo.setFile_ext(fileExt);
		logger.debug("fileVo :  {}",fileVo);
		
		//FileUtil.getFileExt(String FileName);
		//확장자가 있을 경우 .을 포함한 확장가 값을 리턴 
		//확장자가 없을 경우 ""whitespace 리턴
		//테스트 값 : sally.png => .png
		//테스트 값 : sally => ""
		
		try {
			//첨부파일이 없을 시 null발생
			//첨부파일의 사이즈가 0 : 첨부파일이 없다
			if(part.getSize() > 0) {
				//정해진 path에 업로드
				part.transferTo(file);
				//데이터베이스에 첨부파일 정보 저장
				//1. fileService
				//2. 로직 호출
				fileService.insertFile(fileVo);
			}
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "mvc/fileUploadView";
	}
	
	//fileUpload(파일 전송)을 처리하기 위한 controller method(post)
	
	
	
}
