
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Main extends Application implements EventHandler<ActionEvent>{
	static Scene mainScene;
	FormBMenu formB = new FormBMenu();
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
			l0.getChildren().add(new Label("     α: Revenues ∑ Form B                                                             "));
			l0.getChildren().add(new TextField());
			revenueButton = new Button("Edit");
			revenueButton.setOnAction(this);
			l0.getChildren().add(revenueButton);
			layout.getChildren().add(l0);
			
			HBox exp = new HBox();
			exp.getStyleClass().add("hbox");
			exp.getChildren().add(new Label("     Expenditures"));
			layout.getChildren().add(exp);
			HBox sal = new HBox();
			sal.getStyleClass().add("hbox");
			sal.getChildren().add(new Label("          Salary"));
			layout.getChildren().add(sal);
			
			HBox l1 = new HBox();
			l1.getStyleClass().add("hbox");
			l1.getChildren().add(new Label("               Employees (No of QPQ employees x time x salary)     "));
			l1.getChildren().add(new TextField());
			
			HBox l2 = new HBox();
			l2.getStyleClass().add("hbox");
			l2.getChildren().add(new Label("               Employment Agency (AYN) (Form T)                           "));
			l2.getChildren().add(new TextField());
			employmentAgencyButton = new Button("Edit");
			employmentAgencyButton.setOnAction(this);
			l2.getChildren().add(employmentAgencyButton);
			
			HBox l3 = new HBox();
			l3.getStyleClass().add("hbox");
			l3.getChildren().add(new Label("          Materials (Form O)                                                            "));
			l3.getChildren().add(new TextField());
			goodsHistoryButton = new Button("Edit");
			goodsHistoryButton.setOnAction(this);
			l3.getChildren().add(goodsHistoryButton);
			
			HBox l4 = new HBox();
			l4.getStyleClass().add("hbox");
			l4.getChildren().add(new Label("          Investments (Form R)                                                        "));
			l4.getChildren().add(new TextField());
			
			HBox l5 = new HBox();
			l5.getStyleClass().add("hbox");
			l5.getChildren().add(new Label("          Consultant Fees (WSWK) (Form R)                                    "));
			l5.getChildren().add(new TextField());
			
			HBox l6 = new HBox();
			l6.getStyleClass().add("hbox");
			l6.getChildren().add(new Label("          Total expenditures (∑ β)                                                    "));
			l6.getChildren().add(new TextField());
			
			HBox l7 = new HBox();
			l7.getStyleClass().add("hbox");
			l7.getChildren().add(new Label("          Profit/Loss (α – β)                                                              "));
			l7.getChildren().add(new TextField());
			
			
			layout.getChildren().addAll(l1 , l2 , l3 , l4 , l5 , l6 , l7);
			Scene scene = new Scene(layout , 800 , 700);
			arg0.setScene(scene);
			Main.mainScene = scene;
			mainScene.getStylesheets().add("Styling.css");
			arg0.show();
		}

		@Override
		public void handle(ActionEvent event) {
			if (event.getSource() == revenueButton){
//				if (formBScene == null){
//					formBScene= FormBMenu.display(this);
//				}
				Main.window.setScene(formB.display(this));
			} else if (event.getSource() == goodsHistoryButton){
				if (formOScene == null){
					formOScene = FormOMenu.display();
				}
				Main.window.setScene(formOScene );
			}  else if (event.getSource() == employmentAgencyButton){
				if (formTScene == null){
					formTScene = FormTMenu.display();
				}
				Main.window.setScene(formTScene);
			} 
		}
}
