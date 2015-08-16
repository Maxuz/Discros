
<div style="background-color: #ffffff; margin-top:75px; margin-bottom: 15px">
  

<!-- FORMULARIO DE REGISTRO DE NUEVO CLIENTE-->
<div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >
    
    
    <h2 style="text-align: center;">Registro de nuevo cliente</h2>
    <hr> 
   
   <form role="form" class="form-horizontal"  method="post"  onsubmit="validaAlta(event)" action="uAlta.do" >
      <% if(session.getAttribute("nombre")==null){%>

    <% if(session.getAttribute("mensajeExito")!= null)
    {%>
           <br><br><br>        
           <div class="alert alert-danger">
           <% out.print((String)session.getAttribute("mensajeExito"));
           session.setAttribute("mensajeExito", null);
           %>
           </div>     
    
   <% }%>
   <h4>Datos de inicio de sesión</h4>
   <hr>
   
    <div class="col-xs-8">
          
    
     <label for="email" id="lblemail1">Email:</label>
    <input type="email" class="form-control" id="email" name="email"  placeholder="Introduce tu email">
    </div>
    <br><br><br><br>
    
    
    <div class="col-xs-8">
    <label id="lblemail2" for="email2">Reescribe tu Email:</label>
    <input type="email" class="form-control" id="email2" name="email2" placeholder="Introduce tu email">
    </div> 
     
    <br><br><br><br>
  
    
    <div class="col-xs-8">
    <label id="lblPass" for="password">Contraseña:</label>
    <input type="password" class="form-control" id="pass"  name="pass" placeholder="Contraseña">
    </div>
    <br><br><br><br>
    
    
    <div class="col-xs-8">
    <label id="lblPass2" for="password2">Reescribe tu Contraseña:</label>
    <input type="password" class="form-control" id="pass2"  name="pass2" placeholder="Contraseña">
    </div>
    <br><br><br><br>
    <hr>
    
     <h4>Datos personales</h4>
     <hr>
     
    <div class="col-xs-8">
    <label id="lblNombre" for="Nombre">Ingrese su Nombre:</label>
    <input type="text" class="form-control" placeholder="Nombre" name="nombre" id="nombre"><br>
    </div>
    <br><br><br><br>
           
    
    <div class="col-xs-8">
    <label id="lblApellido" for="Apellido">Ingrese su Apellido:</label>
    <input type="text" class="form-control" placeholder="Apellido" name="apellido" id="apellido"><br>
    </div>
    <br><br><br><br>
            
    <div class="col-xs-8">
    <label id="lblDni" for="DNI">Ingrese su DNI:</label>
    <input type="text" class="form-control" placeholder="DNI" name="dni" id="dni"><br>
    </div>
    <br><br><br><br>
            
    <div class="col-xs-8">
    <label id="lblProvincia" for="Provincia">Elija su Provincia:</label>
    <select class="form-control" name="provincia" id="provincia" >
            
            <option> Elegir provincia.. </option>  
            <option value="Buenos Aires">Buenos Aires</option>
            <option value="Catamarca">Catamarca</option>
            <option value="Capital Federal">Capital Federal</option>
            <option value="Chaco">Chaco</option>
            <option value="Chubut">Chubut</option>
            <option value="Córdoba">Córdoba</option>
            <option value="Corrientes">Corrientes</option>
            <option value="Entre Ríos">Entre Ríos</option>
            <option value="Formosa">Formosa</option>
            <option value="Jujuy">Jujuy</option>
            <option value="La Pampa">La Pampa</option>
            <option value="La Rioja">La Rioja</option>
            <option value="Mendoza">Mendoza</option>
            <option value="Misiones">Misiones</option>
            <option value="Nequén">Nequén</option>
            <option value="Río Negro">Río Negro</option>
            <option value="Salta">Salta</option>
            <option value="San Juan">San Juan</option>
            <option value="San Luis">San Luis</option>
            <option value="Santa Crúz">Santa Crúz</option>
            <option value="Santa Fe">Santa Fe</option>
            <option value="Santiago del Estero">Santiago del Estero</option>
            <option value="Tierra del Fuego">Tierra del Fuego</option>
            <option value="Tucumán">Tucumán</option>
            </select><br>
    </div>
    <br><br><br><br>
      
    
    <div class="col-xs-8">
    <label id="lblCiudad" for="Ciudad">Ingrese su Ciudad:</label>
    <input type="text" class="form-control" placeholder="Ciudad" name="ciudad" id="ciudad">
    </div>
    <br><br><br><br>
      
    
    <div class="col-xs-8">
    <label id="lblDireccion" for="Dirección">Ingrese su Dirección:</label>
    <input type="text" class="form-control" placeholder="Direccion" name="direccion" id="direccion">
    </div>    
    <br><br><br><br>
            
                
    <button type="submit" class="btn btn-default" style="width: 220px; margin-left: 15px;">Registrar</button>
    <br><br>
   
</form>
    </div>
    
       <% }else{
                if(session.getAttribute("mensajeExito")!=null)
                {%>
                        <!-- USUARIO RECIÉN LOGUEADO-->
                        <div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >
                            <br><br><br>        
                            <div class="alert alert-success">
                                <% out.print((String)session.getAttribute("mensajeExito"));
                                    session.setAttribute("mensajeExito", null);
                                    %>
                                
                            </div>
                                <br><br>
                                <a href="index.jsp"><strong>Ir al inicio..</strong></a>    
                                <br><br>
                        
                        </div>
                
              <%}else{%>
                        <!-- USUARIO LOGUEADO-->
                        <div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >

                        <h3 style="text-align: center; font-style: italic;">Hay un usuario logueado, por favor cierra la sesión y vuelve a intentarlo.</h3>
                        <hr> 
                        </div>
                    <%}%>
              <%}
    %>
       
        
    
  
</div>

    