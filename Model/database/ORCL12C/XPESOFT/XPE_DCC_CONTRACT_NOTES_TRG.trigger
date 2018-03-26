-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CONTRACT_NOTES_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CONTRACT_NOTES_TRG</name>
--         <identifier class="java.math.BigDecimal">52509032</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CONTRACT_NOTES_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CONTRACT_NOTES FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CONTRACT_NOTES_ADT VALUES
    (
      :NEW.XPE_CONTRACT_ID,
      :NEW.XPE_CONTRACT_VERSION,
      :NEW.XPE_NOTE_DTTM,
      :NEW.XPE_NOTE,
      :NEW.XPE_USER,
      :NEW.XPE_NOTE_LONG,
      :NEW.XPE_NOTE_TYPE,
      :NEW.CREATED_BY,
      :NEW.LAST_UPDATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_DATE
    );
END;
/
