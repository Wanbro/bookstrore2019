package com.example.bookstoredatabase.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.example.bookstoredatabase.bookstore.domain.Category;
import com.example.bookstoredatabase.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	
	
    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByName() {
     List<Category> categories = repository.findByName("Kauhu");
        
        assertThat(categories.get(0).getName()).isEqualTo("Kauhu");
    }
}
