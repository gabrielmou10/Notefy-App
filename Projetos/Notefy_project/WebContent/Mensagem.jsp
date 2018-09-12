<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
 <style type="text/css">  <%@include file="WEB-INF/style.css" %> </style>
 <link href="WEB-INF/style.css" rel="stylesheet" type="text/css">
 <head>
 <title>Exemplo de JSP</title>
 </head>
 <body>
<%@ page import="java.util.*,br.moura.gui.*" %>
 <ul>
  <li><a href="#1">
   <h2>Title #1</h2>
   <p>Text Content #1</p>
	</a></li>
 </ul>
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