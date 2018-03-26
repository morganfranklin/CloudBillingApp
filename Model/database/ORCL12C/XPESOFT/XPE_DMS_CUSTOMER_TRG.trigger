-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>XPE_DMS_CUSTOMER_TRG</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>XPE_DMS_CUSTOMER_TRG</name>
--         <identifier class="java.math.BigDecimal">52509010</identifier>
--         <schemaName>XPESOFT</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER XPE_DMS_CUSTOMER_TRG AFTER
  INSERT OR UPDATE ON XPE_DMS_CUSTOMER FOR EACH ROW BEGIN
  INSERT
  INTO XPE_DMS_CUSTOMER_ADT VALUES
    (
      :NEW.CUST_ID,
      :NEW.SET_ID,
      :NEW.COMPANY_NAME,
      :NEW.BILLING_ADDRESS1,
      :NEW.BILLING_ADDRESS2,
      :NEW.CITY,
      :NEW.STATE,
      :NEW.COUNTRY,
      :NEW.POSTAL,
      :NEW.MAILING_ADDRESS1,
      :NEW.MAILING_ADDRESS2,
      :NEW.MAILING_CITY,
      :NEW.MAILING_STATE,
      :NEW.MAILING_COUNTRY,
      :NEW.MAILING_POSTAL,
      :NEW.EMAIL,
      :NEW.PHONE_NUM,
      :NEW.CONTACT_TYPE,
      :NEW.CONTACT_NAME,
      :NEW.TITLE,
      :NEW.BUSINESS_TYPE,
      :NEW.PRODUCT_TIER,
      :NEW.CUSTOMER_TIER,
      :NEW.CREATED_BY,
      :NEW.LAST_UPDATED_BY,
      :NEW.CREATED_DATE,
      :NEW.LAST_UPDATED_DATE
    );
END;
/
