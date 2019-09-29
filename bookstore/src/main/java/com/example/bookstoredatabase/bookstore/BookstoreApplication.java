package com.example.bookstoredatabase.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstoredatabase.bookstore.domain.Book;
import com.example.bookstoredatabase.bookstore.domain.BookRepository;
import com.example.bookstoredatabase.bookstore.domain.Category;
import com.example.bookstoredatabase.bookstore.domain.CategoryRepository;
import com.example.bookstoredatabase.bookstore.domain.User;
import com.example.bookstoredatabase.bookstore.domain.UserRepository;




@SpringBootApplication


public class BookstoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {

			crepository.save(new Category("Kauhu"));
			crepository.save(new Category("Romantiikka"));
			crepository.save(new Category("Kauno"));

			repository.save(new Book("Aleksanteri", "Jaskan talvi", "1992", crepository.findByName("Kauhu").get(0)));
			repository.save(new Book("Matti", "Maalaan taivasta", "1993", crepository.findByName("Kauno").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@gmail.com", "USER");
			//password for user is user
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@gmail.com" , "ADMIN");
			//password for admin is admin, for some reason i couldnt use my own hashes for neither of these?
			urepository.save(user1);
			urepository.save(user2);
			
		};
	}
}
