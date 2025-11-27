package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.observer.BooksSubject;
import org.example.observer.SSEObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/books-sse")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SSEController{

    private final BooksSubject allBooksSubject;

    @GetMapping
    public SseEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(0L);

        SSEObserver observer = new SSEObserver(emitter);

        allBooksSubject.attach(observer);

        emitter.onCompletion(() -> allBooksSubject.detach(observer));
        emitter.onTimeout(() -> allBooksSubject.detach(observer));

        return emitter;
    }
}