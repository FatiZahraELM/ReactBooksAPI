package fr.norsys.booksapi.repository;

import fr.norsys.booksapi.entity.Book;
import fr.norsys.booksapi.entity.Rating;
import fr.norsys.booksapi.entity.User;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> getRatingByUser(User user);
    List<Rating> getRatingByBook(Book book);


}
