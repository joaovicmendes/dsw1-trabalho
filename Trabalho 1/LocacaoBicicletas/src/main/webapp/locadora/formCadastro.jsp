<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Gerenciamento de Locadoras</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Gerenciamento de Locadoras</h1>
		<h2>
			<a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp;
			<a href="/<%=contextPath%>/locadoras/cadastro">Adicione Nova Locadora</a> &nbsp;&nbsp;&nbsp;
			<a href="/<%=contextPath%>/locadoras/lista">Mostrar Todas as Locadoras</a>
		</h2>
	</div>

	<div>
		<form action="/<%= contextPath%>/locadoras/insercao" method="post">
			<fieldset>
				<legend>Cadastro de Locadora</legend>
				CNPJ </br>
				<input type="text" name="cnpj"/> <br/>
				Nome </br>
				<input type="text" name="nome"/> <br/>
				Email </br>
				<input type="email" name="email"/> <br/>
				Senha </br>
				<input type="password" name="senha"/> <br/>
				Cidade </br>
				<input type="text" name="cidade"/> <br/>
				<input type="submit" name="enviar" value="Cadastrar" />
			</fieldset>
		</form>
	</div>
</body>
</html>