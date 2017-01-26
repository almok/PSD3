
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class FormBMenu{
	//private static Button backButton;
	
	private static int formCounter = 4;
	
	public static Scene display(){
		BorderPane bPane = new BorderPane();
		// LEFT
				VBox left = new VBox();
				left.getChildren().add(new Label("Form 1"));
				left.getChildren().add(new Label("Form 2"));
				left.getChildren().add(new Label("Form 3"));
				
				bPane.setLeft(left);
		
		//TOP
		
		HBox top = new HBox();
		top.getStyleClass().add("hbox");
		Button backButton = new Button("Back");
		backButton.setOnAction(e -> {
			
			Main.window.setScene(Main.mainScene);
			
		});
		top.getChildren().add(backButton);
		
		Button newFormButton = new Button("New Form");
		newFormButton.setOnAction(e -> {
			if (formCounter <= 20){ 
				left.getChildren().add(new Label("Form " + formCounter));
				formCounter++;
			}
		});
		
		top.getChildren().add(newFormButton);
		top.getChildren().add(new Button("Save Form"));
		top.getChildren().add(new Button("Clear"));
		
		bPane.setTop(top);
		
		
		

		VBox layout = new VBox();
		layout.getStyleClass().add("vbox");
		HBox l1 = new HBox();
		l1.getStyleClass().add("hbox");
		l1.getChildren().add(new Label("          Order number:        "));
		l1.getChildren().add(new TextField());
		
		HBox l2 = new HBox();
		l2.getStyleClass().add("hbox");
		l2.getChildren().add(new Label("          Chassis Type:           "));
		l2.getChildren().add(new TextField());
		
		HBox l3 = new HBox();
		l3.getStyleClass().add("hbox");
		l3.getChildren().add(new Label("          Product Code (C):    "));
		l3.getChildren().add(new TextField());
		
		// ForthLine
		
		HBox forthLineHBox = new HBox();
		forthLineHBox.getStyleClass().add("hbox");
		
		HBox forthLineLefftHBox= new HBox();
		forthLineLefftHBox.getChildren().add(new Label("          Time of receipt of order:    "));
		forthLineLefftHBox.getChildren().add(new TextField());

		HBox forthLineRightHBox= new HBox();
		forthLineRightHBox.getChildren().add(new Label("          Actual Delivery Time:                             "));
		forthLineRightHBox.getChildren().add(new TextField());

		forthLineHBox.getChildren().addAll(forthLineLefftHBox ,forthLineRightHBox);

		// FifthLine
		
		HBox fifthLineHBox = new HBox();
		fifthLineHBox.getStyleClass().add("hbox");
		
		HBox fifthLineLefftHBox= new HBox();
		
		fifthLineLefftHBox.getChildren().add(new Label("          Scheduled lead time (D):    "));
		fifthLineLefftHBox.getChildren().add(new TextField());

		HBox fifthLineRightHBox = new HBox();
		fifthLineRightHBox.getChildren().add(new Label("          Schedule and Actual Time Difference:   "));
		fifthLineRightHBox.getChildren().add(new TextField());

		fifthLineHBox.getChildren().addAll(fifthLineLefftHBox ,fifthLineRightHBox);

		// SixthLine
		
		HBox sixthLineHBox = new HBox();
		sixthLineHBox.getStyleClass().add("hbox");
		
		HBox sixthLineLefftHBox= new HBox();
		sixthLineLefftHBox.getChildren().add(new Label("          Scheduled delivery time:    "));
		sixthLineLefftHBox.getChildren().add(new TextField());

		HBox sixthLineRightHBox = new HBox();
		sixthLineRightHBox.getChildren().add(new Label("          Penalty (b):                                             "));
		sixthLineRightHBox.getChildren().add(new TextField()); 

		sixthLineHBox.getChildren().addAll(sixthLineLefftHBox ,sixthLineRightHBox);

		// SeventhLine
		
		HBox seventhLineHBox = new HBox();
		seventhLineHBox.getStyleClass().add("hbox");
		
		HBox seventhLineLefftHBox= new HBox();
		seventhLineLefftHBox.getChildren().add(new Label("          Contract price (a):               "));
		seventhLineLefftHBox.getChildren().add(new TextField());

		HBox seventhLineRightHBox = new HBox();
		seventhLineRightHBox.getChildren().add(new Label("          Revenue (a-b):                                        "));
		seventhLineRightHBox.getChildren().add(new TextField());

		seventhLineHBox.getChildren().addAll(seventhLineLefftHBox ,seventhLineRightHBox);
				
		layout.getChildren().addAll(l1 , l2 , l3 , new Text("\n\n"), forthLineHBox , fifthLineHBox , sixthLineHBox , seventhLineHBox);
		
		bPane.setCenter(layout);
		Scene formBScene = new Scene(bPane, 1600 , 1000);
		formBScene.getStylesheets().add("Styling.css");
		return formBScene;
	}

	
}
