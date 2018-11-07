package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVO;

@Service
public class UserService implements UserServiceInf {
//	UserDao userDao = new UserDao();
	@Resource(name="userDao")
	private UserDaoInf userDao /*= new UserDao()*/;

	@Override
	public List<UserVo> selectUserAll() {
		return userDao.selectUserAll();
	}

	@Override
	public UserVo selectUser(String userid) {
		return userDao.selectUser(userid);
	}

	@Override
	public UserVo selectUser(UserVo UserVo) {
		return userDao.selectUser(UserVo);
	}

	/**
	 * Method : selectUserPageList 작성자 : 1003yd 변경이력 :
	 * 
	 * @param page
	 * @return Method 설명 : 사용자 페이징 조회
	 *//*
		 * public Map<String, Object> selectUserPageList(PageVO page) {
		 * 
		 * //페이지에 해당하는 유저 리스트(1~10건사이) List<UserVo> userList =
		 * userDao.selectUserPageList(page);
		 * 
		 * //페이지 내비게이션을 위한 전체 유저 리스트 조회 int totalUserCnt = userDao.getUserCnt();
		 * 
		 * //결과를 담는 map Map<String, Object> resultMap = new HashMap<String, Object>();
		 * resultMap.put("userList", userList); resultMap.put("pageCount",
		 * (int)Math.ceil((double)totalUserCnt/page.getPageSize()));
		 * 
		 * return resultMap; }
		 */

	@Override
	public int insertUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userDao.insertUser(userVo);
	}

	@Override
	public int updateUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userDao.updateUser(userVo);
	}

	@Override
	public Map<String, Object> selectUserPageList(PageVO page) {
		// TODO Auto-generated method stub
		// 페이지에 해당하는 유저 리스트(1~10건사이)
		List<UserVo> userList = userDao.selectUserPageList(page);

		// 페이지 내비게이션을 위한 전체 유저 리스트 조회
		int totalUserCnt = userDao.getUserCnt();

		// 결과를 담는 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageUserList", userList);
		resultMap.put("pageCnt", (int) Math.ceil((double) totalUserCnt / page.getPageSize()));

		return resultMap;

	}

}
