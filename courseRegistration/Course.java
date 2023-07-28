package CourseRegistration;

public class Course {

	public  static int cid;
	String cname;
	int fees;
	int dur_months;
	
	public Course(int cid, String cname, int fees, int dur_months) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.fees = fees;
		this.dur_months = dur_months;
		
	}

	public static int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public int getDur_months() {
		return dur_months;
	}

	public void setDur_months(int dur_months) {
		this.dur_months = dur_months;
	}
	
}

