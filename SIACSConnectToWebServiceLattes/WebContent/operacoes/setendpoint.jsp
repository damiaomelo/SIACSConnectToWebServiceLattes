<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="model.util.Mensagem"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>setEndpoint</title>
</head>

<body>

<form name="setEndpoint" method="post" action="/SIACSConnectToWebServiceLattes/SIACSServlet">
	EndPoint:<br>
	<input type="text" name="form_endpoint"><br>

	<input type="submit" name="Submit" value="Enviar" />
    <input type="hidden" name="cmd" value="SetEndPoint" />
    <input type="hidden" name="page" value="index.jsp" />	
</form>
<br/>
<% Integer retornoInteger = (Integer)request.getAttribute("retorno"); 
	if(retornoInteger != null){
		int retorno = retornoInteger.intValue();
		if(retorno != Mensagem.SEM_ERRO)
			out.println(Mensagem.getMensagem(retorno));
	}
%>

</body>
</html>