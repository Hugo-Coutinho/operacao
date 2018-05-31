<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<%@include file="headerADM.jsp" %>
<div align="center">
<h2>Área para anotações <img src="notas.jpg" class="img-rounded" alt="Cinque Terre" width="104" height="80"> </h2><p>

<form method="Post" action="anotar.htm">

<textarea rows="20" cols="80" name="texto"></textarea><br>

<input type="submit" value="gerar em um documento word" class="btn btn-primary"> 
<br>
${msg}
</form>
</div>

</body>
</html>