package com.insy2s.exercices.domain;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger atomicInteger = new AtomicInteger(-1);
    private int id;
    private String name;
    private String email;

    public User(String name, String email) {
        this.id = atomicInteger.incrementAndGet();
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
