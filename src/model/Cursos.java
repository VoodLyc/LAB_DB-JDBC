package model;

import java.sql.SQLException;

public class Cursos extends Table {
	
	//Constructor
	public Cursos(ConexionOracle con) {
		setCon(con);
	}
	
	//Methods
	@Override
	public String createTable() throws SQLException {
		String sql = "CREATE TABLE " + this.getClass().getSimpleName().toUpperCase() + "("
				+ "NOMBRE VARCHAR2(30) PRIMARY KEY,"
				+ "HORARIO VARCHAR2(30) NOT NULL,"
				+ "SALON VARCHAR2(8) NOT NULL,"
				+ "PROFESOR VARCHAR2(20) NOT NULL,"
				+ "CONSTRAINT FK_CEDULA FOREIGN KEY (PROFESOR) REFERENCES PROFESORES(CEDULA))";
		executeStatement(sql);
		return createTableOutput();
	}
	
	public String insert(String nombre, String horario, String salon, String profesor) throws SQLException {
		String sql = "INSERT INTO " + this.getClass().getSimpleName().toUpperCase() + " VALUES(" + "'" + nombre + "', " + "'" + horario + "', " + salon + "'" + profesor + ")";
		executeStatement(sql);
		return insertOutput();
	}

}