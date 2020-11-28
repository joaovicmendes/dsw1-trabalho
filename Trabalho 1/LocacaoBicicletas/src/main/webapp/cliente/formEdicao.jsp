<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Gerenciamento de Clientes</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1>Gerenciamento de Clientes</h1>
		<h2>
			<a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/clientes/cadastro">Adicione Novo Cliente</a>
		</h2>
	</div>

	<div>
		<form action="/<%= contextPath%>/clientes/atualizacao" method="post">
			<fieldset>
				<legend>Atualização de Cliente</legend>
				CPF (não é possível alterar)</br>
				<input type="text" name="cpf" value="${cliente.cpf}" readonly/> <br/>
				Nome </br>
				<input type="text" name="nome" value="${cliente.nome}"/> <br/>
				Email </br>
				<input type="email" name="email" value="${cliente.email}"/> <br/>
				Senha </br>
				<input type="password" name="senha"/> <br/>
				Genero </br>
				<input type="text" name="genero" value="${cliente.genero}"/> <br/>
				Telefone </br>
				<input type="text" name="telefone" value="${cliente.telefone}"/> <br/>
				Data Nascimento </br>
				<input type="text" name="dataNascimento" value="${cliente.dataNascimento}"/> <br/>
				<input type="submit" name="enviar" value="Atualizar" />
			</fieldset>
		</form>
	</div>
</body>
</html>