package fr.norsys.booksapi.repository;

import fr.norsys.booksapi.entity.Book;
import fr.norsys.booksapi.entity.Rating;
import fr.norsys.booksapi.entity.User;
import fr.norsys.booksapi.entity.Wish_list;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Wish_listRepository extends JpaRepository<Wish_list,Integer> {
    List<Wish_list> getWish_listByUser(User user);
    List<Wish_list> getWish_listByBook(Book book);



}
