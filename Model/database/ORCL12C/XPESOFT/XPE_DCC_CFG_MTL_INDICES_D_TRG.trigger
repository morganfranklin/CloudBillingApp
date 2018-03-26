-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_MTL_INDICES_D_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_MTL_INDICES_D_TRG</name>
--         <identifier class="java.math.BigDecimal">52530656</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER "XPESOFT"."XPE_DCC_CFG_MTL_INDICES_D_TRG" AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_MTL_INDICES_DETAIL FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_MTL_INDICES_D_ADT VALUES
    (
       :NEW."XPE_INDEX_CHANGE_ID", 
       :NEW."XPE_START_DATE", 
       :NEW."XPE_END_DATE", 
       :NEW."XPE_INDEX_PRICE", 
       :NEW."XPE_MTL_INDEX_DTL", 
	:NEW."CREATED_BY", 
	:NEW."CREATION_DATE", 
	:NEW."LAST_UPDATED_BY", 
	:NEW."LAST_UPDATE_DATE"
    );
END;
/
