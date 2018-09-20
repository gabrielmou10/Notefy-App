package br.moura.gui;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = { "/editnoteform" })
public class UpdateMessage extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
	throws ServletException, IOException {
		request.getRequestDispatcher("/Mensagem.jsp").include(request, response);
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Mensagem.jsp");
		dispatcher.forward(request, response);
		
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}	