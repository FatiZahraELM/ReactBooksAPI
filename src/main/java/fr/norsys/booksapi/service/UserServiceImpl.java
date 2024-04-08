package fr.norsys.booksapi.service;

import fr.norsys.booksapi.entity.Book;
import fr.norsys.booksapi.entity.Books_loans;
import fr.norsys.booksapi.entity.User;
import fr.norsys.booksapi.entity.Wish_list;
import fr.norsys.booksapi.repository.UserReppository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImpl implements UserService{
    @Autowired
    private UserReppository userReppository;

    @Override
    public List<User> getAll() {
        return userReppository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> author=userReppository.findById(id);
        if(author.isEmpty())
            return null;
        return  userReppository.findById(id).get()  ;
    }

    @Override
    public void save(User user) {
        userReppository.save(user);
    }

    @Override
    public User updateUser(int id, User newUser) {
        User user=userReppository.findById(id).get();
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        return userReppository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userReppository.deleteById(id);
    }

    @Override
    public User findByName(String name) {
        return userReppository.findUserByName(name);
    }


}
