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
		<h3>Palindromo</h3>
		<div>
			<div align="center">
				<h3>
					<b>palavra palíndromo</b>
				</h3>
				<form method="post" action="palavraPalindromo.htm">
					<input type="text" name="palavraPalindromo"
						placeholder="digite sua palavra aqui">
					<button type="submit">verificar</button>
					<br>
				</form>
			</div>
		</div>
		<h3>Palindromo</h3>
		<div>
			<div align="center">
				<h3>
					<b>frase palíndromo</b>
				</h3>
				<form method="post" action="frasePalindromo.htm">
					<input type="text" name="frasePalindromo"
						placeholder="digite sua frase aqui">
					<button type="submit">verificar</button>
					<br>
				</form>
			</div>
		</div>
		<h3>fatorial</h3>
		<div>
			<div align="center">
				<h3>fatorial</h3>
				<form method="post" action="fatorial.htm">
					<input type="text" name="fatorial">
					<button type="submit">resultado</button>
				</form>
			</div>
	</div>
	
	<h3>número primo</h3>
		<div>
			<div align="center">
				<form method="post" action="primo.htm">
					<input type="text" name="primo" placeholder="verificar se é primo">
					<button type="submit">verificar</button>
				</form>
			</div>
		</div>
		<h3>fibonacci</h3>
		<div>
			<div align="center">
				<form method="post" action="fibonacci.htm">
					<input type="text" name="fibonacci" placeholder="calcula fibonacci">
					<button type="submit">resultado</button>
				</form>
			</div>
		</div>
		<h3>perfeito</h3>
		<div>
			<div align="center">
				<form method="post" action="perfeito.htm">
					<input type="text" name="perfeito" placeholder="achar perfeito">
					<button type="submit">resultado</button>
				</form>
			</div>
		</div>
	</div>
	

			
	Operação ..
	<h1 align="center">${msg }</h1>

</body>
</html>