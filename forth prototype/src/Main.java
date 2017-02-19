import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	
	static Stage window;
	static Stage thestage;
	FormVcontroller a;
	static GridPane root;
	@Override
	public void start(Stage arg0) throws Exception{
		
		arg0.setTitle("QpQ");
		Main.window = arg0;
		root = (GridPane)FXMLLoader.load(getClass().getResource("formV.fxml"));
        arg0.setScene(new Scene(root, 300, 275));
        arg0.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
}