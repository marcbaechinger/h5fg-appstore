package com.zuehlke.appstore.domain;

import com.zuehlke.datasource.EntityCollection;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "appstore")
public class ApplicationCollection implements EntityCollection<Application> {
    
    private List<Application> collection = new ArrayList<Application>();

    public ApplicationCollection() {
    }

    public ApplicationCollection(List<Application> collection) {
        this.collection = collection;
    }
    
    @Override
    @XmlElement(name="application")
    public List<Application> getCollection() {
        return collection;
    }
    
    public void setCollection(List<Application> applications) {
        this.collection = collection;
    }
}
