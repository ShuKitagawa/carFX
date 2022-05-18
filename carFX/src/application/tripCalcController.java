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

		//車の平均燃費
		String nenpiTextField2 = nenpiTextField.getText(); 

		//ガソリン価格
		String gasTextField2 = gasTexField.getText(); 

		//入力値が数値かどうかチェック
		String chek = tripCalcTask.checkText(kyoriTextField2,nenpiTextField2,gasTextField2);


		//チェック結果を格納
		chekResult.setText(chek);
		if(chek.equals("OK!")) {

			//チェックOKだった場合は数値に変換
			int kyoriTextField3 = Integer.parseInt(kyoriTextField2); 		
			int nenpiTextField3 = Integer.parseInt(nenpiTextField2); 
			int gasTextField3 = Integer.parseInt(gasTextField2); 

			//必要なガソリン量を計算
			Integer fuelResultText =kyoriTextField3/nenpiTextField3;
			String fuelResultText2 =fuelResultText.toString();

			//結果をラベルに入れる
			costResult.setText(fuelResultText2); 

			//ガソリン代を計算
			Integer gasResultText =gasTextField3*fuelResultText;
			String gasResultText2 =gasResultText.toString();

			//結果をラベルに入れる
			fuelResult.setText(gasResultText2); 

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