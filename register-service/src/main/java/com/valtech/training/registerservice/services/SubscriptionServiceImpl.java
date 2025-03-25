package com.valtech.training.registerservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepo subRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public SubscriptionVO addSubscription(SubscriptionVO svo) {
		List<User> users = userRepo.findAll();
		return SubscriptionVO.from(subRepo.save(svo.to(users)));
	}
	
	@Override
	public SubscriptionVO getSubscriptionById(long subId) {
		return SubscriptionVO.from(subRepo.getReferenceById(subId));
	}
	
	@Override
	public List<SubscriptionVO> getAllSubscription(){
		return subRepo.findAll().stream().map(s->SubscriptionVO.from(s)).collect(Collectors.toList());
	}

}
