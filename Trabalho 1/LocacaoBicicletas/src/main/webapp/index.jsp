<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<fmt:bundle basename="msgs">
	    <head>
	        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	        <title>
	        	<fmt:message key="title"/>
	        </title>
	    </head>
	    <body>
			<c:if test="${sessionScope.clienteLogado == null && sessionScope.locadoraLogado == null}">
				Olá, Convidado.
			</c:if>
			<c:if test="${sessionScope.clienteLogado != null && sessionScope.locadoraLogado == null}">
				Olá, ${sessionScope.clienteLogado.nome}.
			</c:if>
			<c:if test="${sessionScope.clienteLogado == null && sessionScope.locadoraLogado != null}">
				Olá, ${sessionScope.locadoraLogada.nome}.
			</c:if>
			<br>
			<a href="locadoras">
	        	Listar Locadoras
			</a>
			<br>
			<c:if test="${sessionScope.clienteLogado != null && sessionScope.locadoraLogado == null && sessionScope.clienteLogado.admin}">
				<a href="clientes">
					Listar Clientes
				</a>
				<br>
			</c:if>
			<c:if test="${sessionScope.clienteLogado != null || sessionScope.locadoraLogado != null}">
				<a href="locacoes">
					Minhas Locações
				</a>
				<br>
			</c:if>
			<c:choose>
			<c:when test="${sessionScope.clienteLogado == null && sessionScope.locadoraLogado == null}">
				<a href="login.jsp">
					Login
				</a>
				<br>
				<a href="clientes/cadastro">
					Cadastrar como Cliente
				</a>
				<br>
				<a href="locadoras/cadastro">
					Cadastrar como Locadora
				</a>
				<br>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/logout.jsp">
					Sair
				</a>
				<br>
			</c:otherwise>
			</c:choose>
	    </body>
    </fmt:bundle>
</html>