package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.persistance.Book;
import com.example.demo.persistance.BookRepository;

@SpringBootApplication
public class Bootdemoex1Application  implements CommandLineRunner{

	@Autowired
	private BookRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(Bootdemoex1Application.class, args);
		
		/*ApplicationContext ctx = SpringApplication.run(Bootdemoex1Application.class, args);

	    System.out.println("Let's inspect the beans provided by Spring Boot:");

	    String[] beanNames = ctx.getBeanDefinitionNames();
	    Arrays.sort(beanNames);
	    for (String beanName : beanNames) {
	        System.out.println(beanName);
	    }*/
	    
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(121, "ABC111", "head fist", "raj", 300.99));
		books.add(new Book(21, "XXXX111", "head last", "raj", 300.99));
		System.out.println("application started");
		repo.save(books);
	}
}
