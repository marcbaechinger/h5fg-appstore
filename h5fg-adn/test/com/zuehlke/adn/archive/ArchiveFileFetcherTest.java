package com.zuehlke.adn.archive;

import java.io.File;
import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ArchiveFileFetcherTest {
    private ArchiveFileFetcher fetcher;
    
    public ArchiveFileFetcherTest() {
    }

    @Before
    public void init() {
        fetcher = new ArchiveFileFetcher();
    }
    
    @Test
    public void testDownload() throws Exception {
        final File targetFile = getTargetFile();
        fetcher.download(getDownloadUrl(), targetFile);
        
        assertTrue(targetFile.isFile());
    }

    private File getTargetFile() {
        final URL resource = this.getClass().getClassLoader().getResource("testarchive.zip");
        return new File(resource.getPath());
    }

    private String getDownloadUrl() {
        return "http://github.com/marcbaechinger/pwd-manager/archive/gh-pages.zip";
    }
}