package com.cgi.dao;

import java.sql.*;

import org.codehaus.jettison.json.JSONArray;

import com.cgi.util.ToJSON;

/**
 * This java class will hold all the sql queries.
 * 
 * Having all sql/database code in one package makes it easier to maintain and audit
 * but increase complexity.
 * 
 * Note: we also used the extends MySqlDao on this java class to inherit all
 * the methods in MySqlDao.java
 * 
 * @author Prateep Gedupudi
 */

public class SchemaCgiTask extends MySqlDao{
	/**
     * This method will search for a specific user tasks
     * By using prepareStatement and the ?, we are protecting against sql injection
     * 
     * Never add parameter straight into the prepareStatement
     * 
     * @param user - username
     * @return - json array of the results from the database
     * @throws Exception
     */
    public JSONArray queryReturnTasks(String user) throws Exception {
            
            PreparedStatement query = null;
            Connection conn = null;
            
            ToJSON converter = new ToJSON();
            JSONArray json = new JSONArray();
            
            try {
                    conn = mySqlTasksConnection();
                    query = conn.prepareStatement("");
                    
                    query.setString(1, user.toUpperCase()); //protect against sql injection
                    ResultSet rs = query.executeQuery();
                    
                    json = converter.toJSONArray(rs);
                    query.close(); //close connection
            }
            catch(SQLException sqlError) {
                    sqlError.printStackTrace();
                    return json;
            }
            catch(Exception e) {
                    e.printStackTrace();
                    return json;
            }
            finally {
                    if (conn != null) conn.close();
            }
            
            return json;
    }
    
   
	

}
