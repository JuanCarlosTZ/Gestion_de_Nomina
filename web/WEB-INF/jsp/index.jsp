<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <link rel="stylesheet" href="<c:url value ="Resources/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" href="<c:url value="Resources/css/jquery.datetimepicker.css"/>"/>
        
        
    </head>

    <body>

        
        
        <div class="jumbotron text-center">
            <h1>Sistema de Nómina</h1>
            <p>Bienvenido al proyecto final de sistema de nomina!</p> 
            <div>
                    <form action="login.htm" method="get">            
                        <input type="submit" value="INICIAR SESION" class="btn btn-primary disabled" />
                    </form>


                <!--  <form action="login.htm" method="get"> -->
                    <form action="Empleado/create.htm" method="get">
                        <input class="btn btn-primary active" type="submit" value="ENTRAR" />  
                    </form>
            </div>
        </div>
        

        
        

</body>

</html>
