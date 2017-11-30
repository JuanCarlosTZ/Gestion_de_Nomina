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
        <li><h4><b>Tipo de Deducción</b></h4></li>
        <li><a href="<c:url value="index.htm" />">Listado de Tipos de Deducciones</a></li>
        <li class="active">Actualizando Deducciones</li>
    </ol>
    <div class="panel panel-primary">
        <div class="panel-heading text-center">Formulario de Tipos de Deducciones</div>
        <div class="panel-body">
            <form:form method="post" commandName="tipoDeduccionModel" action="edit.htm">
                 <c:if test = "${modeloContenido.getMensage() != null}">
                    <div class="alert alert-success">${modeloContenido.getMensage()}</div>
                 </c:if>
                 <c:if test = "${modeloContenido.getError() != null}">
                    <div class="alert alert-danger">${modeloContenido.getError()}</div>
                 </c:if>     
            
                <h3>Actualizando Tipo de Deducción</h3> 
                <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                <p>
                    <form:label path="id">Identificador</form:label>
                    <form:input path = "id" cssClass="form-control" readonly="true"/>
                </p> 
                <p>
                    <form:label path="nombre">Nombre</form:label>
                    <input required path="nombre" cssClass="form-control" pattern="[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}+[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}+[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}"   />
                </p>  
                <p>
                    <form:label path="dependeDeSalario">Depende de Salario</form:label>
                    <input type="radio" name="dependeDeSalario"  value="1" <c:if test="${tipoDeduccionModel.dependeDeSalario==1}">checked</c:if> />
                    <label for="contactChoice2">SI</label>
                    <input type="radio" name="dependeDeSalario"  value="0" <c:if test="${tipoDeduccionModel.dependeDeSalario==0}">checked</c:if>/>
                    <label for="contactChoice2">NO</label>

                </p>
                <p>
                    <form:label path="estado">Estado</form:label>
                    <form:select path ="estado" cssClass="form-control">
                        <form:option value = "ACTIVO"  >ACTIVO</form:option>
                        <form:option value = "INACTIVO">INACTIVO</form:option>
                    </form:select>
                </p>
      

                <input type="submit" value="Enviar" class="btn btn-danger" />
            </form:form>
        </div>
    </div>
</div>
