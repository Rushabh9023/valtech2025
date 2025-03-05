package com.valtech.training.first.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.valtech.training.first.entities.Publisher;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Integer>{

}
