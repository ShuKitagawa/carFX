package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbCon {

	static final String URL = "jdbc:mysql://localhost/carmng";
	static final String USERNAME = "root";
	static final String PASSWORD = "pirooporoo";

	public static void  sqlInsert(String sqlstate) {
		//車を登録
		String carname = sqlstate;

		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement preStatement = con.prepareStatement("insert into product (name) values (?);")) {

			preStatement.setString(1, carname);
			int count = preStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	public static void  sqlFuelInsert(String sqlstate,Integer sqlstate2) {
		//車を登録
		String carname = sqlstate;
		//燃費を登録
		int fuel = sqlstate2;

		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement preStatement = con.prepareStatement("insert into carmng.product (name,col) values (?,?);")) {

			preStatement.setString(1, carname);
			preStatement.setInt(2, fuel);
			int count = preStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void  sqlSelect() {

		//登録した車を参照
		String sql = "SELECT * FROM product;";

		try (	Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement statement = connection.prepareStatement(sql); ) {

			ResultSet result = statement.executeQuery();
			System.out.println("｜id｜名前｜平均燃費｜");
			while (result.next()) {
				System.out.print(" ｜ "  + result.getString(1));
				System.out.print(" ｜ "  + result.getString(2));
				System.out.print(" ｜ "  + result.getString(3)+ " ｜ ");
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public static void sqlFuelSelect(int CarId) {

		//登録されている車種情報を出力
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement statement = con.prepareStatement("SELECT * FROM product where id =" + CarId + ";")) {
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				System.out.print(" ｜ "  + result.getString(1));
				System.out.print(" ｜ "  + result.getString(2));
				System.out.print(" ｜ "  + result.getString(3)+ " ｜ ");
				System.out.println("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	public static void sqlFuelInsert(int CarId,int fuelQuality) {
		
		//燃費を記録
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement preStatement = con.prepareStatement("update product set col = ? where id = ? ;")) {
			preStatement.setInt(1, fuelQuality);
			preStatement.setInt(2, CarId);
			int count = preStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	public static void sqlCarDelete(int CarId) {
		//車を削除
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement preStatement = con.prepareStatement("delete from product where id =  ?;")) {
			preStatement.setInt(1, CarId);
			int count = preStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}