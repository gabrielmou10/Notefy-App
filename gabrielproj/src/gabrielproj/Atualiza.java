package gabrielproj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/atualiza")
public class Atualiza extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
						HttpServletResponse response)
	throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("ID: <input type='number' name='id'><br>");
		out.println("Nome: <input type='text' name='nome'><br>");
		out.println("Nascimento: <input type='date' name='nascimento'><br>");
		out.println("Altura: <input type='number' name='altura' step='0.01'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
						HttpServletResponse response)
	throws ServletException, IOException {
		
		DAO dao = new DAO();
		
		Pessoas pessoa = new Pessoas();
		pessoa.setId(Integer.valueOf(request.getParameter("id")));
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setAltura(Double.valueOf(request.getParameter("altura")));
		
	//	String nascimento = request.getParameter("nascimento");
	//		Date data = new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);
	//	Calendar dataNascimento = Calendar.getInstance();
	//	dataNascimento.setTime(data);
	//	pessoa.setNascimento(dataNascimento);
		
		try {
			dao.altera(pessoa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("atualizado" + pessoa.getNome());
		out.println("</body></html>");
		
		try {
			dao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}	