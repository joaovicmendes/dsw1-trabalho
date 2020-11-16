<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:bundle basename="messages">
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="page_title"/></title>
    <meta charset="UTF-8">
</head>
<body>
    <h1><fmt:message key="title"/></h1>
    <%  String minValue = request.getParameter("min");
        int min = (minValue == null || minValue == "") ? -100 : Integer.parseInt(minValue);
        String maxValue = request.getParameter("max");
        int max = (maxValue == null || maxValue == "") ?  100 : Integer.parseInt(maxValue);
        String stepValue = request.getParameter("step");
        int step = (stepValue == null || stepValue == "") ?  5 : Integer.parseInt(stepValue);

        if (step <= 0) { %>
            <p><fmt:message key="error_step"/></p>
    <%  } 
        else if (min > max) { %>
            <p><fmt:message key="error_minmax"/></p>
    <%  }
        else { %>
            <table>
            <tr>
            <th>Celsius</th>
            <th>Fahrenheit</th>
            </tr>
            <% for (int celsius = min; celsius <= max; celsius += step) {
                    double fahr = 1.8 * celsius + 32; %>
                    <tr>
                    <td> <%= celsius %> </td>
                    <td> <%= fahr %> </td>
                    </tr>
            <% } %>
            </table>
        <% } %>
</body>
</html>
</fmt:bundle>