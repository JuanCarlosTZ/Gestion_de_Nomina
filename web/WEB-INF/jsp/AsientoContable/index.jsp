<%-- 
    Document   : index
    Created on : 02/11/2017, 06:43:55 PM
    Author     : Juan Carlos Tejeda
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


        <div class="container">
            <ol class="breadcrumb">
                <li ><h4><b>Asiento Contable</b></h4></li>
                <li class="active" >Listado de Asientos Contables</li>               
            </ol>
                <c:if test = "${modeloContenido.getMensage() != null}">
                    <div class="alert alert-success">${modeloContenido.getMensage()}</div>
                 </c:if>
                    <c:if test = "${modeloContenido.getError() != null}">
                    <div class="alert alert-danger">${modeloContenido.getError()}</div>
                 </c:if>
            <p>
                <a href="<c:url value="create.htm" />" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar</a>
            </p>

            <table class="table table-bordered table-striped table-hover">
                <thead>
                   
                    <th>Identificador</th>
                    <th>Descripción</th>
                    <th>Id del Empleado</th>
                    <th>Número de Cuenta</th>
                    <th>Tipo de Movimiento</th>
                    <th>Fecha</th>
                    <th>Monto</th>
                    <th>Estado</th>
                    <th></th>
                </thead>
                <c:forEach var = "asientoContable" items="${listaAsientoContableModel}" >
                    <tr>
                        <td>
                            <c:out value="${asientoContable.getId()}"/>
                        </td>
                        <td>
                            <c:out value="${asientoContable.getDescripcion()}"/>
                        </td>
                        <td>
                            <c:out value="${asientoContable.getIdEmpleado()}"/>
                        </td>
                        <td>
                            <c:out value="${asientoContable.getCuenta()}"/>
                        </td>
                        <td>
                            <c:out value="${asientoContable.getTipoMovimiento()}"/>
                        </td>
                        <td>
                            <c:out value="${asientoContable.getFecha()}"/>
                        </td>
                        <td>
                            <c:out value="${asientoContable.getMonto()}"/>
                        </td>
                        <td>
                            <c:out value="${asientoContable.getEstado()}"/>
                        </td>

                        
                        <td>
                            <a href="<c:url value="edit.htm?id=${asientoContable.getId()}" />"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                            <a href="<c:url  value="delete.htm?id=${asientoContable.getId()}" />" onclick="return confirm('Presione OK para eliminar el registro.')"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>


                        </td>

                    </tr>
                </c:forEach>
               
            </table>
        </div>
