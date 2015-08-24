
<%@page import="Model.Cancion"%>
<%@page import="Model.Usuario"%>
<%@page import="Model.Disco"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Actions.Pedidos.PedidosFunciones"%>
<%@page import="Actions.PedidosCanciones.PedidosCancionesFunciones"%>
<%@page import="Model.Pedido"%>

<div style="margin-top: 60px; background-color: #FFF; margin-bottom: 10px">
<div class="row" style="margin-left: 10%; margin-right: 10%; ">  
    
     
     <!-- CONTROLA SI HAY UN USUARIO LOGUEADO-->
    <% if(session.getAttribute("nombre")==null){%>
        <br><h3 style="text-align: center; font-style: italic;">Lo sentimos, acceso sólo para usuarios logueados.</h3>
        <h4 style="text-align: center;"><a href="u_login.jsp" >Inicie sesión</a></h4><hr><br>
     
      <%}  
    else{%>
          <h1 style="text-align: center;"> Detalles del pedido.</h1>
          <%if(request.getParameter("id")==null || request.getParameter("id").toString().equals("") )
          {%>
            <h3 style="text-align: center;"> Debe ingresar un ID de pedido.</h3>
        
            <%}else{PedidosFunciones funcionesPedido = new PedidosFunciones();
                    int id = Integer.parseInt(request.getParameter("id"));
                    String email = session.getAttribute("email").toString();
            
                    if(!funcionesPedido.buscar(id, email))
                    {%>
                    <h3 style="text-align: center;">El pedido con el ID proporcionado no se encuentra para este cliente.</h3>  
                    
                  <%}else{
                            Pedido ped = funcionesPedido.getOne(id);
                            
                      %>
                         <div class="table-responsive"  id="itemsPedido">
                                 <table class="table" id="tablaCanciones">
                                 <!-- CODIGO PARA EL ENCABEZADO-->
                                 <br>
                                 <tr>
                                     <td><strong>UPC</strong></td>  
                                     <td><strong>Artista</strong></td>
                                     <td><strong>Album</strong></td>
                                     <td><strong>Cantidad</strong></td>
                                     
                                 </tr>
                                 <% 
                                 PedidosCancionesFunciones funcionesPC = new PedidosCancionesFunciones();
                                 ArrayList<Cancion> lista = funcionesPC.getAll(id);
                                 for(Cancion can:lista)
                                 {%>    
                                 <tr>
                                     <td><%out.print(can.getUpc()); %></td>  
                                     <td><%out.print(can.getArtista()); %></td>  
                                     <td><%out.print(can.getAlbum()); %></td>  
                                     <td><%out.print(can.getCantidad()); %></td>  
                                 </tr>
                                 <%}%>            
                                 </table>
                         </div>
                                 
                          <input type="button" class="btn btn-success" value="Volver al historial.." name="volver atrás2" onclick="window.location.href='u_pedidos.jsp'" />
                          <br><br>
                      <%}
                    }
                 
                }
        %>
</div>                
</div>                
    