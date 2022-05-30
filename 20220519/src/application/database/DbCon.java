package application.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbCon {

	static final String URL = "jdbc:mysql://localhost/carmng";
	static final String USERNAME = "root";
	static final String PASSWORD = "pirooporoo";

	public static void  sqlInsert(String sqlstate) {
		//車を登録
		String carname = sqlstate;

		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement preStatement = con.prepareStatement("insert into product (name) values (?);")) {

			preStatement.setString(1, carname);
			preStatement.executeUpdate();
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
		 preStatement.executeUpdate();

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
			preStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	public static void sqlCarDelete(int CarId) {
		//車を削除
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement preStatement = con.prepareStatement("delete from product where id =  ?;")) {
			preStatement.setInt(1, CarId);
			preStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}