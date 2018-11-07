package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.model.ProdAllVo;
import kr.or.ddit.prod.model.ProdDetailVo;
import kr.or.ddit.util.model.PageVO;

public interface ProdServiceInf {

	/**  
	* Method   : prodAllList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 :  제품 전체 리스트 조회
	*/
	public Map<String, Object> prodAllList(PageVO page);
	
	
	/**  
	* Method   : prodDetailList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 :  제품 상세 리스트 조회
	*/
	public ProdDetailVo prodDetailList(String prodId);
}
