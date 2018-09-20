<!DOCTYPE html>
<html lang="en">
<head>
	<title>	Notefy App</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="WEB-INF/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<style type="text/css">  <%@include file="WEB-INF/css/main.css"%> </style>
  	<style type="text/css">  <%@include file="WEB-INF/css/util.css" %> </style>
	<link rel="stylesheet" type="text/css" href="WEB-INF/css/util.css"> 
	<link rel="stylesheet" type="text/css" href="WEB-INF/css/main.css"> 
<script>
function Workspace()
{
location.href=" Mensagem.jsp"
}
</script>
</head>
<body>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form action="adduserform" method ="post">
					<span class="login100-form-title">
						Cadastro
					</span>

					<div class="wrap-input100 validate-input m-b-16" data-validate = "Please enter password">
						<input class="input100" type="name" name="namelogin" placeholder="Nome Completo">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16" data-validate="Please enter username">
						<input class="input100" type="text" name="login" placeholder="Login">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Please enter password">
						<input class="input100" type="password" name="password" placeholder="Senha">
						<span class="focus-input100"></span>
					</div>
					

					<div class="text-right p-t-13 p-b-23">
						<span class="txt1">
						</span>

						<a href="#" class="txt2">
						</a>
					</div>

					<div class="container-login100-form-btn">
						 <input type="submit" value="Sign Up" onClick="Workspace()"/>
					</div>

					<div class="flex-col-c p-t-170 p-b-40">
						<span class="txt1 p-b-9">
					
						</span>

					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>