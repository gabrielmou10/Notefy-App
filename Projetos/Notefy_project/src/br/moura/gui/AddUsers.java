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
import br.moura.gui.Users;


/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class AddUsers extends HttpServlet {
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
			out.println("name: <input type='text' name='name'><br>");
			out.println("login: <input type='text' name='login'><br>");
			out.println("password: <input type='text' name='password'><br>");
			out.println("<input type='submit' value='Submit'>");
			out.println("</form>");
			out.println("<body><html>");
	}
	@Override
	 protected void doPost(HttpServletRequest request,
			 				HttpServletResponse response)
			 	throws ServletException, IOException {
		DAO dao = new DAO();
		
		Users user  = new Users();
		//user.setId(Integer.valueOf(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
	 
		try {
			dao.adduser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("adicionado");
		out.println("</body></html>");
		
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}