package com.models;

import com.interfaces.TechnicalDescription;

import java.time.LocalDate;

public abstract class Robot implements TechnicalDescription {

    private String name;
    private String producer;
    private int year;
    private LocalDate date;

    public Robot(String name, String producer, int year) {
        this.name = name;
        this.producer = producer;
        this.year = year;
        this.date = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
