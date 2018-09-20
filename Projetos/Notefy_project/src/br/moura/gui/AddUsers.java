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
import br.moura.gui.Users;


/**
 * Servlet implementation class AddUsers
 */
@WebServlet(urlPatterns = { "/adduserform" })
public class AddUsers extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
						throws ServletException, IOException {
		request.getRequestDispatcher("/SignUp.jsp").include(request, response);;
	}
	@Override
	 protected void doPost(HttpServletRequest request,
			 				HttpServletResponse response)
			 	throws ServletException, IOException {
		DAO dao = new DAO();
		
		Users user  = new Users();
		user.setName(request.getParameter("namelogin"));
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
	 
		try {
			dao.adduser(user);
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