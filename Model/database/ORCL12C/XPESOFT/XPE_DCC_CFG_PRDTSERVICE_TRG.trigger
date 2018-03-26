-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DCC_CFG_PRDTSERVICE_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DCC_CFG_PRDTSERVICE_TRG</name>
--         <identifier class="java.math.BigDecimal">52504663</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DCC_CFG_PRDTSERVICE_TRG AFTER
  INSERT OR UPDATE ON XPE_DCC_CFG_PRODUCTSERVICE FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DCC_CFG_PRDTSERVICE_ADT VALUES
    (
      :NEW.ITEM_ID,
      :NEW.ITEM_TYPE,
      :NEW.INOUTBOUND,
      :NEW.DESCRIPTION,
      :NEW.CATEGORY,
      :NEW.CLASS_TYPE,
      :NEW.CLASS_ID,
      :NEW.INACTIVE,
      :NEW.INACTIVE_DATE,
      :NEW.CREATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_BY,
      :NEW.LAST_UPDATED_DATE,
      :NEW.WEIGHT_CLASS
      ,'database',
      'N',
      NULL
    );
END;
/
