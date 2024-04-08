package fr.norsys.booksapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rating_id;

    @ManyToOne
    @JoinColumn(name = "user")

    private  User user;

    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;

    @Column
    private String rating;

}
