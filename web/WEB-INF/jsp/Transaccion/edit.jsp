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
        <li><h4><b>Transacción</b></h4></li>
        <li><a href="<c:url value="index.htm" />">Listado de Transacciones</a></li>
        <li class="active">Actualizando Transacción</li>
    </ol>
    <div class="panel panel-primary">
        <div class="panel-heading text-center">Formulario de Transacciones</div>
        <div class="panel-body">
            <form:form method="post" commandName="transaccionModel" action="edit.htm">
                 <c:if test = "${modeloContenido.getMensage() != null}">
                    <div class="alert alert-success">${modeloContenido.getMensage()}</div>
                 </c:if>
                 <c:if test = "${modeloContenido.getError() != null}">
                    <div class="alert alert-danger">${modeloContenido.getError()}</div>
                 </c:if>     
            
                <h3>Actualizando Transacción</h3> 
                <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                <p>
                    <form:label path="id">Identificador</form:label>
                    <form:input path = "id" cssClass="form-control" readonly="true"/>
                </p> 
                <p>
                    <form:label path="tipoTransaccion">Tipo de Transacción</form:label>
                    <form:select path ="tipoTransaccion" cssClass="form-control">
                        <form:option value = "INGRESO"  >INGRESO</form:option>
                        <form:option value = "DEDUCCION">DEDUCCION</form:option>
                    </form:select>
                </p>  
                <p>
                    <form:label path="nombreTipoTransaccion">Descripción</form:label>
                    <input path = "nombreTipoTransaccion" cssClass="form-control"  required pattern="[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}+[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}+[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}"   />

                </p>
                <p>
                    <form:label path="idEmpleado">Empleado</form:label>
                    <form:select path ="idEmpleado"  cssClass="form-control">
                        <form:option value = ""></form:option>
                        <form:options  items="${listaEmpleadoModel}" itemLabel="nombre" itemValue="id" />
                    </form:select>
                </p>
                <p>
                    <form:label path="fecha">Fecha</form:label>
                    <form:input path = "fecha" type="date" cssClass="form-control"/>
                </p>
                <p>
                    <form:label path="monto">Monto</form:label>
                    <input name="monto" class="form-control" value="${transaccionModel.monto}" type="text" placeholder="Monto" minlength="1" maxlength="9" required pattern="[0-9]+([\.][0-9]{0,2})?"  />
                </p>
                <p>
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
