package com.tactfactory.ovg.exceptions;

public class NotYetImplementedException extends HttpException {

    /** The serial number. */
    private static final long serialVersionUID = 1L;

    public NotYetImplementedException() {
    }

    public NotYetImplementedException(String message) {
        super(message);
    }

    public NotYetImplementedException(Throwable cause) {
        super(cause);
    }

    public NotYetImplementedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotYetImplementedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
