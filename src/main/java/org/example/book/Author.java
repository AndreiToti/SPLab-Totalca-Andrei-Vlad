package org.example.book;


public class Author {
    private String name;


    public Author(String name, String surname) {
        this.name = name;

    }

    public void print() {
        System.out.println("Author: " + name);
    }
}