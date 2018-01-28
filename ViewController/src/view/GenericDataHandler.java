package view;
//Version 2.0 10/07/2016 : 09:00am
//Change history maintained in accompanying track6

//Update 2.1 1/23/2018: 5:33pm EX2G and CSCR routines 
//Update 2.2 1/28/2018: 3:13pm process log changes, CSCR routine update

import java.io.File;
import java.io.FileInputStream;

import java.sql.*;

import java.lang.*;

import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.xml.bind.DatatypeConverter;

 // import oracle.sql.DATE;


public class GenericDataHandler implements Runnable {
    public GenericDataHandler() {
        super();
    }
    protected String execPlanId = "TEST_EXEC_PLAN";
    protected Date execFromDate = new Date(System.currentTimeMillis());
    protected Date execToDate = new Date(System.currentTimeMillis());
    protected String cfgFile = "";
    protected String userId = "";
    protected String runType = "PRD";

    protected static String env = "";
    private static String ps_config_user = "";
    private static String ps_config_passwd = "xxxxxxx";
    private static String ps_config_url = "";
    private static String ps_config_driver = "";

    // EX2G begin
    private ArrayList<ArrayList<String>> changesAuditLog = new ArrayList<ArrayList<String>>();
    private int connectionsInSet = 0;
	ArrayList<ExternalMappingDetails> mapping = new ArrayList<ExternalMappingDetails>();
    // EX2G end
    
    public void setExecutionParameters(String userPlanId, Date userDateFrom, Date userDateTo) {

        execPlanId = userPlanId;
        execFromDate = userDateFrom;
        execToDate = userDateTo;

    }

    public void setRunType(String userRunType) {

        runType = userRunType;
    }

    public void setConfig(String userCfgFile) {

        cfgFile = userCfgFile;
    }

    public void setUserId(String userIdSelected) {

        userId = userIdSelected;
    }

    public void setEnv(String userEnv) {

        env = userEnv;
    }

    public void run() {

        this.executeMainLine();
        System.out.println("INFO finished executing the test plan, terminating current thread");

    }

    public static class ProjectVariable {
        String execPlanCode;
        String ruleSetCode;
        Date execDate;
        String billCycleInfo;
        Connection configdb;
        String stage;
        String transInOut;
        String execStep;
        int processId;
        int processRequestId;
        int execSeq;
        String userId;
        String ruleName;
        int loggerId;


        ProjectVariable() {
        }

        public void setextPlanCode(String execPlanCode) {
            this.execPlanCode = execPlanCode;
            //               System.out.println("in Setter: " +  execPlanCode );
        }

        public void setruleSetCode(String ruleSetCode) {
            this.ruleSetCode = ruleSetCode;
            //               System.out.println("in Setter: " +  ruleSetCode );
        }

        public void setexecDate(Date execDate) {
            this.execDate = execDate;
        }

        public void setbillCycleInfo(String billCycleInfo) {
            this.billCycleInfo = billCycleInfo;
        }

        public void setconfigDb(Connection configdb) {
            this.configdb = configdb;
        }

        public void setstage(String stage) {
            this.stage = stage;
        }

        public void settransInOut(String transInOut) {
            this.transInOut = transInOut;
        }

        public void setexecStep(String execStep) {
            this.execStep = execStep;
        }

        public void setprocessId(int processId) {
            this.processId = processId;
        }

        public void setprocessRequestId(int processRequestId) {
            this.processRequestId = processRequestId;
        }

        public void setexecSeq(int execSeq) {
            this.execSeq = execSeq;
        }

        public void setuserId(String userId) {
            this.userId = userId;
        }

        public void setruleName(String ruleName) {
            this.ruleName = ruleName;
        }

        public void setloggerId(int loggerId) {
            this.loggerId = loggerId;
        }
        //===========================================================
        public String getextPlanCode() {
            return (execPlanCode);
        }

        public String getruleSetCode() {
            return (ruleSetCode);
        }

        public Date getExecDate() {
            return (execDate);
        }

        public String getbillCycleInfo() {
            return (billCycleInfo);
        }

        public Connection getconfigDb() {
            return (configdb);
        }

        public String getstage() {
            return (stage);
        }

        public String gettransInOut() {
            return (transInOut);
        }

        public String getexecStep() {
            return (execStep);
        }

        public int getprocessId() {
            return (processId);
        }

        public int getprocessRequestId() {
            return (processRequestId);
        }

        public int getexecSeq() {
            return (execSeq);
        }

        public String getuserId() {
            return (userId);
        }

        public String getruleName() {
            return (ruleName);
        }

        public int getloggerId() {
            return (loggerId);
        }
    }

    public Connection connectConfigDb(String url, String driver, String user, String passwd) {
        Connection conndb = null;
        try {
            Class.forName(driver);
            conndb = DriverManager.getConnection(url, user, passwd);
            System.out.println("Config db Connection is created...");

        } catch (Exception e) {
            System.out.println(e);
        }
        return conndb;
    }

    
    /* EX2G BEGIN */
    
    public Connection connectSourceDb(Connection configdb, String platform_id) {
        Connection sourcedb = null;

        ResultSet myResultSet = null;
        Statement sqlStatement = null;
        
        try {
            sqlStatement = configdb.createStatement();
            String readRecordSQL =
                "select dbname, connectstring, userid, cur_connect_pwd, cis_connect_driver " + " from PS_CIS_XPE_CONN where in_platform = " +
                "'" + platform_id + "'";

            //         System.out.println("readRecordSQL : " + readRecordSQL);

            myResultSet = sqlStatement.executeQuery(readRecordSQL);
            while (myResultSet.next()) {
                String db_name = myResultSet.getString("dbname");
                String url = myResultSet.getString("connectstring");
                String user_name = myResultSet.getString("userid");
                String password = myResultSet.getString("cur_connect_pwd");
                String driver = myResultSet.getString("cis_connect_driver");

                //              System.out.println("Record values : " +  db_name + "--" +  url + "--" +  user_name + "--" +  password + "--" +  driver);

                //get details for the source db
                Class.forName(driver);
                sourcedb = DriverManager.getConnection(url, user_name, password);
                System.out.println("Source db Connection is created...");

            }
            myResultSet.close();

            
            
        } catch (Exception e) {
            System.out.println(e);
        } finally {
        	try { myResultSet.close(); } catch (Exception ignore) { }
        	try { sqlStatement.close(); } catch (Exception ignore) { }
        }
        
        return sourcedb;
        
    }

    
    protected class ExternalMappingDetails {
    	
    	protected String sourceField, targetField, isKey, whereClause, auditTable;
    	
    	protected void printDescriptionToBuffer() {
    		System.out.println("sourceField:"+sourceField);
    		System.out.println("targetField:"+targetField);
    		System.out.println("isKey:"+isKey);
    		System.out.println("whereClause:"+whereClause);
    		System.out.println("whereClause:"+auditTable);
    		
    	}
    	
    }
    
    private int getNumberOfKeys(ArrayList<ExternalMappingDetails> mapping) {
    	
    	int foundKeys = 0;

    	ExternalMappingDetails mappingElement=null;
    	
    	for (int mappingCounter=0; mappingCounter<mapping.size(); mappingCounter++) {
    		
    		mappingElement = mapping.get(mappingCounter);
    		
    		if (mappingElement.isKey.equalsIgnoreCase("Y")) {
    			
    			foundKeys++;
    			
    		}
    		
    	}
    	
    	return foundKeys;
    	
    }
    
    private ArrayList<String> getTargetData(Connection targetDbConnection,
    		ArrayList<ExternalMappingDetails> mapping, ArrayList<String> keySet,
    		String targetTableName) {
    	
    	ArrayList<String> targetDataBuffer = new ArrayList<String>();
    	PreparedStatement extractorStatement = null;
    	ResultSet extractedData = null;
    	int resultSetCounter=0;
    	String extractorSQL=this.getDataTargetCurrentExtractSQL(mapping, keySet, targetTableName);
    	
    	System.out.println("current target data extractor sql: "+extractorSQL);
    	
    	try {
			
    		extractorStatement = targetDbConnection.
    				prepareStatement(extractorSQL);
    		
    		extractedData = extractorStatement.executeQuery();
    		
    		if (extractedData.next()) {
    			
    			for (resultSetCounter=0; resultSetCounter<mapping.size(); resultSetCounter++) {
    				extractorSQL=extractedData.getString(resultSetCounter+1);
    				// System.out.println("extracted field: "+extractorSQL);
    				targetDataBuffer.add(extractorSQL);
    			}
    			
    		}
    		
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	    	try { extractedData.close(); } catch (Exception ignore) { }
	    	try { extractorStatement.close(); } catch (Exception ignore) { }
	    }
    	
		for (resultSetCounter=0; resultSetCounter<targetDataBuffer.size(); resultSetCounter++) {
			System.out.println("targetDataBuffer("+resultSetCounter+"):"+targetDataBuffer.get(resultSetCounter));
		}
    	
    	return targetDataBuffer;
    	
    }
    
    private ArrayList<String> getSourceData(Connection sourceDbConnection, 
    		ArrayList<ExternalMappingDetails> mapping, ArrayList<String> keySet) {
    	
    	ArrayList<String> sourceDataBuffer = new ArrayList<String>();
    	PreparedStatement extractorStatement = null;
    	ResultSet extractedData = null;
    	int resultSetCounter=0;
    	String extractorSQL=this.getDataSourceExtractSQL(mapping, keySet);
    	
    	System.out.println("extractor sql: "+extractorSQL);
    	
    	try {
			
    		extractorStatement = sourceDbConnection.
    				prepareStatement(extractorSQL);
    		
    		extractedData = extractorStatement.executeQuery();
    		
    		if (extractedData.next()) {
    			
    			for (resultSetCounter=0; resultSetCounter<mapping.size(); resultSetCounter++) {
    				extractorSQL=extractedData.getString(resultSetCounter+1);
    				// System.out.println("extracted field: "+extractorSQL);
    				sourceDataBuffer.add(extractorSQL);
    			}
    			
    		}
    		
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	    	try { extractedData.close(); } catch (Exception ignore) { }
	    	try { extractorStatement.close(); } catch (Exception ignore) { }
	    }
    	
		for (resultSetCounter=0; resultSetCounter<sourceDataBuffer.size(); resultSetCounter++) {
			System.out.println("sourceDataBuffer("+resultSetCounter+"):"+sourceDataBuffer.get(resultSetCounter));
		}
    	
    	return sourceDataBuffer;
    	
    }
    
    private String getDataSourceExtractSQL(ArrayList<ExternalMappingDetails> mapping, ArrayList<String> keySet) {
    
    	String extractorSQL = "select ";
    	ExternalMappingDetails mappingElement=null;
    	
    	for (int mappingCounter=0; mappingCounter<mapping.size(); mappingCounter++) {
    		
    		mappingElement = mapping.get(mappingCounter);
    		
    		extractorSQL = extractorSQL + mappingElement.sourceField;
    		
    		if (mappingCounter<mapping.size()-1) {
    			if (mappingElement.whereClause==null) {
        			extractorSQL = extractorSQL + " , ";
    			} else {
        			extractorSQL = extractorSQL + mappingElement.whereClause + " , ";
    			}
    		}
    		
    	}
    	
    	extractorSQL = extractorSQL + " " + mappingElement.whereClause + this.getSourceExtractorLimiterSQL(mapping, keySet, returnLinkSegment(mappingElement.whereClause));
    	
    	return extractorSQL;
    }
    
    private boolean compareSourceAndTarget(ArrayList<String> sourceData, ArrayList<String> targetData,
    		ArrayList<ExternalMappingDetails> mapping) {
    	
    	boolean foundDifference = false;
    	
    	for (int keyCounter=0; keyCounter<sourceData.size() 
    			&& keyCounter<targetData.size()
    			&& foundDifference==false; keyCounter++) {
    		
    		if (sourceData.get(keyCounter)==null || sourceData.get(keyCounter)==null) {
    			
    			if (sourceData.get(keyCounter)!=null || sourceData.get(keyCounter)!=null) {
    				System.out.println("found difference at ("+keyCounter+"): one is null other not");
        			foundDifference = true;    				
    			}
    			
    		} else {
    			
    			if (mapping.get(keyCounter).isKey.equalsIgnoreCase("T")) {
    				
    				if (sourceData.get(keyCounter).substring(0, 18).
    						equals(targetData.get(keyCounter).substring(0, 18))==false) {
            			System.out.println("found difference at ("+keyCounter+"): source:"
            					+sourceData.get(keyCounter)+" != target:"
            					+targetData.get(keyCounter));
            			foundDifference = true;
            		}
    				
    			} else {

    				if (sourceData.get(keyCounter).equals(targetData.get(keyCounter))==false) {
            			System.out.println("found difference at ("+keyCounter+"): source:"
            					+sourceData.get(keyCounter)+" != target:"
            					+targetData.get(keyCounter));
            			foundDifference = true;
            		}
    				
    			}
    			

    		}
    		
    	}
    	
    	return foundDifference;
    }

    private String getDataTargetCurrentExtractSQL(ArrayList<ExternalMappingDetails> mapping, ArrayList<String> keySet,
    		String targetTableName) {

    	String extractorSQL = "select ";
    	ExternalMappingDetails mappingElement=null;
    	
    	for (int mappingCounter=0; mappingCounter<mapping.size(); mappingCounter++) {
    		
    		mappingElement = mapping.get(mappingCounter);
    		
    		extractorSQL = extractorSQL + mappingElement.targetField;
    		
    		if (mappingCounter<mapping.size()-1) {
        		extractorSQL = extractorSQL + " , ";
    		}
    		
    	}
    	
    	extractorSQL = extractorSQL + " from " + targetTableName + this.getTargetExtractorLimiterSQL(mapping, keySet);
    	
    	return extractorSQL;
    }
    
    private int getNumberOfMatchingTargets(Connection targetDatabase, 
    		ArrayList<ExternalMappingDetails> mapping, ArrayList<String> keySet,
    		String targetTableName) {
    	
    	int foundTargets = 0;
    	String seekerSQL = this.getTargetExistsCheckerSQL(mapping, keySet, targetTableName);
    	
    	System.out.println("seeker sql:"+seekerSQL);
    	
    	PreparedStatement sqlStatement = null;
    	ResultSet foundKeySet = null;

    	try {
			
    		sqlStatement = targetDatabase.prepareStatement(seekerSQL);
			
    		foundKeySet = sqlStatement.executeQuery();
    		
    		if (foundKeySet.next()) {
    			foundTargets = foundKeySet.getInt(1);
    		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	    	try { foundKeySet.close(); } catch (Exception ignore) { }
	    	try { sqlStatement.close(); } catch (Exception ignore) { }
	    }
    	
    	return foundTargets;
    	
    }
    
    private int updateTarget(Connection dbTargetConnection, ArrayList<ExternalMappingDetails> mapping,
    		String targetTableName, ArrayList<String> sourceData, ArrayList<String> keySet,
    		int keySize) {
    	
    	String updateSQL = "update "+targetTableName+" set ";
    	int fieldCounter = 0, updatedRows = 0;
    	PreparedStatement updateStatement = null;
    	
    	for (fieldCounter = keySize; fieldCounter<mapping.size(); fieldCounter++) {
    		
    		if (sourceData.get(fieldCounter)==null) {
    			
    			updateSQL = updateSQL + mapping.get(fieldCounter).targetField + " = nUlL "; 
    			
    		} else {
    			
        		if (mapping.get(fieldCounter).isKey.equalsIgnoreCase("T")) {
            		
        			updateSQL = updateSQL + mapping.get(fieldCounter).targetField + " = TO_TIMESTAMP('"
            				+ sourceData.get(fieldCounter) + "' , 'YYYY-MM-DD HH24:MI:SS.FF') ";

        		} else {
        			
            		updateSQL = updateSQL + mapping.get(fieldCounter).targetField + " = '"
            				+ sourceData.get(fieldCounter) + "' ";

        		}

    		}
    		
    		if (fieldCounter<mapping.size()-1) {
    			updateSQL = updateSQL + " , ";
    		}
    		
    	}
    	
    	updateSQL = updateSQL + this.getTargetExtractorLimiterSQL(mapping, keySet);
    	
    	System.out.println("target data update sql: "+updateSQL);
    	
    	try {
    		
			updateStatement = dbTargetConnection.prepareStatement(updateSQL);
			updatedRows = updateStatement.executeUpdate();
			
			System.out.println("updated rows: "+updatedRows );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	    	try { updateStatement.close(); } catch (Exception ignore) { }
	    }
    	
    	return updatedRows;

    }
    
    private int insertIntoTarget(Connection dbTargetConnection, ArrayList<ExternalMappingDetails> mapping,
    		String targetTableName, ArrayList<String> sourceData) {
    	
    	String insertSQL = "insert into "+targetTableName+" ( ";
    	int fieldCounter = 0, insertedRows = 0;
    	PreparedStatement insertStatement = null;
    	
    	for (fieldCounter = 0; fieldCounter<mapping.size(); fieldCounter++) {
    		
    		insertSQL = insertSQL + mapping.get(fieldCounter).targetField;
    	
    		if (fieldCounter<mapping.size()-1) {
    			insertSQL = insertSQL + " , ";
    		}
    		
    	}
    	
    	insertSQL = insertSQL + " ) values ( ";

    	for (fieldCounter = 0; fieldCounter<sourceData.size(); fieldCounter++) {

    		if (sourceData.get(fieldCounter)==null) {
    			insertSQL = insertSQL + " NuLL ";
    		} else {
    			
        		if (mapping.get(fieldCounter).isKey.equalsIgnoreCase("T")) {
            		insertSQL = insertSQL + " TO_TIMESTAMP('" + sourceData.get(fieldCounter) + "' , 'YYYY-MM-DD HH24:MI:SS.FF') ";
        		} else {
            		insertSQL = insertSQL + " '" + sourceData.get(fieldCounter) + "' ";
        		}
        		
    		}
    			
    		if (fieldCounter<sourceData.size()-1) {
    			insertSQL = insertSQL + " , ";
    		}
    		
    	}
    	
    	insertSQL = insertSQL + " ) ";

    	System.out.println("insert statement: "+insertSQL);
    	
    	try {
			insertStatement = dbTargetConnection.prepareStatement(insertSQL);
			insertedRows = insertStatement.executeUpdate();
			System.out.println("inserted rows: "+insertedRows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	    	try { insertStatement.close(); } catch (Exception ignore) { }
	    }
    	
    	return insertedRows;
    	
    }
    
    private boolean isAuditRequired() {
    	
    	boolean localResult = false;
    	
    	if (mapping.size()>=1) {
    		if (mapping.get(mapping.size()-1).auditTable!=null) {
        		localResult=mapping.get(mapping.size()-1).auditTable.isEmpty()==false;
    		}
    	}
    	
    	return localResult;
    	
    }
    
    private void iterateBasedOnMapping(Connection dbSourceConnection, 
    		Connection dbTargetConnection, ArrayList<ExternalMappingDetails> mapping,
    		String targetTableName, String insertUpdateMode, int maxRowsParameter) {
    	
    	PreparedStatement sqlStatement;
    	ResultSet foundKeySet;
    	int numOfKeys=this.getNumberOfKeys(mapping), numberOfMatchingRecordsAtTarget=0, maxRows=Integer.MAX_VALUE,
    			rowsCounter=0, changedRows = 0, keyElementsCounter=0;
    	ArrayList<String> singleKeyEntry = new ArrayList<String>(), sourceData = null, targetData = null;
    	boolean needsAudit = isAuditRequired();
    	
    	if (maxRowsParameter>=0) {
    		maxRows=maxRowsParameter;
    	}
    	
    	try {
			
    		sqlStatement = dbSourceConnection.prepareStatement(this.getKeyIterationSQL(mapping));
    		foundKeySet = sqlStatement.executeQuery();
    		
    		while (foundKeySet.next() && rowsCounter<maxRows) {
    			
    			rowsCounter++;
    			changedRows = 0;
    			
    			singleKeyEntry.clear();
    			
    			for (keyElementsCounter=0; keyElementsCounter<numOfKeys; keyElementsCounter++) {
    				singleKeyEntry.add(foundKeySet.getString(keyElementsCounter+1));
    				System.out.println("singleKeyEntry:"+singleKeyEntry.get(singleKeyEntry.size()-1));
    			}

    			numberOfMatchingRecordsAtTarget = getNumberOfMatchingTargets(dbTargetConnection, mapping, singleKeyEntry, targetTableName); 
				// System.out.println("number of matching target records: "+numberOfMatchingRecordsAtTarget);
				
				if (numberOfMatchingRecordsAtTarget<=0 
						|| insertUpdateMode.equalsIgnoreCase("U")
						|| insertUpdateMode.equalsIgnoreCase("A")) {
					System.out.println("number of matching target records: "+numberOfMatchingRecordsAtTarget
							+" or insertUpdateMode=" + insertUpdateMode 
							+ " therefore source data extract needed...");
					sourceData = this.getSourceData(dbSourceConnection, mapping, singleKeyEntry);

					if (numberOfMatchingRecordsAtTarget<=0) {
						
						changedRows = this.insertIntoTarget(dbTargetConnection, mapping, targetTableName, sourceData);
						
					} else {
						
						// System.out.println("data will be extracted using sql: "+this.getDataTargetCurrentExtractSQL(mapping, singleKeyEntry, targetTableName));
						System.out.println("extracting current target data...");
						targetData = this.getTargetData(dbTargetConnection, mapping, singleKeyEntry, targetTableName);
						
						System.out.println("comparing source and target data...");
						
						if (compareSourceAndTarget(sourceData, targetData, mapping)==true) {
							
							changedRows = this.updateTarget(dbTargetConnection, mapping, targetTableName, sourceData, singleKeyEntry, numOfKeys);
							
						}
						
					}

				}
				
				if (changedRows != -1 && needsAudit) {
					// System.out.println("attempting to update the audit table");
					changesAuditLog.add(singleKeyEntry);
					singleKeyEntry = new ArrayList<String>();
					
				}

    		}
    		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    private int foundOtherOccurences(ArrayList<String> currentKey, int currentPosition) {
    	
    	int foundOtherKeys = 1, currentSearch, keyCounter;
    	boolean isTheSame;
    	
    	for (currentSearch=changesAuditLog.size()-1; currentSearch>currentPosition; currentSearch--) {
    		
    		isTheSame=true;
    		
    		for (keyCounter=0; keyCounter<changesAuditLog.get(currentSearch).size(); keyCounter++) {
    			
    			if (changesAuditLog.get(currentSearch).get(keyCounter).
    					equalsIgnoreCase(currentKey.get(keyCounter))==false) {
    				isTheSame = false;
    			}
    			
    		}
    		
    		if (isTheSame) {
    			foundOtherKeys++;
    			changesAuditLog.remove(currentSearch);
    		}
    		
    	}
    	
    	return foundOtherKeys;
    	
    }
    
    private String cleanKeyForAudit(String keyValue) {
    	
    	String localKey = keyValue;
    	
    	// System.out.println("in: "+localKey);
    	
    	if (localKey.indexOf("||")>=0) {
        	localKey = localKey.substring(0, localKey.indexOf("||"));
    	}
    	
    	if (localKey.indexOf(".")>=0) {
        	localKey = localKey.substring(localKey.indexOf(".")+1, localKey.length());
    	}
    	
    	// System.out.println("out: "+localKey);
    	
    	return localKey;
    	
    }
    
    private String cleanValueForAudit(String keyValue, String auditTable) {
    	
    	String localKey = keyValue;
    	
    	// System.out.println("audit table: "+auditTable);
    	
    	if (auditTable.contentEquals("XPE_DCC_CFG_PCSSHTNAMES_ADT")) {
    	
    		localKey = keyValue.substring(0, keyValue.length()-1);
    		
    	}
    	
    	return localKey;
    	
    }
    
    /* 
     * This method writes all key entries accumulates in changesAuditLog into log table indicated in app_tbl_name
     * field in the last row of mapping (along with where clause).  Since it is executed after the loop of all
     * connections finding connection patter the assumption / limitation is that either all tables looped
     * have the same key structure, log table name. Since connection pattern is declared at action detail level,
     * recommendation is to declare to mapping entries underneath, both with the same key structure and 
     * audit table, but possibly different mapping (if differences exists, e.g. need for declaring table schema)
     */
	private void writeAudit(Connection dbSourceConnection) {

		int rowsCounter, keyElementsCounter, foundOthersCount;
		String auditLogUpdate, newStatus;
		ArrayList<String> currentKeySet;

		if (isAuditRequired() && changesAuditLog.size()>0) {

			System.out.println("----> audit log write begin, changes logged against " + connectionsInSet + " targets");

			for (rowsCounter = 0; rowsCounter < changesAuditLog.size(); rowsCounter++) {

				currentKeySet = changesAuditLog.get(rowsCounter);
				foundOthersCount = foundOtherOccurences(currentKeySet, rowsCounter);
				PreparedStatement updateStatement = null;

				if (foundOthersCount == connectionsInSet) {
					newStatus = "D";
				} else {
					newStatus = "P";
				}

				auditLogUpdate = "UPDATE " + mapping.get(mapping.size() - 1).auditTable + " SET SYNCDONE='" + newStatus
						+ "', SYNCDONEAT=SYSDATE WHERE ";

				for (keyElementsCounter = 0; keyElementsCounter < changesAuditLog.get(rowsCounter)
						.size(); keyElementsCounter++) {

					System.out.println("log element(" + rowsCounter + "." + keyElementsCounter + ")="
							+ changesAuditLog.get(rowsCounter).get(keyElementsCounter));

					auditLogUpdate = auditLogUpdate + cleanKeyForAudit(mapping.get(keyElementsCounter).sourceField) + "='"
							+ cleanValueForAudit(changesAuditLog.get(rowsCounter).get(keyElementsCounter), 
									mapping.get(mapping.size() - 1).auditTable ) + "' ";

				}

				System.out.println("total other key occurences found: " + foundOthersCount);
				auditLogUpdate = auditLogUpdate + " AND SYNCDONE IN ('N','E','P') ";
				System.out.println("auditLogUpdate sql: " + auditLogUpdate);

				try {
					updateStatement = dbSourceConnection.prepareStatement(auditLogUpdate);
					System.out.println("updated logs count:" + updateStatement.executeUpdate());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						updateStatement.close();
					} catch (Exception ignore) {
					}
				}

			}

			changesAuditLog.clear();
			// mapping.clear();
			System.out.println("<---- audit log write end");

		} else {
			System.out.println("...no audit write needed");
		}
		
	}
        
    private String getTargetExtractorLimiterSQL(ArrayList<ExternalMappingDetails> mapping, ArrayList<String> keySet) {
    	
    	String sqlStatement = " where ";
    	ExternalMappingDetails mappingElement=null;
    	
    	for (int mappingCounter=0; mappingCounter<mapping.size(); mappingCounter++) {
    		
    		mappingElement = mapping.get(mappingCounter);
    		
    		if (mappingElement.isKey.equalsIgnoreCase("Y")) {
    			
    			sqlStatement = sqlStatement + mappingElement.targetField + " = '"
    					+ keySet.get(mappingCounter)
    					+ "' AND ";
    			
    		}
    		
    	}
    	
    	sqlStatement = sqlStatement + " 1974=1974 ";
    	
    	return sqlStatement;

    }
    
    private String returnLinkSegment(String givenSelection) {
    
    	String currentLink = " where ";
    	
    	if (givenSelection.contains("where") || givenSelection.contains("WHERE")) {
    		currentLink = " and ";
    	}
    	
    	return currentLink;
    	
    }
    
    private String getSourceExtractorLimiterSQL(ArrayList<ExternalMappingDetails> mapping, ArrayList<String> keySet, String linkSegment) {

    	String sqlStatement = linkSegment ;
    	ExternalMappingDetails mappingElement=null;
    	
    	for (int mappingCounter=0; mappingCounter<mapping.size(); mappingCounter++) {
    		
    		mappingElement = mapping.get(mappingCounter);
    		
    		if (mappingElement.isKey.equalsIgnoreCase("Y")) {
    			
    			sqlStatement = sqlStatement + mappingElement.sourceField + " = '"
    					+ keySet.get(mappingCounter)
    					+ "' AND ";
    			
    		}
    		
    	}
    	
    	sqlStatement = sqlStatement + " 1978=1978 ";
    	
    	return sqlStatement;
    	
    }
    
    private String getTargetExistsCheckerSQL(ArrayList<ExternalMappingDetails> mapping, ArrayList<String> keySet,
    		String targetTableName) {
    	
    	String sqlStatement = "select count(*) from " + targetTableName + " where ";
    	ExternalMappingDetails mappingElement=null;
    	
    	for (int mappingCounter=0; mappingCounter<mapping.size(); mappingCounter++) {
    		
    		mappingElement = mapping.get(mappingCounter);
    		
    		if (mappingElement.isKey.equalsIgnoreCase("Y")) {
    			
    			sqlStatement = sqlStatement + mappingElement.targetField + " = '"
    					+ keySet.get(mappingCounter)
    					+ "' AND ";
    			
    		}
    		
    	}
    	
    	sqlStatement = sqlStatement + " 2011=2011 ";
    	
    	return sqlStatement;
    	
    }
    
    private String getKeyIterationSQL(ArrayList<ExternalMappingDetails> mapping) {
    	
    	String sqlStatement = "select ";
    	ExternalMappingDetails mappingElement=null;
    	
    	for (int mappingCounter=0; mappingCounter<mapping.size(); mappingCounter++) {
    		
    		mappingElement = mapping.get(mappingCounter);
    		
    		if (mappingElement.isKey.equalsIgnoreCase("Y")) {
    			
    			sqlStatement = sqlStatement + mappingElement.sourceField + ", ";
    			
    		}
    		
    	}
    	
		sqlStatement = sqlStatement + " 0 " + mappingElement.whereClause;
    	return sqlStatement;
    	
    }
    
    private void externalExecuteMapping(Connection givenSource, Connection givenTarget,
    		String insertUpdateMode, String directionMode, int maxRows, String actionCode, String detailCode) {
    	
    	String currentTableName = "";
    	PreparedStatement sqlStatement, sqlStatement2;
    	ResultSet myResultSet, myResultSet2; 
    	ExternalMappingDetails currentMappingEntry = null;
    	int numberOfKeys = 0;
    	
    	System.out.println("----- > entering externalExecuteMapping");
    	System.out.println("givenSource:"+givenSource.toString());
    	System.out.println("givenTarget:"+givenTarget.toString());
    	System.out.println("actionCode:"+actionCode);
    	System.out.println("detailCode:"+detailCode);
    	
    	mapping.clear();//180114
    	
		String sqlStatementBody = "select tablename from ps_cis_xpe_mapping where cis_action_code = ? ";
		
		try {
			
			sqlStatement = givenTarget.prepareStatement(sqlStatementBody);
			// 180114 sqlStatement.setString(1, actionCode);
			sqlStatement.setString(1, detailCode);
			System.out.println("searched mapping for action code = "+detailCode);

			myResultSet = sqlStatement.executeQuery();

			while (myResultSet.next()) {
				
				currentTableName = myResultSet.getString(1);
				System.out.println("currentTableName:"+currentTableName);
				System.out.println("actionCode:"+actionCode);
				
				sqlStatementBody = "select generic_field, cis_native_field, is_key, where_clause1, app_tbl_name from ps_cis_xpe_map_dtl where tablename = ? and cis_action_code = ? order by seqno";
				
				sqlStatement2 = givenTarget.prepareStatement(sqlStatementBody);
				sqlStatement2.setString(1, currentTableName);
				// 180114 sqlStatement2.setString(2, actionCode);
				sqlStatement2.setString(2, detailCode);
				
				myResultSet2 = sqlStatement2.executeQuery();
				
				while (myResultSet2.next()) {
					
					currentMappingEntry = new ExternalMappingDetails();
					
					currentMappingEntry.sourceField = myResultSet2.getString(1);
					currentMappingEntry.targetField = myResultSet2.getString(2);
					currentMappingEntry.isKey = myResultSet2.getString(3);
					currentMappingEntry.whereClause = myResultSet2.getString(4);
					currentMappingEntry.auditTable= myResultSet2.getString(5);
					// currentMappingEntry.printDescriptionToBuffer();
					mapping.add(currentMappingEntry);
					
				}
				
		    	for (int mappingCounter=0; mappingCounter<mapping.size(); mappingCounter++) {
		        	System.out.println("... mapping details("+mappingCounter+")");
		        	mapping.get(mappingCounter).printDescriptionToBuffer();
		    	}
		    	
		    	System.out.println("iterator sql:"+this.getKeyIterationSQL(mapping));
		    	System.out.println("num of keys:"+this.getNumberOfKeys(mapping));
		    	
		    	// 180112 begin
		    	if (directionMode.contentEquals("O")) {
			    	iterateBasedOnMapping(givenTarget, givenSource, mapping, currentTableName, insertUpdateMode,
			    			maxRows);
		    	} else {
			    	// 180112 original
			    	iterateBasedOnMapping(givenSource, givenTarget, mapping, currentTableName, insertUpdateMode,
			    			maxRows);
		    	}
		    	// 180112 end
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	System.out.println("< ----- exiting externalExecuteMapping");

    }
    
    public int executeScript(ProjectVariable projShare, String actionCode) {

    	Connection commonConfigdb = projShare.getconfigDb();
    	String sqlStatementBody = "", connectionPattern = "";
    	ResultSet myResultSet = null;
    	PreparedStatement sqlStatement = null;
    	boolean hadResults=false;
    	int localResult=0;
    			
    	System.out.println("----> entering executeScript");
    	
    	try {
    		
        	sqlStatementBody = "select cis_custom_sql from ps_cis_xpe_act_dtl where cis_action_code = ? order by dtl_seq_nbr";
			sqlStatement = commonConfigdb.prepareStatement(sqlStatementBody);
			
			sqlStatement.setString(1, actionCode);
			
			myResultSet = sqlStatement.executeQuery();

			System.out.println("... executing " + sqlStatementBody);
			
			while (myResultSet.next()) {
				
				connectionPattern = myResultSet.getString(1);

				System.out.println("----> entering pl/sql " + connectionPattern );
		    			
				CallableStatement cstmt = commonConfigdb.prepareCall("{CALL "+connectionPattern+"}");
				cstmt.executeUpdate();

				System.out.println("<---- exiting pl/sql ");

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	System.out.println("<---- exiting executeScript");
    	
    	return localResult;
    }
    


    public int external2Generic(ProjectVariable projShare, String actionCode) {
    	
    	int resultCode=0, maximumRows = -1;
    	PreparedStatement sqlStatement = null, sqlStatement2 = null;
    	Connection commonConfigdb = null, externalConfigdb = null;
    	String sqlStatementBody = "", connectionPattern = "", connectionName = "", insertUpdateMode="A", directionMode="O",
    			detailCode="unknown/ignored from the original XPE mainline";
    	ResultSet myResultSet = null, myResultSet2 = null;
    	
        System.out.println("---- > entering external2Generic for " + actionCode + ":" + detailCode);
        
        commonConfigdb = projShare.getconfigDb();
        
        try {
        
			// multiple details now allowed sqlStatementBody = "select cis_operator1, cis_operator2, parm_1, parm_2 from ps_cis_xpe_act_dtl where cis_action_code = ? and cis_detail_code = ? and parm_1!=0 order by dtl_seq_nbr";
        	sqlStatementBody = "select cis_operator1, cis_operator2, parm_1, parm_2, cis_detail_code from ps_cis_xpe_act_dtl where cis_action_code = ? and parm_1!=0 order by dtl_seq_nbr";
			sqlStatement = commonConfigdb.prepareStatement(sqlStatementBody);
			
			sqlStatement.setString(1, actionCode);
			
			myResultSet = sqlStatement.executeQuery();

			System.out.println("... executing " + sqlStatementBody);
			
			while (myResultSet.next()) {
				
				connectionPattern = myResultSet.getString(1);
				insertUpdateMode =  myResultSet.getString(2);
				maximumRows = myResultSet.getInt(3);
				directionMode = myResultSet.getString(4);
				detailCode = myResultSet.getString(5); //180114
				
				System.out.println("connectionPattern:"+connectionPattern );
				System.out.println("insertUpdateMode:"+insertUpdateMode );
				System.out.println("maximumRows:"+maximumRows );
				System.out.println("directionMode:"+directionMode );
				System.out.println("detailCode:"+detailCode );
				
				sqlStatementBody = "select in_platform from ps_cis_xpe_conn where in_platform like ?";
				sqlStatement2 = commonConfigdb.prepareStatement(sqlStatementBody); 
				
				sqlStatement2.setString(1, connectionPattern);
				
				myResultSet2 = sqlStatement2.executeQuery();
				
				while (myResultSet2.next()) {
					
					connectionName = myResultSet2.getString(1);

					System.out.println("found connection definition:"+connectionName);
					connectionsInSet++;

					externalConfigdb = connectSourceDb(commonConfigdb, connectionName);
					
					// externalExecuteMapping(externalConfigdb, commonConfigdb, insertUpdateMode, 
					// 			directionMode, maximumRows, detailCode);
					externalExecuteMapping(externalConfigdb, commonConfigdb, insertUpdateMode, 
								directionMode, maximumRows, actionCode, detailCode);
					
				}
				
				// mapping.clear();
			
			}
			
			this.writeAudit(commonConfigdb);
			connectionsInSet=0;

        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


        System.out.println("< ---- exiting external2Generic");
        
    	return resultCode;
    	
    }
    
    /* E2G END */
    
    public int source2generic_ver3(ProjectVariable projShare, String action_code, String detailCode) {

        String module = "source2generic";
        // init insert stmt
        String insertSql = "insert into ";
        String insertSql_2 = " SELECT  ";
        String insertSql_3 = " group by   ";
        String whereClause = "";
        String errorMsg = module;
        int message_date_pointer = 4;

        String insertGenericFields = "";
        String insertGenericFieldsSum = "";
        String insertGenericFieldsSumMonth = "";

        String insertNativeSelect = "";

        String insertStmt = null;
        String insertAgg = "";
        String insertAgg_for_month = "";

        String mapp_detail_table_name = "";
        String mapp_detail_generic_field;
        String mapp_detail_native_field;
        String mapp_detail_constant_field;
        String mapp_detail_is_key;
        String mapp_detail_where_field;
        String mapp_detail_target_table = "";
        String mapp_detail_agg;
        String mapp_detail_target_field = "";
        String billing_cylcle_id = "";
        String billing_cylcle_info = "";

        int result = 0;

        String whereHistory = "";
        //count of records
        int mapp_detail_cnt = 0;

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String stage = "1-IMPORT";
        String trans_in_out = "1-IN";
        projShare.setstage(stage);
        projShare.settransInOut(trans_in_out);
        String execPlanCode = projShare.getextPlanCode();
        Date execDate = projShare.getExecDate();
        String execDateStr = df.format(execDate);
        System.out.println("execDate =  " + execDateStr);
        Connection configdb = projShare.getconfigDb();
        String billing_cylcle_id_str; // Passed as parameter

        System.out.println("execFromDate...=  " + execFromDate);
        System.out.println("execToDate... =  " + execToDate);

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        final String stringDt_execFrom = dateFormat1.format(execFromDate);
        final java.sql.Date sql_execFromDate = java.sql.Date.valueOf(stringDt_execFrom);
        System.out.println("sql_execFromDate :  " + sql_execFromDate);

        final String stringDt_execTo = dateFormat1.format(execToDate);
        final java.sql.Date sql_execToDate = java.sql.Date.valueOf(stringDt_execTo);
        System.out.println("sql_execToDate :  " + sql_execToDate);

        projShare.setstage(stage);
        projShare.settransInOut(trans_in_out);

        int processId = projShare.getprocessId();
        int processRequestId = projShare.getprocessRequestId();

        String execStep = projShare.getexecStep();

        System.out.println("Entering source2generic_Ver2 ");
        //   System.out.println("billing_cylcle_id : " +  billing_cylcle_id );

        try {

            //conect to config
            Statement sqlStatement = configdb.createStatement();
            
            // for getting count
            String readRecordSQLcount =
                "select count(1) as cnt " + " from PS_CIS_XPE_MAP_DTL where" + " cis_action_code =" + "'" +
                action_code + "'";

            System.out.println("Record values 1 : " + readRecordSQLcount);

            //form select
            String readRecordSQL =
                "select TABLENAME, generic_field, cis_native_field, cis_constant_field, is_key, where_clause1, APP_TBL_NAME, cis_aggregate_type, dp_targetfield " +
                " from PS_CIS_XPE_MAP_DTL where " + "  cis_action_code =" + "'" + action_code + "'" + " order by seqno";

            System.out.println("readRecordSQL : " + readRecordSQL);

            //get query count
            ResultSet myResultSetcnt = sqlStatement.executeQuery(readRecordSQLcount);
            while (myResultSetcnt.next()) {
                mapp_detail_cnt = myResultSetcnt.getInt("cnt");
                System.out.println("mapp_detail_cnt : " + mapp_detail_cnt);
            }
            myResultSetcnt.close();

            if (mapp_detail_cnt == 0) {
                System.out.println("Mapping_detail is not defined : ");
                errorMsg = errorMsg + " Mapping_detail is not defined for action code " + action_code;
                logger(projShare, errorMsg);
                return (-1);
            }


            String[] genericArray = new String[mapp_detail_cnt];
            String[] nativeArray = new String[mapp_detail_cnt];
            String[] whereArray = new String[mapp_detail_cnt];
            String[] constantArray = new String[mapp_detail_cnt];
            String[] targetFieldArray = new String[mapp_detail_cnt];
            String[] aggArray = new String[mapp_detail_cnt];

            //geting all data now
            System.out.println("Record values 1 : " + readRecordSQL);

            ResultSet myResultSet = sqlStatement.executeQuery(readRecordSQL);

            boolean hasNext = myResultSet.next();
            int recordCounter = 0;
            String tbl_name;

            while (hasNext) {

                mapp_detail_table_name = myResultSet.getString("TABLENAME");
                mapp_detail_generic_field = myResultSet.getString("generic_field");
                mapp_detail_native_field = myResultSet.getString("cis_native_field");
                mapp_detail_constant_field = myResultSet.getString("cis_constant_field");
                mapp_detail_is_key = myResultSet.getString("is_key");
                mapp_detail_where_field = myResultSet.getString("where_clause1");
                mapp_detail_target_table = myResultSet.getString("APP_TBL_NAME");
                mapp_detail_agg = myResultSet.getString("cis_aggregate_type");
                mapp_detail_target_field = myResultSet.getString("dp_targetfield");

                genericArray[recordCounter] = mapp_detail_generic_field;
                nativeArray[recordCounter] = mapp_detail_native_field;
                whereArray[recordCounter] = mapp_detail_where_field;
                constantArray[recordCounter] = mapp_detail_constant_field;
                //            targetFieldArray[recordCounter] = mapp_detail_where_field;
                targetFieldArray[recordCounter] = mapp_detail_target_field;
                aggArray[recordCounter] = mapp_detail_agg;

                                    System.out.println("Generic : "  +  mapp_detail_generic_field );
                                   System.out.println("Native array : " +    mapp_detail_native_field );
                                System.out.println("Target table : "  +  mapp_detail_target_table );
                                 System.out.println("Target field : "  +  mapp_detail_target_field );
                                 System.out.println("Aggregate : "  +  mapp_detail_agg );
                                                    System.out.println("=========1 : " +  readRecordSQL );

                hasNext = myResultSet.next();
                recordCounter++;

            } //while
            //                      System.out.println("=========2: " +  readRecordSQL );
            System.out.println("recordCounter " + recordCounter);
            System.out.println("mapp_detail_table_name : " + mapp_detail_table_name);

            if (mapp_detail_table_name.equals("PS_CIS_XPE_UDCA_HISTORY_VW")) {
                whereHistory =
                    "AND TO_char(message_date,'YYYY-MM-DD') BETWEEN " + "'" + stringDt_execFrom + "'" + " AND " + "'" +
                    stringDt_execTo + "'";
            }
            System.out.println("whereHistory : " + whereHistory);

            switch (mapp_detail_table_name) {
            case "PS_CIS_XPE_UDCA_HISTORY_VW":
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
                billing_cylcle_id = dateFormat2.format(execToDate);
                billing_cylcle_info = billing_cylcle_id;
                System.out.println("billing_cylcle_id...................... =  " + billing_cylcle_id);
                System.out.println(" billing_cylcle_id History============> " + billing_cylcle_id);
                break;
            case "PS_CIS_XPE_UDCA_CURRENT_VW":
                Statement stmt = configdb.createStatement();
                ResultSet rs =
                    stmt.executeQuery("SELECT TO_CHAR(LAST_DAY(message_date),'MM/DD/YYYY') FROM CURRENT_REPORT_RECORDS where rownum < 2");

                if (rs != null && rs.next()) {
                    billing_cylcle_id = rs.getString(1);
                    rs.close();
                } else {
                    System.out.println(" No record found in Current UDCA : ");
                    errorMsg = errorMsg + " Error details: " + " No record found in Current UDCA";
                    logger(projShare, errorMsg);
                    return (-1);
                }
                System.out.println(" billing_cylcle_id Curent =============>: " + billing_cylcle_id);
                billing_cylcle_info = billing_cylcle_id;

                //Force mode to TST - Matt 09/29/2016
                runType = "TST";

                stmt.close();
                break;
            case "PS_CIS_XPE_UDCA_CLOSED_VW":
                Statement stmt2 = configdb.createStatement();
                ResultSet rs2 =
                    stmt2.executeQuery("SELECT TO_CHAR(LAST_DAY(message_date),'MM/DD/YYYY') FROM closed_report_records where rownum < 2");

                if (rs2 != null && rs2.next()) {
                    billing_cylcle_id = rs2.getString(1);
                    rs2.close();
                } else {
                    System.out.println(" No record found in closed: ");
                    errorMsg = errorMsg + " Error details: " + " No record found in closed";
                    logger(projShare, errorMsg);
                    return (-1);
                }
                billing_cylcle_info = billing_cylcle_id;

                System.out.println(" billing_cylcle_id_str closed:============> " + billing_cylcle_id);
                runType = "PRD";

                stmt2.close();
                break;
            default:
            	billing_cylcle_id = "09/30/2017";
                break;
            } //switch

            insertGenericFieldsSum = "";

            //form Select columns
            for (int i = 0; i < mapp_detail_cnt; i++) {
                if (i < mapp_detail_cnt - 1) {

                    //                               System.out.println("i : =================" +  i );
                    //                               System.out.println("aggArray[i] " +  aggArray[i] );


                    //if agg field is not empty
                    if (aggArray[i] != null && !aggArray[i].isEmpty()) {

                        insertGenericFieldsSum =
                            insertGenericFieldsSum + aggArray[i] + "(" + nativeArray[i] + ")" + ",";
                        insertGenericFieldsSumMonth =
                            insertGenericFieldsSumMonth + aggArray[i] + "(" + nativeArray[i] + ")" + ",";
                        insertGenericFields = insertGenericFields + targetFieldArray[i] + ",";
                    } else { //agg field is empty
                        //                                System.out.println("2.. "  );
                        //check constant if initialized
                        if (constantArray[i] != null && !constantArray[i].isEmpty()) {
                            insertGenericFieldsSum = insertGenericFieldsSum + "'" + constantArray[i] + "'" + ",";
                            insertGenericFieldsSumMonth =
                                insertGenericFieldsSumMonth + "'" + constantArray[i] + "'" + ",";

                        } else {
                            if (i == message_date_pointer) {
                                insertGenericFieldsSumMonth =
                                    insertGenericFieldsSumMonth + "to_Date(" + "'" + billing_cylcle_id + "'" +
                                    ",'MM/DD/YYYY')" + ",";

                            } else {
                                insertGenericFieldsSumMonth = insertGenericFieldsSumMonth + nativeArray[i] + ",";
                            }
                            insertGenericFieldsSum = insertGenericFieldsSum + nativeArray[i] + ",";
                        }
                        insertGenericFields = insertGenericFields + "a." + genericArray[i] + ",";
                    }


                    if (aggArray[i] == null || aggArray[i].isEmpty()) {
                        //                                System.out.println("3.. "  );

                        if (i == message_date_pointer) {
                            insertAgg_for_month =
                                insertAgg_for_month + "to_Date(" + "'" + billing_cylcle_id + "'" + ",'MM/DD/YYYY')" +
                                ",";
                        } else {
                            insertAgg_for_month = insertAgg_for_month + nativeArray[i] + ",";
                        }
                        insertAgg = insertAgg + nativeArray[i] + ",";

                    }
                } else { // this is the last iteration
                    //                         System.out.println("4.. "  );
                    if (aggArray[i] != null && !aggArray[i].isEmpty()) {
                        insertGenericFieldsSum = insertGenericFieldsSum + aggArray[i] + "(" + nativeArray[i] + ")";
                        insertGenericFieldsSumMonth =
                            insertGenericFieldsSumMonth + aggArray[i] + "(" + nativeArray[i] + ")";
                        insertGenericFields = insertGenericFields + targetFieldArray[i];
                    } else {
                        //                                System.out.println("5.. "  );
                        //check constant if initialized
                        if (constantArray[i] != null && !constantArray[i].isEmpty()) {
                            insertGenericFieldsSum = insertGenericFieldsSum + "'" + constantArray[i] + "'";
                            insertGenericFieldsSumMonth = insertGenericFieldsSumMonth + "'" + constantArray[i] + "'";
                        } else {
                            if (i == message_date_pointer) {
                                insertGenericFieldsSumMonth =
                                    insertGenericFieldsSumMonth + "to_Date(" + "'" + billing_cylcle_id + "'" +
                                    ",'MM/DD/YYYY')";

                            } else {
                                insertGenericFieldsSumMonth = insertGenericFieldsSumMonth + nativeArray[i];
                            }
                            insertGenericFieldsSum = insertGenericFieldsSum + nativeArray[i];


                        }
                        insertGenericFields = insertGenericFields + "a." + genericArray[i];
                    }
                    //                     insertGenericFields = insertGenericFields + genericArray[i] ;

                    if (aggArray[i] == null || aggArray[i].isEmpty()) {
                        //                                System.out.println("6.. "  );
                        if (i == message_date_pointer) {
                            insertAgg_for_month =
                                insertAgg_for_month + "to_Date(" + "'" + billing_cylcle_id + "'" + ",'MM/DD/YYYY')";
                        } else {
                            insertAgg_for_month = insertAgg_for_month + nativeArray[i];
                        }

                        insertAgg = insertAgg + nativeArray[i];

                    }

                }
            }
            //           System.out.println("=========3: " +  readRecordSQL );
            System.out.println("insertGenericFieldsSum " + insertGenericFieldsSum);
            System.out.println("insertGenericFieldsSumMonth " + insertGenericFieldsSumMonth);
            System.out.println("insertGenericFields " + insertGenericFields);
            System.out.println("insertGenericFieldsSum " + insertGenericFieldsSum);


            //check for last character if ,

            int len = insertAgg.length();
            //           System.out.println("len " +  len );
            //           System.out.println("insertAgg " +  insertAgg );

            String insertAggUpd;
            String lastChar = insertAgg.substring(len - 1);

            if (lastChar.equals(",")) {
                insertAggUpd = insertAgg.substring(0, len - 1);
            } else {
                insertAggUpd = insertAgg;
            }

            //          System.out.println("insertAggUpd : ==============> "  + insertAggUpd);


            len = insertAgg_for_month.length();

            String insertAgg_for_monthUpdate;
            lastChar = insertAgg_for_month.substring(len - 1);

            if (lastChar.equals(",")) {
                insertAgg_for_monthUpdate = insertAgg_for_month.substring(0, len - 1);
            } else {
                insertAgg_for_monthUpdate = insertAgg_for_month;
            }

            insertGenericFieldsSum = insertGenericFieldsSum + ",";
            insertGenericFieldsSumMonth = insertGenericFieldsSumMonth + ",";
            String otherFieldsData = "";
            otherFieldsData =
                otherFieldsData + "'" + stage + "'" + "," + "'" + trans_in_out + "'" + "," + "'" + billing_cylcle_info +
                "'" + "," + "'" + execPlanCode + "'" + "," + "TO_DATE (" + "'" + execDateStr + "'" + ",'MM/DD/YYYY')" +
                "," + "'" + execStep + "'" + "," + processId + "," + processRequestId + "," + "'" + runType + "'";
            String otherFields =
                "CIS_STAGE" + "," + "CIS_TRANS_IN_OUT" + "," + "CIS_BILLCYCLE_INFO" + "," + "CIS_EXEC_PLAN_CODE" + "," +
                "CIS_EXEC_DATE" + "," + "CIS_EXEC_PLAN_STEP" + "," + "PROCESSID" + "," + "CIS_PRCS_REQST_ID" + "," +
                "RUN_TYPE";

            insertGenericFieldsSum = insertGenericFieldsSum + otherFieldsData;
            insertGenericFieldsSumMonth = insertGenericFieldsSumMonth + otherFieldsData;

            insertGenericFieldsSum = insertGenericFieldsSum + " from " + mapp_detail_table_name;
            insertGenericFieldsSumMonth = insertGenericFieldsSumMonth + " from " + mapp_detail_table_name;

            System.out.println("insertGenericFieldsSumMonth : " + insertGenericFieldsSumMonth);


            //close insertgeneric
            //        System.out.println("Record values : tbl_name " +  tbl_name  );
            //   System.out.println("Record values : mapp_detail_table_name " +  mapp_detail_table_name  );


            //add additional fields
            String otherFields1 =
                "," + "CIS_STAGE" + "," + "CIS_TRANS_IN_OUT" + "," + "CIS_BILLCYCLE_INFO" + "," + "CIS_EXEC_PLAN_CODE" +
                "," + "CIS_EXEC_DATE" + "," + "CIS_EXEC_PLAN_STEP" + "," + "PROCESSID" + "," + "CIS_PRCS_REQST_ID" +
                ")";

            insertGenericFields = insertGenericFields;


            //get target name
            insertSql = insertSql + mapp_detail_target_table + " " + " a\n";

            System.out.println("insertGenericFields : " + insertGenericFields);

            String whereCombined = buildWhere_ver2(detailCode, projShare, 'N') + whereHistory;
            System.out.println("whereCombined : " + whereCombined);

            //close it
            //      System.out.println("Record values : mapp_detail_table_name " +  mapp_detail_table_name  );
            String otherFields2 =
                "," + "'" + stage + "'" + "," + "'" + trans_in_out + "'" + "," + "'" + billing_cylcle_info + "'" + "," +
                "'" + execPlanCode + "'" + "," + "TO_DATE (" + "'" + execDateStr + "'" + ",'MM/DD/YYYY')" + "," + "'" +
                execStep + "'" + "," + processId + "," + processRequestId;
            insertNativeSelect = insertNativeSelect + otherFields2;

            System.out.println("insertNativeSelect : " + insertNativeSelect);

            insertStmt = insertSql + " " + "(" + insertGenericFields + "," + otherFields + ")" + insertSql_2 //select
                + insertGenericFieldsSum + whereCombined + insertSql_3 //group by
                + insertAggUpd;
            //     System.out.println("Complete insert :  "  + insertStmt );

            PreparedStatement preparedStatement = null;
            PreparedStatement preparedStatement_cnt = null;
            PreparedStatement preparedStatement_insert = null;

            String checkCus =
                "select distinct CIS_DNS_CUST_ID from PS_CIS_CUS_XWLK where  start_dt between trunc(?,'MONTH') AND LAST_DAY(?) ";
            //         String checkCus_count = "select count(1) as cnt from PS_CIS_CUS_XWLK where  start_dt between trunc(to_date( ? ,'MM/DD/YYYY'),'MONTH') AND LAST_DAY(to_date( ? ,'MM/DD/YYYY')) "  ;
            String checkCus_count =
                "select count(1) as cnt from PS_CIS_CUS_XWLK where  start_dt between trunc( ? ,'MONTH') AND LAST_DAY( ?) ";

            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); //
            System.out.println("billing_cylcle_id: "+billing_cylcle_id);
            Date convertedBillCycleDate = dateFormat.parse(billing_cylcle_id);
            System.out.println("out of <---- bill cycle id parse  "+convertedBillCycleDate );
            java.util.Date utilDate = convertedBillCycleDate;
            final String stringDate = dateFormat1.format(utilDate);
            final java.sql.Date sqlDate = java.sql.Date.valueOf(stringDate);
            System.out.println("sqlDate :  " + sqlDate);

            preparedStatement = configdb.prepareStatement(checkCus);
            preparedStatement_cnt = configdb.prepareStatement(checkCus_count);
            int prepared1cnt = 0;

            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setDate(2, sqlDate);

            preparedStatement_cnt.setDate(1, sqlDate);
            preparedStatement_cnt.setDate(2, sqlDate);

            /* neustar retire tz 170912
            ResultSet myResultSetcnt1 = preparedStatement_cnt.executeQuery();
            while (myResultSetcnt1.next()) {
                prepared1cnt = myResultSetcnt1.getInt("cnt");
                System.out.println("Multiple opcs  - prepared1cnt : " + prepared1cnt);

            }
            myResultSetcnt1.close(); /* neustar retire end */
            
            prepared1cnt = 0;

            if (prepared1cnt > 0) {
                String[] custArray = new String[prepared1cnt];

                recordCounter = 0;

                System.out.println("checkCus :  " + checkCus);

                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    custArray[recordCounter] = rs.getString("CIS_DNS_CUST_ID");
                    System.out.println("Customers :  " + custArray[recordCounter]);

                    String whereUpdatedIn = whereCombined + " AND OPC =  " + "'" + custArray[recordCounter] + "'";
                    System.out.println("whereUpdatedIn :  " + whereUpdatedIn);

                    insertStmt = insertSql + " " + "(" + insertGenericFields + "," + otherFields + ")" + insertSql_2 //select
                        + insertGenericFieldsSum + whereUpdatedIn + insertSql_3 //group by
                        + insertAggUpd;
                    System.out.println("Complete insert  with OPC:  " + insertStmt);

                    result = sqlStatement.executeUpdate(insertStmt); //PROD #1
                    System.out.println("Rows committed " + result);
                } //while

                //for the entire month of complete load
                String whereUpdatedIn = whereCombined + " AND OPC NOT IN  (" + checkCus + ")";
                insertStmt = insertSql + " " + "(" + insertGenericFields + "," + otherFields + ")" + insertSql_2 //select
                    + insertGenericFieldsSumMonth + whereUpdatedIn + insertSql_3 //group by
                    + insertAgg_for_monthUpdate;
                
                

                preparedStatement_insert = configdb.prepareStatement(insertStmt);
                preparedStatement_insert.setDate(1, sqlDate);
                preparedStatement_insert.setDate(2, sqlDate);

                System.out.println("Complete insert AND OPC NOT IN :  " + insertStmt);
                result = preparedStatement_insert.executeUpdate(); //PROD #2

                System.out.println("Rows committed " + result);

            } //if
            else { // process since there are multiple opc in this period

                insertStmt = insertSql + " " + "(" + insertGenericFields + "," + otherFields + ")" + insertSql_2 //select
                    + insertGenericFieldsSumMonth + whereCombined + insertSql_3 //group by
                    + insertAgg_for_monthUpdate;
                
                
                System.out.println("Complete insert with no OPC dupes:  " + insertStmt);

                result = sqlStatement.executeUpdate(insertStmt); //PROD #3
                System.out.println("Rows committed " + result);

            }

            myResultSet.close();

        } catch (Exception e) {
            System.out.println(e);
            errorMsg = errorMsg + " Error details: " + e;
            logger(projShare, errorMsg);
            return (-1);
        }
        return (0);
    }


    public int update_custom_sql(ProjectVariable projShare, String action_code, String detailCode) {

        String module = "update_custom_sql";
        String errorMsg =
            "Module : " + module + "\n" + "Action : " + action_code + "\n" + "Action Detail : " + "\n" + detailCode +
            "\n";

        //rule condition defs
        String rc_detail_code = "";
        int rc_detail_seq;
        String rc_custom_sql = "";


        Connection configdb = projShare.getconfigDb();

        try {
            Statement sqlStatement = configdb.createStatement();

            // select from rule_conditionP
            String readRecordSQL_2 =
                "SELECT cis_detail_code, dtl_seq_nbr,  CIS_custom_sql " +
                " FROM PS_CIS_XPE_ACT_DTL where  CIS_detail_code =" + "'" + detailCode + "'";
            System.out.println("Condition query : " + readRecordSQL_2);

            ResultSet myResultSet2 = sqlStatement.executeQuery(readRecordSQL_2);

            boolean hasNext2 = myResultSet2.next();
            int recordCounter2 = 0;
            while (hasNext2) {
                rc_custom_sql = myResultSet2.getString("CIS_custom_sql");
                hasNext2 = myResultSet2.next();
                recordCounter2++;
            }
            System.out.println("rc_custom_sql query : " + rc_custom_sql);

            int result = sqlStatement.executeUpdate(rc_custom_sql);
            System.out.println("Rows committed " + result);
        } catch (Exception e) {
            System.out.println(e);
            errorMsg = errorMsg + " Error details: " + e;
            logger(projShare, errorMsg);
            return (-1);
        }
        return (0);

    }

    public int custom_proc(ProjectVariable projShare, String action_code, String detailCode) {

        String module = "custom_proc";
        String errorMsg = module;

        //rule condition defs
        String rc_detail_code = "";
        int rc_detail_seq;
        String rc_custom_proc = "";


        Connection configdb = projShare.getconfigDb();

        try {
            Statement sqlStatement = configdb.createStatement();

            // select from rule_conditionP
            String readRecordSQL_2 =
                "SELECT cis_detail_code, dtl_seq_nbr,  CIS_custom_sql, CIS_CUSTOM_PROCESS " +
                " FROM PS_CIS_XPE_ACT_DTL where  CIS_detail_code =" + "'" + detailCode + "'";
            System.out.println("Condition query : " + readRecordSQL_2);

            ResultSet myResultSet2 = sqlStatement.executeQuery(readRecordSQL_2);

            boolean hasNext2 = myResultSet2.next();
            int recordCounter2 = 0;
            while (hasNext2) {
                rc_custom_proc = myResultSet2.getString("CIS_CUSTOM_PROCESS");
                hasNext2 = myResultSet2.next();
                recordCounter2++;
            }
            System.out.println("rc_custom_proc  : " + rc_custom_proc);

            switch (rc_custom_proc) {
            case "prepareProjResource":
                System.out.println("calling prepareProjResource : ");
                prepareProjResource(projShare);
                break;
            case "prepareVoucher":
                System.out.println("calling prepareVoucher : ");
                prepareVoucher(projShare);
                break;
            default:
                break;
            } //switch
        }


        catch (Exception e) {
            System.out.println(e);
            errorMsg = errorMsg + " : " + e;
            logger(projShare, errorMsg);
            return (-1);
        }
        return (0);

    }

    public int insert2Generic(ProjectVariable projShare, String action_code, String detailCode) {

        String module = "insert2Generic";
        // init insert stmt
        String insertSql = "insert into ";
        String insertSql_3 = " group by   ";
        String whereClause = "";
        String genericTableName = "PS_CIS_XPE_IMPORT";
        String errorMsg = module;
        String insertSql_2 = " SELECT  distinct ";

        //constants

        String readRecordNeuSql = "";

        String mapp_detail_table_name = "";
        String mapp_detail_generic_field;
        String mapp_detail_native_field;
        String mapp_detail_constant_field;
        String mapp_detail_is_key;
        String mapp_detail_where_field;
        String mapp_detail_target_table = "";
        String mapp_detail_agg;
        String mapp_detail_target_field = "";
        ResultSet myMainCnt;

        String insertGenericFields = "";
        String insertGenericFieldsSum = "";

        String insertNativeSelect = "";

        String insertStmt = null;
        String insertAgg = "";

        //count of records
        int mapp_detail_cnt = 0;

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Connection configdb = projShare.getconfigDb();


        int processId = projShare.getprocessId();
        int processRequestId = projShare.getprocessRequestId();


        System.out.println("Entering  " + module);
        try {

            //conect to config
            Statement sqlStatement = configdb.createStatement();

            // for getting count
            String readRecordSQLcount =
                "select count(1) as cnt " + " from PS_CIS_XPE_MAP_DTL where" + " cis_action_code =" + "'" +
                action_code + "'";

            System.out.println("Record values 1 : " + readRecordSQLcount);

            //form select
            String readRecordSQL =
                "select TABLENAME, generic_field, cis_native_field, cis_constant_field, is_key, where_clause1, APP_TBL_NAME, cis_aggregate_type, dp_targetfield " +
                " from PS_CIS_XPE_MAP_DTL where " + "  cis_action_code =" + "'" + action_code + "'" + " order by seqno";

            System.out.println("Record values 1 : " + readRecordSQL);

            //get query count
            ResultSet myResultSetcnt = sqlStatement.executeQuery(readRecordSQLcount);
            while (myResultSetcnt.next()) {
                mapp_detail_cnt = myResultSetcnt.getInt("cnt");
                System.out.println("Record values : " + mapp_detail_cnt);
            }

            //geting all data now
            System.out.println("Record values 1 : " + readRecordSQL);

            if (mapp_detail_cnt == 0) {
                System.out.println("Mapping_detail is not defined : ");
                errorMsg = errorMsg + " Mapping_detail is not defined for action code " + action_code;
                logger(projShare, errorMsg);
                return (-1);
            }
            myResultSetcnt.close();

            String[] genericArray = new String[mapp_detail_cnt];
            String[] nativeArray = new String[mapp_detail_cnt];
            String[] whereArray = new String[mapp_detail_cnt];
            String[] constantArray = new String[mapp_detail_cnt];
            String[] targetFieldArray = new String[mapp_detail_cnt];
            String[] aggArray = new String[mapp_detail_cnt];

            ResultSet myResultSet = sqlStatement.executeQuery(readRecordSQL);

            boolean hasNext = myResultSet.next();
            int recordCounter = 0;
            String tbl_name;

            while (hasNext) {
                mapp_detail_table_name = myResultSet.getString("TABLENAME");
                mapp_detail_generic_field = myResultSet.getString("generic_field");
                mapp_detail_native_field = myResultSet.getString("cis_native_field");
                mapp_detail_constant_field = myResultSet.getString("cis_constant_field");
                mapp_detail_is_key = myResultSet.getString("is_key");
                mapp_detail_where_field = myResultSet.getString("where_clause1");
                mapp_detail_target_table = myResultSet.getString("APP_TBL_NAME");
                mapp_detail_agg = myResultSet.getString("cis_aggregate_type");
                mapp_detail_target_field = myResultSet.getString("dp_targetfield");

                genericArray[recordCounter] = mapp_detail_generic_field;
                nativeArray[recordCounter] = mapp_detail_native_field;
                whereArray[recordCounter] = mapp_detail_where_field;
                constantArray[recordCounter] = mapp_detail_constant_field;
                targetFieldArray[recordCounter] = mapp_detail_where_field;
                targetFieldArray[recordCounter] = mapp_detail_target_field;
                aggArray[recordCounter] = mapp_detail_agg;

                //                System.out.println("Record values : " +  mapp_detail_table_name + "--" +  mapp_detail_generic_field );
                //               System.out.println("Record values : " +  mapp_detail_target_table + "--" +  mapp_detail_target_table );
                //      System.out.println("=========1 : " +  readRecordSQL );


                hasNext = myResultSet.next();
                recordCounter++;
            } //while

            String aggFieldFound = "No";
            //form Select columns
            for (int i = 0; i < mapp_detail_cnt; i++) {
                if (i < mapp_detail_cnt - 1) {

                    //if agg field is not empty
                    if (aggArray[i] != null && !aggArray[i].isEmpty()) {
                        insertGenericFieldsSum =
                            insertGenericFieldsSum + aggArray[i] + "(" + nativeArray[i] + ")" + ",";
                        insertGenericFields = insertGenericFields + targetFieldArray[i] + ",";
                    } else {
                        //check constant if initialized
                        if (constantArray[i] != null && !constantArray[i].isEmpty()) {
                            insertGenericFieldsSum = insertGenericFieldsSum + "'" + constantArray[i] + "'" + ",";
                        } else {
                            insertGenericFieldsSum = insertGenericFieldsSum + "b." + nativeArray[i] + ",";
                        }
                        insertGenericFields = insertGenericFields + genericArray[i] + ",";
                    }


                    if (aggArray[i] == null || aggArray[i].isEmpty()) {
                        insertAgg = insertAgg + "b." + nativeArray[i] + ",";
                    } else {
                        aggFieldFound = "Yes";
                    }
                } else { // this is the last iteration
                    if (aggArray[i] != null && !aggArray[i].isEmpty()) {
                        insertGenericFieldsSum = insertGenericFieldsSum + aggArray[i] + "(" + nativeArray[i] + ")";
                        insertGenericFields = insertGenericFields + targetFieldArray[i];
                    } else {
                        //check constant if initialized
                        if (constantArray[i] != null && !constantArray[i].isEmpty()) {
                            insertGenericFieldsSum = insertGenericFieldsSum + "'" + constantArray[i] + "'";
                        } else {
                            insertGenericFieldsSum = insertGenericFieldsSum + "b." + nativeArray[i];
                        }
                        insertGenericFields = insertGenericFields + genericArray[i];
                    }
                    //                     insertGenericFields = insertGenericFields + genericArray[i] ;

                    if (aggArray[i] == null || aggArray[i].isEmpty()) {
                        insertAgg = insertAgg + "b." + nativeArray[i];
                    } else {
                        aggFieldFound = "Yes";
                    }

                }
            }

            //check for last character if ,

            int len = insertAgg.length();

            String insertAggUpd;
            String lastChar = insertAgg.substring(len - 1);

            if (lastChar.equals(",")) {
                insertAggUpd = insertAgg.substring(0, len - 1);
            } else {
                insertAggUpd = insertAgg;
            }

            insertGenericFieldsSum = insertGenericFieldsSum + ",";
            String otherFieldsData = "";
            otherFieldsData = otherFieldsData + processId + "," + processRequestId;
            String otherFields = "PROCESSID" + "," + "CIS_PRCS_REQST_ID";

            insertGenericFieldsSum = insertGenericFieldsSum + otherFieldsData;


            //close insertgeneric
            //        System.out.println("Record values : tbl_name " +  tbl_name  );
            //   System.out.println("Record values : mapp_detail_table_name " +  mapp_detail_table_name  );
            String fromClause = " from " + mapp_detail_table_name + " b"; //+  mapp_detail_target_table + " a";

            //add additional fields
            String otherFields1 = "," + "PROCESSID" + "," + "CIS_PRCS_REQST_ID" + ")";

            insertGenericFields = insertGenericFields;

            System.out.println("mapp_detail_target_table : ==>  " + mapp_detail_target_table);


            //get target name
            insertSql = insertSql + mapp_detail_target_table + " ";

            System.out.println("insertGenericFields : " + insertGenericFields);
            System.out.println("insertGenericFieldsSum : " + insertGenericFieldsSum);

            String whereCombined = buildWhere_ver2(detailCode, projShare, 'Y');
            System.out.println("whereCombined : " + whereCombined);

            //close it
            //      System.out.println("Record values : mapp_detail_table_name " +  mapp_detail_table_name  );
            String otherFields2 = "," + processId + "," + processRequestId;
            insertNativeSelect = insertNativeSelect + otherFields2;

            System.out.println("insertNativeSelect : " + insertNativeSelect);


            if (aggFieldFound.equals("Yes")) {
                insertStmt = insertSql + " " + "(" + insertGenericFields + "," + otherFields + ")" + insertSql_2 //select
                    + insertGenericFieldsSum + fromClause + whereCombined + insertSql_3 //group by
                    + insertAggUpd;
            } else {
                insertStmt = insertSql + " " + "(" + insertGenericFields + "," + otherFields + ")" + insertSql_2 //select
                    + insertGenericFieldsSum + fromClause + whereCombined;
            }


            System.out.println("Complete insert :  " + insertStmt);

            int result = sqlStatement.executeUpdate(insertStmt);
            System.out.println("Rows committed " + result);


            myResultSet.close();

        } catch (Exception e) {
            errorMsg = errorMsg + " : " + e;
            System.out.println("errorMsg : " + errorMsg);
            logger(projShare, errorMsg);
            return (-1);
        }
        return (0);
    }

    public String buildWhere_ver2(String detailCode, ProjectVariable projShare, char optionPrefix) {

        //option prefix 'Y' adds prefix
        String module = "buildWhere_ver2";

        String errorMsg = module;

        //rule condition defs
        String rc_detail_code = "";
        int rc_detail_seq;
        String rc_operator_1 = "";
        String rc_prefix = "";
        String rc_attribute_left = "";
        String rc_operator_2 = "";
        String rc_attribute_right = "";
        String rc_attribute_constant = "";
        String rc_custom_process = "";
        String rc_suffix = "";
        String rc_operator_3 = "";
        String rc_attr_left_value;
        String rc_attr_right_value;
        String whereCondition;
        String whereCombined = " ";


        Connection configdb = projShare.getconfigDb();

        try {
            //decipher condition code to form the where clause
            Statement sqlStatement = configdb.createStatement();

            // select from rule_conditionP
            String readRecordSQL_2 =
                "SELECT CIS_detail_code, dtl_seq_nbr, CIS_operator1, CIS_prefix, CIS_attr_left,CIS_operator2, CIS_attr_right, CIS_attr_const, CIS_custom_process, CIS_suffix_value, CIS_operator3 " +
                " FROM PS_CIS_XPE_ACT_DTL where  CIS_detail_code =" + "'" + detailCode + "'";

            String readRecordSQL_2_cnt =
                "SELECT count(1) as cnt from " + " PS_CIS_XPE_ACT_DTL where  CIS_detail_code =" + "'" + detailCode +
                "'";

            //get counts in ne_rule_condition
            int detail_cnt = 0;
            ResultSet myResultSetcnt2;

            System.out.println("readRecordSQL_2_cnt: " + readRecordSQL_2_cnt);

            myResultSetcnt2 = sqlStatement.executeQuery(readRecordSQL_2_cnt);
            while (myResultSetcnt2.next()) {
                detail_cnt = myResultSetcnt2.getInt("cnt");
                System.out.println("detail_cnt: " + detail_cnt);
            }


            System.out.println("Condition query : " + readRecordSQL_2);
            //-ok
            //geting all data now
            String[] rc_operator_1Array = new String[detail_cnt];
            String[] rc_prefixArray = new String[detail_cnt];
            String[] rc_attribute_leftArray = new String[detail_cnt];
            String[] rc_operator_2Array = new String[detail_cnt];
            String[] rc_attribute_rightArray = new String[detail_cnt];
            String[] rc_attribute_constantArray = new String[detail_cnt];
            String[] rc_SuffixArray = new String[detail_cnt];
            String[] rc_operator_3Array = new String[detail_cnt];

            ResultSet myResultSet2 = sqlStatement.executeQuery(readRecordSQL_2);

            boolean hasNext2 = myResultSet2.next();
            int recordCounter2 = 0;

            while (hasNext2) {

                rc_detail_code = myResultSet2.getString("CIS_detail_code");
                rc_detail_seq = myResultSet2.getInt("dtl_seq_nbr");
                rc_operator_1 = myResultSet2.getString("CIS_operator1");
                rc_prefix = myResultSet2.getString("CIS_prefix");
                rc_attribute_left = myResultSet2.getString("CIS_attr_left");
                rc_operator_2 = myResultSet2.getString("CIS_operator2");
                rc_attribute_right = myResultSet2.getString("CIS_attr_right");
                rc_attribute_constant = myResultSet2.getString("CIS_attr_const");
                rc_custom_process = myResultSet2.getString("CIS_custom_process");
                rc_suffix = myResultSet2.getString("CIS_suffix_value");
                rc_operator_3 = myResultSet2.getString("CIS_operator3");
                //                                    System.out.println("1>>>>>>>> " +  readRecordSQL_2_cnt );

                if (rc_operator_1 == null) {
                    rc_operator_1Array[recordCounter2] = "";
                } else {
                    rc_operator_1Array[recordCounter2] = rc_operator_1;

                }

                rc_prefixArray[recordCounter2] = rc_prefix;
                rc_attribute_leftArray[recordCounter2] = rc_attribute_left;
                rc_operator_2Array[recordCounter2] = rc_operator_2;
                rc_attribute_rightArray[recordCounter2] = rc_attribute_right;
                if (rc_attribute_constant == null) {
                    rc_attribute_constantArray[recordCounter2] = "";
                } else {
                    rc_attribute_constantArray[recordCounter2] = rc_attribute_constant;

                }

                rc_SuffixArray[recordCounter2] = rc_suffix;
                if (rc_operator_3 == null) {
                    rc_operator_3Array[recordCounter2] = "";
                } else {
                    rc_operator_3Array[recordCounter2] = rc_operator_3;
                }
                hasNext2 = myResultSet2.next();
                recordCounter2++;
            }

            int internalCondnCounter = 0;

            //check if first where is blank
            if (rc_operator_1Array[0] == null || rc_operator_1Array[0].isEmpty()) {
                System.out.println("where is blank: ");
                return (whereCombined);
            }

            //combine all rc_right attributes
            String rc_right_attributes_combined = "";

            if (detail_cnt == 1) {
                rc_right_attributes_combined = rc_right_attributes_combined + rc_attribute_rightArray[0];
            } else {
                for (int i = 0; i < detail_cnt; i++) {
                    if (i < detail_cnt - 1) {
                        rc_right_attributes_combined = rc_right_attributes_combined + rc_attribute_rightArray[i] + ",";
                    } else {
                        rc_right_attributes_combined = rc_right_attributes_combined + rc_attribute_rightArray[i];
                    }
                }
            }
            //Combine all the Wheres

            for (int i = 0; i < detail_cnt; i++) {

                if (!rc_attribute_constantArray[i].isEmpty()) {
                    if (optionPrefix == 'Y') {
                        whereCombined =
                            whereCombined + rc_operator_1Array[i] + " " + rc_prefixArray[i] + " " + "b." +
                            rc_attribute_leftArray[i] + " " + rc_operator_2Array[i] + " " +
                            rc_attribute_constantArray[i] + " " + rc_SuffixArray[i] + " " + " " +
                            rc_operator_3Array[i] + "\n ";
                    } else {
                        whereCombined =
                            whereCombined + rc_operator_1Array[i] + " " + rc_prefixArray[i] + " " +
                            rc_attribute_leftArray[i] + " " + rc_operator_2Array[i] + " " +
                            rc_attribute_constantArray[i] + " " + rc_SuffixArray[i] + " " + " " +
                            rc_operator_3Array[i] + "\n ";
                    }


                } else {
                    if (optionPrefix == 'Y') {
                        whereCombined =
                            whereCombined + rc_operator_1Array[i] + " " + rc_prefixArray[i] + " " + "b." +
                            rc_attribute_leftArray[i] + " " + rc_operator_2Array[i] + " " + "a." +
                            rc_attribute_rightArray[i] + " " + rc_SuffixArray[i] + " " + rc_attribute_constantArray[i] +
                            " " + rc_operator_3Array[i] + "\n ";

                    } else {
                        whereCombined =
                            whereCombined + rc_operator_1Array[i] + " " + rc_prefixArray[i] + " " +
                            rc_attribute_leftArray[i] + " " + rc_operator_2Array[i] + " " + rc_attribute_rightArray[i] +
                            " " + rc_SuffixArray[i] + " " + rc_attribute_constantArray[i] + " " +
                            rc_operator_3Array[i] + "\n ";
                    }


                }

            }

            //                System.out.println("whereCombined : " +  whereCombined  );


        } //try
        catch (Exception e) {
            System.out.println(e);
            errorMsg = errorMsg + " : " + e;
            logger(projShare, errorMsg);
        }
        return (whereCombined);

    }

    public int generic2target(ProjectVariable projShare, String action_code, String detailCode) {

        String module = "generic2target";
        // init insert stmt
        String insertSql = "insert into ";
        String insertSql_2 = " SELECT  ";
        String insertSql_3 = " group by   ";

        String insertNativeSelect = "";
        String errorMsg = module;

        String insertGenericFields = "";
        String insertGenericFieldsSum = "";
        String insertTargetFields = "";


        String insertStmt = null;
        String insertAgg = "";
        String mapp_detail_table_name = "";
        String mapp_detail_generic_field;
        String mapp_detail_native_field;
        String mapp_detail_constant_field;
        String mapp_detail_is_key;
        String mapp_detail_where_field;
        String mapp_detail_target_table = "";
        String mapp_detail_agg;
        String mapp_detail_target_field = "";

        //count of records
        int mapp_detail_cnt = 0;

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String stage = "4-REPORTING";
        String trans_in_out = "1-IN";
        projShare.setstage(stage);
        projShare.settransInOut(trans_in_out);
        String execPlanCode = projShare.getextPlanCode();
        Date execDate = projShare.getExecDate();
        String execDateStr = df.format(execDate);
        System.out.println("execDate =  " + execDateStr);
        Connection configdb = projShare.getconfigDb();

        System.out.println("Entering generic2target ");

        try {

            //conect to config
            Statement sqlStatement = configdb.createStatement();

            // for getting count
            String readRecordSQLcount =
                "select count(1) as cnt " + " from PS_CIS_XPE_MAP_DTL where  " + "  cis_action_code =" + "'" +
                action_code + "'";

            //form select
            String readRecordSQL =
                "select TABLENAME, generic_field, cis_native_field, cis_constant_field, is_key, where_clause1, APP_TBL_NAME, cis_aggregate_type, dp_targetfield " +
                " from PS_CIS_XPE_MAP_DTL where " + "  cis_action_code =" + "'" + action_code + "'" + " order by seqno";


            System.out.println("Record readRecordSQLcount : " + readRecordSQLcount);
            System.out.println("Record readRecordSQL : " + readRecordSQL);


            //get query count
            ResultSet myResultSetcnt = sqlStatement.executeQuery(readRecordSQLcount);
            while (myResultSetcnt.next()) {
                mapp_detail_cnt = myResultSetcnt.getInt("cnt");
                System.out.println("Record values : " + mapp_detail_cnt);
            }
            myResultSetcnt.close();

            if (mapp_detail_cnt == 0) {
                System.out.println("Mapping_detail is not defined : ");
                errorMsg = errorMsg + " Mapping_detail is not defined for action code " + action_code;
                logger(projShare, errorMsg);
                return (-1);
            }

            String[] genericArray = new String[mapp_detail_cnt];
            String[] nativeArray = new String[mapp_detail_cnt];
            String[] whereArray = new String[mapp_detail_cnt];
            String[] constantArray = new String[mapp_detail_cnt];
            String[] targetFieldArray = new String[mapp_detail_cnt];
            String[] aggArray = new String[mapp_detail_cnt];

            //geting all data now
            ResultSet myResultSet = sqlStatement.executeQuery(readRecordSQL);

            boolean hasNext = myResultSet.next();
            int recordCounter = 0;

            while (hasNext) {

                mapp_detail_table_name = myResultSet.getString("TABLENAME");
                mapp_detail_generic_field = myResultSet.getString("generic_field");
                mapp_detail_native_field = myResultSet.getString("cis_native_field");
                mapp_detail_constant_field = myResultSet.getString("cis_constant_field");
                mapp_detail_is_key = myResultSet.getString("is_key");
                mapp_detail_where_field = myResultSet.getString("where_clause1");
                mapp_detail_target_table = myResultSet.getString("APP_TBL_NAME");
                mapp_detail_agg = myResultSet.getString("cis_aggregate_type");
                mapp_detail_target_field = myResultSet.getString("dp_targetfield");

                genericArray[recordCounter] = mapp_detail_generic_field;
                nativeArray[recordCounter] = mapp_detail_native_field;
                whereArray[recordCounter] = mapp_detail_where_field;
                constantArray[recordCounter] = mapp_detail_constant_field;
                targetFieldArray[recordCounter] = mapp_detail_where_field;
                targetFieldArray[recordCounter] = mapp_detail_target_field;
                aggArray[recordCounter] = mapp_detail_agg;

                System.out.println("Record values : " + mapp_detail_table_name + "--" + mapp_detail_generic_field);
                System.out.println("Record values : " + mapp_detail_target_table + "--" + mapp_detail_target_table);
                //               Check validity of records
                if (mapp_detail_generic_field != null && mapp_detail_constant_field != null) {
                    if (!mapp_detail_generic_field.isEmpty() && !mapp_detail_constant_field.isEmpty()) {
                        throw new Exception("Missing Mapping - Both Generic and constant cannot be used simultaneously  " +
                                            mapp_detail_generic_field + " " + mapp_detail_constant_field);
                    }
                }


                hasNext = myResultSet.next();
                recordCounter++;

            } //while
            //close insertgeneric

            insertGenericFieldsSum = "";

            //form Select columns
            for (int i = 0; i < mapp_detail_cnt; i++) {
                if (i < mapp_detail_cnt - 1) {

                    //if agg field is not empty
                    if (aggArray[i] != null && !aggArray[i].isEmpty()) {
                        insertGenericFieldsSum =
                            insertGenericFieldsSum + aggArray[i] + "(" + genericArray[i] + ")" + ",";
                        insertGenericFields = insertGenericFields + targetFieldArray[i] + ",";
                    } else {
                        //check constant if initialized
                        if (constantArray[i] != null && !constantArray[i].isEmpty()) {
                            insertGenericFieldsSum = insertGenericFieldsSum + "'" + constantArray[i] + "'" + ",";
                        } else {
                            insertGenericFieldsSum = insertGenericFieldsSum + genericArray[i] + ",";
                        }
                        insertGenericFields = insertGenericFields + genericArray[i] + ",";

                    } //else1

                    insertTargetFields = insertTargetFields + targetFieldArray[i] + ",";


                    if (aggArray[i] == null || aggArray[i].isEmpty()) {
                        insertAgg = insertAgg + genericArray[i] + ",";
                    }
                } else { // this is the last iteration
                    if (aggArray[i] != null && !aggArray[i].isEmpty()) {
                        insertGenericFieldsSum = insertGenericFieldsSum + aggArray[i] + "(" + genericArray[i] + ")";
                        insertGenericFields = insertGenericFields + targetFieldArray[i];
                    } else {
                        //check constant if initialized
                        if (constantArray[i] != null && !constantArray[i].isEmpty()) {
                            insertGenericFieldsSum = insertGenericFieldsSum + "'" + constantArray[i] + "'";
                        } else {
                            insertGenericFieldsSum = insertGenericFieldsSum + genericArray[i];
                        }
                        insertGenericFields = insertGenericFields + genericArray[i];
                    }
                    //                     insertGenericFields = insertGenericFields + genericArray[i] ;
                    insertTargetFields = insertTargetFields + targetFieldArray[i];


                    if (aggArray[i] == null || aggArray[i].isEmpty()) {
                        insertAgg = insertAgg + genericArray[i];
                    }

                }
            } //form select

            //check for last character if ,

            int len = insertAgg.length();

            String insertAggUpd;
            String lastChar = insertAgg.substring(len - 1);

            if (lastChar.equals(",")) {
                insertAggUpd = insertAgg.substring(0, len - 1);
            } else {
                insertAggUpd = insertAgg;
            }

            insertGenericFieldsSum = insertGenericFieldsSum;
            String otherFieldsData = "";
            String otherFields = "";

            insertGenericFieldsSum = insertGenericFieldsSum + otherFieldsData;

            insertGenericFieldsSum = insertGenericFieldsSum + " from " + mapp_detail_table_name;

            String whereCombined = buildWhere_ver2(detailCode, projShare, 'N');


            insertStmt = insertSql + mapp_detail_target_table + " " + "(" + insertTargetFields + otherFields + ")" + insertSql_2 //select
                + insertGenericFieldsSum + whereCombined + insertSql_3 //group by
                + insertAggUpd;


            System.out.println("Complete insert : " + insertStmt);

            //   sqlStatement.executeUpdate(insertStmt);


            myResultSet.close();

        } catch (Exception e) {
            System.out.println(e);
            errorMsg = errorMsg + " : " + e;
            logger(projShare, errorMsg);
            return (-1);
        }
        return (0);
    }

    public int generic2generic(ProjectVariable projShare, String action_code, String detailCode) {

        String module = "generic2generic";
        // init insert stmt
        String insertSql = "INSERT into  ";
        String insertSql_2 = " SELECT  ";
        String insertSql_3 = " group by   ";
        String errorMsg = module;

        String insertGenericFields = "";
        String insertGenericFieldsSum = "";

        String insertNativeSelect = "";

        String insertStmt = null;
        String insertAgg = "";

        String mapp_detail_table_name = "";
        String mapp_detail_generic_field;
        String mapp_detail_native_field;
        String mapp_detail_constant_field;
        String mapp_detail_is_key;
        String mapp_detail_where_field;
        String mapp_detail_target_table = "";
        String mapp_detail_agg;
        String mapp_detail_target_field = "";

        //count of records
        int mapp_detail_cnt = 0;

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String stage = "3-AGGREGATE";
        String trans_in_out = "1-IN";
        projShare.setstage(stage);
        projShare.settransInOut(trans_in_out);
        String execPlanCode = projShare.getextPlanCode();

        int processId = projShare.getprocessId();
        int processRequestId = projShare.getprocessRequestId();

        String execStep = projShare.getexecStep();
        Date execDate = projShare.getExecDate();
        String execDateStr = df.format(execDate);
        System.out.println("execDate =  " + execDateStr);
        Connection configdb = projShare.getconfigDb();

        //rule condition defs
        String rc_detail_code = "";
        int rc_detail_seq;
        String rc_operator_1 = "";
        String rc_prefix = "";
        String rc_attribute_left = "";
        String rc_operator_2 = "";
        String rc_attribute_right = "";
        String rc_attribute_constant = "";
        String rc_custom_process = "";
        String rc_suffix = "";
        String rc_operator_3 = "";
        String rc_attr_left_value;
        String rc_attr_right_value;
        String whereCondition;

        System.out.println("Entering generic2generic ");

        try {

            //conect to config
            Statement sqlStatement = configdb.createStatement();

            // for getting count
            String readRecordSQLcount =
                "select count(1) as cnt " + " from PS_CIS_XPE_MAP_DTL where  " + " cis_action_code =" + "'" +
                action_code + "'";

            System.out.println("SQL  readRecordSQLcount : " + readRecordSQLcount);

            //form select
            String readRecordSQL =
                "select TABLENAME, generic_field, cis_native_field, cis_constant_field, is_key, where_clause1, APP_TBL_NAME, cis_aggregate_type, dp_targetfield " +
                " from PS_CIS_XPE_MAP_DTL where " + "  cis_action_code =" + "'" + action_code + "'" + " order by seqno";
            //get query count
            ResultSet myResultSetcnt = sqlStatement.executeQuery(readRecordSQLcount);
            while (myResultSetcnt.next()) {
                mapp_detail_cnt = myResultSetcnt.getInt("cnt");
                System.out.println("Record count  for mapp_detail_cnt : " + mapp_detail_cnt);
            }
            myResultSetcnt.close();

            if (mapp_detail_cnt == 0) {
                System.out.println("Mapping_detail is not defined : ");
                errorMsg = errorMsg + " Mapping_detail is not defined for action code " + action_code;
                logger(projShare, errorMsg);
                return (-1);
            }

            String[] genericArray = new String[mapp_detail_cnt];
            String[] nativeArray = new String[mapp_detail_cnt];
            String[] whereArray = new String[mapp_detail_cnt];
            String[] constantArray = new String[mapp_detail_cnt];
            String[] targetFieldArray = new String[mapp_detail_cnt];
            String[] aggArray = new String[mapp_detail_cnt];

            //geting all data now
            System.out.println("SQL  readRecordSQL : " + readRecordSQL);

            ResultSet myResultSet = sqlStatement.executeQuery(readRecordSQL);

            boolean hasNext = myResultSet.next();
            int recordCounter = 0;

            while (hasNext) {

                mapp_detail_table_name = myResultSet.getString("TABLENAME");
                mapp_detail_generic_field = myResultSet.getString("generic_field");
                mapp_detail_native_field = myResultSet.getString("cis_native_field");
                mapp_detail_constant_field = myResultSet.getString("cis_constant_field");
                mapp_detail_is_key = myResultSet.getString("is_key");
                mapp_detail_where_field = myResultSet.getString("where_clause1");
                mapp_detail_target_table = myResultSet.getString("APP_TBL_NAME");
                mapp_detail_agg = myResultSet.getString("cis_aggregate_type");
                mapp_detail_target_field = myResultSet.getString("dp_targetfield");

                genericArray[recordCounter] = mapp_detail_generic_field;
                nativeArray[recordCounter] = mapp_detail_native_field;
                whereArray[recordCounter] = mapp_detail_where_field;
                constantArray[recordCounter] = mapp_detail_constant_field;
                targetFieldArray[recordCounter] = mapp_detail_where_field;
                targetFieldArray[recordCounter] = mapp_detail_target_field;
                aggArray[recordCounter] = mapp_detail_agg;

                //       System.out.println("Record values : " +  mapp_detail_table_name + "--" +  mapp_detail_generic_field );
                //      System.out.println("Record values : " +  mapp_detail_target_table + "--" +  mapp_detail_target_table );
                //        System.out.println("=========1 : " +  readRecordSQL );


                hasNext = myResultSet.next();
                recordCounter++;

            } //while

            insertGenericFieldsSum = "";

            //form Select columns
            for (int i = 0; i < mapp_detail_cnt; i++) {
                if (i < mapp_detail_cnt - 1) {

                    //if agg field is not empty
                    if (aggArray[i] != null && !aggArray[i].isEmpty()) {
                        insertGenericFieldsSum =
                            insertGenericFieldsSum + aggArray[i] + "(" + genericArray[i] + ")" + ",";
                        insertGenericFields = insertGenericFields + targetFieldArray[i] + ",";
                    } else {
                        //check constant if initialized
                        if (constantArray[i] != null && !constantArray[i].isEmpty()) {
                            insertGenericFieldsSum = insertGenericFieldsSum + "'" + constantArray[i] + "'" + ",";
                        } else {
                            if (nativeArray[i] != null && !nativeArray[i].isEmpty()) {
                                insertGenericFieldsSum = insertGenericFieldsSum + nativeArray[i] + ",";
                            } else {
                                insertGenericFieldsSum = insertGenericFieldsSum + genericArray[i] + ",";
                            }
                        }
                        insertGenericFields = insertGenericFields + genericArray[i] + ",";
                    }


                    if (aggArray[i] == null || aggArray[i].isEmpty()) {
                        if (constantArray[i] != null && !constantArray[i].isEmpty()) {
                            insertAgg = insertAgg + "'" + constantArray[i] + "'" + ",";
                        } else {
                            if (nativeArray[i] != null && !nativeArray[i].isEmpty()) {
                                insertAgg = insertAgg + nativeArray[i] + ",";
                            } else {
                                insertAgg = insertAgg + genericArray[i] + ",";
                            }


                        }

                    }
                } else { // this is the last iteration
                    if (aggArray[i] != null && !aggArray[i].isEmpty()) {
                        insertGenericFieldsSum = insertGenericFieldsSum + aggArray[i] + "(" + genericArray[i] + ")";
                        insertGenericFields = insertGenericFields + targetFieldArray[i];
                    } else {
                        //check constant if initialized
                        if (constantArray[i] != null && !constantArray[i].isEmpty()) {
                            insertGenericFieldsSum = insertGenericFieldsSum + "'" + constantArray[i] + "'";
                        } else {
                            if (nativeArray[i] != null && !nativeArray[i].isEmpty()) {
                                insertGenericFieldsSum = insertGenericFieldsSum + nativeArray[i];
                            } else {
                                insertGenericFieldsSum = insertGenericFieldsSum + genericArray[i];
                            }

                        }
                        insertGenericFields = insertGenericFields + genericArray[i];
                    }

                    System.out.println("insertGenericFields :============> " + insertGenericFields);


                    if (aggArray[i] == null || aggArray[i].isEmpty()) {
                        if (constantArray[i] != null && !constantArray[i].isEmpty()) {
                            insertAgg = insertAgg + "'" + constantArray[i] + "'";
                        } else {
                            if (nativeArray[i] != null && !nativeArray[i].isEmpty()) {
                                insertAgg = insertAgg + nativeArray[i];
                            } else {
                                insertAgg = insertAgg + genericArray[i];
                            }

                        }

                    }

                }
            }


            //check for last character if ,


            int len = insertAgg.length();

            String insertAggUpd = insertAgg;


            insertGenericFieldsSum = insertGenericFieldsSum + ",";
            String otherFieldsData = "";
            otherFieldsData =
                otherFieldsData + "'" + trans_in_out + "'" + "," + "'" + execPlanCode + "'" + "," + "'" + execPlanCode +
                "'" + "," + "TO_DATE (" + "'" + execDateStr + "'" + ",'MM/DD/YYYY')" + "," + processId + "," +
                processRequestId;
            String otherFields =
                "CIS_TRANS_IN_OUT" + "," + "CIS_EXEC_PLAN_CODE" + "," + "CIS_EXEC_PLAN_STEP" + "," + "CIS_EXEC_DATE" +
                "," + "PROCESSID" + "," + "CIS_PRCS_REQST_ID";

            insertGenericFieldsSum = insertGenericFieldsSum + otherFieldsData;

            insertGenericFieldsSum = insertGenericFieldsSum + " from " + mapp_detail_table_name;


            //decipher condition code to form the where clause
            sqlStatement = configdb.createStatement();

            // select from rule_conditionP
            String readRecordSQL_2 =
                "SELECT CIS_detail_code, dtl_seq_nbr, CIS_operator1, CIS_prefix, CIS_attr_left,CIS_operator2, CIS_attr_right, CIS_attr_const, CIS_custom_process, CIS_suffix_value, CIS_operator3 " +
                " FROM PS_CIS_XPE_ACT_DTL where  CIS_detail_code =" + "'" + detailCode + "'";

            String readRecordSQL_2_cnt =
                "SELECT count(1) as cnt from " + " PS_CIS_XPE_ACT_DTL where  cis_detail_code =" + "'" + detailCode +
                "'";

            //get counts in ne_rule_condition
            int detail_cnt = 0;
            ResultSet myResultSetcnt2;

            System.out.println("readRecordSQL_2_cnt: " + readRecordSQL_2_cnt);

            myResultSetcnt2 = sqlStatement.executeQuery(readRecordSQL_2_cnt);
            while (myResultSetcnt2.next()) {
                detail_cnt = myResultSetcnt2.getInt("cnt");
                System.out.println("detail_cnt: " + detail_cnt);
            }
            myResultSetcnt.close();


            System.out.println("Condition query : " + readRecordSQL_2);
            //-ok
            //geting all data now
            String[] rc_operator_1Array = new String[detail_cnt];
            String[] rc_prefixArray = new String[detail_cnt];
            String[] rc_attribute_leftArray = new String[detail_cnt];
            String[] rc_operator_2Array = new String[detail_cnt];
            String[] rc_attribute_rightArray = new String[detail_cnt];
            String[] rc_attribute_constantArray = new String[detail_cnt];
            String[] rc_SuffixArray = new String[detail_cnt];
            String[] rc_operator_3Array = new String[detail_cnt];

            ResultSet myResultSet2 = sqlStatement.executeQuery(readRecordSQL_2);

            boolean hasNext2 = myResultSet2.next();
            int recordCounter2 = 0;

            while (hasNext2) {

                rc_detail_code = myResultSet2.getString("cis_detail_code");
                rc_detail_seq = myResultSet2.getInt("dtl_seq_nbr");
                rc_operator_1 = myResultSet2.getString("CIS_operator1");
                rc_prefix = myResultSet2.getString("CIS_prefix");
                rc_attribute_left = myResultSet2.getString("CIS_attr_left");
                rc_operator_2 = myResultSet2.getString("CIS_operator2");
                rc_attribute_right = myResultSet2.getString("CIS_attr_right");
                rc_attribute_constant = myResultSet2.getString("CIS_attr_const");
                rc_custom_process = myResultSet2.getString("CIS_custom_process");
                rc_suffix = myResultSet2.getString("CIS_suffix_value");
                rc_operator_3 = myResultSet2.getString("CIS_operator3");
                //                            System.out.println("1>>>>>>>> " +  readRecordSQL_2_cnt );

                if (rc_operator_1 == null) {
                    rc_operator_1Array[recordCounter2] = "";
                } else {
                    rc_operator_1Array[recordCounter2] = rc_operator_1;

                }

                rc_prefixArray[recordCounter2] = rc_prefix;
                rc_attribute_leftArray[recordCounter2] = rc_attribute_left;
                rc_operator_2Array[recordCounter2] = rc_operator_2;
                rc_attribute_rightArray[recordCounter2] = rc_attribute_right;
                if (rc_attribute_constant == null) {
                    rc_attribute_constantArray[recordCounter2] = "";
                } else {
                    rc_attribute_constantArray[recordCounter2] = rc_attribute_constant;

                }

                rc_SuffixArray[recordCounter2] = rc_suffix;
                if (rc_operator_3 == null) {
                    rc_operator_3Array[recordCounter2] = "";
                } else {
                    rc_operator_3Array[recordCounter2] = rc_operator_3;
                }
                hasNext2 = myResultSet2.next();
                recordCounter2++;
            }

            whereCondition = rc_operator_1 + " " + rc_prefix + " " + rc_attribute_left + " " + rc_operator_2 + " ";

            System.out.println("Where :===> " + whereCondition);
            System.out.println("rc_attribute_right : " + rc_attribute_right);

            int internalCondnCounter = 0;

            //combine all rc_right attributes
            String rc_right_attributes_combined = "";

            if (detail_cnt == 1) {
                rc_right_attributes_combined = rc_right_attributes_combined + rc_attribute_rightArray[0];
            } else {
                for (int i = 0; i < detail_cnt; i++) {
                    if (i < detail_cnt - 1) {
                        rc_right_attributes_combined = rc_right_attributes_combined + rc_attribute_rightArray[i] + ",";
                    } else {
                        rc_right_attributes_combined = rc_right_attributes_combined + rc_attribute_rightArray[i];
                    }
                }
            }

            System.out.println("rc_right_attributes_combined : " + rc_right_attributes_combined);
            //Combine all the Wheres
            String whereCombined = " ";

            for (int i = 0; i < detail_cnt; i++) {

                if (!rc_attribute_constantArray[i].isEmpty()) {
                    whereCombined =
                        whereCombined + rc_operator_1Array[i] + " " + rc_prefixArray[i] + " " +
                        rc_attribute_leftArray[i] + " " + rc_operator_2Array[i] + " " + rc_attribute_constantArray[i] +
                        " " + rc_SuffixArray[i] + " " + " " + rc_operator_3Array[i] + "\n ";
                } else {
                    whereCombined =
                        whereCombined + rc_operator_1Array[i] + " " + rc_prefixArray[i] + " " +
                        rc_attribute_leftArray[i] + " " + rc_operator_2Array[i] + " " + rc_attribute_rightArray[i] +
                        " " + rc_SuffixArray[i] + " " + rc_attribute_constantArray[i] + " " + rc_operator_3Array[i] +
                        "\n ";
                }

            }

            System.out.println("whereCombined : " + whereCombined);

            insertStmt =
                insertSql + mapp_detail_target_table + " " + "(" + insertGenericFields + "," + otherFields + ")" + insertSql_2 //select
                + insertGenericFieldsSum + whereCombined + insertSql_3 //group by
                + insertAggUpd;
            //close insertgeneric

            System.out.println("Complete insert : " + insertStmt);

            int result = sqlStatement.executeUpdate(insertStmt);
            System.out.println("Rows committed " + result);

            myResultSet.close();

        } catch (Exception e) {
            System.out.println(e);
            errorMsg = errorMsg + " : " + e;
            logger(projShare, errorMsg);
            return (-1);
        }
        return (0);
    }

    public int updateGeneric(ProjectVariable projShare, String action_code, String detailCode) {

        // init insert stmt

        String module = "updateGeneric";
        String insertGenericFields = "";
        String insertGenericFieldsSum = "";

        String errorMsg = module;
        String commitRecords = "1000";

        String insertNativeSelect = "";

        //rule condition defs
        String rc_detail_code = "";
        int rc_detail_seq;
        String rc_operator_1 = "";
        String rc_prefix = "";
        String rc_attribute_left = "";
        String rc_operator_2 = "";
        String rc_attribute_right = "";
        String rc_attribute_constant = "";

        String rc_custom_process = "";
        String rc_suffix = "";
        String rc_operator_3 = "";

        String rc_attr_left_value;
        String rc_attr_right_value;

        String whereCondition;

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        String stage = "2-UPDATE";
        String trans_in_out = "1-IN";


        String updateSql = "update PS_CIS_XPE_IMPORT a\n" + "set \n" + "(";
        String completUpdate = "";

        projShare.setstage(stage);
        projShare.settransInOut(trans_in_out);

        String execPlanCode = projShare.getextPlanCode();

        Date execDate = projShare.getExecDate();
        String execDateStr = df.format(execDate);
        System.out.println("execDate =  " + execDateStr);

        Connection configdb = projShare.getconfigDb();

        // for getting count
        String readRecordSQLcount =
            "select count(1) as cnt " + " from PS_CIS_XPE_MAP_DTL where" + " cis_action_code = " + "'" + action_code +
            "'";

        //form select from mapping_detail
        String readRecordSQL =
            "select TABLENAME, generic_field, cis_native_field, cis_constant_field, is_key, where_clause1, APP_TBL_NAME, cis_aggregate_type, dp_targetfield " +
            " from PS_CIS_XPE_MAP_DTL where " + "  cis_action_code =" + "'" + action_code + "'" + " order by seqno";

        System.out.println("mapping_detail " + readRecordSQL);

        //Select from PS_CIS_XPE_import
        String readRecordNeuSql = "";

        String param_orgCustId = "org_cust_id1";

        String updStmt = null;

        String mapp_detail_table_name = "";
        String mapp_detail_generic_field;
        String mapp_detail_native_field;
        String mapp_detail_constant_field;
        String mapp_detail_is_key;
        String mapp_detail_where_field;
        String mapp_detail_target_table = "";
        String mapp_detail_agg;
        ResultSet myResultSetcnt;
        ResultSet myMainCnt;
        int result = 0;

        //count of records
        int mapp_detail_cnt = 0;

        String key1;

        System.out.println("Entering updateGeneric 2 ");

        try {

            //conect to config
            Statement sqlStatement = configdb.createStatement();

            //          System.out.println("mapping_detail COUNT " + readRecordSQLcount );

            //get query count
            myResultSetcnt = sqlStatement.executeQuery(readRecordSQLcount);

            while (myResultSetcnt.next()) {
                mapp_detail_cnt = myResultSetcnt.getInt("cnt");
                //              System.out.println("Record values : " +  mapp_detail_cnt );
            }
            myResultSetcnt.close();

            if (mapp_detail_cnt == 0) {
                //              System.out.println("Mapping is not defined : "  );
                errorMsg = errorMsg + " Mapping_detail is not defined for action code " + action_code;
                logger(projShare, errorMsg);
                return (-1);
            }

            String[] genericArray = new String[mapp_detail_cnt];
            String[] nativeArray = new String[mapp_detail_cnt];
            String[] whereArray = new String[mapp_detail_cnt];
            String[] constantArray = new String[mapp_detail_cnt];

            //geting all data now
            ResultSet myResultSet = sqlStatement.executeQuery(readRecordSQL);

            boolean hasNext = myResultSet.next();
            int recordCounter = 0;

            while (hasNext) {

                mapp_detail_table_name = myResultSet.getString("TABLENAME");
                mapp_detail_generic_field = myResultSet.getString("generic_field");
                mapp_detail_native_field = myResultSet.getString("cis_native_field");
                mapp_detail_constant_field = myResultSet.getString("cis_constant_field");
                mapp_detail_is_key = myResultSet.getString("is_key");
                mapp_detail_where_field = myResultSet.getString("where_clause1");
                mapp_detail_target_table = myResultSet.getString("APP_TBL_NAME");
                mapp_detail_agg = myResultSet.getString("cis_aggregate_type");

                genericArray[recordCounter] = mapp_detail_generic_field;
                nativeArray[recordCounter] = mapp_detail_native_field;
                whereArray[recordCounter] = mapp_detail_where_field;
                constantArray[recordCounter] = mapp_detail_constant_field;

                //                System.out.println("Record values : " +  mapp_detail_table_name + "--" +  mapp_detail_generic_field );
                //               System.out.println("Record values : " +  mapp_detail_target_table + "--" +  mapp_detail_target_table );

                hasNext = myResultSet.next();
                recordCounter++;

            } //while
            myResultSet.close();

            //close insertgeneric
            //form ps query
            String ps_query_1 = "Select ";
            String ps_query_1_cnt = "Select ";

            String main_query_1 = " ";
            String main_query_1_cnt = "Select ";


            //form Target Select columns
            for (int i = 0; i < mapp_detail_cnt; i++) {
                if (i == 0) {
                    if (constantArray[i] != null && !constantArray[i].isEmpty()) {
                        ps_query_1 = ps_query_1 + constantArray[i];
                    } else {
                        ps_query_1 = ps_query_1 + "b." + nativeArray[i];
                    }
                } else {
                    if (constantArray[i] != null && !constantArray[i].isEmpty()) {
                        ps_query_1 = ps_query_1 + "," + constantArray[i];
                    } else {
                        ps_query_1 = ps_query_1 + "," + "b." + nativeArray[i];
                    }
                }
            }
            //           System.out.println("ps_query_1 select : " +  ps_query_1  );


            //form Main query Select columns
            for (int i = 0; i < mapp_detail_cnt; i++) {
                if (i == 0) {
                    main_query_1 = main_query_1 + "a." + genericArray[i];
                } else {
                    main_query_1 = main_query_1 + "," + "a." + genericArray[i];
                }
            }
            System.out.println("main_query_1 select : " + main_query_1);

            String queryTable = "";
            if (mapp_detail_table_name.equals(mapp_detail_target_table)) {
                queryTable = "dual";
            } else {
                queryTable = mapp_detail_table_name;

            }

            ps_query_1 = ps_query_1 + " from " + queryTable + " b ";


            //decipher condition code to form the where clause
            sqlStatement = configdb.createStatement();

            // select from rule_conditionP
            String readRecordSQL_2 =
                "SELECT CIS_detail_code, dtl_seq_nbr, CIS_operator1, CIS_prefix, CIS_attr_left,CIS_operator2, CIS_attr_right, CIS_attr_const, CIS_custom_process, CIS_suffix_value, CIS_operator3 " +
                " FROM PS_CIS_XPE_ACT_DTL where  CIS_detail_code =" + "'" + detailCode + "'";


            String readRecordSQL_2_cnt =
                "SELECT count(1) as cnt from " + " PS_CIS_XPE_ACT_DTL where  CIS_detail_code =" + "'" + detailCode +
                "'";

            //get counts in ne_rule_condition
            int detail_cnt = 0;
            ResultSet myResultSetcnt2;

            System.out.println("readRecordSQL_2_cnt: " + readRecordSQL_2_cnt);

            myResultSetcnt2 = sqlStatement.executeQuery(readRecordSQL_2_cnt);
            while (myResultSetcnt2.next()) {
                detail_cnt = myResultSetcnt2.getInt("cnt");
                //           System.out.println("detail_cnt: " +  detail_cnt );
            }
            myResultSetcnt2.close();


            //         System.out.println("Condition query : " + readRecordSQL_2 );
            //-ok
            //geting all data now
            String[] rc_operator_1Array = new String[detail_cnt];
            String[] rc_prefixArray = new String[detail_cnt];
            String[] rc_attribute_leftArray = new String[detail_cnt];
            String[] rc_operator_2Array = new String[detail_cnt];
            String[] rc_attribute_rightArray = new String[detail_cnt];
            String[] rc_attribute_constantArray = new String[detail_cnt];
            String[] rc_SuffixArray = new String[detail_cnt];
            String[] rc_operator_3Array = new String[detail_cnt];

            ResultSet myResultSet2 = sqlStatement.executeQuery(readRecordSQL_2);

            boolean hasNext2 = myResultSet2.next();
            int recordCounter2 = 0;

            while (hasNext2) {

                rc_detail_code = myResultSet2.getString("CIS_detail_code");
                rc_detail_seq = myResultSet2.getInt("dtl_seq_nbr");
                rc_operator_1 = myResultSet2.getString("CIS_operator1");
                rc_prefix = myResultSet2.getString("CIS_prefix");
                rc_attribute_left = myResultSet2.getString("CIS_attr_left");
                rc_operator_2 = myResultSet2.getString("CIS_operator2");
                rc_attribute_right = myResultSet2.getString("CIS_attr_right");
                rc_attribute_constant = myResultSet2.getString("CIS_attr_const");
                rc_custom_process = myResultSet2.getString("CIS_custom_process");
                rc_suffix = myResultSet2.getString("CIS_suffix_value");
                rc_operator_3 = myResultSet2.getString("CIS_operator3");
                //                        System.out.println("1>>>>>>>> " +  readRecordSQL_2_cnt );

                if (rc_operator_1 == null) {
                    rc_operator_1Array[recordCounter2] = "";
                } else {
                    rc_operator_1Array[recordCounter2] = rc_operator_1;

                }

                rc_prefixArray[recordCounter2] = rc_prefix;
                rc_attribute_leftArray[recordCounter2] = rc_attribute_left;
                rc_operator_2Array[recordCounter2] = rc_operator_2;
                rc_attribute_rightArray[recordCounter2] = rc_attribute_right;
                if (rc_attribute_constant == null) {
                    rc_attribute_constantArray[recordCounter2] = "";
                } else {
                    rc_attribute_constantArray[recordCounter2] = rc_attribute_constant;

                }

                rc_SuffixArray[recordCounter2] = rc_suffix;
                if (rc_operator_3 == null) {
                    rc_operator_3Array[recordCounter2] = "";
                } else {
                    rc_operator_3Array[recordCounter2] = rc_operator_3;
                }
                hasNext2 = myResultSet2.next();
                recordCounter2++;
            }
            myResultSet2.close();
            whereCondition = rc_operator_1 + " " + rc_prefix + " " + rc_attribute_left + " " + rc_operator_2 + " ";

            //          System.out.println("Where :===> " +  whereCondition  );
            //           System.out.println("rc_attribute_right : " +  rc_attribute_right  );

            int internalCondnCounter = 0;

            //combine all rc_right attributes
            String rc_right_attributes_combined = "";

            if (detail_cnt == 1) {
                rc_right_attributes_combined = rc_right_attributes_combined + rc_attribute_rightArray[0];
            } else {
                for (int i = 0; i < detail_cnt; i++) {
                    if (i < detail_cnt - 1) {
                        rc_right_attributes_combined = rc_right_attributes_combined + rc_attribute_rightArray[i] + ",";
                    } else {
                        rc_right_attributes_combined = rc_right_attributes_combined + rc_attribute_rightArray[i];
                    }
                }
            }

            //         System.out.println("rc_right_attributes_combined : " +  rc_right_attributes_combined  );
            //          System.out.println(" ps_query_1 " +  ps_query_1  );
            //          System.out.println("ps_query_1_cnt : " +  ps_query_1_cnt  );

            System.out.println("main_query_1 : " + main_query_1);
            //           System.out.println("main_query_1_cnt : " +  main_query_1_cnt  );


            //Main loop
            Statement stmt = null;
            stmt = configdb.createStatement();
            stmt = configdb.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);


            String errorMsgRead = "";

            System.out.println("ps_query_1 : " + ps_query_1);
            String whereCombined = buildWhere_ver2(detailCode, projShare, 'Y');
            System.out.println("whereCombined 1 : " + whereCombined);

            updateSql = "update " + mapp_detail_target_table + " a\n" + " set \n" + "(";

            completUpdate = updateSql + main_query_1 + ")" + " =  " + "(" + ps_query_1 + whereCombined + ") ";
            System.out.println("completUpdate : " + completUpdate);

            result = sqlStatement.executeUpdate(completUpdate);
            System.out.println("Rows committed " + result);

            myResultSet.close();

        } catch (Exception e) {
            errorMsg = errorMsg + " : " + e;
            System.out.println("errorMsg : " + errorMsg);
            logger(projShare, errorMsg);
            return (-1);
        }
        return (0);

    }

    public void processExecPlan(String execPlanCode, ProjectVariable projShare) {

        String module = "processExecPlan";
        ResultSet myResultSet;
        String execPlanStep;
        int execSeq;
        String ruleSetCode;
        String status = "A";
        String billing_cycle_id = "";
        String userId = projShare.getuserId();
        int return_status = 1;
        String lock_status = "";
        int result;
        String descr;

        Connection configdb = projShare.getconfigDb();

        System.out.println("Entering exec Plan========================>: " + execPlanCode);

        System.out.println("userId  => " + userId);

        descr = "Unable to execute : " + execPlanCode + " Plan in Progress, System is locked by USERID : " + userId;

        //update instance to locked

        //       System.out.println("Rows committed " + result);

        try {

            //get instance locked status
            Statement stmt1 = configdb.createStatement();
            Statement stmt2 = configdb.createStatement();
            Statement stmt3 = configdb.createStatement();
            Statement stmt4 = configdb.createStatement();

            ResultSet rs1 = stmt1.executeQuery("SELECT LOCK_STATUS  FROM PS_CIS_XPE_INSTANCE ");

            if (rs1 != null && rs1.next()) {
                lock_status = rs1.getString(1);
                System.out.println("lock_status  => " + lock_status);
                rs1.close();
            }

            stmt1.close();

            Date execDate = new Date();
            projShare.setexecDate(execDate);

            // for getting execution steps
            String readRecordSQL =
                "select cis_exec_plan_step, cis_execution_seq, cis_rule_set_code, STATUS_MSG " +
                " from PS_CIS_XPE_EXECSTP where cis_exec_plan_code = " + "'" + execPlanCode + "'" +
                " order by cis_execution_seq";
            System.out.println("readRecordSQL : " + readRecordSQL);

            //conect to config
            Statement sqlStatement = configdb.createStatement();

            if (lock_status.equals("L")) {
                System.out.println("Exiting out due to current running plan ");
                insertProcess(projShare, descr, "L");
                return;
            } else if (lock_status.equals("U")) {
                String updSql = "UPDATE PS_CIS_XPE_INSTANCE SET LOCK_STATUS = 'L'";
                result = stmt2.executeUpdate(updSql);
            }
            stmt2.close();

            //get query count
            myResultSet = sqlStatement.executeQuery(readRecordSQL);
            while (myResultSet.next()) {

                execPlanStep = myResultSet.getString("cis_exec_plan_step");
                ruleSetCode = myResultSet.getString("cis_rule_set_code");
                status = myResultSet.getString("STATUS_MSG");
                execSeq = myResultSet.getInt("cis_execution_seq");

                projShare.setextPlanCode(execPlanCode);
                projShare.setruleSetCode(ruleSetCode);
                projShare.setexecDate(execDate);
                projShare.setexecStep(execPlanStep);
                projShare.setexecSeq(execSeq);

                //              System.out.println("execPlanCode :  "  + execPlanCode );
                System.out.println("execPlanStep :  " + execPlanStep);
                System.out.println("execSeq :  " + execSeq);

                String logMsg;
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                final String stringDt_execFrom = dateFormat1.format(execFromDate);
                final java.sql.Date sql_execFromDate = java.sql.Date.valueOf(stringDt_execFrom);
                System.out.println("sql_execFromDate :  " + sql_execFromDate);

                final String stringDt_execTo = dateFormat1.format(execToDate);
                final java.sql.Date sql_execToDate = java.sql.Date.valueOf(stringDt_execTo);
                System.out.println("sql_execToDate :  " + sql_execToDate);
                logMsg =
                    "execFromDate 170830a " + execFromDate + "  execToDate " + execToDate + " sql from " + sql_execFromDate +
                    " sql to " + sql_execToDate;
                System.out.println("logMsg : " + logMsg);


                descr = "Starting Execution Plan : " + execPlanCode;
                insertProcess(projShare, descr, " ");

                    return_status = processRuleInRuleSet(projShare, ruleSetCode);

                // If process fails quit
                if (return_status == -1) {
                    break;
                }

            } //while
            myResultSet.close();
            String updSql = "UPDATE PS_CIS_XPE_INSTANCE SET LOCK_STATUS = 'U'";
            result = stmt4.executeUpdate(updSql);
            stmt4.close();

            descr = "Completed Execution Plan : " + execPlanCode;
            insertProcess(projShare, descr, " ");
        } //try
        catch (Exception e) {
            System.out.println(e);
        } //catch

        System.out.println("Exiting exec Plan: <=========================== " + execPlanCode);

    }

    public int processRuleInRuleSet(ProjectVariable projShare, String ruleSet) {
        System.out.println("\n Entering processRuleInRuleSet:...................> " + ruleSet);
        String module = "processRuleInRuleSet";

        ResultSet myResultSet;
        String ruleCode = "";
        String ruleName = "";
        String ruleSetCode = "";
        String conditionCode = "";
        int return_status = 1;
        String descr;

        Connection configdb = projShare.getconfigDb();

        // for getting execution steps
        String readRecordSQL =
            "select cis_rule_code, cis_rule_name, cis_rule_set_code,  cis_condition_code" +
            " from PS_CIS_XPE_rule  where cis_rule_set_code = " + "'" + ruleSet + "'" + "order by seq_nbr";
        System.out.println("Rule sql : " + readRecordSQL);

        try {
            //conect to config
            Statement sqlStatement = configdb.createStatement();

            //get query count
            myResultSet = sqlStatement.executeQuery(readRecordSQL);
            while (myResultSet.next()) {
                ruleCode = myResultSet.getString("cis_rule_code");
                ruleName = myResultSet.getString("cis_rule_name");
                ruleSetCode = myResultSet.getString("cis_rule_set_code");
                conditionCode = myResultSet.getString("cis_condition_code");

                System.out.println("Rule Name 1 => " + ruleName);

                descr = "Executing Rule Name : " + ruleName;

                projShare.setruleName(ruleName);

                switch (conditionCode) {
                case "ALWAYS":
                    System.out.println("Processing RuleInRuleset : " + ruleCode + ":" + ruleName + ":" + ruleSetCode +
                                       ":" + conditionCode);
                    insertProcess(projShare, descr, "R");
                    return_status = processActionsInRule(projShare, ruleCode);
                    updateProcess(projShare, return_status, descr);
                    break;
                case "SKIP":
                    System.out.println("Skipping : " + conditionCode);
                    break;
                default:
                    break;
                } //switch

                if (return_status == -1) {
                    break;
                }

            } //while
            myResultSet.close();

        } //try
        catch (Exception e) {
            System.out.println(e);
        } //catch
        System.out.println("Exiting ruleSet:<.............................. \n\n" + ruleSet);
        return (return_status);

    }

    public String getActionDetailCode(ProjectVariable projShare, String actionCode) {

        String module = "getActionDetailCode";
        String errorMsg = module;
        String execPlanCode = projShare.getextPlanCode();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

        Date execDate = projShare.getExecDate();
        String execDateStr = df.format(execDate);
        Connection configdb = projShare.getconfigDb();


        //         System.out.println("Entering getActionDetailCode for: **********> " +  actionCode );

        ResultSet myResultSet;
        String detailCode = "";

        // for getting execution steps
        String readRecordSQL =
            "select cis_detail_code " + " from PS_CIS_XPE_ACT_DTL  where cis_action_code = " + "'" + actionCode + "'";
        //      System.out.println("readRecordSQL : " +  readRecordSQL );

        try {
            //conect to config
            Statement sqlStatement = configdb.createStatement();

            //get query count
            myResultSet = sqlStatement.executeQuery(readRecordSQL);
            while (myResultSet.next()) {
                detailCode = myResultSet.getString("cis_detail_code");

                System.out.println("Read in getActionDetailCode : " + detailCode);

            }
            myResultSet.close();

        } //try
        catch (Exception e) {
            System.out.println(e);
        } //catch
        System.out.println("Exiting getActionDetailCode: *************<< \n\n" + actionCode);
        return (detailCode);

    }

    public int processActionsInRule(ProjectVariable projShare,
                                    String ruleCode) {
        //return  0 if successfull and -1 if failed

        System.out.println("\n Processing processActionsInRule: ##################################################################################>" +
                           ruleCode);

        String module = "processActionsInRule";
        ResultSet myResultSet;
        String actionCode = "";
        String actionTypeId = "";
        String detailCode;
        String errorMsg = module;
        int return_status = 0;

        Connection configdb = projShare.getconfigDb();

        //
        String readRecordSQL =
            "select cis_action_code, actiontype, cis_rule_code " + " from PS_CIS_XPE_ACTION  where cis_rule_code = " +
            "'" + ruleCode + "'";
        System.out.println("readRecordSQL : " + readRecordSQL);

        try {
            //conect to config
            Statement sqlStatement = configdb.createStatement();

            //get query count
            myResultSet = sqlStatement.executeQuery(readRecordSQL);
            while (myResultSet.next()) {
                actionCode = myResultSet.getString("cis_action_code");
                actionTypeId = myResultSet.getString("actiontype");
                ruleCode = myResultSet.getString("cis_rule_code");

                System.out.println("Read in processActionsInRule actionCode : actionTypeId : ruleCode : " + actionCode +
                                   ":" + actionTypeId + ":" + ruleCode);

                detailCode = getActionDetailCode(projShare, actionCode);

                if (detailCode.isEmpty()) {
                    errorMsg = errorMsg + " Action_DETAIL -  DetailCode not found for actioncode : " + actionCode;
                    logger(projShare, errorMsg);
                    return (-1);
                }
                System.out.println("Return value detailCode : " + detailCode);


                switch (actionTypeId) {
                case "S2G":
                    return_status = source2generic_ver3(projShare, actionCode, detailCode);
                    break;
                case "G2T":
                    return_status = generic2target(projShare, actionCode, detailCode);
                    break;
                case "G2G":
                    return_status = generic2generic(projShare, actionCode, detailCode);
                    break;
                case "UG":
                    return_status = updateGeneric(projShare, actionCode, detailCode);
                    break;
                case "IG":
                    return_status = insert2Generic(projShare, actionCode, detailCode);
                    break;
                case "CSQL":
                    return_status = update_custom_sql(projShare, actionCode, detailCode);
                    break;
                case "CPROC":
                    return_status = custom_proc(projShare, actionCode, detailCode);
                    break;
                case "EX2G": 
                	return_status = external2Generic(projShare, actionCode);
                	break;
                case "CSCR":
                	return_status = executeScript(projShare, actionCode);
                default:
                    break;

                } //switch

            }
            myResultSet.close();
            System.out.println("Return status for actioncode  : " + actionCode + " : " + return_status);


        } //try
        catch (Exception e) {
            System.out.println(e);
        } //catch
        System.out.println("Completing processActionsInRule: <##########################################################################\n\n" +
                           ruleCode);
        return (return_status);
    }

    public void insertProcess(ProjectVariable projShare, String msg, String status) {
        String module = "insertProcess";

        String execPlanCode = projShare.getextPlanCode();
        String execStep = projShare.getexecStep();
        int execSeq = projShare.getexecSeq();
        String stage = projShare.getstage();
        String ruleName = projShare.getruleName();
        String userId = projShare.getuserId();

        int process_id_seq = 0;

        Connection configdb = projShare.getconfigDb();

        try {
            Statement stmt = configdb.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT PS_CIS_XPE_PROCESS_ID_SEQ.nextval FROM dual");

            if (rs != null && rs.next()) {
                process_id_seq = rs.getInt(1);
                System.out.println("Writing process_id_seq  => " + process_id_seq);
                rs.close();
            }
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        } //catch

        String insertSql =
            "insert into PS_CIS_XPE_PROCESS ( PROCESSID, CIS_EXEC_PLAN_CODE , CIS_EXEC_PLAN_STEP, CIS_EXECUTION_SEQ , STATUS_MSG, DESCR100, ACTUAL_START_DT, USERID " +
            " )" + "values (?,?,?,?,?,?,sysdate, ?)";
        String descr = ruleName;
        // DEV System.out.println("Rule Name  => " + ruleName);

        try {
        	
        	if (execPlanCode.equalsIgnoreCase("A10")) {

        		PreparedStatement pstmt = configdb.prepareStatement(insertSql);
                pstmt.setInt(1, process_id_seq);
                pstmt.setString(2, execPlanCode);
                pstmt.setString(3, execStep);
                pstmt.setInt(4, execSeq);
                pstmt.setString(5, status);
                pstmt.setString(6, msg);
                pstmt.setString(7, userId);
            	pstmt.executeUpdate(); // execute insert statement
}

            projShare.setprocessId(process_id_seq);

        }

        catch (Exception e) {
            System.out.println(e);
        } //catch

// System.out.println(" 170830a exiting process status insert ");
    }

    public void updateProcess(ProjectVariable projShare, int return_status, String descr) {
        String module = "updateProcess";

        String execPlanCode = projShare.getextPlanCode();
        String execStep = projShare.getexecStep();
        int execSeq = projShare.getexecSeq();
        int processId = projShare.getprocessId();
        String ruleName = projShare.getruleName();
        int loggerId = projShare.getloggerId();

        String insertSql = "";

        //       System.out.println(" Updating using processId :  "  + processId );

        Connection configdb = projShare.getconfigDb();

        if (return_status == 0) {
            descr = ruleName;
            insertSql =
                "update PS_CIS_XPE_PROCESS set STATUS_MSG = 'C', actual_finish_dt = sysdate , DESCR100 = ?" +
                "where  PROCESSID  = ? and CIS_EXEC_PLAN_CODE = ? and CIS_EXEC_PLAN_STEP = ? and CIS_EXECUTION_SEQ = ? ";
        } else if (return_status == -1) {
            descr = ruleName + " Check PS_CIS_XPE_LOG_TBL : CIS_LOG_KEY = " + loggerId;
            insertSql =
                "update PS_CIS_XPE_PROCESS set STATUS_MSG = 'E', actual_finish_dt = sysdate , DESCR100 = ?" +
                "where  PROCESSID  = ? and CIS_EXEC_PLAN_CODE = ? and CIS_EXEC_PLAN_STEP = ? and CIS_EXECUTION_SEQ = ?  ";
            System.out.println(" Encountered error :  " + processId);

        }


        try {
            PreparedStatement pstmt = configdb.prepareStatement(insertSql);

            pstmt.setString(1, descr);
            pstmt.setInt(2, processId);
            pstmt.setString(3, execPlanCode);
            pstmt.setString(4, execStep);
            pstmt.setInt(5, execSeq);

            pstmt.executeUpdate(); // execute statement
        } catch (Exception e) {
            System.out.println(e);
        } //catch

    }

    public void logger(ProjectVariable projShare, String errorDetails) {

        String execPlanCode = projShare.getextPlanCode();

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");


        Date execDate = projShare.getExecDate();
        String execDateStr = df.format(execDate);

        String stage = projShare.getstage();
        String transInOut = projShare.gettransInOut();
        String ruleName = projShare.getruleName();
        String errorMsg = "";
        String errorMsg_250 = "";
        int logkeyseq = 0;

        Connection configdb = projShare.getconfigDb();

        System.out.println("In Logger ");


        String insertSql =
            "insert into PS_CIS_XPE_LOG_TBL (   CIS_LOG_KEY , CIS_EXEC_PLAN_CODE , KEY1 , KEY2 , KEY3 , KEY_DATE_01 , CIS_STAGE, CIS_TRANS_IN_OUT ," +
            "CIS_BILLCYCLE_INFO ,  CIS_STAGE_DESCR, ERROR_MESSAGE )" + "values (?,?,?,?,?,?,?,?,?,?,?)";

        try {

            Statement stmt = configdb.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT PS_CIS_XPE_LOG_KEY_SEQ.nextval FROM dual");

            if (rs != null && rs.next()) {
                logkeyseq = rs.getInt(1);
                rs.close();
            }
            stmt.close();

            PreparedStatement pstmt = configdb.prepareStatement(insertSql);

            projShare.setloggerId(logkeyseq);


            errorMsg = "Rule : " + ruleName + "\n" + errorDetails;

            System.out.println("Error message 1 " + errorMsg + "Len " + errorMsg.length());

            if (errorMsg.length() > 250) {
                errorMsg_250 = errorMsg.substring(0, 248);
            } else {
                errorMsg_250 = errorMsg;
            }


            System.out.println("Error message 2 " + errorMsg_250);

            pstmt.setInt(1, logkeyseq);
            pstmt.setString(2, execPlanCode);
            pstmt.setString(3, "");
            pstmt.setString(4, "");
            pstmt.setString(5, "");
            pstmt.setString(6, "");
            pstmt.setString(7, stage);
            pstmt.setString(8, transInOut);
            pstmt.setString(9, "");
            pstmt.setString(10, "");
            pstmt.setString(11, errorMsg_250);
            pstmt.executeUpdate(); // execute insert statement
        } catch (Exception e) {
            System.out.println(e);
        } //catch

    }

    public int prepareProjResource(ProjectVariable projShare) {
        //test
        String module = "prepareProjResource";

        String execPlanCode = projShare.getextPlanCode();
        String execStep = projShare.getexecStep();
        int execSeq = projShare.getexecSeq();
        String stage = projShare.getstage();
        int last_resource_id = 0;

        String project_id = "";
        String activity_id = "";
        String trans_attr3 = "";
        String trans_attr4 = "";
        double trans_agg_amt1 = 0;
        String prod_desc = "";
        String prod_uom = "";
        String contract_no = "";
        int cntr_line_no = 0;
        String tgt_cust1_detail1 = "";
        int trans_agg_qty1 = 0;
        String resType = "";
        String productId = "";
        String opc = "";
        String key1 = "";
        int usageCount = 0;
        double billingRate = 0;
        double billingAmount = 0;
        String pc_bu = "";
        String resource_id = "";
        String tgt_cust_id1 = "";
        java.sql.Date monthlastDt;
        int result;
        int minResourceId = 0;
        int maxResourceId = 0;

        String errorMsg = module;

        double ratederived = 0; //tbd from query
        String stringDate;

        int processId = projShare.getprocessId();
        String userid = projShare.getuserId();

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");

        Date lastbillcyle = new Date();
        stringDate = dateFormat1.format(lastbillcyle);
        java.sql.Date sqllastbillcyle = java.sql.Date.valueOf(stringDate);

        Date todayDate = new Date();
        stringDate = dateFormat1.format(todayDate);
        java.sql.Date sqltodayDate = java.sql.Date.valueOf(stringDate);
        Connection configdb = projShare.getconfigDb();

        int processRequestId = projShare.getprocessRequestId();

        System.out.println("processRequestId  : " + processRequestId);


        String readSQL =
            "SELECT  DISTINCT CIS_TARGET_CUSTID1, CIS_TARGTCUST1DET1, PROJECT_ID, ACTIVITY_ID, ATTR_VALUE3,  \n" +
            "  PRODUCT_DESCR, UOM_RECV, CONTRACT_NUM, CONTRACT_LINE_NUM, BUSINESS_UNIT_PC, RESOURCE_ID, SUM(CIS_TRANS_AGG_QTY1) AS CIS_TRANS_AGG_QTY1, SUM(round(CIS_TRANS_BI_AMT1,2)) AS CIS_TRANS_BI_AMT1 ," +
            "last_day(max(key_date_01)) as month_last_dt\n" + "from PS_CIS_XPE_IMP_CONTR_VW b \n" +
            "where cis_stage in ('1-IMPORT', '2_SWT_CNAM_INT_AGG','2_SWT_LIDB_INT_AGG','2_SWT_CNAM_EXT_AGG','2_SWT_GETDATA_EXT_AGG','2_SWT_LIDB_EXT_AGG','2_SWT_OLNS_EXT_AGG','3-AGG-SHORT')  and cis_status = 'P' " +
            "and project_id is not null and activity_id is not null " +
            "GROUP BY  CIS_TARGET_CUSTID1, CIS_TARGTCUST1DET1, PROJECT_ID, ACTIVITY_ID, ATTR_VALUE3, PRODUCT_DESCR, UOM_RECV, CONTRACT_NUM, CONTRACT_LINE_NUM, BUSINESS_UNIT_PC, RESOURCE_ID";

        System.out.println("readSQL Proj Res  : " + readSQL);

        try {

            Statement sqlStatement = configdb.createStatement();

            Statement sqlStatement_pc_install = configdb.createStatement();

            ResultSet myResultSet = sqlStatement.executeQuery(readSQL);

            boolean hasNext = myResultSet.next();
            int recordCounter = 0;
            int recordCounter1 = 0;

            while (hasNext) { //main proj resource

                tgt_cust_id1 = myResultSet.getString("CIS_TARGET_CUSTID1");
                tgt_cust1_detail1 = myResultSet.getString("CIS_TARGTCUST1DET1");
                project_id = myResultSet.getString("PROJECT_ID");
                activity_id = myResultSet.getString("ACTIVITY_ID");
                trans_attr3 = myResultSet.getString("ATTR_VALUE3");
                prod_desc = myResultSet.getString("PRODUCT_DESCR");
                prod_uom = myResultSet.getString("UOM_RECV");
                contract_no = myResultSet.getString("CONTRACT_NUM");
                cntr_line_no = myResultSet.getInt("CONTRACT_LINE_NUM");
                pc_bu = myResultSet.getString("BUSINESS_UNIT_PC");
                resource_id = myResultSet.getString("RESOURCE_ID");
                monthlastDt = myResultSet.getDate("month_last_dt");

                trans_agg_qty1 = myResultSet.getInt("CIS_TRANS_AGG_QTY1");
                billingAmount = myResultSet.getDouble("CIS_TRANS_BI_AMT1");

                //      trans_attr4  = " ";  //As requested by Monika/Matt

                //Logic provided by Monika email 07/25


                switch (trans_attr3) {
                case "CNAM":
                    trans_attr4 = trans_attr3;
                    break;
                case "LIDB":
                    trans_attr4 = trans_attr3;
                    break;
                case "SWTR":
                    trans_attr4 = "CNAM";
                    break;
                default:
                    break;
                } //switch

                //    System.out.println("recordCounter " + recordCounter);
                //   System.out.println("trans_agg_qty1 " + trans_agg_qty1);


                if (trans_agg_qty1 != 0) {
                    ratederived = billingAmount / trans_agg_qty1;
                } else {
                    ratederived = 0;
                }


                //update last resource id

                String updSql = "UPDATE PS_INSTALLATION_PC SET LAST_RESOURCE_ID = LAST_RESOURCE_ID + 1 ";
                result = sqlStatement_pc_install.executeUpdate(updSql); //PROD RESOURCE_ID UPDATE #1 of 3

                //       System.out.println("Rows committed " + result);


                //get last resource id
                Statement stmt = configdb.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT LAST_RESOURCE_ID FROM PS_INSTALLATION_PC");

                if (rs != null && rs.next()) {
                    last_resource_id = rs.getInt(1);
                    //            System.out.println("last_resource_id  => " + last_resource_id);
                    rs.close();
                }

                stmt.close();

                //     System.out.println("2=====================> " );

                //              System.out.println("processId " + processId);

                //               System.out.println("processRequestId " + processRequestId);

                String insertSql =
                    "insert into PS_PROJ_RESOURCE ( " + //PROD #2 of 3
                    "BUSINESS_UNIT, \n" + //1
                    "PROJECT_ID, \n" + //2
                    "ACTIVITY_ID, \n" + //3
                    "RESOURCE_ID, \n" + //4,
                    "RESOURCE_ID_FROM, \n" + //5
                    "BUSINESS_UNIT_GL, \n" + //6
                    "BUS_UNIT_GL_FROM, \n" + //7
                    "CURRENCY_CD, \n" + //8
                    "ANALYSIS_TYPE, \n" + //9
                    "RESOURCE_TYPE, \n" + //10
                    "RESOURCE_CATEGORY , \n" + //11
                    "TRANS_DT ,\n" + //12
                    "ACCOUNTING_DT, \n" + //13
                    "OPRID ,\n" + //14
                    "DTTM_STAMP,\n" + //15
                    "FOREIGN_CURRENCY, \n" + //16
                    "RT_TYPE, \n" + //17
                    "FOREIGN_AMOUNT,\n" + //18
                    "RATE_MULT,\n" + //19
                    "RATE_DIV, \n" + //20
                    "CUR_EFFDT, \n" + //21
                    "PROCESS_INSTANCE,\n" + //22
                    "PC_DISTRIB_STATUS,\n" + //23
                    "GL_DISTRIB_STATUS, \n" + //24
                    "RESOURCE_STATUS, \n" + //25
                    "DESCR, \n" + //26
                    "SYSTEM_SOURCE, \n" + //27
                    "UNIT_OF_MEASURE,\n" + //28
                    "BUSINESS_UNIT_PO, \n" + //29
                    "CONTRACT_NUM, \n" + //30
                    "CONTRACT_LINE_NUM, \n" + //31
                    "BI_DISTRIB_STATUS, \n" + //32
                    "REV_DISTRIB_STATUS,\n" + //33
                    "CUST_ID, \n" + //34
                    "RESOURCE_QUANTITY, \n" + //35
                    "RESOURCE_AMOUNT, \n" + //36
                    "BUDGET_HDR_STATUS, \n" + //37
                    "BUDGET_DT, \n" + //38
                    "BD_DISTRIB_STATUS,\n" + //39
                    "FA_STATUS, \n" + //40
                    "PM_REVIEWED,\n" + //41
                    "PRICED_RATE, \n" + //42
                    "CST_DISTRIB_STATUS, \n" + //43
                    "FND_DIST_STATUS, \n " + //44
                    "JOURNAL_ID, \n " + //45
                    "UNPOST_SEQ, \n " + //46
                    "JOURNAL_LINE, \n " + //47
                    "FISCAL_YEAR, \n " + //48
                    "ACCOUNTING_PERIOD, \n" + //49
                    "JOURNAL_DATE, \n" + //50
                    "ACCOUNT,  \n " + "ALTACCT,\n" + "DEPTID,\n" + "OPERATING_UNIT,\n" + "PRODUCT,\n" + "FUND_CODE,\n" +
     "CLASS_FLD,\n" + "PROGRAM_CODE,\n" + "BUDGET_REF,\n" + "AFFILIATE,\n" + //60
     "AFFILIATE_INTRA1,\n" + "AFFILIATE_INTRA2,\n" + "CHARTFIELD1,\n" + "CHARTFIELD2,\n" + "CHARTFIELD3,\n" +
     "STATISTICS_CODE,\n" + "LEDGER_GROUP,\n" + "RESOURCE_SUB_CAT,\n" + "RES_USER1,\n" + "RES_USER2,\n" + //70
     "RES_USER3,\n" + "RES_USER4,\n" + "RES_USER5,\n" + "JRNL_LN_REF,\n" + "OPEN_ITEM_STATUS,\n" + "LINE_DESCR,\n" +
     "JRNL_LINE_STATUS,\n" + "PROJ_TRANS_TYPE,\n" + "PROJ_TRANS_CODE,\n" + "EMPLID,\n" + //80
     "TIME_RPTG_CD,\n" + "JOBCODE,\n" + "COMPANY,\n" + "BUSINESS_UNIT_AP,\n" + "VENDOR_ID,\n" + "VOUCHER_ID,\n" +
     "APPL_JRNL_ID,\n" + "DST_ACCT_TYPE,\n" + "PO_DISTRIB_STATUS,\n" + "REQ_ID,\n" + "PO_ID,\n" +
     "AM_DISTRIB_STATUS,\n" + "BUSINESS_UNIT_AM,\n" + "ASSET_ID,\n" + "PROFILE_ID,\n" + "COST_TYPE,\n" + "BOOK,\n" +
     "INCENTIVE_ID,\n" + "BUSINESS_UNIT_BI,\n" + //100
     "INVOICE,\n" + "BUSINESS_UNIT_AR,\n" + "ITEM,\n" + "BUSINESS_UNIT_IN,\n" + "INV_ITEM_ID,\n" +
     "BUSINESS_UNIT_OM,\n" + "ORDER_NO,\n" + "EX_DOC_ID,\n" + "EX_DOC_TYPE,\n" + "KK_AMOUNT_TYPE,\n" +
     "KK_TRAN_OVER_FLAG,\n" + "KK_TRAN_OVER_OPRID,\n" + "BUDGET_OVER_ALLOW,\n" + "BUDGET_LINE_STATUS,\n" + "LEDGER,\n" +
     "BUSINESS_UNIT_BD,\n" + "TIME_SHEET_ID,\n" + "SHEET_ID,\n" + "ACTIVITY_ID_DETAIL,\n" + //120
     "TXN_LMT_TRANS_ID,\n" + "CA_FEE_STATUS,\n" + "BUSINESS_UNIT_WO,\n" + "WO_ID,\n" + "RSRC_TYPE,\n" +
     "AMOUNT_IN_EXCESS,\n" + "RECLAIMED_FROM_OL,\n" + "ADJ_LINE_TYPE, \n " + "EMPL_RCD,\n" + "SEQ_NBR,\n" +
     "VOUCHER_LINE_NUM,\n" + "PYMNT_CNT,\n" + "REQ_LINE_NBR,\n" + "REQ_SCHED_NBR,\n" + "REQ_DISTRIB_NBR,\n" +
     "LINE_NBR,\n" + "SCHED_NBR,\n" + "DISTRIB_LINE_NUM,\n" + "MSTONE_SEQ,\n" + "CONTRACT_PPD_SEQ,\n" + "ITEM_LINE,\n" +
     "ITEM_SEQ_NUM,\n" + "DST_SEQ_NUM,\n" + "SCHED_LINE_NO,\n" + "DEMAND_LINE_NO,\n" + "ORDER_INT_LINE_NO,\n" +
     "VCHR_DIST_LINE_NUM,\n" + "EVENT_NUM,\n" + "WO_TASK_ID,\n" + "RES_LN_NBR,\n" + "COMPRESS_ID,\n" +
     "SEQ_TRANS_ID,\n" + "DIST_TRANS_ID,\n" + "FEEDER_SUM_ID,\n" + "PRICE_SUM_ID\n" + //128
     " )" +
     "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
     "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
     "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," + "?,?,?" +
     ")";

                PreparedStatement pstmt = configdb.prepareStatement(insertSql);
                pstmt.setString(1, "NEU01");
                pstmt.setString(2, project_id);
                pstmt.setString(3, activity_id);
                pstmt.setInt(4, last_resource_id);
                pstmt.setInt(5, last_resource_id);
                pstmt.setString(6, "TIC01");
                pstmt.setString(7, "TIC01");
                pstmt.setString(8, "USD");
                pstmt.setString(9, "BIL");
                pstmt.setString(10, trans_attr3);
                pstmt.setString(11, trans_attr4);
                pstmt.setDate(12, monthlastDt);
                pstmt.setDate(13, monthlastDt);
                pstmt.setString(14, userid);
                pstmt.setDate(15, sqltodayDate);
                pstmt.setString(16, "USD");
                pstmt.setString(17, "CRRNT");
                pstmt.setDouble(18, billingAmount);
                pstmt.setInt(19, 1);
                pstmt.setInt(20, 1);
                pstmt.setDate(21, sqltodayDate);
                pstmt.setInt(22, processId);
                pstmt.setString(23, "N");
                pstmt.setString(24, "C");
                pstmt.setString(25, "A");
                pstmt.setString(26, prod_desc);
                pstmt.setString(27, "XPE");
                pstmt.setString(28, prod_uom);
                pstmt.setString(29, "NEU01");
                pstmt.setString(30, contract_no);
                pstmt.setInt(31, cntr_line_no);
                pstmt.setString(32, "P");
                pstmt.setString(33, "N");
                pstmt.setString(34, tgt_cust_id1);
                pstmt.setDouble(35, trans_agg_qty1);
                pstmt.setDouble(36, billingAmount);
                pstmt.setString(37, "N");
                pstmt.setDate(38, monthlastDt);
                pstmt.setString(39, "N");
                pstmt.setString(40, "N");
                pstmt.setString(41, "Y");
                pstmt.setDouble(42, ratederived);
                pstmt.setString(43, "N");
                pstmt.setString(44, "N");
                pstmt.setString(45, " ");
                pstmt.setInt(46, 0);
                pstmt.setInt(47, 0);
                pstmt.setInt(48, 0);
                pstmt.setInt(49, 0);
                pstmt.setDate(50, monthlastDt);
                pstmt.setString(51, " ");
                pstmt.setString(52, " ");
                pstmt.setString(53, " ");
                pstmt.setString(54, " ");
                pstmt.setString(55, " ");
                pstmt.setString(56, " ");
                pstmt.setString(57, " ");
                pstmt.setString(58, " ");
                pstmt.setString(59, " ");
                pstmt.setString(60, " ");
                pstmt.setString(61, " ");
                pstmt.setString(62, " ");
                pstmt.setString(63, " ");
                pstmt.setString(64, " ");
                pstmt.setString(65, " ");
                pstmt.setString(66, " ");
                pstmt.setString(67, " ");
                pstmt.setString(68, " ");
                pstmt.setString(69, " ");
                pstmt.setString(70, " ");
                pstmt.setString(71, " ");
                pstmt.setString(72, " ");
                pstmt.setString(73, " ");
                pstmt.setString(74, " ");
                pstmt.setString(75, " ");
                pstmt.setString(76, " ");
                pstmt.setString(77, " ");
                pstmt.setString(78, " ");
                pstmt.setString(79, " ");
                pstmt.setString(80, " ");
                pstmt.setString(81, " ");
                pstmt.setString(82, " ");
                pstmt.setString(83, " ");
                pstmt.setString(84, " ");
                pstmt.setString(85, " ");
                pstmt.setString(86, " ");
                pstmt.setString(87, " ");
                pstmt.setString(88, " ");
                pstmt.setString(89, " ");
                pstmt.setString(90, " ");
                pstmt.setString(91, " ");
                pstmt.setString(92, " ");
                pstmt.setString(93, " ");
                pstmt.setString(94, " ");
                pstmt.setString(95, " ");
                pstmt.setString(96, " ");
                pstmt.setString(97, " ");
                pstmt.setString(98, " ");
                pstmt.setString(99, " ");
                pstmt.setString(100, " ");
                pstmt.setString(101, " ");
                pstmt.setString(102, " ");
                pstmt.setString(103, " ");
                pstmt.setString(104, " ");
                pstmt.setString(105, " ");
                pstmt.setString(106, " ");
                pstmt.setString(107, " ");
                pstmt.setString(108, " ");
                pstmt.setString(109, " ");
                pstmt.setString(110, " ");
                pstmt.setString(111, " ");
                pstmt.setString(112, " ");
                pstmt.setString(113, " ");
                pstmt.setString(114, " ");
                pstmt.setString(115, " ");
                pstmt.setString(116, " ");
                pstmt.setString(117, " ");
                pstmt.setString(118, " ");
                pstmt.setString(119, " ");
                pstmt.setString(120, " ");
                pstmt.setString(121, " ");
                pstmt.setString(122, " ");
                pstmt.setString(123, " ");
                pstmt.setString(124, " ");
                pstmt.setString(125, " ");
                pstmt.setString(126, " ");
                pstmt.setInt(127, 0);
                pstmt.setInt(128, 0);
                pstmt.setInt(129, 0);
                pstmt.setInt(130, 0);
                pstmt.setInt(131, 0);
                pstmt.setInt(132, 0);
                pstmt.setInt(133, 0);
                pstmt.setInt(134, 0);
                pstmt.setInt(135, 0);
                pstmt.setInt(136, 0);
                pstmt.setInt(137, 0);
                pstmt.setInt(138, 0);
                pstmt.setInt(139, 0);
                pstmt.setInt(140, 0);
                pstmt.setInt(141, 0);
                pstmt.setInt(142, 0);
                pstmt.setInt(143, 0);
                pstmt.setInt(144, 0);
                pstmt.setInt(145, 0);
                pstmt.setInt(146, 0);
                pstmt.setInt(147, 0);
                pstmt.setInt(148, 0);
                pstmt.setInt(149, 0);
                pstmt.setInt(150, 0);
                pstmt.setInt(151, 0);
                pstmt.setInt(152, 0);
                pstmt.setInt(153, 0);


                result = pstmt.executeUpdate(); // execute insert statement
                //            System.out.println("Rows committed " + result);
                pstmt.close();

                if (result > 0) { //proje resource inserted

                    if (recordCounter == 0) {
                        minResourceId = last_resource_id;
                        maxResourceId = last_resource_id;
                    } else {
                        maxResourceId = last_resource_id;
                    }

                    String readSQL2_usg =
                        "SELECT  KEY1, PRODUCT_ID, CIS_TARGET_CUSTID1, CIS_TARGTCUST1DET1, PROJECT_ID, ACTIVITY_ID, ATTR_VALUE3, ATTR_VALUE4, \n" +
                        "    BUSINESS_UNIT_PC, RESOURCE_ID, sum(CIS_TRANS_AGG_QTY1) as CIS_TRANS_AGG_QTY1, sum(round(CIS_TRANS_BI_AMT1,2)) as CIS_TRANS_BI_AMT1, last_day(max(key_date_01)) as month_last_dt" +
                        " from PS_CIS_XPE_IMP_CONTR_VW b \n" +
                        "where cis_stage in ('1-IMPORT', '2_SWT_CNAM_INT_AGG','2_SWT_LIDB_INT_AGG','2_SWT_CNAM_EXT_AGG','2_SWT_GETDATA_EXT_AGG','2_SWT_LIDB_EXT_AGG','2_SWT_OLNS_EXT_AGG','3-AGG-SHORT')" +
                        " and cis_Status = 'P' " + "and CIS_TARGET_CUSTID1 = " + "'" + tgt_cust_id1 + "'" +
                        "and project_id = " + "'" + project_id + "'" + " and ACTIVITY_ID = " + "'" + activity_id + "'" +
                        " and project_id is not null and activity_id is not null " +
                        " GROUP BY KEY1, PRODUCT_ID, CIS_TARGET_CUSTID1, CIS_TARGTCUST1DET1, PROJECT_ID, ACTIVITY_ID, ATTR_VALUE3, ATTR_VALUE4, BUSINESS_UNIT_PC, RESOURCE_ID ";

                    //                 System.out.println("readSQL2 " + readSQL2_usg);

                    Statement sqlStatement_usg = configdb.createStatement();

                    ResultSet myResultSet_usg = sqlStatement_usg.executeQuery(readSQL2_usg);

                    boolean hasNext_usg = myResultSet_usg.next();
                    recordCounter1 = 0;

                    while (hasNext_usg) { //usage report


                        productId = myResultSet_usg.getString("PRODUCT_ID");
                        tgt_cust_id1 = myResultSet_usg.getString("CIS_TARGET_CUSTID1");
                        tgt_cust1_detail1 = myResultSet_usg.getString("CIS_TARGTCUST1DET1");
                        project_id = myResultSet_usg.getString("PROJECT_ID");
                        activity_id = myResultSet_usg.getString("ACTIVITY_ID");
                        trans_attr3 = myResultSet_usg.getString("ATTR_VALUE3");
                        trans_attr4 = myResultSet_usg.getString("ATTR_VALUE4");
                        pc_bu = myResultSet_usg.getString("BUSINESS_UNIT_PC");
                        resource_id = myResultSet_usg.getString("RESOURCE_ID");
                        monthlastDt = myResultSet_usg.getDate("month_last_dt");
                        key1 = myResultSet_usg.getString("KEY1");

                        usageCount = myResultSet_usg.getInt("CIS_TRANS_AGG_QTY1");
                        billingAmount = myResultSet_usg.getDouble("CIS_TRANS_BI_AMT1");

                        if (trans_attr3.equals("SWTR")) {
                            opc = " ";
                        } else {
                            opc = key1;
                        }


                        if (usageCount != 0) {
                            billingRate = billingAmount / usageCount;
                        } else {
                            billingRate = 0;
                        }
                        //  System.out.println("1c=====================> " );

                        switch (trans_attr3) {
                        case "CNAM":
                            resType = "Call Name Delivery";
                            break;
                        case "LIDB":
                            resType = "LIDB Delivery";
                            break;
                        default:
                            break;
                        } //switch


                        //========================== PS_CIS_XPE_USG_RPT===============
                        String insertSql_usage = "insert into PS_CIS_XPE_USG_RPT ( " + //PROD #3 of 3
                            "PROCESSID,\n" + //1
                            "CIS_PRCS_REQST_ID,\n" + //2
                            "CUST_ID,\n" + //3
                            "CUST_NAME,\n" + //4
                            "TRANS_DATE,\n" + //5
                            "SERVICENAME,\n" + //6
                            "PRODUCT_ID,\n" + //7
                            "CIS_OPC,\n" + //8
                            "USAGE_QTY,\n" + //9
                            "RATE,\n" + //10
                            "AMOUNT,\n" + //11
                            "BUSINESS_UNIT_PC,\n" + //12
                            "PROJECT_ID,\n" + //13
                            "ACTIVITY_ID,\n" + //14
                            "RESOURCE_ID\n" + //15
                            " )" + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                        PreparedStatement pstmt_usg = configdb.prepareStatement(insertSql_usage);
                        pstmt_usg.setInt(1, processId);
                        pstmt_usg.setInt(2, processRequestId);
                        pstmt_usg.setString(3, tgt_cust_id1);
                        pstmt_usg.setString(4, tgt_cust1_detail1);
                        pstmt_usg.setDate(5, monthlastDt);
                        pstmt_usg.setString(6, resType);
                        pstmt_usg.setString(7, productId);
                        pstmt_usg.setString(8, opc);
                        pstmt_usg.setInt(9, usageCount);
                        pstmt_usg.setDouble(10, billingRate);
                        pstmt_usg.setDouble(11, billingAmount);
                        pstmt_usg.setString(12, pc_bu);
                        pstmt_usg.setString(13, project_id);
                        pstmt_usg.setString(14, activity_id);
                        pstmt_usg.setInt(15, last_resource_id);

                        pstmt_usg.executeUpdate(); // execute insert statement

                        pstmt_usg.close();


                        hasNext_usg = myResultSet_usg.next();
                        recordCounter1++;

                    } //while   usage report
                    myResultSet_usg.close();
                    //               System.out.println("Rows committed PS_CIS_XPE_USG_RPT  " + recordCounter1);

                } //if inserted in proj


                //proj resource next result
                hasNext = myResultSet.next();
                recordCounter++;


            } //while   main proj resource


            myResultSet.close();
            System.out.println("Rows committed PS_CIS_XPE_PROJ_RESOURCE " + recordCounter);


            System.out.println("minResourceId " + minResourceId);
            System.out.println("maxResourceId " + maxResourceId);

            String read_del_temp = " delete from ps_cis_xpe_projx_temp ";
            Statement sql_del_temp = configdb.createStatement();
            result = sql_del_temp.executeUpdate(read_del_temp);

            sql_del_temp.close();

            String build_temp =
                " insert into ps_cis_xpe_projx_temp  \n" +
                "SELECT  distinct SOLD_TO_CUST_ID,  c.project_id, c.ACTIVITY_ID, c.resource_id, b.PC_TRANS_ID\n" +
                "		from PS_CIS_XPE_CONTR b, PS_CIS_XPE_USG_RPT c\n" +
                "		where b.SOLD_TO_CUST_ID = c.cust_id and b.project_id = c.project_id and b.ACTIVITY_ID = c.ACTIVITY_ID and last_day(b.key_date_01) = c.TRANS_DATE\n" +
                "		and c.resource_id  >= ? and c.resource_id  <= ?  and c.project_id is not null and c.activity_id is not null";

            System.out.println("build_temp " + build_temp);

            PreparedStatement pstmt_build_temp = configdb.prepareStatement(build_temp);
            pstmt_build_temp.setInt(1, minResourceId);
            pstmt_build_temp.setInt(2, maxResourceId);


            result = pstmt_build_temp.executeUpdate(); // execute insert statement
            System.out.println("Rows built in temp " + result);

            pstmt_build_temp.close();


            String updProjX =
                "MERGE INTO PS_CIS_XPE_IMPORT a\n" + "  USING \n" + "  (\n" +
                "        SELECT  distinct SOLD_TO_CUST_ID,  project_id, aCTIVITY_ID, resource_id, PC_TRANS_ID\n" +
                "		   from ps_cis_xpe_projx_temp\n" + "  ) b\n" +
                "  ON  ( a.CIS_TARGET_CUSTID1 = b.sold_to_cust_id and b.pc_trans_id  = a.attr_Value5	 )\n" +
                "  WHEN MATCHED THEN\n" +
                "        UPDATE SET a.cis_Status = 'X', a.project_id = b.project_id , a.ACTIVITY_ID = b.ACTIVITY_ID , a.resource_id = b.resource_id \n" +
                "        WHERE a.cis_status = 'P'";

            System.out.println("Query ProjX " + updProjX);

            PreparedStatement pstmt_updProjX = configdb.prepareStatement(updProjX);

            result = pstmt_updProjX.executeUpdate(); // execute insert statement

            pstmt_updProjX.close();

            System.out.println("Rows committed to ProjX " + result);

        } //try
        catch (Exception e) {
            errorMsg = errorMsg + " : " + e;
            System.out.println("errorMsg : " + errorMsg);
            logger(projShare, errorMsg);
            return (-1);
        } //catch
        return (0);
    }

    public double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }

    public void prepareVoucher(ProjectVariable projShare) {


        String module = "prepareVoucher";

        String execPlanCode = projShare.getextPlanCode();
        String execStep = projShare.getexecStep();
        int execSeq = projShare.getexecSeq();
        String stage = projShare.getstage();
        int last_resource_id = 0;

        String tgt_vendor_id = "";
        String last_tgt_vendor_id = "";
        double trans_agg_amt4 = 0;
        double merchandise_amt = 0;
        String chartfield1 = " ";
        String chartfield2 = " ";
        String chartfield3 = " ";
        String deptId = "";
        String transAttr3 = "";
        String transAttr4 = "";
        String project_id = "";
        String activity_id = "";
        String tgtCustId2 = "";
        String ocn = "";
        int usage_qty = 0;
        double rate = 0;
        double rate_round2 = 0;
        double amt = 0;
        String tgtCustId1 = "";
        String tgtCust2Detail1 = "";
        String tgtCust1Detail1 = "";
        int trans_agg_qty1 = 0;
        int trans_agg_qty2 = 0;
        double trans_bi_amt1 = 0;
        java.sql.Date monthlastDt;
        DecimalFormat f = new DecimalFormat("##.00");
        int headerRowCommitted = 0;

        boolean hasNext2;

        ResultSet myResultSet2;

        String stringDate;

        int processId = projShare.getprocessId();
        String userid = " ";

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");

        Date todayDate = new Date();
        stringDate = dateFormat1.format(todayDate);
        java.sql.Date sqltodayDate = java.sql.Date.valueOf(stringDate);


        Connection configdb = projShare.getconfigDb();

        String key_c1_seq = "";
        String minVoucher = "";
        String maxVoucher = "";
        int result;

        String mainSQL =
            "SELECT  distinct CIS_TARGET_VENDOR1\n" + "from PS_CIS_XPE_IMP_CONTR_VW b \n" +
            "where cis_stage in ( '3_CNAM_RV_AGG','3_LIDB_RV_AGG') AND CIS_TARGET_VENDOR1 IS NOT NULL  and cis_status = 'P' \n" + //
            "order by CIS_TARGET_VENDOR1";

        System.out.println("mainSQL " + mainSQL);

        try {
            Statement sqlStatement_main = configdb.createStatement();
            Statement sqlStatement_seq = configdb.createStatement();
            Statement sqlStatement_apstgrp = configdb.createStatement();

            ResultSet myResultSet_main = sqlStatement_main.executeQuery(mainSQL);

            boolean hasNext1 = myResultSet_main.next();
            int recordCounter = 0;
            int recordCounter1 = 0;

            while (hasNext1) { // MAIN While
                tgt_vendor_id = myResultSet_main.getString("CIS_TARGET_VENDOR1");
                //                  System.out.println("tgt_vendor_id " + tgt_vendor_id );


                String readhdrSQL =
                    "SELECT  distinct CIS_TARGET_VENDOR1,  sum(round(CIS_TRANS_AGG_AMT4,2)) as CIS_TRANS_AGG_AMT4 , last_day(max(key_date_01)) as month_last_dt\n" +
                    "from PS_CIS_XPE_IMP_CONTR_VW b \n" +
                    "where cis_stage in ( '3_CNAM_RV_AGG','3_LIDB_RV_AGG') AND CIS_TARGET_VENDOR1 IS NOT NULL  and cis_status = 'P' \n" + //
                    "and CIS_TARGET_VENDOR1 = " + "'" + tgt_vendor_id + "'" + " GROUP BY CIS_TARGET_VENDOR1 \n" +
                    "having sum(round(CIS_TRANS_AGG_AMT4,2) ) > 0\n" + "order by CIS_TARGET_VENDOR1";

                //            System.out.println("readhdrSQL " + readhdrSQL );

                Statement sqlStatement_hdr = configdb.createStatement();
                ResultSet myResultSet_hdr = sqlStatement_hdr.executeQuery(readhdrSQL);
                boolean hasNext3 = myResultSet_hdr.next();

                int printsqlflag = 0;

                while (hasNext3) { //while header

                    //              System.out.println("1a=====================> " );

                    trans_agg_amt4 = myResultSet_hdr.getDouble("CIS_TRANS_AGG_AMT4");
                    monthlastDt = myResultSet_hdr.getDate("month_last_dt");

                    //              System.out.println("trans_agg_amt4 " + trans_agg_amt4 );
                    //              System.out.println("monthlastDt " + monthlastDt );

                    //get next seq
                    ResultSet rs =
                        sqlStatement_seq.executeQuery("SELECT 'NET' || LPAD(PS_CIS_XPE_VCHR_KEY_C1_SEQ.nextval,5,'0') as seq FROM dual");

                    if (rs != null && rs.next()) {
                        key_c1_seq = rs.getString(1);
                        //          System.out.println("Writing key_c1_seq  => " + key_c1_seq);
                        rs.close();
                    }
                    rs.close();

                    //insert into voucher header table
                    String insertSql_vchr_hrd =
                        "insert into PS_VCHR_HDR_STG ( " + //PROD #1 OF 5
                        "BUSINESS_UNIT,\n" + //1
                        "VCHR_BLD_KEY_C1,\n" + //2
                        "VCHR_BLD_KEY_C2,\n" + //3
                        "VCHR_BLD_KEY_N1,\n" + //4
                        "VCHR_BLD_KEY_N2,\n" + //5
                        "VOUCHER_ID,\n" + //6
                        "INVOICE_ID,\n" + //7
                        "INVOICE_DT,\n" + //8
                        "VENDOR_SETID,\n" + //9
                        "VENDOR_ID,\n" + //10
                        "VNDR_LOC,\n" + //11
                        "ADDRESS_SEQ_NUM,\n" + //12
                        "ORIGIN,\n" + //13
                        "OPRID,\n" + //14
                        "ACCOUNTING_DT,\n" + //15
                        "GROSS_AMT,\n" + //16
                        "DSCNT_AMT,\n" + //17
                        "SALETX_AMT,\n" + //18
                        "FREIGHT_AMT,\n" + //19
                        "MISC_AMT,\n" + //20
                        "RATE_MULT,\n" + //21
                        "RATE_DIV,\n" + //22
                        "VAT_ENTRD_AMT,\n" + //23
                        "ECQUEUEINSTANCE,\n" + //24
                        "REMIT_ADDR_SEQ_NUM,\n" + //25
                        "ITEM_LINE,\n" + //26
                        "ERS_INV_SEQ,\n" + //27
                        "LS_KEY,\n" + //28
                        "VCHR_SRC,\n" + //29
                        "USER_VCHR_DEC,\n" + //30
                        "USER_VCHR_NUM1,\n" + //31
                        "VOUCHER_STYLE,\n" + //32
                        "GRP_AP_ID,\n" + //33
                        "POST_VOUCHER,\n" + //33
                        "DST_CNTRL_ID,\n" + //33
                        "VOUCHER_ID_RELATED,\n" + //33
                        "TAX_EXEMPT,\n " + "EIN_FEDERAL,\n" + "DOC_TYPE,\n" + "STATE_SHIP_FROM,\n" +
"STATE_SHIP_TO,\n" + "STATE_LOC_SELLER,\n" + "STATE_LOC_BUYER,\n" + "STATE_VAT_SUPPLY,\n" + "STATE_VAT_PERFRM,\n" +
"STATE_VAT_DEFAULT,\n" + "VCHR_BLD_CODE,\n" + "PYMNT_TERMS_CD,\n" + "RT_TYPE,\n" + "BUSINESS_UNIT_PO,\n" +
"TAX_PYMNT_TYPE,\n" + "BUSINESS_UNIT_AR,\n" + "BUSINESS_UNIT_AM,\n" + "ENDORSER_PARTY,\n" + "VAT_TREATMENT_GRP,\n" +
"TAX_GRP,\n" + "BUSPROCNAME,\n" + "APPR_RULE_SET,\n" + "BILL_OF_LADING,\n" + "ITEM,\n" + "LEASE_ID,\n" + "CLAIM_NO,\n" +
"POLICY_NUM,\n" + "TXN_CURRENCY_CD,\n" + "COUNTRY_SHIP_FROM,\n" + "COUNTRY_SHIP_TO,\n" + "COUNTRY_VAT_BILLFR,\n" +
"COUNTRY_VAT_BILLTO,\n" + "COUNTRY_LOC_SELLER,\n" + "COUNTRY_LOC_BUYER,\n" + "COUNTRY_VAT_SUPPLY,\n" +
"COUNTRY_VAT_PERFRM,\n" + "PAY_SCHEDULE_TYPE,\n" + "DESCR254_MIXED,\n" + "PACKSLIP_NO,\n" + "VAT_EXCPTN_CERTIF,\n" +
"EIN_STATE_LOCAL,\n" + "ECTRANSID,\n" + "CUST_ID,\n" + "IMAGE_REF_ID,\n" + "LC_ID,\n" + "ASSET_ID,\n" +
"PREPAID_REF,\n" + "PO_ID,\n" + "CARRIER_ID,\n" + "FRGHT_CHARGE_CODE,\n" + "MISC_CHARGE_CODE,\n" +
"SALETX_CHARGE_CODE,\n" + "MATCH_ACTION,\n" + "CUR_RT_SOURCE,\n" + "DSCNT_AMT_FLG,\n" + "DUE_DT_FLG,\n" +
"VCHR_APPRVL_FLG,\n" + "VAT_DCLRTN_POINT,\n" + "VAT_CALC_TYPE,\n" + "VAT_CALC_GROSS_NET,\n" + "VAT_RECALC_FLG,\n" +
"VAT_CALC_FRGHT_FLG,\n" + "VAT_ROUND_RULE,\n" + "PREPAID_AUTO_APPLY,\n" + "IN_PROCESS_FLG,\n" +
"PAY_TRM_BSE_DT_OPT,\n" + "VAT_CALC_MISC_FLG,\n" + "DSCNT_PRORATE_FLG,\n" + "VAT_EXCPTN_TYPE,\n" +
"USER_VCHR_CHAR1,\n" + "USER_VCHR_CHAR2,\n" + "USER_HDR_CHAR1, \n" + "PROCESS_INSTANCE \n" + " )" +
"values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                    PreparedStatement pstmt_vchr_hdr = configdb.prepareStatement(insertSql_vchr_hrd);
                    pstmt_vchr_hdr.setString(1, "TIC01"); //1
                    pstmt_vchr_hdr.setString(2, key_c1_seq); //2
                    pstmt_vchr_hdr.setString(3, " "); //3
                    pstmt_vchr_hdr.setInt(4, 0);
                    pstmt_vchr_hdr.setInt(5, 0);
                    pstmt_vchr_hdr.setString(6, key_c1_seq);
                    pstmt_vchr_hdr.setString(7, key_c1_seq);
                    pstmt_vchr_hdr.setDate(8, monthlastDt);
                    pstmt_vchr_hdr.setString(9, "CIS00");
                    pstmt_vchr_hdr.setString(10, tgt_vendor_id);
                    pstmt_vchr_hdr.setString(11, "MAIN");
                    pstmt_vchr_hdr.setInt(12, 1);
                    pstmt_vchr_hdr.setString(13, "CNM");
                    pstmt_vchr_hdr.setString(14, userid);
                    pstmt_vchr_hdr.setDate(15, monthlastDt);
                    pstmt_vchr_hdr.setDouble(16, trans_agg_amt4);
                    pstmt_vchr_hdr.setInt(17, 0);
                    pstmt_vchr_hdr.setInt(18, 0);
                    pstmt_vchr_hdr.setInt(19, 0);
                    pstmt_vchr_hdr.setInt(20, 0);
                    pstmt_vchr_hdr.setInt(21, 0);
                    pstmt_vchr_hdr.setInt(22, 0);
                    pstmt_vchr_hdr.setInt(23, 0);
                    pstmt_vchr_hdr.setInt(24, 0);
                    pstmt_vchr_hdr.setInt(25, 0);
                    pstmt_vchr_hdr.setInt(26, 0);
                    pstmt_vchr_hdr.setInt(27, 0);
                    pstmt_vchr_hdr.setInt(28, 0);
                    pstmt_vchr_hdr.setString(29, "XML");
                    pstmt_vchr_hdr.setInt(30, 0);
                    pstmt_vchr_hdr.setInt(31, 0);
                    pstmt_vchr_hdr.setString(32, " "); //
                    pstmt_vchr_hdr.setString(33, " "); //
                    pstmt_vchr_hdr.setString(34, " "); //
                    pstmt_vchr_hdr.setString(35, " "); //
                    pstmt_vchr_hdr.setString(36, " "); //
                    pstmt_vchr_hdr.setString(37, " "); //
                    pstmt_vchr_hdr.setString(38, " "); //
                    pstmt_vchr_hdr.setString(39, " "); //
                    pstmt_vchr_hdr.setString(40, " "); //
                    pstmt_vchr_hdr.setString(41, " "); //
                    pstmt_vchr_hdr.setString(42, " "); //
                    pstmt_vchr_hdr.setString(43, " "); //
                    pstmt_vchr_hdr.setString(44, " "); //
                    pstmt_vchr_hdr.setString(45, " ");
                    pstmt_vchr_hdr.setString(46, " "); //;
                    pstmt_vchr_hdr.setString(47, " "); //
                    pstmt_vchr_hdr.setString(48, " "); //
                    pstmt_vchr_hdr.setString(49, " "); //
                    pstmt_vchr_hdr.setString(50, " "); //
                    pstmt_vchr_hdr.setString(51, " ");
                    pstmt_vchr_hdr.setString(52, " ");
                    pstmt_vchr_hdr.setString(53, " ");
                    pstmt_vchr_hdr.setString(54, " ");
                    pstmt_vchr_hdr.setString(55, " ");
                    pstmt_vchr_hdr.setString(56, " ");
                    pstmt_vchr_hdr.setString(57, " ");
                    pstmt_vchr_hdr.setString(58, " ");
                    pstmt_vchr_hdr.setString(59, " ");
                    pstmt_vchr_hdr.setString(60, " ");
                    pstmt_vchr_hdr.setString(61, " ");
                    pstmt_vchr_hdr.setString(62, " ");
                    pstmt_vchr_hdr.setString(63, " ");
                    pstmt_vchr_hdr.setString(64, " ");
                    pstmt_vchr_hdr.setString(65, " ");
                    pstmt_vchr_hdr.setString(66, " ");
                    pstmt_vchr_hdr.setString(67, " ");
                    pstmt_vchr_hdr.setString(68, " ");
                    pstmt_vchr_hdr.setString(69, " ");
                    pstmt_vchr_hdr.setString(70, " ");
                    pstmt_vchr_hdr.setString(71, " ");
                    pstmt_vchr_hdr.setString(72, " ");
                    pstmt_vchr_hdr.setString(73, " ");
                    pstmt_vchr_hdr.setString(74, " ");
                    pstmt_vchr_hdr.setString(75, " ");
                    pstmt_vchr_hdr.setString(76, " ");
                    pstmt_vchr_hdr.setString(77, " ");
                    pstmt_vchr_hdr.setString(78, " ");
                    pstmt_vchr_hdr.setString(79, " ");
                    pstmt_vchr_hdr.setString(80, " ");
                    pstmt_vchr_hdr.setString(81, " ");
                    pstmt_vchr_hdr.setString(82, " ");
                    pstmt_vchr_hdr.setString(83, " ");
                    pstmt_vchr_hdr.setString(84, " ");
                    pstmt_vchr_hdr.setString(85, " ");
                    pstmt_vchr_hdr.setString(86, " ");
                    pstmt_vchr_hdr.setString(87, " ");
                    pstmt_vchr_hdr.setString(88, " ");
                    pstmt_vchr_hdr.setString(89, " ");
                    pstmt_vchr_hdr.setString(90, " ");
                    pstmt_vchr_hdr.setString(91, " ");
                    pstmt_vchr_hdr.setString(92, " ");
                    pstmt_vchr_hdr.setString(93, " ");
                    pstmt_vchr_hdr.setString(94, " ");
                    pstmt_vchr_hdr.setString(95, " ");
                    pstmt_vchr_hdr.setString(96, " ");
                    pstmt_vchr_hdr.setString(97, " ");
                    pstmt_vchr_hdr.setString(98, " ");
                    pstmt_vchr_hdr.setString(99, " ");
                    pstmt_vchr_hdr.setString(100, " ");
                    pstmt_vchr_hdr.setString(101, " ");
                    pstmt_vchr_hdr.setString(102, " ");
                    pstmt_vchr_hdr.setString(103, " ");
                    pstmt_vchr_hdr.setString(104, " ");
                    pstmt_vchr_hdr.setString(105, " ");
                    pstmt_vchr_hdr.setString(106, " ");
                    pstmt_vchr_hdr.setString(107, " ");
                    pstmt_vchr_hdr.setString(108, " ");
                    pstmt_vchr_hdr.setInt(109, 0);

                    headerRowCommitted = pstmt_vchr_hdr.executeUpdate(); // execute insert statement
                    pstmt_vchr_hdr.close();

                    recordCounter = recordCounter + 1;
                    hasNext3 = myResultSet_hdr.next();
                }
                ; //WHILE header
                //     System.out.println("Rows to header " + headerRowCommitted);

                myResultSet_hdr.close();
                myResultSet_hdr.close();

                if (headerRowCommitted > 0) {

                    if (recordCounter == 1) {
                        minVoucher = key_c1_seq;
                        maxVoucher = key_c1_seq;
                    } else {
                        maxVoucher = key_c1_seq;
                    }
                    String readlineStgSQL =
                        "SELECT  distinct CIS_TARGET_VENDOR1, PROJECT_ID, ACTIVITY_ID, ATTR_VALUE3, ATTR_VALUE4,  sum(round(CIS_TRANS_AGG_AMT4,2)) as CIS_TRANS_AGG_AMT4, " +
                        "CHARTFIELD1, CHARTFIELD2, CHARTFIELD3 \n" + "from PS_CIS_XPE_IMP_CONTR_VW b \n" +
                        "where cis_stage in ( '3_CNAM_RV_AGG','3_LIDB_RV_AGG') AND CIS_TARGET_VENDOR1 IS NOT NULL  and cis_status = 'P'  \n" + //
                        "and CIS_TARGET_VENDOR1 = " + "'" + tgt_vendor_id + "'" +
                        "GROUP BY CIS_TARGET_VENDOR1, PROJECT_ID, ACTIVITY_ID, ATTR_VALUE3, ATTR_VALUE4 , CHARTFIELD1, CHARTFIELD2, CHARTFIELD3\n" +
                        "having sum( round(CIS_TRANS_AGG_AMT4,2)) > 0\n" +
                        "order by CIS_TARGET_VENDOR1, PROJECT_ID, ACTIVITY_ID";


                    Statement sqlStatement_line = configdb.createStatement();
                    ResultSet myResultSet_line = sqlStatement_line.executeQuery(readlineStgSQL);
                    boolean hasNext4 = myResultSet_line.next();
                    int voucherLine = 1;
                    //               System.out.println("2a=====================> " );


                    while (hasNext4) { //while voucher lines

                        //           System.out.println("2b=====================> " );

                        if (printsqlflag == 0) {
                            //                                System.out.println("readlineStgSQL " + readlineStgSQL );
                            printsqlflag = -1;
                        }

                        activity_id = myResultSet_line.getString("ACTIVITY_ID");
                        transAttr3 = myResultSet_line.getString("ATTR_VALUE3");
                        transAttr4 = myResultSet_line.getString("ATTR_VALUE4");
                        project_id = myResultSet_line.getString("PROJECT_ID");
                        trans_agg_amt4 = myResultSet_line.getDouble("CIS_TRANS_AGG_AMT4");
                        chartfield1 = myResultSet_line.getString("CHARTFIELD1");
                        chartfield2 = myResultSet_line.getString("CHARTFIELD2");
                        chartfield3 = myResultSet_line.getString("CHARTFIELD3");


                        //insert into voucher line table
                        String insertSql_line_stg =
                            "insert into PS_VCHR_LINE_STG ( " + //PROD #2 OF 5
                            "BUSINESS_UNIT,\n" + //1
                            "VCHR_BLD_KEY_C1,\n" + //2
                            "VCHR_BLD_KEY_C2,\n" + //3
                            "VCHR_BLD_KEY_N1,\n" + //4
                            "VCHR_BLD_KEY_N2,\n" + //5
                            "VOUCHER_ID,\n" + //6
                            "VOUCHER_LINE_NUM,\n" + //7
                            "LINE_NBR,\n" + //8
                            "SCHED_NBR,\n" + //9
                            "DESCR,\n" + //10
                            "MERCHANDISE_AMT,\n" + //11
                            "QTY_VCHR,\n" + //12
                            "STATISTIC_AMOUNT,\n" + //13
                            "UNIT_PRICE,\n" + //14
                            "RECV_LN_NBR,\n" + //15
                            "RECV_SHIP_SEQ_NBR,\n" + //16
                            "ADDR_SEQ_NUM_SHIP,\n" + //17
                            "ECQUEUEINSTANCE,\n" + //18
                            "VAT_ENTRD_AMT,\n" + //19
                            "USER_VCHR_DEC,\n" + //20
                            "USER_VCHR_NUM1,\n " + //21
                            "BUSINESS_UNIT_PO,\n" + //22
                            "PO_ID,\n" + //23
                            "ITM_SETID,\n" + //24
                            "INV_ITEM_ID,\n" + //25
                            "UNIT_OF_MEASURE,\n" + //26
                            "DSCNT_APPL_FLG,\n" + //27
                            "TAX_CD_VAT,\n" + //28
                            "BUSINESS_UNIT_RECV,\n" + //29
                            "RECEIVER_ID,\n" + //30
                            "MATCH_LINE_OPT,\n" + //31
                            "DISTRIB_MTHD_FLG,\n" + //32
                            "SHIPTO_ID,\n" + //33
                            "SUT_BASE_ID,\n" + //34
                            "TAX_CD_SUT,\n" + //35
                            "ULTIMATE_USE_CD,\n" + //36
                            "SUT_EXCPTN_TYPE,\n" + //37
                            "SUT_EXCPTN_CERTIF,\n" + //38
                            "SUT_APPLICABILITY,\n" + //39
                            "VAT_APPLICABILITY,\n" + //40
                            "VAT_TXN_TYPE_CD,\n" + //41
                            "VAT_USE_ID,\n" + //42
                            "BUS_UNIT_RELATED,\n" + //43
                            "VOUCHER_ID_RELATED,\n" + //44
                            "VENDOR_ID,\n" + //45
                            "VNDR_LOC,\n" + "DESCR254_MIXED,\n" + "SPEEDCHART_KEY,\n" + "BUSINESS_UNIT_GL,\n" +
    "ACCOUNT,\n" + "ALTACCT,\n" + "OPERATING_UNIT,\n" + "PRODUCT,\n " + "FUND_CODE,\n" + "CLASS_FLD,\n" +
    "PROGRAM_CODE,\n" + "BUDGET_REF,\n" + "AFFILIATE,\n" + "AFFILIATE_INTRA1,\n" + "AFFILIATE_INTRA2,\n" +
    "CHARTFIELD1,\n" + "CHARTFIELD2,\n" + "CHARTFIELD3,\n" + "DEPTID,\n" + "PROJECT_ID,\n" + "BUSINESS_UNIT_PC,\n" +
    "ACTIVITY_ID,\n" + "ANALYSIS_TYPE,\n" + "RESOURCE_TYPE,\n" + "RESOURCE_CATEGORY,\n" + "RESOURCE_SUB_CAT,\n" +
    "ECTRANSID,\n" + "TAX_DSCNT_FLG,\n" + "TAX_FRGHT_FLG,\n" + "TAX_MISC_FLG,\n" + "TAX_VAT_FLG,\n" +
    "PHYSICAL_NATURE,\n" + "VAT_RCRD_INPT_FLG,\n" + "VAT_RCRD_OUTPT_FLG,\n" + "VAT_TREATMENT,\n" +
    "VAT_SVC_SUPPLY_FLG,\n" + "VAT_SERVICE_TYPE,\n" + "COUNTRY_LOC_BUYER,\n" + "STATE_LOC_BUYER,\n" +
    "COUNTRY_LOC_SELLER,\n" + "STATE_LOC_SELLER,\n" + "COUNTRY_VAT_SUPPLY,\n" + "STATE_VAT_SUPPLY,\n" +
    "COUNTRY_VAT_PERFRM,\n" + "STATE_VAT_PERFRM,\n" + "STATE_SHIP_FROM,\n" + "STATE_VAT_DEFAULT,\n" +
    "REQUESTOR_ID,\n" + "VAT_RECEIPT,\n" + "VAT_RGSTRN_SELLER,\n" + "IST_TXN_FLG,\n" + "WTHD_SW,\n" + "WTHD_CD,\n" +
    "MFG_ID,\n" + "USER_VCHR_CHAR1,\n" + "USER_VCHR_CHAR2,\n" + "USER_LINE_CHAR1,\n" + "USER_SCHED_CHAR1,\n" +
    "VAT_RVRSE_CHG_GDS\n" + //21
    " )" + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" + " )";

                        PreparedStatement pstmt_vchr_line_stg = configdb.prepareStatement(insertSql_line_stg);
                        pstmt_vchr_line_stg.setString(1, "TIC01"); //1
                        pstmt_vchr_line_stg.setString(2, key_c1_seq); //2
                        pstmt_vchr_line_stg.setString(3, " "); //3
                        pstmt_vchr_line_stg.setInt(4, 0);
                        pstmt_vchr_line_stg.setInt(5, 0);
                        pstmt_vchr_line_stg.setString(6, key_c1_seq);
                        pstmt_vchr_line_stg.setInt(7, voucherLine);
                        pstmt_vchr_line_stg.setInt(8, 0);
                        pstmt_vchr_line_stg.setInt(9, 0);
                        pstmt_vchr_line_stg.setString(10, "Carrier Compensation");
                        pstmt_vchr_line_stg.setDouble(11, trans_agg_amt4);
                        pstmt_vchr_line_stg.setInt(12, 1);
                        pstmt_vchr_line_stg.setInt(13, 0);
                        pstmt_vchr_line_stg.setDouble(14, trans_agg_amt4);
                        pstmt_vchr_line_stg.setInt(15, 0);
                        pstmt_vchr_line_stg.setInt(16, 0);
                        pstmt_vchr_line_stg.setInt(17, 0);
                        pstmt_vchr_line_stg.setInt(18, 0);
                        pstmt_vchr_line_stg.setInt(19, 0);
                        pstmt_vchr_line_stg.setInt(20, 0);
                        pstmt_vchr_line_stg.setInt(21, 0);
                        pstmt_vchr_line_stg.setString(22, " "); //
                        pstmt_vchr_line_stg.setString(23, " "); //
                        pstmt_vchr_line_stg.setString(24, " "); //
                        pstmt_vchr_line_stg.setString(25, " "); //
                        pstmt_vchr_line_stg.setString(26, " "); //
                        pstmt_vchr_line_stg.setString(27, " "); //
                        pstmt_vchr_line_stg.setString(28, " "); //
                        pstmt_vchr_line_stg.setString(29, " "); //
                        pstmt_vchr_line_stg.setString(30, " "); //
                        pstmt_vchr_line_stg.setString(31, " "); //
                        pstmt_vchr_line_stg.setString(32, " "); //
                        pstmt_vchr_line_stg.setString(33, " "); //
                        pstmt_vchr_line_stg.setString(34, " "); //
                        pstmt_vchr_line_stg.setString(35, " "); //
                        pstmt_vchr_line_stg.setString(36, " "); //
                        pstmt_vchr_line_stg.setString(37, " "); //
                        pstmt_vchr_line_stg.setString(38, " "); //
                        pstmt_vchr_line_stg.setString(39, " "); //
                        pstmt_vchr_line_stg.setString(40, " "); //
                        pstmt_vchr_line_stg.setString(41, " "); //
                        pstmt_vchr_line_stg.setString(42, " "); //
                        pstmt_vchr_line_stg.setString(43, " "); //
                        pstmt_vchr_line_stg.setString(44, " "); //
                        pstmt_vchr_line_stg.setString(45, tgt_vendor_id);
                        pstmt_vchr_line_stg.setString(46, " "); //;
                        pstmt_vchr_line_stg.setString(47, " "); //
                        pstmt_vchr_line_stg.setString(48, " "); //
                        pstmt_vchr_line_stg.setString(49, " "); //
                        pstmt_vchr_line_stg.setString(50, " "); //
                        pstmt_vchr_line_stg.setString(51, " ");
                        pstmt_vchr_line_stg.setString(52, " ");
                        pstmt_vchr_line_stg.setString(53, " ");
                        pstmt_vchr_line_stg.setString(54, " ");
                        pstmt_vchr_line_stg.setString(55, " ");
                        pstmt_vchr_line_stg.setString(56, " ");
                        pstmt_vchr_line_stg.setString(57, " ");
                        pstmt_vchr_line_stg.setString(58, " ");
                        pstmt_vchr_line_stg.setString(59, " ");
                        pstmt_vchr_line_stg.setString(60, " ");
                        pstmt_vchr_line_stg.setString(61, " ");
                        pstmt_vchr_line_stg.setString(62, " ");
                        pstmt_vchr_line_stg.setString(63, " ");
                        pstmt_vchr_line_stg.setString(64, " ");
                        pstmt_vchr_line_stg.setString(65, " ");
                        pstmt_vchr_line_stg.setString(66, " ");
                        pstmt_vchr_line_stg.setString(67, " ");
                        pstmt_vchr_line_stg.setString(68, " ");
                        pstmt_vchr_line_stg.setString(69, " ");
                        pstmt_vchr_line_stg.setString(70, " ");
                        pstmt_vchr_line_stg.setString(71, " ");
                        pstmt_vchr_line_stg.setString(72, " ");
                        pstmt_vchr_line_stg.setString(73, " ");
                        pstmt_vchr_line_stg.setString(74, " ");
                        pstmt_vchr_line_stg.setString(75, " ");
                        pstmt_vchr_line_stg.setString(76, " ");
                        pstmt_vchr_line_stg.setString(77, " ");
                        pstmt_vchr_line_stg.setString(78, " ");
                        pstmt_vchr_line_stg.setString(79, " ");
                        pstmt_vchr_line_stg.setString(80, " ");
                        pstmt_vchr_line_stg.setString(81, " ");
                        pstmt_vchr_line_stg.setString(82, " ");
                        pstmt_vchr_line_stg.setString(83, " ");
                        pstmt_vchr_line_stg.setString(84, " ");
                        pstmt_vchr_line_stg.setString(85, " ");
                        pstmt_vchr_line_stg.setString(86, " ");
                        pstmt_vchr_line_stg.setString(87, " ");
                        pstmt_vchr_line_stg.setString(88, " ");
                        pstmt_vchr_line_stg.setString(89, " ");
                        pstmt_vchr_line_stg.setString(90, " ");
                        pstmt_vchr_line_stg.setString(91, " ");
                        pstmt_vchr_line_stg.setString(92, " ");
                        pstmt_vchr_line_stg.setString(93, " ");
                        pstmt_vchr_line_stg.setString(94, " ");
                        pstmt_vchr_line_stg.setString(95, " ");
                        pstmt_vchr_line_stg.setString(96, " ");
                        pstmt_vchr_line_stg.setString(97, " ");
                        pstmt_vchr_line_stg.setString(98, " ");
                        pstmt_vchr_line_stg.setString(99, " ");
                        pstmt_vchr_line_stg.setString(100, " ");
                        pstmt_vchr_line_stg.setString(101, " ");
                        pstmt_vchr_line_stg.setString(102, " ");
                        pstmt_vchr_line_stg.setString(103, " ");
                        pstmt_vchr_line_stg.setString(104, " ");
                        pstmt_vchr_line_stg.executeUpdate(); // execute insert statement
                        pstmt_vchr_line_stg.close();
                        //      System.out.println("2b=====================> " );
                        //     System.out.println("transAttr4=> " + transAttr4 );


                        //insert into voucher dist_stg
                        String insertSql_dist_stg =
                            "insert into PS_VCHR_DIST_STG ( " + // //PROD #3 OF 5
                            "BUSINESS_UNIT,\n" + //1
                            "VCHR_BLD_KEY_C1,\n" + //2
                            "VCHR_BLD_KEY_C2,\n" + //3
                            "VCHR_BLD_KEY_N1,\n" + //4
                            "VCHR_BLD_KEY_N2,\n" + //5
                            "VOUCHER_ID,\n" + //6
                            "VOUCHER_LINE_NUM,\n" + //7
                            "DISTRIB_LINE_NUM,\n" + //8
                            "BUSINESS_UNIT_GL,\n" + //9
                            "ACCOUNT,\n" + //10
                            "DEPTID,\n" + //11
                            "MERCHANDISE_AMT,\n" + //12
                            "LINE_NBR,\n" + //13
                            "SCHED_NBR,\n" + //14
                            "PO_DIST_LINE_NUM,\n" + //15
                            "BUSINESS_UNIT_PC,\n" + //16
                            "ACTIVITY_ID,\n" + //17
                            "ANALYSIS_TYPE,\n" + //18
                            "RESOURCE_TYPE,\n" + //19
                            "RESOURCE_CATEGORY,\n" + //20
                            "RECV_LN_NBR,\n" + //21
                            "RECV_SHIP_SEQ_NBR,\n" + //22
                            "RECV_DIST_LINE_NUM,\n" + //23
                            "PRODUCT,\n" + //24
                            "PROJECT_ID,\n" + //25
                            "ECQUEUEINSTANCE,\n" + //26
                            "USER_VCHR_DEC,\n" + //27
                            "USER_VCHR_NUM1,\n" + //28
                            "VAT_RECOVERY_PCT,\n" + //29
                            "VAT_REBATE_PCT,\n" + //30
                            "VAT_CALC_AMT,\n" + //31
                            "VAT_BASIS_AMT,\n" + //32
                            "VAT_RCVRY_AMT,\n" + //33
                            "VAT_NRCVR_AMT,\n" + //34
                            "VAT_REBATE_AMT,\n" + //35
                            "VAT_TRANS_AMT,\n" + //36
                            "TAX_CD_VAT_PCT,\n" + //37
                            "VAT_INV_AMT,\n" + //38
                            "VAT_NONINV_AMT,\n" + //39
                            "WO_TASK_ID,\n" + //40
                            "RES_LN_NBR, \n " + "ALTACCT,\n" + "STATISTICS_CODE,\n" + "STATISTIC_AMOUNT,\n" +
    "QTY_VCHR,\n" + "DESCR,\n" + "BUSINESS_UNIT_PO,\n" + "PO_ID,\n" + "RESOURCE_SUB_CAT,\n" + "ASSET_FLG,\n" +
    "BUSINESS_UNIT_AM,\n" + "ASSET_ID,\n" + "PROFILE_ID,\n" + "COST_TYPE,\n" + "VAT_TXN_TYPE_CD,\n" +
    "BUSINESS_UNIT_RECV,\n" + "RECEIVER_ID,\n" + "OPERATING_UNIT,\n" + "FUND_CODE,\n" + "CLASS_FLD,\n" +
    "PROGRAM_CODE,\n" + "BUDGET_REF,\n" + "AFFILIATE,\n" + "AFFILIATE_INTRA1,\n" + "AFFILIATE_INTRA2,\n" +
    "CHARTFIELD1,\n" + "CHARTFIELD2,\n" + "CHARTFIELD3,\n" + "ENTRY_EVENT,\n" + "ECTRANSID,\n" + "JRNL_LN_REF,\n" +
    "VAT_APORT_CNTRL,\n" + "USER_VCHR_CHAR1,\n" + "USER_VCHR_CHAR2,\n" + "USER_DIST_CHAR1,\n" + "OPEN_ITEM_KEY,\n" +
    "BUSINESS_UNIT_WO,\n" + "WO_ID,\n" + "RSRC_TYPE\n" + //41
    " )" + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" + ")";

                        PreparedStatement pstmt_vchr_dist_stg = configdb.prepareStatement(insertSql_dist_stg);
                        pstmt_vchr_dist_stg.setString(1, "TIC01"); //1
                        pstmt_vchr_dist_stg.setString(2, key_c1_seq); //2
                        pstmt_vchr_dist_stg.setString(3, " "); //3
                        pstmt_vchr_dist_stg.setInt(4, 0);
                        pstmt_vchr_dist_stg.setInt(5, 0);
                        pstmt_vchr_dist_stg.setString(6, key_c1_seq);
                        pstmt_vchr_dist_stg.setInt(7, voucherLine);
                        pstmt_vchr_dist_stg.setInt(8, 1);
                        pstmt_vchr_dist_stg.setString(9, "TIC01");
                        pstmt_vchr_dist_stg.setString(10, chartfield1);
                        pstmt_vchr_dist_stg.setString(11, chartfield2);
                        pstmt_vchr_dist_stg.setDouble(12, trans_agg_amt4);
                        pstmt_vchr_dist_stg.setInt(13, 0);
                        pstmt_vchr_dist_stg.setInt(14, 0);
                        pstmt_vchr_dist_stg.setInt(15, 0);
                        pstmt_vchr_dist_stg.setString(16, "NEU01");
                        pstmt_vchr_dist_stg.setString(17, activity_id);
                        pstmt_vchr_dist_stg.setString(18, "ACT");
                        pstmt_vchr_dist_stg.setString(19, transAttr3);
                        pstmt_vchr_dist_stg.setString(20, transAttr4);
                        pstmt_vchr_dist_stg.setInt(21, 0);
                        pstmt_vchr_dist_stg.setInt(22, 0);
                        pstmt_vchr_dist_stg.setInt(23, 0);
                        pstmt_vchr_dist_stg.setString(24, chartfield3);
                        pstmt_vchr_dist_stg.setString(25, project_id);
                        pstmt_vchr_dist_stg.setInt(26, 0);
                        pstmt_vchr_dist_stg.setInt(27, 0);
                        pstmt_vchr_dist_stg.setInt(28, 0);
                        pstmt_vchr_dist_stg.setInt(29, 0);
                        pstmt_vchr_dist_stg.setInt(30, 0);
                        pstmt_vchr_dist_stg.setInt(31, 0);
                        pstmt_vchr_dist_stg.setInt(32, 0);
                        pstmt_vchr_dist_stg.setInt(33, 0);
                        pstmt_vchr_dist_stg.setInt(34, 0);
                        pstmt_vchr_dist_stg.setInt(35, 0);
                        pstmt_vchr_dist_stg.setInt(36, 0);
                        pstmt_vchr_dist_stg.setInt(37, 0);
                        pstmt_vchr_dist_stg.setInt(38, 0);
                        ;
                        pstmt_vchr_dist_stg.setInt(39, 0);
                        pstmt_vchr_dist_stg.setInt(40, 0);
                        pstmt_vchr_dist_stg.setInt(41, 0);
                        pstmt_vchr_dist_stg.setInt(42, 0);
                        pstmt_vchr_dist_stg.setString(43, " "); //
                        pstmt_vchr_dist_stg.setInt(44, 0);
                        pstmt_vchr_dist_stg.setInt(45, 1);
                        pstmt_vchr_dist_stg.setString(46, " "); //;
                        pstmt_vchr_dist_stg.setString(47, " "); //
                        pstmt_vchr_dist_stg.setString(48, " "); //
                        pstmt_vchr_dist_stg.setString(49, " "); //
                        pstmt_vchr_dist_stg.setString(50, " "); //
                        pstmt_vchr_dist_stg.setString(51, " ");
                        pstmt_vchr_dist_stg.setString(52, " ");
                        pstmt_vchr_dist_stg.setString(53, " ");
                        pstmt_vchr_dist_stg.setString(54, " ");
                        pstmt_vchr_dist_stg.setString(55, " ");
                        pstmt_vchr_dist_stg.setString(56, " ");
                        pstmt_vchr_dist_stg.setString(57, " ");
                        pstmt_vchr_dist_stg.setString(58, " ");
                        pstmt_vchr_dist_stg.setString(59, " ");
                        pstmt_vchr_dist_stg.setString(60, " ");
                        pstmt_vchr_dist_stg.setString(61, " ");
                        pstmt_vchr_dist_stg.setString(62, " ");
                        pstmt_vchr_dist_stg.setString(63, " ");
                        pstmt_vchr_dist_stg.setString(64, " ");
                        pstmt_vchr_dist_stg.setString(65, " ");
                        pstmt_vchr_dist_stg.setString(66, " ");
                        pstmt_vchr_dist_stg.setString(67, " ");
                        pstmt_vchr_dist_stg.setString(68, " ");
                        pstmt_vchr_dist_stg.setString(69, " ");
                        pstmt_vchr_dist_stg.setString(70, " ");
                        pstmt_vchr_dist_stg.setString(71, " ");
                        pstmt_vchr_dist_stg.setString(72, " ");
                        pstmt_vchr_dist_stg.setString(73, " ");
                        pstmt_vchr_dist_stg.setString(74, " ");
                        pstmt_vchr_dist_stg.setString(75, " ");
                        pstmt_vchr_dist_stg.setString(76, " ");
                        pstmt_vchr_dist_stg.setString(77, " ");
                        pstmt_vchr_dist_stg.setString(78, " ");
                        pstmt_vchr_dist_stg.setString(79, " ");
                        pstmt_vchr_dist_stg.executeUpdate(); // execute insert statement
                        pstmt_vchr_dist_stg.close();

                        //CHECK for external
                        if (transAttr4.equals("RSCEX") || transAttr4.equals("RSOEX") ||
                            transAttr4.equals("RSLEX")) {
                            //           System.out.println("Performing insert for " + transAttr4);

                            String readSQL_APSTGGRP =
                                                              "SELECT   distinct CIS_TARGET_CUSTID2, CIS_TARGTCUST2DET1,CIS_TARGET_VENDOR1 , ACTIVITY_ID,ATTR_VALUE3,ATTR_VALUE4 ,  \n" +
                                                              "  CIS_TARGET_CUSTID1, CIS_TARGTCUST1DET1, KEY4,   CHARTFIELD1, CHARTFIELD2, CHARTFIELD3, SUM(CIS_TRANS_AGG_QTY1) as CIS_TRANS_AGG_QTY1 , " +
                                                              " sum(round(CIS_TRANS_AGG_AMT4,2)) as CIS_TRANS_AGG_AMT4, last_day(max(key_date_01)) as month_last_dt \n" +
                                                              "from PS_CIS_XPE_IMP_CONTR_VW b \n" +
                                                              "where cis_stage in ('3_CNAM_RV_AGG','3_LIDB_RV_AGG')  and cis_status = 'P' " + //
                                                              "and CIS_TARGET_VENDOR1 = " + "'" + tgt_vendor_id + "'" +
                                                              "and ATTR_VALUE4 = " + "'" + transAttr4 + "'" +
                                                              "and PROJECT_ID = " + "'" + project_id + "'" +
                                                              "and ACTIVITY_ID = " + "'" + activity_id + "'" +
                                                              " GROUP BY CIS_TARGET_CUSTID2, CIS_TARGTCUST2DET1,CIS_TARGET_VENDOR1 , ACTIVITY_ID, ATTR_VALUE3,ATTR_VALUE4, CIS_TARGET_CUSTID1, CIS_TARGTCUST1DET1, KEY4,CHARTFIELD1, CHARTFIELD2, CHARTFIELD3" +
                                                              " having sum(round(CIS_TRANS_AGG_AMT4,2)) > 0";

                            //       System.out.println("readSQL_APSTGGRP " + readSQL_APSTGGRP);

                            ResultSet myResultSet_apstgrp = sqlStatement_apstgrp.executeQuery(readSQL_APSTGGRP);

                            boolean hasNext2_apstgrp = myResultSet_apstgrp.next();
                            recordCounter1 = 0;
                            while (hasNext2_apstgrp) { //while apstgrp

                                tgtCustId2 = myResultSet_apstgrp.getString("CIS_TARGET_CUSTID2");
                                tgtCust2Detail1 = myResultSet_apstgrp.getString("CIS_TARGTCUST2DET1");
                                tgt_vendor_id = myResultSet_apstgrp.getString("CIS_TARGET_VENDOR1");
                                activity_id = myResultSet_apstgrp.getString("ACTIVITY_ID");
                                transAttr3 = myResultSet_apstgrp.getString("ATTR_VALUE3");
                                transAttr4 = myResultSet_apstgrp.getString("ATTR_VALUE4");
                                tgtCustId1 = myResultSet_apstgrp.getString("CIS_TARGET_CUSTID1");
                                tgtCust1Detail1 = myResultSet_apstgrp.getString("CIS_TARGTCUST1DET1");
                                ocn = myResultSet_apstgrp.getString("KEY4");
                                chartfield1 = myResultSet_apstgrp.getString("CHARTFIELD1");
                                chartfield2 = myResultSet_apstgrp.getString("CHARTFIELD2");
                                chartfield3 = myResultSet_apstgrp.getString("CHARTFIELD3");
                                monthlastDt = myResultSet_apstgrp.getDate("month_last_dt");

                                trans_agg_qty1 = myResultSet_apstgrp.getInt("CIS_TRANS_AGG_QTY1");
                                trans_agg_amt4 = myResultSet_apstgrp.getDouble("CIS_TRANS_AGG_AMT4");
                                tgtCustId1 = myResultSet_apstgrp.getString("CIS_TARGET_CUSTID1");


                                String tgtCust2Detail1_40;

                                if (tgtCust2Detail1.length() > 40) {
                                    tgtCust2Detail1_40 = tgtCust2Detail1.substring(0, 39);
                                } else {
                                    tgtCust2Detail1_40 = tgtCust2Detail1;
                                }

                                String tgtCust1Detail1_40;

                                if (tgtCust1Detail1.length() > 40) {
                                    tgtCust1Detail1_40 = tgtCust1Detail1.substring(0, 39);
                                } else {
                                    tgtCust1Detail1_40 = tgtCust1Detail1;
                                }

                                if (trans_agg_qty1 != 0) {
                                    rate = trans_agg_amt4 / trans_agg_qty1;
                                    rate_round2 = roundTwoDecimals(rate);
                                    //                    rate_round2 = 0;
                                } else {
                                    rate_round2 = 0;
                                }

                                if (trans_agg_amt4 > 0) {
                                    //                                        insert into PS_CIS_XPE_APSTGRP
                                    //  System.out.println("=============RSCEX========================= "  );
                                    //          System.out.println("processId " + processId );
                                    //          System.out.println("tgtCustId2 " + tgtCustId2 );
                                    //          System.out.println("tgtCust2Detail1_40 " + tgtCust2Detail1_40 );
                                    //          System.out.println("tgt_vendor_id " + tgt_vendor_id );
                                    //           System.out.println("monthlastDt " + monthlastDt );
                                    //           System.out.println("tgtCustId1 " + tgtCustId1 );
                                    //          System.out.println("ocn " + ocn );
                                    //           System.out.println("trans_agg_qty1 " + trans_agg_qty1 );
                                    //          System.out.println("rate_round2 " + rate_round2 );
                                    //           System.out.println("key_c1_seq " + key_c1_seq );
                                    //           System.out.println("trans_agg_amt4 " + trans_agg_amt4 );
                                    //          System.out.println("voucherLine " + voucherLine );
                                    //           System.out.println("tgtCust1Detail1_40 " + tgtCust1Detail1_40 );



                                    String insertSql_ap_stg = "insert into PS_CIS_XPE_APSTGRP ( " + //PROD   #4 OF 5
                                        "PROCESSID,\n" + //1
                                        "CIS_PRCS_REQST_ID,\n" + //2
                                        "CUST_ID,\n" + //3
                                        "CUST_NAME,\n" + //4
                                        "VENDOR_ID,\n" + //5
                                        "TRANS_DATE,\n" + //6
                                        "SERVICENAME,\n" + //7
                                        "CIS_CUST_ID_OPC,\n" + //8
                                        "CIS_OCN,\n" + //9
                                        "USAGE_QTY,\n" + //10
                                        "RATE,\n" + //11
                                        "AMOUNT,\n" + //12
                                        "BUSINESS_UNIT_AP,\n" + //13
                                        "VCHR_BLD_KEY_C1,\n" + //14
                                        "VCHR_BLD_KEY_C2,\n" + //15
                                        "VCHR_BLD_KEY_N1,\n" + //16
                                        "VCHR_BLD_KEY_N2,\n" + //17
                                        "VOUCHER_ID,\n" + //18
                                        "VOUCHER_LINE_NUM, \n" + //19
                                        "NAME1 \n" + //20

                                        " )" + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                                    PreparedStatement pstmt_apstg_rp = configdb.prepareStatement(insertSql_ap_stg);
                                    pstmt_apstg_rp.setInt(1, processId); //1
                                    pstmt_apstg_rp.setInt(2, 1); //2
                                    pstmt_apstg_rp.setString(3, tgtCustId2); //3
                                    pstmt_apstg_rp.setString(4, tgtCust2Detail1_40);
                                    pstmt_apstg_rp.setString(5, tgt_vendor_id);
                                    pstmt_apstg_rp.setDate(6, monthlastDt);
                                    pstmt_apstg_rp.setString(7, "CNAM DATABASE COMPENSATION");
                                    pstmt_apstg_rp.setString(8, tgtCustId1);
                                    pstmt_apstg_rp.setString(9, ocn);
                                    pstmt_apstg_rp.setInt(10, trans_agg_qty1);
                                    pstmt_apstg_rp.setDouble(11, rate_round2);
                                    pstmt_apstg_rp.setDouble(12, trans_agg_amt4);
                                    pstmt_apstg_rp.setString(13, "TIC01");
                                    pstmt_apstg_rp.setString(14, key_c1_seq);
                                    ;
                                    pstmt_apstg_rp.setString(15, " ");
                                    pstmt_apstg_rp.setInt(16, 0);
                                    pstmt_apstg_rp.setInt(17, 0);
                                    pstmt_apstg_rp.setString(18, key_c1_seq);
                                    ;
                                    pstmt_apstg_rp.setInt(19, voucherLine);
                                    ;
                                    pstmt_apstg_rp.setString(20, tgtCust1Detail1_40);
                                    ;

                                    result = pstmt_apstg_rp.executeUpdate(); // execute insert statement
                                    //                              System.out.println("4c=====================> " );
                                    pstmt_apstg_rp.close();

                                    if (result >
                                        0) { //make X
                                        String updVoucherX_rcex =
                                   "MERGE INTO PS_CIS_XPE_IMPORT a\n" + "  USING \n" + "  (\n" +
                                   "                  SELECT  CIS_TARGET_CUSTID1, b.key1, b.key2, b.KEY3, b.KEY4, b.KEY_DATE_01, b.CIS_STATUS \n" +
                                   "               from PS_CIS_XPE_IMP_CONTR_VW b  \n" +
                                   "where cis_stage in ('3_CNAM_RV_AGG','3_LIDB_RV_AGG')  and cis_status = 'P' " + //
                                   "and CIS_TARGET_VENDOR1 = " + "'" + tgt_vendor_id + "'" + "and ATTR_VALUE4 = " +
                                   "'" + transAttr4 + "'" + "and PROJECT_ID = " + "'" + project_id + "'" +
                                   "and ACTIVITY_ID = " + "'" + activity_id + "'" + "\n" + "  ) b\n" +
                                   "  ON  ( a.key1 = b.key1  AND a.key2 = b.key2 and a.key3 = b.key3 and a.key4 = b.key4 and a.KEY_DATE_01 = b.KEY_DATE_01 and a.cis_stage in ('3_CNAM_RV_AGG','3_LIDB_RV_AGG')    )\n" +
                                   "  WHEN MATCHED THEN\n" +
                                   "        UPDATE SET a.cis_Status = 'X',VCHR_BLD_KEY_C1 = ? , VCHR_BLD_KEY_C2 = ?  , VCHR_BLD_KEY_N1 = ? , " +
                                   "VCHR_BLD_KEY_N2 = ? , VOUCHER_ID = ? ,  VOUCHER_LINE_NUM = ? ";

                                        //                                                         System.out.println("key_c1_seq " + key_c1_seq);
                                        //                                                          System.out.println("voucherLine " + voucherLine);
                                        //                                                       System.out.println("Query updVoucherX_rcex " + updVoucherX_rcex);

                                        PreparedStatement pstmt_updVoucherX_rcex =
                                            configdb.prepareStatement(updVoucherX_rcex);
                                        pstmt_updVoucherX_rcex.setString(1, key_c1_seq);
                                        ;
                                        pstmt_updVoucherX_rcex.setString(2, " ");
                                        pstmt_updVoucherX_rcex.setInt(3, 0);
                                        pstmt_updVoucherX_rcex.setInt(4, 0);
                                        pstmt_updVoucherX_rcex.setString(5, key_c1_seq);
                                        ;
                                        pstmt_updVoucherX_rcex.setInt(6, voucherLine);
                                        ;
                                        result = pstmt_updVoucherX_rcex.executeUpdate(); // execute insert statement
                                        pstmt_updVoucherX_rcex.close();
                                    }

                                } //trans_bi_amt check

                                hasNext2_apstgrp = myResultSet_apstgrp.next();
                                recordCounter1++;

                            } //While  //while apstgrp
                            myResultSet_apstgrp.close();

                        }

                        if (transAttr4.equals("RSCIN")) {
                            //      System.out.println("Performing insert for " + transAttr4);


                            String readSQL_APSTGGRP =
                                "SELECT   distinct CIS_TARGET_CUSTID2, CIS_TARGTCUST2DET1,CIS_TARGET_VENDOR1 , ACTIVITY_ID,ATTR_VALUE3,ATTR_VALUE4 ,  \n" +
                                "    KEY4,   CHARTFIELD1, CHARTFIELD2, CHARTFIELD3, SUM(CIS_TRANS_AGG_QTY1) as CIS_TRANS_AGG_QTY1,  " +
                                " sum(round(CIS_TRANS_AGG_AMT4,2)) as CIS_TRANS_AGG_AMT4, last_day(max(key_date_01)) as month_last_dt \n" +
                                "from PS_CIS_XPE_IMP_CONTR_VW b \n" +
                                "where cis_stage in ('3_CNAM_RV_AGG','3_LIDB_RV_AGG')  and cis_status = 'P' " + //
                                "and CIS_TARGET_VENDOR1 = " + "'" + tgt_vendor_id + "'" + "and ATTR_VALUE4 = " + "'" +
                                transAttr4 + "'" + "and PROJECT_ID = " + "'" + project_id + "'" + "and ACTIVITY_ID = " +
                                "'" + activity_id + "'" +
                                " GROUP BY CIS_TARGET_CUSTID2, CIS_TARGTCUST2DET1,CIS_TARGET_VENDOR1 , ACTIVITY_ID, ATTR_VALUE3,ATTR_VALUE4,  KEY4,CHARTFIELD1, CHARTFIELD2, CHARTFIELD3" +
                                " having sum(round(CIS_TRANS_AGG_AMT4,2)) > 0";

                            //      System.out.println("readSQL_APSTGGRP " + readSQL_APSTGGRP);
                            //   System.out.println("readSQL_APSTGGRP " + recordCounter1 );

                            ResultSet myResultSet_apstgrp = sqlStatement_apstgrp.executeQuery(readSQL_APSTGGRP);

                            boolean hasNext2_apstgrp = myResultSet_apstgrp.next();
                            recordCounter1 = 0;
                            while (hasNext2_apstgrp) { //while apstgrp

                                tgtCustId2 = myResultSet_apstgrp.getString("CIS_TARGET_CUSTID2");
                                tgtCust2Detail1 = myResultSet_apstgrp.getString("CIS_TARGTCUST2DET1");
                                tgt_vendor_id = myResultSet_apstgrp.getString("CIS_TARGET_VENDOR1");
                                activity_id = myResultSet_apstgrp.getString("ACTIVITY_ID");
                                transAttr3 = myResultSet_apstgrp.getString("ATTR_VALUE3");
                                transAttr4 = myResultSet_apstgrp.getString("ATTR_VALUE4");
                                tgtCustId1 = "  ";
                                tgtCust1Detail1 = "CNAMCOMP: NEUSTAR DATABASE";
                                ocn = myResultSet_apstgrp.getString("KEY4");
                                chartfield1 = myResultSet_apstgrp.getString("CHARTFIELD1");
                                chartfield2 = myResultSet_apstgrp.getString("CHARTFIELD2");
                                chartfield3 = myResultSet_apstgrp.getString("CHARTFIELD3");
                                monthlastDt = myResultSet_apstgrp.getDate("month_last_dt");

                                trans_agg_qty1 = myResultSet_apstgrp.getInt("CIS_TRANS_AGG_QTY1");
                                trans_agg_amt4 = myResultSet_apstgrp.getDouble("CIS_TRANS_AGG_AMT4");


                                String tgtCust2Detail1_40;

                                if (tgtCust2Detail1.length() > 40) {
                                    tgtCust2Detail1_40 = tgtCust2Detail1.substring(0, 39);
                                } else {
                                    tgtCust2Detail1_40 = tgtCust2Detail1;
                                }

                                String tgtCust1Detail1_40;

                                if (tgtCust1Detail1.length() > 40) {
                                    tgtCust1Detail1_40 = tgtCust1Detail1.substring(0, 39);
                                } else {
                                    tgtCust1Detail1_40 = tgtCust1Detail1;
                                }

                                if (trans_agg_qty1 != 0) {
                                    rate = trans_agg_amt4 / trans_agg_qty1;
                                    rate_round2 = roundTwoDecimals(rate);
                                    //                           rate_round2 = 0;
                                } else {
                                    rate_round2 = 0;
                                }

                                if (trans_agg_amt4 > 0) {
                                    //                                        insert into PS_CIS_XPE_APSTGRP

                                    //  System.out.println("=============RSCIN========================= "  );
                                    //                        System.out.println("tgtCustId2 " + tgtCustId2 );
                                    //             System.out.println("tgtCust2Detail1_40 " + tgtCust2Detail1_40 );
                                    //             System.out.println("tgt_vendor_id " + tgt_vendor_id );
                                    //             System.out.println("tgtCustId1 " + tgtCustId1 );
                                    //            System.out.println("ocn " + ocn );
                                    //            System.out.println("trans_agg_qty1 " + trans_agg_qty1 );
                                    //            System.out.println("rate_round2 " + rate_round2 );
                                    //             System.out.println("key_c1_seq " + key_c1_seq );
                                    //            System.out.println("trans_agg_amt4 " + trans_agg_amt4 );
                                    //            System.out.println("voucherLine " + voucherLine );
                                    //            System.out.println("tgtCust1Detail1_40 " + tgtCust1Detail1_40 );

                                    String insertSql_ap_stg = "insert into PS_CIS_XPE_APSTGRP ( " + //PROD   #5 OF 5

                                        "PROCESSID,\n" + //1
                                        "CIS_PRCS_REQST_ID,\n" + //2
                                        "CUST_ID,\n" + //3
                                        "CUST_NAME,\n" + //4
                                        "VENDOR_ID,\n" + //5
                                        "TRANS_DATE,\n" + //6
                                        "SERVICENAME,\n" + //7
                                        "CIS_CUST_ID_OPC,\n" + //8
                                        "CIS_OCN,\n" + //9
                                        "USAGE_QTY,\n" + //10
                                        "RATE,\n" + //11
                                        "AMOUNT,\n" + //12
                                        "BUSINESS_UNIT_AP,\n" + //13
                                        "VCHR_BLD_KEY_C1,\n" + //14
                                        "VCHR_BLD_KEY_C2,\n" + //15
                                        "VCHR_BLD_KEY_N1,\n" + //16
                                        "VCHR_BLD_KEY_N2,\n" + //17
                                        "VOUCHER_ID,\n" + //18
                                        "VOUCHER_LINE_NUM, \n" + //19
                                        "NAME1 \n" + //20

                                        " )" + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                                    PreparedStatement pstmt_apstg_rp = configdb.prepareStatement(insertSql_ap_stg);
                                    pstmt_apstg_rp.setInt(1, processId); //1
                                    pstmt_apstg_rp.setInt(2, 1); //2
                                    pstmt_apstg_rp.setString(3, tgtCustId2); //3
                                    pstmt_apstg_rp.setString(4, tgtCust2Detail1_40);
                                    pstmt_apstg_rp.setString(5, tgt_vendor_id);
                                    pstmt_apstg_rp.setDate(6, monthlastDt);
                                    pstmt_apstg_rp.setString(7, "CNAM DATABASE COMPENSATION");
                                    pstmt_apstg_rp.setString(8, tgtCustId1);
                                    pstmt_apstg_rp.setString(9, ocn);
                                    pstmt_apstg_rp.setInt(10, trans_agg_qty1);
                                    pstmt_apstg_rp.setDouble(11, rate_round2);
                                    pstmt_apstg_rp.setDouble(12, trans_agg_amt4);
                                    pstmt_apstg_rp.setString(13, "TIC01");
                                    pstmt_apstg_rp.setString(14, key_c1_seq);
                                    ;
                                    pstmt_apstg_rp.setString(15, " ");
                                    pstmt_apstg_rp.setInt(16, 0);
                                    pstmt_apstg_rp.setInt(17, 0);
                                    pstmt_apstg_rp.setString(18, key_c1_seq);
                                    ;
                                    pstmt_apstg_rp.setInt(19, voucherLine);
                                    ;
                                    pstmt_apstg_rp.setString(20, tgtCust1Detail1_40);
                                    ;

                                    result = pstmt_apstg_rp.executeUpdate(); // execute insert statement


                                    if (result >
                                        0) { //make X
                                        String updVoucherX_rcin =
                                   "MERGE INTO PS_CIS_XPE_IMPORT a\n" + "  USING \n" + "  (\n" +
                                   "                  SELECT  CIS_TARGET_CUSTID1, b.key1, b.key2, b.KEY3, b.KEY4, b.KEY_DATE_01, b.CIS_STATUS \n" +
                                   "               from PS_CIS_XPE_IMP_CONTR_VW b  \n" +
                                   "where cis_stage in ('3_CNAM_RV_AGG','3_LIDB_RV_AGG')  and cis_status = 'P' " + //
                                   "and CIS_TARGET_VENDOR1 = " + "'" + tgt_vendor_id + "'" + "and ATTR_VALUE4 = " +
                                   "'" + transAttr4 + "'" + "and PROJECT_ID = " + "'" + project_id + "'" +
                                   "and ACTIVITY_ID = " + "'" + activity_id + "'" + "\n" + "  ) b\n" +
                                   "  ON  ( a.key1 = b.key1  AND a.key2 = b.key2 and a.key3 = b.key3 and a.key4 = b.key4 and a.KEY_DATE_01 = b.KEY_DATE_01 " +
                                   " and a.cis_stage in ('3_CNAM_RV_AGG','3_LIDB_RV_AGG')    )\n" +
                                   "  WHEN MATCHED THEN\n" +
                                   "        UPDATE SET a.cis_Status = 'X', VCHR_BLD_KEY_C1 = ? , VCHR_BLD_KEY_C2 = ?  , VCHR_BLD_KEY_N1 = ? , VCHR_BLD_KEY_N2 = ? , VOUCHER_ID = ? ,  VOUCHER_LINE_NUM = ?";

                                        //                                                        System.out.println("Query updVoucherX_rcin " + updVoucherX_rcin);
                                        //                                                         System.out.println("key_c1_seq " + key_c1_seq);
                                        //                                                         System.out.println("voucherLine " + voucherLine);

                                        PreparedStatement pstmt_updVoucherX_rcin =
                                            configdb.prepareStatement(updVoucherX_rcin);
                                        pstmt_updVoucherX_rcin.setString(1, key_c1_seq);
                                        ;
                                        pstmt_updVoucherX_rcin.setString(2, " ");
                                        pstmt_updVoucherX_rcin.setInt(3, 0);
                                        pstmt_updVoucherX_rcin.setInt(4, 0);
                                        pstmt_updVoucherX_rcin.setString(5, key_c1_seq);
                                        ;
                                        pstmt_updVoucherX_rcin.setInt(6, voucherLine);
                                        ;

                                        result = pstmt_updVoucherX_rcin.executeUpdate(); // execute insert statement
                                        pstmt_updVoucherX_rcin.close();
                                    }

                                    //                                   System.out.println("4d====================> " );
                                    pstmt_apstg_rp.close();
                                } //trans_bi_amt check

                                hasNext2_apstgrp = myResultSet_apstgrp.next();
                                recordCounter1++;

                            } //While  //while apstgrp
                            myResultSet_apstgrp.close();

                        }
                        //   System.out.println("Record committed " + recordCounter );

                        hasNext4 = myResultSet_line.next();
                        voucherLine = voucherLine + 1;
                        //            System.out.println("2c=====================> " );

                    }
                    ; ////while voucher lines
                    //       System.out.println("2d=====================> " );


                    myResultSet_line.close();
                    myResultSet_line.close();


                    //  System.out.println("3a=====================> " );

                    //ps_cis_xpe_apstggrp


                } //if headerrow > 0


                hasNext1 = myResultSet_main.next();
                recordCounter++;
            } // Main While

            myResultSet_main.close();
            System.out.println("detail records " + recordCounter);
            result = 0;


        } //try
        catch (Exception e) {
            System.out.println(e);
        } //catch

    }

    private static void overrideFromFile(String fileName) {

        // String propertyString;

        System.out.println("reading properties file " + fileName);

        try {

            Properties prop = new Properties();

            prop.load(new FileInputStream(fileName));

            env = parseStringParameter(prop, "env", env, true);
            ps_config_user = parseStringParameter(prop, "ps_config_user", ps_config_user, true);
            ps_config_passwd = parseStringParameter(prop, "ps_config_passwd", ps_config_passwd, false);
            ps_config_url = parseStringParameter(prop, "ps_config_url", ps_config_url, true);
            ps_config_driver = parseStringParameter(prop, "ps_config_driver", ps_config_driver, true);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    private static void printParameterAction(String parameterName, String propertyVal, boolean printDescr) {

        if (printDescr) {
            System.out.println(parameterName + " set to >>>" + propertyVal);
        }

    }

    private static String parseStringParameter(Properties propertyStream, String parameterName, String currentValue,
                                               boolean printDescr) {

        String propertyString = propertyStream.getProperty(parameterName);

        if (propertyString != null) {
            printParameterAction(parameterName, propertyString, printDescr);
        } else {
            propertyString = currentValue;
        }

        return propertyString;

    }


    private String decryptPassword(String s) {
        byte[] decoded = DatatypeConverter.parseBase64Binary(s);

        return new String(decoded);
    }

    public void executeMainLine() {

        //sourcedb is a pointer to PeopleSoft system
        Connection ps_db_uat = null;

        try {
            System.getProperty("user.dir");
            System.out.println("cfgFile : " + cfgFile);

            overrideFromFile(cfgFile);
            // DEV ps_config_passwd = decryptPassword(ps_config_passwd);

            ps_db_uat = connectConfigDb(ps_config_url, ps_config_driver, ps_config_user, ps_config_passwd);
            //execute the plan
            ProjectVariable projShare = new ProjectVariable();
            projShare.setprocessRequestId(1);

            projShare.setconfigDb(ps_db_uat);
            System.out.println("userId : " + userId);

            projShare.setuserId(userId);

            processExecPlan(execPlanId, projShare);

        } catch (Exception e) {
            System.out.println(e);
        }


    }


}
