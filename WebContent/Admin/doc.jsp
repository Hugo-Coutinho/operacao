<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.*, manager.*, java.util.*, persistence.*" %>
<jsp:useBean id="mb" class="manager.ManagerBean" scope="page"></jsp:useBean>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style type="text/css">
    body {
        color: #566787;
		background: #f5f5f5;
		font-family: 'Varela Round', sans-serif;
		font-size: 13px;
	}
	.table-wrapper {
        background: #fff;
        padding: 20px 25px;
        margin: 30px 0;
		border-radius: 3px;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
	.table-title {        
		padding-bottom: 15px;
		background: #435d7d;
		background-color: black;
		padding: 16px 30px;
		margin: -20px -25px 10px;
		border-radius: 3px 3px 0 0;
    }
    .table-title h2 {
		margin: 5px 0 0;
		font-size: 24px;
	}
	.table-title .btn-group {
		float: right;
	}
	.table-title .btn {
		color: #fff;
		float: right;
		font-size: 13px;
		border: none;
		min-width: 50px;
		border-radius: 2px;
		border: none;
		outline: none !important;
		margin-left: 10px;
	}
	.table-title .btn i {
		float: left;
		font-size: 21px;
		margin-right: 5px;
	}
	.table-title .btn span {
		float: left;
		margin-top: 2px;
	}
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
		padding: 12px 15px;
		vertical-align: middle;
    }
	table.table tr th:first-child {
		width: 60px;
	}
	table.table tr th:last-child {
		width: 100px;
	}
    table.table-striped tbody tr:nth-of-type(odd) {
    	background-color: #fcfcfc;
	}
	table.table-striped.table-hover tbody tr:hover {
		background: #f5f5f5;
	}
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }	
    table.table td:last-child i {
		opacity: 0.9;
		font-size: 22px;
        margin: 0 5px;
    }
	table.table td a {
		font-weight: bold;
		color: #566787;
		display: inline-block;
		text-decoration: none;
		outline: none !important;
	}
	table.table td a:hover {
		color: #2196F3;
	}
	table.table td a.edit {
        color: #FFC107;
    }
    table.table td a.delete {
        color: #F44336;
    }
    table.table td i {
        font-size: 19px;
    }
	table.table .avatar {
		border-radius: 50%;
		vertical-align: middle;
		margin-right: 10px;
	}
    .pagination {
        float: right;
        margin: 0 0 5px;
    }
    .pagination li a {
        border: none;
        font-size: 13px;
        min-width: 30px;
        min-height: 30px;
        color: #999;
        margin: 0 2px;
        line-height: 30px;
        border-radius: 2px !important;
        text-align: center;
        padding: 0 6px;
    }
    .pagination li a:hover {
        color: #666;
    }	
    .pagination li.active a, .pagination li.active a.page-link {
        background: #03A9F4;
    }
    .pagination li.active a:hover {        
        background: #0397d6;
    }
	.pagination li.disabled i {
        color: #ccc;
    }
    .pagination li i {
        font-size: 16px;
        padding-top: 6px
    }
    .hint-text {
        float: left;
        margin-top: 10px;
        font-size: 13px;
    }    
	/* Custom checkbox */
	.custom-checkbox {
		position: relative;
	}
	.custom-checkbox input[type="checkbox"] {    
		opacity: 0;
		position: absolute;
		margin: 5px 0 0 3px;
		z-index: 9;
	}
	.custom-checkbox label:before{
		width: 18px;
		height: 18px;
	}
	.custom-checkbox label:before {
		content: '';
		margin-right: 10px;
		display: inline-block;
		vertical-align: text-top;
		background: white;
		border: 1px solid #bbb;
		border-radius: 2px;
		box-sizing: border-box;
		z-index: 2;
	}
	.custom-checkbox input[type="checkbox"]:checked + label:after {
		content: '';
		position: absolute;
		left: 6px;
		top: 3px;
		width: 6px;
		height: 11px;
		border: solid #000;
		border-width: 0 3px 3px 0;
		transform: inherit;
		z-index: 3;
		transform: rotateZ(45deg);
	}
	.custom-checkbox input[type="checkbox"]:checked + label:before {
		border-color: #03A9F4;
		background: #03A9F4;
	}
	.custom-checkbox input[type="checkbox"]:checked + label:after {
		border-color: #fff;
	}
	.custom-checkbox input[type="checkbox"]:disabled + label:before {
		color: #b8b8b8;
		cursor: auto;
		box-shadow: none;
		background: #ddd;
	}
	/* Modal styles */
	.modal .modal-dialog {
		max-width: 400px;
	}
	.modal .modal-header, .modal .modal-body, .modal .modal-footer {
		padding: 20px 30px;
	}
	.modal .modal-content {
		border-radius: 3px;
	}
	.modal .modal-footer {
		background: #ecf0f1;
		border-radius: 0 0 3px 3px;
	}
    .modal .modal-title {
        display: inline-block;
    }
	.modal .form-control {
		border-radius: 2px;
		box-shadow: none;
		border-color: #dddddd;
	}
	.modal textarea.form-control {
		resize: vertical;
	}
	.modal .btn {
		border-radius: 2px;
		min-width: 100px;
	}	
	.modal form label {
		font-weight: normal;
	}	
</style>

<script type="text/javascript">
function deletarAnotacao(id) {
	document.getElementById("idAnotacaoDelete").value = id;
	$("#deletarAnotacao").modal('show');
}
</script>

<script type="text/javascript">
function deletarTodasAnotacoes() {

	var CheckedId = document.getElementsByClassName('checks');
	var ids= [];
	
	for(i=0; i<CheckedId.length; i++ ){
	
		if(CheckedId[i].checked == true){
			ids.push(CheckedId[i].value);
		}
	}
// 	alert(ids[0]);	
$.ajax({
url:"apagarAnotacoesChecked.htm",
type:"get",
dataType: 'json',
data:{ids:ids},
success: function(){
	location='doc.jsp';
},
error:function(xhr){
	location='doc.jsp';
}
});

 	
}
</script>

<script type="text/javascript">
function editarAnotacao(id) {
$.ajax({
url:"editarAnotacao.htm",
type:"get",
data: {"id":id},
success: function(resposta){
 document.getElementById("idAnotacaoEditar").value=id;
 document.getElementById("nomeAnotacao").value=resposta.nome;
 document.getElementById("editarInput").value=resposta.texto;
$("#editarAnotacao").modal('show');
},
error:function(xhr){
	alert('deu ruim');
}
});

}
</script>

<script type="text/javascript">
function verAnotacao(id) {
$.ajax({
url:"verAnotacao.htm",
type:"get",
data: {"id":id},
success: function(resposta){
 document.getElementById("verInput").value=resposta;
	$("#ver").modal('show');
},
error:function(xhr){
	alert('deu ruim');
}
});

}
</script>
</head>
<body>
<%@include file="/Admin/headerADM.jsp" %>
<div align="center">
<h2>Área para anotações <img src="notas.jpg" class="img-rounded" alt="Cinque Terre" width="104" height="80"> </h2></div>

<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
					</div>
					<div class="col-sm-6">
						<a href="#addAnotacao" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Novo</span></a>
						<a onclick="deletarTodasAnotacoes()" class="btn btn-danger" ><i data-toggle="modal" class="material-icons">&#xE15C;</i> <span>Remover</span></a>						
					</div>
                </div>
            </div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th></th>
						<th class="col-md-3">Nome da anotação</th>
						<th class="col-md-3">Data Criacão</th>
						<th class="col-md-3">acão</th>
					</tr>
				</thead>
				<c:forEach items="${mb.notas }" var="nota">
					<tbody>
						<tr>
							<td><span class="custom-checkbox"> <input class="checks"
									type="checkbox" id="codigoCheck" name="codigoCheck" value="${nota.idAnotacao }">
									<label for="checkbox1"></label>
							</span></td>
							<td>${nota.nome}</td>
							<td>${nota.data}</td>
							<td>
							<i class="material-icons" data-toggle="tooltip" title="Editar" onclick="editarAnotacao(${nota.idAnotacao})" style="cursor:pointer">&#xE254;</i>
							<i data-toggle="tooltip" title="visualizar"class="material-icons" onclick="verAnotacao(${nota.idAnotacao})" style="cursor:pointer">play_circle_filled</i>
                            <i class="material-icons" data-toggle="tooltip" title="Deletar" onclick="deletarAnotacao(${nota.idAnotacao})" style="cursor:pointer">&#xE872;</i>
                            </td>
						</tr>
				</c:forEach>

				</tbody>
			</table>
			${errorAddAnotacao }
			<div class="clearfix">
                <div class="hint-text">mostrando <b>2</b> de <b>6</b> anotacões</div>
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Anterior</a></li>
                    <li class="page-item"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item active"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                    <li class="page-item"><a href="#" class="page-link">Próximo</a></li>
                </ul>
            </div>
        </div>
    </div>
	<!-- Add Modal HTML -->
	<div id="addAnotacao" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Nova Anotacão</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>Nome da anotacão</label>
							<input type="text" name="nome" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Digite aqui sua anotacão</label>
							<textarea  class="form-control" name="anotacao" required></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
						<input type="submit" class="btn btn-success" value="Adicionar" formaction="addAnotacao.htm" formmethod="Post">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editarAnotacao" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Editar</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>Nome</label>
							<input type="text" class="form-control" required name="nomeAnotacao" id="nomeAnotacao">
							<input type="hidden" class="form-control" required name="idAnotacaoEditar" id="idAnotacaoEditar">
						</div>
						<div class="form-group">
							<label>Edite aqui sua anotacão</label>
							<textarea  class="form-control" required name="textoEditado" id="editarInput"></textarea>
						</div>					
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
						<input type="submit" class="btn btn-info" value="Salvar" formaction="salvarAnotacaoEditada.htm" formmethod="Post">
					</div>
				</form>
			</div>
		</div>
	</div>
<!-- ver -->
	<div id="ver" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" align="center">visualizando anotação</h4>
				</div>
				<div class="modal-body">
					<textarea  class="form-control" name="anotacao" required name="verInput" id="verInput" readonly="readonly"></textarea>
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="sair">
				</div>
			</div>
		</div>
	</div>
	<!-- Delete Modal HTML -->
	<div id="deletarAnotacao" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Deletar Anotacão</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<p>Tem certeza que deseja remover essa anotacão?</p>
						<p class="text-warning"><small>Essa acão não poderá ser desfeita.</small></p>
					</div>
					<div class="modal-footer">
						<input type="hidden" id="idAnotacaoDelete" name="idAnotacaoDelete">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
						<input type="submit" class="btn btn-danger" value="Deletar" formaction="removerAnotacao.htm" formmethod="Post">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>