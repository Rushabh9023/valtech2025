package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Author;

public interface AuthorService {

	long countAllAuthors();

	List<Author> getAllAuthors();

}