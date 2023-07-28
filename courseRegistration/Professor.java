package CourseRegistration;

public class Professor {
	public static int pid;
	String pname;
	int exp;
	public static String user_name;
	public static String password;
	public Professor(int pid, String pname, int exp ,String user_name,String password) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.exp = exp;
		this.user_name=user_name;
		this.password=password;
	}
	public static int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public static String getUser_name() {
		return user_name;
	}
	public static void setUser_name(String user_name) {
		Professor.user_name = user_name;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Professor.password = password;
	}
	
	
}
