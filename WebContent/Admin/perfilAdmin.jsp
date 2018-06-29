<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Foto</title>
</head>
<body>
<%@include file="/Admin/headerADM.jsp" %>
<div align="center" style="padding-top: 100px">
<img src="${logado.perfil.foto}" alt="perfil" class="img-thumbnail" alt="perfil" width="390px" height="450px">
<input type="file" name="file" class="form-control-file" aria-describedby="fileHelp" id="fileId">
<br>
<button type="button" class="btn btn-primary btn-lg">Atualizar</button>
</div>



</body>
</html>