import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;


public class FormTMenu implements Initializable {
	
	@FXML
	public Button addButton, backButton, deleteButton;
	
	@FXML
	private TableView<EmployeeLine> employeeTable;
	
	@FXML
	private TableColumn<EmployeeLine, TextField> name;
	
	@FXML
	private TableColumn<EmployeeLine, MenuButton> department;
	
	@FXML
	private TableColumn<EmployeeLine, CheckBox> skill;
	
	@FXML
	private TableColumn<EmployeeLine, Button> button1, button2, button3, button4, button5, 
		button6, button7, button8, button9, button10, button11, button12, button13, 
		button14, button15, button16, button17, button18, button19, button20;
		
	
	ObservableList<EmployeeLine> employees = FXCollections.observableArrayList();
	
	// redirects to settings
	@FXML
	public void goToSettings() throws IOException{
	
		Stage stage = (Stage) backButton.getScene().getWindow();
		Parent parent = FXMLLoader.load(getClass().getResource("formO.fxml")); // currently takes to formO for testing
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("Settings");
		stage.setScene(scene);
		stage.show();
		}
	
	// creates new employee
	@FXML
	public void createNewEmployee(){
		EmployeeLine emp = new EmployeeLine(new AVNEmployee());
		employees.add(emp);
	}
	
	@FXML
	public void deleteEmployee(){
		ObservableList<EmployeeLine> allEmployees;
		ObservableList<EmployeeLine> selectedEmployees;
		
		allEmployees = employeeTable.getItems();
		selectedEmployees = employeeTable.getSelectionModel().getSelectedItems();
		
		//shorthand to remove selected
		selectedEmployees.forEach(allEmployees::remove);
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		EmployeeLine em = new EmployeeLine(new AVNEmployee());
		//employees.add(em);
		
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		department.setCellValueFactory(new PropertyValueFactory<>("department"));
		skill.setCellValueFactory(new PropertyValueFactory<>("skill"));
		
		button1.setCellValueFactory(new PropertyValueFactory<>("button1"));
		button2.setCellValueFactory(new PropertyValueFactory<>("button2"));
		button3.setCellValueFactory(new PropertyValueFactory<>("button3"));
		button4.setCellValueFactory(new PropertyValueFactory<>("button4"));
		button5.setCellValueFactory(new PropertyValueFactory<>("button5"));
		button6.setCellValueFactory(new PropertyValueFactory<>("button6"));
		button7.setCellValueFactory(new PropertyValueFactory<>("button7"));
		button8.setCellValueFactory(new PropertyValueFactory<>("button8"));
		button9.setCellValueFactory(new PropertyValueFactory<>("button9"));
		button10.setCellValueFactory(new PropertyValueFactory<>("button10"));
		button11.setCellValueFactory(new PropertyValueFactory<>("button11"));
		button12.setCellValueFactory(new PropertyValueFactory<>("button12"));
		button13.setCellValueFactory(new PropertyValueFactory<>("button13"));
		button14.setCellValueFactory(new PropertyValueFactory<>("button14"));
		button15.setCellValueFactory(new PropertyValueFactory<>("button15"));
		button16.setCellValueFactory(new PropertyValueFactory<>("button16"));
		button17.setCellValueFactory(new PropertyValueFactory<>("button17"));
		button18.setCellValueFactory(new PropertyValueFactory<>("button18"));
		button19.setCellValueFactory(new PropertyValueFactory<>("button19"));
		button20.setCellValueFactory(new PropertyValueFactory<>("button20"));
		
		employeeTable.setItems(employees);

	}
}
