<%-- 
    Document   : create
    Created on : 09/09/2017, 09:47:31 PM
    Author     : Juan Carlos Tejeda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrar Usuario</h1>
        
                <div class="container">

            ${requestScope.guardarConfirmacion}
            <div class="form-group form">
                <form action="registrarusuario.htm" method="post">
                    <div>
                        <label>Codigo:</label>
                        <input type="text" id="codigo" name="codigo" placeholder="codigo" class="form-control"/>
                    </div>
                    <div>
                        <label>Contraseña:</label>
                        <input type="password" id="contrasenia" name="contrasenia" placeholder="contrasenia" class="form-control"/>
                    </div>
                    <div>
                        <label>Tipo de Usuario:</label>
                        <input type="int" id="idTipoUsuario" name="idTipoUsuario" placeholder="Tipo de Usuario" class="form-control"/>
                    </div>
                   
                    <button id="registrarUsuarioButton" class="form-control">Guardar</button>

            </div>
        </div>
    </body>
</html>
