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
		<form action="/<%= contextPath%>/clientes/insercao" method="post">
			<fieldset>
				<legend>Cadastro de Cliente</legend>
				CPF </br>
				<input type="text" name="cpf"/> <br/>
				Nome </br>
				<input type="text" name="nome"/> <br/>
				Email </br>
				<input type="email" name="email"/> <br/>
				Senha </br>
				<input type="password" name="senha"/> <br/>
				Genero </br>
				<input type="text" name="genero"/> <br/>
				Telefone </br>
				<input type="text" name="telefone" placeholder="X XXXX-XXXX"/> <br/>
				Data Nascimento </br>
				<input type="text" name="dataNascimento" placeholder="YYYY-MM-DD"/> <br/>
				<input type="submit" name="enviar" value="Cadastrar" />
			</fieldset>
		</form>
	</div>
</body>
</html>