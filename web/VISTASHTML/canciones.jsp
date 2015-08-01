<%-- 
    Document   : canciones
    Created on : 28-jul-2015, 14:43:08
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
        <h3><a href="productos.jsp">VOLVER..</a></h3>
        <hr>
         <!-- FORMULARIO: GETONE-->
        <div>
            <h1>OBTENER UNA CANCIÓN DE LA BASE DE DATOS (getOne)</h1>
            <form method="post" action="canciones.do">
             
            Ingrese UPC:
            <input type="text" name="upc" size="20"><br><br>
            
            Ingrese ISRC:
            <input type="text" name="isrc" size="20"><br>
                              
            <input type="text" name="funcion" size="5" value="getOne" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        <hr>
        
        <!-- FORMULARIO DE REGISTRO DE CANCION-->
        <div><h1>ALTA CANCION</h1>
            <form method="post" action="canciones.do">
             
            Ingrese UPC
            <input type="text" name="upc" size="20"><br><br>
         
            Ingrese ISRC:
            <input type="text" name="isrc" size="20"><br><br>
               
            Ingrese Nombre:
            <input type="text" name="nombre" size="20"><br><br>
            
            Ingrese Track:
            <input type="text" name="track" size="20"><br><br>
            
            Ingrese Duración:
            <input type="text" name="duracion" size="20"><br><br>
            
            Ingrese Precio:
            <input type="text" name="precio" size="20"><br><br>
           
              
            <input type="text" name="funcion" size="5" value="alta" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        <hr>
        
        <!-- FORMULARIO DE BAJA DE CANCION-->
        <div>
            <h1>BAJA CANCION</h1>
            <form method="post" action="canciones.do">
             
            Ingrese UPC:
            <input type="text" name="upc" size="20"><br><br>
            
            Ingrese ISRC:
            <input type="text" name="isrc" size="20"><br>
                              
            <input type="text" name="funcion" size="5" value="baja" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        <hr>
        
         <!-- FORMULARIO DE MODIFICACIÓN DE DISCO-->
        <div><h1>MODIFICAR DISCO</h1>
            <form method="post" action="canciones.do">
             
            Ingrese UPC
            <input type="text" name="upc" size="20"><br><br>
         
            Ingrese ISRC:
            <input type="text" name="isrc" size="20"><br><br>
                  
            Ingrese Nombre:
            <input type="text" name="nombre" size="20"><br><br>
            
            Ingrese Track:
            <input type="text" name="track" size="20"><br><br>
            
            Ingrese Duración:
            <input type="text" name="duracion" size="20"><br><br>
            
            Ingrese Precio:
            <input type="text" name="precio" size="20"><br><br>
           
            <input type="text" name="funcion" size="5" value="modificar" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        
    </body>
</html>
