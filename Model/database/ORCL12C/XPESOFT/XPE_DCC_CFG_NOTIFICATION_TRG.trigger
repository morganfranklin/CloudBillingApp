-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_NOTIFICATION_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_NOTIFICATION_TRG</name>
--         <identifier class="java.math.BigDecimal">52509019</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CFG_NOTIFICATION_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_NOTIFICATION FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_NOTIFICATION_ADT VALUES
    (
      :NEW.NOTIFICATION_ID,
      :NEW.NOTIFICATION_NAME,
      :NEW.CREDIT_UTILIZATION,
      :NEW.NOTIFICATION_TO,
      :NEW.NOTIFICATION_CC,
      :NEW.NOTIFICATION_TOPIC,
      :NEW.NOTIFICATION_SALUTATION,
      :NEW.NOTIFICATION_EMAIL,
      :NEW.CREDIT_DETAILS,
      :NEW.INACTIVE,
      :NEW.INACTIVE_DATE,
      :NEW.CREATED_BY,
      :NEW.CREATION_DATE,
      :NEW.LAST_UPDATED_BY,
      :NEW.LAST_UPDATE_DATE
    );
END;
/
