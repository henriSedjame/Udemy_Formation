package com.formation.spring.udemy.Model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Project udemy
 * @Author Henri Joel SEDJAME
 * @Date 04/07/2018
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
@Entity
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Version
  private int version;
  private String firstname;
  private String lastname;
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "author_book",
    joinColumns = @JoinColumn(name = "author_id"),
    inverseJoinColumns = @JoinColumn(name = "book_id"))
  private Set<Book> books;

  {
    books = new HashSet<>();
  }
}
