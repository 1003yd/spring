package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVO;

public interface UserDaoInf {

	public List<UserVo> selectUserAll();

	public UserVo selectUser(String userid);

	public UserVo selectUser(UserVo UserVo);
	
	/**  
	* Method   : getUserCnt 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @return  
	* Method 설명 : 사용자 전체 건수 조회 
	*/
	int getUserCnt();
	
	/**  
	* Method   : insertUser 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param UserVo
	* @return  
	* Method 설명 : 사용자 등록  
	*/
	public int insertUser(UserVo UserVo);
	
	
	/**  
	* Method   : deleteUser 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param userId
	* @return  
	* Method 설명 :  사용자 삭제
	*/
	public int deleteUser(String userId);
	
	/**  
	* Method   : updateUser 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param UserVo
	* @return  
	* Method 설명 :  사용자 정보 수정
	*/
	public int updateUser(UserVo userVo);
	
	/**  
	* Method   : selectUserPageList 
	* 작성자 : 1003yd 
	* 변경이력 :  
	* @param page
	* @return  
	* Method 설명 :  사용자 페이징 조회
	*/
	public List<UserVo> selectUserPageList(PageVO page);

	
	
	

}
