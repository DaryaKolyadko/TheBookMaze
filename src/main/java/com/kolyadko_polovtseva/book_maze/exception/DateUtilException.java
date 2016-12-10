package com.kolyadko_polovtseva.book_maze.exception;


public class DateUtilException extends RuntimeException {
    public DateUtilException() {
    }

    public DateUtilException(String message) {
        super(message);
    }

    public DateUtilException(String message, Throwable cause) {
        super(message, cause);
    }

    public DateUtilException(Throwable cause) {
        super(cause);
    }

    public DateUtilException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}