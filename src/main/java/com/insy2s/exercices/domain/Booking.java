package com.insy2s.exercices.domain;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Booking {
    private static final AtomicInteger atomicInteger = new AtomicInteger(-1);
    private int id;
    private String room;
    private Date date;

    public Booking(String room, Date date) {
        this.id = atomicInteger.incrementAndGet();
        this.room = room;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
