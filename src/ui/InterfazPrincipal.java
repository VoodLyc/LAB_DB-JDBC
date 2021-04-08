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
	private Estudiantes estudiantes;
	private Profesores profesores;
	private Cursos cursos;
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
		estudiantes = new Estudiantes(connection);
		profesores = new Profesores(connection);
		cursos = new Cursos(connection);
		matricula = new Matricula(connection);
	}
	
	public void dropTables() {
		try {
			System.out.println(estudiantes.dropTable());
			System.out.println(profesores.dropTable());
			System.out.println(cursos.dropTable());
			System.out.println(matricula.dropTable());
		} catch (SQLException e) {
			System.out.println("\n" + e.getMessage());
		}
	}
	
	public void createTables() throws SQLException {
		System.out.println(estudiantes.createTable());
		System.out.println(profesores.createTable());
		System.out.println(cursos.createTable());
		System.out.println(matricula.createTable());
	}
	
	public void insertData() throws SQLException {
		//ESTUDIANTES
		System.out.println(estudiantes.insert("A01","Samuel Satizabal","Ingenieria de Sistemas",3.8,21));
		System.out.println(estudiantes.insert("A02","Esteban Ariza","Diseno de Medios Interactivos",4.5,20));
		System.out.println(estudiantes.insert("A03","Mateo Valdes","Ingenieria de Sistemas",4.8,23));
		System.out.println(estudiantes.insert("A04","Johan Giraldo","Ingenieria de Sistemas",4.0,20));
		System.out.println(estudiantes.insert("A05","Juan Ossa","Ingenieria Telematica",4.2,19));
		//PROFESORES
		System.out.println(profesores.insert("101","Enrique Pena",1));
		System.out.println(profesores.insert("102","Karen Lara",2));
		System.out.println(profesores.insert("103","Victor Vargas",3));
		System.out.println(profesores.insert("104","Andres Alberto Aristizabal",4));
		System.out.println(profesores.insert("105","Juan Manuel Reyes",5));
		//CURSOS
		System.out.println(cursos.insert("Intro TIC","7:00am-9:00am","E201","101"));
		System.out.println(cursos.insert("APO I","9:00am-11:00am","E202","102"));
		System.out.println(cursos.insert("APO II","11:00am-1:00pm","E203","103"));
		System.out.println(cursos.insert("AED","2:00pm-4:00pm","E204","104"));
		System.out.println(cursos.insert("PI I","4:00pm-6:00pm","E205","105"));
		//MATRICULA
		System.out.println(matricula.insert("A01","Intro TIC"));
		System.out.println(matricula.insert("A02","Intro TIC"));
		System.out.println(matricula.insert("A03","Intro TIC"));
		System.out.println(matricula.insert("A04","Intro TIC"));
		System.out.println(matricula.insert("A05","Intro TIC"));
		System.out.println(matricula.insert("A01","APO I"));
		System.out.println(matricula.insert("A02","APO II"));
		System.out.println(matricula.insert("A03","AED"));
		System.out.println(matricula.insert("A04","PI I"));
	}
}