package model.views.entitybased;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Feb 24 15:29:54 CST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgRolesEOVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgRolesEOVOImpl() {
    }

    /**
     * Returns the variable value for bind_PeoplesoftRole.
     * @return variable value for bind_PeoplesoftRole
     */
    public String getbind_PeoplesoftRole() {
        return (String) ensureVariableManager().getVariableValue("bind_PeoplesoftRole");
    }

    /**
     * Sets <code>value</code> for variable bind_PeoplesoftRole.
     * @param value value to bind as bind_PeoplesoftRole
     */
    public void setbind_PeoplesoftRole(String value) {
        ensureVariableManager().setVariableValue("bind_PeoplesoftRole", value);
    }
}
