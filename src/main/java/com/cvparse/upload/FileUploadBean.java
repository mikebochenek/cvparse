package com.cvparse.upload;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
 
/**
 * http://showcase.richfaces.org/richfaces/component-sample.jsf?demo=fileUpload
 * 
 * FileUpload requires two context-parameter's to be set in web.xml:
 * createTempFiles boolean attribute which defines whether the uploaded 
 *   files are stored in temporary files or available in the listener directly as byte[] 
 *   data (false for this example).
 * maxRequestSize attribute defines max size in bytes of the uploaded files (1000000 for this example).
 * 
 * @author Ilya Shaikovsky
 */
@ManagedBean
@SessionScoped
public class FileUploadBean implements Serializable {
    private ArrayList<UploadedImage> files = new ArrayList<UploadedImage>();
 
    public void paint(OutputStream stream, Object object) throws IOException {
        stream.write(getFiles().get((Integer) object).getData());
        stream.close();
    }
 
    public void listener(FileUploadEvent event) throws Exception {
        UploadedFile item = event.getUploadedFile();
        UploadedImage file = new UploadedImage();
        file.setLength(item.getData().length);
        file.setName(item.getName());
        file.setData(item.getData());
        files.add(file);
    }
 
    public String clearUploadData() {
        files.clear();
        return null;
    }
 
    public int getSize() {
        if (getFiles().size() > 0) {
            return getFiles().size();
        } else {
            return 0;
        }
    }
 
    public long getTimeStamp() {
        return System.currentTimeMillis();
    }
 
    public ArrayList<UploadedImage> getFiles() {
        return files;
    }
 
    public void setFiles(ArrayList<UploadedImage> files) {
        this.files = files;
    }
}