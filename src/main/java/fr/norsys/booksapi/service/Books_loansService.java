package fr.norsys.booksapi.service;

import fr.norsys.booksapi.entity.Book;
import fr.norsys.booksapi.entity.Books_loans;
import fr.norsys.booksapi.entity.User;

import java.util.List;

public interface Books_loansService {


    List<Books_loans> getAll();

    Books_loans getBooks_loansById(int id);

    Books_loans save(Books_loans booksLoans);

    Books_loans updateBooks_loans(int id, Books_loans newRating);


    void deleteById(int id);

    List<Books_loans> getBooks_loansByUser(User user);
    List<Books_loans> getBooks_loansByBook(Book book);



}
