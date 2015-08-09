
<div style="background-color: floralwhite; margin-top:75px; margin-bottom: 15px">
<div class="row" >
    
    <h2 style="text-align: center;">Registro de nuevo cliente</h2>
    
    <form role="form" class="form-horizontal" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" method="post" action="usuario.do">
        
   <h4>Datos de inicio de sesión</h4>
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email" name="email"
           placeholder="Introduce tu email">
  
    <br>
    
    <label for="email2">Reescribe tu Email</label>
    <input type="email" class="form-control" id="email" name="email2" placeholder="Introduce tu email">
  
    <br>
  
    <label for="password">Contraseña</label>
    <input type="password" class="form-control" id="pass"  name="pass" placeholder="Contraseña">
 
    <br>
    
    <label for="password2">Reescribe tu Contraseña</label>
    <input type="password" class="form-control" id="pass"  name="pass2" placeholder="Contraseña">
 
    <hr>
    
     <h4>Datos personales</h4>
  
            <label for=Nombre">Ingrese su Nombre</label>
            <input type="text" class="form-control" placeholder="Nombre" name="nombre" id="nombre"><br>
            
            <label for="Apellido">Ingrese su Apellido</label>
            <input type="text" class="form-control" placeholder="Apellido" name="apellido" id="apellido"><br>
            
            <label for="DNI">Ingrese su DNI</label>
            <input type="text" class="form-control" placeholder="DNI" name="dni" id="dni"><br>
            
            <label for="Provincia">Elija su Provincia</label>
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
            
            <label for="Ciudad">Ingrese su Ciudad</label>
            <input type="text" class="form-control" placeholder="Ciudad" name="ciudad" id="ciudad"><br>
            
            <label for="Dirección">Ingrese su Dirección </label>
            <input type="text" class="form-control" placeholder="Direccion" name="direccion" id="direccion">
            <br>
           
            <input type="text" name="funcion" size="5" value="alta" hidden readonly="true"><br>
      
            <button type="submit" class="btn btn-default">Registrar</button>
    
</form>
    </div>
</div>

    