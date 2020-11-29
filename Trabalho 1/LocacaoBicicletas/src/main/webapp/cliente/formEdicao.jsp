<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<fmt:bundle basename="msgs">
		<head>
			<title>
				<fmt:message key="client_managing"/>
			</title>
		</head>
		<body>
			<%
				String contextPath = request.getContextPath().replace("/", "");
			%>
			<div align="center">
				<h1>
					<fmt:message key="client_managing"/>
				</h1>
				<h2>
					<a href="/<%=contextPath%>">
						<fmt:message key="main_menu"/>
					</a>
					&nbsp;&nbsp;&nbsp;
					<a href="/<%=contextPath%>/clientes/cadastro">
						<fmt:message key="client_new"/>
					</a>
				</h2>
			</div>
			<div>
				<form action="/<%= contextPath%>/clientes/atualizacao" method="post">
					<fieldset>
						<legend>
							<fmt:message key="client_edition"/>
						</legend>
						<fmt:message key="cpf.readonly"/></br>
						<input type="text" name="cpf" value="${cliente.cpf}" readonly/> <br/>
						<fmt:message key="name"/> </br>
						<input type="text" name="nome" value="${cliente.nome}"/> <br/>
						<fmt:message key="email"/> </br>
						<input type="email" name="email" value="${cliente.email}"/> <br/>
						<fmt:message key="pw"/> </br>
						<input type="password" name="senha"/> <br/>
						<fmt:message key="gender"/> </br>
						<input type="text" name="genero" value="${cliente.genero}"/> <br/>
						<fmt:message key="phone"/> </br>
						<input type="text" name="telefone" value="${cliente.telefone}"/> <br/>
						<fmt:message key="birhtdata"/> </br>
						<input type="text" name="dataNascimento" value="${cliente.dataNascimento}"/> <br/>
						<input type="submit" name="enviar" value="<fmt:message key="update"/>" />
					</fieldset>
				</form>
			</div>
		</body>
	</fmt:bundle>
</html>