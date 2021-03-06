package br.moura.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadUsers
 */
@WebServlet("/ReadUsers")
public class ReadUsers extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			 HttpServletResponse response)
		throws ServletException, IOException {
		
		DAO dao = new DAO();
		
		List<Users> users = null;
		try {
			users = dao.getListaUsers();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><td>ID</td><td>Nomes</td>" +
			 "<td>Logins<td>Senhas</td></tr>");
		for (Users user : users) {
			out.println("<tr><td>" + user.getId() + "</td>");
			out.println("<td>" + user.getName() + "</td>");
			out.println("<td>" + user.getLogin() + "</td>");
			out.println("<td>" + user.getPassword() + "</td></tr>");
			}
		out.println("</table></body></html>");

			try {
				dao.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 }


}
