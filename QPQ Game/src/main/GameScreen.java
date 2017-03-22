package main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import forms.SettingsScene;
import forms.StartScreen;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
public class GameScreen extends Application implements Initializable, EventHandler<ActionEvent>{
	@FXML private Button startButton;
	@FXML private Button settingsButton;
	@FXML private Text text;
	@FXML private AnchorPane aPane;
	
	public static void main(String[] args){
		launch(args);
	}
	public void display(Button button) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
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
			try{
				StartScreen startMenu = new StartScreen();
				startMenu.display(startButton);
			} catch (IOException e){
				e.printStackTrace();
			}
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
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		
		aPane.setStyle("-fx-background: #363738;");
		text.setStyle("-fx-fill: #ffffff;");
		
		 assert startButton != null : "fx:id=\"startButton\" was not injected";
		 assert settingsButton != null : "fx:id=\"settingsButton\" was not injected";
		startButton.setOnAction(this);
		settingsButton.setOnAction(this);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
		Scene scene = new Scene(root, 800, 700);
        primaryStage.setTitle("FXML Welcome");
        scene.getStylesheets().add("forms/Styling.css");
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}