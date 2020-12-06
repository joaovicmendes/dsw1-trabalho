<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<fmt:bundle basename="msgs">
		<head>
			<title>
				<fmt:message key="leases"/>
			</title>
		</head>
		<body>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<div align="center">
				<h1>
					<fmt:message key="leases"/>
				</h1>
				<h2>
					<a href="/<%=contextPath%>">
						<fmt:message key="main_menu"/>
					</a>
					&nbsp;&nbsp;&nbsp;
					<a href="/<%=contextPath%>/locacoes/locacao">
						<fmt:message key="new_lease"/>
					</a>
				</h2>
			</div>
			<div align="center">
				<c:if test="${requestScope.listaLocacoes != null}">
				<table border="1">
					<caption>
						<fmt:message key="my_leases"/>
					</caption>
					<tr>
						<th><fmt:message key="client_cpf"/></th>
						<th><fmt:message key="client_name"/></th>
						<th><fmt:message key="rental_company_cnpj"/></th>
						<th><fmt:message key="rental_company_name"/></th>
						<th><fmt:message key="date"/></th>
					</tr>
					<c:forEach var="locacao" items="${requestScope.listaLocacoes}">
						<tr>
							<td>${locacao.cliente.cpf}</td>
							<td>${locacao.cliente.nome}</td>
							<td>${locacao.locadora.cnpj}</td>
							<td>${locacao.locadora.nome}</td>
							<td>${locacao.dataReserva}</td>
						</tr>
					</c:forEach>
				</table>
				</c:if>
				<c:if test="${requestScope.listaLocacoes == null}">
					<fmt:message key="no_leases"/>
				</c:if>
			</div>
		</body>
	</fmt:bundle>
</html>