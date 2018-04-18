package com.highschool.football.exception;

public class SessionOutOfDateException extends RuntimeException {
    public SessionOutOfDateException(String message) {
        super(message);
    }
}
