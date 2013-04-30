package com.zuehlke.appstore.service;

import com.zuehlke.datasource.DataSourceException;
import com.zuehlke.datasource.XmlDataSource;
import com.zuehlke.appstore.domain.Application;
import com.zuehlke.appstore.domain.ApplicationCollection;
import com.zuehlke.datasource.EntityCollection;
import java.util.List;
import javax.xml.bind.JAXBException;

public class ApplicationSource extends XmlDataSource<Application> {
        
    public ApplicationSource(String filename, String packageName) throws DataSourceException, JAXBException {
        super(filename, packageName);
    }

    @Override
    public EntityCollection createCollection(List<Application> dataItems) {
        return new ApplicationCollection(dataItems);
    }

}
