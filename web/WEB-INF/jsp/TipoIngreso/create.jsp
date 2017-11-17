<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <ol class="breadcrumb">
        <li><h4><b>Tipo de Ingreso</b></h4></li>
        <li><a href="<c:url value="index.htm" />">Listado de Tipos de Ingresos</a></li>
        <li class="active">Agregar Tipo de Ingreso</li>
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
            <form:form modelAttribute="tipoIngresoModel" action="create.htm" method="post">
                <h3>Agregando Tipo de Ingreso</h3>
               <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                <p>
                   <label for="nombre">Nombre</label>
                    <input name="nombre" class="form-control" value="${tipoIngresoModel.nombre}" />
                </p>
                <p>
                    <label for="dependeDeSalario">Depende de Salario</label>
                    <input name="dependeDeSalario" class="form-control" value="${tipoIngresoModel.dependeDeSalario} " />
                 </p>
                <p>
                    <label>Estado</label>
                    <input name="estado" class="form-control" value="${tipoIngresoModel.estado} "/>
                </p>


                <input type="submit" value="Enviar" class="btn btn-danger" />
            </form:form>
        </div>
    </div>
</div>


