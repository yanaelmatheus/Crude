package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Usuario;

public class UsuarioDao {
	
	private Connection connection;
	
	public UsuarioDao() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public boolean Verifica_Usuario(String login, String Senha) throws SQLException {
		
		boolean result = false;
		
		PreparedStatement stmt = connection.prepareStatement("select count(login) as total from usuarios" + " where login = '" +login+ "'" + "and pass = '" +Senha+ "'");
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			String Usuarios_Encontrados = rs.getString("total");
			if("1".equals(Usuarios_Encontrados)) {
				result = true;
			} else {
				result = false;
			}	
		}
			
		return result;
}
}
