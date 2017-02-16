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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class FormOMenu implements Initializable {
	
	@FXML
	public Button button;
	
	@FXML
	private TableView<OrderHistory> historyTable;
	
	@FXML
	private TableColumn<OrderHistory, String> orderNoColumn;
	
	@FXML
	private TableColumn<OrderHistory, String> productCodeColumn;
	
	@FXML
	private TableColumn<OrderHistory, Double> kitPriceColumn;
	
	ObservableList<OrderHistory> orders = FXCollections.observableArrayList();
	
	
	// add new orders to the table
	public void updateOrderHistory(Order order){
		orders.add(new OrderHistory(order));
	}
	
	// padaryt redirection
	@FXML
	public void goToFormV() throws IOException{
	/*
		Stage stage = new Stage();
		Parent parent = FXMLLoader.load(getClass().getResource("formV.fxml"));
		Scene scene = new Scene(parent);
		stage.setTitle("Form V");
		stage.setScene(scene);
		stage.show();
	*/
		}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		updateOrderHistory(new Order("aa", "dd"));
		updateOrderHistory(new Order("vva", "dsssd"));
		updateOrderHistory(new Order("aaddd", "dfdddd"));
		
		orderNoColumn.setCellValueFactory(new PropertyValueFactory<>("orderNo"));
		productCodeColumn.setCellValueFactory(new PropertyValueFactory<>("productCode"));
		kitPriceColumn.setCellValueFactory(new PropertyValueFactory<>("kitPrice"));
		
		historyTable.setItems(orders);
		
	}
	
		
	/*private static int rowCounter = 2;
	
	public static Scene display(){
		VBox vBox = new VBox();
		
		HBox top = new HBox();
		Button backButton = new Button("Back");
		backButton.setOnAction(e -> {
			
			//Main.window.setScene(Main.mainScene);
			
		});
		top.getChildren().add(backButton);
		
		Button newFormButton = new Button("New Row");
		newFormButton.setOnAction(e -> {
			if (rowCounter <= 9){ 

				HBox nLineHBox = new HBox();
				
				nLineHBox.getChildren().addAll(
						new Text("       " + rowCounter + "             ") , 
						new TextField() , 
						new Text("                          ") , 
						new TextField() , 
						new Text("                               ") , 
						new TextField());
				
				vBox.getChildren().add(nLineHBox);

				
				rowCounter++;
			} else if (rowCounter >= 10 && rowCounter <= 20){ 

				HBox nLineHBox = new HBox();
				
				nLineHBox.getChildren().addAll(
						new Text("       " + rowCounter + "           ") , 
						new TextField() , 
						new Text("                          ") , 
						new TextField() , 
						new Text("                               ") , 
						new TextField());
				
				vBox.getChildren().add(nLineHBox);

				
				rowCounter++;
			}
		});
		
		top.getChildren().add(newFormButton);

		Button deleteFormButton = new Button("Delete Row");
		deleteFormButton .setOnAction(e -> {
			if (rowCounter > 2){ 

				vBox.getChildren().remove(vBox.getChildren().size() - 1);
				
				rowCounter--;
			}
		});

		
		top.getChildren().add(deleteFormButton);
		top.getChildren().add(new Text("                 Total = "));
		top.getChildren().add(new TextField());
		
		vBox.getChildren().add(top);
		
		HBox firstLineHBox = new HBox();
		
		firstLineHBox.getChildren().addAll(
				new Text("\n\n\n       N") , 
				new Text("\n\n\n                            Order                           ") , 
				new Text("\n\n\n                            Product Code                            ") ,
				new Text("\n\n\n                            Kit Price (Scϕ)                            "));
		
		vBox.getChildren().add(firstLineHBox);
		
		HBox zeroLineHBox = new HBox();
		
		zeroLineHBox.getChildren().addAll(
				new Text("       1             ") , 
				new TextField() , 
				new Text("                          ") , 
				new TextField() , 
				new Text("                               ") , 
				new TextField());
		
		vBox.getChildren().add(zeroLineHBox);


		
		// FifthLine
		
		HBox fifthLineHBox = new HBox();
		
		HBox fifthLineLefftHBox= new HBox();
		fifthLineLefftHBox.getChildren().add(new Text("          Scheduled lead time (D):    "));
		fifthLineLefftHBox.getChildren().add(new TextField());

		HBox fifthLineRightHBox = new HBox();
		fifthLineRightHBox.getChildren().add(new Text("          Schedule and Actual Time Difference:   "));
		fifthLineRightHBox.getChildren().add(new TextField());

		fifthLineHBox.getChildren().addAll(fifthLineLefftHBox ,fifthLineRightHBox);

		// SixthLine
		
		HBox sixthLineHBox = new HBox();
		
		HBox sixthLineLefftHBox= new HBox();
		sixthLineLefftHBox.getChildren().add(new Text("          Scheduled delivery time:    "));
		sixthLineLefftHBox.getChildren().add(new TextField());

		HBox sixthLineRightHBox = new HBox();
		sixthLineRightHBox.getChildren().add(new Text("          Penalty (b):                                             "));
		sixthLineRightHBox.getChildren().add(new TextField()); 

		sixthLineHBox.getChildren().addAll(sixthLineLefftHBox ,sixthLineRightHBox);

		// SeventhLine
		
		HBox seventhLineHBox = new HBox();
		
		HBox seventhLineLefftHBox= new HBox();
		seventhLineLefftHBox.getChildren().add(new Text("          Contract price (a):               "));
		seventhLineLefftHBox.getChildren().add(new TextField());

		HBox seventhLineRightHBox = new HBox();
		seventhLineRightHBox.getChildren().add(new Text("          Revenue (a-b):                                        "));
		seventhLineRightHBox.getChildren().add(new TextField());

		seventhLineHBox.getChildren().addAll(seventhLineLefftHBox ,seventhLineRightHBox);

		return new Scene(vBox, 800 , 700);
	}*/

}
