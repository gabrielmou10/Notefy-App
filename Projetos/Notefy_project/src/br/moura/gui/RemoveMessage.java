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

/**
 * Servlet implementation class RemoveMessage
 */
@WebServlet(urlPatterns = { "/removenoteform" })
public class RemoveMessage extends HttpServlet {
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
			try {
				dao.removemessage(Integer.valueOf(request.getParameter("id")));
			} catch (NumberFormatException | SQLException e) {
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