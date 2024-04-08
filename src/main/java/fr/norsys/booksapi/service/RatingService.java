package fr.norsys.booksapi.service;

import fr.norsys.booksapi.entity.Book;
import fr.norsys.booksapi.entity.Rating;
import fr.norsys.booksapi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {


    List<Rating> getAll();

    Rating getRatingById(int id);

    Rating save(Rating ating);

    Rating updateRating(int id,Rating newRating);


    void deleteById(int id);

    List<Rating> getRatingByUser(User user);
    List<Rating> getRatingByBook(Book book);



}
