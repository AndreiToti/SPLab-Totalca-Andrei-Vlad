package org.example.observer;

import org.example.book.Book;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class SSEObserver implements Observer {

    private final SseEmitter emitter;

    public SSEObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (Exception e) {
            System.err.println("SSE Observer failed to send update: " + e.getMessage());
            emitter.completeWithError(e);
        }
    }
}