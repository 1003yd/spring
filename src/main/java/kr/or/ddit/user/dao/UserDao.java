package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.confing.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVO;

@Repository
public class UserDao implements UserDaoInf {
	public List<UserVo> selectUserAll(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		//selectOne : 데이터가 한건일 때
		//selectList : 여러건의 데이터를 조회
		//메소드 인자 : 문자열 = namespace(모듈명).queryId
		List<UserVo> userList = session.selectList("user.selectUserAll");
		int cntList = userList.size();
		System.out.println(cntList);
		session.rollback();
		session.commit();
		session.close();

		return userList;
	}

	public UserVo selectUser(String userid){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		UserVo UserVo = (UserVo)session.selectOne("user.selectUser", userid);
		session.rollback();
		session.commit();
		session.close();
		
		return UserVo;
	}


	public UserVo selectUser(UserVo UserVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		UserVo UserVoList = session.selectOne("user.selectUserByVo", UserVo);
		session.rollback();
		session.commit();
		session.close();
		
		return UserVoList;

	}
	
	@Override
	public List<UserVo> selectUserPageList(PageVO page){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<UserVo> pageUserList = session.selectList("user.selectUsrPageList", page);
		
		for(UserVo UserVo : pageUserList){
			System.out.println(UserVo.getUserId());
		}
		session.rollback();
		session.commit();
		session.close();
		
		return pageUserList;
	}
	
	/**  
	* Method   : getUserCnt 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 : 사용자 전체 건수 조회 
	*/
	@Override
	public int getUserCnt() {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int cntUserList = session.selectOne("user.getUserCnt");
		
		return cntUserList;
	}
	
	/**  
	* Method   : insertUser 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param UserVo
	* @return  
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(UserVo UserVo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertCnt= session.insert("user.inserUser",UserVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}

	@Override
	public int deleteUser(String userId) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int deleteCnt= session.delete("user.deleteUser",userId);
		
		//자동커밋이 안되기 때문에 db상의 데이터가 변경 시 commit을 반드시 해야한다.
		session.commit();
		session.close();
		
		return deleteCnt;
	}

	/**  
	* Method   : updateUser 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param UserVo
	* @return  
	* Method 설명 : 사용자 정보 수정 
	*/
	@Override
	public int updateUser(UserVo userVo) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateUserCnt = session.update("user.updateUser", userVo);
		session.commit();
		session.close();
		
		return updateUserCnt;
	}
/*
	@Override
	public UserVo selectUser(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
