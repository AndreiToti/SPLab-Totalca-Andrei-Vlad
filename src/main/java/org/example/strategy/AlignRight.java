package org.example.strategy;

import org.example.book.Paragraph;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, Object renderingContext) {
        System.out.println("Align: Right");
        System.out.println("Text: " + paragraph.getText());
    }
}