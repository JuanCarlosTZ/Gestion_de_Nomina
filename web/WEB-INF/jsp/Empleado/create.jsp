<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <ol class="breadcrumb">
        <li><h4><b>Empleado</b></h4></li>
        <li><a href="<c:url value="index.htm" />">Listado de Empleados</a></li>
        <li class="active">Agregar Empleado</li>
    </ol>
        <c:if test = "${modeloContenido.getMensage() != null}">
                    <div class="alert alert-success">${modeloContenido.getMensage()}</div>
                 </c:if>
                 <c:if test = "${modeloContenido.getError() != null}">
                    <div class="alert alert-danger">${modeloContenido.getError()}</div>
                 </c:if> 
    <div class="panel panel-primary">
        <div class="panel-heading text-center"><b>Complete el Formulario</b></div>
        <div class="panel-body">
            <form:form modelAttribute="empleado" action="create.htm" method="post">
                <h3>Agregando Empleado</h3>
               <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                <p>
                   <label for="cedula">Cedula</label>
                    <input name="cedula" class="form-control" value="${empleado.cedula}" />


                </p>
                <p>
                    <label for="nombre">Nombre</label>
                    <input name="nombre" class="form-control" value="${empleado.nombre} " />
                 </p>
                <p>
                    <label>Departamento</label>
                    <input name="departamento" class="form-control" value="${empleado.departamento} "/>
                </p>
                <p>
                    <label>Puesto</label>
                    <input name="puesto" class="form-control" value="${empleado.puesto} "/>
                </p>
                <p>
                    <label>Salario</label>
                    <input name="salario" class="form-control" value="${empleado.salario} "/>
               </p>
               <p>
                    <label>Cuenta</label>
                    <input name="cuenta" class="form-control" value="${empleado.cuenta} "/>
               </p>
               <p>
                    <label>Id de la Nomina</label>
                    <input name="idNomina" class="form-control" value="${empleado.idNomina} "/>
               </p>


                <input type="submit" value="Enviar" class="btn btn-danger" />
            </form:form>
        </div>
    </div>
</div>


