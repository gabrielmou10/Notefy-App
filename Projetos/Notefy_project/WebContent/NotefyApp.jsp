<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
function Signup()
{
location.href=" SignUp.jsp"
}
function Login()
{
location.href=" LogIn.jsp"
}
</script>
<meta charset="ISO-8859-1">
<title>Notefy App</title>
</head>
<body>
 <h1>NOTEFY APP</h1>
 <hr />
 <input type="submit" value="Já tenho cadastro" onClick="Login()" />
 <input type="submit" value="Novo Usúario" onClick="Signup()">
</html>
