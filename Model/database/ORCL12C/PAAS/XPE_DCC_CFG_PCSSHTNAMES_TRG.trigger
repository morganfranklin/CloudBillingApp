-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_PCSSHTNAMES_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_PCSSHTNAMES_TRG</name>
--         <identifier class="java.math.BigDecimal">128650</identifier>
--         <schemaName>PAAS</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CFG_PCSSHTNAMES_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_PCSSHORTNAMES FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_PCSSHTNAMES_ADT VALUES
    (
      :NEW.PCSSHORTNAME_ID,
      :NEW.PCSSHORT_NAME,
      :NEW.ACCOUNT_CLASS,
      :NEW.INACTIVE,
      :NEW.INACTIVE_DATE,
      :NEW.CREATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_BY,
      :NEW.LAST_UPDATED_DATE,
      :NEW.COV_ID,
      :NEW.COV_SOLD_ID,
      :NEW.COV_BILL_ID,
      :NEW.COV_SOLD_LOC_NUM,
      :NEW.COV_BILL_LOC_NUM,
      :NEW.BILL_CYCLE_ID,
      :NEW.INV_SUPRESS
    );
END;
/
