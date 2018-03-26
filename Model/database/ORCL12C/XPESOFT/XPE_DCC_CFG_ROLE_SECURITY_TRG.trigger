-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_ROLE_SECURITY_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_ROLE_SECURITY_TRG</name>
--         <identifier class="java.math.BigDecimal">52530653</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER "XPESOFT"."XPE_DCC_CFG_ROLE_SECURITY_TRG" AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_ROLE_SECURITY FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_ROLE_SECURITY_ADT VALUES
    (
        :NEW."CPE_ROLE", 
	:NEW."SCREEN1", 
	:NEW."SCREEN2", 
	:NEW."SCREEN3", 
	:NEW."SCREEN4", 
	:NEW."SCREEN5", 
	:NEW."SCREEN6", 
	:NEW."SCREEN7", 
	:NEW."SCREEN8", 
	:NEW."SCREEN9", 
	:NEW."SCREEN10", 
	:NEW."SCREEN11", 
	:NEW."SCREEN12", 
	:NEW."SCREEN13", 
	:NEW."SCREEN14", 
	:NEW."SCREEN15", 
	:NEW."SCREEN16", 
	:NEW."SCREEN17", 
	:NEW."SCREEN18", 
	:NEW."SCREEN19", 
	:NEW."SCREEN20", 
	:NEW."SCREEN21", 
	:NEW."SCREEN22", 
	:NEW."SCREEN23", 
	:NEW."SCREEN24", 
	:NEW."SCREEN25", 
	:NEW."SCREEN26", 
	:NEW."SCREEN27", 
	:NEW."SCREEN28", 
	:NEW."SCREEN29", 
	:NEW."SCREEN30", 
	:NEW."CREATED_BY", 
	:NEW."LAST_UPDATED_BY", 
	:NEW."CREATED_DATE", 
	:NEW."LAST_UPDATED_DATE"
    );
END;
/
