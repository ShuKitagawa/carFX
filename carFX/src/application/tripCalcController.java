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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class tripCalcController {
	@FXML private Button returnTop;
	@FXML private TextField  kyoriTextField;
	@FXML private TextField nenpiTextField;
	@FXML private TextField gasTexField;
	@FXML private Button  calcButton;
	@FXML private Label  costResult;
	@FXML private Label  fuelResult;
	@FXML private Label  chekResult;


	//「計算する」ボタンクリック
	@FXML
	protected void onCalcClick(ActionEvent evt) {
		
		//目的地までの距離
		String kyoriTextField2 = kyoriTextField.getText(); 
		String chek = tripCalcTask.checkText(kyoriTextField2);
		//入力値をチェック
		chekResult.setText(chek);
		int kyoriTextField3 = Integer.parseInt(kyoriTextField2); 

		//車の平均燃費
		String nenpiTextField2 = nenpiTextField.getText(); 
		String chek2 = tripCalcTask.checkText(nenpiTextField2);
		//入力値をチェック
		chekResult.setText(chek2);
		int nenpiTextField3 = Integer.parseInt(nenpiTextField2); 
		
		//ガソリン価格
		String gasTextField2 = gasTexField.getText(); 
		String chek3 = tripCalcTask.checkText(gasTextField2);
		//入力値をチェック
		chekResult.setText(chek3);
		int gasTextField3 = Integer.parseInt(gasTextField2); 

		//必要なガソリン量を計算
		Integer fuelResultText =kyoriTextField3/nenpiTextField3;
		String fuelResultText2 =fuelResultText.toString(); 
		costResult.setText(fuelResultText2); //結果をラベルに入れる
		
		//ガソリン代を計算
		Integer gasResultText =gasTextField3*fuelResultText;
		String gasResultText2 =gasResultText.toString(); 
		fuelResult.setText(gasResultText2); //結果をラベルに入れる

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