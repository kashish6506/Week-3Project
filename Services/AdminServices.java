package Services;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;



import CourseRegistration.Course;


public class AdminServices {


//	public static Connection con;
	public static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet ResultSet;

	public static void menu() {
		// TODO Auto-generated method stub
		System.out.println("Select Option:");
		System.out.println("1. Add course\n"
				+ "2. Add Student\n"
				+ "3. Add Professor\n"
				+ "4. Remove Course\n"
				+ "5. Remove Professor\n"
				+ "6. Remove Student\n"
				+ "7. View All Students\n"
				+ "8. View All Courses\n"
				+ "9. View All Professors\n"
				+ "10.View All Users\n"
				+ "0. Exit\n"
				+ "11.Back to main menu\n"
				+ "12.Back to manage menu");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch (n) {
		case 1: {
			addCourse();
			break;

		}
		case 2:{
			addStudent();
			break;
		}
		case 3:{
			addProfessor();
			break;
		}
		case 4: {
			removeCourse();
			break;
		}
		case 5: {
			removeProfessor();
			break;
		}
		case 6: {
			removeStudent();
			break;
		}
		case 7: {
			viewAllStudents();
			break;
		}
		case 8: {
			viewAllCourses();
			break;
		}
		case 9: {
			viewAllProfessors();
			break;
		}
		case 10: {
			viewAllUsers();
			break;
		}
		case 0: {
			System.exit(0);
		}
		case 11: {
			menu();
			break;
		}
		case 12: {
			CRSApp.manage();
			break;
		}
		
		default:{
			System.err.println("enter a valid input");
			break;
		}
		}
	}

	public static void viewAllUsers() {
		
		try {
			

				String sql = "Select * from Users";
				stmt = CRSApp.con.createStatement();
				ResultSet = stmt.executeQuery(sql);
				 System.out.println("Name\t\tPassword");

				while(ResultSet.next()) {
					String user_name = ResultSet.getString("user_name");
	                String password = ResultSet.getString("password");
	                
	                
	                
	                System.out.println(user_name + "\t\t" + password);
					
					System.out.println("--------------------------------");
				}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		menu();
		

	}

	public static void viewAllCourses() {
		
		try {
			

				String sql = "Select * from Course";
				stmt = CRSApp.con.createStatement();
				ResultSet = stmt.executeQuery(sql);
				 System.out.println("ID\t\tName\t\tFees\t\tDuration");

				while(ResultSet.next()) {
					int cid = ResultSet.getInt("cid");
	                String cname = ResultSet.getString("cname");
	                int fees = ResultSet.getInt("fees");
	                int dur_months = ResultSet.getInt("dur_months");
	                
	                
	                System.out.println(cid + "\t\t" + cname
	                                   + "\t\t" + fees + "\t\t" +dur_months);
					
					System.out.println("------------------------------------------------------");
				}
				
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		menu();

	}

	public static void viewAllProfessors() {
		
		try {
			

				String sql = "Select * from Professor";
				stmt = CRSApp.con.createStatement();
				ResultSet = stmt.executeQuery(sql);
				 System.out.println("ID\t\tName\t\tExperience");

				while(ResultSet.next()) {
					int sid = ResultSet.getInt("pid");
	                String sname = ResultSet.getString("pname");
	                String exp = ResultSet.getString("exp");
	                
	                System.out.println(sid + "\t\t" + sname
	                                   + "\t\t" + exp);
					
					System.out.println("-----------------------------------------------");
				}
				
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
		menu();

	}

	public static void viewAllStudents()  {
		
		try {
			

				String sql = "Select * from Student";
				stmt = CRSApp.con.createStatement();
				ResultSet = stmt.executeQuery(sql);
				 System.out.println("ID\t\tName\t\tEmail\t\t\tUser Name");

				while(ResultSet.next()) {
					int sid = ResultSet.getInt("sid");
	                String sname = ResultSet.getString("sname");
	                String email = ResultSet.getString("email");
	                String user_name = ResultSet.getString("user_name");
	                System.out.println(sid + "\t\t" + sname
	                                   + "\t\t" + email+ "\t\t" +user_name);
					
					System.out.println("----------------------------------------------------------------------");
				}
				
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		menu();

	}

	public static void removeStudent() {

		Scanner sc = new Scanner(System.in);
		System.out.println("How many Students you want to remove?");
		int n=sc.nextInt();

		while(n!=0) {
			try {
				//				
				String sql = "Delete from Student where sid=?";

				pstmt=CRSApp.con.prepareStatement(sql);

				System.out.println("Enter the Student ID:");
				pstmt.setInt(1, sc.nextInt());

				int x =pstmt.executeUpdate();
				//				
				if(x>0) {
					System.out.println("Student Removed...");
					System.out.println("----------------------------------------------");
				}
				else {
					System.out.println(" Student not Removed...");
					System.out.println("----------------------------------------------");
				}

			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			n--;
		}
		menu();
	}

	public static void removeProfessor() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Professors you want to remove?");
		int n=sc.nextInt();

		while(n!=0) {
			try {
				//				
				String sql = "Delete from Professor where pid=?";

				pstmt=CRSApp.con.prepareStatement(sql);

				System.out.println("Enter the Professor ID:");
				pstmt.setInt(1, sc.nextInt());

				int x =pstmt.executeUpdate();
				//				
				if(x>0) {
					System.out.println("Professor Removed...");
					System.out.println("----------------------------------------------");
				}
				else {
					System.out.println(" Professor not Removed...");
					System.out.println("----------------------------------------------");
				}

			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			n--;
		}
		menu();

	}

	public static void removeCourse() {

		Scanner sc = new Scanner(System.in);
		System.out.println("How many Course you want to remove?");
		int n=sc.nextInt();

		while(n!=0) {
			try {
				//				
				String sql = "Delete from Course where cid=?";

				pstmt=CRSApp.con.prepareStatement(sql);

				System.out.println("Enter the Course ID:");
				pstmt.setInt(1, sc.nextInt());

				int x =pstmt.executeUpdate();
				//				
				if(x>0) {
					System.out.println("Course Removed...");
					System.out.println("----------------------------------------------");
				}
				else {
					System.out.println(" Course not Removed...");
					System.out.println("----------------------------------------------");
				}

			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			n--;
		}
		menu();
	}

	public static void addProfessor() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Professor you want to enter?");
		int n=sc.nextInt();
		while(n!=0) {
			try {
				//				Student s = new Student()
				String sql = "Insert into Professor values(?,?,?,?,?,?)";

				pstmt=CRSApp.con.prepareStatement(sql);

				System.out.println("Enter the Professor ID:");
				pstmt.setInt(1, sc.nextInt());
				System.out.println("Enter the Professor Name:");
				pstmt.setString(2, sc.next());
				System.out.println("Enter the Professor Exp:");
				pstmt.setInt(3, sc.nextInt());
				System.out.println("Enter the Professor's Course-Id:");
				pstmt.setInt(4, sc.nextInt());
				System.out.println("Enter the Professor user_name:");
				pstmt.setString(5, sc.next());
				System.out.println("Enter the Professor password:");
				pstmt.setString(6, sc.next());


				int x =pstmt.executeUpdate();
				//				System.out.println("DaCreated");
				//				System.out.println("Table Created");
				if(x>0) {
					System.out.println("Professor Data Added...");
					System.out.println("----------------------------------------------");
				}
				else {
					System.out.println(" Professor Data Not Added...");
					System.out.println("----------------------------------------------");
				}

			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			n--;
		}
		menu();

	}

	public static void addStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Students you want to enter?");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			try {
				//				Student s = new Student()
				String sql = "Insert into Student values(?,?,?,?,?,?)";

				pstmt=CRSApp.con.prepareStatement(sql);

				System.out.println("Enter the Student ID:");
				pstmt.setInt(1, sc.nextInt());
				System.out.println("Enter the Student Name:");
				pstmt.setString(2, sc.next());
				System.out.println("Enter the Student Email:");
				pstmt.setString(3, sc.next());
				System.out.println("Enter the Student user_name:");
				pstmt.setString(4, sc.next());
				System.out.println("Enter the Student password:");
				pstmt.setString(5, sc.next());
				System.out.println("Enter the Student's Course-Id:");
				pstmt.setInt(6, sc.nextInt());
				

				int x =pstmt.executeUpdate();
				//				System.out.println("DaCreated");
				//				System.out.println("Table Created");
				if(x>0) {
					System.out.println("Student Data Added...");
					System.out.println("----------------------------------------------");
				}
				else {
					System.out.println(" Student Data Not Added...");
					System.out.println("----------------------------------------------");
				}

			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		menu();

	}

	public static void addCourse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Course you want to register?");
		int n=sc.nextInt();
		while(n!=0) {
			try {
				//				Student s = new Student()
				String sql = "Insert into Course values(?,?,?,?)";

				pstmt=CRSApp.con.prepareStatement(sql);

				System.out.println("Enter the Course ID:");
				pstmt.setInt(1, sc.nextInt());
				System.out.println("Enter the Course Name:");
				pstmt.setString(2, sc.next());
				System.out.println("Enter the Course Fees:");
				pstmt.setInt(3, sc.nextInt());
				System.out.println("Enter the Course Duration:");
				pstmt.setInt(4, sc.nextInt());



				int x =pstmt.executeUpdate();
				//				System.out.println("DaCreated");
				//				System.out.println("Table Created");
				if(x>0) {
					System.out.println("Course Data Added...");
					System.out.println("----------------------------------------------");
				}
				else {
					System.out.println(" Course Data Not Added...");
					System.out.println("----------------------------------------------");
				}

			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			n--;
		}
		menu();
	}
}
