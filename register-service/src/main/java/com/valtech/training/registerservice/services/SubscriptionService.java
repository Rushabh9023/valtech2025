package com.valtech.training.registerservice.services;

import java.util.List;

import com.valtech.training.registerservice.vos.SubscriptionVO;

public interface SubscriptionService {

	SubscriptionVO addSubscription(SubscriptionVO svo);

	SubscriptionVO getSubscriptionById(long subId);

	List<SubscriptionVO> getAllSubscription();

}