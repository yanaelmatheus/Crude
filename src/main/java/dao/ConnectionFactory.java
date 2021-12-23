package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/estuda",	"root",	"");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
