package com.insy2s.exercices.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private static final AtomicInteger atomicInteger = new AtomicInteger(-1);
    private int id;
    private String title;

    public Task(String title) {
        this.id = atomicInteger.incrementAndGet();
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
