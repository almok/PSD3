import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.PSDSingleton;



public class FormOMenu implements Initializable {
	
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
	private TableColumn<OrderHistory, Double> kitPriceColumn;
	
	ObservableList<OrderHistory> orders = FXCollections.observableArrayList();
	
	FormTMenu formT;
	FormVcontroller formV;
	

	// add new orders to the table
	public void updateOrderHistory(Order order){
		orders.add(new OrderHistory(order));
	}
	
	public double calcTotalKitPrice(){
		
		double sum = 0;
		for(OrderHistory order : orders){
			sum+= order.getKitPrice();
		}
		return sum;
	}
	
	// display this form
	public void display(Button button) throws IOException{
			Parent parent = FXMLLoader.load(getClass().getResource("formO.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = (Stage) button.getScene().getWindow();
			scene.getStylesheets().add("Styling.css");
			stage.setScene(scene);
			stage.setTitle("Order History");
			
		}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		formV = new FormVcontroller();
		
		backButton.setOnAction(e -> {
			try {
				formV.display(backButton);
			} catch (IOException e1) {
				e1.printStackTrace();
				}
		});
		
		// iterate through orders and add them using updateOrderHistory()
		ArrayList<String[]> arr = PSDSingleton.getInstance().getFormBData();
		if (!arr.isEmpty()){
			for (String [] data : arr){
				updateOrderHistory(new Order(data[0], data[1], data[3], data[4], data[5], data[6]));
			}
		}
		//
		updateOrderHistory(new Order("talk to me", "aa", "dd", null, null, null));
		updateOrderHistory(new Order(" shake that ass", "vva", "dsssd", null, null, null));
		updateOrderHistory(new Order("order 1", "aaddd", "dfdddd", null, null, null));
		//
		//
		
		// attach values to columns
		orderNoColumn.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));
		orderNoColumn.setStyle("-fx-alignment: CENTER");
		
		productCodeColumn.setCellValueFactory(new PropertyValueFactory<>("productCode"));
		productCodeColumn.setStyle("-fx-alignment: CENTER");
		
		kitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("kitPrice"));
		kitPriceColumn.setStyle("-fx-alignment: CENTER");
		
		// add orders into a table
		historyTable.setItems(orders);
		
		// set total kit price
		totalKitPrice.setText(Double.toString(calcTotalKitPrice()));
		totalKitPrice.setStyle("-fx-alignment: CENTER");
		
		
		
	}
}
