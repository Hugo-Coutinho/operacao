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
      <a class="navbar-brand" href="/operacao/Admin/paginaInicial.jsp"><span style="font-size: 21px;">Pagina inicial</span></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/operacao/Admin/adminListUsuario.jsp"><span style="font-size: 21px;">Usu�rio</span></a></li>
      <li><a href="/operacao/Admin/doc.jsp"><span style="font-size: 21px;">Anota��es</span></a></li>
      <li><a href="/operacao/Admin/perfilAdmin.jsp"><span style="font-size: 21px;">Editar Foto</span></a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/operacao/login.jsp"><span class="glyphicon glyphicon-user" style="font-size: 21px;">Sair</span></a></li>
    </ul>
    <div align="center">
    <ul>
    <li><h4 style="color:#FFD700; font-size: 21px;">modo Administador: ${logado.nome}</h4></li>
    </ul>
    </div>
  </div>
  <br>
</div>
<div class="footer">
<br><br>
</div>



</body>
</html>