<%-- 
    Document   : exito
    Created on : 06-jun-2016, 16:44:18
    Author     : heltonsmith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido ${requestScope.nombre}</h1>
        
        <p>Todo OK</p>
        <form action="index.htm">
            
            <input type="submit" value="Cerrar sesion." />
        </form>
    </body>
</html>
