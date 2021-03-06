package forms;

public class Employee {

	private String name;
	private String department;
	private float wage;

	public Employee() {
		name = "";
		department = "";
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
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

	public void setWage(float wage) {
		this.wage = wage;
	}
}
