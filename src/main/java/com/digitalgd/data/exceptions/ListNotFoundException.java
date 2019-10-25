package com.digitalgd.data.exceptions;

public class ListNotFoundException extends RuntimeException {

    static final long serialVersionUID = -7034897190745766937L;

    public ListNotFoundException() {
        super();
    }

    public ListNotFoundException(String message) {
        super(message);
    }

    public ListNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ListNotFoundException(String message, Throwable cause,
                                      boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
