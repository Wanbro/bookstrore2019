package com.example.bookstoredatabase.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstoredatabase.bookstore.domain.Book;
import com.example.bookstoredatabase.bookstore.domain.BookRepository;
import com.example.bookstoredatabase.bookstore.domain.Category;
import com.example.bookstoredatabase.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {

			crepository.save(new Category("Kauhu"));
			crepository.save(new Category("Romantiikka"));
			crepository.save(new Category("Kauno"));

			repository.save(new Book("Aleksanteri", "Jaskan talvi", "1992", crepository.findByName("Kauhu").get(0)));
			repository.save(new Book("Matti", "Maalaan taivasta", "1993", crepository.findByName("Kauno").get(0)));

		};
	}
}
