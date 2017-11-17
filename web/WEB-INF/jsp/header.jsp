<%-- 
    Document   : header
    Created on : 08/11/2017, 06:50:41 PM
    Author     : Juan Carlos Tejeda
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
<div>
<a href="${pageContext.request.contextPath}">
<img src="${pageContext.request.contextPath}/resources/logo.png"/>
</a>
</div>
-->
<div>                  
                    
             
    <nav class="navbar navbar-default navbar-inverse">  
        <div class="container-fluid">    
            <div class="navbar-header">      
                <a class="navbar-brand" href="#">Gestión de Nomina</a>    
            </div>
    
            <ul class="nav navbar-nav">        
                
                <li></li>      
                <li><a href="<c:url value="${modeloContenido.getRuta()}Empleado/index.htm" />">Empleado</a></li>
                <li ><a href="<c:url value="${modeloContenido.getRuta()}Transaccion/index.htm" />">Transacción</a></li>
                <li ><a href="<c:url value="${modeloContenido.getRuta()}TipoIngreso/index.htm" />">Tipo Ingreso</a></li>
                <li ><a href="<c:url value="${modeloContenido.getRuta()}TipoDeduccion/index.htm" />">Tipo Deducción</a></li>
                <li><a href="<c:url value="#" />">Nómina</a></li>
                <li><a href="<c:url value="${modeloContenido.getRuta()}Transaccion/report.htm" />">Reporte</a></li>
    
            </ul>  
        </div>
    </nav>
       
</div>
                <script type="text/javascript" src="../../Resources/js/bootstrap-dropdown.js"></script>
<script>
     $(document).ready(function(){
        $('.dropdown-toggle').dropdown()
    });
</script>
                    
                    

