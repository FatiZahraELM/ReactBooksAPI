package fr.norsys.booksapi.repository;

import fr.norsys.booksapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findBookByTitle(String title);
}
