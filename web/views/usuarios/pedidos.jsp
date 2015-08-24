
<%@page import="java.util.ArrayList"%>
<%@page import="Actions.Pedidos.PedidosFunciones"%>
<%@page import="Model.Pedido"%>

<div style="margin-top: 60px; background-color: #FFF; margin-bottom: 10px">
    
     <!-- CONTROLA SI HAY UN USUARIO LOGUEADO-->
    <% if(session.getAttribute("nombre")==null)
    {%>
        <br><h3 style="text-align: center; font-style: italic;">Lo sentimos, acceso sólo para usuarios logueados.</h3><hr><br>
        
    <%}  else{%>
                <!-- MÓDULO PARA USUARIOS LOGUEADOS -->
                 <br><h2 style="text-align: center;">Historial de compras</h2><hr>
                 
                 <% PedidosFunciones funciones = new PedidosFunciones();
                    ArrayList<Model.Pedido> lista = new ArrayList<Model.Pedido>();
                    String email = (String)session.getAttribute("email");
                    lista = funciones.getAll(email);
                    int cantidad = lista.size();
                    int i;
                    Pedido ped = new Pedido();
                            if(cantidad==0){%> <h3 style="text-align: center; font-style: italic;">Aún no tiene ningúna compra realizada.</h3> <%};%>
                     
                                <!-- TABLA DE CANCIONES: RECORDAR QUE EL PRECIO DE UN DISCO ES LA CANCION DEL DISCO CON CÓDIGO = 0-->
                                <div class="table-responsive" style="margin-left: 10%; margin-right: 10%;">
                                 <table class="table" id="tablaCanciones">
                                 <!-- CODIGO PARA EL ENCABEZADO-->
                                 <tr>
                                     <td><strong>ID</strong></td>
                                     <td><strong>Estado</strong></td>
                                     <td><strong>Fecha</strong></td>
                                     <td><strong>Total</strong></td>
                                     <td><strong>Links</strong></td>
                                 </tr>
                                  
                                 <!-- VERIFICA SI HAY OBJETOS EN LA LISTA PARA MOSTRALOS-->
                                 <%     if(cantidad!=0){
                            
                                        for(i=0;i<cantidad;i++)
                                        {   
                                            ped = lista.get(i);
                                            %>
                                             <tr>
                                             <td><%out.print(ped.getID()); %></td>
                                             <td><%out.print(ped.getEstado()); %></td>
                                             <td><%out.print(ped.getFecha()); %></td>
                                             <td>$ <%out.print(ped.getValor()); %></td>
                                             <td><a href="u_pedidosDetalle.jsp?id=<%out.print(ped.getID());%>">Ver detalles del pedido..</a></td>
                                             </tr>
                                            <%
                                        }
                                        };%>
                                        </table>
                                        </div>
                                     
          <%}%>
</div>                