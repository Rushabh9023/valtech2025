package com.valtech.training.registerservice.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.UserVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private SubscriptionRepo subRepo;
	
	@Override
	public UserVO addUserToSubscription(UserVO uvo,long sub) {
		Subscription sc = subRepo.getReferenceById(sub);
		User user = uvo.to(sc);
		user = userRepo.save(user);
		return UserVO.from(user);
	}
	
	@Override
	public UserVO getUserById(long id) {
		return UserVO.from(userRepo.getReferenceById(id));
	}
	
	@Override
	public UserVO signUp(UserVO vo) {
		Subscription sc =new Subscription();
		sc.setAmount(560);
		sc.setSubscriptionStart(LocalDate.now());
		sc.setSubscriptionEnd(LocalDate.now().plusYears(1));
		sc = subRepo.save(sc);
		User user = vo.to(sc);
		user = userRepo.save(user);
		return UserVO.from(user);
		
	}
	
	@Override
	public List<UserVO> getAllUsers() {
	List<User> users =	userRepo.findAll();
		return users.stream().map(u->UserVO.from(u)).collect(Collectors.toList());
	}

	@Override
	public void deleteUserFromSubscription(long userId) {
		User user = userRepo.getReferenceById(userId);
		Subscription sub = user.getSubscription();
		sub.removeUser(user);
		userRepo.deleteById(userId);
	}
	
}
