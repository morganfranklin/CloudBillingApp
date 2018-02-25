package model.views.entitybased;

import java.sql.Timestamp;

import model.entities.XpeDccCfgRoleSecurityEOImpl;

import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Feb 24 15:34:13 CST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XpeDccCfgRoleSecurityEOVORowImpl extends ViewRowImpl {


    public static final int ENTITY_XPEDCCCFGROLESECURITYEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CpeRole,
        CreatedBy,
        CreatedDate,
        LastUpdatedBy,
        LastUpdatedDate,
        Screen1,
        Screen10,
        Screen11,
        Screen12,
        Screen13,
        Screen14,
        Screen15,
        Screen16,
        Screen17,
        Screen18,
        Screen19,
        Screen2,
        Screen20,
        Screen21,
        Screen22,
        Screen23,
        Screen24,
        Screen25,
        Screen26,
        Screen27,
        Screen28,
        Screen29,
        Screen3,
        Screen30,
        Screen4,
        Screen5,
        Screen6,
        Screen7,
        Screen8,
        Screen9,
        LookupSharedAppModule_ScreenSecurityTypeLOV;
        static AttributesEnum[] vals = null;
        ;
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


    public static final int CPEROLE = AttributesEnum.CpeRole.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDDATE = AttributesEnum.LastUpdatedDate.index();
    public static final int SCREEN1 = AttributesEnum.Screen1.index();
    public static final int SCREEN10 = AttributesEnum.Screen10.index();
    public static final int SCREEN11 = AttributesEnum.Screen11.index();
    public static final int SCREEN12 = AttributesEnum.Screen12.index();
    public static final int SCREEN13 = AttributesEnum.Screen13.index();
    public static final int SCREEN14 = AttributesEnum.Screen14.index();
    public static final int SCREEN15 = AttributesEnum.Screen15.index();
    public static final int SCREEN16 = AttributesEnum.Screen16.index();
    public static final int SCREEN17 = AttributesEnum.Screen17.index();
    public static final int SCREEN18 = AttributesEnum.Screen18.index();
    public static final int SCREEN19 = AttributesEnum.Screen19.index();
    public static final int SCREEN2 = AttributesEnum.Screen2.index();
    public static final int SCREEN20 = AttributesEnum.Screen20.index();
    public static final int SCREEN21 = AttributesEnum.Screen21.index();
    public static final int SCREEN22 = AttributesEnum.Screen22.index();
    public static final int SCREEN23 = AttributesEnum.Screen23.index();
    public static final int SCREEN24 = AttributesEnum.Screen24.index();
    public static final int SCREEN25 = AttributesEnum.Screen25.index();
    public static final int SCREEN26 = AttributesEnum.Screen26.index();
    public static final int SCREEN27 = AttributesEnum.Screen27.index();
    public static final int SCREEN28 = AttributesEnum.Screen28.index();
    public static final int SCREEN29 = AttributesEnum.Screen29.index();
    public static final int SCREEN3 = AttributesEnum.Screen3.index();
    public static final int SCREEN30 = AttributesEnum.Screen30.index();
    public static final int SCREEN4 = AttributesEnum.Screen4.index();
    public static final int SCREEN5 = AttributesEnum.Screen5.index();
    public static final int SCREEN6 = AttributesEnum.Screen6.index();
    public static final int SCREEN7 = AttributesEnum.Screen7.index();
    public static final int SCREEN8 = AttributesEnum.Screen8.index();
    public static final int SCREEN9 = AttributesEnum.Screen9.index();
    public static final int LOOKUPSHAREDAPPMODULE_SCREENSECURITYTYPELOV =
        AttributesEnum.LookupSharedAppModule_ScreenSecurityTypeLOV.index();

    /**
     * This is the default constructor (do not remove).
     */
    public XpeDccCfgRoleSecurityEOVORowImpl() {
    }

    /**
     * Gets XpeDccCfgRoleSecurityEO entity object.
     * @return the XpeDccCfgRoleSecurityEO
     */
    public XpeDccCfgRoleSecurityEOImpl getXpeDccCfgRoleSecurityEO() {
        return (XpeDccCfgRoleSecurityEOImpl) getEntity(ENTITY_XPEDCCCFGROLESECURITYEO);
    }

    /**
     * Gets the attribute value for CPE_ROLE using the alias name CpeRole.
     * @return the CPE_ROLE
     */
    public String getCpeRole() {
        return (String) getAttributeInternal(CPEROLE);
    }

    /**
     * Sets <code>value</code> as attribute value for CPE_ROLE using the alias name CpeRole.
     * @param value value to set the CPE_ROLE
     */
    public void setCpeRole(String value) {
        setAttributeInternal(CPEROLE, value);
    }

    /**
     * Gets the attribute value for CREATED_BY using the alias name CreatedBy.
     * @return the CREATED_BY
     */
    public String getCreatedBy() {
        return (String) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATED_BY using the alias name CreatedBy.
     * @param value value to set the CREATED_BY
     */
    public void setCreatedBy(String value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CREATED_DATE using the alias name CreatedDate.
     * @return the CREATED_DATE
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }


    /**
     * Gets the attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy.
     * @return the LAST_UPDATED_BY
     */
    public String getLastUpdatedBy() {
        return (String) getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as attribute value for LAST_UPDATED_BY using the alias name LastUpdatedBy.
     * @param value value to set the LAST_UPDATED_BY
     */
    public void setLastUpdatedBy(String value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for LAST_UPDATED_DATE using the alias name LastUpdatedDate.
     * @return the LAST_UPDATED_DATE
     */
    public Timestamp getLastUpdatedDate() {
        return (Timestamp) getAttributeInternal(LASTUPDATEDDATE);
    }


    /**
     * Gets the attribute value for SCREEN1 using the alias name Screen1.
     * @return the SCREEN1
     */
    public String getScreen1() {
        return (String) getAttributeInternal(SCREEN1);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN1 using the alias name Screen1.
     * @param value value to set the SCREEN1
     */
    public void setScreen1(String value) {
        setAttributeInternal(SCREEN1, value);
    }

    /**
     * Gets the attribute value for SCREEN10 using the alias name Screen10.
     * @return the SCREEN10
     */
    public String getScreen10() {
        return (String) getAttributeInternal(SCREEN10);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN10 using the alias name Screen10.
     * @param value value to set the SCREEN10
     */
    public void setScreen10(String value) {
        setAttributeInternal(SCREEN10, value);
    }

    /**
     * Gets the attribute value for SCREEN11 using the alias name Screen11.
     * @return the SCREEN11
     */
    public String getScreen11() {
        return (String) getAttributeInternal(SCREEN11);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN11 using the alias name Screen11.
     * @param value value to set the SCREEN11
     */
    public void setScreen11(String value) {
        setAttributeInternal(SCREEN11, value);
    }

    /**
     * Gets the attribute value for SCREEN12 using the alias name Screen12.
     * @return the SCREEN12
     */
    public String getScreen12() {
        return (String) getAttributeInternal(SCREEN12);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN12 using the alias name Screen12.
     * @param value value to set the SCREEN12
     */
    public void setScreen12(String value) {
        setAttributeInternal(SCREEN12, value);
    }

    /**
     * Gets the attribute value for SCREEN13 using the alias name Screen13.
     * @return the SCREEN13
     */
    public String getScreen13() {
        return (String) getAttributeInternal(SCREEN13);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN13 using the alias name Screen13.
     * @param value value to set the SCREEN13
     */
    public void setScreen13(String value) {
        setAttributeInternal(SCREEN13, value);
    }

    /**
     * Gets the attribute value for SCREEN14 using the alias name Screen14.
     * @return the SCREEN14
     */
    public String getScreen14() {
        return (String) getAttributeInternal(SCREEN14);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN14 using the alias name Screen14.
     * @param value value to set the SCREEN14
     */
    public void setScreen14(String value) {
        setAttributeInternal(SCREEN14, value);
    }

    /**
     * Gets the attribute value for SCREEN15 using the alias name Screen15.
     * @return the SCREEN15
     */
    public String getScreen15() {
        return (String) getAttributeInternal(SCREEN15);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN15 using the alias name Screen15.
     * @param value value to set the SCREEN15
     */
    public void setScreen15(String value) {
        setAttributeInternal(SCREEN15, value);
    }

    /**
     * Gets the attribute value for SCREEN16 using the alias name Screen16.
     * @return the SCREEN16
     */
    public String getScreen16() {
        return (String) getAttributeInternal(SCREEN16);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN16 using the alias name Screen16.
     * @param value value to set the SCREEN16
     */
    public void setScreen16(String value) {
        setAttributeInternal(SCREEN16, value);
    }

    /**
     * Gets the attribute value for SCREEN17 using the alias name Screen17.
     * @return the SCREEN17
     */
    public String getScreen17() {
        return (String) getAttributeInternal(SCREEN17);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN17 using the alias name Screen17.
     * @param value value to set the SCREEN17
     */
    public void setScreen17(String value) {
        setAttributeInternal(SCREEN17, value);
    }

    /**
     * Gets the attribute value for SCREEN18 using the alias name Screen18.
     * @return the SCREEN18
     */
    public String getScreen18() {
        return (String) getAttributeInternal(SCREEN18);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN18 using the alias name Screen18.
     * @param value value to set the SCREEN18
     */
    public void setScreen18(String value) {
        setAttributeInternal(SCREEN18, value);
    }

    /**
     * Gets the attribute value for SCREEN19 using the alias name Screen19.
     * @return the SCREEN19
     */
    public String getScreen19() {
        return (String) getAttributeInternal(SCREEN19);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN19 using the alias name Screen19.
     * @param value value to set the SCREEN19
     */
    public void setScreen19(String value) {
        setAttributeInternal(SCREEN19, value);
    }

    /**
     * Gets the attribute value for SCREEN2 using the alias name Screen2.
     * @return the SCREEN2
     */
    public String getScreen2() {
        return (String) getAttributeInternal(SCREEN2);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN2 using the alias name Screen2.
     * @param value value to set the SCREEN2
     */
    public void setScreen2(String value) {
        setAttributeInternal(SCREEN2, value);
    }

    /**
     * Gets the attribute value for SCREEN20 using the alias name Screen20.
     * @return the SCREEN20
     */
    public String getScreen20() {
        return (String) getAttributeInternal(SCREEN20);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN20 using the alias name Screen20.
     * @param value value to set the SCREEN20
     */
    public void setScreen20(String value) {
        setAttributeInternal(SCREEN20, value);
    }

    /**
     * Gets the attribute value for SCREEN21 using the alias name Screen21.
     * @return the SCREEN21
     */
    public String getScreen21() {
        return (String) getAttributeInternal(SCREEN21);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN21 using the alias name Screen21.
     * @param value value to set the SCREEN21
     */
    public void setScreen21(String value) {
        setAttributeInternal(SCREEN21, value);
    }

    /**
     * Gets the attribute value for SCREEN22 using the alias name Screen22.
     * @return the SCREEN22
     */
    public String getScreen22() {
        return (String) getAttributeInternal(SCREEN22);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN22 using the alias name Screen22.
     * @param value value to set the SCREEN22
     */
    public void setScreen22(String value) {
        setAttributeInternal(SCREEN22, value);
    }

    /**
     * Gets the attribute value for SCREEN23 using the alias name Screen23.
     * @return the SCREEN23
     */
    public String getScreen23() {
        return (String) getAttributeInternal(SCREEN23);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN23 using the alias name Screen23.
     * @param value value to set the SCREEN23
     */
    public void setScreen23(String value) {
        setAttributeInternal(SCREEN23, value);
    }

    /**
     * Gets the attribute value for SCREEN24 using the alias name Screen24.
     * @return the SCREEN24
     */
    public String getScreen24() {
        return (String) getAttributeInternal(SCREEN24);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN24 using the alias name Screen24.
     * @param value value to set the SCREEN24
     */
    public void setScreen24(String value) {
        setAttributeInternal(SCREEN24, value);
    }

    /**
     * Gets the attribute value for SCREEN25 using the alias name Screen25.
     * @return the SCREEN25
     */
    public String getScreen25() {
        return (String) getAttributeInternal(SCREEN25);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN25 using the alias name Screen25.
     * @param value value to set the SCREEN25
     */
    public void setScreen25(String value) {
        setAttributeInternal(SCREEN25, value);
    }

    /**
     * Gets the attribute value for SCREEN26 using the alias name Screen26.
     * @return the SCREEN26
     */
    public String getScreen26() {
        return (String) getAttributeInternal(SCREEN26);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN26 using the alias name Screen26.
     * @param value value to set the SCREEN26
     */
    public void setScreen26(String value) {
        setAttributeInternal(SCREEN26, value);
    }

    /**
     * Gets the attribute value for SCREEN27 using the alias name Screen27.
     * @return the SCREEN27
     */
    public String getScreen27() {
        return (String) getAttributeInternal(SCREEN27);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN27 using the alias name Screen27.
     * @param value value to set the SCREEN27
     */
    public void setScreen27(String value) {
        setAttributeInternal(SCREEN27, value);
    }

    /**
     * Gets the attribute value for SCREEN28 using the alias name Screen28.
     * @return the SCREEN28
     */
    public String getScreen28() {
        return (String) getAttributeInternal(SCREEN28);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN28 using the alias name Screen28.
     * @param value value to set the SCREEN28
     */
    public void setScreen28(String value) {
        setAttributeInternal(SCREEN28, value);
    }

    /**
     * Gets the attribute value for SCREEN29 using the alias name Screen29.
     * @return the SCREEN29
     */
    public String getScreen29() {
        return (String) getAttributeInternal(SCREEN29);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN29 using the alias name Screen29.
     * @param value value to set the SCREEN29
     */
    public void setScreen29(String value) {
        setAttributeInternal(SCREEN29, value);
    }

    /**
     * Gets the attribute value for SCREEN3 using the alias name Screen3.
     * @return the SCREEN3
     */
    public String getScreen3() {
        return (String) getAttributeInternal(SCREEN3);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN3 using the alias name Screen3.
     * @param value value to set the SCREEN3
     */
    public void setScreen3(String value) {
        setAttributeInternal(SCREEN3, value);
    }

    /**
     * Gets the attribute value for SCREEN30 using the alias name Screen30.
     * @return the SCREEN30
     */
    public String getScreen30() {
        return (String) getAttributeInternal(SCREEN30);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN30 using the alias name Screen30.
     * @param value value to set the SCREEN30
     */
    public void setScreen30(String value) {
        setAttributeInternal(SCREEN30, value);
    }

    /**
     * Gets the attribute value for SCREEN4 using the alias name Screen4.
     * @return the SCREEN4
     */
    public String getScreen4() {
        return (String) getAttributeInternal(SCREEN4);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN4 using the alias name Screen4.
     * @param value value to set the SCREEN4
     */
    public void setScreen4(String value) {
        setAttributeInternal(SCREEN4, value);
    }

    /**
     * Gets the attribute value for SCREEN5 using the alias name Screen5.
     * @return the SCREEN5
     */
    public String getScreen5() {
        return (String) getAttributeInternal(SCREEN5);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN5 using the alias name Screen5.
     * @param value value to set the SCREEN5
     */
    public void setScreen5(String value) {
        setAttributeInternal(SCREEN5, value);
    }

    /**
     * Gets the attribute value for SCREEN6 using the alias name Screen6.
     * @return the SCREEN6
     */
    public String getScreen6() {
        return (String) getAttributeInternal(SCREEN6);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN6 using the alias name Screen6.
     * @param value value to set the SCREEN6
     */
    public void setScreen6(String value) {
        setAttributeInternal(SCREEN6, value);
    }

    /**
     * Gets the attribute value for SCREEN7 using the alias name Screen7.
     * @return the SCREEN7
     */
    public String getScreen7() {
        return (String) getAttributeInternal(SCREEN7);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN7 using the alias name Screen7.
     * @param value value to set the SCREEN7
     */
    public void setScreen7(String value) {
        setAttributeInternal(SCREEN7, value);
    }

    /**
     * Gets the attribute value for SCREEN8 using the alias name Screen8.
     * @return the SCREEN8
     */
    public String getScreen8() {
        return (String) getAttributeInternal(SCREEN8);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN8 using the alias name Screen8.
     * @param value value to set the SCREEN8
     */
    public void setScreen8(String value) {
        setAttributeInternal(SCREEN8, value);
    }

    /**
     * Gets the attribute value for SCREEN9 using the alias name Screen9.
     * @return the SCREEN9
     */
    public String getScreen9() {
        return (String) getAttributeInternal(SCREEN9);
    }

    /**
     * Sets <code>value</code> as attribute value for SCREEN9 using the alias name Screen9.
     * @param value value to set the SCREEN9
     */
    public void setScreen9(String value) {
        setAttributeInternal(SCREEN9, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LookupSharedAppModule_ScreenSecurityTypeLOV.
     */
    public RowSet getLookupSharedAppModule_ScreenSecurityTypeLOV() {
        return (RowSet) getAttributeInternal(LOOKUPSHAREDAPPMODULE_SCREENSECURITYTYPELOV);
    }
}

