package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;


public interface BookService {

	Book saveBook(Book book);

	Book updateBook(Book book);

	void deleteBook(Book book);

	Book getBook(int id);

	List<Book> getAllBooks();

	long count();

    List<Book> findAllByYearBetween(int min, int max);
	
	List<Book> findAllByPriceGreaterThan(int price);
	
	List<Book> findAllByAuthorsId(int authorId);
	
	List<Integer> findAllPriceByAuthorsId(int authorId);
	
	List<BookInfoDTO> getBookInfoByAuthor(int id);


}