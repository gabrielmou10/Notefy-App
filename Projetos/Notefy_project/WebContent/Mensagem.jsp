<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<script>
	var input = 1;
	function Edit(campo) { 
	document.getElementById("aqui").innerHTML+="input "+input+" - "+campo+" <input type='text' name='"+campo+"' value=''><br>"; 
	document.form.campo.value=""; 
	input++;
}
</script>
 <style type="text/css">  <%@include file="WEB-INF/style2.css" %> </style>
 <link href="WEB-INF/style.css" rel="stylesheet" type="text/css">
 <head>
 <title>NOTES WORKSPACE</title>
 </head>
 <body>
 <form id="addnoteform" action="addnoteform" method="post">
 Mensagem: <input type="text" name="message" /><br />
 Categoria: <input type="text" name="category" /><br />
 <input type="hidden" id="id" name="usermessage" value="gabrielmou">
 <input type="submit" value="NOVA NOTA" form="addnoteform">
 </form>
 <p>Usuário: ${param.namelogin}</p>
 <ul>
<%@ page import="java.util.*,br.moura.gui.*" %>
<% DAO dao = new DAO();
 List<Messages> messages = dao.getListaMessages();
 for (Messages message : messages ) {%>
	<li>
		 <form id="removenoteform" action="removenoteform" method="post">
		<input type="hidden" id="id" name="id" value=<%=message.getId()%> form="removenoteform">
		<input type="submit" value="X" form="removenoteform"/>
		 </form>
		<h2><%=message.getCategory()%></h2>
		<p><%=message.getMessage()%></p>
		<form id="editnoteform" action="editnoteform" method="post">
		<input type="hidden" id="id" name="id" value=<%=message.getId()%> form="editnoteform">
		<input type="hidden" id="usermessage" name="usermessage" value=<%=message.getUserMessage()%> form="editnoteform">
		Mensagem: <input type="text" name="message" /><br />
 		Categoria: <input type="text" name="category" /><br /> 		
		<input type="submit" value="Atualizar" form="editnoteform" OnClick = "Edit()"/>
		</form>
	</li>
<% } %>
</ul>
</body>
</html> 