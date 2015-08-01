<%-- 
    Document   : ped_prod
    Created on : 29-jul-2015, 0:48:08
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
        <h3><a href="index.jsp">VOLVER..</a></h3>
        <hr>
        
        <!-- FORMULARIO: GETONE-->
        <div>
            <h1>OBTENER UN ÍTEM DE PEDIDO DE LA BASE DE DATOS (getOne)</h1>
            <form method="post" action="pedidoscanciones.do.do">
             
            Ingrese ID Pedido:
            <input type="text" name="id_pedido" size="20"><br><br>
            Ingrese UPC del Disco:
            <input type="text" name="upc" size="20"><br><br>                     
            Ingrese ISRC de la Cancion:
            <input type="text" name="isrc" size="20"><br><br>
         
            <input type="text" name="funcion" size="5" value="getOne" hidden><br>
            
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        <hr>
        
         <!-- FORMULARIO DE REGISTRO DE ÍTEM DE PEDIDO-->
        <div><h1>ALTA PEDIDO</h1>
            
            <form method="post" action="pedidoscanciones.do">
             
            Ingrese ID Pedido:
            <input type="text" name="id_pedido" size="20"><br><br>
            Ingrese UPC del Disco:
            <input type="text" name="upc" size="20"><br><br>                     
            Ingrese ISRC de la Cancion:
            <input type="text" name="isrc" size="20"><br><br>
            
            <h5 style="font-style: italic;">En el caso que sea sólo el disco lo que se vaya a cargar.. </h5>
            Ingrese Cantidad de Discos:
            <input type="text" name="isrc" size="20"><br><br>
            
                          
            <input type="text" name="funcion" size="5" value="alta" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        <hr>
        
        
    </body>
</html>
