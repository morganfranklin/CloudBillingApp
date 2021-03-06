-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_GENERAL_CNV_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_GENERAL_CNV_TRG</name>
--         <identifier class="java.math.BigDecimal">52509015</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CFG_GENERAL_CNV_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_GENERAL_CNV FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_GENERAL_CNV_ADT VALUES
    (
      :NEW.GENERAL_CNV_ID,
      :NEW.CARRIER_ID,
      :NEW.ORIGIN_ID,
      :NEW.DESTINATION_ID,
      :NEW.MATERIAL_ID,
      :NEW.PCS_SHORT_NAME_ID,
      :NEW.TRANSLATION_CONSUMER,
      :NEW.CONVERSION_VALUE,
      :NEW.CREATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_BY,
      :NEW.LAST_UPDATED_DATE,
      :NEW.INACTIVE,
      :NEW.INACTIVE_DATE,
      :NEW.TOH_BUSINESS_TYPE,
      :NEW.TOH_PAY_TYPE,
      :NEW.COUNTRY,
      :NEW.COUNTY_ID
    );
END;
/
