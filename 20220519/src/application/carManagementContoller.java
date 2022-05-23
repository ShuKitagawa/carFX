package application;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

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



	@FXML
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void onReloadClick(ActionEvent evt) {
		//SQLを指定してDBに接続
		ObservableList<ObservableList> data;
		Connection c;
		data = FXCollections.observableArrayList();
		try {
			c = DBConnect.connect();
			String SQL = "SELECT * from PRODUCT";
			ResultSet rs = c.createStatement().executeQuery(SQL);


			//カラムを取得
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				
				final int j = i;
				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
				col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
					public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
						return new SimpleStringProperty(param.getValue().get(j).toString());
					}
				});

				carData.getColumns().addAll(col);
				System.out.println("Column [" + i + "] ");
			}
			
			//取得したデータをListに格納
			while (rs.next()) {
				ObservableList<String> row = FXCollections.observableArrayList();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {

					row.add(rs.getString(i));
				}
				System.out.println("Row [1] added " + row);
				data.add(row);

			}

			//画面上にデータを表示
			carData.setItems(data);
		} catch (Exception e) {
			e.printStackTrace();
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