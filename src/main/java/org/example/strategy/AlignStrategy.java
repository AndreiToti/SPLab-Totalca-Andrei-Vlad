package org.example.strategy;

import org.example.book.Paragraph;

public interface AlignStrategy {
    void render(Paragraph paragraph, Object renderingContext);
}