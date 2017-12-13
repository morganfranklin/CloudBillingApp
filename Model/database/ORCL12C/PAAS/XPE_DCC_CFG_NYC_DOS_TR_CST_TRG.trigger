-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_NYC_DOS_TR_CST_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_NYC_DOS_TR_CST_TRG</name>
--         <identifier class="java.math.BigDecimal">131444</identifier>
--         <schemaName>PAAS</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CFG_NYC_DOS_TR_CST_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_NYC_DOS_TERM_CUST FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_NYC_DOS_TR_CST_ADT VALUES
    (
      :NEW.ORIGIN_ID,
      :NEW.TERMINAL_ID,
      :NEW.PCSSHORTNAME_ID,
      :NEW.INACTIVE,
      :NEW.INACTIVE_DATE,
      :NEW.CREATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_BY,
      :NEW.LAST_UPDATED_DATE
    );
END;
/
