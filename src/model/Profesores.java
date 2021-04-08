package model;

import java.sql.SQLException;

public class Profesores extends Table {

	//Constructor
	public Profesores(ConexionOracle con) {
		setCon(con);
	}
	
	//Methods
	@Override
	public String createTable() throws SQLException {
		String sql = "CREATE TABLE " + this.getClass().getSimpleName().toUpperCase() + "("
				+ "CEDULA VARCHAR2(20) PRIMARY KEY,"
				+ "NOMBRE VARCHAR2(40) NOT NULL,"
				+ "DEPARTAMENTO NUMBER(3) NOT NULL)";
		executeStatement(sql);
		return createTableOutput();
	}
	
	public String Insert(String cedula, String nombre, int departamento) throws SQLException {
		String sql = "INSERT INTO " + this.getClass().getSimpleName().toUpperCase() + " VALUES(" + "'" + cedula + "', " + "'" + nombre + "', " + departamento + ")";
		executeStatement(sql);
		return insertOutput();
	}
}