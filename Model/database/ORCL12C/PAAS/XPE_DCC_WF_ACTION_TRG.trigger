-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_WF_ACTION_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_WF_ACTION_TRG</name>
--         <identifier class="java.math.BigDecimal">129400</identifier>
--         <schemaName>PAAS</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_WF_ACTION_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_WF_ACTION FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_WF_ACTION_ADT VALUES
    (
      :NEW.XPE_CONTRACT_ID,
      :NEW.XPE_CONTRACT_VERSION,
      :NEW.XPE_EVENT_NUMBER,
      :NEW.XPE_APPROVER_SEQUENCE,
      :NEW.XPE_UUID,
      :NEW.XPE_APPROVER_EMAIL,
      :NEW.XPE_ACTION_STATUS,
      :NEW.CREATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_BY,
      :NEW.LAST_UPDATED_DATE
    );
END;
/
