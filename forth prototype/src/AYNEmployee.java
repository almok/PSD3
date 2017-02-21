public class AYNEmployee {

	
	private String name;
	private String department;
	private boolean multiSkilled;
	private int time1, time2, totTime;
	private float wage;
	
	
	public AYNEmployee () {
		name = "";
		department = "";
		time1 = 0;
		time2 = 0;
	}
	
	// getters and setters
	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public boolean getMultiSkilled() {
		return multiSkilled;
	}

	public int getTime1() {
		return time1;
	}

	public int getTime2() {
		return time2;
	}
	
	public int getTotTime() {
		return totTime;
	}
	
	public float getWage() {
		return wage;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setMultiSkilled(boolean multiSkilled) {
		this.multiSkilled = multiSkilled;
	}

	public void setTime1(int time1) {
		this.time1 = time1;
	}

	public void setTime2(int time2) {
		this.time2 = time2;
	}
	
	public void setTotTime(int totTime) {
		this.totTime = totTime;
	}
	
	public void setWage(float wage) {
		this.wage = wage;
	}
}
