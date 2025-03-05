package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.repos.BookRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}
	
	@Override
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	@Override
	public void deleteBook(Book book) {
		bookRepo.delete(book);
	}
	
	@Override
	public Book getBook(int id) {
		return bookRepo.getReferenceById(id);
	}
	
	@Override
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	@Override
	public long count() {
		return bookRepo.count();
	}

	@Override
	public List<Book> findAllByYearBetween(int min, int max) {
		return bookRepo.findAllByYearBetween(min, max);
	}

	@Override
	public List<Book> findAllByPriceGreaterThan(int price) {
		return bookRepo.findAllByPriceGreaterThan(price);
	}

	@Override
	public List<Book> findAllByAuthorsId(int authorId) {
		return bookRepo.findAllByAuthorsId(authorId);
	}

	@Override
	public List<Integer> findAllPriceByAuthorsId(int authorId) {
		return bookRepo.findAllPriceByAuthorsId(authorId);
	}

	@Override
	public List<BookInfoDTO> getBookInfoByAuthor(int id) {
		return bookRepo.getBookInfoByAuthor(id);
	}

}
