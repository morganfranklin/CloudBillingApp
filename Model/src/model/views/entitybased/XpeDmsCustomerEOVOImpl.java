package model.views.entitybased;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Sep 07 22:11:44 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDmsCustomerEOVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public XpeDmsCustomerEOVOImpl() {
    }

    /**
     * Returns the variable value for bind_CustId.
     * @return variable value for bind_CustId
     */
    public String getbind_CustId() {
        return (String) ensureVariableManager().getVariableValue("bind_CustId");
    }

    /**
     * Sets <code>value</code> for variable bind_CustId.
     * @param value value to bind as bind_CustId
     */
    public void setbind_CustId(String value) {
        ensureVariableManager().setVariableValue("bind_CustId", value);
    }
}

