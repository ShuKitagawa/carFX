package application.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import application.DTO;
import application.check.CheckTextFinal;
import application.check.TextCheck;
import application.database.DBConnect;
import application.database.DbCon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Window;

public class CarManagementContoller {
	@FXML private Button returnTop;
	@FXML private Label  chekResult1;
	@FXML private TextField  insertCarField;
	@FXML private TextField insertNenpiField1;
	@FXML private TextField insertNenpiField2;
	@FXML private TextField deleteCarField;
	@FXML private Button  insertCarButton;
	@FXML private Button  insertNenpiButton;
	@FXML private Button  deleteCarButton;
	@FXML private Button  reloadDBButton;
	@FXML private Label  costResult;
	@FXML private Label  fuelResult;
	@FXML private TableColumn<?, ?>  name;
	@FXML private TableColumn<?, ?>  ID;
	@FXML private TableColumn<?, ?>  col;
	@FXML private TableView<DTO>  tblView;

	//「車種登録」ボタンクリック
	@FXML
	protected void onInsertCarClick(ActionEvent evt) {
		//車種登録
		String insertCarField2 = insertCarField.getText(); 
		//入力値が空白でないかどうか、10文字以下になっているかどうかチェック
		String chek = TextCheck.checkCarnameText(insertCarField2);
		//チェック結果を格納
		chekResult1.setText(chek);
		
		if(chek.equals(CheckTextFinal.OK)) {
			DbCon.sqlInsert(insertCarField2);
		} else {
			insertCarField.setText("");
		}
	}
	
	//「燃費登録」ボタンクリック
	@FXML
	protected void onInsertNenpiClick(ActionEvent evt) {
		
		String stringInsertNenpiId1 = insertNenpiField1.getText();
		TextCheck.toHalfWidth(stringInsertNenpiId1);
		
		String stringInsertNenpi1 = insertNenpiField2.getText();
		TextCheck.toHalfWidth(stringInsertNenpi1);
		
		String chek = TextCheck.caeManagementCheckText(stringInsertNenpiId1,stringInsertNenpi1);
		//チェック結果を格納
		chekResult1.setText(chek);
		//チェック結果を格納
		if(chek.equals(CheckTextFinal.OK)) {
		//燃費を登録
		int insertNenpiId = Integer.parseInt(insertNenpiField1.getText()); 
		int insertNenpi = Integer.parseInt(insertNenpiField2.getText());
		DbCon.sqlFuelInsert(insertNenpiId,insertNenpi);
		} else {
			//入力値が正しくない場合はテキストエリアから入力値を削除
			insertNenpiField1.setText("");
			insertNenpiField2.setText("");
		}
	}

	//「車種削除」ボタンをクリック
	@FXML
	protected void onDeleteCarClick(ActionEvent evt) {
		String deleteCarField1 = deleteCarField.getText();
		String chek = TextCheck.checkId(deleteCarField1);
		//チェック結果を格納
		chekResult1.setText(chek);
		//チェック結果を格納
		if(chek.equals(CheckTextFinal.OK)) {
		//燃費を登録
		int deleteCarField2 = Integer.parseInt(deleteCarField.getText()); 
		DbCon.sqlCarDelete(deleteCarField2);
		} else {
			//入力値が正しくない場合はテキストエリアから入力値を削除
			deleteCarField.setText("");
		}
		
	}
	



//更新ボタンをクリック
	@FXML
	public void onReloadClick(ActionEvent evt) {
		
		//SQLを指定してDBに接続
		ObservableList<DTO> data=FXCollections.observableArrayList();
		Connection c;
		try {
			c = DBConnect.connect();
			String SQL = "SELECT * from PRODUCT";
			ResultSet rs = c.createStatement().executeQuery(SQL);
			ID.setCellValueFactory(new PropertyValueFactory<>("ID")); 
			name.setCellValueFactory(new PropertyValueFactory<>("name"));
			col.setCellValueFactory(new PropertyValueFactory<>("col"));
			
			while(rs.next())
			{
				data.add(new DTO(
						rs.getInt("ID"),
						rs.getString("name"),
						rs.getString("col")
						));
				tblView.setItems(data);
			}
			rs.close();
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}


	//Top画面に戻る
	@FXML
	public void onTopClick(ActionEvent event) {

		Scene s = ((Node)event.getSource()).getScene();
		Window window = s.getWindow();
		window.hide();

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("scenebuild/carcontoller.fxml"));
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