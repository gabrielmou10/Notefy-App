package br.moura.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.moura.gui.Messages;

public class DAO {
	private Connection connection = null;
	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/meus_dados", "root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() throws SQLException {
		connection.close();
	}
	
	public void add(Messages message) throws SQLException {
		String sql = "INSERT INTO MENSAGEM" +
		"(mensagem,categoria,userid) values(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,message.getMessage());
		stmt.setString(2,message.getCategory());
		stmt.setString(3,message.getUserMessage());
		stmt.execute();
		stmt.close();
	}
	
	public void update(Messages message) throws SQLException {
		String sql = "UPDATE MENSAGEM SET " +
		 "mensagem=?, categoria=?, userid=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,message.getMessage());
		stmt.setString(2,message.getCategory());
		stmt.setString(3,message.getUserMessage());
		stmt.execute();
		stmt.close();
	}
	
	public void remove(Integer id) throws SQLException {
		PreparedStatement stmt = connection
		 .prepareStatement("DELETE FROM Messages WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
	}
	
	public List<Messages> getLista() throws SQLException {
		
		List<Messages> messages = new ArrayList<Messages>();
		
		PreparedStatement stmt = connection.
			prepareStatement("SELECT * FROM Pessoas");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Messages message = new Messages();
			message.setId(rs.getInt("id"));
			message.setMessage(rs.getString("mensagem"));
			message.setCategory(rs.getString("categoria"));
			message.setUserMessage(rs.getString("usuario da mensagem"));
			messages.add(message);
		}
		rs.close();
		stmt.close();
		
		return messages;
	}
}
