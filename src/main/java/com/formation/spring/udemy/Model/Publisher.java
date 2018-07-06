package com.formation.spring.udemy.Model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;
    private String name;
    private String adress;
    @OneToMany(mappedBy = "publisher")
    private Set<Book> publishedBooks;

    {
        publishedBooks = new HashSet<>();
    }
}
