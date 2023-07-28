package Services;



import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import Services.AdminServices;
import Services.ProfessorServices;
import Services.StudentServices;

import CourseRegistration.ProfessorLogin;
import CourseRegistration.Users;
import CourseRegistration.Student;
import CourseRegistration.Professor;
import CourseRegistration.StudentLogin;



public class CRSApp {
//	
	
	public static Connection con;
	public static void sleep(int val) {
		try {
			System.out.println("Please Wait....\n");
			Thread.sleep(val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void manage(){
		System.out.println("Select the Type of User:");
		System.out.println("1. Admin\n"
				+ "2. Professor\n"
				+ "3. Student\n");
//		System.out.println("Enter number jo aapko karna hai");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch (n) {
		case 1: {
			while(true) {
			boolean b = Users.login();
			sleep(3000);
			if(b==true) {
				System.out.println("Login Successful...\n");
				System.out.println("------------------------------------");
				AdminServices adsrv = new AdminServices();
				adsrv.menu();
				break;
			}
			else {
				System.err.println("Invalid......\n");
				System.out.println("Enter again");
				
			}
			}
		}
		case 2:{
			while(true) {
				boolean b = ProfessorLogin.login();
				sleep(3000);
				if(b==true) {
					System.out.println("Login Successful...\n");
					System.out.println("------------------------------------");
//					ProfessorServices prsrv = new ProfessorServices(n, n);
					ProfessorServices.profmenu();
					break;
				}
				else {
					System.err.println("Invalid......\n");
					System.out.println("Enter again");
					
				}
				}
			
		}
		case 3:{
			while(true) {
				boolean b = StudentLogin.login();
				sleep(3000);
				if(b==true) {
					System.out.println("Login Successful...\n");
					System.out.println("------------------------------------");
//					ProfessorServices prsrv = new ProfessorServices(n, n);
					StudentServices.studmenu();
					break;
				}
				else {
					System.err.println("Invalid......\n");
					System.out.println("Enter again");
					
				}
				}
			
			
		}
		}
	}
	public static void main(String[] args) throws Exception{

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
		String url = "jdbc:mysql://localhost:3306/crs";

		String user = "root";
		String pwd  = "root";
		// Step:2
		con = DriverManager.getConnection(url, user, pwd);
		manage();
		
		
	}
}

