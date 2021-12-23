package dao;

import beans.Usuario;

public class teste {

	public static void main(String[] args) {
		
		Usuario u = new Usuario();
		
		u.setUsuario("yanael");
		u.setSenha("123");
		
		UsuarioDao dao = new UsuarioDao();
		
		boolean b = dao.VerificaUsuario(u);
		
		
		System.out.println(b);
	}

}
