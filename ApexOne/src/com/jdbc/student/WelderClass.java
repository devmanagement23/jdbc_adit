package com.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class WelderClass {

	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);

	private void insertRecord() throws SQLException {
		System.out.println("inside insert record function");

		String sql = "insert into student(name,percentage ,address) "
				                + "values ('Raj',88,'Mumbai')";
		

		PreparedStatement ps = connection.prepareStatement(sql);
		
		int rows = ps.executeUpdate();

		if (rows > 0) {
			System.out.println("Record inserted successfully");
		}
	}

	public static void main(String[] args) {

		System.out.println("working");

		WelderClass welderclass = new WelderClass();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String dbURL = "jdbc:mysql://localhost:3301/jdbcdemo1";
			String userName = "root";
			String password = "root";

			connection = DriverManager.getConnection(dbURL, userName, password);

			System.out.println("Enter choice");
			System.out.println("1.Insert record");
			System.out.println("2.Check record");
			System.out.println("3.Delete record");
			System.out.println("4.Update record\n");
			

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				welderclass.insertRecord();
				break;

			case 2:
				break;

			default:
				break;

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}

//cmd command - show global variables like 'PORT';
