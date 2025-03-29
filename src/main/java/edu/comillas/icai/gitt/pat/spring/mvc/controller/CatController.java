package edu.comillas.icai.gitt.pat.spring.mvc.controller;

import edu.comillas.icai.gitt.pat.spring.mvc.model.Cat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CatController {
    private final Map<String, Cat> cats = new HashMap<>();

    @GetMapping("/cats/{name}")
    public ResponseEntity<Cat> getCat(@PathVariable String name) {
        Cat cat = cats.get(name);
        if( cat != null) {
            return ResponseEntity.ok(cat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cats")
    @ResponseStatus(HttpStatus.CREATED)
    public Cat addCat(@RequestBody Cat newCat) {
        cats.put(newCat.name(), newCat);
        return newCat;
    }

    @PutMapping("/cats/{name}/age/{age}")
    public ResponseEntity<Cat> updateCat(@PathVariable String name,
                         @PathVariable int age) {
        Cat existingCat = cats.get(name);
        if( existingCat != null) {
            Cat updatedCat =  new Cat(name, existingCat.age() + age);
            cats.put(name, updatedCat);
            return ResponseEntity.ok(updatedCat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/cats/{name}")
    public ResponseEntity<Cat> deleteCat(@PathVariable String name) {
        Cat removedCat = cats.remove(name);
        if( removedCat != null) {
            return ResponseEntity.ok(removedCat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
