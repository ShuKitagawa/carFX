package application.controller;

import java.io.IOException;

import application.check.CheckTextFinal;
import application.check.TextCheck;
import application.database.DbCon;
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

public class CarInfoController {
	
	//燃費計算画面
	@FXML private Button returnTop;
	@FXML private TextField  carNameTextField;
	@FXML private TextField fuelAmountTextField;
	@FXML private TextField tripTextField;
	@FXML private Button  calcButton;
	@FXML private Label  fuelResult;
	@FXML private Label  chekResult;


	//「計算する」ボタンクリック
	@FXML
	protected void onCalcClick(ActionEvent evt) {

		//車種
		String carNameTextField2 = carNameTextField.getText(); 

		//給油量
		String fuelAmountTextField2 = fuelAmountTextField.getText();
		//全角入力の場合半角に変換する
		TextCheck.toHalfWidth(fuelAmountTextField2);

		//走行距離
		String tripTextField2 = tripTextField.getText(); 
		//全角入力の場合半角に変換する
		TextCheck.toHalfWidth(tripTextField2);

		//入力値が数値かどうかチェック
		String chek = TextCheck.checkFuelText(carNameTextField2,fuelAmountTextField2,tripTextField2);

		//チェック結果を格納
		chekResult.setText(chek);
		if(chek.equals(CheckTextFinal.OK)) {

			//チェックOKだった場合は数値に変換
			int fuelAmountTextField3 = Integer.parseInt(fuelAmountTextField2); 
			int tripTextField3 = Integer.parseInt(tripTextField2); 

			//燃費を計算
			Integer fuelResultText =tripTextField3/fuelAmountTextField3;
			String fuelResultText2 =fuelResultText.toString();

			//結果をラベルに入れる
			fuelResult.setText(fuelResultText2); 
			
			//車種と燃費をDBに登録
			DbCon.sqlFuelInsert(carNameTextField2,fuelResultText);

		} else {
			
			//入力値が正しくない場合はテキストエリアから入力値を削除
			carNameTextField.setText("");
			fuelAmountTextField.setText("");
			tripTextField.setText("");
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