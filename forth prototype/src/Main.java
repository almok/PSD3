import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	
	static Stage window;
	static Stage thestage;
	FormVcontroller a;
	static BorderPane root;
	
	@Override
	public void start(Stage stage) throws Exception{
		
		stage.setTitle("QpQ");
		Main.window = stage;
		root = (BorderPane)FXMLLoader.load(getClass().getResource("formV.fxml"));
        Scene scene = new Scene(root, 700, 500);
        scene.getStylesheets().add("Styling.css");
		stage.setScene(scene);
		
        stage.show();
        stage.setMaximized(true);
	}
	
	public static void main(String[] args){
		launch(args);
	}
}