package model.views.entitybased;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Feb 28 00:15:34 EST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgUserBusinessUnitEOVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgUserBusinessUnitEOVOImpl() {
    }

    /**
     * Returns the variable value for bindBusinessUnit.
     * @return variable value for bindBusinessUnit
     */
    public String getbindBusinessUnit() {
        return (String) ensureVariableManager().getVariableValue("bindBusinessUnit");
    }

    /**
     * Sets <code>value</code> for variable bindBusinessUnit.
     * @param value value to bind as bindBusinessUnit
     */
    public void setbindBusinessUnit(String value) {
        ensureVariableManager().setVariableValue("bindBusinessUnit", value);
    }

    /**
     * Returns the variable value for bindUserName.
     * @return variable value for bindUserName
     */
    public String getbindUserName() {
        return (String) ensureVariableManager().getVariableValue("bindUserName");
    }

    /**
     * Sets <code>value</code> for variable bindUserName.
     * @param value value to bind as bindUserName
     */
    public void setbindUserName(String value) {
        ensureVariableManager().setVariableValue("bindUserName", value);
    }
}

