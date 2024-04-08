package fr.norsys.booksapi.repository;

import fr.norsys.booksapi.entity.Book;
import fr.norsys.booksapi.entity.Books_loans;
import fr.norsys.booksapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Books_loansRepository extends JpaRepository<Books_loans,Integer> {
    List<Books_loans> getBooks_loansByUser(User user);

    List<Books_loans> getBooks_loansByBook(Book book);
}