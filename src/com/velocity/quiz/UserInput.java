package com.velocity.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

public class UserInput {
// For Akanksha
//	4.	User will choose thAe answers.

//	5.	Also ability to store the multiple student score into database.

		int result;
		Connection con = null;
		PreparedStatement pst = null;	
		public Connection getConnectiondetails(){
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions","root","root");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		public void getuserdetail(int id,String name,int score,String mark) {
			
			try {
				getConnectiondetails();
				pst = con.prepareStatement("insert into user_input(Id,Name,Score,Grade)values(?,?,?,?)");
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setInt(3,score);
	        	pst.setString(4, mark);
				int i=pst.executeUpdate();
				System.out.println("Record inset Successfully :: "+i);
			  
			} catch (Exception e) {
			e.printStackTrace();	
			}
		}
	   
		public static void main(String []args) {
		       
				
		        System.out.println(" *** Quize Started *** ");
		        Questions questions = new Questions();
		        questions.getQuestionsFromDB();
		        Scanner sc = new Scanner(System.in);
		        System.out.println("Enter you Id::");
		        int id =sc.nextInt();
		        System.out.println("Enter you Name::");
		        String name =sc.next();
		        int score =questions.result;
		        String mark=questions.grade;
		        UserInput user = new UserInput();
		        user.getuserdetail( id,name,score, mark);
}
}