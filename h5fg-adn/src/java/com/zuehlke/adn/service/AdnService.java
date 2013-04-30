package com.zuehlke.adn.service;

import com.zuehlke.adn.archive.AppArchiveException;
import com.zuehlke.adn.archive.ArchiveRepositoryManager;
import com.zuehlke.adn.domain.ManagedApplication;
import com.zuehlke.datasource.DataSourceException;
import java.io.File;
import java.util.List;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("apps")
public class AdnService {

    @Context
    private UriInfo context;
    @javax.ws.rs.core.Context 
    ServletContext servletContext;
    
    private ManagedApplicationSource applicationSource;
    private Long nextId;
    public AdnService() throws DataSourceException {
        applicationSource = new ManagedApplicationSource("repository.xml", "com.zuehlke.adn.domain");
    }

    @GET
    @Produces("application/json")
    public List<ManagedApplication> getAll() {
        return applicationSource.getAll();
    }
    
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public ManagedApplication find(@PathParam("id") Long id) {
        return applicationSource.find(id);
    }
    
    @PUT
    @Consumes("application/json")
    public boolean register(ManagedApplication managedApplication) throws DataSourceException, AppArchiveException {
        
        managedApplication.setId(getNextId());
        applicationSource.add(managedApplication);
        applicationSource.save();
        
        ArchiveRepositoryManager manager = 
                new ArchiveRepositoryManager(getResourceRoot(), managedApplication, getTmpDirectory());
        manager.download();
        manager.unpack();
        
        return true;
    }

    private Long getNextId() {
        if (nextId == null) {
            nextId = 0L;
            for (ManagedApplication app: this.applicationSource.getAll()) {
                if (app.getId() > nextId) {
                    nextId = app.getId();
                }
            }
        }
        nextId = nextId + 1;
        return nextId;
    }

    private String getFileName(String repositoryUrl) {
        int pos = repositoryUrl.lastIndexOf("/");
        return repositoryUrl.substring(pos);
    }

    private File getArchiveFile(ManagedApplication managedApplication) {
        return new File(servletContext.getRealPath("/archives/" + getFileName(managedApplication.getRepositoryUrl())));
    }
    private File getResourceRoot() {
            return new File(servletContext.getRealPath("/"));
    }
    private File getTmpDirectory() {
            return new File(servletContext.getRealPath("/tmp"));
    }
}
