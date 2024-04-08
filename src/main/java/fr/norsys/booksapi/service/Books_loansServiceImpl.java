package fr.norsys.booksapi.service;

import fr.norsys.booksapi.entity.Book;
import fr.norsys.booksapi.entity.Books_loans;
import fr.norsys.booksapi.entity.User;
import fr.norsys.booksapi.repository.Books_loansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin("*")


public class Books_loansServiceImpl implements Books_loansService{
    @Autowired
    private Books_loansRepository booksLoansRepository;
    @Override
    public List<Books_loans> getAll() {
        return booksLoansRepository.findAll();
    }

    @Override
    public Books_loans getBooks_loansById(int id) {
        return booksLoansRepository.findById(id).get();
    }

    @Override
    public Books_loans save(Books_loans booksLoans) {
        return booksLoansRepository.save(booksLoans);
    }

    @Override
    public Books_loans updateBooks_loans(int id, Books_loans newBook) {
        Books_loans booksLoans=booksLoansRepository.findById(id).get();
        booksLoans.setBook(newBook.getBook());
        booksLoans.setUser(newBook.getUser());
        return booksLoansRepository.save(booksLoans);
    }

    @Override
    public void deleteById(int id) {
        booksLoansRepository.deleteById(id);

    }

    @Override
    public List<Books_loans> getBooks_loansByUser(User user) {
        return booksLoansRepository.getBooks_loansByUser(user);
    }

    @Override
    public List<Books_loans> getBooks_loansByBook(Book book) {
        return booksLoansRepository.getBooks_loansByBook(book);
    }
}
