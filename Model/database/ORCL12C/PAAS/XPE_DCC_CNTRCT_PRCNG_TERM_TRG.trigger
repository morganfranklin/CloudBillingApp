-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CNTRCT_PRCNG_TERM_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CNTRCT_PRCNG_TERM_TRG</name>
--         <identifier class="java.math.BigDecimal">129233</identifier>
--         <schemaName>PAAS</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CNTRCT_PRCNG_TERM_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CONTRACT_PRICING_TERM FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CNTRCT_PRCNG_TERM_ADT VALUES
    (
      :NEW.XPE_CONTRACT_ID,
      :NEW.XPE_CONTRACT_VERSION,
      :NEW.XPE_CONTRACT_LINE,
      :NEW.XPE_PRICING_TERM_LINE,
      :NEW.XPE_PRICING_TERM_TYPE,
      :NEW.XPE_QTY_MAX,
      :NEW.XPE_RATE,
      :NEW.XPE_CHARGE_OVER_MIN,
      :NEW.XPE_CHARGE_OVER_MAX,
      :NEW.XPE_CHARGE_DESC,
      :NEW.XPE_ROLLOVER_TYPE,
      :NEW.XPE_RESET_TYPE,
      :NEW.XPE_PERIOD_TYPE,
      :NEW.XPE_PERIOD_NBR,
      :NEW.XPE_ICON,
      :NEW.XPE_INDEX_CHANGE_TYPE,
      :NEW.XPE_INDEX_CHANGE_ID,
      :NEW.XPE_METALS_INDEX_VAL,
      :NEW.XPE_METALS_INDEX_PRC1,
      :NEW.XPE_METALS_INDEX_PRC2,
      :NEW.XPE_METALS_UOM_MLT,
      :NEW.XPE_METALS_UOM_DEN
    );
END;
/
