package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.ProdAllVo;
import kr.or.ddit.prod.model.ProdDetailVo;
import kr.or.ddit.util.model.PageVO;

public interface ProdListDaoInf {
	
	/**  
	* Method   : prodAllList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 :  제품 전체 리스트 조회
	*/
	public List<ProdAllVo> prodAllList(PageVO page);
	
	
	/**  
	* Method   : prodDetailList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 :  제품 상세 리스트 조회
	*/
	public ProdDetailVo prodDetailList(String prodId);
	
	/**  
	* Method   : prodCnt 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 :  제품 전체 리스트 수 조회
	*/
	public int prodCnt();
}
