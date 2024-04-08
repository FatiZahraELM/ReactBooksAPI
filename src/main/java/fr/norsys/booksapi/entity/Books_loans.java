package fr.norsys.booksapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "books_loans")
public class Books_loans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_loans_id;
    @ManyToOne
    @JoinColumn(name = "user")

    private  User user;

    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;

}
