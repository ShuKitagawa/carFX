package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class carManagementContoller {
	@FXML private Button returnTop;
	@FXML private TextField  insertCarField;
	@FXML private TextField insertNenpiField1;
	@FXML private TextField insertNenpiField2;
	@FXML private TextField deleteCarField;
	@FXML private Button  insertCarButton;
	@FXML private Button  insertNenpiButton;
	@FXML private Button  deleteCarButton;
	@FXML private Label  costResult;
	@FXML private Label  fuelResult;
	@FXML private TableView  carData;


	//「車種登録」ボタンクリック
	@FXML
	protected void okInsertCarClick(ActionEvent evt) {
		//車種登録
		String insertCarField2 = insertCarField.getText(); 
		dbCon.sqlInsert(insertCarField2);
	}
	//「燃費登録」ボタンクリック
	@FXML
	protected void onInsertNenpiClick(ActionEvent evt) {
		//燃費を登録
		int insertNenpiId = Integer.parseInt(insertNenpiField1.getText()); 
		int insertNenpi = Integer.parseInt(insertNenpiField2.getText());
		dbCon.sqlFuelInsert(insertNenpiId,insertNenpi);
	}
	
	//「車種削除」ボタンをクリック
	@FXML
	protected void onDeleteCarClick(ActionEvent evt) {
		//燃費を登録
		int insertNenpiId1 = Integer.parseInt(deleteCarField.getText()); 
		dbCon.sqlCarDelete(insertNenpiId1);
	}
	
	
	//Top画面に戻る
	@FXML
	public void onTopClick(ActionEvent event) {
		
		Scene s = ((Node)event.getSource()).getScene();
		Window window = s.getWindow();
		window.hide();
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("carcontoller.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Top画面");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}