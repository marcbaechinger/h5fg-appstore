package com.zuehlke.adn.archive;

import com.zuehlke.exception.SystemException;

public class AppArchiveException extends SystemException {

    public AppArchiveException(String string) {
        super(string);
    }

    public AppArchiveException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public AppArchiveException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
