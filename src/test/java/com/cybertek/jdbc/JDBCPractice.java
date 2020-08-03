package com.cybertek.jdbc;

import org.junit.Test;

import java.sql.*;

public class JDBCPractice {
    private final String DB_URL ="jdbc:oracle:thin:@52.71.242.164:1521:XE";
    private final String DB_USER="hr";
    private final String DB_PASSWORD="hr";

     @Test
    public void testDBConnection() throws SQLException {
        Connection connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM EMPLOYEES");

        while(resultSet.next()){
            System.out.println(resultSet.getString("first_name"));
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
   @Test
    public void getDataAsTable() throws SQLException {
        Connection connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("SELECT * FROM EMPLOYEES");

        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        int columnCount=resultSetMetaData.getColumnCount();

        while(resultSet.next()){
            for(int column=1; column<= columnCount; column++){
                System.out.println(resultSet.getString(column) + " ");
            }
            System.out.println();
        }
        resultSet.close();
        statement.close();
        connection.close();
    }




}
