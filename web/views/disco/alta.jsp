
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
                 <form role="form" class="form-horizontal"  method="post"  action="dAlta.do">
                <h2 style="text-align: center;">Registro de nuevo disco</h2>
                <hr>
                <h4>Datos del disco</h4>
                <hr>

                 <div class="col-xs-8">


                 <label for="UPC">UPC:</label>
                 <input type="text" class="form-control" id="upc" name="upc"  placeholder="Introduce UPC del disco">
                 </div>
                 <br><br><br><br>


                 <div class="col-xs-8">
                 <label for="Artista">Artista:</label>
                 <input type="text" class="form-control" id="artista"  name="artista" placeholder="Ingrese el artista.">
                 </div>
                 <br><br><br><br>


                 <div class="col-xs-8">
                 <label for="album">Album:</label>
                 <input type="text" class="form-control" placeholder="Ingrese el Album" name="album" id="album"><br>
                 </div>
                 <br><br><br><br>


                 <div class="col-xs-8">
                 <label for="genero">Género:</label>
                 <input type="text" class="form-control" placeholder="Ingrese el genero" name="genero" id="genero"><br>
                 </div>
                 <br><br><br><br>

                 <div class="col-xs-8">
                 <label for="stock">Stock:</label>
                 <input type="text" class="form-control" placeholder="Ingrese Stock" name="stock" id="stock"><br>
                 </div>
                 <br><br><br><br>


                 <div class="col-xs-8">
                 <label for="descripcion">Descripción:</label>
                 <input type="text" class="form-control" placeholder="Ingrese descripcion" name="descripcion" id="descripcion">
                 </div>    
                 <br><br><br><br>

                 <div class="col-xs-8">
                 <label for="precio">Precio:</label>
                 <input type="text" class="form-control" placeholder="Ingrese Precio:" name="precio" id="precio">
                 </div>    
                 <br><br><br><br>

                 <div class="col-xs-8">
                 <label for="ejemplo_archivo_1">Imágen de la tapa del disco</label>
                 <input type="file" id="ejemplo_archivo_1">
                 <p class="help-block">Seleccione un archivo con extensión .jpg y no menor a: 200x200px.</p>
                 </div>



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

    