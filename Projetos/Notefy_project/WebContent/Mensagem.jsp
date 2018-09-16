<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
 <style type="text/css">  <%@include file="WEB-INF/style.css" %> </style>
 <link href="WEB-INF/style.css" rel="stylesheet" type="text/css">
 <head>
 <title>NOTES WORKSPACE</title>
 </head>
 <body>
 <ul>
<%@ page import="java.util.*,br.moura.gui.*" %>
<% DAO dao = new DAO();
 List<Messages> messages = dao.getListaMessages();
 for (Messages message : messages ) { %>
	<li><a href="#1">
		<h2><%=message.getCategory()%></h2>
		<p><%=message.getMessage()%></p>
	</a></li>
<% } %>
</ul>
</body>
</html> 