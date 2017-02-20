import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import java.util.concurrent.TimeUnit;
import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.script.*;

public class StartScreen implements Initializable {
	
	private int roundCounter;
	private ToggleGroup rounds;
	private Scene scene;
	private static final int STARTTIME = 15;
	
	public void addRoundButton(VBox left){
		
		RadioButton roundButton = new RadioButton(" Round " + roundCounter + " ");
		roundButton.setUserData(roundCounter);
		roundButton.setToggleGroup(rounds);
		left.getChildren().add(roundButton);
		roundCounter++;

	}
	
	
	public void display(Button button) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
		Scene scene = new Scene(parent);
		Stage stage = (Stage) button.getScene().getWindow();
		stage.hide();
		stage.setScene(scene);
		stage.show();
		scene.getStyleSheets().add("Styling.css");


	public void goToTimer() throws IOException{
		
	}
	
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
	private HBox rightBox;


	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		
		// Start Button
		startButton.setOnAction(event -> {
			addRoundButton(leftVBox);
//			new CountDownTimer(30000,1000){
//				Public void onTick(long millisUntilFinished){
//					rightBox.setText("seconds remaining")
//				}
//			}
		});
		
		// Setting Button
		SettingsMenu settingsMenu  = new SettingsMenu();
		settingsButton.setOnAction(event -> {
			
			try {
				settingsMenu.display(settingsButton);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		});
		

		// Report Button
		reportButton.setOnAction(event -> {
			//produce report from financials of rounds available
		});
		

		

		// Finance Button
		FormVController formV = new FormVController() // or is this form B???
		rounds.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){ //Listener for action on toggles
		    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

		         if (rounds.getSelectedToggle() != null) {
		        	 financeButton.setOnAction(event ->{
		        		 
		        		try{
		    				formV.display(financeButton); //display method may need to be adjusted to account for round selected
		    			} catch (IOException e1) {
		    				e1.printStackTrace();
		    			}
		        		 
		        	 
		        		 //Go to finance page with round selected [Form V]
		        		 //rounds.getSelectedToggle().getUserData().toString()
		        	 });

		         }

		     } 
		});
		
			
		}
	
}