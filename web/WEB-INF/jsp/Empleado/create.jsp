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
                   <input name="cedula"  class="form-control" value="${empleado.cedula}" type="text" placeholder="Cédula" minlength="11" maxlength="11" required pattern="[0-9]+" />
                    

                </p>
                <p>
                    <label for="nombre">Nombre</label>
                    <input name="nombre" class="form-control" value="${empleado.nombre}" type="text" placeholder="Nombre" minlength="3" maxlength="50" required pattern="[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}+[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}+[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}"  />
                 </p>
                <p>
                    <label>Departamento</label>
                    <input name="departamento" class="form-control" value="${empleado.departamento}" type="text" placeholder="Departamento" minlength="1" maxlength="50" required pattern="[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}+[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}+[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}"  />
                </p>
                <p>
                    <label>Puesto</label>
                    <input name="puesto" class="form-control" value="${empleado.puesto}"  type="text" placeholder="Puesto" minlength="1" maxlength="50"  required pattern="[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}+[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}+[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ]{2,25}"    />
                </p>
                <p>
                    <label>Salario</label>
                    <input name="salario" class="form-control" value="${empleado.salario}" type="text" placeholder="Salario" minlength="1" maxlength="9" required pattern="[0-9]+([\.][0-9]{0,2})?"  />
               </p>
               <p>
                    <label>Cuenta</label>
                    <input name="cuenta" class="form-control" value="${empleado.cuenta}" type="text" minlength="1" maxlength="20" placeholder="Cuenta" required pattern="[0-9]+"  />
               </p>
               <p>
                    <label>Nomina</label>
                    <form:select path ="idNomina" cssClass="form-control">
                        <form:option value = "1">Nomina</form:option>
                    </form:select>
               </p>


                <input type="submit" value="Enviar" class="btn btn-danger" />
            </form:form>
        </div>
    </div>
</div>


