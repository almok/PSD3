import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.PSDSingleton;



public class FormSMenu implements Initializable {

	RoundCounter roundCounter = RoundCounter.getInstance();
	int roundCount = roundCounter.getRoundCounter();

	private static FormSMenu instance = null;

	public static FormSMenu getInstance() {
		if(instance == null) {
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
	public void createNewEmployee(){
		EmployeeList emp = new EmployeeList(new Employee());
		employees.add(emp);	
		
	}
	
	@FXML
	public void deleteEmployee(){
		ObservableList<EmployeeList> allEmployees;
		ObservableList<EmployeeList> selectedEmployees;
		
		allEmployees = employeeTable.getItems();
		selectedEmployees = employeeTable.getSelectionModel().getSelectedItems();
		
		//shorthand to remove selected
		selectedEmployees.forEach(allEmployees::remove);
		
	}
	
	public int countEmployees(ObservableList<EmployeeList> employees){
		int numberEmployees = 0;
		for (int i = 0;i<employees.size();i++){
			String name = employees.get(i).getNameAsString();
			String department = employees.get(i).getDepartmentName();
			if (name != "" && department != null){
				numberEmployees++;
			}
		}
		return numberEmployees;
	}
	
	// display this form
	public void display(Button button) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("formS.fxml"));
		Scene scene = new Scene(parent);
		Stage stage = (Stage) button.getScene().getWindow();
		stage.setTitle("Employee List");
		scene.getStylesheets().add("Styling.css");
		stage.setScene(scene);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// on initialize
		// simulate creating new employee if there is data in the table
		ArrayList<String[]> arr = PSDSingleton.getInstance().getFormSData();
		for (int i = 0; i < arr.size() ; i ++){
			if(Integer.parseInt(arr.get(i)[2]) == roundCount){
				EmployeeList emp = new EmployeeList(new Employee() , arr.get(i)[0] , arr.get(i)[1]);
				employees.add(emp);	
			}
		}
		
		backButton.setOnAction(e -> {
			
			ArrayList<String[]> formSData = PSDSingleton.getInstance().getFormSData();
			for (int i = 0;i<employees.size();i++){
				String name = employees.get(i).getNameAsString();
				String department = employees.get(i).getDepartmentName();
				
				if (name != "" && department != null){
					String[] person = new String[3];
					person[0] = name;
					person[1] = department;
					person[2] = String.valueOf(roundCount);
					formSData.add(person);
				}
			} 
			
			PSDSingleton.getInstance().setFormSData(formSData);
			
			
			FormVcontroller formV = FormVcontroller.getInstance();
			try{
				formV.setEmployeeWage(countEmployees(employees));
				formV.display(backButton);
			}catch(IOException e1){
				e1.printStackTrace();
			}
		});
		
		name.setCellValueFactory(new PropertyValueFactory<>("name"));				name.setStyle("-fx-alignment: CENTER");
		department.setCellValueFactory(new PropertyValueFactory<>("department"));
		
		employeeTable.setItems(employees);
	}
}
