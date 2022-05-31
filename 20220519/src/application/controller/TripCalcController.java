package application.controller;

import java.io.IOException;

import application.check.CheckTextFinal;
import application.check.TextCheck;
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

public class TripCalcController {
	
	//移動計算画面
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
		String kyori = kyoriTextField.getText(); 
		//全角入力の場合半角に変換する
		TextCheck.toHalfWidth(kyori);

		//車の平均燃費
		String nenpi = nenpiTextField.getText(); 
		//全角入力の場合半角に変換する
		TextCheck.toHalfWidth(nenpi);
		
		//ガソリン価格
		String gas = gasTexField.getText(); 
		//全角入力の場合半角に変換する
		TextCheck.toHalfWidth(gas);
		
		//入力値が数値かどうかチェック
		String chek = TextCheck.checkText(kyori,nenpi,gas);


		//チェック結果を格納
		chekResult.setText(chek);
		if(chek.equals(CheckTextFinal.OK)) {

			//チェックOKだった場合は数値に変換
			int intKyori = Integer.parseInt(kyori); 		
			int intNenpi = Integer.parseInt(nenpi); 
			int intGas = Integer.parseInt(gas); 

			//必要なガソリン量を計算
			Integer fuelResultText =intKyori/intNenpi;
			String fuelResultText2 =fuelResultText.toString();

			//ガソリン代を計算
			Integer gasResultText =intGas*fuelResultText;
			String gasResultText2 =gasResultText.toString();
			//結果をラベルに入れる
			costResult.setText(gasResultText2); 
			fuelResult.setText(fuelResultText2); 

		} else {
			
			//入力値が正しくない場合はテキストエリアから入力値を削除
			kyoriTextField.setText("");
			nenpiTextField.setText("");
			gasTexField.setText("");
		}
	}

	//Top画面に戻る
	@FXML
	public void onTopClick(ActionEvent event) {

		Scene s = ((Node)event.getSource()).getScene();
		Window window = s.getWindow();
		window.hide();

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("../scenebuild/carcontoller.fxml"));
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