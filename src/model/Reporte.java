package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reporte {
	
	private ConexionOracle con;
	
	public Reporte(ConexionOracle con) {
		this.con = con;
	}

	public String report() throws SQLException {
		String begin = "\n********** INICIO REPORTE DE CURSOS POR ESTUDIANTE **********\n"
	+ "CODIGO_EST NOMBRE_EST NOMBRE_CURSO HORARIO SALON NOMBRE_PROF";
		String end = "********************* FIN REPORTE **************************";
		
		String query = "SELECT E.CODIGO, E.NOMBRE, C.NOMBRE, C.HORARIO, C.SALON, P.NOMBRE"
				+ " FROM ESTUDIANTES E INNER JOIN MATRICULA M ON E.CODIGO=M.ESTUDIANTE"
				+ " INNER JOIN CURSOS C ON M.CURSO=C.NOMBRE"
				+ " INNER JOIN PROFESORES P ON C.PROFESOR=P.CEDULA"
				+ " ORDER BY E.NOMBRE ASC";
		
		Statement stmt = con.getConnection().createStatement();
		ResultSet rs = stmt.executeQuery(query);
		String result = "";
		
		while(rs.next()) {
			result += "\n" + rs.getString(1) + " , " + rs.getString(2) + " , " + rs.getString(3) + " , " + rs.getString(4) + " , " + rs.getString(5);
		}
		
		rs.close();
		stmt.close();
		
		String report = begin + "\n" + result + "\n"+ end;
		return report;
	}
}