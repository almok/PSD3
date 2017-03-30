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
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.GameScreen;
import main.PSDSingleton;
import main.RoundCounter;
import main.Timer;

public class StartScreen implements Initializable, EventHandler<ActionEvent> {
	@FXML
	private Button startButton;
	@FXML
	private Button exportButton;
	@FXML
	private Button importButton;
	@FXML
	private Button reportButton;
	@FXML
	private Button timerButton;
	@FXML
	private Button backButton;
	@FXML
	private HBox leftVBox;
	@FXML
	private Label rightLabel;
	@FXML
	private AnchorPane aPane;
	@FXML
	private SplitPane sPane;
	@FXML
	private Text text;

	public void display(Button button) throws IOException {
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

	// Round count to act as a unique ID for all saved data.
	RoundCounter roundCounter = RoundCounter.getInstance();

	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == startButton) {
			// Add new round to game
			addRoundButton(leftVBox);
			roundCounter.incRoundCounter();
		} else if (event.getSource() == reportButton) {
			// Generate .csv file with headers, further detailed in PSDSingleton
			PSDSingleton.getInstance().reportData();
		} else if (event.getSource() == timerButton) {
			// Display timer in separate window
			Timer timer = new Timer();
			try {
				timer.display(timerButton);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (event.getSource() == backButton) {
			// Clear all data before exiting game lobby (StartScreen)
			GameScreen GameScreen = new GameScreen();
			PSDSingleton.clear();
			roundCounter.setRoundCounter(0);
			roundCounter.setMaxCount(0);
			try {
				GameScreen.display(backButton);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (event.getSource() == exportButton) {
			// Export to 4 .csv files, each dedicated to a different form.
			PSDSingleton.getInstance().exportData();
		} else if (event.getSource() == importButton) {
			// Import from .csv files. Must look exactly like file produced from
			// export
			PSDSingleton.getInstance().importData();
		}
	}

	// Method to add and assign roundcount to button.
	public void addRoundButton(HBox left) {
		Button roundButton;
		left.setSpacing(10);
		if (roundCounter.getRoundCounter() < PSDSingleton.getInstance().getNumberOfRounds()) {
			if (roundCounter.getRoundCounter() == 0) {
				roundButton = new Button(" Trial Round ");
				roundButton.setMinWidth(99);
				roundButton.setMinHeight(37);
			} else {
				roundButton = new Button(" Round " + roundCounter.getRoundCounter() + " ");
				roundButton.setMinWidth(99);
				roundButton.setMinHeight(37);
			}
			left.getChildren().add(roundButton);
			roundButton.setOnAction(e -> {
				String buttonTxt = roundButton.getText().replaceAll("\\D+", "");
				try {
					roundCounter.setRoundCounter(Integer.parseInt(buttonTxt));
				} catch (Exception e1) {
					roundCounter.setRoundCounter(0);
				}
				FormVcontroller formVMenu = new FormVcontroller();
				try {
					formVMenu.display(roundButton);
				} catch (Exception e1) {
				}
			});
			roundCounter.setMaxCount(roundCounter.getRoundCounter());
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		sPane.setStyle("-fx-background: #363738;");
		aPane.setStyle("-fx-background: #363738;");
		text.setStyle("-fx-fill: #ffffff");

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

		// Reload all Round buttons when returning to startscreen
		if (roundCounter.getMaxCount() >= -1) {
			int i = roundCounter.getMaxCount();
			roundCounter.setRoundCounter(0);
			while (roundCounter.getRoundCounter() <= i) {
				addRoundButton(leftVBox);
				roundCounter.incRoundCounter();
			}
		}
	}
}