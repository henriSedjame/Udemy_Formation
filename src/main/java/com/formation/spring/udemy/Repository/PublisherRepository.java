package com.formation.spring.udemy.Repository;

import com.formation.spring.udemy.Model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PublisherRepository extends JpaRepository<Publisher, Long>, QuerydslPredicateExecutor<Publisher> {
}
