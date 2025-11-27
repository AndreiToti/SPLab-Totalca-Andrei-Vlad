package org.example.strategy;

import org.example.book.Paragraph;

public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, Object renderingContext) {
        System.out.println("Align: Left");
        System.out.println("Text: " + paragraph.getText());
    }
}