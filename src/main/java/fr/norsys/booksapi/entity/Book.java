package fr.norsys.booksapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String genre;

    @Column
    private String resume;

    @Column
    private String availability;

    @OneToMany(mappedBy = "book", cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Books_loans> books_loans;

    @OneToMany(mappedBy = "book", cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Wish_list> wish_list ;

    @OneToMany(mappedBy = "rating", cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Rating> ratings;

}
