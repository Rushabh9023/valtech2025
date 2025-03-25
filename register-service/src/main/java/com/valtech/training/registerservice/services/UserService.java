package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.UserVO;

public interface UserService {

	UserVO addUserToSubscription(UserVO uvo,long sub);

	UserVO getUserById(long id);

	UserVO signUp(UserVO vo);

	List<UserVO> getAllUsers();

	void deleteUserFromSubscription(long userId);

}