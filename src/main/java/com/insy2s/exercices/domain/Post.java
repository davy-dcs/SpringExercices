package com.insy2s.exercices.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Post {
    private static final AtomicInteger atomicInteger = new AtomicInteger(-1);
    private int id;
    private String title;
    private String content;

    public Post(String title, String content) {
        this.id = atomicInteger.incrementAndGet();
        this.title = title;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
