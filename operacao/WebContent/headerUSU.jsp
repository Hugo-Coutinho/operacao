<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>usu�rio</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<style>
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: black;
}
</style>
</head>
<body style="background-color:#C0C0C0">

<div class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/operacao/paginaInicialUser.jsp">Pagina inicial</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/operacao/operacao.jsp">Opera��es</a></li>
      <li><a href="/operacao/cadastro.jsp">Editar Cadastro</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/operacao/logout.jsp"><span class="glyphicon glyphicon-user"></span>Sair</a></li>
    </ul>
    <div align="center">
    <ul>
    <li><h4 style="color:#FFD700;">modo Usu�rio: ${logado.nome}</h4></li>
    </ul>
    </div>
  </div>
</div>
<div class="footer"><br></div>

</body>
</html>