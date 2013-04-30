package com.zuehlke.appstore.domain;

import com.zuehlke.datasource.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Application implements Entity {
    private static final long serialVersionUID = 1L;
    private Long id;
    
    private String name;
    private String description;
    private String image;
    private String version;
    private String appUrl;

    public Application() {
    }

    
    public Application(long id, String name, String description, String appUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.appUrl = appUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zuehlke.appstore.domain.Application[ id=" + id + " ]";
    }
    
}
