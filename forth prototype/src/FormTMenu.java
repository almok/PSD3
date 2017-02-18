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
import javafx.stage.Stage;


public class FormTMenu implements Initializable {
	
	@FXML
	public Button backButton;
	
	@FXML
	public TextField totalKitPrice;
	
	@FXML
	private TableView<EmployeeLine> employeeTable;
	
	@FXML
	private TableColumn<EmployeeLine, TextField> name;
	
	@FXML
	private TableColumn<EmployeeLine, MenuButton> department;
	
	@FXML
	private TableColumn<EmployeeLine, CheckBox> skill;
	@FXML
	private TableColumn<EmployeeLine, Button> button1;
	@FXML
	private TableColumn<EmployeeLine, Button> button2;
	@FXML
	private TableColumn<EmployeeLine, Button> button3;
	@FXML
	private TableColumn<EmployeeLine, Button> button4;
	@FXML
	private TableColumn<EmployeeLine, Button> button5;
	@FXML
	private TableColumn<EmployeeLine, Button> button6;
	@FXML
	private TableColumn<EmployeeLine, Button> button7;
	@FXML
	private TableColumn<EmployeeLine, Button> button8;
	@FXML
	private TableColumn<EmployeeLine, Button> button9;
	@FXML
	private TableColumn<EmployeeLine, Button> button10;
	@FXML
	private TableColumn<EmployeeLine, Button> button11;
	@FXML
	private TableColumn<EmployeeLine, Button> button12;
	@FXML
	private TableColumn<EmployeeLine, Button> button13;
	@FXML
	private TableColumn<EmployeeLine, Button> button14;
	@FXML
	private TableColumn<EmployeeLine, Button> button15;
	@FXML
	private TableColumn<EmployeeLine, Button> button16;
	@FXML
	private TableColumn<EmployeeLine, Button> button17;
	@FXML
	private TableColumn<EmployeeLine, Button> button18;
	@FXML
	private TableColumn<EmployeeLine, Button> button19;
	@FXML
	private TableColumn<EmployeeLine, Button> button20;
	
	
	ObservableList<EmployeeLine> employees = FXCollections.observableArrayList();
	
	// Redirects to settings
		@FXML
		public void goToFormV() throws IOException{
		
			Stage stage = (Stage) backButton.getScene().getWindow();
			Parent parent = FXMLLoader.load(getClass().getResource("formO.fxml")); // currently takes to formO for testing
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("Settings");
			stage.setScene(scene);
			stage.show();
			}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		EmployeeLine em = new EmployeeLine();
		employees.add(em);
		
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
