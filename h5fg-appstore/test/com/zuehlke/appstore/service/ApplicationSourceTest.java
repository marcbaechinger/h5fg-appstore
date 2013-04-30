package com.zuehlke.appstore.service;

import com.zuehlke.appstore.domain.Application;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ApplicationSourceTest {
    private ApplicationSource applicationSource;
    
    public ApplicationSourceTest() {
    }

    @Before 
    public void init() throws Exception {
        applicationSource = new ApplicationSource("apps.xml", "com.zuehlke.appstore.domain");
    }
    
    @Test
    public void testGetAll() throws Exception {
        List<Application> applications = applicationSource.getAll();
        applications.clear();
        applications.add(new Application(99, "test1", "test1 description", "http://"));
        applicationSource.save();
        assertEquals(1, applications.size());
    }

}