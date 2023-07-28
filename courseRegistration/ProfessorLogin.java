package CourseRegistration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Services.CRSApp;

public class ProfessorLogin {
	static String user_name;
	static String password;
	private static PreparedStatement pstmt;
	private static ResultSet res;

	public ProfessorLogin(String user_name, String password) {
		super();
		this.user_name = user_name;
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static boolean login() {
		try {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter the user_name:");
			user_name=sc.next();
			System.out.println("Enter the password:");
			password=sc.next();
			String sql = "select * from professor where user_name=? and password=?";
			pstmt = CRSApp.con.prepareStatement(sql);
			pstmt.setString(1, user_name);
			pstmt.setString(2, password);
			res = pstmt.executeQuery();
			//			if(user_name.equals("professor") && password.equals("professor")) {
			//				return true;
			//			}
			//			else {
			//				return false;
			//			}
			//		}
			//		catch (Exception e) {
			//			e.printStackTrace();
			//		}
			//		return false;
			if (res.next() == true) {
				return true;
			}

			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
