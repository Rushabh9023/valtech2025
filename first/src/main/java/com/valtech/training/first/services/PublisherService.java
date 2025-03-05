package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Publisher;

public interface PublisherService {

	Publisher savePublisher(Publisher publisher);

	Publisher updatePublisher(Publisher publisher);

	void deletePublisher(Publisher publisher);

	Publisher getPublisher(int id);

	List<Publisher> getAllPublishers();

	long count();

}