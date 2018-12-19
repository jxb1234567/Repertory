package com.todo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class OpSqliteDB {
    
    private static final String Class_Name = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite::resource:app.db";

//    public static void main(String args[]) {
//        // load the sqlite-JDBC driver using the current class loader
//        Connection connection = null;
//        try {
//            connection = createConnection();
//            func1(connection);
//            System.out.println("Success!");
//        }  catch (SQLException e) {
//            System.err.println(e.getMessage());
//        } catch(Exception e) {
//            e.printStackTrace();
//        } finally{
//            try {
//                if (connection != null)
//                    connection.close();
//            } catch (SQLException e) {
//                // connection close failed.
//                System.err.println(e);
//            }
//        }
//    }
    
    // 创建Sqlite数据库连接
    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName(Class_Name);
        return DriverManager.getConnection(DB_URL);
    }

    public static ResultSet execQuerySql(String sql) throws SQLException {
    	Connection connection = null;
    	try {
			connection = createConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30); // set timeout to 30 sec.
        // 执行查询语句
        return statement.executeQuery(sql);
    }
    
    public static void execUpdateSql(String sql) throws SQLException {
    	Connection connection = null;
    	Statement statement = null;
    	try {
    		connection = createConnection();
    	
	    	statement = connection.createStatement();
	    	// 执行查询语句
	    	statement.executeUpdate(sql);
    	} catch (ClassNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}finally{
    		statement.close();
    		connection.close();
    	}
    }
}