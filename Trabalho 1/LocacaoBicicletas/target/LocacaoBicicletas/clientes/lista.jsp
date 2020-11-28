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

	<div align="center">
		<table border="1">
			<caption>Lista de Clientes</caption>
			<tr>
				<th>CPF</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Senha</th>
				<th>Genero</th>
				<th>Telefone</th>
                <th>Data de nascimento</th>
                <th>Ações</th>
			</tr>
			<c:forEach var="cliente" items="${requestScope.listaClientes}">
				<tr>
					<td>${cliente.cpf}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.email}</td>
					<td>${cliente.senha}</td>
					<td>${cliente.genero}</td>
                    <td>${cliente.telefone}</td>
                    <td>${cliente.dataNascimento}</td>
					<td><a href="/<%= contextPath%>/clientes/edicao?id=${cliente.cpf}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/clientes/remocao?id=${cliente.cpf}"
						onclick="return confirm('Tem certeza de que deseja excluir este item?');">
							Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>