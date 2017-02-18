public class AVNEmployee {

	
	private String name;
	private String department;
	private int startTime;
	private int stopTime;
	
	
	public AVNEmployee () {
		name = "";
		department = "";
		startTime = 0;
		stopTime = 0;
	}
	
	// getters and setters
	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getStopTime() {
		return stopTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public void setStopTime(int stopTime) {
		this.stopTime = stopTime;
	}
	
}
