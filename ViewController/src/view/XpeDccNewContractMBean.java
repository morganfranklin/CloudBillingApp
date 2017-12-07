package view;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;

import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

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
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryOperationEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.domain.ClobDomain;

import view.utils.ADFUtils;

public class XpeDccNewContractMBean implements Serializable {
    @SuppressWarnings("compatibility:-1676697804706803154")
    private static final long serialVersionUID = -7288355791642493247L;
    private String contractId;
    private String contractVersion;

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractVersion(String contractVersion) {
        this.contractVersion = contractVersion;
    }

    public String getContractVersion() {
        return contractVersion;
    }

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
            } else if ("UPDATE".equals(contractType) || "BLS".equals(contractType)) {
                String contractId = ADFUtils.getValueFrmExpression("#{bindings.XpeContractId.inputValue}");
                String contractVersion = ADFUtils.getValueFrmExpression("#{bindings.XpeContractVersion.inputValue}");
                if((null==this.getContractId() && null==this.getContractVersion()) || !(contractId.equalsIgnoreCase(this.getContractId()) && contractVersion.equalsIgnoreCase(this.getContractVersion()))){
                    DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
                    OperationBinding operationBinding = bindings.getOperationBinding("createNewContractVersion");
                    if (null != operationBinding) {
                        String newContractVersion = (String) operationBinding.execute();
                        if (null != newContractVersion) {
                            DCIteratorBinding contractVersionIterator =
                                bindings.findIteratorBinding("XpeDccNewContractVersionViewIterator");
                            Key key = new Key(new Object[] { contractId, newContractVersion });
                            Row[] rows = contractVersionIterator.getRowSetIterator().findByKey(key, 1);

                            if (rows.length > 0) {
                                contractVersionIterator.setCurrentRowWithKey(rows[0].getKey().toStringFormat(true));
                                this.setContractId(contractId);
                                this.setContractVersion(contractVersion);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initializeNewLPCRow() {
        /*String contractType = (String) ADFUtils.evaluateEL("#{pageFlowScope.ContractType}");
        System.err.println("Contract Type: " + contractType);
        try {
            if ("NEW".equals(contractType)) {
                Long lineRowCount =
                    (Long) ADFUtils.evaluateEL("#{bindings.XpeDccNewContractLineViewIterator.estimatedRowCount}");
                if (lineRowCount.intValue() == 0)
                    ADFUtils.invokeEL("#{bindings.LineCreateInsert.execute}");
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }*/
    }

    public void initializeNewContractNotesRow() {
        String contractType = (String) ADFUtils.evaluateEL("#{pageFlowScope.ContractType}");
        System.err.println("Contract Type: " + contractType);
        try {
            if ("NEW".equals(contractType)) {
                Long notesRowCount =
                    (Long) ADFUtils.evaluateEL("#{bindings.XpeDccNewContractNotesViewIterator.estimatedRowCount}");
                if (notesRowCount.intValue() == 0)
                    ADFUtils.invokeEL("#{bindings.NotesCreateInsert.execute}");
            }else if("UPDATE".equals(contractType)){
                Long notesRowCount =
                    (Long) ADFUtils.evaluateEL("#{bindings.XpeDccNewContractNotesViewIterator.estimatedRowCount}");
                if (notesRowCount.intValue() == 0)
                    ADFUtils.invokeEL("#{bindings.NotesCreateInsert.execute}");
            }
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    public void onSubmit(ActionEvent actionEvent) {
        try {
            BindingContext bc = BindingContext.getCurrent();
            BindingContainer bindings = bc.getCurrentBindingsEntry();
            OperationBinding operationBinding = bindings.getOperationBinding("newContractCreation");
            if (null != operationBinding) {
                byte[] bytes = null;
                if(null!=FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PDF"))
                    bytes = (byte[])FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PDF");
                operationBinding.getParamsMap().put("bytes", bytes);
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
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getXpeDccNewContractBBean().getTermTemplateRTE());

        } catch (Exception ex) {
            // TODO: Add catch code
            ex.printStackTrace();
        }
    }

    public void onReviewHTML(ActionEvent actionEvent) {

        try {
            ClobDomain html = (ClobDomain) ADFUtils.evaluateEL("#{bindings.XpeDccTermTemplate.inputValue}");

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PDF", FileOperations.genPdfRep(buildXML(replaceHtml(convertClobToString(html))), FileOperations.getRTFAsInputStream("TermPreview")));
            this.getXpeDccNewContractBBean().getHtml_popup().show(new RichPopup.PopupHints());
        } catch (Exception ex) {
            // TODO: Add catch code
            ex.printStackTrace();
        }
    }

    private String replaceHtml(String htmlString) {
        //ADFUtils.setvalueToExpression("#{pageFlowScope.html}", null);
        if (null != htmlString && htmlString.length() > 0) {
            String customerType = ADFUtils.getValueFrmExpression("#{bindings.Customer_Type.attributeValue}");
            System.err.println("customerType: "+customerType);
            if ("NEW".equals(customerType))
                htmlString = htmlString.replaceAll("\\{CUSTOMER NAME\\}",
                                          (String) ADFUtils.evaluateEL("#{bindings.CompanyName.inputValue}"));
            else if ("EXT".equals(customerType))
                htmlString = htmlString.replaceAll("\\{CUSTOMER NAME\\}",
                                          (String) ADFUtils.evaluateEL("#{bindings.CustomerName.inputValue}"));
            else
                htmlString = htmlString.replaceAll("\\{CUSTOMER NAME\\}",
                                          (String) ADFUtils.evaluateEL("#{bindings.Name1.inputValue}"));
            
            htmlString = htmlString.replaceAll("\\{WASTE TYPE\\}",  ADFUtils.getValueFrmExpression("#{bindings.XpeWasteType.inputValue}"));
            htmlString = htmlString.replaceAll("\\{CONTRACT SUB TYPE\\}",  ADFUtils.getValueFrmExpression("#{bindings.XpeContractSubType.inputValue}"));
            htmlString = htmlString.replaceAll("\\{AGREEMENT TYPE\\}",  ADFUtils.getValueFrmExpression("#{bindings.XpeAgreementType.inputValue}"));
            //ADFUtils.setvalueToExpression("#{pageFlowScope.html}", htmlString);
        }
        return htmlString;
    }
    
    public void buildPDF(){
        try {
            BindingContext bc = BindingContext.getCurrent();
            BindingContainer bindings = bc.getCurrentBindingsEntry();
            OperationBinding operationBinding = bindings.getOperationBinding("buildXML");
            if (null != operationBinding){
                Map pdf = (Map)operationBinding.execute();
                if(null!=pdf && pdf.size()>1)
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PDF", FileOperations.genPdfRep(String.valueOf(pdf.get("XML")).getBytes(), FileOperations.getRTFAsInputStream(String.valueOf(pdf.get("TEMPLATE_NAME")))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;

        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
        } catch (IOException ioe) {
            // TODO: Add catch code
            ioe.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException ioe) {
                // TODO: Add catch code
                ioe.printStackTrace();
            }
        }

        return bytes;
    }*/
    
    
    private byte[] buildXML(String html){
        byte[] dataBytes = null;
        String xmlTag = "<?xml version=\"1.0\" encoding=\"windows-1252\"?>";
        try {
            StringBuilder xmlBuilder = new StringBuilder();
            xmlBuilder.append(xmlTag);
            xmlBuilder.append("<TERM_DETAILS>");
            xmlBuilder.append("<TERM_DETAILS_ROW>");
            xmlBuilder.append("<HTML_TEXT>").append("<![CDATA[").append(html).append("]]>").append("</HTML_TEXT>");
            xmlBuilder.append("</TERM_DETAILS_ROW>");
            xmlBuilder.append("</TERM_DETAILS>");

            System.out.println(xmlBuilder.toString());

            dataBytes = xmlBuilder.toString().getBytes();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return dataBytes;
    }
    
    /*private byte[] buildXML(){
        byte[] dataBytes = null;
        String xmlTag = "<?xml version=\"1.0\" encoding=\"windows-1252\"?>";
        try {
            StringBuilder xmlBuilder = new StringBuilder();
            xmlBuilder.append(xmlTag);
            xmlBuilder.append("<CONTRACT_DETAILS>");
            xmlBuilder.append("<CONTRACT_DETAILS_ROW>");
            String customerType = ADFUtils.getValueFrmExpression("#{bindings.Customer_Type.attributeValue}");
            System.err.println("customerType: "+customerType);
            if ("NEW".equals(customerType)){
                xmlBuilder.append("<CUSTOMER_ID>").append("NEW").append("</CUSTOMER_ID>");
                xmlBuilder.append("<CUSTOMER_NAME>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.CompanyName.inputValue}"))).append("</CUSTOMER_NAME>");
                xmlBuilder.append("<CUSTOMER_ADDRESS>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.MailingAddress1.inputValue}"))).append("</CUSTOMER_ADDRESS>");
                xmlBuilder.append("<CUSTOMER_ADDRESS1>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.MailingAddress2.inputValue}"))).append("</CUSTOMER_ADDRESS1>");
                xmlBuilder.append("<CITY>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.MailingCity.inputValue}"))).append("</CITY>");
                xmlBuilder.append("<STATE>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.MailingState.inputValue}"))).append("</STATE>");
                xmlBuilder.append("<POSTAL_CODE>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.MailingPostal.inputValue}"))).append("</POSTAL_CODE>");
                
                xmlBuilder.append("<CONTACT_NAME>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.ContactName.inputValue}"))).append("</CONTACT_NAME>");
                xmlBuilder.append("<CONTACT_TITLE>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.Title.inputValue}"))).append("</CONTACT_TITLE>");
                xmlBuilder.append("<CONTACT_PHONE>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.PhoneNum.inputValue}"))).append("</CONTACT_PHONE>");
                xmlBuilder.append("<CONTACT_EMAIL>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.Email.inputValue}"))).append("</CONTACT_EMAIL>");
                
                xmlBuilder.append("<BILLING_ADDRESS1>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.BillingAddress1.inputValue}"))).append("</BILLING_ADDRESS1>");
                xmlBuilder.append("<BILLING_ADDRESS2>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.BillingAddress2.inputValue}"))).append("</BILLING_ADDRESS2>");
                xmlBuilder.append("<BILLING_CITY>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.City.inputValue}"))).append("</BILLING_CITY>");
                xmlBuilder.append("<BILLING_STATE>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.State.inputValue}"))).append("</BILLING_STATE>");
                xmlBuilder.append("<BILLING_POSTAL_CODE>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.Postal.inputValue}"))).append("</BILLING_POSTAL_CODE>");
            }else if ("EXT".equals(customerType)){
                xmlBuilder.append("<CUSTOMER_NAME>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.EXTCustomerName.inputValue}"))).append("</CUSTOMER_NAME>");
                //xmlBuilder.append("<CONTACT_NAME>").append(ADFUtils.getValueFrmExpression("#{bindings.ContactName.inputValue}")).append("</CONTACT_NAME>");
                xmlBuilder.append("<CUSTOMER_ADDRESS>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.EXTAddress1.inputValue}"))).append("</CUSTOMER_ADDRESS>");
                xmlBuilder.append("<CITY>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.EXTCity.inputValue}"))).append("</CITY>");
                xmlBuilder.append("<STATE>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.EXTState.inputValue}"))).append("</STATE>");
                xmlBuilder.append("<POSTAL_CODE>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.EXTPostal.inputValue}"))).append("</POSTAL_CODE>");
                xmlBuilder.append("<CUSTOMER_ID>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.CustId.inputValue}"))).append("</CUSTOMER_ID>");
            }
            xmlBuilder.append("<BUSINESS_TYPE>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.Business_Type.attributeValue}"))).append("</BUSINESS_TYPE>");
            xmlBuilder.append("<AS_OF_DATE>").append(formatDate(ADFUtils.getValueFrmExpression("#{bindings.XpeAsOfDate.inputValue}"))).append("</AS_OF_DATE>");
            xmlBuilder.append("<FROM_DATE>").append(formatDate(ADFUtils.getValueFrmExpression("#{bindings.XpeStartDate.inputValue}"))).append("</FROM_DATE>");
            xmlBuilder.append("<TO_DATE>").append(formatDate(ADFUtils.getValueFrmExpression("#{bindings.XpeEndDate.inputValue}"))).append("</TO_DATE>");
            xmlBuilder.append("<USER_NAME>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.XpeUser.inputValue}"))).append("</USER_NAME>");
            xmlBuilder.append("<CUSTOMER_NOTES>").append(checkIfNull(ADFUtils.getValueFrmExpression("#{bindings.XpeNote.inputValue}"))).append("</CUSTOMER_NOTES>");
            
            xmlBuilder = buildXMLForTerms(xmlBuilder);
            
            xmlBuilder.append("</CONTRACT_DETAILS_ROW>");
            xmlBuilder.append("</CONTRACT_DETAILS>");

            System.out.println(xmlBuilder.toString());

            dataBytes = xmlBuilder.toString().getBytes();
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return dataBytes;
    }*/
    
    /*public StringBuilder buildXMLForTerms(StringBuilder xmlBuilder){
        try {
            XpeDccTermsContractEOVOImpl xpeDccTermsContractEOVO = (XpeDccTermsContractEOVOImpl)ADFUtils.findViewObjectFromIteratorName("XpeDccTermsContractEOVOIterator");
            RowSetIterator rowsetIterator = xpeDccTermsContractEOVO.createRowSetIterator(null);
            while(rowsetIterator.hasNext()){
                XpeDccTermsContractEOVORowImpl xpeDccTermsContractEOVORow =(XpeDccTermsContractEOVORowImpl)rowsetIterator.next();
            xmlBuilder.append("<TERM_DETAILS_ROW>");
            xmlBuilder.append("<HTML_TEXT>").append("<![CDATA[").append(replaceHtml(convertClobToString(xpeDccTermsContractEOVORow.getXpeDccTermTemplate()))).append("]]>").append("</HTML_TEXT>");
            xmlBuilder.append("</TERM_DETAILS_ROW>");
            }
            System.out.println(xmlBuilder.toString());
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        return xmlBuilder;
    }*/
    
    /*private String getTemplateName() {
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
    }*/
    
    /*private String formatDate(String dateInString) {
           SimpleDateFormat dateFormat = new SimpleDateFormat(
                   "yyyy-MM-dd hh:mm:ss");
           SimpleDateFormat  formatter = new SimpleDateFormat("MM/dd/yyyy");
        try {
            if (null != dateInString && dateInString.trim().length()>0) {
                Date date = dateFormat.parse(dateInString);
                System.out.println(date);
                return formatter.format(date);
            }
        } catch (ParseException e) {
               e.printStackTrace();
           }
          return "";
       }*/

    private String convertClobToString(ClobDomain html) {
        StringBuilder htmlBuilder = new StringBuilder();
        try {
            Reader initialReader = html.getCharacterStream();
            char[] charBuffer = new char[8 * 1024];
            int numCharsRead;
            while ((numCharsRead = initialReader.read(charBuffer, 0, charBuffer.length)) != -1) {
                htmlBuilder.append(charBuffer, 0, numCharsRead);
            }
            initialReader.close();
        } catch (IOException ioe) {
            // TODO: Add catch code
            ioe.printStackTrace();
        }
        return htmlBuilder.toString();
    }
    
    /*private String checkIfNull(String val){ 
        if(null==val || val.trim().length()==0)
          return "";
        else
         return val;
    }*/

    public void contractQueryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.ImplicitViewCriteriaQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccContractSearchROVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getXpeDccNewContractBBean().getContractSearchROVOTblBind());
        }
    }
    
    public Object invokeMethodExpression(String expr, Class returnType, Class[] argTypes, Object[] args) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr = elFactory.createMethodExpression(elctx, expr, returnType, argTypes);
        return methodExpr.invoke(elctx, args);
    }

    public Object invokeEL(String expr, Class returnType, Class argType, Object argument) {
        return invokeMethodExpression(expr, returnType, new Class[] { argType }, new Object[] { argument });
    }

    public void contractCustQueryOperationListener(QueryOperationEvent queryOperationEvent) {
        invokeEL("#{bindings.NewContractCustomerSearchQuery.processQueryOperation}",Object.class,
                 QueryOperationEvent.class, queryOperationEvent);
        if (queryOperationEvent.getOperation().name().toUpperCase().equals("RESET")) {
            DCIteratorBinding carrierIter = ADFUtils.findIterator("XpeDccNewContractCustomerSearchROVOIterator");
            carrierIter.getViewObject().executeEmptyRowSet();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getXpeDccNewContractBBean().getContractCustSearchROVOTblBind());
        }
    }

    public String onCustomerNextAction() {
        String customerSelection = (String) ADFUtils.evaluateEL("#{bindings.Customer_Type.inputValue}");
        String contractType = (String) ADFUtils.evaluateEL("#{pageFlowScope.ContractType}");
        if("NEW".equals(contractType)){
            if (null == customerSelection) {
                ADFUtils.showErrorMessage("You must make a selection.",
                                          this.getXpeDccNewContractBBean().getCustomerSelection());
                return null;
            } else
                return "next";   
        }else
            return "next";  
    }
}
