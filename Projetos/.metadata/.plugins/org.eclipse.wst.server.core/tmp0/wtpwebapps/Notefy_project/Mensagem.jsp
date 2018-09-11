<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
 <head>
 <title>Exemplo de JSP</title>
 </head>
 <body>
<%@ page import="java.util.*,br.moura.gui.*" %>
<table border='1'>
<% DAO dao = new DAO();
 List<Messages> messages = dao.getListaMessages();
 for (Messages message : messages ) { %>
 <tr>
 <td><%=message.getMessage()%></td>
 <td><%=message.getCategory()%></td>
 <td><%=message.getUserMessage()%></td>
 </tr>
<% } %>
</table>
</body>
</html> 