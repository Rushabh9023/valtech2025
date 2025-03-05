package com.valtech.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.first.services.AuthorService;
import com.valtech.training.first.services.BookService;
import com.valtech.training.first.services.PublisherService;

@SpringBootTest
public class LibraryApplicationTests {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private PublisherService publisherService;
	
	@Autowired
	private AuthorService authorService;
	
	@Test
	void testBookService() {
		assertEquals(6, bookService.getAllBooks().size());
		assertEquals(4, bookService.findAllByYearBetween(2000, 2006).size());
		assertEquals(3, bookService.findAllByPriceGreaterThan(100).size());
		assertEquals(2, bookService.findAllByAuthorsId(1).size());
		assertEquals(2, bookService.findAllPriceByAuthorsId(1).size());
		System.out.println(bookService.findAllPriceByAuthorsId(1));
		System.err.println(bookService.getBookInfoByAuthor(1));
		
	}
	
	@Test
	void testPublisherService() {
		assertEquals(3, publisherService.getAllPublishers().size());
	}
	
	@Test
	void testAuthorService() {
		assertEquals(6, authorService.getAllAuthors().size());
	}
}
