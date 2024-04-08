package fr.norsys.booksapi.service;

import fr.norsys.booksapi.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAll();

        Book getBookById(int id);

        Book save(Book book);

        Book updateBook(int id,Book newBook);

        void deleteById(int id);


        Book findByTitle(String  title);




}
