package com.valtech.training.registerservice.vos;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record UserVO(long id,String name,int age,String mobile,String email,boolean kid,long subscriptionId) {

	public static UserVO from(User u) {
		return new UserVO(u.getId(), u.getName(), u.getAge(), u.getMobile(), u.getEmail(),u.isKid(),u.getSubscription().getId());
	}
	
	public User to(Subscription sub) {
		User user = new User(name, age, mobile, email, kid) ;
				user.setSubscription(sub);
		
		return user;
	}
}
