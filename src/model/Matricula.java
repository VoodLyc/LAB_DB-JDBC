package model;

import java.sql.SQLException;

public class Matricula extends Table {
	
	//Constructor
	public Matricula(ConexionOracle con) {
		setCon(con);
	}

	//Methods
	@Override
	public String createTable() throws SQLException {
		String sql = "CREATE TABLE " + this.getClass().getSimpleName().toUpperCase() + "("
				+ "ESTUDIANTE VARCHAR2(20) REFERENCES ESTUDIANTES(CODIGO),"
				+ "CURSO VARCHAR2(30) REFERENCES CURSOS(NOMBRE),"
				+ "CONSTRAINT PK_MATRICULA PRIMARY KEY(ESTUDIANTE, CURSO))";
		executeStatement(sql);
		return createTableOutput();
	}
	
	public String insert(String estudiante, String curso) throws SQLException {
		String sql = "INSERT INTO " + this.getClass().getSimpleName().toUpperCase() + " VALUES(" + "'" + estudiante + "', " + "'" + curso + ")";
		executeStatement(sql);
		return insertOutput();
	}
}