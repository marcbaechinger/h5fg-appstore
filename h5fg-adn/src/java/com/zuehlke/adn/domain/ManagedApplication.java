package com.zuehlke.adn.domain;

import com.zuehlke.datasource.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ManagedApplication implements Entity {
    private Long id;
    private String path;
    private String name;
    private String description;
    private String repositoryUrl;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }
    
    public String getArchiveFileName() {
        if (repositoryUrl != null) {
            int pos = this.repositoryUrl.lastIndexOf("/");
            return this.repositoryUrl.substring(pos + 1);
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ManagedApplication other = (ManagedApplication) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.path == null) ? (other.path != null) : !this.path.equals(other.path)) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        if ((this.repositoryUrl == null) ? (other.repositoryUrl != null) : !this.repositoryUrl.equals(other.repositoryUrl)) {
            return false;
        }
        return true;
    }
    
    
}
