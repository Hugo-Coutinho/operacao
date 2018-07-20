<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script type="text/javascript"
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>

<%-- <script src="<%=request.getContextPath()%>/js/ApiCep.js"></script> --%>
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
</head>
<body>
<%@include file="headerUSU.jsp" %>
<form method="post" action="editarUsu.htm">
<div align="center"><h2 align="center"><b>Editar</b></h2><br /> <br />  </div> 
<div class="col-md-6">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title" align="center"><font style="font-style:italic;">Editar Cadastro</font>${msg}</div>
				</div>
				<div class="panel-body">
<!-- 				<form method="post" action="editarUsu.htm"> -->
						
			<label for="nome" style="font-family:Bell MT;">Nome: ${logado.nome}</label> 
			<input type="text" id="nome"name="nome" required="required" placeholder="digite seu nome" class="form-control">
			
			<label for="nome" style="font-family:Bell MT;">Email: ${logado.email}</label> 
			<input type="email" id="email"name="email" required="required" placeholder="digite seu email" class="form-control">
			
			<label for="numero"style="font-family:Bell MT;">Senha: ${logado.senha}</label>
			   <input type="password" id="senha" name="senha" required="required" placeholder="digite sua senha" class="form-control"><br/>
			    
			Sexo :<br /> <input
			type="radio" name="sexo" value="m" /><font style="font-family:Bell MT;"size="4xp">Masculino </font>
			<input type="radio" name="sexo" value="f" /><font style="font-family:Bell MT;"size="4xp;">Feminino</font>
				</div>
				</div>
			</div>
			
			<div class="col-md-6">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title" align="center">Endereco</div>
				</div>
				<div class="panel-body">
			<label for="cep" style="font-family:Bell MT;">cep : ${logado.endereco.cep}</label> 
			<input type="text" id="cep"name="cep" required="required" placeholder="digite seu novo cep" pattern="[0-9]{8}" class="form-control">
			
			<label for="logradouro" style="font-family:Bell MT;">logradouro : ${logado.endereco.logradouro}</label> 
			<input type="text" id="rua"name="logradouro" required="required" placeholder="digite seu novo logradouro" pattern="[a-z A-Z]+" class="form-control">

			<label for="bairro" style="font-family:Bell MT;">bairro : ${logado.endereco.bairro}</label> 
			<input type="text" id="bairro"name="bairro" required="required" placeholder="digite seu novo bairro" pattern="[a-z A-Z]+" class="form-control">
			
			<label for="cidade" style="font-family:Bell MT;">cidade : ${logado.endereco.cidade}</label> 
			<input type="text" id="cidade"name="cidade" required="required" placeholder="digite sua cidade" pattern="[a-z A-Z]+" class="form-control">
			
			<label for="estado" style="font-family:Bell MT;">estado : ${logado.endereco.estado}</label> 
			<input type="text" id="uf"name="estado" required="required" placeholder="digite seu estado" pattern="[a-z A-Z]{2}" class="form-control"> <br /> <br />
				</div>
			</div>
		</div>
		<input type="submit" value="Atualizar" name="btnLogar" class="btn btn-primary btn-block">
		<p>
	<h2 style="color:maroon;" align="center"> <span style="color:maroon; font-family:Bell MT;">${msg} </span></h2>	
	</form>
</body>                  <span style="color:maroon; font-family:Bell MT;">${msg} </span>
</html>