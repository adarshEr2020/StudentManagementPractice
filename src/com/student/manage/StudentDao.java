package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudentToDB(Student student) {
		boolean flag = false;
		try {
			// JDBC code...
			Connection connection = ConnectionGenerator.createConnection();
			String query = "INSERT INTO students(student_name,student_phone,student_city) VALUES(?,?,?)";

			// PreparedStatement
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set the value of parameter
			pstmt.setString(1, student.getStudentName());
			pstmt.setString(2, student.getStudentPhone());
			pstmt.setString(3, student.getStudentCity());

			// execute
			pstmt.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteStudent(int studentId) {
		boolean flag = false;
		try {
			// JDBC code...
			Connection connection = ConnectionGenerator.createConnection();
			String query = "DELETE FROM students WHERE student_id = ?";

			// PreparedStatement
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set the value of parameter
			pstmt.setInt(1, studentId);

			// execute
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;

	}

	public static boolean updateStudentToDB(Student student) {
		boolean flag = false;
		try {
			// JDBC code...
			Connection connection = ConnectionGenerator.createConnection();
			String query = "UPDATE students SET student_name = ?,student_phone = ?,student_city = ? where student_id =?";

			// PreparedStatement
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set the value of parameter
			pstmt.setString(1, student.getStudentName());
			pstmt.setString(2, student.getStudentPhone());
			pstmt.setString(3, student.getStudentCity());
			pstmt.setInt(4, student.getStudentId());
			
			// execute
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void showAllStudent() {
		try {
			// JDBC code...
			Connection connection = ConnectionGenerator.createConnection();
			String query = "SELECT * FROM students;";
			Statement stmt = connection.createStatement();

			ResultSet set = stmt.executeQuery(query);

			while (set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);

				System.out.println("Student ID :" + id);
				System.out.println("Student Name :" + name);
				System.out.println("Student phone :" + phone);
				System.out.println("Student City :" + city);
				System.out.println("++++++++++++++++++++++++++++++");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean updateStudentNameToDB(Student student) {
		boolean flag = false;
		try {
			// JDBC code...
			Connection connection = ConnectionGenerator.createConnection();
			String query = "UPDATE students SET student_name = ? where student_id =?";

			// PreparedStatement
			PreparedStatement pstmt = connection.prepareStatement(query);

			// Set the value of parameter
			pstmt.setString(1, student.getStudentName());
			pstmt.setInt(2, student.getStudentId());
			
			// execute
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
