
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
				left.getChildren().add(new Text("Form 1"));
				left.getChildren().add(new Text("Form 2"));
				left.getChildren().add(new Text("Form 3"));
				
				bPane.setLeft(left);
		
		//TOP
		
		HBox top = new HBox();
		Button backButton = new Button("Back");
		backButton.setOnAction(e -> {
			
			Main.window.setScene(Main.mainScene);
			
		});
		top.getChildren().add(backButton);
		
		Button newFormButton = new Button("New Form");
		newFormButton.setOnAction(e -> {
			if (formCounter <= 20){ 
				left.getChildren().add(new Text("Form " + formCounter));
				formCounter++;
			}
		});
		
		top.getChildren().add(newFormButton);
		top.getChildren().add(new Button("Save Form"));
		top.getChildren().add(new Button("Clear"));
		
		bPane.setTop(top);
		
		
		

		VBox layout = new VBox();
		HBox l1 = new HBox();
		l1.getChildren().add(new Text("          Order number:        "));
		l1.getChildren().add(new TextField());
		
		HBox l2 = new HBox();
		l2.getChildren().add(new Text("          Chassis Type:           "));
		l2.getChildren().add(new TextField());
		
		HBox l3 = new HBox();
		l3.getChildren().add(new Text("          Product Code (C):    "));
		l3.getChildren().add(new TextField());
		
		// ForthLine
		
		HBox forthLineHBox = new HBox();
		
		HBox forthLineLefftHBox= new HBox();
		forthLineLefftHBox.getChildren().add(new Text("          Time of receipt of order:    "));
		forthLineLefftHBox.getChildren().add(new TextField());

		HBox forthLineRightHBox= new HBox();
		forthLineRightHBox.getChildren().add(new Text("          Actual Delivery Time:                             "));
		forthLineRightHBox.getChildren().add(new TextField());

		forthLineHBox.getChildren().addAll(forthLineLefftHBox ,forthLineRightHBox);

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
				
		layout.getChildren().addAll(l1 , l2 , l3 , new Text("\n\n"), forthLineHBox , fifthLineHBox , sixthLineHBox , seventhLineHBox);
		
		bPane.setCenter(layout);
		return new Scene(bPane, 800 , 700);
	}

	
}
