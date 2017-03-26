package forms;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
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
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.PSDSingleton;
import main.RoundCounter;



public class FormTMenu implements Initializable {

	RoundCounter roundCounter = RoundCounter.getInstance();
	int roundCount = roundCounter.getRoundCounter();
	
	private static FormTMenu instance = null;

	public static FormTMenu getInstance() {
		if(instance == null) {
			instance = new FormTMenu();
	    }
		return instance;
	}
	
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
		ArrayList<AYNEmployee> formTData = PSDSingleton.getInstance().getFormTData();
		ObservableList<AYNEmployeeLine> allEmployees;
		ObservableList<AYNEmployeeLine> selectedEmployees;
		
		allEmployees = employeeTable.getItems();
		selectedEmployees = employeeTable.getSelectionModel().getSelectedItems();
		
		//Remove from FormTData Singleton
		for (int i = 0; i <formTData.size(); i++){
			if (formTData.get(i).getName().equals(selectedEmployees.get(0).getEmployee().getName())
					&& formTData.get(i).getRoundCount() == selectedEmployees.get(0).getEmployee().getRoundCount()){
				formTData.remove(i);
				break;
			}
		}
		
		//shorthand to remove selected
		selectedEmployees.forEach(allEmployees::remove);
		

	}
	// Method to check for duplicates within FormTData.
	boolean contains(ArrayList<AYNEmployee> formTData, String name){
		for (int i = 0; i < formTData.size(); i++){
			if (formTData.get(i).getName().equals(name) && formTData.get(i).getRoundCount() == roundCount){
				return true;
			}
		}
		return false;
	}
	
	@FXML
	public void saveEmployees(){
		ArrayList<AYNEmployee> listToSave = PSDSingleton.getInstance().getFormTData();
		for(AYNEmployeeLine empl : employeeTable.getItems()){
			if (contains(listToSave, empl.getEmployee().getName()) == false){
				listToSave.add(empl.getEmployee());
			}
		}
		
		PSDSingleton.getInstance().setFormTData(listToSave);
		
		emps.setEmployees(listToSave);
	}
	
	
	// display this form
	public void display(Button button) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("formT.fxml"));
		Scene scene = new Scene(parent);
		Stage stage = (Stage) button.getScene().getWindow();
		scene.getStylesheets().add("forms/Styling.css");	
		stage.setScene(scene);
		stage.setTitle("AYN Employee List");
		
		Rectangle2D screen = Screen.getPrimary().getVisualBounds();
		stage.setX(screen.getMinX());
		stage.setY(screen.getMinY());
		stage.setWidth(screen.getWidth());
		stage.setHeight(screen.getHeight());
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// load existing employees
		ArrayList<AYNEmployee> arr = PSDSingleton.getInstance().getFormTData();
		System.out.println("arr " + arr);
		for (int i = 0; i < arr.size() ; i ++){
            
			if (arr.get(i).getRoundCount() == roundCount){
				AYNEmployeeLine emp = new AYNEmployeeLine(arr.get(i));
				employees.add(emp);
			}
		}

		// load existing employees
		emps = AYNEmployeeList.getInstance();
	
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
		
		
		// add columns dynamically
		for (int i = 1; i <= PSDSingleton.getInstance().getRoundTime(); i++){
			final int id = i - 1;
			TableColumn<AYNEmployeeLine, Button> butCol = new TableColumn<>(Integer.toString(i));
			butCol.setCellValueFactory(param ->  new ReadOnlyObjectWrapper<>(param.getValue().getButton(id)));
			
			butCol.setPrefWidth(30);
			butCol.setStyle("-fx-alignment: CENTER");
			
			employeeTable.getColumns().add(butCol);
		}
		
		employeeTable.setItems(employees);
	}
}
