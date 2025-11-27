package org.example.book;

public class Image extends Element {
    private String url; // url: String

    public Image(String url) {
        this.url = url;
    }

    @Override
    public void print() {
        System.out.println("Image URL: " + url);
    }
}