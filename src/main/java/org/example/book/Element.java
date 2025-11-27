package org.example.book;


public abstract class Element {

    public abstract void print();


    public void add(Element element) {
        throw new UnsupportedOperationException("Unsuported");
    }

    public void remove(Element element) {
        throw new UnsupportedOperationException("Unsuported");
    }

    public Element get(int index) {
        throw new UnsupportedOperationException("Unsuported");
    }
}