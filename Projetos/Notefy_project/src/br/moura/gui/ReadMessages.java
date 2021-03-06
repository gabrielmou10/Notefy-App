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
 * Servlet implementation class ReadMessages
 */
@WebServlet("/ReadMessages")
public class ReadMessages extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request,
			 HttpServletResponse response)
		throws ServletException, IOException {
		
		DAO dao = new DAO();
		
		List<Messages> messages = null;
		try {
			messages = dao.getListaMessages();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><td>ID</td><td>Mensagens</td>" +
			 "<td>Categorias<td>Usuarios</td></tr>");
		for (Messages message : messages) {
			out.println("<tr><td>" + message.getId() + "</td>");
			out.println("<td>" + message.getMessage() + "</td>");
			out.println("<td>" + message.getCategory() + "</td>");
			out.println("<td>" + message.getUserMessage() + "</td></tr>");
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
