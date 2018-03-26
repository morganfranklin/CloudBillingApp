-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CONTRACT_VERSION_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CONTRACT_VERSION_TRG</name>
--         <identifier class="java.math.BigDecimal">52509033</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CONTRACT_VERSION_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CONTRACT_VERSION FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CONTRACT_VERSION_ADT VALUES
    (
      :NEW.XPE_CONTRACT_ID,
      :NEW.XPE_CONTRACT_VERSION,
      :NEW.XPE_CONTRACT_STATUS,
      :NEW.XPE_START_DATE,
      :NEW.XPE_END_DATE,
      :NEW.XPE_NEW_TERM_MODE,
      :NEW.CREATED_BY,
      :NEW.XPE_BILL_OPTIONS_SET,
      :NEW.XPE_ACCTG_OPTIONS_SET,
      :NEW.XPE_CONTRACT_TEMPLATE,
      :NEW.BUSINESS_UNIT_GL,
      :NEW.CURRENCY_CD,
      :NEW.XPE_WASTE_TYPE,
      :NEW.XPE_CONTRACT_SUB_TYPE,
      :NEW.XPE_AGREEMENT_TYPE,
      :NEW.XPE_AS_OF_DATE,
      :NEW.SALES_PERSON,
      :NEW.XPE_CONTRACT_DIRECTION,
      :NEW.LAST_UPDATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_DATE
    );
END;
/
