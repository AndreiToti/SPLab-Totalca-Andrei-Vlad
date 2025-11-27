package org.example.command;

// Interfata Command
public interface Command<T> {
    T execute();
}