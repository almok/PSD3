package forms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.RoundCounter;

public class StartScreen extends Application implements Initializable, EventHandler<ActionEvent>{
	@FXML private Button startButton;
	@FXML private Button settingsButton;
	@FXML private Button reportButton;
	@FXML private Button financeButton;
	@FXML private VBox leftVBox;
	@FXML private Label rightLabel;
	@FXML private AnchorPane aPane;
	
	public static void main(String[] args){
		launch(args);
	}

	public void display(Button button) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
		Scene scene = new Scene(parent);
		Stage stage = (Stage) button.getScene().getWindow();
		scene.getStylesheets().add("forms/Styling.css");
		stage.setScene(scene);
		stage.setTitle("QpQ");
			
		}
	
	//Mostly needs fix at timer and need to relate roundbutton to a unique ID.
	RoundCounter roundCounter = RoundCounter.getInstance();
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == startButton){
			addRoundButton(leftVBox);
			roundCounter.incRoundCounter();
			//CountDownTimer countDown = new CountDownTimer();
			//countdown.display(startButton);
		} else if (event.getSource() == settingsButton){
			try {
				SettingsScene settingsMenu = new SettingsScene();
				settingsMenu.display(settingsButton);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			//} catch (Exception e){
			//	System.out.println(e.toString());
			}
		} else if (event.getSource() == reportButton){
			//produce report from financials of rounds available
		} 
	}
	
	
	public void addRoundButton(VBox left){
		Button roundButton;
		if (roundCounter.getRoundCounter() == 0){
			roundButton = new Button(" Trial Round ");
		} else {
			roundButton = new Button(" Round " + roundCounter.getRoundCounter() + " ");
		}
		left.getChildren().add(roundButton);
		roundButton.setOnAction(e -> {
			String buttonTxt = roundButton.getText().replaceAll("\\D+", "");
			System.out.println(buttonTxt);
			try{
				roundCounter.setRoundCounter(Integer.parseInt(buttonTxt));
				System.out.println(roundCounter.getRoundCounter());
			} catch (Exception e1){
				roundCounter.setRoundCounter(0);
				System.out.println(roundCounter.getRoundCounter());
			}
			FormVcontroller formVMenu = new FormVcontroller();
			try {
		 		formVMenu.display(roundButton);
		 	 } catch (Exception e1) {
		 	 	e1.printStackTrace();
		 	 }
		});
		roundCounter.setMaxCount(roundCounter.getRoundCounter());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		 assert startButton != null : "fx:id=\"startButton\" was not injected";
		 assert settingsButton != null : "fx:id=\"settingsButton\" was not injected";
		 assert reportButton != null : "fx:id=\"reportButton\" was not injected";

		startButton.setOnAction(this);
		settingsButton.setOnAction(this);
		reportButton.setOnAction(this);

		System.out.println("Printing round count " + roundCounter.getMaxCount());
		if (roundCounter.getMaxCount() >= -1){
			int i = roundCounter.getMaxCount();
			roundCounter.setRoundCounter(0);
			while (roundCounter.getRoundCounter() <= i){
				addRoundButton(leftVBox);
				roundCounter.incRoundCounter();
			}
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));

		Scene scene = new Scene(root, 800, 700);
        primaryStage.setTitle("FXML Welcome");
        scene.getStylesheets().add("forms/Styling.css");
        primaryStage.setScene(scene);
        primaryStage.show();

	}
}
