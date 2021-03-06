package com.formation.spring.udemy.Initializer;

import com.formation.spring.udemy.Model.Author;
import com.formation.spring.udemy.Model.Book;
import com.formation.spring.udemy.Model.Publisher;
import com.formation.spring.udemy.Repository.AuthorRepository;
import com.formation.spring.udemy.Utils.PojoQueryingPredicates.AuthorPredicator;
import com.querydsl.core.types.Predicate;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Project udemy
 * @Author Henri Joel SEDJAME
 * @Date 05/07/2018
 */

@SuppressWarnings("ALL")
@Component
@Log4j2
public class DBSeeder implements ApplicationListener<ContextRefreshedEvent> {

  private final AuthorRepository authorRepository;
  private AuthorPredicator authorPredicator;

  public DBSeeder(AuthorRepository authorRepository, AuthorPredicator authorPredicator) {
    this.authorRepository = authorRepository;
    this.authorPredicator = authorPredicator;
  }

  @SuppressWarnings("NullableProblems")
  @Override
  public void onApplicationEvent(@SuppressWarnings("NullableProblems") ContextRefreshedEvent contextRefreshedEvent) {
    this.initPojo();
  }

  private void initPojo() {

    Publisher pub1 = Publisher.builder()
      .name("Amazon")
      .adress(null)
      .build();

    Publisher pub2 = Publisher.builder()
      .name("Ocean")
      .adress(null)
      .build();

    Publisher pub3 = Publisher.builder()
      .name("L'harmattan")
      .adress(null)
      .build();

    Publisher[] pubs = {pub1, pub2, pub3};
    Assert.noNullElements(pubs, "L'un des publishers est null");

    Book book1 = Book.builder()
      .isbn("123")
      .publisher(pub1)
      .build();

    Book book2 = Book.builder()
      .isbn("654")
      .publisher(pub2)
      .build();

    Book book3 = Book.builder()
      .isbn("759")
      .publisher(pub3)
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

    Assert.notNull(author1, "Author1 est null");
    Assert.notNull(author1.getBooks(), "Author1n'a pas de liste de livres");
    Assert.isTrue(author1.getFirstname().equals("Joel"), "Prenom incorrect");
    Assert.isTrue(author1.getLastname().equals("Sedjame"), "Nom incorrect");

    author1.getBooks().add(book1);

    Assert.isTrue(!author1.getBooks().isEmpty(), "La liste de livres est imcomplete");


    Assert.notNull(author2, "author2 est null");

    Assert.notNull(author1, "Author1 est null");
    Assert.notNull(author2.getBooks(), "Author1n'a pas de liste de livres");
    Assert.isTrue(author2.getFirstname().equals("Chloe"), "Prenom incorrect");
    Assert.isTrue(author2.getLastname().equals("Le Nain"), "Nom incorrect");

    author2.getBooks().add(book2);
    author2.getBooks().add(book3);

    Assert.isTrue(author2.getBooks().size() == 2, "Manque des livres pour author2");
    Assert.notNull(authorRepository, "authorRepository est nul");
    Assert.notNull(authorPredicator, "authorPredicator est nul");

    this.authorRepository.saveAll(Arrays.asList(author1, author2));
    Predicate predicate = this.authorPredicator.named("Sedjame");
    List<Author> authors = (List<Author>) this.authorRepository.findAll(predicate);
    Assert.isTrue(authors.size() == 1, "Erreur dans le findAll");


  }
}
