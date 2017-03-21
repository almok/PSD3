package forms;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.PSDSingleton;
import main.Round;
import main.RoundCounter;



public class FormVcontroller implements Initializable{
	
	public Scene formVScene;
	static Stage window;
	FormBMenu formB = FormBMenu.getInstance();
	FormTMenu formT = FormTMenu.getInstance();
	FormOMenu formO = FormOMenu.getInstance();
	FormSMenu formS = FormSMenu.getInstance();
	StartScreen startScreen = new StartScreen();
	RoundCounter roundCounter = RoundCounter.getInstance();
	int roundCount = roundCounter.getRoundCounter();

	private static FormVcontroller instance = null;

	public static FormVcontroller getInstance() {
		if(instance == null) {
			instance = new FormVcontroller();
	    }
		return instance;
	}

	private ArrayList<String> roundNumArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> totalRevenueArray = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> employeeWageArray = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> aynPayArray = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> materialsSumArray = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> totalExpenditureArray = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> profitLossArray = new ArrayList<String>(Collections.nCopies(20, ""));
	
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
			scene.getStylesheets().add("forms/Styling.css");
			stage.setScene(scene);
			stage.setTitle("QpQ");
			
			Rectangle2D screen = Screen.getPrimary().getVisualBounds();
			stage.setX(screen.getMinX());
			stage.setY(screen.getMinY());
			stage.setWidth(screen.getWidth());
			stage.setHeight(screen.getHeight());
			
		}

		public void saveFields(){
			roundNumArrayList.set(roundCounter.getRoundCounter(), String.valueOf(roundCounter.getRoundCounter()));
			totalRevenueArray.set(roundCounter.getRoundCounter(), Revenues.getText());
			employeeWageArray.set(roundCounter.getRoundCounter(), Employees.getText());
			aynPayArray.set(roundCounter.getRoundCounter(), Employment.getText());
			materialsSumArray.set(roundCounter.getRoundCounter(), Materials.getText());
			totalExpenditureArray.set(roundCounter.getRoundCounter(), Exp.getText());
			profitLossArray.set(roundCounter.getRoundCounter(), ProfitLoss.getText());
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
				int i = roundCounter.getRoundCounter();
				Round rounds = new Round(roundNumArrayList.get(i), totalRevenueArray.get(i), employeeWageArray.get(i), aynPayArray.get(i),
					materialsSumArray.get(i), totalExpenditureArray.get(i), profitLossArray.get(i));
				System.out.println("\nround num " + rounds.getRoundNum());
				formVData.add(rounds);
				PSDSingleton.getInstance().setFormVData(formVData);
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
					if (array.get(j)[9].equals("True")){
						if (Integer.parseInt(array.get(j)[8]) == roundCounter.getRoundCounter()){
							String contractPrice = array.get(j)[2];
							String scheduleTime = array.get(j)[3];
							String actualTime = array.get(j)[4];
							System.out.println("element: " + j + "\n" + 
										"contract price: " + contractPrice + "\n" + 
										"scheduled time: " + scheduleTime + "\n" + 
										"actual time: " + actualTime);
							if(contractPrice.isEmpty() != true && scheduleTime.isEmpty() != true && actualTime.isEmpty() != true){
								int Revenue = (Integer.parseInt(contractPrice) 
										- PSDSingleton.getInstance().getPenalty() *(Integer.parseInt(actualTime) 
										- Integer.parseInt(scheduleTime)));
								System.out.println("revenue is: " + Revenue);
								totalRevenue += Revenue;
							}
						}
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
				for (int i = 0; i < arr.size() ; i++){
					System.out.println("emp " + Integer.parseInt(arr.get(i)[2]));
					if (Integer.parseInt(arr.get(i)[2]) == roundCounter.getRoundCounter()){
						totalWageCost = totalWageCost + PSDSingleton.getInstance().getEmployeeWage(arr.get(i)[1]);
					}
				}
				int roundTime = PSDSingleton.getInstance().getRoundTime();
				
				if (totalWageCost*roundTime != 0){
					Employees.setText(String.valueOf(totalWageCost*roundTime));
				}
			} else {
				Employees.setText("");
			}
			
			// set total AYN expenses
			ArrayList<AYNEmployee> ayn = PSDSingleton.getInstance().getFormTData();
			float totPay = 0;
			for (AYNEmployee emp : ayn){
				if(emp.getRoundCount() == roundCounter.getRoundCounter()){
					totPay += emp.calcWage();
				}
			}
			String pay = String.valueOf(totPay);
			if (totPay == 0.0){
				Employment.setText("");
			}
			else{
				Employment.setText(pay);
			}

			// Display kit price
			
			ArrayList<String[]> orderHistory = PSDSingleton.getInstance().getFormBData();
			// delete duplicates
			for (int i = FormOMenu.getInstance().getOrders().size() - 1; i >= 0; i--){
					FormOMenu.getInstance().getOrders().remove(i);
				
			}
			System.out.println("is empty? " + orderHistory.isEmpty());
			if (!orderHistory.isEmpty()){
				for (String [] data : orderHistory){
					if (Integer.parseInt(data[8]) == roundCounter.getRoundCounter()){
						
						FormOMenu.getInstance().updateOrderHistory(new Order(data[0], data[1], data[2], data[3], data[4], data[5], data[9]));
					}
				}
			}
			
			ArrayList<String> formOData = PSDSingleton.getInstance().getFormOData();
			

			Double kPrice = FormOMenu.getInstance().calcTotalKitPrice();
			
			formOData.set(roundCount, String.valueOf(kPrice));
			
			for(String s : formOData){ 
				System.out.println("---------->>>>>>>> " + s);
			}
			
			PSDSingleton.getInstance().setFormOData(formOData);
			try{
				Double sum = Double.parseDouble(formOData.get(roundCounter.getRoundCounter()));
				Materials.setText(String.valueOf(sum));
			} catch (Exception e) {}

			displayTotal();
			saveFields();		
		}
		public void displayTotal(){
			try{
				double totalExpenditure = 0;
				double revenue = Double.parseDouble(Revenues.getText());
				double employeeCosts = Double.parseDouble(Employees.getText());
				double aynCosts = Double.parseDouble(Employment.getText());
				double materialCosts = Double.parseDouble(Materials.getText());
				
				totalExpenditure = + employeeCosts + aynCosts + materialCosts;
				
				Exp.setText(String.valueOf(totalExpenditure));
				ProfitLoss.setText(String.valueOf(revenue - totalExpenditure));
			}catch(Exception e){
				System.out.print(e.toString());
				Exp.setText("0.00");
				ProfitLoss.setText("0.00");
			}
		
		}
	
}		