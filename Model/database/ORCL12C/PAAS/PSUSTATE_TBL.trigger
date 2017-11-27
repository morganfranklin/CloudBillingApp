-- <?xml version = '1.0' encoding = 'UTF-8'?>
-- <trigger xmlns="http://xmlns.oracle.com/jdeveloper/1211/offlinedb">
--   <name>PSUSTATE_TBL</name>
--   <enabled>true</enabled>
--   <properties>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_CONNECTION</key>
--       <value class="java.lang.String">fsuat91.neustar.com</value>
--     </entry>
--     <entry>
--       <key>OfflineDBConstants.IMPORT_SOURCE_ID</key>
--       <value class="oracle.javatools.db.ReferenceID">
--         <name>PSUSTATE_TBL</name>
--         <identifier class="java.math.BigDecimal">118946</identifier>
--         <schemaName>PAAS</schemaName>
--         <type>TRIGGER</type>
--       </value>
--     </entry>
--   </properties>
--   <statementLevel>true</statementLevel>
-- </trigger>

CREATE OR REPLACE
TRIGGER PSUSTATE_TBL BEFORE INSERT OR UPDATE ON PS_STATE_TBL FOR EACH ROW DECLARE PSSYSID number (31,0); pragma autonomous_transaction; BEGIN IF INSERTING THEN IF :new.SYNCID > 0 THEN :new.SYNCDTTM := SYSDATE; ELSE UPDATE PSSYSTEMID SET PTNEXTSYSTEMID = PTNEXTSYSTEMID + 1 WHERE RECNAME = 'STATE_TBL'; SELECT PTNEXTSYSTEMID INTO PSSYSID FROM PSSYSTEMID WHERE RECNAME='STATE_TBL'; :new.SYNCID:= PSSYSID; :new.SYNCDTTM := SYSDATE; END IF; ELSE :new.SYNCDTTM := SYSDATE; END IF; commit; END;
/
