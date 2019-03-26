package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	private static final String jdbcURL= "jdbc:mysql://localhost/iscrittiCorsi?useTimezone=true&serverTimezone=UTC&user=root&password=toro1997";

	public static Connection getConnection() {
		
		Connection conn;
		
		try {
			conn= DriverManager.getConnection(jdbcURL);
			return conn;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
