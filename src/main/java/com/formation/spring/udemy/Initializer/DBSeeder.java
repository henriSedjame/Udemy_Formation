package com.formation.spring.udemy.Initializer;

import com.formation.spring.udemy.Model.Author;
import com.formation.spring.udemy.Model.Book;
import com.formation.spring.udemy.Repository.AuthorRepository;
import com.formation.spring.udemy.Repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Project udemy
 * @Author Henri Joel SEDJAME
 * @Date 05/07/2018
 */

@Component
public class DBSeeder implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;

  public DBSeeder(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.initPojo();
  }

  public void initPojo(){

    Book book1 = Book.builder()
                    .isbn("123")
                    .publisher("Amazon")
                    .build();

    Book book2 = Book.builder()
                    .isbn("654")
                    .publisher("Ocean")
                    .build();

    Book book3 = Book.builder()
                    .isbn("759")
                    .publisher("L'harmattan")
                    .build();


    Author author1 = Author.builder()
                          .firstname("Joel")
                          .lastname("Sedjame")
                          .books(new HashSet<>())
                          .build();

    Author author2 = Author.builder()
                          .firstname("Chloe")
                          .lastname("Le Nain")
                          .books(new HashSet<>())
                          .build();

    Assert.notNull(author1,"Author1 est null");
    Assert.notNull(author1.getBooks(),"Author1n'a pas de liste de livres");
    Assert.isTrue(author1.getFirstname().equals("Joel"),"Prenom incorrect");
    Assert.isTrue(author1.getLastname().equals("Sedjame"),"Nom incorrect");

    author1.getBooks().add(book1);

    Assert.isTrue( !author1.getBooks().isEmpty(), "La liste de livres est imcomplete");


    Assert.notNull(author2,"author2 est null");

    Assert.notNull(author1,"Author1 est null");
    Assert.notNull(author2.getBooks(),"Author1n'a pas de liste de livres");
    Assert.isTrue(author2.getFirstname().equals("Chloe"),"Prenom incorrect");
    Assert.isTrue(author2.getLastname().equals("Le Nain"),"Nom incorrect");

    author2.getBooks().add(book2);
    author2.getBooks().add(book3);

    Assert.isTrue(author2.getBooks().size() == 2, "Manque des livres pour author2");

    this.authorRepository.saveAll(Arrays.asList(author1, author2));
  }
}
