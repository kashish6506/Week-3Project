package CourseRegistration;

public class Student {
	int sid;
	static String sname;
	static String email;
	public static String user_name;
	public static String password;
	static int cid;
	public Student(int sid, String sname, String email, String user_name, String password,int cid) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.email = email;
		this.user_name = user_name;
		this.password=password;
		this.cid=cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Student.password = password;
	}
	public static int getCid() {
		return cid;
	}
	public static void setCid(int cid) {
		Student.cid = cid;
	}
	
	
}
