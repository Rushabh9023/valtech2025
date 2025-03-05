package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Publisher;
import com.valtech.training.first.repos.PublisherRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PublisherServiceImpl implements PublisherService {
	
	@Autowired
	private PublisherRepo publisherRepo;
	
	@Override
	public Publisher savePublisher(Publisher publisher) {
		return publisherRepo.save(publisher);
	}
	
	@Override
	public Publisher updatePublisher(Publisher publisher) {
		return publisherRepo.save(publisher);
	}
	
	@Override
	public void deletePublisher(Publisher publisher) {
		publisherRepo.delete(publisher);
	}
	
	@Override
	public Publisher getPublisher(int id) {
		return publisherRepo.getReferenceById(id);
	}
	
	@Override
	public List<Publisher> getAllPublishers(){
		return publisherRepo.findAll();
	}
	
	@Override
	public long count() {
		return publisherRepo.count();
	}

}
