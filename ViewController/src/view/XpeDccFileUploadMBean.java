package view;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import oracle.jbo.domain.BlobDomain;

import org.apache.myfaces.trinidad.model.UploadedFile;

import view.utils.ADFUtils;

public class XpeDccFileUploadMBean implements Serializable {
    private transient UploadedFile uploadedFile;
    private static final List<String> FILE_TYPE_LIST =
        new ArrayList<String>(Arrays.asList("GIF", "JPG", "PNG", "JPEG"));

    public XpeDccFileUploadMBean() {
        super();
    }


    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void onDocUpload() {
        try {
            if (null != this.getUploadedFile()) {
                if (validateFileType()) {
                    this.setUploadedFile(null);
                    ADFUtils.showErrorMessage("ATTACH_DOCUMENT_OF_MENTIONED_TYPES");
                    return;
                }
                System.err.println("Name: " + this.getUploadedFile().getFilename());
                System.err.println("Size: " + this.getUploadedFile().getLength());
                System.err.println("Type: " + this.getUploadedFile().getContentType());
                String filename =
                    this.getUploadedFile().getFilename().substring(0,
                                                                   this.getUploadedFile().getFilename().lastIndexOf("."));
                String fileType =
                    this.getUploadedFile().getFilename().substring(this.getUploadedFile().getFilename().lastIndexOf(".") +
                                                                   1);
                ADFUtils.setvalueToExpression("#{sessionScope.SIGNATURE}", createBlobDomain(this.getUploadedFile()));

            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            ADFUtils.showErrorMessage("CONTACT_ADMINISTRATOR");
        }
    }

    private boolean validateFileType() {
        boolean flag = false;
        if (null != this.getUploadedFile()) {
            String fileType =
                this.getUploadedFile().getFilename().substring(this.getUploadedFile().getFilename().lastIndexOf(".") +
                                                               1);
            if (!(FILE_TYPE_LIST.contains(fileType.toUpperCase())))
                flag = true;
        }
        return flag;
    }
    
    /**Method to create blobdomain for uploaded file**/
    private BlobDomain createBlobDomain(UploadedFile file) {
        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;

        try {
            in = file.getInputStream();

            blobDomain = new BlobDomain();
            out = blobDomain.getBinaryOutputStream();
            byte[] buffer = new byte[8192];
            int bytesRead = 0;

            while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }

        return blobDomain;
    }
}
