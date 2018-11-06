package kr.or.ddit.file.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.confing.db.SqlFactoryBuilder;
import kr.or.ddit.file.model.FileVo;

//spring bean으로 등록 :@Repository(이름을 안붙이면 class 명에서 앞글자만 소문자로  변경한 텍스트가 spring bean이름)
@Repository //()안에 이름이 설정되어있지 않으므로 fileDao라고 인식한다.
public class FileDao implements FileDaoInf{
	
	private SqlSessionFactory sessionFactory;
	
	public FileDao() {
		// TODO Auto-generated constructor stub
		sessionFactory = SqlFactoryBuilder.getSqlSessionFactory();
	}
	
	/**  
	* Method   : insertFile 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param fileVo
	* @return  
	* Method 설명 :  파일 정보 저장
	*/
	@Override
	public int insertFile(FileVo fileVo) {
		// TODO Auto-generated method stub
		SqlSession session = sessionFactory.openSession();

		//sql호출
		int insertCnt = session.insert("file.insertFile", fileVo);
		
		//트랜잭션  commit, session close
		session.commit();
		session.close();
		return insertCnt;
	}
	
	

}
