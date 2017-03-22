package settings;
import java.io.IOException;
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

public class EditFormR implements Initializable{
	@FXML private Button saveButton;
	@FXML private Button backButton;
	@FXML private VBox products;
	
	private ArrayList<ArrayList<TextField>> textFieldsArr = new ArrayList<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		assert saveButton != null : "fx:id=\"saveButton\" was not injected";
		assert backButton != null : "fx:id=\"backButton\" was not injected";

		 ArrayList<String[]> arr = PSDSingleton.getInstance().getFormRData();
		 for (int i = 0; i < arr.size(); i++) {				
			 
			HBox row = new HBox();
			TextField column0 = new TextField(arr.get(i)[0]);
			TextField column1 = new TextField(arr.get(i)[1]);
			
			ArrayList<TextField> fieldsArr = new ArrayList<>();
			fieldsArr.add(column0);
			fieldsArr.add(column1);
			
			this.textFieldsArr.add(fieldsArr);
			row.getChildren().addAll(column0,column1);
			
			
			products.getChildren().add(row);
		}
		 
		 saveButton.setOnAction(e -> {
			 this.saveFunction("DataBase/Personal/FormR.csv");
		 });

		 backButton.setOnAction(e -> {
			 this.saveFunction("DataBase/Personal/FormR.csv");
				SettingsScene sS = new SettingsScene();
				 try{
					 sS.display(backButton);
			}catch(IOException e1){
				e1.printStackTrace();
			}
		 });
	}

	private void saveFunction(String file) {	
		ArrayList<String[]> formRData = new ArrayList<>();
		
		for (int i = 0; i < this.textFieldsArr.size(); i++) {
			String[] data = new String[2];
			data[0] = this.textFieldsArr.get(i).get(0).getText();
			data[1] = this.textFieldsArr.get(i).get(1).getText();

			formRData.add(data);
		}
		PSDSingleton.getInstance().setFormRData(formRData);
		PSDSingleton.getInstance().saveFormRData();
	}
}
