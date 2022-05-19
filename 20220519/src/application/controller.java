package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class controller {

	@FXML private Button tripbutton;
	@FXML private Button nenpibutton;
	@FXML private Button syaryobutton;

	
	//燃費計算画面
	@FXML
	public void onNenpiClick(ActionEvent event) {
		
		Scene s = ((Node)event.getSource()).getScene();
		Window window = s.getWindow();
		window.hide();
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("carInfo.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("燃費計算画面");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//車両管理画面
	@FXML
	public void onSyaryoClick(ActionEvent event) {
		
		Scene s = ((Node)event.getSource()).getScene();
		Window window = s.getWindow();
		window.hide();
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("carManagement.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("車両管理画面");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//移動計算画面
	@FXML
	public void onTripClick(ActionEvent event) {
		
		Scene s = ((Node)event.getSource()).getScene();
		Window window = s.getWindow();
		window.hide();
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("tripCalc.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("移動計算画面");
			stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
}