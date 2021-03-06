package forms;

import main.PSDSingleton;
import main.RoundCounter;

public class AYNEmployee {

	private String name;
	private String department;
	private boolean multiSkilled;
	private int time1, time2, totTime;
	private double wage, hiringCosts, firingCosts;
	private int roundCount = RoundCounter.getInstance().getRoundCounter();

	public AYNEmployee(String name, String department, boolean multiSkilled, int time1, int time2, int totTime,
			Double wage, int roundCount) {
		this.name = name;
		this.department = department;
		this.multiSkilled = multiSkilled;
		this.time1 = time1;
		this.time2 = time2;
		this.totTime = totTime;
		this.wage = wage;
		this.roundCount = roundCount;
	}

	public AYNEmployee() {
		name = "";
		department = "";
		time1 = 0;
		time2 = 0;
		multiSkilled = false;
	}

	public String getDepartmentWithoutBreak() {
		String dep = this.department;

		dep = dep.replace("\n", "");
		dep = dep.replace(System.getProperty("line.separator"), "");
		dep = dep.replaceAll("\\r|\\n", "");

		return dep;
	}

	// calculate wage
	public Double calcWage() {
		if (multiSkilled) {
			wage = PSDSingleton.getInstance().getEmployeeWage("AYN employee multiskilled");
		} else {
			wage = PSDSingleton.getInstance().getEmployeeWage("AYN employee");
		}
		firingCosts = PSDSingleton.getInstance().getFiringCost();
		hiringCosts = PSDSingleton.getInstance().getHiringCost();
		double totalCost = (wage * totTime) + firingCosts + hiringCosts;

		return totalCost;
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

	public double getWage() {
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

	public void setWage(double wage) {
		this.wage = wage;
	}

	public int getRoundCount() {
		return roundCount;
	}

	public void setRoundCount(int roundCount) {
		this.roundCount = roundCount;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		// convert to appropriate string output
		String department = "";
		for (int i = 0, n = getDepartment().length(); i < n; i++) {
			if (getDepartment().charAt(i) == '\n') {
				department += ' ';
			} else {
				department += getDepartment().charAt(i);
			}
		}
		s.append(getName());
		s.append(",");
		s.append(department);
		s.append(",");
		s.append(getMultiSkilled());
		s.append(",");
		s.append(getTime1());
		s.append(",");
		s.append(getTime2());
		s.append(",");
		s.append(getTotTime());
		s.append(",");
		s.append(getWage());
		return s.toString();

	}
}
