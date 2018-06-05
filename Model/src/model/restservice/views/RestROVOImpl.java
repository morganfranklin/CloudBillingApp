package model.restservice.views;

import java.util.Map;

import model.AppModuleImpl;


import model.restservice.views.common.RestROVO;

import model.utils.FileOperations;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu May 31 23:21:13 EDT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RestROVOImpl extends ViewObjectImpl implements RestROVO {
    /**
     * This is the default constructor (do not remove).
     */
    public RestROVOImpl() {
    }
    
    public String contractApprovalRejectFlow(String uuId, String userType, String action){
        String response = "FAILED";
        try {
            AppModuleImpl appModule = (AppModuleImpl) this.getDBTransaction().getRootApplicationModule();
            Map pdfDetailsMap = appModule.fetchPDFXML(uuId, userType, action);
            if (null != pdfDetailsMap && pdfDetailsMap.size() > 1) {
                byte[] emailPdf = null, contractCoverSheetPdf = null;
                emailPdf =
                    FileOperations.genPdfRep(String.valueOf(pdfDetailsMap.get("XML")).getBytes(),
                                             FileOperations.getRTFAsInputStream(String.valueOf(pdfDetailsMap.get("TEMPLATE_NAME"))));
                if (pdfDetailsMap.size() == 4)
                    contractCoverSheetPdf =
                        FileOperations.genPdfRep(String.valueOf(pdfDetailsMap.get("COVER_SHEET_XML")).getBytes(),
                                                 FileOperations.getRTFAsInputStream(String.valueOf(pdfDetailsMap.get("COVER_SHEET_TEMPLATE_NAME"))));
                //updating contract status
                appModule.updateContractApprovalStatus(uuId, action, emailPdf, userType, contractCoverSheetPdf);
                response="SUCCESS";
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return response;
    }
}

