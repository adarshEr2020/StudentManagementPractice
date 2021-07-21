package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to student management app:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Enter 1 to ADD student :");
			System.out.println("Enter 2 to Delete student :");
			System.out.println("Enter 3 to Update student :");
			System.out.println("Enter 4 to Display student :");
			System.out.println("Enter 5 to Exit app :");
			System.out.println("Enter 6 to update perticular details of student :");

			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				// Add student
				System.out.println("Enter student name :");
				String name = br.readLine();

				System.out.println("Enter student phone :");
				String phone = br.readLine();

				System.out.println("Enter student city :");
				String city = br.readLine();

				// Create student object to store student
				Student student = new Student(name, phone, city);
				boolean answer = StudentDao.insertStudentToDB(student);

				if (answer) {
					System.out.println("Student is successfully added...");
				} else {
					System.out.println("Someting went wrong try again...");
				}

				System.out.println(student);
				break;
			case 2:
				// Delete student
				System.out.println("Enter student id to delete:");
				int studentId = Integer.parseInt(br.readLine());
				answer = StudentDao.deleteStudent(studentId);
				if (answer) {
					System.out.println("Deleted....");
				} else {
					System.out.println("Someting went wrong try again...");
				}
				break;
			case 3:
				// Update student
				System.out.println("Enter student id to update:");
				studentId = Integer.parseInt(br.readLine());

				System.out.println("Enter student new name :");
				name = br.readLine();

				System.out.println("Enter student new phone :");
				phone = br.readLine();

				System.out.println("Enter student new city :");
				city = br.readLine();

				// Create student object to store student
				student = new Student(studentId, name, phone, city);
				answer = StudentDao.updateStudentToDB(student);

				if (answer) {
					System.out.println("Student is successfully updated...");
				} else {
					System.out.println("Someting went wrong try again...");
				}
				break;
			case 4:
				// Display student
				StudentDao.showAllStudent();
				break;

			case 5:
				// Exit
				break;

			case 6:
				// Update student
				System.out.println("Enter student id to update:");
				studentId = Integer.parseInt(br.readLine());

				while (true) {
					System.out.println("Enter 1 to update student name :");
					System.out.println("Enter 2 to update student phone :");
					System.out.println("Enter 3 to Update student city :");
					int input = Integer.parseInt(br.readLine());
					switch (input) {
					case 1:
						System.out.println("Enter new student name :");
						name = br.readLine();
						student = new Student(studentId, name);
						answer = StudentDao.updateStudentNameToDB(student);

						if (answer) {
							System.out.println("Student is successfully updated...");
						} else {
							System.out.println("Someting went wrong try again...");
						}
					default:
						System.out.println("You have entered wong ...");
						break;
					}
				}
			default:
				System.out.println("Entered wong ...");
				break;
			}
			System.out.println("Thankyou for using my application....");
			System.out.println("See you again...");
		}
	}
}
