package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password="2306Hb!!student";
		
		try {
			System.out.println("Starting conection");
			Connection myConn = DriverManager.getConnection(url, user, password);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
