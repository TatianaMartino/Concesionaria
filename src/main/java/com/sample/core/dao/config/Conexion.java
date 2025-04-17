package com.sample.core.dao.config;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Conexion {
	
	private static final Logger log = Logger.getLogger(Conexion.class
			.getPackage().getName());
	
	private static final String HOST = "localhost";
	private static final String URL = "jdbc:mysql://"+HOST+":3306";
	private static final String DBNAME = "concesionaria";
	
	
	private static final String TIMEZONE = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
				
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";
	

	private static Conexion instance;
	 
	private Connection conn;
	
	private Conexion() {}
	
	 public static Conexion getInstance() {
	       if (instance == null) {
	    	   instance = new Conexion();
	       }
	       return instance;
	   }
	
	 public Connection dameConnection() {
	        if (conn == null) {
	            try {
	                Class.forName(DRIVER);  // Cargar el driver MySQL
	                conn = DriverManager.getConnection(URL + "/" + DBNAME + TIMEZONE, USUARIO, PASSWORD);

	                // Verificar si la conexión es válida
	                if (!conn.isClosed()) {
	                    log.info("Conectado a la base de datos.");
	                } else {
	                    log.warning("La conexión está cerrada.");
	                }
	            } catch (ClassNotFoundException e) {
	                log.severe("Error de acceso al driver: " + e.getMessage());
	                e.printStackTrace();
	            } catch (SQLException e) {
	                log.severe("Error de SQL: " + e.getMessage());
	                e.printStackTrace();
	            }
	        }
	        return conn;
	    }
	}

