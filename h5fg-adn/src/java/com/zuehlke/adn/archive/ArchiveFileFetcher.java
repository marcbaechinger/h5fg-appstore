package com.zuehlke.adn.archive;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ArchiveFileFetcher {
    
    public void download(String url, File target) throws AppArchiveException {
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                FileOutputStream fos = new FileOutputStream(target);
                byte[] buffer = new byte[2048];
                int len = 0;
                try {
                    while ((len = instream.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                    }
                } finally {
                    instream.close();
                }
            }
        } catch (IOException ex) {
            throw new AppArchiveException(ex);
        } 
    }
}
