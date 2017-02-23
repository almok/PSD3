
import forms.AYNEmployee;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.PSDSingleton;
import javafx.application.Application;



public class FormVcontroller implements Initializable{
	
	public Scene formVScene;
	static Stage window;
	FormBMenu formB = new FormBMenu();
	FormTMenu formT = new FormTMenu();
	FormOMenu formO = new FormOMenu();
	FormSMenu formS = new FormSMenu();
	StartScreen startScreen = new StartScreen();
	
	@FXML
	private Button Rev;
	@FXML
	private Button formTButton;
	@FXML
	private Button formOButton;
	@FXML
	private Button formSButton;
	@FXML 
	private Button backButton;
	@FXML
	public Label Revenues;
	@FXML
	public Label Employees;
	@FXML
	private Label Employment;
	@FXML
	private Label Materials;
	@FXML
	private Label Investments;
	@FXML
	private Label Consultant;
	@FXML
	private Label Exp;
	@FXML
	private Label ProfitLoss;
	

	// display this form
		public void display(Button button) throws IOException{
			Parent parent = FXMLLoader.load(getClass().getResource("formV.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = (Stage) button.getScene().getWindow();
			scene.getStylesheets().add("Styling.css");
			stage.setScene(scene);
			stage.setTitle("QpQ");
			
		}
		
	   
	    
	    public static void setEmployeeWage(int count)
		{
			
		   // Employees = new Label(); 
			System.out.println(String.valueOf("count of employees " + count));
			//Employees.setText(String.valueOf(count));
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

			backButton.setOnAction(e -> {
				try {
					startScreen.display(backButton);
				}catch(IOException e1){
					e1.printStackTrace();
				}
			});
			
	
			// calculate revenue
			ArrayList<String[]> array = PSDSingleton.getInstance().getFormBData();
			if(array.size() > 0){
				int totalRevenue = 0;
				for(int j = 0; j < array.size(); j++ ){
					String contractPrice = array.get(j)[2];
					String scheduleTime = array.get(j)[3];
					String actualTime = array.get(j)[4];
					System.out.println("element: " + j + "\n" + 
										"contract price: " + contractPrice + "\n" + 
										"scheduled time: " + scheduleTime + "\n" + 
										"actual time: " + actualTime);
					int Revenue = (Integer.parseInt(contractPrice) - 30 *(Integer.parseInt(actualTime) - Integer.parseInt(scheduleTime)));
					System.out.println("revenue is: " + Revenue);
					totalRevenue += Revenue;
				}
				System.out.println("total Revenue is " + totalRevenue);
				Revenues.setText(String.valueOf(totalRevenue));
			} else {
				Revenues.setText("");
			}
			
			// calculate employee costs
			ArrayList<String[]> arr = PSDSingleton.getInstance().getFormSData();
			if (arr.size() > 0){
				int totalWageCost = 0;
				for (int i = 0; i < arr.size() ; i ++){
					totalWageCost = totalWageCost + PSDSingleton.getInstance().getEmployeeWage(arr.get(i)[1]);	
				}
				int roundTime = PSDSingleton.getInstance().getRoundTime();

				Employees.setText(String.valueOf(totalWageCost*roundTime));
			} else {
				Employees.setText("");
			}
			
			// set total AYN expenses
			ArrayList<AYNEmployee> ayn = PSDSingleton.getInstance().getFormTData();
			float totPay = 0;
			for (AYNEmployee emp : ayn){
				totPay += emp.calcWage();
			}
			String pay = String.valueOf(totPay);
			if (totPay == 0.0){
				Employment.setText("");
			}
			else{
				Employment.setText(pay);
			}

			// display kitprice
			double sum = 0;
			// for all orders!!!!
			//to do
			OrderHistory ord = new OrderHistory(new Order(null, null, null, null, null, null));
			if (ord.getKitPrice() != -1){
				sum+= ord.getKitPrice();
			}
			if (sum == 0){
				Materials.setText("");
			}
			else{
				Materials.setText(Double.toString(sum));
			}
			
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
