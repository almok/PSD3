import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class EmployeeLine {

	private TextField name;
	private MenuButton department;
	private CheckBox skill;
	private Button button1, button2, button3, button4, button5, button6, button7, 
		button8, button9, button10, button11, button12, button13, button14, 
		button15, button16, button17, button18, button19, button20;
	private ArrayList<Button> buttons;
	
	
	
	public EmployeeLine(AVNEmployee emp) {
		
		buttons = new ArrayList<>();
		
		name = new TextField();
		department = new MenuButton();
		department.setText("Choose");
		skill = new CheckBox();
		button1 = new Button();
		button1.setText("1");
		button2 = new Button();
		button2.setText("2");
		button3 = new Button();
		button3.setText("3");
		button4 = new Button();
		button4.setText("4");
		button5 = new Button();
		button5.setText("5");
		button6 = new Button();
		button6.setText("6");
		button7 = new Button();
		button7.setText("7");
		button8 = new Button();
		button8.setText("8");
		button9 = new Button();
		button9.setText("9");
		button10 = new Button();
		button10.setText("10");
		button11 = new Button();
		button11.setText("11");
		button12 = new Button();
		button12.setText("12");
		button13 = new Button();
		button13.setText("13");
		button14 = new Button();
		button14.setText("14");
		button15 = new Button();
		button15.setText("15");
		button16 = new Button();
		button16.setText("16");
		button17 = new Button();
		button17.setText("17");
		button18 = new Button();
		button18.setText("18");
		button19 = new Button();
		button19.setText("19");
		button20 = new Button();
		button20.setText("20");
		
		button1.setOnAction(e -> setTime(emp, button1));
		button2.setOnAction(e -> setTime(emp, button2));
		button3.setOnAction(e -> setTime(emp, button3));
		button4.setOnAction(e -> setTime(emp, button4));
		button5.setOnAction(e -> setTime(emp, button5));
		button6.setOnAction(e -> setTime(emp, button6));
		button7.setOnAction(e -> setTime(emp, button7));
		button8.setOnAction(e -> setTime(emp, button8));
		button9.setOnAction(e -> setTime(emp, button9));
		button10.setOnAction(e -> setTime(emp, button10));
		button11.setOnAction(e -> setTime(emp, button11));
		button12.setOnAction(e -> setTime(emp, button12));
		button13.setOnAction(e -> setTime(emp, button13));
		button14.setOnAction(e -> setTime(emp, button14));
		button15.setOnAction(e -> setTime(emp, button15));
		button16.setOnAction(e -> setTime(emp, button16));
		button17.setOnAction(e -> setTime(emp, button17));
		button18.setOnAction(e -> setTime(emp, button18));
		button19.setOnAction(e -> setTime(emp, button19));
		button20.setOnAction(e -> setTime(emp, button20));
		
		buttons.addAll(Arrays.asList(button1, button2, button3, button4, button5, button6, button7,
				button8, button9, button10, button11, button12, button13, button14, button15, 
				button16, button17, button18, button19, button20));
	}
	
	// set and and calculated employment time
	public void setTime(AVNEmployee emp, Button b){
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
			b.setStyle("-fx-background-color: green");
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
	public TextField getName() {
		return name;
	}

	public MenuButton getDepartment() {
		return department;
	}

	public CheckBox getSkill() {
		return skill;
	}

	public Button getButton1() {
		return button1;
	}

	public Button getButton2() {
		return button2;
	}

	public Button getButton3() {
		return button3;
	}

	public Button getButton4() {
		return button4;
	}

	public Button getButton5() {
		return button5;
	}

	public Button getButton6() {
		return button6;
	}

	public Button getButton7() {
		return button7;
	}

	public Button getButton8() {
		return button8;
	}

	public Button getButton9() {
		return button9;
	}

	public Button getButton10() {
		return button10;
	}

	public Button getButton11() {
		return button11;
	}

	public Button getButton12() {
		return button12;
	}

	public Button getButton13() {
		return button13;
	}

	public Button getButton14() {
		return button14;
	}

	public Button getButton15() {
		return button15;
	}

	public Button getButton16() {
		return button16;
	}

	public Button getButton17() {
		return button17;
	}

	public Button getButton18() {
		return button18;
	}

	public Button getButton19() {
		return button19;
	}

	public Button getButton20() {
		return button20;
	}

	public void setName(TextField name) {
		this.name = name;
	}

	public void setDepartment(MenuButton department) {
		this.department = department;
	}

	public void setSkill(CheckBox skill) {
		this.skill = skill;
	}

	public void setButton1(Button button1) {
		this.button1 = button1;
	}

	public void setButton2(Button button2) {
		this.button2 = button2;
	}

	public void setButton3(Button button3) {
		this.button3 = button3;
	}

	public void setButton4(Button button4) {
		this.button4 = button4;
	}

	public void setButton5(Button button5) {
		this.button5 = button5;
	}

	public void setButton6(Button button6) {
		this.button6 = button6;
	}

	public void setButton7(Button button7) {
		this.button7 = button7;
	}

	public void setButton8(Button button8) {
		this.button8 = button8;
	}

	public void setButton9(Button button9) {
		this.button9 = button9;
	}

	public void setButton10(Button button10) {
		this.button10 = button10;
	}

	public void setButton11(Button button11) {
		this.button11 = button11;
	}

	public void setButton12(Button button12) {
		this.button12 = button12;
	}

	public void setButton13(Button button13) {
		this.button13 = button13;
	}

	public void setButton14(Button button14) {
		this.button14 = button14;
	}

	public void setButton15(Button button15) {
		this.button15 = button15;
	}

	public void setButton16(Button button16) {
		this.button16 = button16;
	}

	public void setButton17(Button button17) {
		this.button17 = button17;
	}

	public void setButton18(Button button18) {
		this.button18 = button18;
	}

	public void setButton19(Button button19) {
		this.button19 = button19;
	}

	public void setButton20(Button button20) {
		this.button20 = button20;
	}
	
	
}
