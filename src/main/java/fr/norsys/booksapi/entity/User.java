package fr.norsys.booksapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user", cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Books_loans> books_loans;

    @OneToMany(mappedBy = "user", cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Wish_list> wish_list ;

    @OneToMany(mappedBy = "rating", cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Rating> ratings;

}
