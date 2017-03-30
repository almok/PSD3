package forms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.RoundCounter;

public class FormOMenu implements Initializable {

	RoundCounter roundCounter = RoundCounter.getInstance();
	int roundCount = roundCounter.getRoundCounter();

	private static FormOMenu instance = null;

	public static FormOMenu getInstance() {
		if (instance == null) {
			instance = new FormOMenu();
		}
		return instance;
	}

	@FXML
	private BorderPane formOMenu;

	@FXML
	private Button backButton;

	@FXML
	private TextField totalKitPrice;

	@FXML
	private TableView<OrderHistory> historyTable;

	@FXML
	private TableColumn<OrderHistory, String> orderNoColumn;

	@FXML
	private TableColumn<OrderHistory, String> productCodeColumn;

	@FXML
	private TableColumn<OrderHistory, String> kitPriceColumn;

	ObservableList<OrderHistory> orders = FXCollections.observableArrayList();

	public ObservableList<OrderHistory> getOrders() {
		return orders;
	}

	// add new orders to the table
	public void updateOrderHistory(Order order) {
		orders.add(new OrderHistory(order));
	}

	public double calcTotalKitPrice() {

		double sum = 0;
		for (OrderHistory order : orders) {
			if (order.getKitPrice() != -1) {
				sum += order.getKitPrice();
			}
		}
		return sum;
	}

	// display this form
	public void display(Button button) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("formO.fxml"));
		Scene scene = new Scene(parent);
		Stage stage = (Stage) button.getScene().getWindow();
		scene.getStylesheets().add("forms/Styling.css");
		stage.setScene(scene);
		stage.setTitle("Order History");

		Rectangle2D screen = Screen.getPrimary().getVisualBounds();
		stage.setX(screen.getMinX());
		stage.setY(screen.getMinY());
		stage.setWidth(screen.getWidth());
		stage.setHeight(screen.getHeight());

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		FormVcontroller formV = FormVcontroller.getInstance();

		backButton.setOnAction(e -> {
			try {
				formV.display(backButton);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		// attach values to columns
		orderNoColumn.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));
		orderNoColumn.setStyle("-fx-alignment: CENTER");

		productCodeColumn.setCellValueFactory(new PropertyValueFactory<>("productCode"));
		productCodeColumn.setStyle("-fx-alignment: CENTER");

		kitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("kitPriceString"));
		kitPriceColumn.setStyle("-fx-alignment: CENTER");

		// add orders into a table
		historyTable.setItems(FormOMenu.getInstance().getOrders());

		// set total kit price
		totalKitPrice.setText(Double.toString(calcTotalKitPrice()));
		totalKitPrice.setStyle("-fx-alignment: CENTER");
	}
}
