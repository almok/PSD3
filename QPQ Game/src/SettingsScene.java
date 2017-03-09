
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class SettingsScene implements Initializable{
	@FXML private Button gameRulesButton;
	@FXML private Button formCButton;
	@FXML private Button formDButton;
	@FXML private Button formPButton;
	@FXML private Button formRButton;
	@FXML private Button backButton;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 assert gameRulesButton != null : "fx:id=\"startButton\" was not injected";
		 assert formCButton != null : "fx:id=\"formCButton\" was not injected";
		 assert formDButton != null : "fx:id=\"formDButton\" was not injected";
		 assert formPButton != null : "fx:id=\"formPButton\" was not injected";
		 assert formRButton != null : "fx:id=\"formRButton\" was not injected";
		 gameRulesButton.setOnAction(e -> {
			 this.openPage("GameRules.fxml" , e.getSource());
		 });
		 
		 formCButton.setOnAction(e -> {
			 this.openPage("EditFormC.fxml" , e.getSource());
		 });
		 formDButton.setOnAction(e -> {
			 this.openPage("EditFormD.fxml" , e.getSource());
		 });
		 formPButton.setOnAction(e -> {
			 this.openPage("EditFormP.fxml" , e.getSource());
		 });
		 formRButton.setOnAction(e -> {
			 this.openPage("EditFormR.fxml" , e.getSource());
		 });
		 backButton.setOnAction(e -> {
		 	StartScreen startScreen = new StartScreen();
		 	try{
		 		startScreen.display(backButton);	
		 	}catch(IOException e1){
		 		e1.printStackTrace();
		 	}
		 });
	}
	private void openPage(String fxml , Object source) {		
		try {
			Parent root = FXMLLoader.load(getClass().getResource(fxml));
			Scene scene = new Scene(root, 800, 700);
			Stage appStage = (Stage) ((Node) source).getScene().getWindow();
	        appStage.setTitle("Settings");
	        appStage.setScene(scene);
	        appStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void display(Button button) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("SettingsScene.fxml"));
		Scene scene = new Scene(parent);
		Stage stage = (Stage) button.getScene().getWindow();
		scene.getStylesheets().add("Styling.css");	
		stage.setScene(scene);
		stage.setTitle("QpQ");
			
		}
}