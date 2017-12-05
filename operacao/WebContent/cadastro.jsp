<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<%@include file="headerUSU.jsp" %>
<div align="center"><h2 align="center"><b>Editar</b></h2></div>
<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title" align="center"><font style="font-style:italic;">Editar Cadastro</font>${msg}</div>
				</div>
				<div class="panel-body">
				<form method="post" action="editar.htm">
						
			<label for="nome" style="font-family:Bell MT;">Nome: ${logado.nome}</label> 
			<input type="text" id="nome"name="nome" required="required" placeholder="digite seu nome" class="form-control">
			
			<label for="nome" style="font-family:Bell MT;">Email: ${logado.email}</label> 
			<input type="email" id="email"name="email" required="required" placeholder="digite seu email" class="form-control">
			
			<label for="numero"style="font-family:Bell MT;">Senha: ${logado.senha}</label>
			   <input type="password" id="senha" name="senha" required="required" placeholder="digite sua senha" class="form-control"><br/>
			    
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
			
				<br><button type="reset" class="btn btn-info">Limpar</button>
				<button type="submit" class="btn btn-info">Salvar</button>
			</form>  
				</div>
				<div class="panel-footer">
				<br>
				</div>
			
			</div>
		</div>



</body>
</html>