package gabrielproj;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/lista")
public class Lista extends HttpServlet {
	
	protected void service(HttpServletRequest request,
							HttpServletResponse response)
	
			throws ServletException, IOException {
				DAO dao = new DAO();
				
				List<Pessoas> pessoas = null;
				try {
					pessoas = dao.getLista();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				PrintWriter out = response.getWriter();
				out.println("<html><body><table border='1'>");
				out.println("<tr><td>ID</td><td>Nome</td>" +
						"<td>Nascimento</td><td>Altura</td></tr>");
				for (Pessoas pessoa : pessoas) {
					out.println("<tr><td>" + pessoa.getId() + "</td>");
					out.println("<td>" + pessoa.getNome() + "</td>");
					out.println("<td>" + pessoa.getNascimento().getTime() + "</td>");
					out.println("<td>" + pessoa.getAltura() + "</td></tr>");
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