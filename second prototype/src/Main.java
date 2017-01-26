
import com.sun.prism.paint.Color;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>{
	static Scene mainScene;
	static Scene formBScene;
	static Scene formOScene;
	static Scene formTScene;
		//static Stage window;
		Button revenueButton;
		Button goodsHistoryButton;
		Button employmentAgencyButton;
		static Stage window;
		public static void main(String[] args){
			launch(args);
		}

		@Override
		public void start(Stage arg0) throws Exception {
			arg0.setTitle("Project PSD");
			Main.window = arg0;
			VBox layout = new VBox();
//			layout.getChildren().add(b);
			
			HBox l0 = new HBox();
			l0.getStyleClass().add("hbox");
			Label revenue = new Label("      α: Revenues ∑ Form B                                               ");
			l0.getChildren().add(revenue);
		    //l0.getChildren().add(new Text("     α: Revenues ∑ Form B                                                             "));
			l0.getChildren().add(new TextField());
			revenueButton = new Button("Edit");
			revenueButton.setOnAction(this);
			l0.getChildren().add(revenueButton);
			layout.getChildren().add(l0);
			
			
			Label expenditures = new Label("      Expenditures");
			Label salary = new Label("      Salary");
			layout.getChildren().add(expenditures);
			layout.getChildren().add(salary);
			
			HBox l1 = new HBox();
			l1.getStyleClass().add("hbox");
			Label employees = new Label("      Employees (No of QPQ employees x time x salary)  ");
			l1.getChildren().add(employees);
			//l1.getChildren().add(new Text("               Employees (No of QPQ employees x time x salary)     "));
			l1.getChildren().add(new TextField());
			
			
			HBox l2 = new HBox();
			l2.getStyleClass().add("hbox");
			Label empAgency = new Label("      Employment Agency (AYN) (Form T)                        ");
			l2.getChildren().add(empAgency);
			//l2.getChildren().add(new Text("               Employment Agency (AYN) (Form T)                           "));
			l2.getChildren().add(new TextField());
			employmentAgencyButton = new Button("Edit");
			employmentAgencyButton.setOnAction(this);
			l2.getChildren().add(employmentAgencyButton);
			
			HBox l3 = new HBox();
			l3.getStyleClass().add("hbox");
			Label Materials = new Label("      Materials (Form O)                                                     ");
			l3.getChildren().add(Materials);
			//l3.getChildren().add(new Text("          Materials (Form O)                                                            "));
			l3.getChildren().add(new TextField());
			goodsHistoryButton = new Button("Edit");
			goodsHistoryButton.setOnAction(this);
			l3.getChildren().add(goodsHistoryButton);
			
			HBox l4 = new HBox();
			l4.getStyleClass().add("hbox");
			Label investments = new Label("          Investments (Form R)                                            ");
			l4.getChildren().add(investments);
			//l4.getChildren().add(new Text("          Investments (Form R)                                                        "));
			l4.getChildren().add(new TextField());
			
			HBox l5 = new HBox();
			l5.getStyleClass().add("hbox");
			Label consultFees = new Label("      Consultant Fees (WSWK) (Form R)                           ");
			l5.getChildren().add(consultFees);
			//l5.getChildren().add(new Text("          Consultant Fees (WSWK) (Form R)                                    "));
			l5.getChildren().add(new TextField());
			
			HBox l6 = new HBox();
			l6.getStyleClass().add("hbox");
			Label totExpenditures = new Label("      Total expenditures (∑ β)                                             ");
			l6.getChildren().add(totExpenditures);
			//l6.getChildren().add(new Text("          Total expenditures (∑ β)                                                    "));
			l6.getChildren().add(new TextField());
			
			HBox l7 = new HBox();
			l7.getStyleClass().add("hbox");
			Label profLoss = new Label("      Profit/Loss (α – β)                                                       ");
			l7.getChildren().add(profLoss);
			//l7.getChildren().add(new Text("          Profit/Loss (α – β)                                                              "));
			l7.getChildren().add(new TextField());
			
			layout.getChildren().addAll(l1 , l2 , l3 , l4 , l5 , l6 , l7);
			Scene scene = new Scene(layout , 1600 , 1000);
			arg0.setScene(scene);
			Main.mainScene = scene;
			mainScene.getStylesheets().add("Styling.css");
			arg0.show();
		}

		@Override
		public void handle(ActionEvent event) {
			if (event.getSource() == revenueButton){
				if (formBScene == null){
					formBScene= FormBMenu.display();
					
				}
				Main.window.setScene(formBScene);
			} else if (event.getSource() == goodsHistoryButton){
				if (formOScene == null){
					formOScene = FormOMenu.display();
					formOScene.getStylesheets().add("Styling.css");
				}
				Main.window.setScene(formOScene );
			}  else if (event.getSource() == employmentAgencyButton){
				if (formTScene == null){
					formTScene = FormTMenu.display();
					formTScene.getStylesheets().add("Styling.css");
				}
				Main.window.setScene(formTScene);
			} 
		}
}
