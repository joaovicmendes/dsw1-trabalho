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
			<a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp; <a
				href="/<%=contextPath%>/locadoras/cadastro">Adicione Nova Locadora</a>
		</h2>
	</div>

	<div align="center">
		<table border="1">
			<caption>Lista de Locadoras</caption>
			<tr>
				<th>CNPJ</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Senha</th>
				<th>Cidade</th>
                <th>Ações</th>
			</tr>
			<c:forEach var="locadora" items="${requestScope.listaLocadoras}">
				<tr>
					<td>${locadora.cnpj}</td>
					<td>${locadora.nome}</td>
					<td>${locadora.email}</td>
					<td>${locadora.senha}</td>
					<td>${locadora.cidade}</td>
					<td><a href="/<%= contextPath%>/locadoras/edicao?cnpj=${locadora.cnpj}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/locadoras/remocao?cnpj=${locadora.cnpj}"
						onclick="return confirm('Tem certeza de que deseja excluir este item?');">
							Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>