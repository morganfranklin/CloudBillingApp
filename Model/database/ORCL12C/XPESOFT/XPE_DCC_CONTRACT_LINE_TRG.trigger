-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CONTRACT_LINE_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CONTRACT_LINE_TRG</name>
--         <identifier class="java.math.BigDecimal">52509031</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CONTRACT_LINE_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CONTRACT_LINE FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CONTRACT_LINE_ADT VALUES
    (
      :NEW.XPE_CONTRACT_ID,
      :NEW.XPE_CONTRACT_VERSION,
      :NEW.XPE_CONTRACT_LINE,
      :NEW.XPE_FACILITY,
      :NEW.XPE_PRODUCT_ID,
      :NEW.XPE_PRODUCT_UOM,
      :NEW.XPE_QTY_MIN,
      :NEW.XPE_QTY_MAX,
      :NEW.XPE_PERIOD_TYPE,
      :NEW.XPE_ICON,
      :NEW.XPE_SW_APPR_NBR,
      :NEW.CURRENCY_CD,
      :NEW.BUSINESS_UNIT_GL,
      :NEW.CREATED_BY,
      :NEW.LAST_UPDATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_DATE,
'database',
'N',
NULL
    );
END;
/
