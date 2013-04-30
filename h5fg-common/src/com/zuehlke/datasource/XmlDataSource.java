package com.zuehlke.datasource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public abstract class XmlDataSource<E extends Entity> {
    protected final List<E> dataItems;
    protected final String filename;
    protected JAXBContext jc;
    protected final String packageName;

    public XmlDataSource(String filename, String packageName) throws DataSourceException {
        try {
            jc = JAXBContext.newInstance( packageName );
            this.filename = filename;
            this.packageName = packageName;
            this.dataItems = load();
        } catch (JAXBException ex) {
            throw new DataSourceException(ex);
        }
    }

    
    
    public void add(E app) throws DataSourceException {
        this.dataItems.add(app);
        save();
    }

    public E find(Long id) {
        return getById(id);
    }

    public List<E> getAll() {
        return dataItems;
    }

    public boolean remove(Long applicationId) {
        final E app = this.getById(applicationId);
        boolean remove = false;
        if (app != null) {
            remove = this.dataItems.remove(app);
        }
        return remove;
    }

    public synchronized void save() throws DataSourceException {
        try {
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            System.out.println(this.getClass().getClassLoader().getResource(filename).getPath());
            File file = new File(this.getClass().getClassLoader().getResource(filename).getPath());
            m.marshal(createCollection(dataItems), new FileOutputStream(file));
        } catch (FileNotFoundException ex) {
            throw new DataSourceException("file " + filename + " not found in classpath");
        } catch (JAXBException ex) {
            throw new DataSourceException("error while marshaling appstore", ex);
        }
    }

    public E getById(Long id) {
        for (E app: dataItems) {
           if (app.getId().equals(id)) {
               return app;
           }
        }
        return null;
    }
    
    public synchronized final List<E> load() throws DataSourceException {
        try {
            jc = JAXBContext.newInstance( packageName );
            Unmarshaller u = jc.createUnmarshaller();
            EntityCollection apps = (EntityCollection) 
                    u.unmarshal(this.getClass().getClassLoader().getResourceAsStream(filename));
            return apps.getCollection();
        } catch (JAXBException ex) {
            throw new DataSourceException(ex);
        }
    }
    public abstract EntityCollection<E> createCollection(List<E> dataItems);
    
}
