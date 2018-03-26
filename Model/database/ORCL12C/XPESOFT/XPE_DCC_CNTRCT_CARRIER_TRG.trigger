-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CNTRCT_CARRIER_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CNTRCT_CARRIER_TRG</name>
--         <identifier class="java.math.BigDecimal">52509074</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CNTRCT_CARRIER_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CONTRACT_CARRIER FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CNTRCT_CARRIER_ADT VALUES
    (
      :NEW.XPE_CONTRACT_ID,
      :NEW.XPE_PRICING_TERM_LINE,
      :NEW.XPE_CONTRACT_LINE,
      :NEW.XPE_CONTRACT_VERSION,
      :NEW.XPE_CARRIER_ID,
      :NEW.XPE_VEHICLE_TYPE,
      :NEW.XPE_SUB_NBR,
      :NEW.XPE_VEHICLE_NBR,
      :NEW.XPE_RATE_OVERRIDE,
      :NEW.XPE_SURCHARGE,
      :NEW.XPE_CONTRACT_CARRIER_ID,
      :NEW.CREATED_BY,
      :NEW.LAST_UPDATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_DATE
    );
END;
/
