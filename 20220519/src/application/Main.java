package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
 
public class Main extends Application {
	@SuppressWarnings("exports")
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("carcontoller.fxml"));
			primaryStage.setTitle("初期ページ");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
 
	public static void main(String[] args) {
		launch(args);
	}
}