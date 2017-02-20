import java.io.IOException;
import java.net.URL;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class FormOMenu implements Initializable {
	
	@FXML
	public Button backButton;
	
	@FXML
	public TextField totalKitPrice;
	
	@FXML
	private TableView<OrderHistory> historyTable;
	
	@FXML
	private TableColumn<OrderHistory, String> orderNoColumn;
	
	@FXML
	private TableColumn<OrderHistory, String> productCodeColumn;
	
	@FXML
	private TableColumn<OrderHistory, Double> kitPriceColumn;
	
	ObservableList<OrderHistory> orders = FXCollections.observableArrayList();
	
	public Scene Oscene;
	
	FormVcontroller a;
	public Scene display(FormVcontroller a){
		
		this.a = a;
		
		
		
		if (this.Oscene == null){
			BorderPane bPane = new BorderPane();
			VBox left = new VBox();
			HBox center = new HBox();
			bPane.setLeft(left);
			bPane.setCenter(center);

			try {
				Parent root = FXMLLoader.load(a.getClass().getResource("formO.fxml"));
				this.Oscene = new Scene(root, 800 , 700);
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
			
		}
		this.Oscene.getStylesheets().add("Styling.css");
		return this.Oscene;

	}
	
	
	
	
	// add new orders to the table
	public void updateOrderHistory(Order order){
		orders.add(new OrderHistory(order));
	}
	
	// displays this form
		public void display() {
		
			Stage stage = (Stage) backButton.getScene().getWindow();
			Parent parent;
			try {
				parent = FXMLLoader.load(getClass().getResource("formO.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.setTitle("Order History");
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		}
	
	public double calcTotalKitPrice(){
		
		double sum = 0;
		for(OrderHistory order : orders){
			sum+= order.getKitPrice();
		}
		return sum;
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		updateOrderHistory(new Order("aa", "dd"));
		updateOrderHistory(new Order("vva", "dsssd"));
		updateOrderHistory(new Order("aaddd", "dfdddd"));
		
		// attach values to colums
		orderNoColumn.setCellValueFactory(new PropertyValueFactory<>("orderNo"));
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
