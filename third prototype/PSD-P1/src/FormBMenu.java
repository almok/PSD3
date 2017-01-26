
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormBMenu implements Initializable{
	//private static Button backButton;
	//private static ArrayList<Button> formButtons = new ArrayList<Button>();
	private int formCounter = 1;
	private int currentForm = 1;
	private Scene scene;
	
	
	private ArrayList<String> field1 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field2 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field3 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field4 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field5 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field6 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field7 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field8 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field9 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field10 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> field11 = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<TextField> textFields = new ArrayList<TextField>();
	
	private void displayValues(){
		textFields.get(0).setText(fieldOne.getText());
		textFields.get(1).setText(fieldTwo.getText());
		textFields.get(2).setText(fieldThree.getText());
		textFields.get(3).setText(fieldFour.getText());
		textFields.get(4).setText(fieldFive.getText());
		textFields.get(5).setText(fieldSix.getText());
		textFields.get(6).setText(fieldSeven.getText());
		textFields.get(7).setText(fieldEight.getText());
		textFields.get(8).setText(fieldNine.getText());
		textFields.get(9).setText(fieldTen.getText());
		textFields.get(10).setText(fieldEleven.getText());
	}
	
	private void saveFields(int c){
		System.out.println(c);
		field1.set(c, fieldOne.getText());
		field2.set(c, fieldTwo.getText());
		field3.set(c, fieldThree.getText());
		field4.set(c, fieldFour.getText());
		field5.set(c, fieldFive.getText());
		field6.set(c, fieldSix.getText());
		field7.set(c, fieldSeven.getText());
		field8.set(c, fieldEight.getText());
		field9.set(c, fieldNine.getText());
		field10.set(c, fieldTen.getText());
		field11.set(c, fieldEleven.getText());
	}
	
	private void saveFields(){
		int c = currentForm - 1;
		saveFields(c);
	}
	
	private void addFormButtons(VBox left){
		int c = formCounter;
		if (formCounter > 0 && formCounter < 10){ 
			Button formButton = new Button(" Form " + formCounter + " ");
			formCounter++;
			left.getChildren().add(formButton);
			formButton.setOnAction(e -> {
				saveFields(c);
				currentForm = c;
				displayValues();
			});
		} else if (formCounter >= 10 && formCounter <= 20){ 
			Button formButton = new Button("Form " + formCounter);
			formCounter++;
			left.getChildren().add(formButton);
			formButton.setOnAction(e -> {
				saveFields(currentForm);
				currentForm = c;
				displayValues();
			});
		}
	}
	
	
	public Scene display(Application a){
		if (this.scene == null){
			BorderPane bPane = new BorderPane();
			VBox left = new VBox();
			HBox center = new HBox();
			bPane.setLeft(left);
			bPane.setCenter(center);

			try {
				Parent root = FXMLLoader.load(a.getClass().getResource("formB.fxml"));
				this.scene = new Scene(root, 800 , 700);
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
			
		}
		
		return this.scene;

	}

	@FXML
	private Button backButton;
	@FXML
	private Button newButton;
	@FXML
	private VBox leftVBox;
	@FXML
	private  TextField fieldOne;
	@FXML
	private  TextField fieldTwo;
	@FXML
	private  TextField fieldThree;
	@FXML
	private  TextField fieldFour;
	@FXML
	private  TextField fieldFive;
	@FXML
	private  TextField fieldSix;
	@FXML
	private  TextField fieldSeven;
	@FXML
	private  TextField fieldEight;
	@FXML
	private  TextField fieldNine;
	@FXML
	private  TextField fieldTen;
	@FXML
	private  TextField fieldEleven;
	@FXML
	private static Button form1;
	@FXML
	private static Button form2;
	@FXML
	private static Button form3;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		addFormButtons(leftVBox);
		addFormButtons(leftVBox);
		addFormButtons(leftVBox);
		
		textFields.add(fieldOne);
		textFields.add(fieldTwo);
		textFields.add(fieldThree);
		textFields.add(fieldFour);
		textFields.add(fieldFive);
		textFields.add(fieldSix);
		textFields.add(fieldSeven);
		textFields.add(fieldEight);
		textFields.add(fieldNine);
		textFields.add(fieldTen);
		textFields.add(fieldEleven);
		
		backButton.setOnAction(event -> {
			saveFields();
			Main.window.setScene(Main.mainScene);
        });
		
		newButton.setOnAction(event -> {
			saveFields();
			addFormButtons(leftVBox);
        });
		

	
	}

	
}
