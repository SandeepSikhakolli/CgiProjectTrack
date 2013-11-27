package com.cgi.dao;

import java.sql.Connection;

import javax.naming.*;
import javax.sql.*;

/**
 * This class returns the MySql database connect object
 * 
 * The method and variable in this class are static to save resources
 * You only need one instance of this class running.
 * 
 * @author Prateep Gedupudi
 *
 */
public class MySqlDao {
	 private static DataSource MysqlDS = null; //hold the database object
     private static Context context = null; //used to lookup the database connection in server
     
     /**
      * This is a public method that will return the database connection.
      * 
      * 
      * @return Database object
      * @throws Exception
      */
     public static DataSource MySqlConn() throws Exception {
             
             /**
              * check to see if the database object is already defined...
              * if it is, then return the connection, no need to look it up again.
              */
             if (MysqlDS != null) {
                     return MysqlDS;
             }
             
             try {
                     
                     /**
                      * This only needs to run one time to get the database object.
                      * context is used to lookup the database object in server
                      */
                     if (context == null) {
                             context = new InitialContext();
                     }
                     
                     MysqlDS = (DataSource) context.lookup("MysqlDS");//In server configurations use same JNDI name for Data Source.
                     
             }
             catch (Exception e) {
                     e.printStackTrace();
             }
             
             return MysqlDS;
             
     }
     
     /**
      * This method will return the connection to the MySql schema
      * Scope is protected which means only java class in the
      * dao package can use this method.
      * 
      * @return Connection to MySql database.
      */
     protected static Connection mySqlTasksConnection() {
             Connection conn = null;
             try {
                     conn = MySqlConn().getConnection();
                     return conn;
             } 
             catch (Exception e) {
                     e.printStackTrace();
             }
             return conn;
     }

}
