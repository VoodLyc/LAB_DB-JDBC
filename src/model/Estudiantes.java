package model;

import java.sql.SQLException;

public class Estudiantes extends Table {
	
	//Constructor
	public Estudiantes(ConexionOracle con) {
		setCon(con);
	}

	//Methods
	@Override
	public String createTable() throws SQLException {
		String sql = "CREATE TABLE " + this.getClass().getSimpleName().toUpperCase() + "("
				+ "CODIGO VARCHAR2(20) PRIMARY KEY,"
				+ "NOMBRE VARCHAR2(40) NOT NULL,"
				+ "PROGRAMA VARCHAR2(50) NOT NULL,"
				+ "PROMEDIO_ACUMULADO NUMBER(3, 2) NOT NULL,"
				+ "EDAD NUMBER(3) NOT NULL)";
		executeStatement(sql);
		return createTableOutput();
	}

	public String insert(String codigo, String nombre, String programa, double promedioAcumulado, int edad) throws SQLException {
		String sql = "INSERT INTO " + this.getClass().getSimpleName().toUpperCase() + " VALUES(" + "'" + codigo + "', " + "'" + nombre + "', " + "'" + programa + "', " + promedioAcumulado + ", " + edad + ")";
		executeStatement(sql);
		return insertOutput();
	}
}