package model.views.readonly;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 11 19:33:03 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgDstAssTerminalsROVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        DestinationId,
        TerminalId,
        TerminalDesc;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int DESTINATIONID = AttributesEnum.DestinationId.index();
    public static final int TERMINALID = AttributesEnum.TerminalId.index();
    public static final int TERMINALDESC = AttributesEnum.TerminalDesc.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgDstAssTerminalsROVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute DestinationId.
     * @return the DestinationId
     */
    public String getDestinationId() {
        return (String) getAttributeInternal(DESTINATIONID);
    }

    /**
     * Gets the attribute value for the calculated attribute TerminalId.
     * @return the TerminalId
     */
    public String getTerminalId() {
        return (String) getAttributeInternal(TERMINALID);
    }

    /**
     * Gets the attribute value for the calculated attribute TerminalDesc.
     * @return the TerminalDesc
     */
    public String getTerminalDesc() {
        return (String) getAttributeInternal(TERMINALDESC);
    }
}

