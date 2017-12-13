-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_ACCOUNTING_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_ACCOUNTING_TRG</name>
--         <identifier class="java.math.BigDecimal">128602</identifier>
--         <schemaName>PAAS</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CFG_ACCOUNTING_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_ACCOUNTING FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_ACCOUNTING_ADT VALUES
    (
      :NEW.SITE_ID,
      :NEW.ACCOUNTING_CLASS,
      :NEW.DEAL_CLASS,
      :NEW.MATERIAL_CATEGORY,
      :NEW.PRODUCT_SERVICE_ID,
      :NEW.CHARGE_ID,
      :NEW.STAT_ACCOUNT,
      :NEW.ENTRY_TYPE,
      :NEW.OPERATING_UNIT,
      :NEW.ACCOUNT_ID,
      :NEW.CREATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_BY,
      :NEW.LAST_UPDATED_DATE,
      :NEW.INACTIVE,
      :NEW.INACTIVE_DATE
    );
END;
/
