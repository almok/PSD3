import forms.AYNEmployee;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.PSDSingleton;



public class FormTMenu implements Initializable {
	
	@FXML private BorderPane FormTMenu;
	
	@FXML
	private Button addButton, backButton, deleteButton, saveButton;
	
	@FXML
	private TableView<AYNEmployeeLine> employeeTable;
	
	@FXML
	private TableColumn<AYNEmployeeLine, TextField> name;
	
	@FXML
	private TableColumn<AYNEmployeeLine, MenuButton> department;
	
	@FXML
	private TableColumn<AYNEmployeeLine, CheckBox> skill;
	
	@FXML
	private TableColumn<AYNEmployeeLine, Button> button1, button2, button3, button4, button5, 
		button6, button7, button8, button9, button10, button11, button12, button13, 
		button14, button15, button16, button17, button18, button19, button20;
	
	private AYNEmployeeList emps;
	FormVcontroller formV;
	FormOMenu formO;
	
	ObservableList<AYNEmployeeLine> employees = FXCollections.observableArrayList();

	// creates new employee
	@FXML
	public void createNewEmployee(){
		AYNEmployeeLine emp = new AYNEmployeeLine(new AYNEmployee());
		employees.add(emp);
	}
	
	@FXML
	public void deleteEmployee(){
		ObservableList<AYNEmployeeLine> allEmployees;
		ObservableList<AYNEmployeeLine> selectedEmployees;
		
		allEmployees = employeeTable.getItems();
		selectedEmployees = employeeTable.getSelectionModel().getSelectedItems();
		
		//shorthand to remove selected
		selectedEmployees.forEach(allEmployees::remove);
	}
	
	@FXML
	public void saveEmployees(){
		ArrayList<AYNEmployee> listToSave = new ArrayList<>();
		for(AYNEmployeeLine empl : employeeTable.getItems()){
			listToSave.add(empl.getEmployee());
		}
		
		PSDSingleton.getInstance().setFormTData(listToSave);
		
		emps.setEmployees(listToSave);
		//emps.toFile("AYN Employee List.csv");
	}
	
	
	// display this form
	public void display(Button button) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("formT.fxml"));
		Scene scene = new Scene(parent);
		Stage stage = (Stage) button.getScene().getWindow();
		scene.getStylesheets().add("Styling.css");	
		stage.setScene(scene);
		stage.setTitle("AYN Employee List");
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// load existing employees
		ArrayList<AYNEmployee> arr = PSDSingleton.getInstance().getFormTData();
		for (int i = 0; i < arr.size() ; i ++){
            
			AYNEmployeeLine emp = new AYNEmployeeLine(arr.get(i));
			employees.add(emp);				
		}

		// load existing employees
		emps = new AYNEmployeeList();
		//emps.getEmployees().add(new AYNEmployee("John Smith", "Sales", true, 4, 15, 11, 10));
		
		//emps.loadList("AYN Employee List Default.csv");
		//for (AYNEmployee emp: emps.getEmployees()){
		//	employees.add(new AYNEmployeeLine(emp));
		//}
		
	
		formV = new FormVcontroller();
		
		backButton.setOnAction(e -> {
		
			try {
				// save employees
				saveEmployees();
				formV.display(backButton);
				
			} catch (IOException e1) {
				e1.printStackTrace();
				}
		});
		
		name.setCellValueFactory(new PropertyValueFactory<>("name"));				name.setStyle("-fx-alignment: CENTER");
		department.setCellValueFactory(new PropertyValueFactory<>("department"));
		skill.setCellValueFactory(new PropertyValueFactory<>("skill"));				skill.setStyle("-fx-alignment: CENTER");
		
		button1.setCellValueFactory(new PropertyValueFactory<>("button1"));			button1.setStyle("-fx-alignment: CENTER");
		button2.setCellValueFactory(new PropertyValueFactory<>("button2"));			button2.setStyle("-fx-alignment: CENTER");
		button3.setCellValueFactory(new PropertyValueFactory<>("button3"));			button3.setStyle("-fx-alignment: CENTER");
		button4.setCellValueFactory(new PropertyValueFactory<>("button4"));			button4.setStyle("-fx-alignment: CENTER");
		button5.setCellValueFactory(new PropertyValueFactory<>("button5"));			button5.setStyle("-fx-alignment: CENTER");
		button6.setCellValueFactory(new PropertyValueFactory<>("button6"));			button6.setStyle("-fx-alignment: CENTER");
		button7.setCellValueFactory(new PropertyValueFactory<>("button7"));			button7.setStyle("-fx-alignment: CENTER");
		button8.setCellValueFactory(new PropertyValueFactory<>("button8"));			button8.setStyle("-fx-alignment: CENTER");
		button9.setCellValueFactory(new PropertyValueFactory<>("button9"));			button9.setStyle("-fx-alignment: CENTER");
		button10.setCellValueFactory(new PropertyValueFactory<>("button10"));		button10.setStyle("-fx-alignment: CENTER");
		button11.setCellValueFactory(new PropertyValueFactory<>("button11"));		button11.setStyle("-fx-alignment: CENTER");
		button12.setCellValueFactory(new PropertyValueFactory<>("button12"));		button12.setStyle("-fx-alignment: CENTER");
		button13.setCellValueFactory(new PropertyValueFactory<>("button13"));		button13.setStyle("-fx-alignment: CENTER");
		button14.setCellValueFactory(new PropertyValueFactory<>("button14"));		button14.setStyle("-fx-alignment: CENTER");
		button15.setCellValueFactory(new PropertyValueFactory<>("button15"));		button15.setStyle("-fx-alignment: CENTER");
		button16.setCellValueFactory(new PropertyValueFactory<>("button16"));		button16.setStyle("-fx-alignment: CENTER");
		button17.setCellValueFactory(new PropertyValueFactory<>("button17"));		button17.setStyle("-fx-alignment: CENTER");
		button18.setCellValueFactory(new PropertyValueFactory<>("button18"));		button18.setStyle("-fx-alignment: CENTER");
		button19.setCellValueFactory(new PropertyValueFactory<>("button19"));		button19.setStyle("-fx-alignment: CENTER");
		button20.setCellValueFactory(new PropertyValueFactory<>("button20"));		button20.setStyle("-fx-alignment: CENTER");
		
		employeeTable.setItems(employees);
	}
}
