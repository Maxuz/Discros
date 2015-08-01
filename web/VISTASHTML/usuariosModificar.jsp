<%-- 
    Document   : usuariosModificar
    Created on : 23-jul-2015, 18:32:27
    Author     : Dormitorio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <!-- FORMULARIO DE MODIFICACION DE USUARIO-->
        <div>
            <h3><a href="usuarios.jsp">Volver.. </a></h3>
            <hr>
            <h1>MODIFICAR DATOS DE USUARIO</h1>
            <form method="post" action="usuario.do">
             
            <h5>Datos de inicio de sesión</h5>
            Correo electrónico:
            <input type="text" name="nombre" size="20" value="<% out.print((String)session.getAttribute("email")); %>" disabled="disabled"> 
            <div style="font-style: italic"> No se puede modificar</div><br><br>
            
            Ingrese Clave Anterior:
            <input type="password" name="passAnterior" size="20"><br><br>            
            Ingrese Clave Nueva:
            <input type="password" name="pass" size="20"><br><br>
            
            <hr style="color: gray;">
            <h5>Datos personales</h5>
            Ingrese Nombre:
            
           
            <input type="text" name="nombre" size="20" value="<% out.print((String)session.getAttribute("nombre")); %>"><br><br>
            
           
            Ingrese Apellido:
            <input type="text" name="apellido" size="20" value="<% out.print((String)session.getAttribute("apellido")); %>"><br><br>
            
            Ingrese DNI:
            <input type="text" name="dni" size="20" ><br><br>
            
            Ingrese Dirección:
            <input type="text" name="direccion" size="20" value="<% out.print((String)session.getAttribute("direccion")); %>"><br><br>
            
            Ingrese Ciudad:
            <input type="text" name="ciudad" size="20" value="<% out.print((String)session.getAttribute("ciudad")); %>"><br><br>
            
            Ingrese Provincia:
            <input type="text" name="provincia" size="20" value="<% out.print((String)session.getAttribute("provincia")); %>"><br><br>
            
            
            
            <input type="text" name="funcion" size="5" value="modificar" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
            
        </div>
        
    </body>
</html>
