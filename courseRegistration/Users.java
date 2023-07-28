package CourseRegistration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Services.CRSApp;



public class Users {
	static String user_name;
	static String password;
	private static PreparedStatement pstmt;
	private static ResultSet   res;
	
	public Users(String user_name, String password) {
		super();
		this.user_name = user_name;
		this.password = password;
	}

	public static String getUser_name() {
		return user_name;
	}

	public static void setUser_name(String user_name) {
		Users.user_name = user_name;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Users.password = password;
	}

	public static boolean login() {
		
		try {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the user_name:");
			user_name=sc.next();
			System.out.println("Enter the password:");
			password=sc.next();
			String sql = "select * from users where user_name=? and password=?";
			pstmt = CRSApp.con.prepareStatement(sql);
			pstmt.setString(1, user_name);
			pstmt.setString(2, password);
			res = pstmt.executeQuery();
			if(res!=null) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	
}
}
