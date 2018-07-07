package com.formation.spring.udemy.Repository;

import com.formation.spring.udemy.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @Project udemy
 * @Author Henri Joel SEDJAME
 * @Date 05/07/2018
 */
public interface BookRepository extends JpaRepository<Book, Long>, QuerydslPredicateExecutor<Book> {


}
