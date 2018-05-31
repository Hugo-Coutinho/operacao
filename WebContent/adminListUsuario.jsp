<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.*, manager.*, java.util.*, persistence.*" %>
<jsp:useBean id="mb" class="manager.ManagerBean"
scope="page"></jsp:useBean>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <style type="text/css">
  #tabs{
  background-color: #C0C0C0;
  }
  </style>
  <script src="<%=request.getContextPath()%>/js/tabs.js"></script>
</head>
<body>
 <%@include file="headerADM.jsp" %>
<div id="tabs">
  <ul>
    <li><a href="#edit">Editar</a></li>
    <li><a href="#del">Excluir</a></li>
  </ul>

<div id="edit" >
  
<div align="center"><h2 align="center"><b>${msg}</b></h2></div>
<form method="post" action="editar.htm">
<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title" align="center"><font style="font-style:italic;">Editar Cadastro</font></div>
				</div>
				<div class="panel-body">
				
			<label for="nome" style="font-family:Bell MT;">Nome : ${logado.nome}</label> 
			<input type="text" id="nome"name="nome" required="required" placeholder="digite seu nome" pattern="[a-z A-Z]+" class="form-control">
			
			<label for="nome" style="font-family:Bell MT;">Email: ${logado.email}</label> 
			<input type="email" id="email"name="email" required="required" placeholder="digite seu email" class="form-control">
			
			<label for="numero"style="font-family:Bell MT;">Senha : ${logado.senha}</label>
			   <input type="password" id="senha" name="senha" required="required" placeholder="digite sua senha" pattern="[0-9]+"class="form-control"><br/>
			    
			<div class="form-group">
      			<label for="#">tipo de acesso:</label>
      			<select class="form-control" id="#" name="permissao">
        		<option>Admnistrador</option>
        		<option>Usuario</option>
			 	 </select>    
			 </div>   
			<br />Sexo :<br /> <input
			type="radio" name="sexo" value="m" /><font style="font-family:Bell MT;"size="4xp">Masculino </font>
			<input type="radio" name="sexo" value="f" /><font style="font-family:Bell MT;"size="4xp;">Feminino</font><br/> 

				</div>
				<div class="panel-footer">
				<button type="reset" class="btn btn-info">Limpar</button>
				<button type="submit" class="btn btn-info">Salvar</button>
				</div>
			
			</div>
		</div>
		</form>
  </div>  
  
  <div id="del" >
  
<div class="container">
  <h2>Lista de Usuarios</h2>
  <form>
  <p><input type="text" name="id" placeholder="digite o número do usuário que deseja excluir." pattern="[0-9]{1,50}" title="digite o id e exclua" class="form-control">
  <br><button class="btn btn-danger" formmethod="post" formaction="deletar.htm">deletar</button> </p>
              
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Logradouro</th>
        <th>Bairro</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${mb.usuarios }" var="linha">
      <tr>
        <td>${linha.idUsuario}</td>
        <td>${linha.nome}</td>
        <td>${linha.endereco.logradouro}</td>
        <td>${linha.endereco.bairro}</td>
      </tr>
	</c:forEach>
    </tbody>
  </table>
  </form>
</div>  
  </div>
 </div>
 
</body>



</html>