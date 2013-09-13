<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="model.util.Mensagem"%>   
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>getIdentificadorCNPq</title>
</head>

<body>

<form name="getIdentificadorCNPq" method="post" action="/SIACSConnectToWebServiceLattes/SIACSServlet">
	CPF:<br>
	<input type="text" name="frm_cpf"><br>
	Nome Completo:<br>
	<input type="text" name="frm_nome_completo"><br>
	Data de Nascimento:<br>
	<input type="text" name="frm_dt_nascimento"><br>
	
	<input type="submit" name="Submit" value="Enviar" />
	<input type="hidden" name="cmd" value="GetIdentificadorCNPq" />
    <input type="hidden" name="page" value="operacoes/getidentificadorcnpq.jsp" />	
    
</form>
<br/>
<% 	Integer retornoInteger = (Integer)request.getAttribute("retorno"); 
		if(retornoInteger != null){
			int retorno = retornoInteger.intValue();
			if(retorno != Mensagem.SEM_ERRO)
				out.println(Mensagem.getMensagem(retorno));
		}
		String retornoString = (String) request.getAttribute("retornoString");
		if (retornoString != null)	
			out.println("Resultado: " + String.valueOf(retornoString));

%>


</body>
</html>