package org.example.book;

import java.util.List;
import java.util.ArrayList;


public class Section extends Element {
    protected String title;
    private List<Element> children;

    public Section(String title) {
        this.title = title;
        this.children = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void add(Element element) {
        children.add(element);
    }

    @Override
    public void remove(Element element) {
        children.remove(element);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }

    @Override
    public void print() {
        System.out.println("\nSection: " + title);
        for (Element element : children) {
            element.print();
        }

    }
}