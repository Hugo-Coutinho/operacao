<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<%@include file="/Admin/headerADM.jsp" %>
<div align="center">
<h2>�rea para anota��es <img src="notas.jpg" class="img-rounded" alt="Cinque Terre" width="104" height="80"> </h2><p>

<form method="Post" action="anotar.htm">

<textarea rows="20" cols="80" name="texto"></textarea><br>
<br><br>
<input type="text" name="path" required="required" placeholder="cole aqui o caminho + nome do arquivo + extens�o, exemplo: D:\Git\meu\listaCompra.docx" style="width: 500px;" class="form-control">
<br>
<input type="submit" value="gerar anota��o.." class="btn btn-primary"> 
<br>
${msg}
</form>
</div>

</body>
</html>
