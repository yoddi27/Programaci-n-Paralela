<%-- 
    Document   : mensaje
    Created on : 25/04/2018, 07:25:50 PM
    Author     : sala312
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:out value="${sessionScope.MENSAJE}"></c:out>
            <a href="${pageContext.servletContext.contextPath}/View/Creditos.jsp">Regresar </a>
        </h1>
    </body>
</html>
