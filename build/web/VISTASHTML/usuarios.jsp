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
        
        <!-- FORMULARIO DE LOGOUT-->
        <div>
            
            <% 
                if((String)session.getAttribute("email")==null)
                {out.print("<h4>SESIÓN SIN INICAR </h4>");
                }else{out.print("<h4>SESIÓN INICIADA POR:  </h4>"+(String)session.getAttribute("email")+" <br><a href=\"usuariosModificar.jsp\">Modificar datos</a>");%>
                 <form method="post" action="usuario.do">
                 <input type="text" name="funcion" size="5" value="logout" hidden><br>
                 <input type="submit" value="Cerrar sesion">
                   </form>
                <%}
            %>
                
           
                 <hr>
        </div>
        
                
        <h5 style="font-style: italic;">Las validaciones de los campos de ingresos se harán el el frontend en la última etapa del proyecto.</h5>
        <hr>
        
        
        <!-- FORMULARIO DE INGRESO DE USUARIO-->
        <div>
            <h1>LOGIN</h1>
            <form method="post" action="usuario.do">
                
            Ingrese Email:
            <input type="text" name="email" size="20"><br><br>
            
            Ingrese Clave:
            <input type="password" name="pass" size="20"><br>
            
            <input type="text" name="funcion" size="5" value="login" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
            
            
            
            
        </div>
        <hr>
        <!-- FORMULARIO DE REGISTRO DE USUARIO-->
        <div>
            
            <h1>ALTA USUARIO</h1>
            <form method="post" action="usuario.do">
             
            <h5>Datos de inicio de sesión</h5>
            Ingrese Email:
            <input type="text" name="email" size="20"><br><br>
            
            Ingrese Clave:
            <input type="password" name="pass" size="20"><br><br>
            
            <hr style="color: gray;">
            <h5>Datos personales</h5>
            Ingrese Nombre:
            <input type="text" name="nombre" size="20"><br><br>
            
            Ingrese Apellido:
            <input type="text" name="apellido" size="20"><br><br>
            
            Ingrese DNI:
            <input type="text" name="dni" size="20"><br><br>
            
            Ingrese Dirección:
            <input type="text" name="direccion" size="20"><br><br>
            
            Ingrese Ciudad:
            <input type="text" name="ciudad" size="20"><br><br>
            
            Ingrese Provincia:
            <input type="text" name="provincia" size="20"><br><br>
            
            
            
            <input type="text" name="funcion" size="5" value="alta" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
            
        </div>
        <hr>
          <!-- TABLA CON TODOS LOS USUARIOS-->
        <div>
            
            
            
        </div>
        
        <!-- ELIMINAR USUARIOS-->
        <div>
            
             
            
            <h1>BAJA USUARIO</h1>
            <form method="post" action="usuario.do">
                
            Ingrese Email:
            <input type="text" name="email" size="20"><br><br>
            
            Ingrese Clave:
            <input type="password" name="pass" size="20"><br>
            
            <input type="text" name="funcion" size="5" value="baja" hidden><br>
         
            <input type="submit" value="Confirmar">
            
            </form>
            
        </div>
        
       <!-- MODIFICAR UN USUARIO DE LA LISTA-->
        <div>
            
            
            
        </div>
        
    </body>
</html>
