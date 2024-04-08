package fr.norsys.booksapi.controller;

import fr.norsys.booksapi.entity.Wish_list;
import fr.norsys.booksapi.service.Wish_listService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/wishLists")

public class Wish_listController {

    @Autowired
    private Wish_listService wish_listService;


    @GetMapping
    public ResponseEntity<List<Wish_list>> findAll() {
        List<Wish_list> wishLists= wish_listService.getAll();
        return ResponseEntity.ok(wishLists);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Wish_list> findById(@PathVariable int id) {
        Wish_list updatedWish_list = wish_listService.getWish_listById(id);
        return ResponseEntity.ok().body(updatedWish_list);
    }

    @PostMapping
    public ResponseEntity<Void> createWish_list(@RequestBody Wish_list wishList){
        wish_listService.save(wishList);
        return ResponseEntity.ok(null);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Wish_list> update(@PathVariable int id, @RequestBody Wish_list wishList) {

        wish_listService.updateWish_list(id,wishList);

        return ResponseEntity.ok().body(wishList);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        wish_listService.deleteById(id);
        return  ResponseEntity.ok(null);
    }


}
