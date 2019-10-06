package com.example.bookstoredatabase.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstoredatabase.bookstore.domain.User;
import com.example.bookstoredatabase.bookstore.domain.UserRepository;




@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	  @Autowired
	    private UserRepository  repository;

	    @Test
	    public void findByUsernameAndEmail() {
	       User user = repository.findByUsername("admin");
	        
	        assertThat(user).isNotNull();
	       
	    }
}
