package com.velocity.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Questions {
// For Ajinkya-
//	1.	Store the 10 multiple choice questions related to java into database with correct answer.
//	2.	Out of these, user should able to presented random questions.
//	3.	One question has four options only.
//	4.	User will choose the answers.
	
	ArrayList<String> al = new ArrayList<String>();
	ArrayList<String> al1 = new ArrayList<String>();
	
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
				al1.add(res.getString(7));
			}
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int calculateScore() {
		
		Iterator<String> itr = al.iterator();
		Iterator<String> itr1 = al1.iterator();
		int score = 0;
		while(itr.hasNext()) {
			itr1.hasNext();
			String s1 = itr.next();
			String s2 = itr1.next();
			if(s1.equals(s2)) {
				score = score + 1;
			}
		}
		return score;
	}
		public String calculateGrade() {
		int score = calculateScore();
		String grade = "";
		
		switch(score) {
			case 10:
				grade = "A";
				break;
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "A";
				break;
			case 7:
				grade = "B";
				break;
			case 6:
				grade = "B";
				break;
			case 5:
				grade = "C";
				break;
			default:
				grade = "Fail";
		}
		
		return grade;
	}
	}
