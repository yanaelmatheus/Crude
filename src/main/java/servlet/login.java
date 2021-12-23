package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import beans.Usuario;
import dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter	out	=	response.getWriter();
		
		Usuario u = new Usuario();
		
		u.setUsuario(request.getParameter("user"));
		u.setSenha(request.getParameter("pass"));
		
		
		UsuarioDao us = new UsuarioDao();
		
		
		try {
			if(us.Verifica_Usuario(u.getUsuario(), u.getSenha()) == true) {
				
				out.println("<html>");
				out.println("<body>");
				out.println("Bem Vindo	"	+	u.getUsuario());								
				out.println("</body>");
				out.println("</html>");
				
			} else {
				out.println("<html>");
				out.println("<body>");
				out.println("Não foi possível logar no usuario 	"	+	u.getUsuario());								
				out.println("</body>");
				out.println("</html>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

			

		
		

		
	}
}
