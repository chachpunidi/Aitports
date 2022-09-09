package ru.ch.airport.exception;

import lombok.Getter;

public class CodeNotExistException extends RuntimeException implements HasCode {

    @Getter
    private String code = "001";

    public CodeNotExistException() {
    }

    public CodeNotExistException(String message) {
        super(message);
    }

    public CodeNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CodeNotExistException(Throwable cause) {
        super(cause);
    }

    public CodeNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
