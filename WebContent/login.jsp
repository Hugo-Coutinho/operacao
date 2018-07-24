<!DOCTYPE html>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<title>pagina de login</title>
   <title>Login</title>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
   <link rel="stylesheet" href="css/bootstrap.css">
   <style type="text/css">
 .vertical-center {
  min-height: 100%;		
  min-height: 100vh;
  display: -webkit-box;
  display: -moz-box;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
  -webkit-box-align: center;
  -webkit-align-items: center;
  -moz-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  width: 100%;
  -webkit-box-pack: center;
  -moz-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
}
    </style>
</head>
<body style="background-color:#C0C0C0;">
<%
	try {
		session.setAttribute("logado", null);
// 		session.invalidate();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
%>

	<c:choose>
		<c:when test="${alert }">
			<script type="text/javascript">
				swal("Bom Trabalho!!", "cadastrado com sucesso!", "success");
			</script>
		</c:when>
		<c:when test="${alert ==false}">
			<script type="text/javascript">
				swal("Opaaa!!", "você já possui cadastro..", "warning");
			</script>
		</c:when>
	</c:choose>

	<div class="vertical-center">
			<form method="post" action="logar.htm">
				<div class="card">
				<div class="card-header bg-info">
					<h2 style="font-family:Bell MT;" align="center">Login</h2>				
				</div>
					<div class="card-body">
						<label style="font-family:Bell MT; font-size:20px;" >Login:</label><br>
						<input type="text" name="login" required placeholder="digite aqui seu email" title="email aqui" class="form-control">
						
						<br><label style="font-family:Bell MT; font-size:20px;" >Senha:</label><br>
						<input type="password" name="senha" required placeholder="digite aqui sua senha" title="senha aqui" pattern="^[a-zA-Z0-9_.-]*$" class="form-control">
						<br><input type="submit" value="logar" name="btnLogar" class="btn btn-primary btn-block">
						<br><a href="/operacao/senha.jsp" class="btn btn-link">esqueceu a senha</a>
						<br><a href="/operacao/cadastrar.jsp" class="btn btn-link">cadastrar</a>
						
					</div>
					<div class="card-footer">
					${msg }
					</div>

				</div>

			</form>
		</div>





</body>
</html>
