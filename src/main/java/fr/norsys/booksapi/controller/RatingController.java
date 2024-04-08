package fr.norsys.booksapi.controller;

import fr.norsys.booksapi.entity.Rating;
import fr.norsys.booksapi.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/ratings")

public class RatingController {

    @Autowired
    private RatingService ratingService;
    

        

        @GetMapping
        public ResponseEntity<List<Rating>> findAll() {
        List<Rating> ratings= ratingService.getAll();
        return ResponseEntity.ok(ratings);

    }

        @GetMapping("/{id}")
        public ResponseEntity<Rating> findById(@PathVariable int id) {
            Rating updatedRating = ratingService.getRatingById(id);
            return ResponseEntity.ok().body(updatedRating);
    }

        @PostMapping
        public ResponseEntity<Void> createRating(@RequestBody Rating rating){
        ratingService.save(rating);
        return ResponseEntity.ok(null);
    }


        @PutMapping("/{id}")
        public ResponseEntity<Rating> update(@PathVariable int id, @RequestBody Rating ratingDetails) {

        ratingService.updateRating(id,ratingDetails);

        return ResponseEntity.ok().body(ratingDetails);
    }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable int id) {
        ratingService.deleteById(id);
        return  ResponseEntity.ok(null);
    }


}
