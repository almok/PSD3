package settings;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.PSDSingleton;

public class EditFormC implements Initializable{
	@FXML private Button saveButton;
	@FXML private Button backButton;
	@FXML private VBox products;
	
	private ArrayList<ArrayList<TextField>> textFieldsArr = new ArrayList<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		assert saveButton != null : "fx:id=\"saveButton\" was not injected";
		assert backButton != null : "fx:id=\"backButton\" was not injected";

		 ArrayList<String[]> arr = PSDSingleton.getInstance().getFormCData();
		 for (int i = 0; i < arr.size(); i++) {				
			 
			HBox row = new HBox();
			TextField column0 = new TextField(arr.get(i)[0]);
			TextField column1 = new TextField(arr.get(i)[1]);
			TextField column2 = new TextField(arr.get(i)[2]);
			TextField column3 = new TextField(arr.get(i)[3]);
			TextField column4;
			
			if(arr.get(i).length < 5){
				column4 = new TextField();
			} else {
				column4 = new TextField(arr.get(i)[4]);
			}
			
			ArrayList<TextField> fieldsArr = new ArrayList<>();
			fieldsArr.add(column0);
			fieldsArr.add(column1);
			fieldsArr.add(column2);
			fieldsArr.add(column3);
			fieldsArr.add(column4);
			
			this.textFieldsArr.add(fieldsArr);
			row.getChildren().addAll(column0,column1,column2,column3,column4);
			
			
			products.getChildren().add(row);
		}
		 
		 saveButton.setOnAction(e -> {
			 this.saveFunction("DataBase/Personal/FormC.csv");
		 });

		 backButton.setOnAction(e -> {
			 
		 });
	}

	private void saveFunction(String file) {	
		ArrayList<String[]> formCData = new ArrayList<>();
		
		for (int i = 0; i < this.textFieldsArr.size(); i++) {
			String[] data = new String[5];
			data[0] = this.textFieldsArr.get(i).get(0).getText();
			data[1] = this.textFieldsArr.get(i).get(1).getText();
			data[2] = this.textFieldsArr.get(i).get(2).getText();
			data[3] = this.textFieldsArr.get(i).get(3).getText();
			data[4] = this.textFieldsArr.get(i).get(4).getText();

			formCData.add(data);
		}
		PSDSingleton.getInstance().setFormCData(formCData);
		PSDSingleton.getInstance().saveFormCData();
	}
}
