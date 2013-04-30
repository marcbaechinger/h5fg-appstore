package com.zuehlke.exception;

public class ApplicationException extends Exception {

    public ApplicationException(String string) {
        super(string);
    }

    public ApplicationException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ApplicationException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
