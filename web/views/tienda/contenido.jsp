<div style="margin-top: 60px; background-color: floralwhite; margin-bottom: 10px">
    <br><h2 style="text-align: center;">Tienda virtual</h2>
    <div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >
    
        <div class="row">
            
        <!-- TODOS  --> 
        <div class="col-md-4">
            <a href="t_busqueda.jsp?tipolista=todos"><img class="img-responsive img-tienda"  src="img/cds.jpg" alt="todos"/>
        <h4 style="text-align: center;">Ver todos los discos.</h4></a>   
        </div>
        
        <!-- ARTISTAS -->
    	<div class="col-md-4">
            <a href="t_listas.jsp?tipolista=artista"> <img class="img-responsive img-tienda" src="img/artista.jpg" alt="artistas"/>
            <h4 style="text-align: center;">Ver lista de artistas.</h4></a>   
        </div>
        
        <!-- GENEROS --> 
        <div class="col-md-4">   
         <a href="t_listas.jsp?tipolista=genero"><img class="img-responsive img-tienda" src="img/album.jpg" alt="generos" />
             <h4 style="text-align: center;">Ver lista de géneros musicales.</h4></a>   
        </div>
        
        </div>
    
    
    
    
    
    
    <h3>Realizar una búsqueda específica</h3>
    <hr>
    <form role="form" id="login" method="post" onsubmit="" action="">

            <div class="col-xs-8">
            <label id="lblEmail" for="lEmail">Ingrese Texto</label>
            <input type="email" class="form-control" name="email" id="email" placeholder="Introduce texto">
            </div>
            <br><br><br><br>

            <div class="col-xs-8">
            <label id="lblProvincia" for="Provincia">Elegir tipo de búsqueda:</label>
            <select class="form-control" name="provincia" id="provincia" >

            <option> Elegir opción.. </option>  
            <option value="Santa Crúz">Artista</option>
            <option value="Tierra del Fuego">Album</option>
            <option value="Santa Fe">Género</option>
            
            </select><br>
            </div>
            <br><br><br><br>

            <button type="submit" class="btn btn-default">Buscar</button>
            <br><br><br><br>
           
           <div>
           <!--DIV PARA MOSTRAR ERRORES-->
           <div id="divError" class="alert alert-danger hidden"></div>


           </div>
           </form>

              
</div>               
</div>                