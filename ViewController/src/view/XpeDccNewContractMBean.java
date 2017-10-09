package view;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import model.XpeDccContractVersionViewRowImpl;

import model.views.entitybased.XpeDccNewContractsEOVOImpl;
import model.views.entitybased.XpeDccNewContractsEOVORowImpl;
import model.views.entitybased.XpeDmsCustomerEOVOImpl;
import model.views.entitybased.XpeDmsCustomerEOVORowImpl;
import model.views.readonly.XpeDccNewContractCustomerSearchROVOImpl;
import model.views.readonly.XpeDccNewContractCustomerSearchROVORowImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.ClobDomain;

import view.utils.ADFUtils;

public class XpeDccNewContractMBean implements Serializable {
    @SuppressWarnings("compatibility:-1676697804706803154")
    private static final long serialVersionUID = -7288355791642493247L;

    public XpeDccNewContractMBean() {
        super();
    }
    
    private XpeDccNewContractBBean getXpeDccNewContractBBean() {
        XpeDccNewContractBBean xpeDccNewContractBBean =
            (XpeDccNewContractBBean) ADFUtils.evaluateEL("#{backingBeanScope.XpeDccNewContractBBean}");
        return xpeDccNewContractBBean;
    }

    public void initializeVersionRow() {
        String contractType = (String)ADFUtils.evaluateEL("#{pageFlowScope.ContractType}");
        System.err.println("Contract Type: "+contractType);
        try {
            if ("NEW".equals(contractType)) {
                Long newContractRowCount =
                    (Long) ADFUtils.evaluateEL("#{bindings.XpeDccNewContractsEOVOIterator.estimatedRowCount}");
                System.err.println("newContractRowCount: " + newContractRowCount);
                if (newContractRowCount.intValue() == 0) {
                    XpeDccNewContractsEOVOImpl contractVo =
                        (XpeDccNewContractsEOVOImpl) ADFUtils.findViewObjectFromIteratorName("XpeDccNewContractsEOVOIterator");
                    XpeDccNewContractsEOVORowImpl contractRow =
                        (XpeDccNewContractsEOVORowImpl) contractVo.createAndInitRow(null);
                    System.out.println("contract Id-" + contractRow.getXpeContractId());
                    contractRow.setSetid("MODEL");
                    String customerType = ADFUtils.getValueFrmExpression("#{bindings.Customer_Type.attributeValue}");
                    System.err.println("customerType: " + customerType);
                    if ("NEW".equals(customerType)) {
                        XpeDmsCustomerEOVOImpl newCustomerVo =
                            (XpeDmsCustomerEOVOImpl) ADFUtils.findViewObjectFromIteratorName("XpeDmsCustomerEOVOIterator");
                        XpeDmsCustomerEOVORowImpl newCustomerRow =
                            (XpeDmsCustomerEOVORowImpl) newCustomerVo.getCurrentRow();
                        contractRow.setCustId(newCustomerRow.getCustId());
                    } else if ("EXT".equals(customerType)) {
                        XpeDccNewContractCustomerSearchROVOImpl existCustomerVo =
                            (XpeDccNewContractCustomerSearchROVOImpl) ADFUtils.findViewObjectFromIteratorName("XpeDccNewContractCustomerSearchROVOIterator");
                        XpeDccNewContractCustomerSearchROVORowImpl existCustomerRow =
                            (XpeDccNewContractCustomerSearchROVORowImpl) existCustomerVo.getCurrentRow();
                        contractRow.setCustId(existCustomerRow.getCustId());
                    }
                    XpeDccContractVersionViewRowImpl versionRow =
                        (XpeDccContractVersionViewRowImpl) contractRow.getXpeDccContractVersionView().createRow();
                    versionRow.setXpeContractVersion("V1");
                    contractVo.insertRow(contractRow);
                    contractRow.getXpeDccContractVersionView().insertRow(versionRow);
                } else {
                    XpeDccNewContractsEOVOImpl contractVo =
                        (XpeDccNewContractsEOVOImpl) ADFUtils.findViewObjectFromIteratorName("XpeDccNewContractsEOVOIterator");
                    XpeDccNewContractsEOVORowImpl contractRow =
                        (XpeDccNewContractsEOVORowImpl) contractVo.getCurrentRow();

                    String customerType = ADFUtils.getValueFrmExpression("#{bindings.Customer_Type.attributeValue}");
                    System.err.println("customerType: " + customerType);
                    if ("NEW".equals(customerType)) {
                        XpeDmsCustomerEOVOImpl newCustomerVo =
                            (XpeDmsCustomerEOVOImpl) ADFUtils.findViewObjectFromIteratorName("XpeDmsCustomerEOVOIterator");
                        XpeDmsCustomerEOVORowImpl newCustomerRow =
                            (XpeDmsCustomerEOVORowImpl) newCustomerVo.getCurrentRow();
                        contractRow.setCustId(newCustomerRow.getCustId());
                    } else if ("EXT".equals(customerType)) {
                        XpeDccNewContractCustomerSearchROVOImpl existCustomerVo =
                            (XpeDccNewContractCustomerSearchROVOImpl) ADFUtils.findViewObjectFromIteratorName("XpeDccNewContractCustomerSearchROVOIterator");
                        XpeDccNewContractCustomerSearchROVORowImpl existCustomerRow =
                            (XpeDccNewContractCustomerSearchROVORowImpl) existCustomerVo.getCurrentRow();
                        contractRow.setCustId(existCustomerRow.getCustId());
                    }
                }
            } else if ("UPDATE".equals(contractType)) {
                BindingContext bc = BindingContext.getCurrent();
                BindingContainer bindings = bc.getCurrentBindingsEntry();
                OperationBinding operationBinding = bindings.getOperationBinding("updateContract");
                if (null != operationBinding)
                    operationBinding.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void initializeNewLPCRow() {
//        Long lpcRowCount =
//            (Long) ADFUtils.evaluateEL("#{bindings.XpeDccNewContractLPCROVOIterator.estimatedRowCount}");
//        if (lpcRowCount.intValue() == 0)
//            ADFUtils.invokeEL("#{bindings.LPCCreateInsert.execute}");
        
        Long lineRowCount =
            (Long) ADFUtils.evaluateEL("#{bindings.XpeDccNewContractLineViewIterator.estimatedRowCount}");
        if (lineRowCount.intValue() == 0) {
            ADFUtils.invokeEL("#{bindings.LineCreateInsert.execute}");
//            ADFUtils.invokeEL("#{bindings.PricingCreateInsert.execute}");
//            ADFUtils.invokeEL("#{bindings.CarrierCreateInsert.execute}");
        }
        
    }

    public void initializeNewContractNotesRow() {
        Long notesRowCount =
            (Long) ADFUtils.evaluateEL("#{bindings.XpeDccNewContractNotesViewIterator.estimatedRowCount}");
        if (notesRowCount.intValue() == 0)
            ADFUtils.invokeEL("#{bindings.NotesCreateInsert.execute}");
    }

    public void onSubmit(ActionEvent actionEvent) {
        try {
            BindingContext bc = BindingContext.getCurrent();
            BindingContainer bindings = bc.getCurrentBindingsEntry();
            OperationBinding operationBinding = bindings.getOperationBinding("newContractCreation");
            if (null != operationBinding) {
                operationBinding.execute();
                if (null != operationBinding.getResult() &&
                    Boolean.parseBoolean(String.valueOf(operationBinding.getResult())) == true)
                    ADFUtils.setvalueToExpression("#{requestScope.contractCreation}", "success");
                else
                    ADFUtils.setvalueToExpression("#{requestScope.contractCreation}", null);
            } else {
                ADFUtils.setvalueToExpression("#{requestScope.contractCreation}", null);
                ADFUtils.showErrorMessage("Error while creating new contract. Please contact administrator.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ADFUtils.showErrorMessage("Error while creating new contract. Please contact administrator.");
        }
    }

    public String onSubmitAction() {
        return ADFUtils.getValueFrmExpression("#{requestScope.contractCreation}");
    }

    public void onCustomerTypeValueChange(ValueChangeEvent valueChangeEvent) {
        
        if(null!=valueChangeEvent && "NEW".equals(valueChangeEvent.getNewValue())){
            Long newCustomerCount =
                (Long) ADFUtils.evaluateEL("#{bindings.XpeDmsCustomerEOVOIterator.estimatedRowCount}");
            if(newCustomerCount.intValue()==0)
                ADFUtils.invokeEL("#{bindings.CreateInsert.execute}");
        }
    }
    
    public void onTermIdValueChange(ValueChangeEvent valueChangeEvent) {
        if (null != valueChangeEvent) {
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            try {
                BindingContext bc = BindingContext.getCurrent();
                BindingContainer bindings = bc.getCurrentBindingsEntry();
                OperationBinding operationBinding = bindings.getOperationBinding("fetchClauseForMasterTerm");
                if (null != operationBinding)
                    operationBinding.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onDescSelValueChange(ValueChangeEvent valueChangeEvent) {
        try {
            valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
            ClobDomain html = (ClobDomain) ADFUtils.evaluateEL("#{bindings.XpeDccTermTemplate.inputValue}");
            String tag =
                ADFUtils.getValueFrmExpression("#{bindings.RFF_TAG.selectedValue.attributeValues[1]}");
            System.err.println(tag);
            StringBuilder template = new StringBuilder(100);
            if (null != html && (int) html.getLength() > 0) {
                template.append(html.getSubString(1, (int) html.getLength()));
                template.append("{").append(tag).append("}");
            }else
                template.append("{").append(tag).append("}");
            ADFUtils.setvalueToExpression("#{bindings.XpeDccTermTemplate.inputValue}",
                                          new ClobDomain(template.toString()));
                
            System.err.println("HTML: " + template.toString());

        } catch (Exception ex) {
            // TODO: Add catch code
            ex.printStackTrace();
        }
    }

    public void onReviewHTML(ActionEvent actionEvent) {

        try {
            ClobDomain html = (ClobDomain) ADFUtils.evaluateEL("#{bindings.XpeDccTermTemplate.inputValue}");
            Reader initialReader = html.getCharacterStream();

            char[] charBuffer = new char[8 * 1024];
            StringBuilder htmlBuilder = new StringBuilder();
            int numCharsRead;
            while ((numCharsRead = initialReader.read(charBuffer, 0, charBuffer.length)) != -1) {
                htmlBuilder.append(charBuffer, 0, numCharsRead);
            }
            initialReader.close();
            replaceHtml(htmlBuilder.toString());

            this.getXpeDccNewContractBBean().getHtml_popup().show(new RichPopup.PopupHints());
        } catch (IOException ioe) {
            // TODO: Add catch code
            ioe.printStackTrace();
        }
    }

    private void replaceHtml(String htmlString) {
        ADFUtils.setvalueToExpression("#{pageFlowScope.html}", null);
        if (null != htmlString && htmlString.length() > 0) {
            String customerType = ADFUtils.getValueFrmExpression("#{bindings.Customer_Type.attributeValue}");
            System.err.println("customerType: "+customerType);
            if ("NEW".equals(customerType))
                htmlString = htmlString.replaceAll("\\{CUSTOMER NAME\\}",
                                          (String) ADFUtils.evaluateEL("#{bindings.CompanyName.inputValue}"));
            else if ("EXT".equals(customerType))
                htmlString = htmlString.replaceAll("\\{CUSTOMER NAME\\}",
                                          (String) ADFUtils.evaluateEL("#{bindings.CustomerName.inputValue}"));
            
            htmlString = htmlString.replaceAll("\\{WASTE TYPE\\}",  ADFUtils.getValueFrmExpression("#{bindings.XpeWasteType.inputValue}"));
            htmlString = htmlString.replaceAll("\\{CONTRACT SUB TYPE\\}",  ADFUtils.getValueFrmExpression("#{bindings.XpeContractSubType.inputValue}"));
            htmlString = htmlString.replaceAll("\\{AGREEMENT TYPE\\}",  ADFUtils.getValueFrmExpression("#{bindings.XpeAgreementType.inputValue}"));
            ADFUtils.setvalueToExpression("#{pageFlowScope.html}", htmlString);
        }
    }
    
    public void buildPDF(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PDF", FileOperations.genPdfRep(buildXML(), FileOperations.getRTFAsInputStream(getTemplateName())));
    }
    
    
    private byte[] buildXML(){
        byte[] dataBytes = null;
        try {
            StringBuilder xmlBuilder = new StringBuilder();
            xmlBuilder.append("<CONTRACT_DETAILS>");
            xmlBuilder.append("<CONTRACT_DETAILS_ROW>");
            String customerType = ADFUtils.getValueFrmExpression("#{bindings.Customer_Type.attributeValue}");
            System.err.println("customerType: "+customerType);
            if ("NEW".equals(customerType)){
                xmlBuilder.append("<CUSTOMER_ID>").append("NEW").append("</CUSTOMER_ID>");
                xmlBuilder.append("<CUSTOMER_NAME>").append(ADFUtils.getValueFrmExpression("#{bindings.CompanyName.inputValue}")).append("</CUSTOMER_NAME>");
                xmlBuilder.append("<CUSTOMER_ADDRESS>").append(ADFUtils.getValueFrmExpression("#{bindings.MailingAddress1.inputValue}")).append("</CUSTOMER_ADDRESS>");
                xmlBuilder.append("<CUSTOMER_ADDRESS1>").append(ADFUtils.getValueFrmExpression("#{bindings.MailingAddress2.inputValue}")).append("</CUSTOMER_ADDRESS1>");
                xmlBuilder.append("<CITY>").append(ADFUtils.getValueFrmExpression("#{bindings.MailingCity.inputValue}")).append("</CITY>");
                xmlBuilder.append("<STATE>").append(ADFUtils.getValueFrmExpression("#{bindings.MailingState.inputValue}")).append("</STATE>");
                xmlBuilder.append("<POSTAL_CODE>").append(ADFUtils.getValueFrmExpression("#{bindings.MailingPostal.inputValue}")).append("</POSTAL_CODE>");
                
                xmlBuilder.append("<CONTACT_NAME>").append(ADFUtils.getValueFrmExpression("#{bindings.ContactName.inputValue}")).append("</CONTACT_NAME>");
                xmlBuilder.append("<CONTACT_TITLE>").append(ADFUtils.getValueFrmExpression("#{bindings.Title.inputValue}")).append("</CONTACT_TITLE>");
                xmlBuilder.append("<CONTACT_PHONE>").append(ADFUtils.getValueFrmExpression("#{bindings.PhoneNum.inputValue}")).append("</CONTACT_PHONE>");
                xmlBuilder.append("<CONTACT_EMAIL>").append(ADFUtils.getValueFrmExpression("#{bindings.Email.inputValue}")).append("</CONTACT_EMAIL>");
                
                xmlBuilder.append("<BILLING_ADDRESS1>").append(ADFUtils.getValueFrmExpression("#{bindings.BillingAddress1.inputValue}")).append("</BILLING_ADDRESS1>");
                xmlBuilder.append("<BILLING_ADDRESS2>").append(ADFUtils.getValueFrmExpression("#{bindings.BillingAddress2.inputValue}")).append("</BILLING_ADDRESS2>");
                xmlBuilder.append("<BILLING_CITY>").append(ADFUtils.getValueFrmExpression("#{bindings.City.inputValue}")).append("</BILLING_CITY>");
                xmlBuilder.append("<BILLING_STATE>").append(ADFUtils.getValueFrmExpression("#{bindings.State.inputValue}")).append("</BILLING_STATE>");
                xmlBuilder.append("<BILLING_POSTAL_CODE>").append(ADFUtils.getValueFrmExpression("#{bindings.Postal.inputValue}")).append("</BILLING_POSTAL_CODE>");
            }else if ("EXT".equals(customerType)){
                xmlBuilder.append("<CUSTOMER_NAME>").append(ADFUtils.getValueFrmExpression("#{bindings.EXTCustomerName.inputValue}")).append("</CUSTOMER_NAME>");
                //xmlBuilder.append("<CONTACT_NAME>").append(ADFUtils.getValueFrmExpression("#{bindings.ContactName.inputValue}")).append("</CONTACT_NAME>");
                xmlBuilder.append("<CUSTOMER_ADDRESS>").append(ADFUtils.getValueFrmExpression("#{bindings.EXTAddress1.inputValue}")).append("</CUSTOMER_ADDRESS>");
                xmlBuilder.append("<CITY>").append(ADFUtils.getValueFrmExpression("#{bindings.EXTCity.inputValue}")).append("</CITY>");
                xmlBuilder.append("<STATE>").append(ADFUtils.getValueFrmExpression("#{bindings.EXTState.inputValue}")).append("</STATE>");
                xmlBuilder.append("<POSTAL_CODE>").append(ADFUtils.getValueFrmExpression("#{bindings.EXTPostal.inputValue}")).append("</POSTAL_CODE>");
                xmlBuilder.append("<CUSTOMER_ID>").append(ADFUtils.getValueFrmExpression("#{bindings.CustId.inputValue}")).append("</CUSTOMER_ID>");
            }
            xmlBuilder.append("<BUSINESS_TYPE>").append(ADFUtils.getValueFrmExpression("#{bindings.Business_Type.attributeValue}")).append("</BUSINESS_TYPE>");
            xmlBuilder.append("<AS_OF_DATE>").append(formatDate(ADFUtils.getValueFrmExpression("#{bindings.XpeAsOfDate.inputValue}"))).append("</AS_OF_DATE>");
            xmlBuilder.append("<FROM_DATE>").append(formatDate(ADFUtils.getValueFrmExpression("#{bindings.XpeStartDate.inputValue}"))).append("</FROM_DATE>");
            xmlBuilder.append("<TO_DATE>").append(formatDate(ADFUtils.getValueFrmExpression("#{bindings.XpeEndDate.inputValue}"))).append("</TO_DATE>");
            xmlBuilder.append("<USER_NAME>").append(ADFUtils.getValueFrmExpression("#{bindings.XpeUser.inputValue}")).append("</USER_NAME>");
            xmlBuilder.append("<CUSTOMER_NOTES>").append(ADFUtils.getValueFrmExpression("#{bindings.XpeNote.inputValue}")).append("</CUSTOMER_NOTES>");
            xmlBuilder.append("</CONTRACT_DETAILS_ROW>");
            xmlBuilder.append("</CONTRACT_DETAILS>");

            System.out.println(xmlBuilder.toString());

            dataBytes = xmlBuilder.toString().getBytes();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return dataBytes;
    }
    
    private String getTemplateName() {
        String templateName = null;
        String wasteType = ADFUtils.getValueFrmExpression("#{bindings.XpeWasteType.inputValue}");
        String contractSubType = ADFUtils.getValueFrmExpression("#{bindings.XpeContractSubType.inputValue}");
        String agreementType = ADFUtils.getValueFrmExpression("#{bindings.XpeAgreementType.inputValue}");
        if (null != wasteType && null != contractSubType) {
            if ("MTL".equals(wasteType) && "FRS".equals(contractSubType)) 
                templateName = "OGI - Ferrous Purchase Sale Agreement spot v12-21-14";
            else if ("MTL".equals(wasteType) && "NFR".equals(contractSubType)) 
                templateName = "OGI - Non-Ferrous Purchase Sale Agreement spot v12-21-14";
            else if ("MSW".equals(wasteType) && "PMM".equals(contractSubType) && null!=agreementType && ("PC".equals(agreementType) || "PNC".equals(agreementType)))
                templateName = "Covanta - Spot-Premium Contract Template v2";
            else if ("MSW".equals(wasteType) && "SPT".equals(contractSubType))
                templateName = "Covanta - Spot-Premium Contract Template v2";
        }
        return templateName;
    }
    
    private String formatDate(String dateInString) {
           SimpleDateFormat dateFormat = new SimpleDateFormat(
                   "yyyy-MM-dd hh:mm:ss");
           SimpleDateFormat  formatter = new SimpleDateFormat("MM/dd/yyyy");
        try {
            if (null != dateInString) {
                Date date = dateFormat.parse(dateInString);
                System.out.println(date);
                return formatter.format(date);
            }
        } catch (ParseException e) {
               e.printStackTrace();
           }
          return null;
       }
}
