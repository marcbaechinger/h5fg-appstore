/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.adn.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author marcbaechinger
 */
public class ManagedApplicationTest {
    private ManagedApplication application;
    
    public ManagedApplicationTest() {
    }

    @Before
    public void init() {
        application = new ManagedApplication();
    }
    
    @Test
    public void testGetArchiveFilePath() {
        application.setRepositoryUrl("http://github.com/marcbaechinger/theapp.zip");
        assertEquals("theapp.zip", application.getArchiveFileName());
    }
    @Test
    public void testGetArchiveFilePath_Null() {
        application.setRepositoryUrl(null);
        assertNull(application.getArchiveFileName());
    }
}