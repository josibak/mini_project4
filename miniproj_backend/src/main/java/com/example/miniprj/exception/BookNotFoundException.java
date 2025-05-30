// BookNotFoundException.java
package com.example.miniprj.exception;
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) { super(message); }
}