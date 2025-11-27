package org.example.command;

import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class AsincronExec implements CommandExec {
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public <T> CompletableFuture<T> execute(Command<T> command) {
        return CompletableFuture.supplyAsync(command::execute, executorService);
    }
}