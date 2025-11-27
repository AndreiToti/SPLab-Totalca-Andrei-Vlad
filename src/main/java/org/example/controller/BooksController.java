package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.command.AsincronExec;
import org.example.command.BookCommand;
import org.example.book.Book;
import org.example.observer.BooksSubject;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BooksController {

    private final BookService bookService;
    private final AsincronExec asyncExecutor;
    private final BooksSubject allBooksSubject;

    @GetMapping
    public Collection<Book> getAllBooks() {
        return bookService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookData) {
        Book updated = bookService.update(id, bookData);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<String> createBookAsync(@RequestBody Book newBookData) {
        BookCommand command = new BookCommand(bookService, newBookData);
        CompletableFuture<Book> futureResult = asyncExecutor.execute(command);
        futureResult.thenAccept(book -> {
            allBooksSubject.add(book);
        });

        String taskId = "async-task-" + System.currentTimeMillis();

        return new ResponseEntity<>("Request acceptat. Status at /books/status/" + taskId, HttpStatus.ACCEPTED);
    }

}