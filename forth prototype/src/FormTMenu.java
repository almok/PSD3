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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class FormTMenu implements Initializable {
	
	@FXML
	private Button addButton, backButton, deleteButton;
	
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
	
	public Scene scene;
	
	ObservableList<EmployeeLine> employees = FXCollections.observableArrayList();
	
	
	FormVcontroller a;
	public Scene display(FormVcontroller a){
		this.a = a;
		if (this.scene == null){
			BorderPane bPane = new BorderPane();
			VBox left = new VBox();
			HBox center = new HBox();
			bPane.setLeft(left);
			bPane.setCenter(center);

			try {
				Parent root = FXMLLoader.load(a.getClass().getResource("formT.fxml"));
				this.scene = new Scene(root, 800 , 700);
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
			
		}
		this.scene.getStylesheets().add("Styling.css");
		return this.scene;

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
		
		// here goes the code for loading employee list
		//EmployeeLine em = new EmployeeLine(new AVNEmployee());
		//employees.add(em);
		
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
