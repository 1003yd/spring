package kr.or.ddit.prod.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.model.ProdAllVo;
import kr.or.ddit.prod.model.ProdDetailVo;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.util.model.PageVO;

@RequestMapping("/prod")
@Controller
public class ProdController {
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	@RequestMapping("/prodList")
	public String prodList(PageVO pageVo, Model model) {
		
		Map<String, Object> prodMap= prodService.prodAllList(pageVo);
		List<ProdAllVo> prodAllIst = (List<ProdAllVo>) prodMap.get("prodList");
		model.addAllAttributes(prodMap);
		
		return "/prod/prodList";
		
	}
	
	@RequestMapping("/prodDetail")
	public String prodDetail(@RequestParam("prodId") String prodId, Model model) {
		 ProdDetailVo prodDetail = prodService.prodDetailList(prodId);
		 
		 model.addAttribute("prodVo", prodDetail);
		
		return "/prod/prodDetail";
	}

}
