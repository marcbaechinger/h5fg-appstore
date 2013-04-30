package com.zuehlke.datasource;

import com.zuehlke.exception.SystemException;

public class DataSourceException extends SystemException {

    public DataSourceException(String string) {
        super(string);
    }

    public DataSourceException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DataSourceException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
