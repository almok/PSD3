import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class FormOMenu {
	private static int rowCounter = 2;
	
	public Scene display(){
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
	}

}
