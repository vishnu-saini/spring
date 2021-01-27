package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistance.Book;
import com.example.demo.service.BookService;

@RestController
// @RestController=@Controller + @ResponseBody
public class BookResources {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/api/book", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Book>> getAllBooks() {
		Collection<Book> greetings = bookService.getAllBooks();
		return new ResponseEntity<Collection<Book>>(greetings, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/book/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> getAnBook(@PathVariable Integer id) {
		Book book = bookService.getBookById(id);
		if (book == null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/book", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book savedBook = bookService.addBook(book);
		return new ResponseEntity<Book>(savedBook, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api/book/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> updateBook(@PathVariable Integer id,
			@RequestBody Book book) {

		bookService.updateBook(book);

		return new ResponseEntity<Book>(HttpStatus.OK);
	}

	@RequestMapping(value = "/api/book/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id)
			throws Exception {

		bookService.removeBook(id);

		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}

}