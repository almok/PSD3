
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



public class FormVcontroller {
	
	public Scene formVScene;
	static Stage window;
	FormBMenu formB = new FormBMenu();
	FormTMenu formT = new FormTMenu();
	FormOMenu formO = new FormOMenu();
	
	@FXML
	private Button Rev;
	@FXML
	private Button formTButton;
	@FXML
	private Button formOButton;
	@FXML
	private static TextField Revenues;
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
	
	public static void setRevenue(int revenue)
	{
		
		Revenues.setText(String.valueOf(revenue));
	}
	
	@FXML public void handleRevenueButtonAction(ActionEvent event){
		System.out.println("Button clicked");
		Main.window.setScene(formB.display(this));
	}

	@FXML public void handleFormTButton(ActionEvent event){
		Main.window.setScene(formT.display(this));
	}
	@FXML public void handleFormOButton(ActionEvent event){
		Main.window.setScene(formO.display(this));
	}
		
		

		FormBMenu a;
		public Scene display(FormBMenu a)
		{
			if (this.formVScene == null){
				GridPane gPane = new GridPane();
			
				try {
					Parent root = FXMLLoader.load(a.getClass().getResource("formV.fxml"));
					this.formVScene = new Scene(root, 800 , 700);
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}
			this.formVScene.getStylesheets().add("Styling.css");
			return this.formVScene;
		
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
