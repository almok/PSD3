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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Timer extends Stage implements Initializable {
	@FXML
	private Button resetTimer;
	@FXML
	private Button startTimer;
	@FXML
	private Button stopTimer;
	@FXML
	private Label timeLabel;

	private Timeline timeline;
	private static final Integer STARTTIME = 0;
	private static final Integer ENDTIME = PSDSingleton.getInstance().getRoundTime();
	private Integer timeSeconds = 0;
	private Integer timeMin = STARTTIME + 1;

	public void display(Button button) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Timer.fxml"));
		// this.setTitle("Timer");
		// Group root = new Group();
		Scene scene = new Scene(root, 450, 400);
		scene.getStylesheets().add("forms/Styling.css");
		this.setScene(scene);
		this.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		timeLabel.setText("00:00");
		timeLabel.setTextFill(Color.RED);
		timeLabel.setStyle("-fx-font-size: 10em;");

		resetTimer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				timeSeconds = 0;
				timeMin = STARTTIME;
				timeLabel.setText("00:00");
			}
		});

		stopTimer.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				timeline.stop();
			}
		});

		startTimer.setOnAction(e -> {

			if (timeline != null) {
				System.out.println("timeline not null");

			} else {
				timeMin = STARTTIME;
				timeLabel.setText("00:00");
			}

			// update timer label
			timeline = new Timeline();
			timeline.setCycleCount(Timeline.INDEFINITE);
			timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

				// keyframe event handler
				public void handle(ActionEvent event) {
					timeSeconds++;

					boolean isSeconds60 = timeSeconds > 59;

					if (isSeconds60) {
						timeMin++;
						timeSeconds = 0;
					}
					// update timer label
					timeLabel.setText(String.format("%02d:%02d", timeMin, timeSeconds));
					if (timeMin == ENDTIME) {
						timeline.stop();
					}
				}
			}));
			timeline.playFromStart();
		});
	}
}