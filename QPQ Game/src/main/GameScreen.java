package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import settings.SettingsScene;
import forms.*;

public class GameScreen extends Application implements Initializable, EventHandler<ActionEvent>{
	@FXML private Button startButton;
	@FXML private Button settingsButton;

	 final Label hello = new Label("Please provide password for entry");
    private Button ok = new Button("ok");
	private Button cencel = new Button("cancel");
    private TextField name2 = new TextField();
    private Popup popup = new Popup();
	public static void main(String[] args){
		launch(args);
	}

	private void callPopUp(){
		popup.hide();
		popup = new Popup();

		 VBox popUpVBox = new VBox();
		 HBox popUpHBox = new HBox();
		 

		 popUpHBox.getChildren().add(ok);
		 popUpHBox.getChildren().add(cencel);
		 popUpHBox.setAlignment(Pos.CENTER);
		 
		 popUpVBox.setAlignment(Pos.CENTER);
		 popUpVBox.getChildren().add(hello);
		 popUpVBox.getChildren().add(name2);
		 popUpVBox.getChildren().add(popUpHBox);
		 
		 
		 popup.setAutoFix(false);
		 popup.setHideOnEscape(true);
		 popup.getContent().addAll(popUpVBox);
		 popup.setX(600);
		 popup.setY(200);

	        ok.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent t) {
            		popup.hide();
	            	if (name2.getText().equals("PassWord")){
	            	
	            	try {
	        			SettingsScene settingsMenu = new SettingsScene();
	        			settingsMenu.display(settingsButton);
	    			} catch (IOException e) {
	    				e.printStackTrace();
	    			}
	            	}
	            }
	        });

	        cencel.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent t) {
	                popup.hide();
	            }
	        });
		
		
		popup.show((Stage) settingsButton.getScene().getWindow());
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
			this.callPopUp();
			
				
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
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
