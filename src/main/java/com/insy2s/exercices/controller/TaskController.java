package com.insy2s.exercices.controller;

import com.insy2s.exercices.domain.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final ArrayList<Task> tasks = new ArrayList<>();
    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody Task taskData) {
        tasks.add(taskData);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tâche ajoutée avec l'id " + taskData.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> put(@PathVariable int id, @RequestBody Task taskData) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                if (taskData.getTitle() != null) {
                    task.setTitle(taskData.getTitle());
                }
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Task updated");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
        if (tasks.removeIf(task -> task.getId() == id)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
