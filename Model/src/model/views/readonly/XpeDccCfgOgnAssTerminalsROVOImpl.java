package model.views.readonly;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 11 19:34:44 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgOgnAssTerminalsROVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgOgnAssTerminalsROVOImpl() {
    }

    /**
     * Returns the variable value for bind_OriginId.
     * @return variable value for bind_OriginId
     */
    public String getbind_OriginId() {
        return (String) ensureVariableManager().getVariableValue("bind_OriginId");
    }

    /**
     * Sets <code>value</code> for variable bind_OriginId.
     * @param value value to bind as bind_OriginId
     */
    public void setbind_OriginId(String value) {
        ensureVariableManager().setVariableValue("bind_OriginId", value);
    }

    /**
     * Returns the variable value for bind_TerminalId.
     * @return variable value for bind_TerminalId
     */
    public String getbind_TerminalId() {
        return (String) ensureVariableManager().getVariableValue("bind_TerminalId");
    }

    /**
     * Sets <code>value</code> for variable bind_TerminalId.
     * @param value value to bind as bind_TerminalId
     */
    public void setbind_TerminalId(String value) {
        ensureVariableManager().setVariableValue("bind_TerminalId", value);
    }
}

