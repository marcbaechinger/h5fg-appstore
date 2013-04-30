/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.adn.archive;

import java.io.File;
import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author marcbaechinger
 */
public class ArchiveUnpackerTest {
    private ArchiveUnpacker unpacker;
    
    public ArchiveUnpackerTest() {
    }
    
    @Before
    public void init() {
        unpacker = new ArchiveUnpacker(getTmpDirectory());
    }

    @Test
    public void testUnpack() throws Exception {
        final File targetFile = getTargetFile();
        unpacker.unpack(targetFile, targetFile.getParentFile());
    }
    
    private File getTargetFile() {
        final URL resource = this.getClass().getClassLoader().getResource("testarchive.zip");
        return new File(resource.getPath());
    }
    private File getTmpDirectory() {
        return getTargetFile().getParentFile();
    }
}