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

public class EditFormD implements Initializable{
	@FXML private Button saveButton;
	@FXML private Button backButton;
	@FXML private VBox products;
	
	private ArrayList<ArrayList<TextField>> textFieldsArr = new ArrayList<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		assert saveButton != null : "fx:id=\"saveButton\" was not injected";
		assert backButton != null : "fx:id=\"backButton\" was not injected";

		 ArrayList<String[]> arr = PSDSingleton.getInstance().getFormDData();
		 for (int i = 0; i < arr.size(); i++) {				
			 
			HBox row = new HBox();
			TextField column0 = new TextField(arr.get(i)[0]);
			column0.setPrefWidth(200);
			TextField column1 = new TextField(arr.get(i)[1]);
			column1.setPrefWidth(100);
			TextField column2 = new TextField(arr.get(i)[2]);
			column2.setPrefWidth(100);
			TextField column3 = new TextField(arr.get(i)[3]);
			column3.setPrefWidth(100);
			TextField column4;
			
			if(arr.get(i).length < 5){
				column4 = new TextField();
			} else {
				column4 = new TextField(arr.get(i)[4]);
			}
			column4.setPrefWidth(100);

			TextField column5 = new TextField(arr.get(i)[5]);
			column5.setPrefWidth(100);
			TextField column6 = new TextField(arr.get(i)[6]);
			column6.setPrefWidth(100);
			TextField column7 = new TextField(arr.get(i)[7]);
			column7.setPrefWidth(100);
			TextField column8 = new TextField(arr.get(i)[8]);
			column8.setPrefWidth(100);
			TextField column9 = new TextField(arr.get(i)[9]);
			column9.setPrefWidth(100);
			
			ArrayList<TextField> fieldsArr = new ArrayList<>();
			fieldsArr.add(column0);
			fieldsArr.add(column1);
			fieldsArr.add(column2);
			fieldsArr.add(column3);
			fieldsArr.add(column4);
			fieldsArr.add(column5);
			fieldsArr.add(column6);
			fieldsArr.add(column7);
			fieldsArr.add(column8);
			fieldsArr.add(column9);
			
			this.textFieldsArr.add(fieldsArr);
			row.getChildren().addAll(column0,column1,column2,column3,column4,column5,column6,column7,column8,column9);
			
			
			products.getChildren().add(row);
		}
		 
		 saveButton.setOnAction(e -> {
			 this.saveFunction("DataBase/Personal/FormD.csv");
		 });

		 backButton.setOnAction(e -> {
			 this.saveFunction("DataBase/Personal/FormD.csv");
				SettingsScene sS = new SettingsScene();
				 try{
					 sS.display(backButton);
			}catch(IOException e1){
				e1.printStackTrace();
			}
		 });
	}

	private void saveFunction(String file) {	
		ArrayList<String[]> formDData = new ArrayList<>();
		
		for (int i = 0; i < this.textFieldsArr.size(); i++) {
			String[] data = new String[9];
			data[0] = this.textFieldsArr.get(i).get(0).getText();
			data[1] = this.textFieldsArr.get(i).get(1).getText();
			data[2] = this.textFieldsArr.get(i).get(2).getText();
			data[3] = this.textFieldsArr.get(i).get(3).getText();
			data[4] = this.textFieldsArr.get(i).get(4).getText();
			data[5] = this.textFieldsArr.get(i).get(5).getText();
			data[6] = this.textFieldsArr.get(i).get(6).getText();
			data[7] = this.textFieldsArr.get(i).get(7).getText();
			data[8] = this.textFieldsArr.get(i).get(8).getText();
			data[9] = this.textFieldsArr.get(i).get(9).getText();
			
			System.out.println(data[8]);
			
			formDData.add(data);
		}
		PSDSingleton.getInstance().setFormDData(formDData);
		PSDSingleton.getInstance().saveFormDData();
	}
}
