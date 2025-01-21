package com.insy2s.exercices.controller;

import com.insy2s.exercices.domain.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final ArrayList<Post> posts = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> post(@RequestBody Post post) {
        return posts.add(post) ?
                ResponseEntity.status(HttpStatus.CREATED).body("Article ajouté avec l'id " + post.getId()):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> put(@PathVariable int id, @RequestBody Post post) {
        for (Post p : posts) {
            if (p.getId() == id) {
                p.setId(p.getId());
                if (post.getTitle() != null) {
                    p.setTitle(post.getTitle());
                }
                if (post.getContent() != null) {
                    p.setContent(post.getContent());
                }
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        return (posts.removeIf(product -> product.getId() == id)) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
