<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <%@ page import="java.util.*,br.moura.gui.*" %>
</head>
<body>
 <h1>SIGN UP</h1>
 <hr />
 <form action="AddUser">
 Nome Completo: <input type="text" name="name" /><br />
 Login (Nome de usuário): <input type="text" name="login" /><br />
 Senha (até 20 dígitos): <input type="text" name="password" /><br />
 <input type="submit" value="Gravar" />
 </form>
</body>
</html>