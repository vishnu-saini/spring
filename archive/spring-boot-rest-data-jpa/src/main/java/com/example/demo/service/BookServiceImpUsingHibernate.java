package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.persistance.Book;
import com.example.demo.persistance.BookRepository;

@Service
@Transactional
public class BookServiceImpUsingHibernate implements BookService {

	@Autowired
	private BookRepository bookRepo;
	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Book getBookById(int bookId) {
		return bookRepo.getOne(bookId);
	}

	@Override
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Book removeBook(int bookId) {
		Book book = bookRepo.getOne(bookId);
		bookRepo.delete(bookId);
		return book;
	}

}
