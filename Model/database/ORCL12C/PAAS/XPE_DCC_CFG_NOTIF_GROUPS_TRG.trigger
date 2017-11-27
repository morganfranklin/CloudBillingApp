-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_NOTIF_GROUPS_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_NOTIF_GROUPS_TRG</name>
--         <identifier class="java.math.BigDecimal">128635</identifier>
--         <schemaName>PAAS</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CFG_NOTIF_GROUPS_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_NOTIF_GROUPS FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_NOTIF_GROUPS_ADT VALUES
    (
      :NEW.GROUP_ID,
      :NEW.GROUP_TYPE,
      :NEW.NOTIFICATION_ID,
      :NEW.INACTIVE,
      :NEW.INACTIVE_DATE,
      :NEW.CREATED_BY,
      :NEW.CREATION_DATE,
      :NEW.LAST_UPDATED_BY,
      :NEW.LAST_UPDATE_DATE
    );
END;
/
