package br.moura.gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.moura.gui.DAO;
import br.moura.gui.Messages;

/**
 * Servlet implementation class UpdateMessage
 */
@WebServlet("/UpdateMessage")
public class UpdateMessage extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
	throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("id: <input type='number' name='id'><br>");
		out.println("message: <input type='text' name='message'><br>");
		out.println("category: <input type='text' name='category'><br>");
		out.println("usermessage: <input type='text' name='usermessage' step='0.01'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
						HttpServletResponse response)
	throws ServletException, IOException {
		
		DAO dao = new DAO();
		
		Messages message  = new Messages();
		message.setId(Integer.valueOf(request.getParameter("id")));
		message.setMessage(request.getParameter("message"));
		message.setCategory(request.getParameter("category"));
		message.setUserMessage(request.getParameter("usermessage"));
		

		
		try {
			dao.updatemessage(message);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("atualizado" + message.getMessage());
		out.println("</body></html>");
		
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}	