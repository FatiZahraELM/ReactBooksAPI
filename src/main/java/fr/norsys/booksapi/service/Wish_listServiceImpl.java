package fr.norsys.booksapi.service;

import fr.norsys.booksapi.entity.Book;
import fr.norsys.booksapi.entity.User;
import fr.norsys.booksapi.entity.Wish_list;
import fr.norsys.booksapi.repository.Wish_listRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin("*")

public class Wish_listServiceImpl implements Wish_listService{
    @Autowired
    private Wish_listRepository wishListRepository;
    @Override
    public List<Wish_list> getAll() {
        return wishListRepository.findAll();
    }

    @Override
    public Wish_list getWish_listById(int id) {
        return wishListRepository.findById(id).get();
    }

    @Override
    public Wish_list save(Wish_list wishList) {
        return wishListRepository.save(wishList);
    }

    @Override
    public Wish_list updateWish_list(int id, Wish_list newWish_list) {
        Wish_list wishList=wishListRepository.findById(id).get();
        wishList.setBook(newWish_list.getBook());
        wishList.setUser(newWish_list.getUser());
        return wishListRepository.save(wishList);
    }

    @Override
    public void deleteById(int id) {
        wishListRepository.deleteById(id);

    }

    @Override
    public List<Wish_list> getWish_listByUser(User user) {
        return wishListRepository.getWish_listByUser(user);
    }

    @Override
    public List<Wish_list> getWish_listByBook(Book book) {
        return wishListRepository.getWish_listByBook(book);
    }
}
