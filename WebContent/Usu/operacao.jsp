<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="<%=request.getContextPath()%>/js/accordion.js"></script>
</head>
<body>
	<%@include file="headerUSU.jsp"%>
	<div id="accordion">
		<h3>
			<strong>Palindromo</strong>
		</h3>
		<div>
			<div align="center">
				<h3>
					<strong>palavra palíndromo</strong>
				</h3>
				<form method="post" action="palavraPalindromo.htm">
					<input type="text" name="palavraPalindromo" placeholder="digite sua palavra aqui" class="form-control" style="width: 250px;">
					<button type="submit" class="btn btn-primary">Verificar</button>
					<br>
				</form>
			</div>
		</div>
		<h3>
			<strong>Palindromo Frase</strong>
		</h3>
		<div>
			<div align="center">
				<h3>
					<strong>Frase Palíndromo</strong>
				</h3>
				<form method="post" action="frasePalindromo.htm">
					<input type="text" name="frasePalindromo" placeholder="digite sua frase aqui" class="form-control" style="width: 450px;">
					<!-- <button type="submit">verificar</button> -->
					<button type="submit" class="btn btn-primary">Verificar</button>
					<br>
				</form>
			</div>
		</div>
		<h3>
			<strong>Fatorial</strong>
		</h3>
		<div>
			<div align="center">
				<h3>
					<strong>Fatorial</strong>
				</h3>
				<form method="post" action="fatorial.htm">
					<input type="text" name="fatorial" placeholder="Entre com um numero" class="form-control" style="width: 250px;">
					<button type="submit" class="btn btn-primary">Resultado</button>
				</form>
			</div>
	</div>
	
	<h3>
		<strong>Numero Primo</strong>
	</h3>
		<div>
			<div align="center">
			<h3>
				<strong>Numero Primo</strong>
			</h3>
				<form method="post" action="primo.htm">
					<input type="text" name="primo" placeholder="verificar se é primo" class="form-control" style="width: 250px;">
<!-- 					<button type="submit">Verificar</button> -->
					<button type="submit" class="btn btn-primary">Verificar</button>
				</form>
			</div>
		</div>
		<h3>
			<strong>Fibonacci</strong>		
		</h3>
		<div>
			<div align="center">
				<h3>
					<strong>Fibonacci</strong>
				</h3>
				<form method="post" action="fibonacci.htm">
					<input type="text" name="fibonacci" placeholder="calcula fibonacci" class="form-control" style="width: 250px;">
					<button type="submit" class="btn btn-primary">Resultado</button>
				</form>
			</div>
		</div>
		<h3>
			<strong>Perfeito</strong>
		</h3>
		<div>
			<div align="center">
			<h3>
				<strong>Perfeito</strong>
			</h3>
				<form method="post" action="perfeito.htm">
					<input type="text" name="perfeito" placeholder="achar perfeito" class="form-control" style="width: 250px;">
<!-- 					<button type="submit">Resultado</button> -->
					<button type="submit" class="btn btn-primary">Resultado</button>
				</form>
			</div>
		</div>
	</div>
	

			
	Operação ..
	<h1 align="center">${msg }</h1>

</body>
</html>