package forms;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import main.PSDSingleton;
import main.Round;
import main.RoundCounter;
import main.Timer;

public class StartScreen implements Initializable, EventHandler<ActionEvent>{
	@FXML private Button startButton;
	@FXML private Button exportButton;
	@FXML private Button importButton;	
	@FXML private Button reportButton;
	@FXML private Button timerButton;
	@FXML private VBox leftVBox;
	@FXML private Label rightLabel;
	@FXML private AnchorPane aPane;

	public void display(Button button) throws IOException{
		Parent parent = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
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
	
	//Mostly needs fix at timer and need to relate roundbutton to a unique ID.
	RoundCounter roundCounter = RoundCounter.getInstance();
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() == startButton){
			addRoundButton(leftVBox);
			roundCounter.incRoundCounter();
			//CountDownTimer countDown = new CountDownTimer();
			//countdown.display(startButton);
		} else if (event.getSource() == reportButton){
			//produce report from financials of rounds available
		} 
		else if (event.getSource() == timerButton){
			//display timer in separate window
			System.out.println("Timer button pressed");
			new Timer();
		} else if (event.getSource() == exportButton){
			PrintWriter pw;
			
			
			File theDir = new File("Export");
			if (!theDir.exists()) {
			    try{
			        theDir.mkdir();
			    } 
			    catch(SecurityException se){
			    }  
			}
	
			ArrayList<String[]> formBData = PSDSingleton.getInstance().getFormBData();
			try {
				pw = new PrintWriter(new File("Export/FormBData.csv"));
				for (int i = 0; i < formBData.size(); i++) {
					pw.write("" + formBData.get(i)[0] + "," + formBData.get(i)[1]+ "," + formBData.get(i)[2]+ "," + formBData.get(i)[3]+ "," + formBData.get(i)[4]+ "," + formBData.get(i)[5]
							+ "," + formBData.get(i)[6]+ "," + formBData.get(i)[7]+ "," + formBData.get(i)[8] + "\n");
				}
		        pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	
			ArrayList<String[]> formSData = PSDSingleton.getInstance().getFormSData();
			try {
				pw = new PrintWriter(new File("Export/FormSData.csv"));
				for (int i = 0; i < formSData.size(); i++) {
					pw.write("" + formSData.get(i)[0] + "," + formSData.get(i)[1]+ "," + formSData.get(i)[2] + "\n");
				}
		        pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	
			ArrayList<AYNEmployee> formTData = PSDSingleton.getInstance().getFormTData();
			try {
				pw = new PrintWriter(new File("Export/FormTData.csv"));
				for (int i = 0; i < formTData.size(); i++) {
					pw.write("" + formTData.get(i).getName() + "," + formTData.get(i).getDepartmentWithoutBreak() + "," + formTData.get(i).getMultiSkilled() + "," + formTData.get(i).getTime1()
							 + "," + formTData.get(i).getTime2() + "," + formTData.get(i).getTotTime() + "," + formTData.get(i).getWage()+ "," + formTData.get(i).getRoundCount() + "\n");
				}
		        pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	
			ArrayList<Round> formVData = PSDSingleton.getInstance().getFormVData();
			try {
				pw = new PrintWriter(new File("Export/FormVData.csv"));
				for (int i = 0; i < formVData.size(); i++) {
					pw.write("" + formVData.get(i).getRoundNum() + "," + formVData.get(i).getTotalRevenue() + "," + formVData.get(i).getEmployeeWage()
							+ "," + formVData.get(i).getAynPay()
							 + "," + formVData.get(i).getMaterialsSum() + "," + formVData.get(i).getTotalExpenditure() + "," + formVData.get(i).getProfitLoss()+ "\n");
				}
		        pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else if (event.getSource() == importButton){
			
			PSDSingleton.getInstance().importData();
		}
	}
	
	
	public void addRoundButton(VBox left){
		Button roundButton;
		if (roundCounter.getRoundCounter() == 0){
			roundButton = new Button(" Trial Round ");
		} else {
			roundButton = new Button(" Round " + roundCounter.getRoundCounter() + " ");
		}
		left.getChildren().add(roundButton);
		roundButton.setOnAction(e -> {
			String buttonTxt = roundButton.getText().replaceAll("\\D+", "");
			System.out.println(buttonTxt);
			try{
				roundCounter.setRoundCounter(Integer.parseInt(buttonTxt));
				System.out.println(roundCounter.getRoundCounter());
			} catch (Exception e1){
				roundCounter.setRoundCounter(0);
				System.out.println(roundCounter.getRoundCounter());
			}
			FormVcontroller formVMenu = new FormVcontroller();
			try {
		 		formVMenu.display(roundButton);
		 	 } catch (Exception e1) {
		 	 	e1.printStackTrace();
		 	 }
		});
		roundCounter.setMaxCount(roundCounter.getRoundCounter());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		 assert startButton != null : "fx:id=\"startButton\" was not injected";
		 assert exportButton != null : "fx:id=\"exportButton\" was not injected";
		 assert importButton != null : "fx:id=\"importButton\" was not injected";
		 assert reportButton != null : "fx:id=\"reportButton\" was not injected";

		startButton.setOnAction(this);
		exportButton.setOnAction(this);
		importButton.setOnAction(this);
		reportButton.setOnAction(this);
		timerButton.setOnAction(this);

		System.out.println("Printing round count " + roundCounter.getMaxCount());
		if (roundCounter.getMaxCount() >= -1){
			int i = roundCounter.getMaxCount();
			roundCounter.setRoundCounter(0);
			while (roundCounter.getRoundCounter() <= i){
				addRoundButton(leftVBox);
				roundCounter.incRoundCounter();
			}
		}
	}
}
