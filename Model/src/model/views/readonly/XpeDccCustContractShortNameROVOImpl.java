package model.views.readonly;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Dec 10 21:32:17 EST 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCustContractShortNameROVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCustContractShortNameROVOImpl() {
    }

    /**
     * Returns the bind variable value for bind_ContractId.
     * @return bind variable value for bind_ContractId
     */
    public String getbind_ContractId() {
        return (String) getNamedWhereClauseParam("bind_ContractId");
    }

    /**
     * Sets <code>value</code> for bind variable bind_ContractId.
     * @param value value to bind as bind_ContractId
     */
    public void setbind_ContractId(String value) {
        setNamedWhereClauseParam("bind_ContractId", value);
    }
}
