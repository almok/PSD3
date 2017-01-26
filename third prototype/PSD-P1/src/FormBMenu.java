
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

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
	
	private ArrayList<Integer> revenues = new ArrayList<Integer>(Collections.nCopies(20, 0));
	
	private String calculateRevenues(){
		int rev = 0;
		int revSum = 0;
		for (int i = 0; i < formCounter - 1; i++) {
			rev = (Integer.parseInt(field7.get(i)) - 30 * (Integer.parseInt("1") - Integer.parseInt(field6.get(i))));
			revSum += rev;
			revenues.set(i, rev);
		}

		return revSum + "";
	}

	private void displayValues(int c){
		fieldOne.setText(field1.get(c));
		fieldTwo.setText(field2.get(c));
		fieldThree.setText(field3.get(c));
		fieldFour.setText(field4.get(c));
		fieldFive.setText(field5.get(c));
		fieldSix.setText(field6.get(c));
		fieldSeven.setText(field7.get(c));
		fieldEight.setText(field8.get(c));
		fieldNine.setText(field9.get(c));
		fieldTen.setText(field10.get(c));
		fieldEleven.setText(field11.get(c));
		
	}
	
	private void saveFields(int c){
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
				saveFields(currentForm - 1);
				currentForm = c;
				displayValues(c -1);
			});
		} else if (formCounter >= 10 && formCounter <= 20){ 
			Button formButton = new Button("Form " + formCounter);
			formCounter++;
			left.getChildren().add(formButton);
			formButton.setOnAction(e -> {
				saveFields(currentForm - 1);
				currentForm = c;
				displayValues(c -1);
			});
		}
	}
	
	Main a;
	
	public Scene display(Main a){
		this.a = a;
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
		
		backButton.setOnAction(event -> {
			saveFields();
			System.out.println(calculateRevenues());
			//this.a.rev.setText("11");
			Main.window.setScene(Main.mainScene);
        });
		
		newButton.setOnAction(event -> {
			saveFields();
			addFormButtons(leftVBox);
        });
		

	
	}

	
}
