<%@page import="Actions.Canciones.CancionesFunciones"%>
<%@page import="java.util.*"%>
<%@page import="Actions.Util"%>
<%@page import="Model.Disco"%>
<%@page import="Actions.Discos.DiscosFunciones"%>

<div style="margin-top: 60px; background-color: #FFF; margin-bottom: 10px">
    <br><h2 style="text-align: center;">Resultados de la búsqueda</h2>
    <div style="margin-left:  15px;"><a href="javascript:window.history.back();"><h4>&laquo; Volver atrás</h4></a></div> <hr>
    
    
    <!-- CÓDIGO PARA CARGAR EL ARRAY DE LOS DISCOS -->
    <%  
     
    //VARIABLES PARA LAS SOLICITUDES A LA BASE DE DATOS
    DiscosFunciones funciones = new DiscosFunciones();
    CancionesFunciones funcionesCanciones = new CancionesFunciones();

    //VARIABLES DE DISCOS
    Disco dis = new Disco();
    ArrayList<Model.Disco> lista = new ArrayList<Model.Disco>();

    //VARIABLES AUXILIARES
    boolean ctrlTipo = false;

    //RECUPERA PARÁMETRO DE LA URL
    String tipo = (String)request.getParameter("tipo");
    
    
    
    //SEGÚN EL TIPO RECIBIDO REALIZA LA CONSULTA PERTINENTE
        Util util = new Util();
        int tipoInt = util.getInt(tipo);
        
        switch(tipoInt) {
            //TODOS           
            case 1:
                lista=funciones.getAll();
                break;
            //ARTISTA    
            case 2:
                lista=funciones.getAll();
                break;
            //ALBUM    
            case 3:
                 
                break;
            //GENERO
            case 4:
                 
                break;
            //TIPO INCORRECTO
            case 0:
              
                break;
           
       }
    
    
    %>
    
    <!-- CÓDIGO QUE REALIZA EL CONTROL DE LA CARGA DE LA LISTA DE DISCOS-->
    <% 
       
    int i;
    int f = lista.size();


    if(ctrlTipo)
    {%> <!-- HTML PARA UN TIPO DE BÚSQUEDA INCORRECTO -->
        ENTRA EN IF
        
    <%}else{
            if(f==0)
            {%><!-- HTML PARA UN RESULTADO DE BÚSQUEDA VACÍO -->
            ENTRA EN ELSE/IF
            
            <%}else{%>
                
            <h4 style="font-style: italic; margin-left:  20px">Cantidad de resultados: <%out.print(f);;%></h4>
                <ul id="cd-gallery-items" class="cd-container" style="padding-top: 20px;">
			
                   <%  
                        for(i=0;i<f;i++) 
                        { dis = lista.get(i); 
                          double precio = funcionesCanciones.getOne(dis.getUpc(), 0).getPrecio();
                            %>
                             <li>
                                 <img src="img/thumb.jpg" alt="Preview image" class="img-responsive" style=" float: left;" >
                                 <div class="texto-tienda" style="text-align: left;" id="disco">
                                     
                                     <strong>Artista:</strong><%out.print(dis.getArtista());%><br>
                                     <strong>Album:</strong><%out.print(dis.getAlbum());%> <br>
                                     <strong>Precio:</strong>  $<%out.print(precio);%> <br>
                                     <strong>Stock:</strong><%out.print(dis.getStock());%> <br>
                                     <strong>CANTIDAD:</strong>
                                     <input type="number" value="0" min="0" step="5.0" data-number-to-fixed="2" 
                                            data-number-stepfactor="100" 
                                            class="form-control currency" id="cantidad" name="precio" />
                                            <a href="#">Ver canciones..</a><br><br>
                                    
                                     <button id="agregarItem" onclick="agregar('<% out.print(dis.getUpc());%>' )">
                                     Agregar a carrito
                                     </button>
                                     
                                 </div>
                                </li>
                                
                       <% } %>
                      

		</ul> <!-- cd-gallery-items -->
                 
            <%}    
    }                 
    %>
    
   
              
</div>                
