package fr.norsys.booksapi.controller;

import fr.norsys.booksapi.entity.Books_loans;
import fr.norsys.booksapi.service.Books_loansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/bookLoans")

public class Book_loansController {

    @Autowired
    private Books_loansService booksLoansService;


    @GetMapping
    public ResponseEntity<List<Books_loans>> findAll() {
        List<Books_loans> booksLoans= booksLoansService.getAll();
        return ResponseEntity.ok(booksLoans);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Books_loans> findById(@PathVariable int id) {
        Books_loans booksLoans = booksLoansService.getBooks_loansById(id);
        return ResponseEntity.ok().body(booksLoans);
    }

    @PostMapping
    public ResponseEntity<Void> createBooks_loans(@RequestBody Books_loans booksLoans){
        booksLoansService.save(booksLoans);
        return ResponseEntity.ok(null);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Books_loans> update(@PathVariable int id, @RequestBody Books_loans booksLoans) {
        booksLoansService.updateBooks_loans(id,booksLoans);

        return ResponseEntity.ok().body(booksLoans);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        booksLoansService.deleteById(id);
        return  ResponseEntity.ok(null);
    }


}
