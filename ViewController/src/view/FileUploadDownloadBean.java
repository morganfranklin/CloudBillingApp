package view;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.SQLException;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputFile;

import oracle.jbo.domain.BlobDomain;

import org.apache.myfaces.trinidad.model.UploadedFile;


public class FileUploadDownloadBean {
    public FileUploadDownloadBean() {
        super();
    }
    private RichInputFile inputFile;
    private String fileName;
    private String contentType;
    private UploadedFile file;
    private BlobDomain blob;

    public void downloadFile(FacesContext facesContext, OutputStream outputStream) {
        DCBindingContainer bindings = getDCBindingContainer();
        DCIteratorBinding iteratorbinding = bindings.findIteratorBinding("XpeDccContractsAttachmentsView1Iterator");
        BlobDomain blob = (BlobDomain) iteratorbinding.getCurrentRow().getAttribute("UploadFile");
        try {
            copy(blob.getInputStream(), outputStream);
            blob.closeInputStream();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onFileUploadVCL(ValueChangeEvent valueChangeEvent) {
        file = (UploadedFile) valueChangeEvent.getNewValue();
        // Get the file name
        fileName = file.getFilename();
        // get the mime type
        contentType = file.getContentType();
        // get blob
        blob = getBlob(file);
    }

    public BlobDomain getBlob(UploadedFile file) {
        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;
        try {
            in = file.getInputStream();
            blobDomain = new BlobDomain();
            out = blobDomain.getBinaryOutputStream();
            copy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
        return blobDomain;
    }

    public void onFileUpload(ActionEvent actionEvent) {
        oracle.binding.BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationbinding = (OperationBinding) bindings.getOperationBinding("uploadFiletoDB");
        //   OperationBinding operationbinding = getOperationBinding("uploadFiletoDB");
        if (operationbinding != null) {
            operationbinding.getParamsMap().put("filename", fileName);
            operationbinding.getParamsMap().put("blob", blob);
            operationbinding.execute();
        }
        System.out.println("File uploaded successfully");
        if (inputFile != null) {
            inputFile.resetValue();
            inputFile.setValid(true);
        }
    }


    public static int copy(InputStream input, OutputStream output) throws IOException {
        long count = copyLarge(input, output);
        if (count > 2147483647L) {
            return -1;
        }
        return (int) count;
    }

    public static long copyLarge(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte['?'];
        long count = 0L;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }


    public static DCIteratorBinding findIterator(String name) {
        DCIteratorBinding iter = getDCBindingContainer().findIteratorBinding(name);
        if (iter == null) {
            throw new RuntimeException("Iterator '" + name + "' not found");
        }
        return iter;
    }

    public static DCBindingContainer getDCBindingContainer() {
        return (DCBindingContainer) getBindingContainer();
    }

    public static oracle.binding.BindingContainer getBindingContainer() {
        return (oracle.binding.BindingContainer) resolveExpression("#{bindings}");
    }

    public static Object resolveExpression(String expression) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
        return valueExp.getValue(elContext);
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public void setInputFile(RichInputFile inputFile) {
        this.inputFile = inputFile;
    }

    public RichInputFile getInputFile() {
        return inputFile;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setBlob(BlobDomain blob) {
        this.blob = blob;
    }

    public BlobDomain getBlob() {
        return blob;
    }
}
