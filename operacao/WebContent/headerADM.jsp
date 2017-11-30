<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ADM</title>
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
      <a class="navbar-brand" href="/projeto01Web/paginaInicial.jsp">Pagina inicial</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="adminListUsuario.jsp">Usuário</a></li>
      <li><a href="/projeto01Web/doc.jsp">Anotações</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/projeto01Web/logout.jsp"><span class="glyphicon glyphicon-user"></span>Sair</a></li>
    </ul>
    <div align="center">
    <ul>
    <li><h4 style="color:#FFD700;">modo Administador: ${logado.nome}</h4></li>
    </ul>
    </div>
  </div>
</div>
<div class="footer">
<br>
</div>



</body>
</html>