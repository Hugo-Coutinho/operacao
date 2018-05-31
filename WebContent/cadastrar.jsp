<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>cadastrar</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#C0C0C0">
<form method="Post" action="cadastrar.htm">
<div align="center"><h2 align="center"><b>Cadastrar</b><img 
src="cadastrar.png" class="img-circle" alt="Cinque Terre" width="100" height="90" align="middle"></h2></div>
<div class="col-md-6">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title" align="center"><font style="font-style:italic;">Cadastro</font></div>
				</div>
				<div class="panel-body">

						<label for="nome" style="font-family:Bell MT;">Nome :</label> 
			<input type="text" id="nome"name="nome" required="required" placeholder="digite seu nome" pattern="[a-z A-Z]+" class="form-control">
			
			<label for="nome" style="font-family:Bell MT;">Email :</label> 
			<input type="email" id="email"name="email" required="required" placeholder="digite seu email" class="form-control">
			
			<label for="numero"style="font-family:Bell MT;">Senha :</label>
			   <input type="password" id="senha" name="senha" required="required" pattern="[0-9]+" placeholder="digite sua senha" class="form-control"><br/>
			    
			<div class="form-group">
      			<label for="#">tipo de acesso:</label>
      			<select class="form-control" id="#" name="permissao">
        		<option>Admnistrador</option>
        		<option>Usuario</option>
			 	 </select>    
			 </div>   
			<br />Sexo :<br /> <input
			type="radio" name="sexo" value="m" /><font style="font-family:Bell MT;"size="4xp">Masculino </font>
			<input type="radio" name="sexo" value="f" /><font style="font-family:Bell MT;"size="4xp;">Feminino</font><br/><br>
			
				</div>
				<div class="panel-footer"></div>
			
			</div>
		<a href="login.jsp" class="btn btn-link">voltar para página de login</a>	
		</div>
		
		<div class="col-md-6">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title" align="center">Endereco</div>
				</div>
				<div class="panel-body">
			<label for="cep" style="font-family:Bell MT;">cep :</label> 
			<input type="text" id="bairro"name="cep" required="required" placeholder="digite seu cep" pattern="[0-9]{8}" class="form-control">
			<br><br>
			<label for="logradouro" style="font-family:Bell MT;">logradouro :</label> 
			<input type="text" id="logradouro"name="logradouro" required="required" placeholder="digite seu logradouro" pattern="[a-z A-Z]+" class="form-control">

			<label for="bairro" style="font-family:Bell MT;">bairro :</label> 
			<input type="text" id="bairro"name="bairro" required="required" placeholder="digite seu bairro" pattern="[a-z A-Z]+" class="form-control">
			
			<label for="cidade" style="font-family:Bell MT;">cidade :</label> 
			<input type="text" id="cidade"name="cidade" required="required" placeholder="digite seu cidade" pattern="[a-z A-Z]+" class="form-control">
			
			<label for="estado" style="font-family:Bell MT;">estado :</label> 
			<input type="text" id="estado"name="estado" required="required" placeholder="digite seu estado" pattern="[a-z A-Z]{2}" class="form-control">
			
						<button type="reset" class="btn btn-info">Limpar</button>
						<button type="submit" class="btn btn-info">Salvar</button>
				
				</div>
				<div class="panel-footer">
				${msg}
				</div>
			</div>
		</div>
</form>
</body>
</html>