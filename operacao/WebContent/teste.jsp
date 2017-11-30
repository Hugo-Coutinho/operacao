<!DOCTYPE html>
<html>
<head>
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
    <li><a href="#doc">Relatório</a></li>
  </ul>

<div id="edit" >
  


<div align="center"><h2 align="center"><b>Editar</b></h2></div>
<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title" align="center"><font style="font-style:italic;">Editar Cadastro</font></div>
				</div>
				<div class="panel-body">
				<form method="post" action="Controle?cmd=cadastrarAdmin">
						<label for="nome" style="font-family:Bell MT;">Nome :</label> 
			<input type="text" id="nome"name="nome" required="required" placeholder="digite seu nome" class="form-control">
			
			<label for="nome" style="font-family:Bell MT;">Email :</label> 
			<input type="email" id="email"name="email" required="required" placeholder="digite seu email" class="form-control">
			
			<label for="numero"style="font-family:Bell MT;">Senha :</label>
			   <input type="password" id="senha" name="senha" required="required" placeholder="digite sua senha" class="form-control"><br/>
			    
			<div class="form-group">
      			<label for="#">tipo de acesso:</label>
      			<select class="form-control" id="#">
        		<option>Admnistrador</option>
        		<option>Usuário</option>
			 	 </select>    
			 </div>   
			<br />Sexo :<br /> <input
			type="radio" name="sexo" value="m" /><font style="font-family:Bell MT;"size="4xp">Masculino </font>
			<input type="radio" name="sexo" value="f" /><font style="font-family:Bell MT;"size="4xp;">Feminino</font><br/> 

<label for="cep" style="font-family:Bell MT;">cep :</label> 
			<input type="text" id="bairro"name="cep" required="required" placeholder="digite seu cep" class="form-control">
			<br><br>
			<label for="logradouro" style="font-family:Bell MT;">logradouro :</label> 
			<input type="text" id="logradouro"name="logradouro" required="required" placeholder="digite seu logradouro" class="form-control">

			<label for="bairro" style="font-family:Bell MT;">bairro :</label> 
			<input type="text" id="bairro"name="bairro" required="required" placeholder="digite seu bairro" class="form-control">
			
			<label for="cidade" style="font-family:Bell MT;">cidade :</label> 
			<input type="text" id="cidade"name="cidade" required="required" placeholder="digite seu cidade" class="form-control">
			
			<label for="estado" style="font-family:Bell MT;">estado :</label> 
			<input type="text" id="estado"name="estado" required="required" placeholder="digite seu estado" class="form-control">

				<br><button type="reset" class="btn btn-info">Limpar</button>
				<button type="submit" class="btn btn-info">Salvar</button>
			</form>  
				</div>
				<div class="panel-footer">
				<br>
				${msg}
				</div>
			
			</div>
		</div>
  </div>  
  
  <div id="del" >
  
<div class="container">
  <h2>Bordered Table</h2>
  <p><input type="text" name="id" placeholder="digite o número do usuário que deseja excluir." title="digite o id e exclua" class="form-control">
  <br><button class="btn btn-danger">deletar</button> </p>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
    </tbody>
  </table>
</div>  
  </div>
  <div id="doc">
  <h3>doc</h3>
  </div>
 </div>
 
 
 
</body>



</html>