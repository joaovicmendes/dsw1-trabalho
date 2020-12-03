<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticação de Usuário</title>
        <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" type="text/javascript"></script>
        <script src="toggle.js"></script>

    </head>
    <body>
        <c:if test="${mensagens.existeErros}">
            <div id="erro">
                <ul>
                    <c:forEach var="erro" items="${mensagens.erros}">
                        <li> ${erro} </li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <div style="text-align:center;">
            <button class="btn" onclick="toggleLoader()">Cliente</button>
        </div>
        <div class="box cliente">     
            <h2>Login</h2>
            <form method="post" action="login">
                
                <div class="login-form">
                    <label for="cliente_login">Email</label>
                    <input type="text" name="cliente_login" value="${param.login}" placeholder="Email"/>
                    
                    <label for="cliente_password">Password</label>
                    <input type="password" name="cliente_senha" id="password" placeholder="Password">
                </div>
                
                <input type="submit" id="submit" style="float:right" name="clienteOK" value="Entrar">
            </form>
        </div>

        <div class="box locadora" style="border-left: 5px solid rgb(255, 77, 70); display: none;">
            <h2>Login</h2>
            <form method="post" action="login">
                
                <div class="login-form">
                    <label for="locadora_login">Email</label>
                    <input type="text" name="locadora_login" value="${param.login}" placeholder="Email"/>
                    
                    <label for="locadora_password">Password</label>
                    <input type="password" name="locadora_senha" id="password" placeholder="Password">
                </div>
                
                <input type="submit" id="submit" style="float:right" name="locadoraOK" value="Entrar">
            </form>
        </div>

    </body>
</html>
