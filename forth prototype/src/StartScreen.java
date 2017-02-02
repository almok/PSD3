import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class StartScreen implements Initializable {
	
	private int roundCounter;
	private ToggleGroup rounds;
	private Scene scene;
	
	private void addRoundButton(VBox left){
		
		RadioButton roundButton = new RadioButton(" Round " + roundCounter + " ");
		roundButton.setUserData(roundCounter);
		roundButton.setToggleGroup(rounds);
		left.getChildren().add(roundButton);
		roundCounter++;

	}
	
	/*Main a
	TextField rev
	public Scene showStartScreen(Main a, TextField rev){
		this.a = a;
		this.rev = rev;
		
		try{
			Parent root = FXMLLoader.load(a.getClass().getResource("StartScreen.fxml"));
			this.scene = new Scene(root, 800 , 700);
		}*/
		
	
	
	@FXML 
	private Button startButton;
	@FXML
	private Button settingsButton;
	@FXML
	private Button reportButton;
	@FXML
	private Button financeButton;
	@FXML
	private VBox leftVBox;
	@FXML
	private Label rightLabel;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		
		startButton.setOnAction(event -> {
			addRoundButton(leftVBox);
			//startTimer();
		});
		
		settingsButton.setOnAction(event -> {
			//Go to settings menu
		});
		
		reportButton.setOnAction(event -> {
			//produce report from financials of rounds available
		});
		
		rounds.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

		         if (rounds.getSelectedToggle() != null) {
		        	 financeButton.setOnAction(event ->{
		        		 //Go to finance page with round selected [Form V]
		        		 //rounds.getSelectedToggle().getUserData().toString()
		        	 });

		         }

		     } 
		});
		
			
		}
}
