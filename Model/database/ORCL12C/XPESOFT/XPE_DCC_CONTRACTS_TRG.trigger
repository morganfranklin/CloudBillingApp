-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CONTRACTS_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CONTRACTS_TRG</name>
--         <identifier class="java.math.BigDecimal">52506455</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CONTRACTS_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CONTRACTS FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CONTRACTS_ADT VALUES
    (
      :NEW.XPE_CONTRACT_ID,
      :NEW.XPE_CONTRACT_DESC,
      :NEW.SETID,
      :NEW.CUST_ID,
      :NEW.CREATED_BY,
      :NEW.CURRENCY_CD,
      :NEW.XPE_DCC_PCSNAME,
      :NEW.CUST_CONTRACT_CONTACT_NAME,
      :NEW.CUST_CONTRACT_APPROVER_EMAIL,
      :NEW.ADDRESS_SEQ_NUM,
      :NEW.LAST_UPDATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_DATE
      ,'database',
      'N',
      NULL
    );
END;
/
