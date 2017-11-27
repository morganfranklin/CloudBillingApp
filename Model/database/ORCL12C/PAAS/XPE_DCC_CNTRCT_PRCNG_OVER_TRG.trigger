-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CNTRCT_PRCNG_OVER_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CNTRCT_PRCNG_OVER_TRG</name>
--         <identifier class="java.math.BigDecimal">129232</identifier>
--         <schemaName>PAAS</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CNTRCT_PRCNG_OVER_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CONTRACT_PRICING_OVER FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CNTRCT_PRCNG_OVER_ADT VALUES
    (
      :NEW.XPE_CONTRACT_ID,
      :NEW.XPE_CONTRACT_LINE,
      :NEW.XPE_CONTRACT_VERSION,
      :NEW.XPE_CONTRACT_OVER_NBR,
      :NEW.XPE_OVER_TYPE,
      :NEW.XPE_OVER_START,
      :NEW.XPE_OVER_END,
      :NEW.XPE_SOURCE_FLD,
      :NEW.XPE_CONDITION,
      :NEW.XPE_CHECK,
      :NEW.XPE_TARGET_FLD,
      :NEW.XPE_OVER_MSG,
      :NEW.XPE_OVER_DESC
    );
END;
/
