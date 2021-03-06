package br.moura.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.moura.gui.Messages;
import br.moura.gui.Users;


public class DAO {
	private Connection connection = null;
	public DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/Projeto1?autoReconnect=true&useSSL=false", "root", "gm9mourelisSQL");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("oioi");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("oioi1");
		}
	}
	public void close() throws SQLException {
		connection.close();
	}
	
	public void addmessage(Messages message) throws SQLException {
		String sql = "INSERT INTO Mensagens" +
		"(message,category,usermessage) values(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,message.getMessage());
		stmt.setString(2,message.getCategory());
		stmt.setString(3,message.getUserMessage());
		stmt.execute();
		stmt.close();
	}
	
	public void updatemessage(Messages message) throws SQLException {
		String sql = "UPDATE Mensagens SET " +
		 "message=?, category=?, usermessage=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,message.getMessage());
		stmt.setString(2,message.getCategory());
		stmt.setString(3,message.getUserMessage());
		stmt.setInt(4,message.getId());
		stmt.execute();
		stmt.close();
	}
	
	public void removemessage(Integer id) throws SQLException {
		PreparedStatement stmt = connection
		 .prepareStatement("DELETE FROM Mensagens WHERE id=?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
	}
	
	public List<Messages> getListaMessages() throws SQLException {
		
		List<Messages> messages = new ArrayList<Messages>();
		
		PreparedStatement stmt = connection.
			prepareStatement("SELECT * FROM Mensagens");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Messages message = new Messages();
			message.setId(rs.getInt("id"));
			message.setMessage(rs.getString("message"));
			message.setCategory(rs.getString("category"));
			message.setUserMessage(rs.getString("usermessage"));
			messages.add(message);
		}
		rs.close();
		stmt.close();
		
		return messages;
		
	}
	
	public void adduser (Users user) throws SQLException {
			String sql = "INSERT INTO Usuarios" +
			"(name,login,password) values(?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,user.getName());
			stmt.setString(2,user.getLogin());
			stmt.setString(3,user.getPassword());
			stmt.execute();
			stmt.close();
	}
		
	public void updateuser(Users user) throws SQLException {
			String sql = "UPDATE Usuarios SET " +
			 "name=?,login=?, password=? WHERE id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,user.getName());
			stmt.setString(2,user.getLogin());
			stmt.setString(3,user.getPassword());
			stmt.setInt(4,user.getId());
			stmt.execute();
			stmt.close();
	}
		
	public void removeuser(Integer id) throws SQLException {
			PreparedStatement stmt = connection
			 .prepareStatement("DELETE FROM Usuarios WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
	}	
		
	public List<Users> getListaUsers() throws SQLException {
		
		List<Users> users = new ArrayList<Users>();
		
		PreparedStatement stmt = connection.
			prepareStatement("SELECT * FROM Usuarios");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			Users user = new Users();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setLogin(rs.getString("login"));
			user.setPassword(rs.getString("password"));
			users.add(user);
		}
		rs.close();
		stmt.close();
		
		return users;
	}
	
}	
