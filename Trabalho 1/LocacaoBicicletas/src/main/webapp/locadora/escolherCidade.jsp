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

	<div align="center">
		<form action="/<%= contextPath%>/locadoras/listaCidade" method="get">
			<select name="cidade">
				<c:forEach var="cidade" items="${requestScope.listaCidades}">	
					<option value ="${cidade}">${cidade}</option>
				</c:forEach>
			</select>
			<p><input type="submit" value="Escolher"></p>
		</form>
	</div>
</body>
</html>