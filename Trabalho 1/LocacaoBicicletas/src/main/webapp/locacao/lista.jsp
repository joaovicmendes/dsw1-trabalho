<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<fmt:bundle basename="msgs">
		<head>
			<title>
				Locações
			</title>
		</head>
		<body>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<div align="center">
				<h1>
					Locações
				</h1>
				<h2>
					<a href="/<%=contextPath%>">
						<fmt:message key="main_menu"/>
					</a>
					&nbsp;&nbsp;&nbsp;
					<a href="/<%=contextPath%>/locacoes/locacao">
						Nova Locação
					</a>
				</h2>
			</div>
			<div align="center">
				<c:if test="${requestScope.listaLocacoes != null}">
				<table border="1">
					<caption>
						Minhas Locações
					</caption>
					<tr>
						<th>CPF Cliente</th>
						<th>CNPJ Locadora</th>
						<th>Data Reserva</th>
					</tr>
					<c:forEach var="locacao" items="${requestScope.listaLocacoes}">
						<tr>
							<td>${locacao.cliente.cpf}</td>
							<td>${locacao.locadora.cnpj}</td>
							<td>${locacao.dataReserva}</td>
						</tr>
					</c:forEach>
				</table>
				</c:if>
				<c:if test="${requestScope.listaLocacoes == null}">
					Sem locações disponíveis
				</c:if>
			</div>
		</body>
	</fmt:bundle>
</html>