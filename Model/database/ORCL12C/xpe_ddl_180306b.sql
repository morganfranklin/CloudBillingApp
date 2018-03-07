SET SQLBLANKLINES ON

SPOOL XPE_DDL_180306B.LOG
--------------------------------------------------------
--  File created - Tuesday-March-06-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence PS_CIS_XPE_LOG_KEY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PS_CIS_XPE_LOG_KEY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 81 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PS_CIS_XPE_PROCESS_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PS_CIS_XPE_PROCESS_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 30383 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PS_CIS_XPE_PROCESS_REQ_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PS_CIS_XPE_PROCESS_REQ_ID_SEQ"  MINVALUE 2 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 2 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PS_PENDING_ITEM_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PS_PENDING_ITEM_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 900021 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PS_TXN_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PS_TXN_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 50 START WITH 18851 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_BI_LINE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_BI_LINE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 25001 CACHE 200 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_ACCRUAL_REVENUE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_ACCRUAL_REVENUE_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 141 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_BILLING_ACCOUNTING_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_BILLING_ACCOUNTING_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 221 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_ACCOUNTING_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_ACCOUNTING_SEQ"  MINVALUE 900000 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 900140 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_BUSINESSUNIT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_BUSINESSUNIT_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 900031 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_CARRIERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_CARRIERS_SEQ"  MINVALUE 900000 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 900080 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_COUNTIES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_COUNTIES_SEQ"  MINVALUE 900000 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 900060 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_DESTINATIONS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_DESTINATIONS_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_GENERAL_CNV_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_GENERAL_CNV_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_NOTIFICATION_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_NOTIFICATION_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_ORIGINS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_ORIGINS_SEQ"  MINVALUE 900000 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 900060 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_PCS_ADDRESS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_PCS_ADDRESS_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_PCS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_PCS_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_PCSSHORTNAMES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_PCSSHORTNAMES_SEQ"  MINVALUE 900000 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 900082 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_TERMINALS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_TERMINALS_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 900001 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CFG_VEHICLES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CFG_VEHICLES_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CONTRACT_CARRIER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CONTRACT_CARRIER_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 54241 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CONTRACT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CONTRACT_SEQ"  MINVALUE 100 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 520 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CONTRACT_VERSION_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CONTRACT_VERSION_SEQ"  MINVALUE 100 MAXVALUE 999999999 INCREMENT BY 1 START WITH 100 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_CONTRACTS_ATTACH_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_CONTRACTS_ATTACH_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_WF_ACTION_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_WF_ACTION_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 201 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DCC_WF_EVENT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DCC_WF_EVENT_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 261 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence XPE_DMS_CUSTOMER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "XPE_DMS_CUSTOMER_SEQ"  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 221 CACHE 20 NOORDER  NOCYCLE ;

SPOOL OFF;
