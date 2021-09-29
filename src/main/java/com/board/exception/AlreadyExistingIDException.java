package com.board.exception;

public class AlreadyExistingIDException extends RuntimeException{
    public AlreadyExistingIDException(String message) {
        super(message);
    }
}
