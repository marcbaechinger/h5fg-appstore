package com.zuehlke.adn.domain;

import com.zuehlke.datasource.EntityCollection;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "repository")
public class ManagedApplicationCollection implements EntityCollection {

    private List<ManagedApplication> collection = new ArrayList<ManagedApplication>();

    public ManagedApplicationCollection() {
    }

    public ManagedApplicationCollection(List<ManagedApplication> collection) {
        this.collection = collection;
    }

    
    @Override
    @XmlElement(name="application")
    public List<ManagedApplication> getCollection() {
        return collection;
    }

    public void setCollection(List<ManagedApplication> collection) {
        this.collection = collection;
    }
}
