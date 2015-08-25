<div style="background-color: #ffffff; margin-top:75px; margin-bottom: 15px">
<div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >
    
    <!--T�TULO DE LA P�GINA-->
    <h2 style="text-align: center;">Registro de nuevo cliente</h2>
    <hr> 
   
    <% //VALIDA SI HAY UN USUARIO LOGUEADO EN EL SISTEMA
        if(session.getAttribute("nombre")==null){
            
            //VERIFICA SI HAY MENSAJE DE ERROR QUE DEVUELVE EL CONTROLADOR Y EN TAL CASO LO MUESTRA
            if(session.getAttribute("mensajeError")!=null)
            {%>
               <br>        
               <div class="alert alert-danger" style="text-align: center;">
               <% 
                   out.print((String)session.getAttribute("mensajeError"));
                   session.setAttribute("mensajeError", null);
                %>
               </div>
            <%}%>
            
                <!-- FORMULARIO DE REGISTRO DE NUEVO CLIENTE-->
                <form role="form" class="form-horizontal"  method="post"  onsubmit="validaAlta(event)" action="uAlta.do" >
                <h4>Datos de inicio de sesi�n</h4>
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
                <label id="lblPass" for="password">Contrase�a:</label>
                <input type="password" class="form-control" id="pass"  name="pass" placeholder="Contrase�a">
                </div>
                <br><br><br><br>

                <div class="col-xs-8">
                <label id="lblPass2" for="password2">Reescribe tu Contrase�a:</label>
                <input type="password" class="form-control" id="pass2"  name="pass2" placeholder="Contrase�a">
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
                        <option value="C�rdoba">C�rdoba</option>
                        <option value="Corrientes">Corrientes</option>
                        <option value="Entre R�os">Entre R�os</option>
                        <option value="Formosa">Formosa</option>
                        <option value="Jujuy">Jujuy</option>
                        <option value="La Pampa">La Pampa</option>
                        <option value="La Rioja">La Rioja</option>
                        <option value="Mendoza">Mendoza</option>
                        <option value="Misiones">Misiones</option>
                        <option value="Nequ�n">Nequ�n</option>
                        <option value="R�o Negro">R�o Negro</option>
                        <option value="Salta">Salta</option>
                        <option value="San Juan">San Juan</option>
                        <option value="San Luis">San Luis</option>
                        <option value="Santa Cr�z">Santa Cr�z</option>
                        <option value="Santa Fe">Santa Fe</option>
                        <option value="Santiago del Estero">Santiago del Estero</option>
                        <option value="Tierra del Fuego">Tierra del Fuego</option>
                        <option value="Tucum�n">Tucum�n</option>
                        </select><br>
                </div>
                <br><br><br><br>

                <div class="col-xs-8">
                <label id="lblCiudad" for="Ciudad">Ingrese su Ciudad:</label>
                <input type="text" class="form-control" placeholder="Ciudad" name="ciudad" id="ciudad">
                </div>
                <br><br><br><br>

                <div class="col-xs-8">
                <label id="lblDireccion" for="Direcci�n">Ingrese su Direcci�n:</label>
                <input type="text" class="form-control" placeholder="Direccion" name="direccion" id="direccion">
                </div>    
                <br><br><br><br>
    
                <button type="submit" class="btn btn-default" style="width: 220px; margin-left: 15px;">Registrar</button>
                <br><br>
            </form>
    
    
       <% }else{
                
                //VERIFICA SI HAY MENSAJE DE �XITO
                if(session.getAttribute("mensajeExito")!=null)
                {%>
                        <!-- USUARIO RECI�N LOGUEADO-->
                       <br>        
                       <div class="alert alert-success" style="text-align: center;">
                        <% 
                           out.print((String)session.getAttribute("mensajeExito"));
                           session.setAttribute("mensajeExito", null);
                        %>
                        </div>
                        <hr>
                        <a href="index.jsp"><strong>Ir al inicio..</strong></a>    
                        <br><br>
                
              <%}else{%>
                        <!-- YA HAY UN USUARIO LOGUEADO EN EL SISTEMA-->
                        <div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >

                        <h3 style="text-align: center; font-style: italic;">Hay un usuario logueado, por favor cierra la sesi�n y vuelve a intentarlo.</h3>
                        <hr> 
                        </div>
                    <%}
              }%>
</div>  
</div>

    