-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_GENERAL_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_GENERAL_TRG</name>
--         <identifier class="java.math.BigDecimal">52509016</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CFG_GENERAL_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_GENERAL FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_GENERAL_ADT VALUES
    (
      :NEW.ITEM_ID,
      :NEW.ITEM_LIST_TYPE,
      :NEW.VALID_VALUE,
      :NEW.CREATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_BY,
      :NEW.LAST_UPDATED_DATE,
      :NEW.INACTIVE,
      :NEW.INACTIVE_DATE,
      :NEW.SW_ACCT_CLASS,
      :NEW.DMS_BU_CODE
    );
END;
/
