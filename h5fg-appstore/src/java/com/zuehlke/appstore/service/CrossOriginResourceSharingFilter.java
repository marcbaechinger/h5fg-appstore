package com.zuehlke.appstore.service;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class CrossOriginResourceSharingFilter implements ContainerResponseFilter {

    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        response.getHttpHeaders().putSingle("Access-Control-Allow-Origin", "*");
        response.getHttpHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        response.getHttpHeaders().putSingle("Access-Control-Allow-Headers", "content-type, X-Requested-With, Authorization");
        response.getHttpHeaders().putSingle("Access-Control-Max-Age", "3600");
        return response;
    }
    
}
