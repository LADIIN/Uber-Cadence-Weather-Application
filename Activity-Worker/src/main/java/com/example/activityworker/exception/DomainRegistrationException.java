package com.example.activityworker.exception;

public class DomainRegistrationException extends RuntimeException {
    public DomainRegistrationException() {
    }

    public DomainRegistrationException(String message) {
        super(message);
    }

    public DomainRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DomainRegistrationException(Throwable cause) {
        super(cause);
    }

    public DomainRegistrationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
