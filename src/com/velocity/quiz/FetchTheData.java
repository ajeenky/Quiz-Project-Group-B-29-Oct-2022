package com.velocity.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FetchTheData {
// For Akash
//	8.	Display the list of student’s id, name with score into console as sorting order.
//	9.	To get the particular record by using student id only. If someone wants to retrieve theirs score from database.
        // 8 Done in UserInput Class
	
	public void getRecord() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "root");
			PreparedStatement statement = con.prepareStatement("select * from questions.user_input where id =  ?");
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the id to check the score");
			int stuId = sc.nextInt();
			statement.setInt(1, stuId);
			ResultSet res = statement.executeQuery();
			while(res.next()) {
				System.out.println("Id = " +stuId+ " Name = " +res.getString("Name")+ " Score = " +res.getInt("Score")+ " Grade = " +res.getString("Grade"));
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
