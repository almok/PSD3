package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;




public class Timer extends Stage implements Initializable  {
	@FXML
	private Button resetTimer;
	@FXML
	private Button startTimer;
	@FXML
	private Button stopTimer;
	@FXML
	private Label timeLabel;
	
	
	
	
	//@FXML static Button startTimer;
		//private Label timeLabel = new Label();
		private Timeline timeline;
		private static final Integer STARTTIME = PSDSingleton.getInstance().getRoundTime();
		private Integer timeSeconds = 0;
		private Integer timeMin = STARTTIME -1;
		
		 

		

		
		
		/*public Timer() throws IOException {
			
			
			//Parent root = FXMLLoader.load(getClass().getResource("Timer.fxml"));
			//.this.setTitle("Timer");
			//Group root = new Group();
			//Scene scene = new Scene(root, 800, 700);
			
			 timeLabel.setText(STARTTIME.toString() + ":00");
		     timeLabel.setTextFill(Color.RED);
		     timeLabel.setStyle("-fx-font-size: 4em;");
			//Button resetTimer = new Button();
			//resetTimer.setText("Reset");
			resetTimer.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					timeSeconds = 0;
					timeMin = STARTTIME ;
					timeLabel.setText(timeMin.toString()+ ":00");
				}
			});
		    Button stopTimer = new Button();
			stopTimer.setText("Stop");
			stopTimer.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					timeline.stop();
				}
			});
			Button startTimer = new Button();
			startTimer.setText("Start");
			startTimer.setOnAction(new EventHandler<ActionEvent>(){
				
				
				
				public void handle(ActionEvent event) {
					
					
					if (timeline != null){
						System.out.println("timeline not null");
						//timeline.stop();
						
					}else{
					timeMin = STARTTIME;
					timeLabel.setText(timeMin.toString() + ":00");
					}
					//update timer label
					
			        timeline = new Timeline();
			        timeline.setCycleCount(Timeline.INDEFINITE);
			        timeline.getKeyFrames().add(
			        		new KeyFrame(Duration.seconds(1),
			        				new EventHandler<ActionEvent>(){
			        			//keyframe event handler
			        			public void handle(ActionEvent event){
			        				timeSeconds--;
			        				System.out.println("seconds");
			        				boolean isSecondsZero = timeSeconds <= 0;
			        				
			        				if(isSecondsZero){
			        					timeMin--;
			        					timeSeconds = 60;
			        				}
			        				//update timer label
			        				timeLabel.setText(String.format("%d:%02d", timeMin, timeSeconds-1));
			        				if (timeMin == 0 && timeSeconds <= 1){
			        					timeline.stop();
			        				}
			        			}
			        		}));
					timeline.playFromStart();
					System.out.println("pressed");
				}
			
			});
			/*VBox vb = new VBox(20);
	        // center the components within VBox
	        vb.setAlignment(Pos.CENTER);
	        // Make it as wide as the application frame (scene)
	        vb.setPrefWidth(scene.getWidth());
	        // Move the VBox down a bit
	        vb.setLayoutY(30);
	        // Add the button and timerLabel to the VBox
	        vb.getChildren().addAll(startTimer, timeLabel, stopTimer, resetTimer);
	        // Add the VBox to the root component
	        root.getChildren().add(vb);*/
	        //scene.getStylesheets().add("forms/Styling.css");
	        
		//}
		
		
		
		public void display(Button button) throws IOException 
		{
			Parent root = FXMLLoader.load(getClass().getResource("Timer.fxml"));
			//this.setTitle("Timer");
			//Group root = new Group();
			Scene scene = new Scene(root, 450, 400);
			scene.getStylesheets().add("forms/Styling.css");
			this.setScene(scene);
			this.show();
		}



		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			
			
			 timeLabel.setText(STARTTIME.toString() + ":00");
		     timeLabel.setTextFill(Color.RED);
		     timeLabel.setStyle("-fx-font-size: 10em;");
			//Button resetTimer = new Button();
			//resetTimer.setText("Reset");
			resetTimer.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					timeSeconds = 0;
					timeMin = STARTTIME ;
					timeLabel.setText(timeMin.toString()+ ":00");
				}
			});
		    //Button stopTimer = new Button();
			//stopTimer.setText("Stop");
			stopTimer.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event){
					timeline.stop();
				}
			});
			//Button startTimer = new Button();
			//startTimer.setText("Start");
			startTimer.setOnAction(e -> {
				
				
				System.out.println("START");
				//public void handle(ActionEvent event) {
					
					
					if (timeline != null){
						System.out.println("timeline not null");
						//timeline.stop();
						
					}else{
					timeMin = STARTTIME;
					timeLabel.setText(timeMin.toString() + ":00");
					}
					//update timer label
					
			        timeline = new Timeline();
			        timeline.setCycleCount(Timeline.INDEFINITE);
			        timeline.getKeyFrames().add(
			        		new KeyFrame(Duration.seconds(1),
			        				new EventHandler<ActionEvent>(){
			        			//keyframe event handler
			        			public void handle(ActionEvent event){
			        				timeSeconds--;
			        				System.out.println("seconds");
			        				boolean isSecondsZero = timeSeconds <= 0;
			        				
			        				if(isSecondsZero){
			        					timeMin--;
			        					timeSeconds = 60;
			        				}
			        				//update timer label
			        				timeLabel.setText(String.format("%d:%02d", timeMin, timeSeconds-1));
			        				if (timeMin == 0 && timeSeconds <= 1){
			        					timeline.stop();
			        				}
			        			}
			        		}));
					timeline.playFromStart();
					System.out.println("pressed");
				//}
			
			});
			
		}
		
	}



