package Services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Services.CRSApp;
import Services.AdminServices;
import Services.ProfessorServices;
import CourseRegistration.Professor;
import CourseRegistration.Student;
import CourseRegistration.Course;


public class ProfessorServices {

	public static Connection con;
	public static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet ResultSet;
	private static java.sql.ResultSet res;
	private static java.sql.ResultSet resultset;
	static String check;
	static int stud_id;
//	static int marks;
//	static int stud_id;
	static int quizz;
	static int assignment;
	static int projects;
	static int finals;



	public ProfessorServices(int stud_id2, int quizz2, int assignment2, int projects2, int finals2) {
		// TODO Auto-generated constructor stub
	}

	public static int getStud_id() {
		return stud_id;
	}

	public static void setStud_id(int stud_id) {
		ProfessorServices.stud_id = stud_id;
	}

	public static int getQuizz() {
		return quizz;
	}

	public static void setQuizz(int quizz) {
		ProfessorServices.quizz = quizz;
	}

	public static int getAssignment() {
		return assignment;
	}

	public static void setAssignment(int assignment) {
		ProfessorServices.assignment = assignment;
	}

	public static int getProjects() {
		return projects;
	}

	public static void setProjects(int projects) {
		ProfessorServices.projects = projects;
	}

	public static int getFinals() {
		return finals;
	}

	public static void setFinals(int finals) {
		ProfessorServices.finals = finals;
	}
	

	public static void profmenu() {

		System.out.println("Select Option:");
		System.out.println("1. Grade Student\n"
				+ "2. View Alloted Student\n"
				+ "3. View Alloted Course Details\n"
				+ "4.Change Course\n"
				+"5. Back to manage menu \n"
				+ "0. Exit\n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch (n) {
		case 1: {
			grade_Student();
			break;

		}
		case 2:{
			viewStudent();
			break;
		}
		case 3:{
			viewDetails();
			break;
		}
		case 4:{
			changeCourse();
			break;
		}
		case 5:{
			CRSApp.manage();
			break;
		}
		case 0: {
			System.exit(0);
		}
		default:{
			System.err.println("enter a valid input");
			break;

		}
		}

	}

	public static void changeCourse() {
		CRSApp.sleep(3000);
		try {
			Scanner sc = new Scanner(System.in);
		
			System.out.println("Change your course here:");
			
			String sqll = "update professor set column_id = ? where pid=?";
			pstmt = CRSApp.con.prepareStatement(sqll);
			System.out.println("Enter the course-ID you want to teach:");
			pstmt.setInt(1, sc.nextInt());
			System.out.println("Enter Id:");
			pstmt.setInt(2, sc.nextInt());
//			res=pstmt.executeQuery();
			
			int x =pstmt.executeUpdate();
			
//			
			if(x>0) {
				System.out.println("Professor Course Changed......");
				System.out.println("----------------------------------------------");
			}
			else {
				System.out.println(" Professor Course not Changed......");
				System.out.println("----------------------------------------------");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void viewDetails() {

		Scanner sc = new Scanner(System.in);
		System.out.println("View the Details of the Courses in which you are assigned:");

		

		try {
			//				

			String sql = "select professor.pid,professor.pname,course.cid,course.cname,course.fees,course.dur_months from professor join course on professor.column_id=course.cid where pid=? order by pname";

			pstmt=CRSApp.con.prepareStatement(sql);


			System.out.println("Enter the Professor ID :");
			pstmt.setInt(1, sc.nextInt());

			res = pstmt.executeQuery();


			System.out.println("Professor Id\t\tProfessor Name\t\tCourse Id\t\tCourse Name\t\tFees\t\tDuration");

			while(res.next()==true) {
				int pid = res.getInt("pid");
				String pname = res.getString("pname");
				int cid = res.getInt("cid");
				String cname = res.getString("cname");
				int fees = res.getInt("fees");
				int dur_months = res.getInt("dur_months");

				System.out.println(pid + "\t\t\t"+ pname + "\t\t\t"+ cid + "\t\t\t" + cname
						+ "\t\t\t" + fees+ "\t\t" +dur_months);

				System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	profmenu();


}

public static void viewStudent() {
	Scanner sc = new Scanner(System.in);
	System.out.println("View the Details of the Students who will be in your Course:");

	

	try {
		//				

		String sql = "select student.sid,student.sname,student.email,course.cid,course.cname,course.fees,course.dur_months from student join course on student.cid=course.cid where sid=? order by sname";

		pstmt=CRSApp.con.prepareStatement(sql);


		System.out.println("Enter the Student ID :");
		pstmt.setInt(1, sc.nextInt());

		res = pstmt.executeQuery();


		System.out.println("Student Id\t\tStudent Name\t\tEmail\t\tCourse Id\t\tCourse Name\t\tFees\t\tDuration");

		while(res.next()==true) {
			int sid = res.getInt("sid");
			String sname = res.getString("sname");
			String email = res.getString("email");
			int cid = res.getInt("cid");
			String cname = res.getString("cname");
			int fees = res.getInt("fees");
			int dur_months = res.getInt("dur_months");

			System.out.println(sid + "\t\t\t"+ sname + "\t\t\t"+email+ " \t"+ cid + "\t\t" + cname
					+ "\t\t" + fees+ "\t\t" +dur_months);

			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
		}

	}
	catch (Exception e) {
		e.printStackTrace();
	}

profmenu();



}

public static void grade_Student(){

	// Professor p = new Professor(1, "mudu",5);int pid, String pname, int exp\
	try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Add student marks");
		System.out.println("Enter student id");
		stud_id = sc.nextInt();
		System.out.println("Enter student Quizz marks");
		quizz = sc.nextInt();
		System.out.println("Enter student Assignment marks");
		assignment = sc.nextInt();
		System.out.println("Enter student Projects marks");
		projects = sc.nextInt();
		System.out.println("Enter student finals marks");
		finals = sc.nextInt();
		ProfessorServices ps = new ProfessorServices(stud_id,quizz,assignment,projects,finals);
		String sql = "insert into score values(?,?,?,?,?)";
		pstmt = CRSApp.con.prepareStatement(sql);
		pstmt.setInt(1, ps.getStud_id());
		pstmt.setInt(2, ps.getQuizz());
		pstmt.setInt(3, ps.getAssignment());
		pstmt.setInt(4, ps.getProjects());
		pstmt.setInt(5, ps.getFinals());


		int x = pstmt.executeUpdate();
		if (x > 0) {
			String sql1="select Sname from student where sid=?";
			pstmt = CRSApp.con.prepareStatement(sql1);
			pstmt.setInt(1, ps.getStud_id());
			resultset=pstmt.executeQuery();
			while(resultset.next()==true) {
				System.out.println( resultset.getString("sname")+" student marks Added------------ :");
			}

		}



		System.out.println("\n\t\tstudent marks Added Successfully...");
//		System.out.println("\n----------------------------------------\n");
		System.out.println("Do you want to grade more student : y/n");
		check=sc.next();
		if(check.equals("y")) {
			grade_Student();
		}
		else if(check.equals("n")){
			System.out.println("Do you want to go the management : y/n");
			check=sc.next();
			if(check.equals("y")) {
				CRSApp.manage();
			}
			else if(check.equals("n")){
				System.out.println("\ngo to menu");
				AdminServices.menu();
			}
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}


} 





}


