package com.valtech.assignment.ordermanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.assignment.ordermanagement.entities.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{

}
