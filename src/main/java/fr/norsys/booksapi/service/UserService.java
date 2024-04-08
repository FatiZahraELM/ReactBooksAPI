package fr.norsys.booksapi.service;

import fr.norsys.booksapi.entity.Book;
import fr.norsys.booksapi.entity.Books_loans;
import fr.norsys.booksapi.entity.User;
import fr.norsys.booksapi.entity.Wish_list;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {




    List<User> getAll();
    User findById(int id) ;

    void save(User user);

    User updateUser(int id,User newUser) ;


    void deleteById(int id);


    User findByName(String name);
}
