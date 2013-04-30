package com.zuehlke.adn.service;

import com.zuehlke.adn.domain.ManagedApplication;
import com.zuehlke.adn.domain.ManagedApplicationCollection;
import com.zuehlke.datasource.DataSourceException;
import com.zuehlke.datasource.XmlDataSource;
import com.zuehlke.datasource.EntityCollection;
import java.util.List;

public class ManagedApplicationSource extends XmlDataSource<ManagedApplication> {
        
    public ManagedApplicationSource(String filename, String packageName) throws DataSourceException {
        super(filename, packageName);
    }

    @Override
    public EntityCollection createCollection(List<ManagedApplication> dataItems) {
        return new ManagedApplicationCollection(dataItems);
    }

}
