package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.confing.db.SqlFactoryBuilder;
import kr.or.ddit.prod.model.ProdAllVo;
import kr.or.ddit.prod.model.ProdDetailVo;
import kr.or.ddit.util.model.PageVO;

@Repository
public class ProdListDao implements ProdListDaoInf {

	@Override
	public List<ProdAllVo> prodAllList(PageVO page) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<ProdAllVo> prodList = session.selectList("prod.prodAllList", page);
		session.rollback();
		session.commit();
		session.close();
		
		return prodList;
	}

	@Override
	public ProdDetailVo prodDetailList(String prodId) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		ProdDetailVo prodDetailList = session.selectOne("prod.prodDetailList", prodId);
		session.rollback();
		session.commit();
		session.close();
		
		return prodDetailList;
	}

	@Override
	public int prodCnt() {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int cnt = session.selectOne("prod.prodCnt");
		
		return cnt;
	}

}
