-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_BUSINESSUNIT_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_BUSINESSUNIT_TRG</name>
--         <identifier class="java.math.BigDecimal">129407</identifier>
--         <schemaName>PAAS</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CFG_BUSINESSUNIT_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_BUSINESSUNIT FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_BUSINESSUNIT_ADT VALUES
    (
      :NEW.BUSINESS_UNIT,
      :NEW.TERMINAL_ID,
      :NEW.SITE_ID,
      :NEW.SITE_DESC,
      :NEW.ACCOUNTING_CLASS,
      :NEW.STATS_ONLY,
      :NEW.INACTIVE,
      :NEW.INACTIVE_DATE,
      :NEW.BILLING_BUSINESS_UNIT,
      :NEW.BUSINESS_UNIT_REF,
      :NEW.GL_BUSINESS_UNIT,
      :NEW.AFFLIATE,
      :NEW.OPERATING_UNIT,
      :NEW.CREATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_BY,
      :NEW.LAST_UPDATED_DATE,
      :NEW.BILLING_GL_BUSINESS_UNIT,
      :NEW.BILLING_AFFILIATE,
      :NEW.BILLING_OPERATING_UNIT,
      :NEW.BUSINESSUNIT_ID
    );
END;
/
