<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <ol class="breadcrumb">
        <li><h4><b>Transacción</b></h4></li>
        <li><a href="<c:url value="index.htm" />">Listado de Transacciones</a></li>
        <li class="active">Agregar Transacción</li>
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
            <form:form modelAttribute="transaccionModel" action="create.htm" method="post">
                <h3>Agregando Transacción</h3>
               <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                <p>
                   <label for="tipoTransaccion">Tipo de Transacción</label>
                    <form:select path ="tipoTransaccion" cssClass="form-control">
                        <form:option value = "INGRESO"  >INGRESO</form:option>
                        <form:option value = "DEDUCCION">DEDUCCION</form:option>
                    </form:select>
                </p>
                <p>
                    <label for="nombreTipoTransaccion">Descripción</label>
                    <input name="nombreTipoTransaccion" class="form-control" value="${transaccionModel.nombreTipoTransaccion} " />
                 </p>
                <p>
                    <label for="idEmpleado">Empleado</label>
                    <form:select path ="idEmpleado" cssClass="form-control">
                        <form:option value = ""></form:option>
                        <form:options items="${listaEmpleadoModel}" itemLabel="nombre" itemValue="id"/>
                    </form:select>
                 </p>
                 <p>
                    <label for="fecha">Fecha</label>
                    <input name="fecha" class="form-control" type="date" value="${transaccionModel.fecha} " />
                 </p>
                 <p>
                    <label for="monto">Monto</label>
                    <input name="monto" class="form-control" value="${transaccionModel.monto}" type="text" placeholder="Monto" minlength="1" maxlength="9" required pattern="[0-9]+([\.][0-9]{0,2})?"  />
                 </p>
                 <p>
                    <label for="estado">Estado</label>
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


