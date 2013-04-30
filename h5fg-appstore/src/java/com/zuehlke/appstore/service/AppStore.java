package com.zuehlke.appstore.service;

import com.zuehlke.datasource.DataSourceException;
import com.zuehlke.appstore.domain.Application;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBException;

@Path("/apps")
public class AppStore {

    @Context
    private UriInfo context;

    private final ApplicationSource applicationSource;

    public AppStore() throws DataSourceException, JAXBException {
        this.applicationSource = new ApplicationSource("apps.xml", "com.zuehlke.appstore.domain");
    }

    
    AppStore(ApplicationSource applicationSource) {
        this.applicationSource = applicationSource;
    }
    
    

    @GET
    @Produces("application/json")
    public List<Application> get() {
        return applicationSource.getAll();
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Application find(@PathParam("id") Long id) {
        return applicationSource.find(id);
    }
    @POST
    @Consumes("application/json")
    public void addApplication(Application app) throws DataSourceException {
        applicationSource.add(app);
    }
    @DELETE
    @Produces("application/json")
    public void removeApplication(Long appId) {
        applicationSource.remove(appId);
    }
}
