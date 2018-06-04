package model.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import oracle.xdo.template.FOProcessor;
import oracle.xdo.template.RTFProcessor;


public class FileOperations {
    public FileOperations() {
        super();
    }
    
    public static byte[] genPdfRep(byte[] pXmlOut, InputStream pTemplate) {

        byte[] pdfBytes = null;
        try {
            //Process RTF template to convert to XSL-FO format
            RTFProcessor rtfp = new RTFProcessor(pTemplate);
            ByteArrayOutputStream xslOutStream = new ByteArrayOutputStream();
            rtfp.setOutput(xslOutStream);
            rtfp.process();

            //Use XSL Template and Data from the VO to generate report and return the OutputStream of report
            ByteArrayInputStream xslInStream = new ByteArrayInputStream(xslOutStream.toByteArray());

            FOProcessor processor = new FOProcessor();
            
   
            ByteArrayInputStream dataStream = new ByteArrayInputStream(pXmlOut); 
                 
            processor.setData(dataStream);
            processor.setTemplate(xslInStream);

            ByteArrayOutputStream pdfOutStream = new ByteArrayOutputStream();
            processor.setOutput(pdfOutStream);
    
            processor.setOutputFormat(FOProcessor.FORMAT_PDF); 
            processor.generate();

            pdfBytes = pdfOutStream.toByteArray();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return pdfBytes;
    }
    
    public static InputStream getRTFAsInputStream(String templateName){      
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Templates/").append(templateName).append(".rtf");
            return  new FileInputStream(new File(sb.toString()));
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return null;
    }
}

