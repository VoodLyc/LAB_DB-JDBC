package ui;

import java.sql.SQLException;

import model.ConexionOracle;
import model.Cursos;
import model.Estudiantes;
import model.Matricula;
import model.Profesores;
import model.Reporte;

public class InterfazPrincipal {
	
	//Attributes
	private ConexionOracle connection;
	private Estudiantes estudiante;
	private Profesores profesor;
	private Cursos curso;
	private Matricula matricula;
	
	//Constructor
	public InterfazPrincipal() {
		start();
	}

	//Main
	public static void main(String[] args) {
		new InterfazPrincipal();
	}
	
	//Methods
	public void start() {
		try {
			connection = new ConexionOracle();
			initTables();
			dropTables();
			createTables();
			insertData();
			System.out.println(new Reporte(connection).report());
			connection.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n" + e.getMessage());
		}
	}
	
	public void initTables() {
		estudiante = new Estudiantes(connection);
		profesor = new Profesores(connection);
		curso = new Cursos(connection);
		matricula = new Matricula(connection);
	}
	
	public void dropTables() {
		try {
			System.out.println(estudiante.dropTable());
			System.out.println(profesor.dropTable());
			System.out.println(curso.dropTable());
			System.out.println(matricula.dropTable());
		} catch (SQLException e) {
			System.out.println("\n" + e.getMessage());
		}
	}
	
	public void createTables() throws SQLException {
		System.out.println(estudiante.createTable());
		System.out.println(profesor.createTable());
		System.out.println(curso.createTable());
		System.out.println(matricula.createTable());
	}
	
	public void insertData() throws SQLException {
		//ESTUDIANTE
		System.out.println(estudiante.insert("A00359178", "Johan Giraldo", "SIS", 4.0, 20));
		System.out.println(estudiante.insert("A00359179", "Esteban Ariza", "SIS", 4.7, 21));
		//PROFESOR
		//CURSO
		//MATRICULA
	}
}