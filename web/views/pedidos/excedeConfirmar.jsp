
<%@page import="Model.Usuario"%>
<%@page import="Model.Disco"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Actions.Canciones.CancionesFunciones"%>
<%@page import="Actions.Usuarios.UsuariosFunciones"%>
<%@page import="Model.Pedido"%>

<div style="margin-top: 60px; background-color: #FFF; margin-bottom: 10px">
 <div class="row" style="margin-left: 10%; margin-right: 10%; ">  
     <!-- CONTROLA SI HAY UN USUARIO LOGUEADO-->
    <% if(session.getAttribute("nombre")==null){%>
        <br><h3 style="text-align: center; font-style: italic;">Lo sentimos, acceso sólo para usuarios logueados.</h3>
        <h4 style="text-align: center;"><a href="u_login.jsp" >Inicie sesión</a></h4><hr><br>
     
        <%   response.sendRedirect("u_login.jsp"); }  
    else {%>
                <%  
                if(session.getAttribute("mensajeExito")!=null)
                {%>
                <h1 style="font-style: italic; text-align: center;"><% out.print(session.getAttribute("mensajeExito").toString());%></h1>
               <%}
                else{    
                 %>
                 <!-- MÓDULO PARA USUARIOS LOGUEADOS -->
                 <br><h2 style="text-align: center;">Confirmar pedido</h2><hr>
                 
                
                 <% CancionesFunciones funcionesCanciones = new CancionesFunciones();
                    //ArrayList<Model.Pedido> lista = new ArrayList<Model.Pedido>();
                    
                    if((ArrayList<Model.Disco>)session.getAttribute("listaCarrito")!=null)
                    {
                        
                         
                                %>
                                        
                                <!-- TABLA DE CANCIONES: RECORDAR QUE EL PRECIO DE UN DISCO ES LA CANCION DEL DISCO CON CÓDIGO = 0-->
                                 <br><hr>   
                                 <h3 style="color: #23527c;"> Datos del pedido</h3>
                                 <h4><strong> VALOR TOTAL DEL PEDIDO:  $ <% out.print(session.getAttribute("valorTotalCarrito")); %></strong></h4>
                                 <h4 style="font-style: italic;">Cantidad de items en el carrito: <%out.print(session.getAttribute("itemsTotal").toString());%></h4>
                                 
                                 <button type="button" class="btn btn-info" id="verDetalles"   onclick="verDetalles()">Ver detalles</button>
                                 <button type="button" class="btn btn-info hidden" id="ocultarDetalles"  onclick="ocultarDetalles()" >Ocultar detalles</button>
                                 <br>
                                 <div class="table-responsive" hidden id="itemsPedido">
                                 <table class="table" id="tablaCanciones">
                                 <!-- CODIGO PARA EL ENCABEZADO-->
                                 <br>
                                 <tr>
                                     <td><strong>Artista</strong></td>
                                     <td><strong>Album</strong></td>
                                     <td><strong>Genero</strong></td>
                                     <td><strong>Año</strong></td>
                                     <td><strong>Precio</strong></td>
                                 </tr>
                                 
                                
                                 <!-- VERIFICA SI HAY OBJETOS EN LA LISTA PARA MOSTRALOS-->
                               
                                       
                                     
          <%}else{ %>
            <br><h3 style="text-align: center; ">El carrito esta vacio, para realizar su compra ingrese a la tienda</h3><hr>
            <h3 style="text-align: center;"><a href="t_index.jsp">Ingresar a la Tienda</a> </h3><br>
                    <%};
                        }} %>
</div>                
</div>                
    