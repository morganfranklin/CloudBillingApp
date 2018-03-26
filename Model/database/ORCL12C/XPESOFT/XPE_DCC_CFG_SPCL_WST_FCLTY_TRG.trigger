-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_SPCL_WST_FCLTY_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_SPCL_WST_FCLTY_TRG</name>
--         <identifier class="java.math.BigDecimal">52509026</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CFG_SPCL_WST_FCLTY_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_SPCL_WASTE_FCLTY FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_SPCL_WST_FCLTY_ADT VALUES
    (
      :NEW.XPE_FACILITY_ID,
      :NEW.CUSTOMER_CARE_REVIEW,
      :NEW.CUSTOMER_CARE_SIGNATURE,
      :NEW.CREATED_BY,
      :NEW.CREATION_DATE,
      :NEW.LAST_UPDATED_BY,
      :NEW.LAST_UPDATED_DATE,
      :NEW.INACTIVE,
      :NEW.INACTIVE_DATE
    );
END;
/
