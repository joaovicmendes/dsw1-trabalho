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
			<c:if test="${mensagens.existeErros}">
            <div id="erro">
                <ul>
                    <c:forEach var="erro" items="${mensagens.erros}">
                        <li> ${erro} </li>
                    </c:forEach>
                </ul>
            </div>
        	</c:if>
			<div align="center">
				<h1>
					<fmt:message key="rental_company_managing"/>
				</h1>
				<h2>
					<a href="/<%=contextPath%>">
						<fmt:message key="main_menu"/>
					</a>
					<c:if test="${sessionScope.clienteLogado != null && sessionScope.locadoraLogado == null && sessionScope.clienteLogado.admin}">
						&nbsp;&nbsp;&nbsp;
						<a href="/<%=contextPath%>/locadoras/cadastro">
							<fmt:message key="rental_company_new"/>
						</a>
					</c:if>
					&nbsp;&nbsp;&nbsp;
					<a href="/<%=contextPath%>/locadoras/lista">
						<fmt:message key="rental_company_show_all"/>
					</a>
				</h2>
			</div>
			<div align="center">
				<form action="/<%= contextPath%>/locadoras/listaCidade" method="get">
					<select name="cidade">
						<c:forEach var="cidade" items="${requestScope.listaCidades}">	
							<option value ="${cidade}">${cidade}</option>
						</c:forEach>
					</select>
					<p>
						<input type="submit" value="<fmt:message key="choose"/>">
					</p>
				</form>
			</div>
		</body>
	</fmt:bundle>
</html>