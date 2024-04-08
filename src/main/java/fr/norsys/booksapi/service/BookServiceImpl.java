package fr.norsys.booksapi.service;

import fr.norsys.booksapi.entity.Book;
import fr.norsys.booksapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> book=bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public Book save(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book updateBook(int id, Book newBook) {
        Book book=bookRepository.getById(id);
        book.setAuthor(newBook.getAuthor());
        book.setTitle(newBook.getTitle());
        book.setResume(newBook.getResume());
        book.setAvailability(newBook.getAvailability());
        book.setGenre(newBook.getGenre());
        return bookRepository.save(book);
    }


    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);

    }

    @Override
    public Book findByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }
}
