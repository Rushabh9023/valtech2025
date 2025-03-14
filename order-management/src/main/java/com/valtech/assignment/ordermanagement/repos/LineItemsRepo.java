package com.valtech.assignment.ordermanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.assignment.ordermanagement.entities.LineItems;

public interface LineItemsRepo extends JpaRepository<LineItems, Integer>{

}
