package forms;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.PSDSingleton;
import main.Round;
import main.RoundCounter;

public class FormBMenu implements Initializable {
	RoundCounter roundCounter = RoundCounter.getInstance();
	int roundCount = roundCounter.getRoundCounter();

	private static FormBMenu instance = null;
	
	public static FormBMenu getInstance() {
		if(instance == null) {
			instance = new FormBMenu();
	    }
		return instance;
	}
	
	private ArrayList<Integer> formCountList = new ArrayList<Integer>(Collections.nCopies(20, 0));
	
	private int counter;
	private int formCounter = formCountList.get(roundCount);
	private int currentForm = formCountList.get(roundCount);
	public Scene scene;

	private ArrayList<String> orderArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> chassisArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> productCodeArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> timeOfReceiptArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> leadTimeArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> scheduledDeliveryTimeArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> contractPriceArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> actualDeliveryTimeArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> timeDifferenceArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> penaltyPriceArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<String> revenueArrayList = new ArrayList<String>(Collections.nCopies(20, ""));
	private ArrayList<Integer> roundCountArray = new ArrayList<Integer>(Collections.nCopies(20, 0));

	private void displayValues(int c) {

		orderField.setText(orderArrayList.get(c));
		chassisField.setText(chassisArrayList.get(c));
		productCodeField.setText(productCodeArrayList.get(c));
		timeOfReceiptField.setText(timeOfReceiptArrayList.get(c));
		leadTimeField.setText(leadTimeArrayList.get(c));
		scheduledDeliveryTimeField.setText(scheduledDeliveryTimeArrayList.get(c));
		contractPriceField.setText(contractPriceArrayList.get(c));
		actualDeliveryTimeField.setText(actualDeliveryTimeArrayList.get(c));
		timeDifferenceLabel.setText(timeDifferenceArrayList.get(c));

		// working around to get time difference displaying on reopening an
		// order - to be sorted and cleaned up
		if (!scheduledDeliveryTimeArrayList.get(c).equals("") && !actualDeliveryTimeArrayList.get(c).equals("")) {
			int sch = Integer.parseInt(scheduledDeliveryTimeArrayList.get(c));
			int act = Integer.parseInt(actualDeliveryTimeArrayList.get(c));

			timeDifferenceLabel.setText(String.valueOf(act - sch));
		}

		penaltyPriceField.setText(penaltyPriceArrayList.get(c));
		revenueField.setText(revenueArrayList.get(c));

	}

	private void saveFields(int c) {
		orderArrayList.set(c, orderField.getText());
		chassisArrayList.set(c, chassisField.getText());
		productCodeArrayList.set(c, productCodeField.getText());
		timeOfReceiptArrayList.set(c, timeOfReceiptField.getText());
		leadTimeArrayList.set(c, leadTimeField.getText());
		scheduledDeliveryTimeArrayList.set(c, scheduledDeliveryTimeField.getText());
		contractPriceArrayList.set(c, contractPriceField.getText());
		actualDeliveryTimeArrayList.set(c, actualDeliveryTimeField.getText());
		timeDifferenceArrayList.set(c, timeDifferenceLabel.getText());
		penaltyPriceArrayList.set(c, penaltyPriceField.getText());
		revenueArrayList.set(c, revenueField.getText());
		roundCountArray.set(c, roundCount);

	}

	private void saveFields() {
		int c = currentForm - 1;
		if (c != -1){
			saveFields(c);
		}
		
	}

	public void addFormButtons(VBox left) {

		if (formCounter == 0) {
			formCounter++;
			currentForm = formCounter; // 1
			Button formButton1 = new Button(" Order " + formCounter + " ");

			left.getChildren().add(formButton1);

			centerVBox.setVisible(true);

			// buttons action
			formButton1.setOnAction(e -> {
				saveFields(currentForm - 1);
				currentForm = Integer.parseInt(Character.toString(formButton1.getText().charAt(7)));
				displayValues(currentForm - 1);
				
				if (scheduledDeliveryTimeField.getText() != null && scheduledDeliveryTimeField.getText().length() != 0
						&& actualDeliveryTimeField.getText() != null && actualDeliveryTimeField.getText().length() != 0) {

					int revenue = 0;
					int actualTime = Integer.parseInt(actualDeliveryTimeField.getText());
					int schedTime = Integer.parseInt(scheduledDeliveryTimeField.getText());

					timeDifferenceLabel.setText(Integer.toString(actualTime - schedTime));
					int penalty = 30 * (actualTime - schedTime);
					penaltyPriceField.setText(Integer.toString(penalty));
					revenue = Integer.parseInt(contractPriceField.getText()) - penalty;
					revenueField.setText(Integer.toString(revenue));
				}
				
				
			});
		} else if (formCounter >= 1 && formCounter < 9) {
			centerVBox.setVisible(true);
			formCounter++;
			Button formButton = new Button(" Order " + formCounter + " ");
			left.getChildren().add(formButton);
			
			formButton.setOnAction(e -> {
				
				saveFields(currentForm - 1);
				currentForm = Integer.parseInt(Character.toString(formButton.getText().charAt(7)));
				displayValues(currentForm - 1);
				
				if (scheduledDeliveryTimeField.getText() != null && scheduledDeliveryTimeField.getText().length() != 0
						&& actualDeliveryTimeField.getText() != null && actualDeliveryTimeField.getText().length() != 0) {

					int revenue = 0;
					int actualTime = Integer.parseInt(actualDeliveryTimeField.getText());
					int schedTime = Integer.parseInt(scheduledDeliveryTimeField.getText());

					timeDifferenceLabel.setText(Integer.toString(actualTime - schedTime));
					int penalty = 30 * (actualTime - schedTime);
					penaltyPriceField.setText(Integer.toString(penalty));
					revenue = Integer.parseInt(contractPriceField.getText()) - penalty;
					revenueField.setText(Integer.toString(revenue));
				}
			});
		} else if (formCounter >= 9 && formCounter < 20) {
			
			formCounter++;
			centerVBox.setVisible(true);
			Button formButton = new Button("Order " + formCounter);

			left.getChildren().add(formButton);

			formButton.setOnAction(e -> {
				
				saveFields(currentForm);
				
				String currF = Character.toString(formButton.getText().charAt(6));
				currF += Character.toString(formButton.getText().charAt(7));
				currentForm = Integer.parseInt(currF);
				
				displayValues(currentForm - 1);
				if (scheduledDeliveryTimeField.getText() != null && scheduledDeliveryTimeField.getText().length() != 0
						&& actualDeliveryTimeField.getText() != null && actualDeliveryTimeField.getText().length() != 0) {

					int revenue = 0;
					int actualTime = Integer.parseInt(actualDeliveryTimeField.getText());
					int schedTime = Integer.parseInt(scheduledDeliveryTimeField.getText());

					timeDifferenceLabel.setText(Integer.toString(actualTime - schedTime));
					int penalty = 30 * (actualTime - schedTime);
					penaltyPriceField.setText(Integer.toString(penalty));
					revenue = Integer.parseInt(contractPriceField.getText()) - penalty;
					revenueField.setText(Integer.toString(revenue));
				}
			});
		}
		formCountList.set(roundCount,formCounter);
	}

	@FXML
	private Button backButton;
	@FXML
	private Button newButton;
	@FXML
	private Button deleteButton;
	@FXML
	private VBox leftVBox, centerVBox;
	@FXML
	private TextField orderField;
	@FXML
	private TextField chassisField;
	@FXML
	private TextField productCodeField;
	@FXML
	private TextField timeOfReceiptField;
	@FXML
	private TextField leadTimeField;
	@FXML
	private TextField scheduledDeliveryTimeField;
	@FXML
	private TextField contractPriceField;
	@FXML
	private TextField actualDeliveryTimeField;
	@FXML
	private Label timeDifferenceLabel;
	@FXML
	private TextField penaltyPriceField;
	@FXML
	private TextField revenueField;
	@FXML
	private static Button form1;
	@FXML
	private static Button form2;
	@FXML
	private static Button form3;

	ObservableList<Order> orders = FXCollections.observableArrayList();

	public void createNewOrder() {

		Order order = new Order(null, null, null, null, null, null);
		orders.add(order);
		saveFields();
		addFormButtons(leftVBox);
	}

	// save order objects to observable list
	private void saveOrders(int forms) {
		orders.clear();
		for (int i = 0; i < forms; i++) {
			// creates new order
			Order order = new Order(null, null, null, null, null, null);

			// gets order details and sets
			order.setContractPrice(contractPriceArrayList.get(i));
			order.setOrderNumber(orderArrayList.get(i));
			order.setScheduleTime(scheduledDeliveryTimeArrayList.get(i));
			order.setActualTime(actualDeliveryTimeArrayList.get(i));
			order.setProductCode(productCodeArrayList.get(i));
			order.setPenalty(penaltyPriceArrayList.get(i));
			order.setScheLeadTime(leadTimeArrayList.get(i));
			order.setReceiptTime(timeOfReceiptArrayList.get(i));
			System.out.println("order saved");
			// adds order to list
			orders.add(order);
			
		}
	}

	private void deleteOrder() {
		
		//saveOrders(formCounter);
		
		//currentForm = formCountList.get(roundCount);
		System.out.println("form counter is " + formCounter);
		if (currentForm != 0) {
			
			FormBMenu formB = FormBMenu.getInstance();
			ArrayList<String[]> formBData = PSDSingleton.getInstance().getFormBData();
			int i = 0;
			// find current form in sinlgeton
			System.out.println("Current form:" + currentForm);
			/*while (!formBData.get(i)[0].equals(orderArrayList.get(currentForm - 1)) 
					&& Integer.parseInt(formBData.get(i)[8]) != roundCount
					&& formBData.get(i) != null){
					i++;
			}*/
			int j;
			for( j = 0 ; j < formBData.size(); j++)
			{
				//check round
				if (Integer.parseInt(formBData.get(j)[8]) == roundCount)
				{
					//check order numbers
					System.out.println("form B data round count" + formBData.get(j)[8]);
					if(Integer.parseInt(formBData.get(j)[0]) == Integer.parseInt(orderArrayList.get(currentForm - 1 )))
							{
								System.out.println("True\n");
								formBData.remove(j);
								break;
							}
				}
			}
			//System.out.println("form B data order number:"+formBData.get(j)[0]);
			System.out.println("order arraylist order number " + orderArrayList.get(currentForm - 1));
			
			// remove entries from arrayList
			orderArrayList.remove(currentForm -1);
			chassisArrayList.remove(currentForm - 1);
			productCodeArrayList.remove(currentForm-1);
			timeOfReceiptArrayList.remove(currentForm-1);
			leadTimeArrayList.remove(currentForm-1);
			scheduledDeliveryTimeArrayList.remove(currentForm-1);
			contractPriceArrayList.remove(currentForm-1);
			actualDeliveryTimeArrayList.remove(currentForm-1);
			timeDifferenceArrayList.remove(currentForm-1);
			penaltyPriceArrayList.remove(currentForm-1);
			revenueArrayList.remove(currentForm-1);
			roundCountArray.remove(currentForm-1);


			formCounter--;

			// remove order button //Point of bug
			//ArrayList<String[]> formBData = new ArrayList<>();

			// saves orders

			saveOrders(formCounter);

			// iterate orders adding to formB Data
			for (int k = 0; k < orders.size(); k++) {
				// add buttons
				counter = k;
				Button formButton = new Button(" Order " + (counter + 1) + " ");
				leftVBox.getChildren().add(formButton);
				formButton.setOnAction(e -> {
					currentForm = counter + 1;
					displayValues(counter);
				});

				/*String orderNum = orders.get(k).getOrderNumber();
				String productCode = orders.get(k).getProductCode();
				String contractPrice = orders.get(k).getContractPrice();
				String scheduleTime = orders.get(k).getScheduleTime();
				String actualTime = orders.get(k).getActualTime();
				String penalty = orders.get(k).getPenalty();
				String scheLeadTime = orders.get(k).getScheLeadTime();
				String receiptTime = orders.get(k).getReceiptTime();
				if (orderNum != "" && contains(formBData, orderNum) == false) {
					String[] _order = new String[9];
					_order[0] = orderNum;
					_order[1] = productCode;
					_order[2] = contractPrice;
					_order[3] = scheduleTime;
					_order[4] = actualTime;
					_order[5] = penalty;
					_order[6] = scheLeadTime;
					_order[7] = receiptTime;
					_order[8] = String.valueOf(roundCount);

					formBData.add(_order);
				}
			}

			PSDSingleton.getInstance().setFormBData(formBData);*/
			}
			// refresh page
			try {
				formB.display(deleteButton);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private boolean isInputValid(int formNo) {
		String errorMessage = "";

		if (orderField.getText() == null || orderField.getText().length() == 0) {
			errorMessage += "No valid Order Number.\n";
		} else {
			try {
				Integer.parseInt(orderField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid Order Number(must be an integer)\n";
			}
		}
		if (chassisField.getText() == null || chassisField.getText().length() == 0) {
			errorMessage += "No valid Product Code.\n";
		}
		if (scheduledDeliveryTimeField.getText() == null || scheduledDeliveryTimeField.getText().length() == 0) {
			errorMessage += "No valid Scheduled delivery time.\n";
		} else {
			try {
				Integer.parseInt(scheduledDeliveryTimeField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid scheduled delivery time (must be an integer)\n";
			}
		}
		if (actualDeliveryTimeField.getText() == null || actualDeliveryTimeField.getText().length() == 0) {
			errorMessage += "No valid Actual Delivery time.\n";
		} else {
			try {
				Integer.parseInt(actualDeliveryTimeField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid Actual Delivery time(must be an integer)\n";
			}
		}
		
		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error in Order Form: Order " + Integer.toString(formNo));
			alert.setHeaderText("Error, invalid input");
			alert.setContentText(errorMessage);

			alert.showAndWait();
			return false;
		}

	}
	
	boolean contains(ArrayList<String[]> formBData, String orderNum){
		for (int i = 0; i < formBData.size(); i++){
			if (formBData.get(i)[0].equals(orderNum) && Integer.parseInt(formBData.get(i)[8]) == roundCount){
				return true;
			}
		}
		return false;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// if there is data in forms simulate adding new order

		ArrayList<String[]> array = PSDSingleton.getInstance().getFormBData();

		for (int i = 0; i < array.size(); i++) {

			if (Integer.parseInt(array.get(i)[8]) == roundCount){
				if (array.get(i)[0].isEmpty() != true) {
					orderArrayList.set(formCounter, array.get(i)[0]);

				}
				if (array.get(i)[1].isEmpty() != true) {
					productCodeArrayList.set(formCounter, array.get(i)[1]);
				}
				if (array.get(i)[2].isEmpty() != true) {
					contractPriceArrayList.set(formCounter, array.get(i)[2]);
				}
				if (array.get(i)[3].isEmpty() != true) {
					scheduledDeliveryTimeArrayList.set(formCounter, array.get(i)[3]);
				}
				if (array.get(i)[4].isEmpty() != true) {
					actualDeliveryTimeArrayList.set(formCounter, array.get(i)[4]);
				}
				if (array.get(i)[5].isEmpty() != true) {
					penaltyPriceArrayList.set(formCounter, array.get(i)[5]);
				}
					
				if (array.get(i)[6].isEmpty() != true) {
					leadTimeArrayList.set(formCounter, array.get(i)[6]);
				}
						
				if (array.get(i)[7].isEmpty() != true) {
					timeOfReceiptArrayList.set(formCounter, array.get(i)[7]);
				}
				
				if (array.get(i)[3].isEmpty() != true && array.get(i)[4].isEmpty() != true) {

					int sch = (Integer.parseInt(array.get(i)[3]));
					int act = (Integer.parseInt(array.get(i)[4]));

					int timeDiff = act - sch;

					timeDifferenceArrayList.set(formCounter, String.valueOf(timeDiff));
				}
				
				addFormButtons(leftVBox);
			}
		}

		if (formCountList.get(roundCount) != 0) {
			currentForm = formCountList.get(roundCount);
			formCounter = currentForm;
		}
		if (currentForm != 0) {
			displayValues(currentForm - 1);
		} else {
			displayValues(0);
		}
		
		// automatically add chassis
		if (Order.isCodeValid(productCodeField.getText())) {
			if (scheduledDeliveryTimeField.getText() == "") {
				contractPriceField.setText("0");
			} else {
				String carName = getCarName();
				getContPrice(carName, scheduledDeliveryTimeField.getText());
			}
		} else {
			contractPriceField.setText("0");
		}
		
		// automatically add penalty and revenue and contract price
		if (scheduledDeliveryTimeField.getText() != null && scheduledDeliveryTimeField.getText().length() != 0
				&& actualDeliveryTimeField.getText() != null && actualDeliveryTimeField.getText().length() != 0) {

			try {
				int penalty = 0;
				int revenue = 0;
				int actualTime = Integer.parseInt(actualDeliveryTimeField.getText());
				int schedTime = Integer.parseInt(scheduledDeliveryTimeField.getText());

				penalty = 30 * (actualTime - schedTime);
				penaltyPriceField.setText(Integer.toString(penalty));
				revenue = Integer.parseInt(contractPriceField.getText()) - penalty;
				revenueField.setText(Integer.toString(revenue));
			} catch (Exception e) {
				System.out.println("entered actual delivery time is not a number");
			}
		}

		backButton.setOnAction(e -> {
			saveFields();
			boolean toSave = true;
			for (int i = 1; i <= formCounter; i++){
				displayValues(i-1);
				currentForm = i;
				if (!isInputValid(i)){
					toSave = false;
					break;
				}
			}
			if (toSave){  //if (isInputValid()) {
				saveOrders(formCounter);
			

				//ArrayList<String[]> formBData = new ArrayList<>();
				ArrayList<String[]> formBData = PSDSingleton.getInstance().getFormBData();

				// iterate orders adding to formB Data
				for (int k = 0; k < orders.size(); k++) {
					String orderNum = orders.get(k).getOrderNumber();
					String productCode = orders.get(k).getProductCode();
					String contractPrice = orders.get(k).getContractPrice();
					String scheduleTime = orders.get(k).getScheduleTime();
					String actualTime = orders.get(k).getActualTime();
					String penalty = orders.get(k).getPenalty();
					String scheLeadTime = orders.get(k).getScheLeadTime();
					String receiptTime = orders.get(k).getReceiptTime();
					if (orderNum != "" && contains(formBData, orderNum) == false) {
						String[] _order = new String[9];
						_order[0] = orderNum;
						_order[1] = productCode;
						_order[2] = contractPrice;
						_order[3] = scheduleTime;
						_order[4] = actualTime;
						_order[5] = penalty;
						_order[6] = scheLeadTime;
						_order[7] = receiptTime;
						_order[8] = String.valueOf(roundCount);

						

						formBData.add(_order);
					}
				}

				PSDSingleton.getInstance().setFormBData(formBData);

				FormVcontroller formV = FormVcontroller.getInstance();	

				try {
					formV.display(backButton);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}   
		});


		actualDeliveryTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			if (scheduledDeliveryTimeField.getText() != null && scheduledDeliveryTimeField.getText().length() != 0
					&& actualDeliveryTimeField.getText() != null && actualDeliveryTimeField.getText().length() != 0) {

				try {
					int penalty = 0;
					int revenue = 0;
					int actualTime = Integer.parseInt(actualDeliveryTimeField.getText());
					int schedTime = Integer.parseInt(scheduledDeliveryTimeField.getText());

					timeDifferenceLabel.setText(Integer.toString(actualTime - schedTime));
					penalty = 30 * (actualTime - schedTime);
					penaltyPriceField.setText(Integer.toString(penalty));
					revenue = Integer.parseInt(contractPriceField.getText()) - penalty;
					revenueField.setText(Integer.toString(revenue));
				} catch (Exception e) {
					System.out.println("entered actual delivery time is not a number");
				}
			}
		});

		// add change listener to scheduled time to calculate contract price
		// immediately
		leadTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (Order.isCodeValid(productCodeField.getText())) {
				if (leadTimeField.getText() == "") {
					contractPriceField.setText("0");
				} else {
					String carName = getCarName();
					getContPrice(carName, leadTimeField.getText());
				}
			} else {
				contractPriceField.setText("0");
			}
		});
		
		scheduledDeliveryTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			if (scheduledDeliveryTimeField.getText() != null && scheduledDeliveryTimeField.getText().length() != 0
					&& actualDeliveryTimeField.getText() != null && actualDeliveryTimeField.getText().length() != 0) {

				try {
					int penalty = 0;
					int revenue = 0;
					int actualTime = Integer.parseInt(actualDeliveryTimeField.getText());
					int schedTime = Integer.parseInt(scheduledDeliveryTimeField.getText());

					timeDifferenceLabel.setText(Integer.toString(actualTime - schedTime));
					penalty = 30 * (actualTime - schedTime);
					penaltyPriceField.setText(Integer.toString(penalty));
					revenue = Integer.parseInt(contractPriceField.getText()) - penalty;
					revenueField.setText(Integer.toString(revenue));
				} catch (Exception e) {
					System.out.println("entered actual delivery time is not a number");
				}
			}
		});

		// add change listener to product code
		productCodeField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (Order.isCodeValid(productCodeField.getText())) {
				String carName = getCarName();

				if (scheduledDeliveryTimeField.getText().length() != 0) {
					getContPrice(carName, scheduledDeliveryTimeField.getText());
				}
			} else {
				chassisField.setText("");
				contractPriceField.setText("0");
			}
		});

		deleteButton.setOnAction(event -> {
			deleteOrder();
		});

		newButton.setOnAction(event -> {

			addFormButtons(leftVBox);
			saveFields(currentForm - 1);
			currentForm = formCounter;
			displayValues(currentForm - 1);

		});

	}

	// display this form
	public void display(Button button) throws IOException {

		Parent parent = FXMLLoader.load(getClass().getResource("formB.fxml"));
		Scene scene = new Scene(parent);
		Stage stage = (Stage) button.getScene().getWindow();

		scene.getStylesheets().add("forms/Styling.css");
		stage.setScene(scene);

		// stage.setMaximized(true);

	}

	// extract a car name from a valid product code
	private String getCarName() {
		String carName = "";
		String prodLine = Character.toString(productCodeField.getText().charAt(0));
		String chassis = Character.toString(productCodeField.getText().charAt(1));
		chassis += Character.toString(productCodeField.getText().charAt(2));

		switch (prodLine.toLowerCase()) {
		case "f":
			carName = "Family ";
			break;
		case "P":
		case "p":
			carName = "Pony ";
			break;
		case "S":
		case "s":
			carName = "Sedan ";
			break;
		case "A":
		case "a":
			carName = "Ayrton ";
			break;
		case "C":
		case "c":
			carName = "Coast";
			break;
		case "T":
		case "t":
			carName = "Thunder";
			break;
		}

		switch (chassis.toLowerCase()) {
		case "st":
			chassisField.setText("Standard");
			carName += "Standard";
			break;
		case "dr":
			chassisField.setText("Dragstar");
			carName += "Dragstar";
			break;
		case "de":
			chassisField.setText("Deluxe");
			carName += "Deluxe";
			break;
		case "ss":
			chassisField.setText("Special");
			break;

		}
		return carName;
	}

	// convert time input into a correct integer for a contract price call
	private void getContPrice(String carName, String time) {

		try {
			Double t = Double.parseDouble(leadTimeField.getText());
			int price;

			if (t < 0 || t > 10) {
				price = 0;
			} else if (t < 1) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "1");
			} else if (t < 2) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "2");
			} else if (t < 3) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "3");
			} else if (t < 4) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "4");
			} else if (t < 5) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "5");
			} else if (t < 6) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "6");
			} else if (t < 7) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "7");
			} else if (t < 8) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "8");
			} else if (t < 9) {
				price = PSDSingleton.getInstance().getContractPrice(carName, "9");
			} else {
				price = PSDSingleton.getInstance().getContractPrice(carName, "10");
			}

			if (price != 0) {
				contractPriceField.setText(Integer.toString(price));
			} else {
				contractPriceField.setText("0");
			}

		} catch (Exception e) {
			System.out.println("entered time is not a number");
		}
	}
}
