package com.valtech.training.registerservice.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record SubscriptionVO(long id, int amount,String subscriptionStart,String subscriptionEnd,List<Long> userIds) {
	
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public static SubscriptionVO from(Subscription sub) {
		String startDate = sub.getSubscriptionStart().format(FORMATTER);
		String endDate = sub.getSubscriptionEnd().format(FORMATTER);
		
		List<Long> userIds =  sub.getUsers().stream().map(u -> u.getId()).collect(Collectors.toList());
		
		return new SubscriptionVO(sub.getId(), sub.getAmount(), startDate, endDate,userIds);
		
	}
	
	public Subscription to(List<User> users) {
		
		LocalDate startDate = LocalDate.parse(subscriptionStart,FORMATTER);
		LocalDate endDate = LocalDate.parse(subscriptionEnd,FORMATTER);
		
		Subscription sub = new Subscription(amount, startDate, endDate);
		
		sub.setUsers(users);
		
		return sub;
	}

}
