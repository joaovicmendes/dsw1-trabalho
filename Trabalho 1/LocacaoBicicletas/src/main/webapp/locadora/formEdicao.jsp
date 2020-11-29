<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
					<a href="/<%=contextPath%>/locadoras/lista">
						<fmt:message key="rental_company_show_all"/>
					</a>
				</h2>
			</div>
			<div>
				<form action="/<%= contextPath%>/locadoras/atualizacao" method="get">
					<fieldset>
						<legend>
							<fmt:message key="rental_company_edition"/>
						</legend>
						<fmt:message key="cnpj.readonly"/> </br>
						<input type="text" name="cnpj" value="${locadora.cnpj}" readonly/> <br/>
						<fmt:message key="name"/> </br>
						<input type="text" name="nome" value="${locadora.nome}"/> <br/>
						<fmt:message key="email"/> </br>
						<input type="email" name="email" value="${locadora.email}"/> <br/>
						<fmt:message key="pw"/> </br>
						<input type="password" name="senha"/> <br/>
						<fmt:message key="city"/> </br>
						<input type="text" name="cidade" value="${locadora.cidade}"/> <br/>
						<input type="submit" name="enviar" value="<fmt:message key="update"/>" />
					</fieldset>
				</form>
			</div>
		</body>
	</fmt:bundle>
</html>