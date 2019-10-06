package com.example.bookstoredatabase.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstoredatabase.bookstore.domain.Book;
import com.example.bookstoredatabase.bookstore.domain.BookRepository;
import com.example.bookstoredatabase.bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	
    @Autowired
    private BookRepository repository;

    @Test
    public void findByAuthorAndTitle() {
        List<Book> books = repository.findByAuthor("Aleksanteri");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Jaskan talvi");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Alexander", "IM the best", "1992", new Category("Kauhu"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    
  
    
    @Test
    public void DeletingBookById() {
    	List<Book> books = repository.findByAuthor("Aleksanteri");
        repository.deleteById(books.get(0).getId());
        assertThat(repository.count()).isEqualTo(1);
    }
 
    @Test
    public void DeletingAllBooks() {
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }
    


}
