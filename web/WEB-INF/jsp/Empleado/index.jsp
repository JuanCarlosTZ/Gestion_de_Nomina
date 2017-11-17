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
                <li ><h4><b>Empleado</b></h4></li>
                <li class="active" >Listado de Empleados</li>               
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
                    <th>Cedula</th>
                    <th>Nombre</th>
                    <th>Departamento</th>
                    <th>Puesto</th>
                    <th>Salario</th>
                    <th>Cuenta</th>
                    <th>Id de la Nomina</th>
                    <th></th>
                </thead>
                <c:forEach var = "empleado" items="${listaEmpleado}" >
                    <tr>
                        <td>
                            <c:out value="${empleado.getId()}"/>
                        </td>
                        <td>
                            <c:out value="${empleado.getCedula()}"/>
                        </td>
                        <td>
                            <c:out value="${empleado.getNombre()}"/>
                        </td>
                        <td>
                            <c:out value="${empleado.getDepartamento()}"/>
                        </td>
                        <td>
                            <c:out value="${empleado.getPuesto()}"/>
                        </td>
                        <td>
                            <c:out value="${empleado.getSalario()}"/>
                        </td>
                        <td>
                            <c:out value="${empleado.getCuenta()}"/>
                        </td>
                        <td>
                            <c:out value="${empleado.getIdNomina()}"/>
                        </td>
                        <td>
                            <a href="<c:url value="edit.htm?id=${empleado.id}" />"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                            <a href="<c:url  value="delete.htm?id=${empleado.id}" />" onclick="return confirm('Presione OK para eliminar el registro.')"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>


                        </td>

                    </tr>
                </c:forEach>
               
            </table>
        </div>
