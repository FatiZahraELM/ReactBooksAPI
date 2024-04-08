package fr.norsys.booksapi.controller;

import fr.norsys.booksapi.entity.Book;
import fr.norsys.booksapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/books")

public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books= bookService.getAll();
        return ResponseEntity.ok(books);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable int id) {
        Book updatedBook = bookService.getBookById(id);
        return ResponseEntity.ok().body(updatedBook);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> findByTitle(@PathVariable String title) {
        Book updatedBook = bookService.findByTitle(title);
        return ResponseEntity.ok().body(updatedBook);
    }
    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody Book book){
        bookService.save(book);
        return ResponseEntity.ok(null);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable int id, @RequestBody Book bookDetails) {

        bookService.updateBook(id,bookDetails);

        return ResponseEntity.ok().body(bookDetails);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        bookService.deleteById(id);
        return  ResponseEntity.ok(null);
    }

}
