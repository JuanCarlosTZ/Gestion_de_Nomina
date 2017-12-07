<%-- 
    Document   : edit
    Created on : 08/11/2017, 03:17:34 AM
    Author     : Juan Carlos Tejeda
--%>

<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <ol class="breadcrumb">
        <li><h4><b>Asiento Contable</b></h4></li>
        <li><a href="<c:url value="index.htm" />">Listado de Transacciones</a></li>
        <li class="active">Detalle del Asiento Contable</li>
    </ol>
    <div class="panel panel-primary">
        <div class="panel-heading text-center">Formulario de Asiento Contable</div>
        <div class="panel-body">
            <form:form method="POST" commandName="asientoContable" action="reporte.htm">
                 <c:if test = "${modeloContenido.getMensage() != null}">
                    <div class="alert alert-success">${modeloContenido.getMensage()}</div>
                 </c:if>
                 <c:if test = "${modeloContenido.getError() != null}">
                    <div class="alert alert-danger">${modeloContenido.getError()}</div>
                 </c:if>     
            
                <h3>Detalle del Asiento Contable</h3> 

                <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                <p>
                    <form:label path="id">Identificador</form:label>
                    <form:input path = "id" cssClass="form-control" readonly="true"/>
                </p> 
                <p>
                    <form:label path="cuenta">Descripción</form:label>
                    <form:input path = "cuenta" type="text" cssClass="form-control"/>

                </p>
                <p>
                    <form:label path="tipoMovimiento">Tipo de Transacción</form:label>
                    <form:input path = "tipoMovimiento" type="text" cssClass="form-control"/>
                </p>  
                <p>
                    <form:label path="monto">Monto</form:label>
                    <form:input path = "monto" type="float" cssClass="form-control"/>
                </p>
                <p>
                    <form:label path="fecha">Fecha</form:label>
                    <form:input path = "fecha" type="date" cssClass="form-control"/>
                </p>
      

                <input type="submit" value="Enviar" class="btn btn-danger" />
            </form:form>
        </div>
    </div>
</div>
