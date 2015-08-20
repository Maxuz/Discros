<div style="margin-top: 60px; background-color: floralwhite; margin-bottom: 10px">
    <br><h2 style="text-align: center;">Tienda virtual</h2><hr>
    <div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >
      <!--  BUSQUEDA DE  -->    
        <div class="row">

        <div class="col-xs-5">
        <div class="form-group " id="formText">
        <label class="control-label">Ingrese Texto</label>
        <div class="input-group" >   
        <span class="input-group-addon"><span class="glyphicon glyphicon-text-color"></span></span>
        <input type="email" class="form-control" name="texto" id="texto" placeholder="Introduce texto">
        </div>    
        </div>
        </div>    

        <div class="col-xs-5">
        <div class="form-group" id="formTipo">
        <label for="provincia" class="control-label" >Elegir tipo de búsqueda:</label>
        <div class="input-group">
        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
        <select class="form-control" name="tipo" id="tipo" >

        <option value="">Elegir opción..</option>  
        <option value="artista">Artista</option>
        <option value="album">Album</option>
        <option value="genero">Género</option>

        </select>

        </div>
        </div>
        </div>
        <br>
        </div>   
        
      <button type="submit" class="btn btn-default"   onclick=" validaBusqueda()"> Buscar</button>
         <br> <br> <br>
        
         
         
         <!--  IMÁGENES CON LINKS PARA VER TODOS LOS DISCOS Y OBTENER LISTADO DE ARTISTAS Y GÉNEROS   -->
        <div class="row">
            
        <!-- TODOS  --> 
        <div class="col-md-4">
            <a href="t_busqueda.jsp?tipo=todos"><img class="img-responsive img-tienda"  src="img/cds.jpg" alt="todos"/>
        <h4 style="text-align: center;">Ver todos los discos.</h4></a>   
        </div>
        
        <!-- ARTISTAS -->
    	<div class="col-md-4">
            <a href="t_listas.jsp?tipo=artista"> <img class="img-responsive img-tienda" src="img/artista.jpg" alt="artistas"/>
            <h4 style="text-align: center;">Ver lista de artistas.</h4></a>   
        </div>
        
        <!-- GENEROS --> 
        <div class="col-md-4">   
         <a href="t_listas.jsp?tipo=genero"><img class="img-responsive img-tienda" src="img/album.jpg" alt="generos" />
             <h4 style="text-align: center;">Ver lista de géneros musicales.</h4></a>   
        </div>
        
        </div>
        
        <br> <br> <br><hr>
  

            
     </div>
 </div>               
