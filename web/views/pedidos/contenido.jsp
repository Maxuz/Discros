
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
                <!-- MÓDULO PARA USUARIOS LOGUEADOS -->
                 <br><h2 style="text-align: center;">Confirmar pedido</h2><hr>
                 
                
                 <% CancionesFunciones funcionesCanciones = new CancionesFunciones();
                    //ArrayList<Model.Pedido> lista = new ArrayList<Model.Pedido>();
                    
                    if((ArrayList<Model.Disco>)session.getAttribute("listaCarrito")!=null)
                    {
                        ArrayList<Model.Disco> lista = (ArrayList<Model.Disco>)session.getAttribute("listaCarrito");
                        
                    int cantidad = lista.size();
                    int i;
                    Model.Disco dis = new Disco();
                         
                                %>
                                <!-- CARGA DE DATOS DEL USUARIO QUE REALIZA EL PEDIDO-->
                                       <%
                                       UsuariosFunciones funcionesUsuario = new UsuariosFunciones();
                                       String email = session.getAttribute("email").toString();
                                       Usuario user = funcionesUsuario.getOne(email);
                                       %>
                                        
                                            
                                        <div style="width: 50%;">
                                        <h3 style="color: #23527c;"> Datos del cliente</h3>
                                        <table class="table table-condensed">
                                        <tr>
                                        <td><strong>Nombre y Apellido</strong></td>
                                        <td><%out.print(user.getNombre());%>  <%out.print(user.getApellido());%></td>
                                        </tr>  
                                        
                                        <tr>
                                        <td><strong>DNI</strong></td>
                                        <td><%out.print(user.getdni());%></td>
                                        </tr> 
                                        
                                        <tr>
                                        <td><strong>Ciudad</strong></td>
                                        <td><%out.print(user.getCiudad());%></td>
                                        </tr> 
                                        
                                        <tr>
                                        <td><strong>Provincia</strong></td>
                                        <td><%out.print(user.getProvincia());%></td>
                                        </tr> 
                                        
                                        <tr>
                                        <td><strong>Dirección</strong></td>
                                        <td><%out.print(user.getDireccion());%></td>
                                        </tr> 
                                        
                                       </table>
                                       </div>
                                        
                                <!-- TABLA DE CANCIONES: RECORDAR QUE EL PRECIO DE UN DISCO ES LA CANCION DEL DISCO CON CÓDIGO = 0-->
                                <br><hr>   
                                 <h3 style="color: #23527c;"> Datos del pedido</h3>
                                 <h4 style="font-style: italic;">Cantidad de items en el carrito: <%out.print(session.getAttribute("itemsTotal").toString());%></h4>
                                 <div class="table-responsive">
                                 <table class="table" id="tablaCanciones">
                                 <!-- CODIGO PARA EL ENCABEZADO-->
                                 <tr>
                                     <td><strong>Artista</strong></td>
                                     <td><strong>Album</strong></td>
                                     <td><strong>Genero</strong></td>
                                     <td><strong>Año</strong></td>
                                     <!--<td><strong>Descripción</strong></td>-->
                                     <td><strong>Precio</strong></td>
                                 </tr>
                                 
                                
                                 <!-- VERIFICA SI HAY OBJETOS EN LA LISTA PARA MOSTRALOS-->
                                 <%     if(cantidad!=0){
                            
                                        for(i=0;i<cantidad;i++)
                                        {   dis= lista.get(i);
                                            double precio = funcionesCanciones.getOne(dis.getUpc(), 0).getPrecio();
                                            
                                            %>
                                             <tr>
                                             <td><%out.print(dis.getArtista()); %></td>
                                             <td><%out.print(dis.getAlbum()); %></td>
                                             <td><%out.print(dis.getGenero()); %></td>
                                             <td><%out.print(dis.getFecha()); %></td>
                                         <!--<td><%//out.print(dis.getDescripcion()); %></td>
                                             <td><%//out.print(dis.getImagen()); %></td>-->
                                             <td>$ <%out.print(precio); %></td>
                                             </tr>
                                            <%
                                        }
                                        
                                        };%>
                                        <tr>
                                            <td><strong>Total</strong></td>
                                             <td></td>
                                             <td></td>
                                             <td></td>
                                        <!-- <td></td>
                                             <td></td>-->
                                             <td><strong>$ <% out.print(session.getAttribute("valorTotalCarrito")); %></strong></td>
                                             
                                             </tr>
                                        </table>
                                         </div>   
                                         <br><hr>                                         
                                         <h3 style="color: #23527c;">Datos de Pago</h3>
                                        <form action="pAlta.do" role="form" id="login" method="post"  >
                                        <p>Entrega a domicilio: <%out.print(user.getDireccion());%> - <%out.print(user.getCiudad());%> - <%out.print(user.getProvincia());%></p>
                                         
                                        <div class="radio">
                                            <label><input type="radio" name="optradio" onclick="ocultarTarjeta()" >Pago contra entrega de producto.</label>
                                         </div>
                                             
                                         <div class="radio">
                                             <label><input type="radio" name="optradio" onclick="mostrarTarjeta()">Pago con tarjeta de crédito.</label>
                                         </div>
                                             
                                        <div id="datosTarjetas" class="hidden" style="margin-left: 10%">
                                            <hr>   
                                        <h4 style="color: #23527c;">Datos de la tarjeta de crédito</h4>   
                                        
                                        <div class="col-xs-8">
                                        <label id="lblBanco" for="banco">Banco de la tarjeta</label>
                                        <select class="form-control" name="banco" id="banco" >
                                                <option> Elegir banco.. </option>  
                                                <option value="macro">Macro</option>
                                                <option value="provSF">Provincia Santa Fe</option>
                                                <option value="naranja">Naranja</option>
                                                <option value="otro">Otro</option>
                                                </select><br>
                                        </div>
                                        <br><br><br><br>
                                        
                                        <div class="col-xs-8">
                                        <label id="lblPlan" for="plan">Plan de pago</label>
                                        <select class="form-control" name="plan" id="plan" >
                                                <option> Elegir el plan.. </option>  
                                                <option value="1">1</option>
                                                <option value="3">3</option>
                                                <option value="6">6</option>
                                                <option value="12">12</option>
                                                </select><br>
                                        </div>
                                        <br><br><br><br>
                                        
                                        <div class="col-xs-8">
                                        <label id="lblNyA" for="NyA">Nombre y Apellido del titular</label>
                                        <input type="text" class="form-control" placeholder="Ingrese nombre y apellido" name="NyA" id="NyA"><br>
                                        </div>
                                        <br><br><br><br>
                                        
                                        <div class="col-xs-8">
                                        <label id="lblNtarjeta" for="ntarjeta">Número de tarjeta</label>
                                        <input type="text" class="form-control" placeholder="Ingrese número de tarjeta" name="ntarjeta" id="ntarjeta"><br>
                                        </div>
                                        <br><br><br><br>
                                        
                                        <div class="col-xs-8">
                                        <label id="cs" for="cs">Código de seguridad</label>
                                        <input type="text" class="form-control" placeholder="Ingrese código de seguridad" name="cs" id="cs"><br>
                                        </div>
                                        <br><br><br><br>
                                        
                                        
                                        </div>
                                             <br><br>
                                         <button type="submit" class="btn btn-primary btn-large">Confirmar compra</button> 
                                         </form>
                                        <br>
                                       
                                     
          <%}else{ %>
            <br><h3 style="text-align: center; ">El carrito esta vacio, para realizar su compra ingrese a la tienda</h3><hr>
            <h3 style="text-align: center;"><a href="t_index.jsp">Ingresar a la Tienda</a> </h3><br>
                    <%};
                        } %>
</div>                
</div>                
    