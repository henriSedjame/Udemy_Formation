package com.formation.spring.udemy.Controller;

import com.formation.spring.udemy.Repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Project udemy
 * @Author Henri Joel SEDJAME
 * @Date 07/07/2018
 */

@Controller
public class BookController {

  public static final String BOOKS = "books";
  private BookRepository bookRepository;

  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @RequestMapping(value = "/books")
  public String getBooks(Model model) {
    model.addAttribute("books", this.bookRepository.findAll());
    return BOOKS;
  }
}
