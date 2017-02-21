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
	public static ArrayList<Order> orders = new ArrayList<Order>();
	@Override
	public void start(Stage arg0) throws Exception{
		
		arg0.setTitle("QpQ");
		Main.window = arg0;
		root = (BorderPane)FXMLLoader.load(getClass().getResource("formV.fxml"));
        Scene scene = new Scene(root, 300, 275);
		arg0.setScene(scene);
        arg0.show();
        scene.getStylesheets().add("Styling.css");
	}
	
	public static void main(String[] args){
		launch(args);
	}
}