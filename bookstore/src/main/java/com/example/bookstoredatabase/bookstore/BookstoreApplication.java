package com.example.bookstoredatabase.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstoredatabase.bookstore.domain.Book;
import com.example.bookstoredatabase.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book a1 = new Book("Jaska", "Jaskan talvi", "1988");
			Book a2 = new Book("ALE", "Elämä on tuskaa", "1988");
			Book a3 = new Book("Pertti", "Olen paras", "1988");

			repository.save(a1);
			repository.save(a2);
			repository.save(a3);

		};
	}
}
