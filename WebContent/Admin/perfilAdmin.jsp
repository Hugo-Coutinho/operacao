<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Foto</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
<%@include file="/Admin/headerADM.jsp" %>

<form enctype="multipart/form-data" id="form1" runat="server">

<div align="center" style="padding-top: 100px">
<img src="${logado.foto}" class="img-thumbnail" id="imagem" alt="perfil" width="390px" height="450px">
<input type="file" name="file" class="form-control-file" aria-describedby="fileHelp" id="fileId" required="required">
<br>
<button class="btn btn-primary btn-lg" formaction="atualizarFoto.htm" formmethod="Post">Atualizar</button>
</div>
  	<br><h2 style="color:maroon;" align="center"> <strong style="color:maroon; font-family:Bell MT;">${msg} </strong></h2>
</form>


</body>

<script type="text/javascript" >
function readURL(input) {

  if (input.files && input.files[0]) {
    var reader = new FileReader();

    reader.onload = function(e) {
      $('#imagem').attr('src', e.target.result);
    }

    reader.readAsDataURL(input.files[0]);
  }
}

$("#fileId").change(function() {
  readURL(this);
});
</script>

</html>