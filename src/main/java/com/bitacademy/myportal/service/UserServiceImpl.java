package com.bitacademy.myportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.myportal.exception.UserDaoException;
import com.bitacademy.myportal.repository.UserDao;
import com.bitacademy.myportal.repository.UserVo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDaoImpl;
	
	@Override
	public boolean join(UserVo vo) throws UserDaoException {
		int insertedCount = userDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

	@Override
	public UserVo getUser(String email, String password) {
		UserVo userVo = userDaoImpl.selectUser(email, password);
		return userVo;
	}

	@Override
	public UserVo getUser(String email) {
		UserVo userVo = userDaoImpl.selectUser(email);
		return userVo;
	}
	
	// 회원정보 수정용 -> userVo 객체에 담긴 데이터가 넘어와야 수정 가능함
	@Override
	public int updateUser(UserVo vo) {
		int updatedCount = userDaoImpl.insert(vo);
		// return 1 == updatedCount; --> 타입과 반환값이 틀려 에러
		return updatedCount;
	}
	

}
