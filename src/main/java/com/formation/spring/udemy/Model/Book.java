package com.formation.spring.udemy.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Project udemy
 * @Author Henri Joel SEDJAME
 * @Date 04/07/2018
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Version
  private int version;
  private String isbn;
  private String publisher;
  @ManyToMany(mappedBy = "books")
  private Set<Author> authors = new HashSet<>();
}