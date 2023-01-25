package com.velocity.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Questions {
// For Ajinkya-
//	1.	Store the 10 multiple choice questions related to java into database with correct answer.
//	2.	Out of these, user should able to presented random questions.
//	3.	One question has four options only.
	ArrayList<String> al = new ArrayList<String>();
	
	public void getQuestionsFromDB() {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "root");
			PreparedStatement pstmt = con.prepareStatement("select * from quiz order by rand()");
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				
				System.out.println(res.getInt(1)+" "+res.getString(2));
				System.out.println(res.getString(3)+"  "+res.getString(4)+"  "+res.getString(5)+"  "+res.getString(6));
				System.out.println("Enter a option");
				String input = sc.next();
				al.add(input);
			}
			System.out.println(al);
			con.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Questions questions = new Questions();
		questions.getQuestionsFromDB();
	}
}
