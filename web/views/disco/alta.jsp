
<div style="background-color: #ffffff; margin-top:75px; margin-bottom: 15px">
  

<!-- FORMULARIO DE REGISTRO DE NUEVO DISCO-->
<div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >
    <br>
    <%  String s = (String)session.getAttribute("tipoUsuario");
        
        if(s!=null){%>
      
        <% if(session.getAttribute("mensajeExito")!= null)
        {%>
               <br><br>    
               <div class="alert alert-danger">
               <% out.print((String)session.getAttribute("mensajeExito"));
               session.setAttribute("mensajeExito", null);
               
               
               %>
               </div>     
    
     <%}else{
            
            if(s.equals("admin"))
            {%>
                <form role="form" class="form-horizontal" id="dAlta" method="post" action="dAlta.do">
                <h2 style="text-align: center;">Registro de nuevo disco</h2>
                <hr>
                <h4>Datos del disco</h4>
                <hr>

                 <div class="col-xs-8">


                 <label for="UPC" id="lblUPC">UPC:</label>
                 <input type="text" class="form-control" id="upc" name="upc"  placeholder="Introduce UPC del disco">
                 </div>
                 <br><br><br><br>


                 <div class="col-xs-8">
                 <label for="Artista" id="lblArtista">Artista:</label>
                 <input type="text" class="form-control" id="artista"  name="artista" placeholder="Ingrese el artista.">
                 </div>
                 <br><br><br><br>


                 <div class="col-xs-8">
                 <label for="album" id="lblAlbum">Album:</label>
                 <input type="text" class="form-control" placeholder="Ingrese el Album" name="album" id="album"><br>
                 </div>
                 <br><br><br><br>


                 <div class="col-xs-8">
                 <label for="genero" id="lblGenero">Género:</label>
                 <input type="text" class="form-control" placeholder="Ingrese el genero" name="genero" id="genero"><br>
                 </div>
                 <br><br><br><br>

                 <div class="col-xs-8">
                 <label for="stock" id="lblStock">Stock:</label>
                 <input type="text" class="form-control" placeholder="Ingrese Stock" name="stock" id="stock"><br>
                 </div>
                 <br><br><br><br>


                 <div class="col-xs-8">
                 <label for="descripcion" id="lblDescripcion">Descripción:</label>
                 <textarea rows="3" type="text" class="form-control" placeholder="Ingrese descripcion" name="descripcion" id="descripcion"></textarea>
                 </div>    
                 <br><br><br><br><br><br>

                <div class="col-xs-8"> 
                    <label for="precio" id="lblPrecio">Precio:</label>
                    <input type="number" value="0" min="0" step="5.0" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="precio" />
                </div>
                <br><br><br><br>

                 <div class="col-xs-8">
                 <label for="imagen" id="lblImagen">Imágen de la tapa del disco</label>
                 <input type="file" id="imagen">
                 <p class="help-block">Seleccione un archivo con extensión .jpg y no menor a: 200x200px.</p>
                 </div>
                 <br><br><br><br><br><br>
                 
                 <hr>
                 
                 
                 <h3> Canciones del disco </h3>
                 <br><br>
                 
                 <div class="col-xs-8">
                 <label for="isrc" id="lblIsrc">ISRC:</label>
                 <input type="text" class="form-control" placeholder="Ingrese ISRC" name="isrc" id="isrc"><br>
                 </div>
                 <br><br><br><br>
                 
                 <div class="col-xs-8">
                 <label for="track" id="lblTrack">Track:</label>
                 <input type="text" class="form-control" placeholder="Ingrese Track" name="track" id="track"><br>
                 </div>
                 <br><br><br><br>
                 
                 <div class="col-xs-8">
                 <label for="nombre" id="lblNombre">Nombre:</label>
                 <input type="text" class="form-control" placeholder="Ingrese Nombre" name="nombre" id="nombre"><br>
                 </div>
                 <br><br><br><br>
                 
                 <div class="col-xs-8">
                 <label for="duracion" id="lblDuracion">Duración:</label>
                 <input type="text" class="form-control" placeholder="Ingrese Duración" name="duracion" id="duracion"><br>
                 </div>
                 <br><br><br><br>
                 
                 <div class="col-xs-8">
                 <label for="precio" id="lblPrecio">Precio:</label>
                 <input type="text" class="form-control" placeholder="Ingrese Precio" name="precio" id="precio2"><br>
                 </div>
                 <br><br><br><br>
                 
                 
                 <button id="add">Añadir Canción</button>
                 
                 <br><br>
                  <!-- TABLA DE CANCIONES: RECORDAR QUE EL PRECIO DE UN DISCO ES LA CANCION DEL DISCO CON CÓDIGO = 0-->
                 <div class="table-responsive">
                 <table class="table" id="tablaCanciones">
                     <!-- CODIGO PARA EL ENCABEZADO-->
                     <tr>
                         <td><strong>ISRC</strong></td>
                         <td><strong>Track</strong></td>
                         <td><strong>Nombre</strong></td>
                         <td><strong>Duración</strong></td>
                         <td><strong>Precio</strong></td>
                     </tr>
                 </table>
                 </div>
                 <br><br>
                               
                 <button type="submit" class="btn btn-default" style="width: 220px; margin-left: 15px;">Registrar</button>
                 <br><br>

             </form>
            
            <% }else{%>
                        <h3 style="text-align: center; font-style: italic;">
                        Lo sentimos, página sólo habilitada para administradores.
                        </h3>
                        <hr> 
                
                   <%}%>
    <%}%>
    
    
        <% }else{%>     <!-- USUARIO NO LOGUEADO-->
                   

                        <h3 style="text-align: center; font-style: italic;">
                        Lo sentimos, debe iniciar sesión como administrador.
                        </h3>
                        <hr> 
                        
                    <%}%>
              
       
        
    
  </div>
</div>

    