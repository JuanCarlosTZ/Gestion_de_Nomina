<%-- 
    Document   : edit
    Created on : 08/11/2017, 03:17:34 AM
    Author     : Juan Carlos Tejeda
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <ol class="breadcrumb">
        <li><h4><b>Empleado</b></h4></li>
        <li><a href="<c:url value="index.htm" />">Listado de Empleados</a></li>
        <li class="active">Actualizando Empleado</li>
    </ol>
    <div class="panel panel-primary">
        <div class="panel-heading text-center">Formulario de Empleado</div>
        <div class="panel-body">
            <form:form method="post" commandName="empleado" action="edit.htm">
                 <c:if test = "${modeloContenido.getMensage() != null}">
                    <div class="alert alert-success">${modeloContenido.getMensage()}</div>
                 </c:if>
                 <c:if test = "${modeloContenido.getError() != null}">
                    <div class="alert alert-danger">${modeloContenido.getError()}</div>
                 </c:if>     
            
                <h3>Actualizando Empleado</h3> 
                <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                <p>
                    <form:label path="id">Identificador</form:label>
                    <form:input path = "id" cssClass="form-control"/>
                </p>  
                <p>
                    <form:label path="nombre">Nombre y Apellido</form:label>
                    <form:input path = "nombre" cssClass="form-control"/>
                </p>  
                <p>
                    <form:label path="cedula">Cedula</form:label>
                    <form:input path = "cedula" cssClass="form-control"/>

                </p>
                <p>
                    <form:label path="departamento">Departamento</form:label>
                    <form:input path = "departamento" cssClass="form-control"/>
                </p>
                <p>
                    <form:label path="puesto">Puesto</form:label>
                    <form:input path = "puesto" cssClass="form-control"/>
                </p>
                <p>
                    <form:label path="salario">Salario</form:label>
                    <form:input path = "salario" cssClass="form-control"/>
                </p>
                <p>
                    <form:label path="cuenta">Cuenta</form:label>
                    <form:input path = "cuenta" cssClass="form-control"/>
                </p>
                <p>
                    <form:label path="idNomina">Id de la Nomina</form:label>
                    <form:input path = "idNomina" cssClass="form-control"/>
                </p>

                <input type="submit" value="Enviar" class="btn btn-danger" />
            </form:form>
        </div>
    </div>
</div>
