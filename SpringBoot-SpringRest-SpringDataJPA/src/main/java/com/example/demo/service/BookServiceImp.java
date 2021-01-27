package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.persistance.Book;

//@Service
public class BookServiceImp implements BookService {

	private static Map<Integer, Book> books = new HashMap<Integer, Book>();
	static {
		books.put(1, new Book(121, "ABC123", "head first", "katthy", 500.00));
		books.put(1, new Book(11, "ABU123", "head last", "amit", 400.00));
	}

	@Override
	public List<Book> getAllBooks() {
		return new ArrayList<Book>(books.values());
	}

	@Override
	public Book getBookById(int bookId) {
		return books.get(bookId);
	}

	@Override
	public Book addBook(Book book) {
		book.setId(books.size() + 1);
		books.put(book.getId(), book);
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		if (book.getId() <= 0)
			return null;
		else
			books.put(book.getId(), book);
		return book;
	}

	@Override
	public Book removeBook(int bookId) {
		return books.remove(bookId);
	}

}
