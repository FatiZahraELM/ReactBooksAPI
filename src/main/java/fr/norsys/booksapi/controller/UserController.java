package fr.norsys.booksapi.controller;

import fr.norsys.booksapi.entity.*;
import fr.norsys.booksapi.service.Books_loansService;
import fr.norsys.booksapi.service.RatingService;
import fr.norsys.booksapi.service.UserService;
import fr.norsys.booksapi.service.Wish_listService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")

    public class UserController {

        @Autowired
        private UserService userService;

        @Autowired
        private RatingService ratingService;
        @Autowired
        private Wish_listService wish_listService;
        @Autowired
        private Books_loansService booksLoansService;


        @GetMapping
        public ResponseEntity<List<User>> findAll() {
            List<User> users= userService.getAll();
            return ResponseEntity.ok(users);

        }

        @GetMapping("/{id}")
        public ResponseEntity<User> findById(@PathVariable int id) {
            User updatedUser = userService.findById(id);
            return ResponseEntity.ok().body(updatedUser);
        }

    @GetMapping("/{name}")
    public ResponseEntity<User> findByName(@PathVariable String name) {
        User updatedUser = userService.findByName(name);
        return ResponseEntity.ok().body(updatedUser);
    }


        @PostMapping
        public ResponseEntity<Void> createUser(@RequestBody User user){
            userService.save(user);
            return ResponseEntity.ok(null);
        }


        @PutMapping("/{id}")
        public ResponseEntity<User> update(@PathVariable int id, @RequestBody User userDetails) {

            userService.updateUser(id,userDetails);

            return ResponseEntity.ok().body(userDetails);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable int id) {
            userService.deleteById(id);
            return  ResponseEntity.ok(null);
        }

        @GetMapping("/{id}/ratings")
        public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable int id) {
            User user= userService.findById(id);
            List<Rating> ratings=ratingService.getRatingByUser(user);
            return ResponseEntity.ok(ratings);

        }
    @GetMapping("/{id}/wishLists")
    public ResponseEntity<List<Wish_list>> getWish_listByUser(@PathVariable int id) {
        User user= userService.findById(id);
        List<Wish_list> wishListByUser=wish_listService.getWish_listByUser(user);
        return ResponseEntity.ok(wishListByUser);

    }
    @GetMapping("/{id}/bookLoans")
    public ResponseEntity<List<Books_loans>> getBooks_loansByUser(@PathVariable int id) {
        User user= userService.findById(id);
        List<Books_loans> booksLoans=booksLoansService.getBooks_loansByUser(user);
        return ResponseEntity.ok(booksLoans);

    }
    }

