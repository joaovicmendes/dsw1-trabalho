<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="messages">
<html>
    <title><fmt:message key="page_title"/></title>
    <meta charset="UTF-8">
<body>
    <h1><fmt:message key="title"/></h1>
    <form name="teste" action="conversion.jsp">
        <fieldset>
        <legend><fmt:message key="form_title"/></legend>
        <fmt:message key="form_min"/> </br>
        <input type="number" name="min" placeholder="-100"/> <br/>
        <fmt:message key="form_max"/> </br>
        <input type="number" name="max" placeholder="100"/> <br/>
        <fmt:message key="form_step"/> </br>
        <input type="number" name="step" placeholder="5"/> <br/>
        <input type="submit" name="enviar" value="<fmt:message key="form_submit"/> " />
        </fieldset>
    </form>
</body>
</html>
</fmt:bundle>
