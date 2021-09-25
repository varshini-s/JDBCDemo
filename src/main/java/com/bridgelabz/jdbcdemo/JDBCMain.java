package com.bridgelabz.jdbcdemo;

import java.sql.Driver;
import java.sql.Connection;

import java.sql.DriverManager;
import java.util.Enumeration;


public class JDBCMain 
{


	public static void main(String[] args) {

		String jdbcURL ="jdbc:mysql://localhost:3306/payroll_service?allowPublicKeyRetrieval=true&useSSL=false";
		String username="root";
		String password="Demo@1234";
		Connection connection;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!!!");
		}
		catch(ClassNotFoundException e)
		{
			throw new IllegalStateException("Cannot find driver in classpath ",e) ;
		}

		listDrivers();
		
		try 
		{
			
			System.out.println("Connecting to database"+jdbcURL);
			connection=DriverManager.getConnection(jdbcURL,username,password);
			System.out.println("Connection is successfull!!"+connection);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static void listDrivers() 
	{
		Enumeration<Driver> driverList =DriverManager.getDrivers();
		while(driverList.hasMoreElements())
		{
			Driver driverClass= (Driver)driverList.nextElement();
			System.out.println(" "+driverClass.getClass().getName());
			
		}
		
	}
	
	
	
}
