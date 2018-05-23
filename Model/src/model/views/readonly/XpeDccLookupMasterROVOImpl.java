package model.views.readonly;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu May 17 23:15:04 EDT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccLookupMasterROVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccLookupMasterROVOImpl() {
    }

    /**
     * Returns the variable value for bindLookType.
     * @return variable value for bindLookType
     */
    public String getbindLookType() {
        return (String) ensureVariableManager().getVariableValue("bindLookType");
    }

    /**
     * Sets <code>value</code> for variable bindLookType.
     * @param value value to bind as bindLookType
     */
    public void setbindLookType(String value) {
        ensureVariableManager().setVariableValue("bindLookType", value);
    }

    /**
     * Returns the variable value for bindLookupId.
     * @return variable value for bindLookupId
     */
    public String getbindLookupId() {
        return (String) ensureVariableManager().getVariableValue("bindLookupId");
    }

    /**
     * Sets <code>value</code> for variable bindLookupId.
     * @param value value to bind as bindLookupId
     */
    public void setbindLookupId(String value) {
        ensureVariableManager().setVariableValue("bindLookupId", value);
    }
}
