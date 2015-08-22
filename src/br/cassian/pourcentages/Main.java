package br.cassian.pourcentages;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	private GridPane root;
	@SuppressWarnings("unused")
	private Stage  primaryStage;

	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Pourcentages.fxml"));
			root = (GridPane) loader.load();
			
			this.primaryStage = primaryStage;
			
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("Pourcentages.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
