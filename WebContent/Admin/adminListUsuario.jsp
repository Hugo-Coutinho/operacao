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
<%--   <script src="<%=request.getContextPath()%>/js/ApiCep.js"></script> --%>
</head>
<body>
<%--  <%@include file="/Admin/headerADM.jsp" %> --%>
<script type="text/javascript" >
        $(document).ready(function() {
            function limpa_formulário_cep() {
                $("#rua").val("");
                $("#bairro").val("");
                $("#cidade").val("");
                $("#uf").val("");
                $("#ibge").val("");
            }
            
            $("#cep").blur(function() {
                var cep = $(this).val().replace(/\D/g, '');
                if (cep != "") {
                    var validacep = /^[0-9]{8}$/;
                    if(validacep.test(cep)) {
                        $("#rua").val("...");
                        $("#bairro").val("...");
                        $("#cidade").val("...");
                        $("#uf").val("...");
                        $("#ibge").val("...");
                        $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {
                            if (!("erro" in dados)) {
                                $("#rua").val(dados.logradouro);
                                $("#bairro").val(dados.bairro);
                                $("#cidade").val(dados.localidade);
                                $("#uf").val(dados.uf);
                                $("#ibge").val(dados.ibge);
                            } //end if.
                            else {
                                limpa_formulário_cep();
                                alert("CEP não encontrado.");
                            }
                        });
                    } //end if.
                    else {
                        //cep é inválido.
                        limpa_formulário_cep();
                        alert("Formato de CEP inválido.");
                    }
                } //end if.
                else {
                    //cep sem valor, limpa formulário.
                    limpa_formulário_cep();
                }
            });
        });
    </script>
<div id="tabs">
  <ul>
    <li><a href="#edit">Editar</a></li>
    <li><a href="#del">Excluir</a></li>
  </ul>
<div id="edit" >

<!-- <div align="center"><h2 align="center"><b>Editar</b></h2><br /> <br />  </div>  -->
  
<form method="post" action="editar.htm">
<div class="col-md-6">
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
        		<option>Administrador</option>
        		<option>Usuario</option>
			 	 </select>    
			 </div>   
			<br />Sexo :<br /> <input
			type="radio" name="sexo" value="m" /><font style="font-family:Bell MT;"size="4xp">Masculino </font>
			<input type="radio" name="sexo" value="f" /><font style="font-family:Bell MT;"size="4xp;">Feminino</font><br/> 

				</div>
<!-- 				<div class="panel-footer"> -->
<!-- 				<button type="reset" class="btn btn-info">Limpar</button> -->
<!-- 				<button type="submit" class="btn btn-info">Salvar</button> -->
<!-- 				</div> -->
			</div>
		</div>
		
		
		
		<div class="col-md-6">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title" align="center">Editar Endereco</div>
				</div>
				<div class="panel-body">
			<label for="cep" style="font-family:Bell MT;">cep :</label> 
			<input type="text" id="cep"name="cep" required="required" placeholder="digite seu novo cep" pattern="[0-9]{8}" class="form-control">
			
			<label for="logradouro" style="font-family:Bell MT;">logradouro :</label> 
			<input type="text" id="rua"name="logradouro" required="required" placeholder="digite seu novo logradouro" pattern="[a-z A-Z]+" class="form-control">

			<label for="bairro" style="font-family:Bell MT;">bairro :</label> 
			<input type="text" id="bairro"name="bairro" required="required" placeholder="digite seu novo bairro" pattern="[a-z A-Z]+" class="form-control">
			
			<label for="cidade" style="font-family:Bell MT;">cidade :</label> 
			<input type="text" id="cidade"name="cidade" required="required" placeholder="digite sua cidade" pattern="[a-z A-Z]+" class="form-control">
			
			<label for="estado" style="font-family:Bell MT;">estado :</label>
			<input type="text" id="uf"name="estado" required="required" placeholder="digite seu estado" pattern="[a-z A-Z]{2}" class="form-control"> <br /> <br />
<!-- 						<button type="reset" class="btn btn-info">Limpar</button> -->
<!-- 						<button type="submit" class="btn btn-info">Salvar</button> -->
				</div>
<!-- 				<div class="panel-footer"> -->
<!-- 				</div> -->
			</div>
		</div>
		
  <input type="submit" value="Atualizar" name="btnLogar" class="btn btn-primary btn-block">
  	<h2 style="color:maroon;" align="center">${msg}</h2>
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