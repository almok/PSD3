import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FormTMenu {
	private static int rowCounter = 2;
	
	public static Scene display(){
		VBox vBox = new VBox();
		vBox.getStyleClass().add("vbox");
		
		HBox top = new HBox();
		top.getStyleClass().add("hbox");
		Button backButton = new Button("Back");
		backButton.setOnAction(e -> {
			
			Main.window.setScene(Main.mainScene);
			
		});
		top.getChildren().add(backButton);
		
		Button newFormButton = new Button("New Row");
		newFormButton.setOnAction(e -> {
			if (rowCounter <= 9){ 

				HBox nLineHBox = new HBox();
				ObservableList<String> options = 
					    FXCollections.observableArrayList(
					        "1",
					        "2",
					        "3",
					        "4",
					        "5",
					        "6",
					        "7",
					        "8",
					        "9",
					        "10",
					        "11",
					        "12",
					        "13",
					        "14",
					        "15",
					        "16",
					        "17",
					        "18",
					        "19",
					        "20");
					
				ObservableList<String> optionsM = 
					    FXCollections.observableArrayList(
					        "Yes",
					        "NO");
					
				ComboBox<String> comboBoxM = new ComboBox<String>(optionsM);
				ComboBox<String> comboBox = new ComboBox<String>(options);
				nLineHBox.getChildren().addAll(
						new Label("       " + rowCounter + "             ") , 
						new TextField() , 
						new Label("       ") , 
						new TextField() , 
						new Label("                 ") , 
						comboBoxM ,
						new Label("                                  ") , 
						comboBox);


				vBox.getChildren().add(nLineHBox);
				
				rowCounter++;
			} else if (rowCounter >= 10 && rowCounter <= 20){ 

				HBox nLineHBox = new HBox();
				ObservableList<String> options = 
					    FXCollections.observableArrayList(
					        "1",
					        "2",
					        "3",
					        "4",
					        "5",
					        "6",
					        "7",
					        "8",
					        "9",
					        "10",
					        "11",
					        "12",
					        "13",
					        "14",
					        "15",
					        "16",
					        "17",
					        "18",
					        "19",
					        "20");
					
				ObservableList<String> optionsM = 
					    FXCollections.observableArrayList(
					        "Yes",
					        "NO");
					
				ComboBox<String> comboBoxM = new ComboBox<String>(optionsM);
				ComboBox<String> comboBox = new ComboBox<String>(options);
				nLineHBox.getChildren().addAll(
						new Label("       " + rowCounter + "           ") , 
						new TextField() , 
						new Label("       ") , 
						new TextField() , 
						new Label("                 ") , 
						comboBoxM ,
						new Label("                                  ") , 
						comboBox);
				
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
		vBox.getChildren().add(top);
		
		HBox firstLineHBox = new HBox();
		
		
		firstLineHBox.getChildren().addAll(
				new Label("\n\n\n       N") , 
				new Label("\n\n\n                            Name                           ") , 
				new Label("\n\n\n                Depart.") ,
				new Label("\n\n\n                                   Multi skilled           ") ,
				new Label("\n\n\n                            Time                            "));
		
		vBox.getChildren().add(firstLineHBox);
		
		HBox zeroLineHBox = new HBox();
		ObservableList<String> options = 
			    FXCollections.observableArrayList(
			        "1",
			        "2",
			        "3",
			        "4",
			        "5",
			        "6",
			        "7",
			        "8",
			        "9",
			        "10",
			        "11",
			        "12",
			        "13",
			        "14",
			        "15",
			        "16",
			        "17",
			        "18",
			        "19",
			        "20");
			
		ObservableList<String> optionsM = 
			    FXCollections.observableArrayList(
			        "Yes",
			        "NO");
			
		ComboBox<String> comboBoxM = new ComboBox<String>(optionsM);
		ComboBox<String> comboBox = new ComboBox<String>(options);
		zeroLineHBox.getChildren().addAll(
				new Label("       1             ") , 
				new TextField() , 
				new Label("       ") , 
				new TextField() , 
				new Label("                 ") , 
				comboBoxM ,
				new Label("                                  ") , 
				comboBox);
		
		vBox.getChildren().add(zeroLineHBox);


		
		// FifthLine
		
		HBox fifthLineHBox = new HBox();
		
		HBox fifthLineLefftHBox= new HBox();
		fifthLineLefftHBox.getChildren().add(new Label("          Scheduled lead time (D):    "));
		fifthLineLefftHBox.getChildren().add(new TextField());

		HBox fifthLineRightHBox = new HBox();
		fifthLineRightHBox.getChildren().add(new Label("          Schedule and Actual Time Difference:   "));
		fifthLineRightHBox.getChildren().add(new TextField());

		fifthLineHBox.getChildren().addAll(fifthLineLefftHBox ,fifthLineRightHBox);

		// SixthLine
		
		HBox sixthLineHBox = new HBox();
		
		HBox sixthLineLefftHBox= new HBox();
		sixthLineLefftHBox.getChildren().add(new Label("          Scheduled delivery time:    "));
		sixthLineLefftHBox.getChildren().add(new TextField());

		HBox sixthLineRightHBox = new HBox();
		sixthLineRightHBox.getChildren().add(new Label("          Penalty (b):                                             "));
		sixthLineRightHBox.getChildren().add(new TextField()); 

		sixthLineHBox.getChildren().addAll(sixthLineLefftHBox ,sixthLineRightHBox);

		// SeventhLine
		
		HBox seventhLineHBox = new HBox();
		
		HBox seventhLineLefftHBox= new HBox();
		seventhLineLefftHBox.getChildren().add(new Label("          Contract price (a):               "));
		seventhLineLefftHBox.getChildren().add(new TextField());

		HBox seventhLineRightHBox = new HBox();
		seventhLineRightHBox.getChildren().add(new Label("          Revenue (a-b):                                        "));
		seventhLineRightHBox.getChildren().add(new TextField());

		seventhLineHBox.getChildren().addAll(seventhLineLefftHBox ,seventhLineRightHBox);

		return new Scene(vBox,1600 , 1000);
	}

}
