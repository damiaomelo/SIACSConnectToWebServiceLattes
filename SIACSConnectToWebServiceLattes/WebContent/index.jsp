<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.util.Mensagem"%>    

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Index</title>
</head>

<body>

<form name="operacao" method="post" action="/SIACSConnectToWebServiceLattes/SIACSServlet" >
	<select size="1" name="comboBoxOperacao">
		<option selected value="Selecione">Selecione a função desejada:</option>
		<option value="getDataAtualizacaoCVPorUsuario">getDataAtualizacaoCVPorUsuario</option>
		<option value="getDataAtualizacaoCV">getDataAtualizacaoCV</option>
		<option value="getCurriculoCompactadoPorUsuario">getCurriculoCompactadoPorUsuario</option>
		<option value="getCurriculoCompactado">getCurriculoCompactado</option>
		<option value="getIdentificadorCNPqPorUsuario">getIdentificadorCNPqPorUsuario</option>
		<option value="getIdentificadorCNPq">getIdentificadorCNPq</option>
		<option value="getOcorrenciaCVPorUsuario">getOcorrenciaCVPorUsuario</option>
		<option value="getOcorrenciaCV">getOcorrenciaCV</option>
		<option value="setEndpoint">setEndPoint</option>
	</select>
	
	<input type="submit" name="Submit" value="Enviar" />
	<input type="hidden" name="cmd" value="VerificarFuncao" />
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
