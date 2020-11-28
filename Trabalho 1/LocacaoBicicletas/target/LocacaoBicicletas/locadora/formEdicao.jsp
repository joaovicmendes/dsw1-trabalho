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
		<form action="/<%= contextPath%>/locadoras/atualizacao" method="get">
			<fieldset>
				<legend>Edição de Locadora</legend>
				CNPJ (não é possível alterar)</br>
				<input type="text" name="cnpj" value="${locadora.cnpj}" readonly/> <br/>
				Nome </br>
				<input type="text" name="nome" value="${locadora.nome}"/> <br/>
				Email </br>
				<input type="email" name="email" value="${locadora.email}"/> <br/>
				Senha </br>
				<input type="password" name="senha"/> <br/>
				Cidade </br>
				<input type="text" name="cidade" value="${locadora.cidade}"/> <br/>
				<input type="submit" name="enviar" value="Atualizar" />
			</fieldset>
		</form>
	</div>
</body>
</html>