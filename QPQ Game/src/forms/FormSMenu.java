package forms;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.PSDSingleton;
import main.RoundCounter;

public class FormSMenu implements Initializable {

	RoundCounter roundCounter = RoundCounter.getInstance();
	int roundCount = roundCounter.getRoundCounter();

	private static FormSMenu instance = null;

	public static FormSMenu getInstance() {
		if (instance == null) {
			instance = new FormSMenu();
		}
		return instance;
	}

	@FXML
	private Button addButton, backButton, deleteButton;

	@FXML
	private TableView<EmployeeList> employeeTable;

	@FXML
	private TableColumn<EmployeeList, TextField> name;

	@FXML
	private TableColumn<EmployeeList, MenuButton> department;

	ObservableList<EmployeeList> employees = FXCollections.observableArrayList();

	// creates new employee
	@FXML
	public void createNewEmployee() {
		EmployeeList emp = new EmployeeList(new Employee());
		employees.add(emp);

	}

	@FXML
	public void deleteEmployee() {
		ArrayList<String[]> formSData = PSDSingleton.getInstance().getFormSData();
		ObservableList<EmployeeList> allEmployees;
		ObservableList<EmployeeList> selectedEmployees;

		allEmployees = employeeTable.getItems();
		selectedEmployees = employeeTable.getSelectionModel().getSelectedItems();

		// Remove from FormSData Singleton
		for (int i = 0; i < formSData.size(); i++) {
			if (formSData.get(i)[0].equals(selectedEmployees.get(0).getNameAsString())
					&& formSData.get(i)[1].equals(selectedEmployees.get(0).getDepartmentName())
					&& Integer.parseInt(formSData.get(i)[2]) == roundCount) {
				formSData.remove(i);
				break;
			}
		}

		// shorthand to remove selected
		selectedEmployees.forEach(allEmployees::remove);

	}

	public int countEmployees(ObservableList<EmployeeList> employees) {
		int numberEmployees = 0;
		for (int i = 0; i < employees.size(); i++) {
			String name = employees.get(i).getNameAsString();
			String department = employees.get(i).getDepartmentName();
			if (name != "" && department != null) {
				numberEmployees++;
			}
		}
		return numberEmployees;
	}

	// Method to check for duplicates within FormSData.
	boolean contains(ArrayList<String[]> formSData, String name, String department) {
		for (int i = 0; i < formSData.size(); i++) {
			if (formSData.get(i)[0].equals(name) && formSData.get(i)[1].equals(department)
					&& Integer.parseInt(formSData.get(i)[2]) == roundCount) {
				return true;
			}
		}
		return false;
	}

	// display this form
	public void display(Button button) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("formS.fxml"));
		Scene scene = new Scene(parent);
		Stage stage = (Stage) button.getScene().getWindow();
		stage.setTitle("Employee List");
		scene.getStylesheets().add("forms/Styling.css");
		stage.setScene(scene);

		Rectangle2D screen = Screen.getPrimary().getVisualBounds();
		stage.setX(screen.getMinX());
		stage.setY(screen.getMinY());
		stage.setWidth(screen.getWidth());
		stage.setHeight(screen.getHeight());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// on initialize
		// simulate creating new employee if there is data in the table
		ArrayList<String[]> arr = PSDSingleton.getInstance().getFormSData();
		for (int i = 0; i < arr.size(); i++) {
			// only reload data related to current round
			if (Integer.parseInt(arr.get(i)[2]) == roundCount) {
				EmployeeList emp = new EmployeeList(new Employee(), arr.get(i)[0], arr.get(i)[1]);
				employees.add(emp);
			}
		}

		backButton.setOnAction(e -> {

			ArrayList<String[]> formSData = PSDSingleton.getInstance().getFormSData();
			for (int i = 0; i < employees.size(); i++) {
				String name = employees.get(i).getNameAsString();
				String department = employees.get(i).getDepartmentName();

				if (name != "" && department != null && contains(formSData, name, department) == false) {
					String[] person = new String[3];
					person[0] = name;
					person[1] = department;
					person[2] = String.valueOf(roundCount);
					formSData.add(person);
				}
			}

			PSDSingleton.getInstance().setFormSData(formSData);

			FormVcontroller formV = FormVcontroller.getInstance();
			try {
				formV.display(backButton);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		// attach values to columns
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setStyle("-fx-alignment: CENTER");
		department.setCellValueFactory(new PropertyValueFactory<>("department"));

		employeeTable.setItems(employees);
	}
}
