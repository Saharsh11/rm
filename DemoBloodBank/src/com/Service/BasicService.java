package com.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BasicService {
	
	public static java.util.Date changeToUtilDate(String d){
		java.util.Date dt=null;
		try {
			dt=new SimpleDateFormat("yyyy-MM-dd").parse(d);
			System.out.println("Date is : "+ dt);
		} catch (ParseException e) {
			System.out.println("Can not change into Date !! ");
		}
		return dt;
	}
	
	public static java.sql.Date changeToSqlDate(String d){
		java.util.Date dt = changeToUtilDate(d);
		java.sql.Date dte= new java.sql.Date(dt.getTime());	
		return dte;
	}
}