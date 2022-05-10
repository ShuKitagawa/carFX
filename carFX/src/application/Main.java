package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        // JavaFX の実行
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // fxml の読み込み
        Parent root = FXMLLoader.load(getClass().getResource("/carcontoller.fxml"));

        // Scene の作成・登録
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // 表示
        stage.show();
    }
}