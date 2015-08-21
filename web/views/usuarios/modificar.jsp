<%@page import="Actions.Usuarios.UsuariosFunciones"%>
<%@page import="Model.Usuario"%>
<% 
    String nombre = (String)session.getAttribute("nombre");
    
    if(nombre==null)
    {%>
        <div class="row" style="margin-top: 80px; background-color: #ffffff; margin-bottom: 15px;">
            <br>
            <img class="img-responsive" src="img/userunknow.png" style="margin:auto;"/>
            <h3 style="text-align:center;"> NO HAY USUARIO LOGUEADO </h3><br><br><br><br><br><br><br><br>
        </div>
        
    <% } else{
%>
<div style="background-color: #ffffff; margin-top:75px; margin-bottom: 15px">
    <div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >
        
        <h2 style="text-align: center;"> Modificar datos de usuario</h2>

        <!--FORMILARIO MODIFICAR USUARIO-->
        
        <%
            UsuariosFunciones funciones = new UsuariosFunciones();
            Usuario usu = funciones.getOne((String)session.getAttribute("email"));
        %>
        
        <hr> 
        <form role="form" class="form-horizontal"  method="post" onsubmit="validaModificar(event)" action="uModificar.do" >
            <% //if(session.getAttribute("nombre")==null){%>
      
            <h4>Datos del usuario</h4>
            <hr>
            <div class="col-xs-8">
                <label for="email" id="lblemail1">Email:</label>
                <input readonly type="email" class="form-control" id="email" name="email" placeholder="Introduce tu email" value="<%= usu.getEmail() %>">
            </div>
            <br><br><br><br>

            <a onclick="show('changePass')" style="cursor: pointer">Cambiar Contrase&ntilde;a</a>
            <div id="changePass" style="display: none">
                <br>
                <div class="col-xs-8">
                    <label id="lblPassVieja" for="password">Contraseña Vieja:</label>
                    <input type="password" class="form-control" id="passVieja" name="passVieja" placeholder="Contraseña">
                </div>
                <br><br><br><br>

                <div class="col-xs-8">
                    <label id="lblPass" for="password2">Contraseña Nueva:</label>
                    <input type="password" class="form-control" id="pass" name="pass" placeholder="Contraseña">
                </div>
                <br><br><br><br>

                <div class="col-xs-8">
                    <label id="lblPass2" for="password2">Reescribe la Contraseña Nueva:</label>
                    <input type="password" class="form-control" id="pass2" name="pass2" placeholder="Contraseña">
                </div>
                <br><br>
            </div>
            <script type="text/javascript">
            function show(id)
            {
                var obj = document.getElementById(id);
                obj.style.display = (obj.style.display === 'none') ? 'block' : 'none';
            }
            </script>
            <br><br>
            <hr>
    
            <h4>Datos personales</h4>
            <hr>
     
            <div class="col-xs-8">
                <label id="lblNombre" for="Nombre">Ingrese su Nombre:</label>
                <input type="text" class="form-control" placeholder="Nombre" name="nombre" id="nombre" value="<%= usu.getNombre() %>"><br>
            </div>
            <br><br><br><br>
    
            <div class="col-xs-8">
                <label id="lblApellido" for="Apellido">Ingrese su Apellido:</label>
                <input type="text" class="form-control" placeholder="Apellido" name="apellido" id="apellido" value="<%= usu.getApellido() %>"><br>
            </div>
            <br><br><br><br>
            
            <div class="col-xs-8">
                <label id="lblDni" for="DNI">Ingrese su DNI:</label>
                <input type="text" class="form-control" placeholder="DNI" name="dni" id="dni" value="<%= usu.getdni()%>"><br>
            </div>
            <br><br><br><br>
            
            <div class="col-xs-8">
                <label id="lblProvincia" for="Provincia">Elija su Provincia:</label>
                <select class="form-control" name="provincia" id="provincia" value="<%= usu.getProvincia()%>">
                    <option value="" <% if(usu.getProvincia().equals("")){ %>selected="selected"<% } %>>Seleccione opci&oacute;n</option>
                    <option value="Buenos Aires" <% if(usu.getProvincia().equals("Catamarca")){ %>selected="selected"<% } %>>Buenos Aires</option>
                    <option value="Catamarca" <% if(usu.getProvincia().equals("Catamarca")){ %>selected="selected"<% } %>>Catamarca</option>
                    <option value="Capital Federal" <% if(usu.getProvincia().equals("Capital Federal")){ %>selected="selected"<% } %>>Capital Federal</option>
                    <option value="Chaco" <% if(usu.getProvincia().equals("Chaco")){ %>selected="selected"<% } %>>Chaco</option>
                    <option value="Chubut" <% if(usu.getProvincia().equals("Chubut")){ %>selected="selected"<% } %>>Chubut</option>
                    <option value="Córdoba" <% if(usu.getProvincia().equals("Córdoba")){ %>selected="selected"<% } %>>Córdoba</option>
                    <option value="Corrientes" <% if(usu.getProvincia().equals("Corrientes")){ %>selected="selected"<% } %>>Corrientes</option>
                    <option value="Entre Ríos" <% if(usu.getProvincia().equals("Entre Ríos")){ %>selected="selected"<% } %>>Entre Ríos</option>
                    <option value="Formosa" <% if(usu.getProvincia().equals("Formosa")){ %>selected="selected"<% } %>>Formosa</option>
                    <option value="Jujuy" <% if(usu.getProvincia().equals("Jujuy")){ %>selected="selected"<% } %>>Jujuy</option>
                    <option value="La Pampa" <% if(usu.getProvincia().equals("La Pampa")){ %>selected="selected"<% } %>>La Pampa</option>
                    <option value="La Rioja" <% if(usu.getProvincia().equals("La Rioja")){ %>selected="selected"<% } %>>La Rioja</option>
                    <option value="Mendoza" <% if(usu.getProvincia().equals("Mendoza")){ %>selected="selected"<% } %>>Mendoza</option>
                    <option value="Misiones" <% if(usu.getProvincia().equals("Misiones")){ %>selected="selected"<% } %>>Misiones</option>
                    <option value="Nequén" <% if(usu.getProvincia().equals("Nequén")){ %>selected="selected"<% } %>>Nequén</option>
                    <option value="Río Negro" <% if(usu.getProvincia().equals("Río Negro")){ %>selected="selected"<% } %>>Río Negro</option>
                    <option value="Salta" <% if(usu.getProvincia().equals("Salta")){ %>selected="selected"<% } %>>Salta</option>
                    <option value="San Juan" <% if(usu.getProvincia().equals("San Juan")){ %>selected="selected"<% } %>>San Juan</option>
                    <option value="San Luis" <% if(usu.getProvincia().equals("San Luis")){ %>selected="selected"<% } %>>San Luis</option>
                    <option value="Santa Crúz" <% if(usu.getProvincia().equals("Santa Crúz")){ %>selected="selected"<% } %>>Santa Crúz</option>
                    <option value="Santa Fe" <% if(usu.getProvincia().equals("Santa Fe")){ %>selected="selected"<% } %>>Santa Fe</option>
                    <option value="Santiago del Estero" <% if(usu.getProvincia().equals("Santiago del Estero")){ %>selected="selected"<% } %>>Santiago del Estero</option>
                    <option value="Tierra del Fuego" <% if(usu.getProvincia().equals("Tierra del Fuego")){ %>selected="selected"<% } %>>Tierra del Fuego</option>
                    <option value="Tucumán" <% if(usu.getProvincia().equals("Tucumán")){ %>selected="selected"<% } %>>Tucumán</option>
                </select><br>
            </div>
            <br><br><br><br>
            <div class="col-xs-8">
                <label id="lblCiudad" for="Ciudad">Ingrese su Ciudad:</label>
                <input type="text" class="form-control" placeholder="Ciudad" name="ciudad" id="ciudad" value="<%= usu.getCiudad()%>">
            </div>
            <br><br><br><br>

            <div class="col-xs-8">
                <label id="lblDireccion" for="Dirección">Ingrese su Dirección:</label>
                <input type="text" class="form-control" placeholder="Direccion" name="direccion" id="direccion" value="<%= usu.getDireccion()%>">
            </div>    
            <br><br><br><br>
                
            <button type="submit" class="btn btn-default" style="width: 220px; margin-left: 15px;">Terminar</button>
            <br><br>
   
        </form>
    </div>
</div>

<% } %>