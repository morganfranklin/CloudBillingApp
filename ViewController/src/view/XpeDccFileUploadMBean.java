package view;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.util.ResetUtils;

import oracle.jbo.domain.BlobDomain;

import org.apache.myfaces.trinidad.model.UploadedFile;

import view.utils.ADFUtils;

public class XpeDccFileUploadMBean implements Serializable {
    //private transient UploadedFile uploadedFile;
    private static final List<String> FILE_TYPE_LIST =
        new ArrayList<String>(Arrays.asList("GIF", "JPG", "PNG", "JPEG"));

    public XpeDccFileUploadMBean() {
        super();
    }


    //    public void setUploadedFile(UploadedFile uploadedFile) {
    //        this.uploadedFile = uploadedFile;
    //    }
    //
    //    public UploadedFile getUploadedFile() {
    //        return uploadedFile;
    //    }

    public void onDocUpload(ValueChangeEvent vce) {
        try {
            if (null != vce.getNewValue()) {
                //Get File Object from VC Event
                UploadedFile uploadedFile = (UploadedFile) vce.getNewValue();
                //                if (validateFileType()) {
                //                    this.setUploadedFile(null);
                //                    ADFUtils.showErrorMessage("Upload file of image types.");
                //                    return;
                //                }
                System.err.println("Name: " + uploadedFile.getFilename());
                System.err.println("Size: " + uploadedFile.getLength());
                System.err.println("Type: " + uploadedFile.getContentType());

                ADFUtils.setvalueToExpression("#{sessionScope.SIGNATURE}", createBlobDomain(uploadedFile));
                // Reset inputFile component after upload
                ResetUtils.reset(vce.getComponent());
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
            ADFUtils.showErrorMessage("Error while saving the data. Please contact system Administrator.");
        }
    }

    //    private boolean validateFileType() {
    //        boolean flag = false;
    //        if (null != this.getUploadedFile()) {
    //            String fileType =
    //                this.getUploadedFile().getFilename().substring(this.getUploadedFile().getFilename().lastIndexOf(".") +
    //                                                               1);
    //            if (!(FILE_TYPE_LIST.contains(fileType.toUpperCase())))
    //                flag = true;
    //        }
    //        return flag;
    //    }

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
