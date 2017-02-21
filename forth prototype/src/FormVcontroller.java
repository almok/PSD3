
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;



public class FormVcontroller implements Initializable{
	
	public Scene formVScene;
	static Stage window;
	FormBMenu formB = new FormBMenu();
	FormTMenu formT = new FormTMenu();
	FormOMenu formO = new FormOMenu();
	FormSMenu formS = new FormSMenu();
	
	@FXML
	private Button Rev;
	@FXML
	private Button formTButton;
	@FXML
	private Button formOButton;
	@FXML
	private Button formSButton;
	@FXML
	public static TextField Revenues;
	@FXML
	private TextField Employees;
	@FXML
	private TextField Employment;
	@FXML
	private TextField Materials;
	@FXML
	private TextField Investments;
	@FXML
	private TextField Consultant;
	@FXML
	private TextField Exp;
	@FXML
	private TextField ProfitLoss;
	

	// display this form
		public void display(Button button) throws IOException{
			Parent parent = FXMLLoader.load(getClass().getResource("formV.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = (Stage) button.getScene().getWindow();
			scene.getStylesheets().add("Styling.css");
			stage.setScene(scene);
			stage.setTitle("QpQ");
			
		}
		
	    public static void setRevenue(int revenue)
		{
			
		    Revenues = new TextField(); 
			System.out.println(String.valueOf(revenue));
			Revenues.setText(String.valueOf(revenue));
		}
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			Rev.setOnAction(e -> {
				try{
					formB.display(Rev);
				}catch(IOException e1){
					e1.printStackTrace();
				}
			});
			
			formTButton.setOnAction(e -> {
				try{
					formT.display(formTButton);
				}catch(IOException e1){
					e1.printStackTrace();
				}
			});
			
			formOButton.setOnAction(e -> {
				try{
					formO.display(formOButton);
				}catch(IOException e1){
					e1.printStackTrace();
				}
			});
			
			formSButton.setOnAction(e -> {
				try{
					formS.display(formSButton);
				}catch(IOException e1){
					e1.printStackTrace();
				}
			});
		}
	
}		
		
		
		
		
		
	
			
			/*if (event.getSource() == revenueButton){

				System.out.println(this.rev.getText());
				Main.window.setScene(formB.display(this , rev));
			} else if (event.getSource() == goodsHistoryButton){
				if (formOScene == null){
					formOScene = FormOMenu.display();
				}
				Main.window.setScene(formOScene );
			}  else if (event.getSource() == employmentAgencyButton){
				if (formTScene == null){
					formTScene = FormTMenu.display();
				}
				Main.window.setScene(formTScene);
			} 
		}
*/
