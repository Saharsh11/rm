package com.dao;

import java.sql.*;

public class DButil {
	private static Connection conn=null;
	
	public static Connection getMyConnection(){
		System.out.println("Establishing connection... ");
		if(conn==null){
			try {
				System.out.println("Trying new connection... ");
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				String url="jdbc:oracle:thin:@10.232.71.29:1521:INATP02";
//				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				conn=DriverManager.getConnection(url,"shobana","shobana");
//				conn=DriverManager.getConnection(url,"SYSTEM","saharsh123");
				System.out.println("new connection established ...! ");
			} catch (SQLException e) {
				System.out.println("No connection established...?? ");
				//e.printStackTrace();
			}
		}
		return conn;
	}
}
