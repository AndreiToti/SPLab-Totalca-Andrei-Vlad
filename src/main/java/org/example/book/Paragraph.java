package org.example.book;

import org.example.strategy.AlignStrategy;

public class Paragraph extends Element {
    private String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
        this.alignStrategy = null;
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            alignStrategy.render(this, null);
        } else {
            System.out.println("Alignment: ");
            System.out.println("Text: " + text);
        }
    }
}