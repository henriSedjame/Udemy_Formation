package com.formation.spring.udemy.Utils.PojoQueryingPredicates.Impl;

import com.formation.spring.udemy.Model.Author;
import com.formation.spring.udemy.Model.QAuthor;
import com.formation.spring.udemy.Utils.PojoQueryingPredicates.AuthorPredicator;
import com.formation.spring.udemy.Utils.PojoQueryingPredicates.PojoQueryingPredicator;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Component;

@Component
public class AuthorPredicatorImpl extends PojoQueryingPredicator<QAuthor> implements AuthorPredicator {

  public AuthorPredicatorImpl() {
    super(Author.class);
  }

  public Predicate named(String name) {
    return getQClasse().lastname.eq(name);
  }
}
