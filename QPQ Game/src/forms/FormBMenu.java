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

public class FormBMenu implements Initializable {
	// private static Button backButton;

	private int counter;
	private int formCounter = 0;
	private int currentForm = 0;
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

	private ArrayList<Integer> revenues = new ArrayList<Integer>(Collections.nCopies(20, 0));

	private void calculateTimeDif() {
		String timeDif;

		int Actual = Integer.parseInt(actualDeliveryTimeField.getText());
		int scheduled = Integer.parseInt(scheduledDeliveryTimeField.getText());
		timeDif = String.valueOf(Actual - scheduled);
		timeDifferenceLabel.setText(timeDif);
		saveFields();

	}

	private int isInteger(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return 0;
		} catch (NullPointerException e) {
			return 0;
		}
	}

	private void displayValues(int c) {
		System.out.println("displaying values : " + c);
		System.out.println("field one display :" + orderArrayList.get(c));
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

	/*
	 * private void displayOrders(){ int j = 0; for(Order order: orders) {
	 * //orderArrayList.set(j, order.get); //chassisArrayList.set(j,
	 * chassisField.getText()); //productCodeArrayList.set(j,
	 * productCodeField.getText()); //timeOfReceiptArrayList.set(j,
	 * timeOfReceiptField.getText()); //leadTimeArrayList.set(j,
	 * leadTimeField.getText()); scheduledDeliveryTimeArrayList.set(j,
	 * order.getScheduleTime()); contractPriceArrayList.set(j,
	 * order.getContractPrice()); actualDeliveryTimeArrayList.set(j,
	 * order.getActualTime()); //timeDifferenceArrayList.set(j,
	 * timeDifferenceLabel.getText()); //penaltyPriceArrayList.set(j,
	 * penaltyPriceField.getText()); //revenueArrayList.set(j,
	 * revenueField.getText()); j++; addFormButtons(leftVBox); }
	 */

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

	}

	private void saveFields() {
		int c = formCounter - 1;
		saveFields(c);
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
				System.out.println(Integer.parseInt(Character.toString(formButton1.getText().charAt(7))));

				System.out.println("current form is :" + currentForm);
				// System.out.println("values in field 1 :" + );
				displayValues(currentForm - 1);
			});
		} else if (formCounter >= 1 && formCounter < 9) {
			centerVBox.setVisible(true);
			formCounter++;
			Button formButton = new Button(" Order " + formCounter + " ");
			// Order order = new Order(Integer.toString(c), null, null, null,
			// null, null);

			left.getChildren().add(formButton);
			formButton.setOnAction(e -> {
				saveFields(currentForm - 1);
				currentForm = Integer.parseInt(Character.toString(formButton.getText().charAt(7)));
				System.out.println("current form is :" + currentForm);
				// if (isInputValid()) {

				displayValues(currentForm - 1);
				// }
			});
		} else if (formCounter >= 9 && formCounter < 20) {
			formCounter++;
			centerVBox.setVisible(true);
			Button formButton = new Button("Order " + formCounter);
			// Order order = new Order(Integer.toString(c), null, null, null,
			// null, null);

			left.getChildren().add(formButton);

			formButton.setOnAction(e -> {
				saveFields(currentForm);
				String currF = Character.toString(formButton.getText().charAt(6));
				currF += Character.toString(formButton.getText().charAt(7));
				currentForm = Integer.parseInt(currF);
				//if (isInputValid()) {
					
					displayValues(currentForm - 1);
				//}
			});
		}
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
			System.out.println("Saving order number " + i + " as " + orderArrayList.get(i));
			order.setContractPrice(contractPriceArrayList.get(i));
			order.setOrderNumber(orderArrayList.get(i));
			System.out.println("order number is " + order.getOrderNumber() + " at a position " + i);
			order.setScheduleTime(scheduledDeliveryTimeArrayList.get(i));
			order.setActualTime(actualDeliveryTimeArrayList.get(i));
			order.setProductCode(productCodeArrayList.get(i));
			order.setPenalty(penaltyPriceArrayList.get(i));
			// adds order to list
			orders.add(order);
		}
	}

	private void deleteOrder() {

		if (currentForm != 0) {
			// System.out.println("number of orders : " + totalOrders);
			FormBMenu formB = new FormBMenu();
			// remove entries from arrayList
			orderArrayList.remove(currentForm - 1);
			for (int i = 0; i < orderArrayList.size(); i++) {
				System.out.println("--- " + orderArrayList.get(i) + " at pos " + i);
			}
			chassisArrayList.remove(currentForm - 1);
			productCodeArrayList.remove(currentForm - 1);
			timeOfReceiptArrayList.remove(currentForm - 1);
			leadTimeArrayList.remove(currentForm - 1);
			scheduledDeliveryTimeArrayList.remove(currentForm - 1);
			contractPriceArrayList.remove(currentForm - 1);
			actualDeliveryTimeArrayList.remove(currentForm - 1);
			timeDifferenceArrayList.remove(currentForm - 1);
			penaltyPriceArrayList.remove(currentForm - 1);
			revenueArrayList.remove(currentForm - 1);

			formCounter--;

			// remove order button
			ArrayList<String[]> formBData = new ArrayList<>();

			// saves orders

			saveOrders(formCounter);
			for (int i = 0; i < orders.size(); i++) {
				System.out.println("+++ " + orders.get(i).getOrderNumber());
			}
			// orders.remove(currentForm - 1);

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

				String orderNum = orders.get(k).getOrderNumber();
				System.out.println("order number saved :" + orderNum);
				String productCode = orders.get(k).getProductCode();
				String contractPrice = orders.get(k).getContractPrice();
				String scheduleTime = orders.get(k).getScheduleTime();
				String actualTime = orders.get(k).getActualTime();
				String penalty = orders.get(k).getPenalty();
				if (orderNum != "") {
					String[] _order = new String[6];
					_order[0] = orderNum;
					_order[1] = productCode;
					_order[2] = contractPrice;
					_order[3] = scheduleTime;
					_order[4] = actualTime;
					_order[5] = penalty;

					formBData.add(_order);
				}
			}

			// System.out.println("field 1 saved :" + formBData.get(0)[0]);
			PSDSingleton.getInstance().setFormBData(formBData);

			// refresh page
			try {
				formB.display(deleteButton);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private boolean isInputValid() {
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
		if (contractPriceField.getText() == null || contractPriceField.getText().length() == 0) {
			errorMessage += "No valid Contract Price.\n";
		} else {
			try {
				Integer.parseInt(contractPriceField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid Contract Price (must be an integer)\n";
			}
		}
		if (penaltyPriceField.getText() == null || penaltyPriceField.getText().length() == 0) {
			errorMessage += "No valid Penalty Price.\n";
		} else {
			try {
				Integer.parseInt(penaltyPriceField.getText());
			} catch (NumberFormatException e) {
				errorMessage += "No valid Penalty Price (must be an integer)\n";
			}
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error, invalid input");
			alert.setContentText(errorMessage);

			alert.showAndWait();
			return false;
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// if there is data in forms simulate adding new order

		ArrayList<String[]> array = PSDSingleton.getInstance().getFormBData();
		System.out.println(array.size());

		for (int i = 0; i < array.size(); i++) {

			System.out.println("i is " + i);
			if (array.get(i)[0].isEmpty() != true) {
				System.out.println("order number is :" + array.get(i)[0]);
				orderArrayList.set(i, array.get(i)[0]);

			}
			if (array.get(i)[1].isEmpty() != true) {
				productCodeArrayList.set(i, array.get(i)[1]);
			}
			if (array.get(i)[2].isEmpty() != true) {
				contractPriceArrayList.set(i, array.get(i)[2]);
			}
			if (array.get(i)[3].isEmpty() != true) {
				scheduledDeliveryTimeArrayList.set(i, array.get(i)[3]);
			}
			if (array.get(i)[4].isEmpty() != true) {
				actualDeliveryTimeArrayList.set(i, array.get(i)[4]);
			}
			if (array.get(i)[5].isEmpty() != true) {
				penaltyPriceArrayList.set(i, array.get(i)[5]);
			}
			if (array.get(i)[3].isEmpty() != true && array.get(i)[4].isEmpty() != true) {

				int sch = (Integer.parseInt(array.get(i)[3]));
				int act = (Integer.parseInt(array.get(i)[4]));

				int timeDiff = act - sch;

				timeDifferenceArrayList.set(i, String.valueOf(timeDiff));
			}

			addFormButtons(leftVBox);
		}

		if (array.size() != 0) {
			currentForm = array.size();
			formCounter = currentForm;
		}
		System.out.println("what is curr form? " + currentForm);
		if (currentForm != 0) {
			displayValues(currentForm - 1);
		} else {
			displayValues(0);
		}

		backButton.setOnAction(e -> {

			if (isInputValid()) {

				ArrayList<String[]> formBData = new ArrayList<>();
				// check all fields are correct input

				// saves orders
				// saveOrders(totalOrders);

				// iterate fields creating orders
				/*
				 * for(int i = 0; i < orders.size(); i++) { Order order = new
				 * Order(orderArrayList.get(i),productCodeArrayList.get(i) ,
				 * contractPriceArrayList.get(i),
				 * scheduledDeliveryTimeArrayList.get(i),
				 * actualDeliveryTimeArrayList .get(i) , null);
				 * System.out.println(order.getOrderNumber());
				 * orders.add(order); }
				 */

				// iterate orders adding to formB Data
				for (int k = 0; k < orders.size(); k++) {
					String orderNum = orders.get(k).getOrderNumber();
					System.out.println("order number saved :" + orderNum);
					String productCode = orders.get(k).getProductCode();
					String contractPrice = orders.get(k).getContractPrice();
					String scheduleTime = orders.get(k).getScheduleTime();
					String actualTime = orders.get(k).getActualTime();
					String penalty = orders.get(k).getPenalty();
					if (orderNum != "") {
						String[] _order = new String[6];
						_order[0] = orderNum;
						_order[1] = productCode;
						_order[2] = contractPrice;
						_order[3] = scheduleTime;
						_order[4] = actualTime;
						_order[5] = penalty;

						formBData.add(_order);
					}
				}

				// System.out.println("field 1 saved :" + formBData.get(0)[0]);
				PSDSingleton.getInstance().setFormBData(formBData);

				FormVcontroller formV = new FormVcontroller();

				try {
					formV.display(backButton);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		// re-populate forms
		// displayOrders();

		actualDeliveryTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
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
		});

		/*
		 * orderField.textProperty().addListener((observable, oldValue,
		 * newValue) -> { saveFields(); });
		 * 
		 * scheduledDeliveryTimeField.textProperty().addListener((observable,
		 * oldValue, newValue) -> { saveFields(); });
		 */

		// add change listener to scheduled time to calculate contract price
		// immediately
		scheduledDeliveryTimeField.textProperty().addListener((observable, oldValue, newValue) -> {
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
			// saveFields();
			// createNewOrder();

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
			Double t = Double.parseDouble(scheduledDeliveryTimeField.getText());
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
