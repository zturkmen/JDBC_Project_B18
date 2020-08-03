package com.cybertek.jdbc.day1;

import java.sql.*;

public class DB_Connection {

    public static void main(String[] args) throws SQLException {


        String connectionStr = "jdbc:oracle:thin:@3.90.47.254:1521:XE";
        String username="hr";
        String password="hr";
        Connection conn = DriverManager.getConnection(connectionStr,username,password);   // for connections


        Statement stmnt=conn.createStatement();  // write the statement

        ResultSet rs= stmnt.executeQuery("SELECT * FROM REGIONS");
        rs.next();

        System.out.println("THE END");
    }

}
