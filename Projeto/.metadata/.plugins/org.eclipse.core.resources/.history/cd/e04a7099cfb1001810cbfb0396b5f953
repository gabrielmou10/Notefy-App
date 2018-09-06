package br.moura.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adicionaNome")
public class AddNameServlet extends HttpServlet {
	protected void service(HttpServletRequest request,
						HttpServletResponse response)
	throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		out.println("<html>");
		out.println("<body>");
		out.println("Nome: " + nome );
		out.println("</body>");
		out.println("</html>");
	}
}