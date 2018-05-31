<!DOCTYPE html>
<html>
<head>
   <title>senha:</title>
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
<div class="vertical-center">
			<form method="Post" action="senha.htm">
				<div class="card">
				<div class="card-header bg-info">
					<h2 style="font-family:Bell MT;" align="center">nova senha</h2>				
				</div>
					<div class="card-body">
						<label style="font-family:Bell MT; font-size:20px;" >digite seu email:</label><br>
						<input type="text" name="senha" required placeholder="digite aqui seu email" title="receber email com a nova senha" class="form-control">
						<br><input type="submit" value="gerar nova senha" name="btnLogar" class="btn btn-primary btn-block">
						<br><a href="login.jsp" class="btn btn-link">voltar a página de login</a>
					</div>
					<div class="card-footer">
						${msg }
					</div>

				</div>


			</form>
		</div>


</body>
</html>
