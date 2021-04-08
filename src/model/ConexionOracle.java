package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {
	
	private Connection connection;
	
	public ConexionOracle() throws SQLException {
		connect();
	}
	
	private void connect() throws SQLException {
		connection = DriverManager.getConnection("jdbc:oracle:thin:@//200.3.193.24:1522/ESTUD", "P09551_1_8", "P09551_1_8_20211");
	}
	
	public Connection getConnection() {
		return connection;
	}
}