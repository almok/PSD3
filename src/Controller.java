import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;

public class Controller implements Initializable {

	@FXML
	private Button StartButton;
	@FXML
	private HBox HBOX;
	@FXML
	private Button EndButton;
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
        EndButton.setOnAction(event -> {
        	System.out.print("End");
        
        });
            
    
        

        
    }
    
    

}