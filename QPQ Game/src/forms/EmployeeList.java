package forms;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EmployeeList {

	private TextField name;
	private ComboBox<String> department;
	private ArrayList<String> departments = new ArrayList<>(
			Arrays.asList("Sales", "Production Planning", "Goods Receipt", "Floor Control", "Production", "Ledger",
					"Quality Assurance", "Finance", "Supplier", "Manager"));

	// constructor
	public EmployeeList(Employee emp) {

		name = new TextField();
		department = new ComboBox<>();
		department.setPromptText("Choose");
		department.setMinWidth(190);

		// add change listener to the name text box
		name.textProperty().addListener((observable, oldValue, newValue) -> {
			emp.setName(newValue);
		});

		// set department choices
		department.getItems().addAll(departments);
		department.setOnAction(e -> {
			emp.setDepartment(department.getSelectionModel().getSelectedItem());
		});
		department.setVisibleRowCount(departments.size() - 1);

	}

	// constructor for populating list with stored values
	public EmployeeList(Employee emp, String nameP, String departmentP) {
		
		name = new TextField(nameP);
		department = new ComboBox<>();
		department.getSelectionModel().select(departmentP);
		department.setPromptText("Choose");
		department.setMinWidth(190);

		// add change listener to the name text box
		name.textProperty().addListener((observable, oldValue, newValue) -> {
			emp.setName(newValue);
		});

		// set department choices
		department.getItems().addAll(departments);
		department.setOnAction(e -> {
			emp.setDepartment(department.getSelectionModel().getSelectedItem());
		});
		department.setVisibleRowCount(departments.size() - 1);

	}

	// getter and setter
	public TextField getName() {
		return name;
	}

	public String getNameAsString() {
		return name.getText();
	}

	public ComboBox<String> getDepartment() {
		return department;
	}

	public String getDepartmentName() {
		return department.getValue();
	}

	public void setName(TextField name) {
		this.name = name;
	}

	public void setDepartment(ComboBox<String> department) {
		this.department = department;
	}
}
