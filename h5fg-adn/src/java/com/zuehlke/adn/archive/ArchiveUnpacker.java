package com.zuehlke.adn.archive;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ArchiveUnpacker {
    public static final int BUFFER_SIZE = 1024;
    private final File tmpDirectory;

    public ArchiveUnpacker(File tmpDirectory) {
        this.tmpDirectory = tmpDirectory;
    }
    
    
    public synchronized void unpack(File archiveFile, File targetDirectory) throws AppArchiveException {
        try {
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(archiveFile)));
            ZipEntry entry = null;
            while ((entry = zis.getNextEntry()) != null) {
                File targetFile = new File(tmpDirectory, entry.getName());
                if (entry.isDirectory()) {
                    targetFile.mkdir();
                } else {
                    extractEntry(targetFile, zis);
                }
            }
            moveExtractedArchive(tmpDirectory, targetDirectory);
        } catch (IOException ex) {
            throw new AppArchiveException(ex);
        }
        
    }

    private void extractEntry(File targetFile, ZipInputStream zis) throws FileNotFoundException, IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile), BUFFER_SIZE);
        int byteRead = 0;
        byte[] data = new byte[BUFFER_SIZE];
        while ((byteRead = zis.read(data, 0, BUFFER_SIZE)) != -1) {
            bos.write(data, 0, byteRead);
        }
        bos.flush();
        bos.close();
    }

    private synchronized void moveExtractedArchive(File tmpDirectory, File targetDirectory) throws AppArchiveException {
        File[] files = tmpDirectory.listFiles();
        if (files.length > 1) {
            files[0].renameTo(targetDirectory);
        } else {
            throw new AppArchiveException("multiple files in root of archive not supported. Please repack your archive file in github style. " + files);
        }
        
    }
}
