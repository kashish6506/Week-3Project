package Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import CourseRegistration.Course;
import CourseRegistration.Student;
import Services.CRSApp;
import Services.StudentServices;

public class StudentServices {

	private static PreparedStatement pstmt;
	private static ResultSet resultset;
	private static int sid;
	private static ResultSet res;

	public StudentServices(int sid) {
		this.sid = sid;

	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public static void studmenu() {
		System.out.println("- Student Portal -\n");
		System.out.println("Select Option:");
		System.out.println("1. Get Scores\n"
				+ "2. Get Marks Card\n"
				//				+ "3. View Details\n"
				+ "3. Change Course\n"
				+ "4. Back to Main\n"
				+ "5. Back to manage page\n"
				+ "6. Exit\n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch (n) {
		case 1: {
			show_marks();
			break;

		}
		case 2:{

			getMarkCard();
			break;
		}

		case 3: {
			changeCourse();
			break;
		}
		case 4: {
			studmenu();
			break;
		}
		case 5: {
			CRSApp.manage();
			break;
		}
		case 6: {
			System.exit(0);
			break;
		}
		default:
			System.err.println("Invalid Data....");
			break;
		}
	}



	public static void changeCourse() {
		CRSApp.sleep(3000);
		try {
			Scanner sc = new Scanner(System.in);
		
			System.out.println("Change your course here:");
			
			String sqll = "update course set cname = ? where cid=?";
			pstmt = CRSApp.con.prepareStatement(sqll);
			System.out.println("Enter the course name you want to enroll");
			pstmt.setString(1, sc.next());
			System.out.println("Enter Id:");
			pstmt.setInt(2, sc.nextInt());
//			res=pstmt.executeQuery();
			
			int x =pstmt.executeUpdate();
			
//			
			if(x>0) {
				System.out.println("Student Course Changed......");
				System.out.println("----------------------------------------------");
			}
			else {
				System.out.println(" Student Course not Changed......");
				System.out.println("----------------------------------------------");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		studmenu();
		

		}

		public static void getMarkCard() {
			CRSApp.sleep(3000);

			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\nEnter the user_name:");
				String user_name = sc.next();
				System.out.println("Enter the password:");
				String password = sc.next();
				String sql = "select * from student where user_name=? and password=?";
				//		

				PreparedStatement ps = CRSApp.con.prepareStatement(sql);
				ps.setString(1, user_name);
				ps.setString(2, password);

				ResultSet rs = ps.executeQuery();

				if (rs.next() == true) {
					System.out.println("Login Successfully............");
				}
				else{
					System.out.println("Invalid Credentials...........");
				}



				System.out.println("\n You want your Mark Card(Y/N) ");

				String ans = sc.next();
				if(ans.equals("y")) {


					//			
					String sql1=" select student.sname,student.sid,student.cid,score.quizz,score.assignment,score.projects,score.finals from student join score on student.sid = score.stud_id where sid=? order by student.sname";
					pstmt = CRSApp.con.prepareStatement(sql1);
					System.out.println("Enter Id:");
					pstmt.setInt(1, sc.nextInt());
					res=pstmt.executeQuery();


					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("\n\t\t\t\t\tMark Card\n\n");
					System.out.println();
					System.out.println();
					System.out.println("Student Name\t\tStudent-ID\t\tCourse-ID\t\t Quizz\t\tAssignments\t\tProjects\t\tFinals");

					while(res.next()==true) {
						String sname = res.getString("sname");
						int sid = res.getInt("sid");
						int cid = res.getInt("cid");
						int quizz = res.getInt("quizz");
						int assignment = res.getInt("assignment");
						//						
						int projects = res.getInt("projects");
						int finals = res.getInt("finals");

						System.out.println(sname +"\t\t\t"+ sid + "\t\t\t"+ cid + "\t\t\t"+ quizz + "\t\t\t"+ assignment + "\t\t\t" + projects
								+ "\t\t\t" + finals);

						System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					}
				}
				else if(ans.equals("n")) {
					System.out.println("Do you want to go the management : y/n");
					ans=sc.next();
					if(ans.equals("y")) {
						CRSApp.manage();
					}
					else if(ans.equals("n")){
						System.out.println("\ngo to menu");
						AdminServices.menu();
					}
				}
			}



			catch (Exception e) {
				e.printStackTrace();
			}

			studmenu();

		}


		public static void show_marks() {
			Scanner sc=new Scanner(System.in);
			try {
				System.out.println("Enter student id");
				sid = sc.nextInt();
				StudentServices ps = new StudentServices(sid);
				String sql1="select Sname from student where sid=?";
				pstmt = CRSApp.con.prepareStatement(sql1);
				pstmt.setInt(1, ps.getSid());
				resultset=pstmt.executeQuery();
				while(resultset.next()==true) {
					System.out.print("Name of the student:");
					System.out.println( resultset.getString("sname"));
				}
				String sql2="select * from score where stud_id=?";
				pstmt = CRSApp.con.prepareStatement(sql2);
				pstmt.setInt(1, StudentServices.getSid());
				resultset=pstmt.executeQuery();
				while(resultset.next()==true) {
					System.out.println("Marks of the student....");
					System.out.println("-------------------------");
					System.out.print("Student Id:");
					System.out.println( resultset.getInt("stud_id"));
					System.out.println("--------------------------");
					System.out.print("Quizz:");
					System.out.println( resultset.getInt("quizz"));
					System.out.println("-------------------------");
					System.out.print("Assignments:");
					System.out.println( resultset.getInt("assignment"));
					System.out.println("------------------------------");
					System.out.print("Projects:");
					System.out.println( resultset.getInt("projects"));
					System.out.println("------------------------------");
					System.out.print("Finals:");
					System.out.println( resultset.getInt("finals"));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			studmenu();
		}

		public static int getSid() {
			return sid;
		}



	}




