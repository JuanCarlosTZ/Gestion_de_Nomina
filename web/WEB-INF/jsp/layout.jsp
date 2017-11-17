<%-- 
    Document   : createLayout
    Created on : 08/11/2017, 06:16:40 PM
    Author     : Juan Carlos Tejeda
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<title>${modeloContenido.getTitulo()}</title>

<link rel="stylesheet" type="text/css"	href="<c:url value ="${modeloContenido.getRuta()}Resources/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" type="text/css"  href="<c:url value="${modeloContenido.getRuta()}Resources/css/jquery.datetimepicker.css"/>"/>
</head>
<body>
	
    	<jsp:include page="header.jsp"/>
        <div class="container ">
	<jsp:include page="${modeloContenido.getPagina()}.jsp"/>	</div>
	<jsp:include page="footer.jsp"/>	
	
</body>
</html>
