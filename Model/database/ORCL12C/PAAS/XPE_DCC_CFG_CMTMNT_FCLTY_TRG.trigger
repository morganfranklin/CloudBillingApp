-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_CMTMNT_FCLTY_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_CMTMNT_FCLTY_TRG</name>
--         <identifier class="java.math.BigDecimal">128603</identifier>
--         <schemaName>PAAS</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CFG_CMTMNT_FCLTY_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_CMTMNT_FACILITY FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_CMTMNT_FCLTY_ADT VALUES
    (
      :NEW.XPE_FACILITY_ID,
      :NEW.CUSTOMER_CARE_REVIEW,
      :NEW.LEGAL_REVIEW,
      :NEW.FINANCIAL_REVIEW,
      :NEW.GENERAL_MANAGER_REVIEW,
      :NEW.SUST_SOL_REVIEW,
      :NEW.CFO_REVIEW,
      :NEW.CEO_REVIEW,
      :NEW.CREATED_BY,
      :NEW.CREATION_DATE,
      :NEW.LAST_UPDATED_BY,
      :NEW.LAST_UPDATE_DATE,
      :NEW.INACTIVE,
      :NEW.INACTIVE_DATE,
      :NEW.CEO_SIGNATURE
    );
END;
/
