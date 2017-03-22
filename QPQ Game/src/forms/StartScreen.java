package forms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.GameScreen;
import main.PSDSingleton;
import main.RoundCounter;
import main.Timer;

public class StartScreen implements Initializable, EventHandler<ActionEvent>{
	@FXML private Button startButton;
	@FXML private Button exportButton;
	@FXML private Button importButton;	
	@FXML private Button reportButton;
	@FXML private Button timerButton;
	@FXML private Button backButton;
	@FXML private VBox leftVBox;
	@FXML private Label rightLabel;
	@FXML private AnchorPane aPane;

	public void display(Button button) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
		Scene scene = new Scene(parent);
		Stage stage = (Stage) button.getScene().getWindow();
		scene.getStylesheets().add("forms/Styling.css");
		stage.setScene(scene);
		stage.setTitle("QpQ");
		
		Rectangle2D screen = Screen.getPrimary().getVisualBounds();
		stage.setX(screen.getMinX());
		stage.setY(screen.getMinY());
		stage.setWidth(screen.getWidth());
		stage.setHeight(screen.getHeight());
			
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
		} else if (event.getSource() == reportButton){
			//produce report from financials of rounds available
		} else if (event.getSource() == timerButton){
			//display timer in separate window
			Timer timer = new Timer();
			System.out.println("Timer button pressed");
			try {
		 		timer.display(timerButton);
		 	 } catch (Exception e1) {
		 	 	e1.printStackTrace();
		 	 }
		} else if (event.getSource() == backButton){
		 	GameScreen GameScreen = new GameScreen();
		 	try{
		 		GameScreen.display(backButton);	
		 	}catch(IOException e1){
		 		e1.printStackTrace();
		 	}
		} else if (event.getSource() == exportButton){
			PSDSingleton.getInstance().exportData();
			
		} else if (event.getSource() == importButton){
			
			PSDSingleton.getInstance().importData();
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
		 assert backButton != null : "fx:id=\"backButton\" was not injected";
		 assert exportButton != null : "fx:id=\"exportButton\" was not injected";
		 assert importButton != null : "fx:id=\"importButton\" was not injected";
		 assert reportButton != null : "fx:id=\"reportButton\" was not injected";

		backButton.setOnAction(this);
		startButton.setOnAction(this);
		exportButton.setOnAction(this);
		importButton.setOnAction(this);
		reportButton.setOnAction(this);
		timerButton.setOnAction(this);

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
}
