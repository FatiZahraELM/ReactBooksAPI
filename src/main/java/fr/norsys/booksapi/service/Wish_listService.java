package fr.norsys.booksapi.service;

import fr.norsys.booksapi.entity.*;

import java.util.List;

public interface Wish_listService {


    List<Wish_list> getAll();

    Wish_list getWish_listById(int id);

    Wish_list save(Wish_list wishList);

    Wish_list updateWish_list(int id, Wish_list newWish_list);


    void deleteById(int id);

    List<Wish_list> getWish_listByUser(User user);
    List<Wish_list> getWish_listByBook(Book book);



}
