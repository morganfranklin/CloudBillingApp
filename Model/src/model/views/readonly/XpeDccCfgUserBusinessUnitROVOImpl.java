package model.views.readonly;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowSetImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Feb 28 23:01:00 EST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgUserBusinessUnitROVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgUserBusinessUnitROVOImpl() {
    }

    /**
     * Returns the bind variable value for bindUserName.
     * @return bind variable value for bindUserName
     */
    public String getbindUserName() {
        return (String) getNamedWhereClauseParam("bindUserName");
    }

    /**
     * Sets <code>value</code> for bind variable bindUserName.
     * @param value value to bind as bindUserName
     */
    public void setbindUserName(String value) {
        setNamedWhereClauseParam("bindUserName", value);
    }

    @Override
    public void prepareRowSetForQuery(ViewRowSetImpl viewRowSetImpl) {
        // TODO Implement this method
        super.prepareRowSetForQuery(viewRowSetImpl);
    }
}

