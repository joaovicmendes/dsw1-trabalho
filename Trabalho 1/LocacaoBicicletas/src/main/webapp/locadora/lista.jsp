<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<fmt:bundle basename="msgs">
		<head>
			<title>
				<fmt:message key="rental_company_managing"/>
			</title>
		</head>
		<body>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<div align="center">
				<h1>
					<fmt:message key="rental_company_managing"/>
				</h1>
				<h2>
					<a href="/<%=contextPath%>">
						<fmt:message key="main_menu"/>
					</a>
					&nbsp;&nbsp;&nbsp;
					<a href="/<%=contextPath%>/locadoras/cadastro">
						<fmt:message key="rental_company_new"/>
					</a>
					&nbsp;&nbsp;&nbsp;
					<a href="/<%=contextPath%>/locadoras/escolherCidade">
						<fmt:message key="rental_company_show_all"/>
					</a>
				</h2>
			</div>
			<div align="center">
				<table border="1">
					<caption>
						<fmt:message key="rental_company_list"/>
					</caption>
					<tr>
						<th><fmt:message key="cnpj"/></th>
						<th><fmt:message key="name"/></th>
						<th><fmt:message key="email"/></th>
						<th><fmt:message key="pw"/></th>
						<th><fmt:message key="city"/></th>
		                <th><fmt:message key="actions"/></th>
					</tr>
					<c:forEach var="locadora" items="${requestScope.listaLocadoras}">
						<tr>
							<td>${locadora.cnpj}</td>
							<td>${locadora.nome}</td>
							<td>${locadora.email}</td>
							<td>${locadora.senha}</td>
							<td>${locadora.cidade}</td>
							<td>
								<a href="/<%= contextPath%>/locadoras/edicao?cnpj=${locadora.cnpj}">
									<fmt:message key="edition"/>
								</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<fmt:message var="confirmation_text" key="confirmation_text"/>
								<a
									href="/<%= contextPath%>/locadoras/remocao?cnpj=${locadora.cnpj}"
									onclick="return confirm(${confirmation_text});">
									<fmt:message key="removal"/>
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</body>
	</fmt:bundle>
</html>