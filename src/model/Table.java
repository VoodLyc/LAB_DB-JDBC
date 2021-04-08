package model;

import java.sql.SQLException;
import java.sql.Statement;

public abstract class Table {
	
	//Attributes
	private ConexionOracle con;
	
	//Abstract methods
	public abstract String createTable() throws SQLException;
	
	//Methods
	public String createTableOutput() {
		return "\nTable " + this.getClass().getSimpleName().toUpperCase() + " created.\n";
	}
	
	public String dropTableOutput() {
		return "\nTable " + this.getClass().getSimpleName().toUpperCase() + " dropped.\n";
	}
	
	public String insertOutput() {
		return "\n1 row inserted.\n";
	}

	public void executeStatement(String sql) throws SQLException {
		Statement stmt = getCon().getConnection().createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
	}
	
	public String dropTable() throws SQLException {
		String sql = "DROP TABLE " + this.getClass().getSimpleName().toUpperCase() + " CASCADE CONSTRAINTS";
		executeStatement(sql);
		return dropTableOutput();
	}
	
	//Getters
	public ConexionOracle getCon() {
		return con;
	}
	
	//Setters
	public void setCon(ConexionOracle con) {
		this.con = con;
	}
}