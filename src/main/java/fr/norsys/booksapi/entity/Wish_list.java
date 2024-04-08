package fr.norsys.booksapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "wish_list")
public class Wish_list {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wish_list_id;
    @ManyToOne
    @JoinColumn(name = "user")

    private  User user;

    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;

}
