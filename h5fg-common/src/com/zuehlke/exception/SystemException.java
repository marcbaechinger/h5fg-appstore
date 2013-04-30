package com.zuehlke.exception;

public class SystemException extends Exception {

    public SystemException(String string) {
        super(string);
    }

    public SystemException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public SystemException(Throwable thrwbl) {
        super(thrwbl);
    }

    
}
