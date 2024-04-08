package fr.norsys.booksapi.service;

import fr.norsys.booksapi.entity.Book;
import fr.norsys.booksapi.entity.Rating;
import fr.norsys.booksapi.entity.User;
import fr.norsys.booksapi.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(int id) {

        return ratingRepository.findById(id).get();
    }

    @Override
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRating(int id, Rating newRating) {
        Rating rating=ratingRepository.findById(id).get();
        rating.setRating(newRating.getRating());
        rating.setBook(newRating.getBook());
        rating.setUser(newRating.getUser());
        return null;
    }

    @Override
    public void deleteById(int id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public List<Rating> getRatingByUser(User user) {
        return ratingRepository.getRatingByUser(user);
    }

    @Override
    public List<Rating> getRatingByBook(Book book) {
        return ratingRepository.getRatingByBook(book);
    }
}
