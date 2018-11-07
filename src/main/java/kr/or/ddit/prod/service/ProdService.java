package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.prod.dao.ProdListDao;
import kr.or.ddit.prod.dao.ProdListDaoInf;
import kr.or.ddit.prod.model.ProdAllVo;
import kr.or.ddit.prod.model.ProdDetailVo;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.util.model.PageVO;

@Service
public class ProdService implements ProdServiceInf {
//	private ProdListDaoInf prodDao = new ProdListDao();
	//아래의 name 정의는 실제 dao에서 사용한 @Repository에서 정의한 이름과 같아야한다.
	// 만약 @Repostiroy에서 이름을 정의하지않았다면 해당 파일명 앞글자를 소문자로 변환한 이름이다.
	@Resource(name="prodListDao")
	private ProdListDaoInf prodDao;
	
	@Override
	public Map<String, Object> prodAllList(PageVO page) {
		// TODO Auto-generated method stub
		List<ProdAllVo> prodAllList = prodDao.prodAllList(page);
		
		int totalCnt = prodDao.prodCnt();
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("prodList", prodAllList);
		result.put("pageCnt", (int)Math.ceil((double)totalCnt/page.getPageSize()));
		
		return result; 
	}

	@Override
	public ProdDetailVo prodDetailList(String prodId) {
		// TODO Auto-generated method stub
		return prodDao.prodDetailList(prodId);
	}

}
