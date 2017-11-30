<%
try{
session.setAttribute("logado", null); 
session.invalidate(); 


out.print("<br/><br/><a href=/projeto01Web/login.jsp>Voltar</a>");
}catch(Exception ex){
	ex.printStackTrace();
	}
%>