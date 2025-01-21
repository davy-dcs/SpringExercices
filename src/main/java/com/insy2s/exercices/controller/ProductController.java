package com.insy2s.exercices.controller;

import com.insy2s.exercices.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final ArrayList<Product> products = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> post(@RequestBody Product product) {
        if (products.add(product)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Produit ajouté avec l'id " + product.getId());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> put(@PathVariable int id, @RequestBody Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                if (product.getName() != null) {
                    p.setName(p.getName());
                }
                if (product.getPrice() != null) {
                    p.setPrice(product.getPrice());
                }
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        return (products.removeIf(product -> product.getId() == id)) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
