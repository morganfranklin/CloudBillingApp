-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_TERM_MASTER_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_TERM_MASTER_TRG</name>
--         <identifier class="java.math.BigDecimal">52509036</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_TERM_MASTER_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_TERM_MASTER FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_TERM_MASTER_ADT VALUES
    (
      :NEW.XPE_DCC_TERM,
      :NEW.XPE_DCC_STATUS,
      :NEW.XPE_DCC_TERM_DESC,
      :NEW.XPE_CONTRACT_SUB_TYPE,
      :NEW.XPE_WASTE_TYPE,
      :NEW.XPE_AGREEMENT_TYPE,
      :NEW.CREATED_BY,
      :NEW.LAST_UPDATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_DATE
    );
END;
/
