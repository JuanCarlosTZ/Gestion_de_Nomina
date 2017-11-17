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
        <li><a href="<c:url value="index.htm" />">Listado de Asientos Contables</a></li>
        <li class="active">Actualizando Asiento Contable</li>
    </ol>
    <div class="panel panel-primary">
        <div class="panel-heading text-center">Formulario de Asientos Contables</div>
        <div class="panel-body">
            <form:form method="post" commandName="asientoContableModel" action="edit.htm">
                 <c:if test = "${modeloContenido.getMensage() != null}">
                    <div class="alert alert-success">${modeloContenido.getMensage()}</div>
                 </c:if>
                 <c:if test = "${modeloContenido.getError() != null}">
                    <div class="alert alert-danger">${modeloContenido.getError()}</div>
                 </c:if>     
            
                <h3>Actualizando Asientos Contable</h3> 
                <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                <p>
                    <form:label path="id">Identificador</form:label>
                    <form:input path = "id" cssClass="form-control"/>
                </p> 
                <p>
                    <form:label path="descripcion">Descripción</form:label>
                    <form:input path = "descripcion" cssClass="form-control"/>
                </p>  
                <p>
                    <form:label path="idEmpleado">Id del Empleado</form:label>
                    <form:input path = "idEmpleado" cssClass="form-control"/>

                </p>
                <p>
                    <form:label path="cuenta">Número de Cuenta</form:label>
                    <form:input path = "cuenta" cssClass="form-control"/>
                </p>
                <p>
                    <form:label path="tipoMovimiento">Tipo de Movimiento</form:label>
                    <form:input path = "tipoMovimiento" cssClass="form-control"/>
                </p>
                <p>
                    <form:label path="fecha">Fecha</form:label>
                    <form:input path = "fecha" type="date" cssClass="form-control"/>
                </p>
                <p>
                    <form:label path="monto">Monto</form:label>
                    <form:input path = "monto" cssClass="form-control"/>
                </p>
                <p>
                    <form:label path="estado">Estado</form:label>
                    <form:input path = "estado" cssClass="form-control"/>
                </p>


                <input type="submit" value="Enviar" class="btn btn-danger" />
            </form:form>
        </div>
    </div>
</div>
