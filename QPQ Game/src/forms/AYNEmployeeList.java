package forms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import main.RoundCounter;

public class AYNEmployeeList {

	private ArrayList<AYNEmployee> employees;

	private static AYNEmployeeList instance = null;

	public static AYNEmployeeList getInstance() {
		if (instance == null) {
			instance = new AYNEmployeeList();
		}
		return instance;
	}

	public AYNEmployeeList() {
		employees = new ArrayList<>();
	}

	public ArrayList<AYNEmployee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<AYNEmployee> employees) {
		this.employees = employees;
	}

	// load employees from a file
	public void loadList(String filename) {

		FileReader fileRead;
		BufferedReader buffRead;
		String line;
		String[] stats;

		try {

			fileRead = new FileReader(filename);
			buffRead = new BufferedReader(fileRead);

			// read file
			while ((line = buffRead.readLine()) != null) {
				// split the lines into numbers
				stats = line.split(",");

				// convert to appropriate string input
				String department = "";
				for (int i = 0, n = stats[1].length(); i < n; i++) {
					if (stats[1].charAt(i) == ' ') {
						department += '\n';
					} else {
						department += stats[1].charAt(i);
					}
				}

				// assign the values
				AYNEmployee employee = new AYNEmployee(stats[0], department, Boolean.parseBoolean(stats[2]),
						Integer.parseInt(stats[3]), Integer.parseInt(stats[4]), Integer.parseInt(stats[5]),
						Double.parseDouble(stats[6]), RoundCounter.getInstance().getRoundCounter());

				// add a process to a collection of processes
				employees.add(employee);
			}
		} catch (IOException e) {
		}
	}

	// save employee list to a file
	public void toFile(String filename) {

		try {
			PrintWriter writer = new PrintWriter(filename, "UTF-8");

			for (int i = 0; i < employees.size(); i++) {
				writer.println(employees.get(i).toString());
			}

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
