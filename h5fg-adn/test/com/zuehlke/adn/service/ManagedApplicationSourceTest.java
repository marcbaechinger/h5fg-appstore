package com.zuehlke.adn.service;

import com.zuehlke.datasource.DataSourceException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ManagedApplicationSourceTest {
    private ManagedApplicationSource source;
    
    public ManagedApplicationSourceTest() {
    }
    
    @Before
    public void init () throws DataSourceException {
        this.source = new ManagedApplicationSource("repository.xml", "com.zuehlke.adn.domain");
    }

    @Test
    public void testCreateCollection() {
        assertEquals(1, source.getAll().size());
    }
}