package forms;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import main.PSDSingleton;

public class AYNEmployeeLine {

	private TextField name;
	private ComboBox<String> department;
	private CheckBox skill;

	private ArrayList<Button> buttons;
	private ArrayList<String> departments = new ArrayList<>(Arrays.asList("Sales", "Production\nPlanning", "Goods Receipt", 
				"Floor Control", "Production", "Ledger", "Quality\nAssurance", "Finance", "Manager"));
	AYNEmployee emp;
	
	// constructor
	public AYNEmployeeLine(AYNEmployee emp) {
		this.emp = emp;
		
		buttons = new ArrayList<>();
		
		name = new TextField();
		name.setText(emp.getName());
		
		department = new ComboBox<>();
		department.setPromptText("Choose");
		if (emp.getDepartment() != ""){
			department.getSelectionModel().select(emp.getDepartment());
		}
		skill = new CheckBox();
		skill.setSelected(emp.getMultiSkilled());
		
		// create buttons dynamically (in accordance to round time)
		for (int i = 1; i <= PSDSingleton.getInstance().getRoundTime(); i++){
			String name = Integer.toString(i);
			
			Button button = new Button();
			
			button.setMinHeight(26);
			button.setMinWidth(26);
			button.setPadding(new Insets(0,0,0,0));
			button.setText(name);
			
			button.setOnAction(e -> setTime(emp, button));
			
			buttons.add(button);
		}
		
		// add change listener to the name text box
		name.textProperty().addListener((observable, oldValue, newValue) -> {emp.setName(newValue);});
		
		// check this link http://code.makery.ch/blog/javafx-2-event-handlers-and-change-listeners/
		
		// set department choices
		department.getItems().addAll(departments);
		department.setOnAction(e -> {emp.setDepartment(department.getSelectionModel().getSelectedItem());});
		department.setVisibleRowCount(departments.size() - 1);
		
		// set multi skilled option
		skill.setOnAction(e -> {emp.setMultiSkilled(skill.isSelected());});
		
		// set button styles
		if (emp.getTime1() != 0 && emp.getTime2() != 0){
			for(Button but:buttons){
				if (Integer.parseInt(but.getText()) >= Math.min(emp.getTime1(), emp.getTime2()) && Integer.parseInt(but.getText()) <= Math.max(emp.getTime1(), emp.getTime2())){
					but.setStyle("-fx-background-color: green");
				}
			}
		}
	}
	
	// set and and calculated employment time
	public void setTime(AYNEmployee emp, Button b){
		// if nothing is selected
		if (emp.getTime1() == 0){
			emp.setTime1(Integer.parseInt(b.getText()));
			b.setStyle("-fx-background-color: green");
		}
		// if second selection is the same as first one
		else if(emp.getTime2() == 0 && emp.getTime1() == Integer.parseInt(b.getText())){
			emp.setTime1(0);
			b.setStyle("");
		}
		// if one time is selected and second is different
		else if(emp.getTime2() == 0 && emp.getTime1() != Integer.parseInt(b.getText())){
			
			emp.setTime2(Integer.parseInt(b.getText()));
			emp.setTotTime(Math.max(emp.getTime1(), emp.getTime2()) - Math.min(emp.getTime1(), emp.getTime2()));
			
			for(Button but:buttons){
				if (Integer.parseInt(but.getText()) >= Math.min(emp.getTime1(), emp.getTime2()) && Integer.parseInt(but.getText()) <= Math.max(emp.getTime1(), emp.getTime2())){
					but.setStyle("-fx-background-color: green");
				}
			}
		}
		// if two selections are made
		else{
			for(Button but:buttons){
				but.setStyle("");
			}
			emp.setTime1(Integer.parseInt(b.getText()));
			b.setStyle("-fx-background-color: green");
			emp.setTime2(0);
		}
	}	

	// getter and setter
	public AYNEmployee getEmployee(){
		return emp;
	}
	public TextField getName() {
		return name;
	}

	public ComboBox<String> getDepartment() {
		return department;
	}

	public CheckBox getSkill() {
		return skill;
	}
	
	public Button getButton(int index) {
		return buttons.get(index);
	}

	public void setName(TextField name) {
		this.name = name;
	}

	public void setDepartment(ComboBox<String> department) {
		this.department = department;
	}

	public void setSkill(CheckBox skill) {
		this.skill = skill;
	}
}
