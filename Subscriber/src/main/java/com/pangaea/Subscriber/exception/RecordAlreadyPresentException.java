package com.pangaea.Subscriber.exception;

public class RecordAlreadyPresentException extends RuntimeException {
    public RecordAlreadyPresentException(String message) {
        super(message);
    }

    public RecordAlreadyPresentException(Throwable cause) {
        super(cause);
    }
}
