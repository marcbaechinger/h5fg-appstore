package com.zuehlke.adn.archive;

import com.zuehlke.adn.domain.ManagedApplication;
import java.io.File;

public class ArchiveRepositoryManager {
    private final File resourceRoot;
    private final ManagedApplication application;
    private final ArchiveFileFetcher fileFetcher;
    private final ArchiveUnpacker unpacker;

    public ArchiveRepositoryManager(File resourceRoot, ManagedApplication application, File tmpDirectory) {
        this.resourceRoot = resourceRoot;
        this.application = application;
        fileFetcher = new ArchiveFileFetcher();
        unpacker = new ArchiveUnpacker(tmpDirectory);
    }
    public ManagedApplication getApplication() {
        return application;
    }

    public File getResourceRoot() {
        return resourceRoot;
    }
    
    public boolean hasArchiveFile() {
        File archiveFile = getArchiveFile();
        return archiveFile.exists() && archiveFile.isFile();
    }
    public boolean hasRepositoryDirectoty() {
        File repositoryDirectory = getRepositoryDirectory();
        return repositoryDirectory.exists() && repositoryDirectory.isFile();
    }
    public void download() throws AppArchiveException {
        fileFetcher.download(application.getRepositoryUrl(), getArchiveFile());
    }
    
    public void unpack() throws AppArchiveException {
        unpacker.unpack(getArchiveFile(), getRepositoryDirectory());
    }

    private String getArchiveRoot() {
        return resourceRoot + "/archives";
    }
    private String getRepositoryRoot() {
        return resourceRoot + "/repositories";
    }

    private File getArchiveFile() {
        return new File(getArchiveRoot(), application.getArchiveFileName());
    }

    private File getRepositoryDirectory() {
        return new File(getRepositoryRoot(), application.getPath());
    }
}
