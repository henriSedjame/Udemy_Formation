package com.formation.spring.udemy.Utils.PojoQueryingPredicates;


import com.querydsl.core.types.Predicate;


public interface AuthorPredicator {
  Predicate named(String name);
}
