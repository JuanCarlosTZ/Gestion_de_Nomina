<%-- 
    Document   : login
    Created on : 02/09/2017, 05:07:34 PM
    Author     : Juan Carlos Tejeda
--%>

<%@page language ="java" contentType="text/html; charset = ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <%-- <jsp:include page="/WEB-INF/views/login.jsp"/> --%>
        <title>Login</title>    
     
    </head>
    <body>
        <div class="container">

            ${requestScope.loginError}
            <div class="form-group form">
                <form action="login.htm" method="post">
                    <div>
                        <label>Nombre de usuario:</label>
                        <input type="text" id="userId" name="userId" placeholder="nombre de usuario" class="form-control"/>
                    </div>
                    <div>
                        <label>Contraseña</label>
                        <input type="password" id="password" name="password" placeholder="contraseña" class="form-control"/>
                    </div>
                    <button id="loginButton" class="form-control">Login</button>
                </form>
                
                
                       <form action="registrarusuario.htm" method="gest">  
            
            <input type="submit" value="Registrar" />
        </form>
            </div>
        </div>
    </body>
</html>


<%-- 
    Document   : login
    Created on : 02/09/2017, 05:07:34 PM
    Author     : Juan Carlos Tejeda
--%>
<%--
<%@page language ="java" contentType="text/html; charset = ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
    
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <jsp:include page="/WEB-INF/views/head-include.jsp"/>
        <title>Login</title>    
     
    </head>
    <body>
        <div class="container">
            @{loginError}
            <div class="form-group form">
                <form action="login" method="post">
                    <div>
                        <label>Nombre de usuario:</label>
                        <input type="text" id="userId" name="userId" placeholder="nombre de usuario" class="form-control"/>
                    </div>
                    <div>
                        <label>Contraseña</label>
                        <input type="password" id="password" placeholder="contraseña" class="form-control"/>
                    </div>
                    <button id="loginButton" class="form-control">Login</button>
                </form>
            </div>
        </div>
    </body>
</html>
--%>