<%-- 
    Document   : pedidos
    Created on : 29-jul-2015, 0:21:22
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
            <h1>OBTENER UN PEDIDO DE LA BASE DE DATOS (getOne)</h1>
            <form method="post" action="pedidos.do">
             
            Ingrese ID:
            <input type="text" name="id" size="20"><br><br>
                                        
            <input type="text" name="funcion" size="5" value="getOne" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        <hr>
        
        <!-- FORMULARIO DE REGISTRO DE PEDIDO-->
        <div><h1>ALTA PEDIDO</h1>
            <form method="post" action="pedidos.do">
             
            Ingrese ID:
            <input type="text" name="id" size="20"><br><br>
         
            Ingrese EMAIL:
            <input type="text" name="email" size="20"><br><br>
               
            Ingrese Valor:
            <input type="text" name="valor" size="20"><br><br>
            
            Ingrese Estado:
            <input type="text" name="estado" size="20"><br><br>
            
            Ingrese Fecha que caduca:
            <input type="text" name="fecha" size="20"><br><br>
            
                          
            <input type="text" name="funcion" size="5" value="alta" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        <hr>
        
        <!-- FORMULARIO DE BAJA DE CANCION-->
        <div>
            <h1>BAJA PEDIDO</h1>
            <form method="post" action="pedidos.do">
             
            Ingrese ID:
            <input type="text" name="id" size="20"><br><br>
                    
            <input type="text" name="funcion" size="5" value="baja" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        <hr>
        
         <!-- FORMULARIO DE MODIFICACIÓN DE DISCO-->
        <div><h1>MODIFICAR PEDIDO</h1>
            <form method="post" action="pedidos.do">
             
            Ingrese ID:
            <input type="text" name="id" size="20"><br><br>
         
            Ingrese EMAIL:
            <input type="text" name="email" size="20"><br><br>
               
            Ingrese Valor:
            <input type="text" name="valor" size="20"><br><br>
            
            Ingrese Estado:
            <input type="text" name="estado" size="20"><br><br>
            
            Ingrese Fecha que caduca:
            <input type="text" name="fecha" size="20"><br><br>
           
            <input type="text" name="funcion" size="5" value="modificar" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
        </div>
        
        
    </body>
</html>
