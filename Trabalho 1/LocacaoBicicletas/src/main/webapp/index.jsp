<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
	        <a href="clientes">
	        	<fmt:message key="crud.client"/>
	        </a>
	        <br>
	        <a href="locadoras">
	        	<fmt:message key="crud.rental_company"/>
	        </a>
	    </body>
    </fmt:bundle>
</html>