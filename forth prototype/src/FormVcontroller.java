
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
import main.Round;
import javafx.application.Application;



public class FormVcontroller implements Initializable{
	
	public Scene formVScene;
	static Stage window;
	FormBMenu formB = new FormBMenu();
	FormTMenu formT = new FormTMenu();
	FormOMenu formO = new FormOMenu();
	FormSMenu formS = new FormSMenu();
	StartScreen startScreen = new StartScreen();
	private int roundC;
	
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

		public int getRoundCount(){
			return roundC;
		}

		public void setRoundCount(int roundC){
			this.roundC = roundC;
		}
	   
	    
	    public static void setEmployeeWage(int count)
		{
			
		   // Employees = new Label(); 
			System.out.println(String.valueOf("count of employees " + count));
			//Employees.setText(String.valueOf(count));
		}
		
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			ArrayList<Round> formVData = PSDSingleton.getInstance().getFormVData();
			final Round round = null;
			try{
				round.setRoundData(formVData.get(roundC));
				if (round != null){
					Revenues.setText(round.getTotalRevenue());
					Employees.setText(round.getEmployeeWage());
					Employment.setText(round.getAynPay());
					Materials.setText(round.getMaterialsSum());
					Exp.setText(round.getTotalExpenditure());
					ProfitLoss.setText(round.getProfitLoss());
				}
			} catch(Exception e1){
				e1.printStackTrace();
			}


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
					round.setRoundNum(String.valueOf(roundC));
					round.setTotalRevenue(Revenues.getText());
					round.setEmployeeWage(Employees.getText());
					round.setAynPay(Employment.getText());
					round.setMaterialsSum(Materials.getText());
					round.setTotalExpenditure(Exp.getText());
					round.setProfitLoss(ProfitLoss.getText());
					formVData.set(roundC, round);
					PSDSingleton.getInstance().setFormVData(formVData);
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
				if(contractPrice.isEmpty() != true && scheduleTime.isEmpty() != true && actualTime.isEmpty() != true){
					
				
					int Revenue = (Integer.parseInt(contractPrice)- 30 *(Integer.parseInt(actualTime) - Integer.parseInt(scheduleTime)));
					System.out.println("revenue is: " + Revenue);
					totalRevenue += Revenue;
					}
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

			// Display kit price
			Double sum = PSDSingleton.getInstance().getFormOData();
			if (sum != null){
				Materials.setText(String.valueOf(sum));
			} else{
				Materials.setText("");
			}
			// double sum = 0;
			// ArrayList<String[]> orderData = PSDSingleton.getInstance().getFormBData();
			// if (!arr.isEmpty()){
			// 	for (String [] data : orderData){
			// 		OrderHistory ordHist = new OrderHistory(new Order(data[0], data[1], data[2], data[3], data[4], data[5]));
			// 		if (ordHist.getKitPrice() != -1){
			// 			sum+= ordHist.getKitPrice();
			// 		}
			// 		if (sum == 0){
			// 			Materials.setText("");
			// 		}
			// 		else{
			// 			Materials.setText(Double.toString(sum));
			// 		}
			// 	}
			// }
			// else{
			// 	Materials.setText("");
			// }

			//Diplay Total Expenditure
			displayTotal();			
		}
		public void displayTotal(){
			// assert Revenues != null : "fx:id=\"Revenues\" was not injected";
			// assert Employees != null : "fx:id=\"Employees\" was not injected";
			// assert Employment != null : "fx:id=\"Employment\" was not injected";
			// assert Materials != null : "fx:id=\"Materials\" was not injected";
			// Calculate total expenditure
			try{
				double totalExpenditure = 0;
				double revenue = Double.parseDouble(Revenues.getText());
				double employeeCosts = Double.parseDouble(Employees.getText());
				double aynCosts = Double.parseDouble(Employment.getText());
				double materialCosts = Double.parseDouble(Materials.getText());
				
				totalExpenditure = + employeeCosts + aynCosts + materialCosts;
				//System.out.println("rev " + revenue + "empl " + employeeCosts + "ayn " + aynCosts);
				
				Exp.setText(String.valueOf(totalExpenditure));
				ProfitLoss.setText(String.valueOf(revenue - totalExpenditure));
			}catch(Exception e){
				System.out.print(e.toString());
				Exp.setText("0.00");
				ProfitLoss.setText("0.00");
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
