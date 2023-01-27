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
//	5.	Also ability to store the multiple student score into database.

	Connection con = null;
	PreparedStatement pstmt = null;
	
	public void storeDataIntoDB(int Id, String name, int score, String grade) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions","root","root");
			pstmt = con.prepareStatement("insert into user_input(Id, Name, Score, Grade)values(?,?,?,?)");
			pstmt.setInt(1, Id);
			pstmt.setString(2, name);
			pstmt.setInt(3, score);
			pstmt.setString(4, grade);
			int i = pstmt.executeUpdate();
			System.out.println("Data added into DB for.."+1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
public void retrieveDataFromDB() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questions", "root", "root");
			pstmt = con.prepareStatement("select * from user_input order by Score DESC");
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3)+" "+res.getString(4));
			}
			
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}