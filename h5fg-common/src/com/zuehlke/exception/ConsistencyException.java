package com.zuehlke.exception;

public class ConsistencyException extends RuntimeException {

    public ConsistencyException(String string) {
        super(string);
    }

    public ConsistencyException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ConsistencyException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
