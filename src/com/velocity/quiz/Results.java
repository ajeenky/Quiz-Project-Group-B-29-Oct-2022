package com.velocity.quiz;

import java.util.Scanner;

public class Results {
// For Akhilesh
//	6.	System will display the result- it means what is the score out of 10.
//	7.	Also display the marks as below
//	Class A- 8-10
//	Class B- 6-8
//	Class C- 5
//	Class D- <5 then its fail.
	int num; 
	
	public void flowOfProgram() {
		try {
			System.out.println("Welcome all to this Quiz...");
			Thread.sleep(1000);
			System.out.println("Please choose an correct answer from given 4 options...");
			Thread.sleep(1000);
			System.out.println("You just have choose from A, B, C & D.");
			Thread.sleep(1000);
			System.out.println(" ");
			System.out.println("All the best for your quiz...");
			Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Questions questions = new Questions();
			
			Scanner sc = new Scanner(System.in);
			
			do {
				questions.getQuestionsFromDB();
				questions.calculateScore();
				int score = questions.calculateScore();
				
				UserInput user = new UserInput();
				System.out.println(" ");
				System.out.println("Enter Student Id-->");
				int id = sc.nextInt();
				System.out.println("Enter Student Name-->");
				String name = sc.next();
				
				questions.calculateGrade();
				String grade = questions.calculateGrade();
				user.storeDataIntoDB(id, name, score, grade);
				System.out.println("Your score is --> "+score);
				System.out.println("Your grade is --> "+grade);
				System.out.println("Enter 1 for another quiz");
				System.out.println("Enter 0 for exit");
				int num = sc.nextInt();
		} while (num != 0);
			
				sc.close();
			
	}
}
