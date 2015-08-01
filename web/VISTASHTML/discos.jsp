
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
            <h1>OBTENER UN DISCO DE LA BASE DE DATOS (getOne)</h1>
            <form method="post" action="discos.do">
             
            Ingrese UPC:
            <input type="text" name="upc" size="20"><br>
                              
            <input type="text" name="funcion" size="5" value="getOne" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        <hr>
        <!-- FORMULARIO DE REGISTRO DE DISCO-->
        <div><h1>ALTA DISCO</h1>
            <form method="post" action="discos.do">
             
            Ingrese UPC
            <input type="text" name="upc" size="20"><br><br>
         
            Ingrese Artista:
            <input type="text" name="artista" size="20"><br><br>
            
            Ingrese Album:
            <input type="text" name="album" size="20"><br><br>
            
            Ingrese Genero:
            <input type="text" name="genero" size="20"><br><br>
            
            Ingrese Stock:
            <input type="text" name="stock" size="20"><br><br>
            
            Ingrese Descripción:
            <input type="text" name="descripcion" size="20"><br><br>
            
            Ingrese el Precio:
            <input type="text" name="precio" size="20"><br><br>
            
            Ingrese URL Imagen:
            <input type="text" name="imagen" size="20"><br>
            
            
            
            <input type="text" name="funcion" size="5" value="alta" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        
        <!-- FORMULARIO DE BAJA DE DISCO-->
        <div><hr>
            
            <!-- 
            MÉTODO QUE EN REALIDAD PODRÍA NO SER UNA BAJA LITERAL DE LA BASE DE DATOS, DEBIDO A QUE
            PUEDE HABER PROBLEMAS CON LA BASE DE DATOS Y LAS CLAVES FORÁNEAS SI SE DESEA ELIMINAR UN DISCO
            QUE FUE VENDIDO.
            
            SE PODRÍA RESOLVER CON UN ATRIBUTO ""ESTADO"" EN EL DISCO
            Y QUE LA BAJA LITERAL DEL DISCO LA REALICE UN ADMINISTRADOR DE BD.
            -->
            <h1>BAJA DISCO</h1>
            <h5 style="font-style: italic;">Cuando se borra un disco, se borran también todas las canciones del mismo.</h5>
            <form method="post" action="discos.do">
             
            Ingrese UPC:
            <input type="text" name="upc" size="20"><br>
                              
            <input type="text" name="funcion" size="5" value="baja" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        <hr>
        
         <!-- FORMULARIO DE REGISTRO DE DISCO-->
        <div><h1>MODIFICAR DISCO</h1>
            <form method="post" action="discos.do">
             
            Ingrese UPC
            <input type="text" name="upc" size="20"><br><br>
         
            Ingrese Artista:
            <input type="text" name="artista" size="20"><br><br>
            
            Ingrese Album:
            <input type="text" name="album" size="20"><br><br>
            
            Ingrese Genero:
            <input type="text" name="genero" size="20"><br><br>
            
            Ingrese Stock:
            <input type="text" name="stock" size="20"><br><br>
            
            Ingrese el Precio:
            <input type="text" name="precio" size="20"><br><br>
            
            Ingrese Descripción:
            <input type="text" name="descripcion" size="20"><br><br>
            
            Ingrese URL Imagen:
            <input type="text" name="imagen" size="20"><br>
            
            <input type="text" name="funcion" size="5" value="modificar" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        
    </body>
</html>
