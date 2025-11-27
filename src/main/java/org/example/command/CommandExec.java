package org.example.command;

import java.util.concurrent.CompletableFuture;

public interface CommandExec {
    <T> CompletableFuture<T> execute(Command<T> command);
}