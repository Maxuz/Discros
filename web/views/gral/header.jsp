<%@page import="java.util.ArrayList"%>
<%@page import="Model.Disco"%>
<%@page import="Actions.Discos.DiscosFunciones"%>
<%@page import="Actions.Canciones.CancionesFunciones"%>

<%--BARRA DE MENÚ--%>
            <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">MENU</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>

                  <a class="navbar-brand" href="#">DISCROS INC.</a>
                </div>

                
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                     <%--BOTONES--%>
                    <ul class="nav navbar-nav">
                        
                        <li  <% if(session.getAttribute("paginaActual").equals("index")) 
                                {   %>class="active"><% 
                        
                              } else {%> >  <%};%> 
                        
                       
                            <a href="index.jsp">HOME 
                            <% System.out.println(request.getRequestURI()) ; %> </a>
                        </li>
                        
                        <li
                            <% if(session.getAttribute("paginaActual").equals("qsomos"))
                        {%>  class="active">  <% 
                        
                        } else {%> >  <%};%> 
                            <a href="qsomos.jsp">QUIENES SOMOS</a>
                        </li>

                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown">TIENDA VIRTUAL<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                <a href="t_index.jsp">Ingreso a Tienda Virtual</a>
                                </li> 
                                <li class="divider">
                                </li>
                                <li>
                                <a id="modalformadepago" href="#Formasdepago" role="button" class="btn" data-toggle="modal">Formas de Pago</a>
                                </li>
                                <li>
                                <li class="divider">
                                </li>
                                <li><a href="#">Preguntas Frecuentes</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    
                     <%--USUARIOS--%>
                     <%--CONTENEDOR PRINCIPAL DE BOTONES DE USUARIO--%>
                     <ul class="nav navbar-nav navbar-right" style="margin-right: 10px;">
                    
                          <!--INICIO DE SESIÓN O MENÚ DE OPCIONES PARA EL USUARIO-->
                    
                            <% 
                            String tipo = (String)session.getAttribute("tipoUsuario");
                            
                            if(tipo!=null && tipo.equals("admin"))
                            {%>  
                            <%-- INICIAR SESIÓN --%>
                            
                            <li class="dropdown">
                            <%-- MENÚ DEL USUARIO LOGUEADO --%>
                            
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"  ><strong>Menu Administrador </strong><strong class="caret"></strong></a>
                                        
                            <ul class="dropdown-menu" style="width: 100%;">
                                
                                <li style="background-color:#2a6496; color: #ffffff; text-align: center;"><strong>USUARIOS</strong></li>
                                <li><a id="btnModificardatos" href="u_admin.jsp" role="button" class="btn">Administrar Cliente</a></li>
                                <li class="divider"></li>
                                
                                <li style="background-color:#2a6496; color: #ffffff; text-align: center;"><strong>PRODUCTOS</strong></li>
                                <li><a id="btnModificardatos" href="p_admin.jsp" role="button" class="btn">Administrar Productos</a></li>
                                <li class="divider"></li>
                                
                                <li style="background-color:#2a6496; color: #ffffff; text-align: center;"><strong>PEDIDOS</strong></li>
                                <li><a id="btnModificardatos" href="p_informar.jsp?tipo=admin" role="button" class="btn">Actualizar estado</a></li>
                                <li class="divider"></li>
                                
                                <li style="background-color:#2a6496; color: #ffffff; text-align: center;"><strong>REPORTES</strong></li>
                                <li><a id="btnModificardatos" href="#" role="button" class="btn">Usuarios</a></li>
                                <li><a id="btnModificardatos" href="#" role="button" class="btn">Pedidos</a></li>
                                <li><a id="btnModificardatos" href="#" role="button" class="btn">Productos</a></li>
                                
                            </ul>
                            
                             </li>  
                             
                            <%
                            }%>
                            
                                      
                                        
                            
                         
                         
                         
                         <%--BOTÓN PARA REGISTRARSE  --%>
                        <% if (session.getAttribute("nombre")== null)
                                {%>
                                <% if(session.getAttribute("paginaActual").equals("u_alta"))
                                    {%>
                                    <li class="active"><a href="u_alta.jsp">REGISTRATE</a></li>
                                    <%} else {%>
                                                 <li><a href="u_alta.jsp">REGISTRATE</a></li>
                                            <%} 
                                 }%>
                                                 
                                                
                    
                    <!--INICIO DE SESIÓN O MENÚ DE OPCIONES PARA EL USUARIO-->
                    
                            <% 
                            
                            String nombre = (String)session.getAttribute("nombre");
                            if(nombre==null)
                            {%>  
                            <%-- INICIAR SESIÓN --%>
                            <li
                            <% if(session.getAttribute("paginaActual").equals("u_login"))
                                {%>
                              class="active" 
                              <% } %>><a href="u_login.jsp" role="button" >INICIA SESION</a></li>
                             
                            <%
                            }else{%>
                            
                            <li class="dropdown">
                            <%-- MENÚ DEL USUARIO LOGUEADO --%>
                            
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="img/usuario.png" alt="Usuario" WIDTH=20 HEIGHT=20> <strong>
                                <% out.print(nombre);  %> </strong><strong class="caret"></strong>
                            
                            
                            </a>
                                        
                                <ul class="dropdown-menu" style="text-align: center;">
                                <li style="background-color:#2a6496; color: #ffffff;"><strong>COMPRAS</strong></li>
                                <li><a id="btnModificardatos" href="u_pedidos.jsp" role="button" class="btn" >Historial</a></li>
                                
                                <li style="background-color:#2a6496; color: #ffffff;"><strong>CUENTA</strong></li>
                                <li><a id="btnModificardatos" href="u_modificar.jsp" role="button" class="btn" >Modificar mis datos.</a></li>
                                <li class="divider"></li>
                                <li><a href="uLogout.do">Cerrar Sesión</a></li>
                                
                            </ul>
                            
                             </li>            
                                        
                            <%}%>
                           
                                               
                                                              
                     <%--CARRITO DE COMPRAS--%>                            
                    <li class="dropdown" >
                       
                        
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="img/carrito.png" alt="Usuario" WIDTH=20 HEIGHT=20> <strong>
                                Carrito 
                              
                                <% 
                                    int cantidad = Integer.parseInt(session.getAttribute("itemsTotal").toString());
                                    out.print("("+cantidad+")");
                                %>
                             
                                </strong><strong class="caret"></strong>
                            </a>
                          
                            <!--VALIDA QUE NO ESTÉ POR CONFIRMAR EL PEDIDO, DE SER ASÍ SE INHABILITA EL CARRITO PARA QUE NO SUFRA MODIFICACIONES EL MISMO-->    
                            <ul class="dropdown-menu scrollable-menu"   style="width: 333px;" > 
                            <% if(session.getAttribute("paginaActual").toString().equals("p_excedeConfirmar") || session.getAttribute("paginaActual").toString().equals("p_confirmar") )
                            {%>
                            <li><h4 style="margin: 2px; text-align: center;"> No puede modificar el carrito<br> durante el proceso de confirmación.</h4></li>
                                <li><p style="margin: 2px; text-align: center;"> <br><br><a href="t_index.jsp">Ir a tienda</a> </p></li>
                            
                            <%}else{%>
                                  

                                        
                                         
                                 <% 
                                    
                                    //if(cantidad==0)
                                    ArrayList<Disco> lista = (ArrayList<Disco>)session.getAttribute("listaCarrito");
                                    if(lista == null)
                                    { 
                                        //CARRITO VACÍO
                                        %> 
                                        <li><p style="margin: 2px; text-align: center;"> UPS!<br> Carrito vacío</p></li>
                                        <li><p style="margin: 2px; text-align: center;"> <br><br><a href="t_index.jsp">Agregue su primer producto</a> </p></li>
                                        <%
                                        
                                     } else{
                                        
                                        //CARRITO CON ITEMS
                                        CancionesFunciones funcionesCanciones = new CancionesFunciones();
                                        int i;
                                        double total=0;
                                        
                                        //INSERTA TÍTULO HTML PARA LISTAR ITEMS
                                        %>
                                        <li style="background-color:#2a6496; color: #ffffff; text-align: center;">
                                            <strong>Items del Pedido</strong><br>
                                        </li>
                                        <%
                                        
                                        //CARGA DE ITEMS AL CARRITO
                                       
                                        
                                        for( Disco dis : lista)
                                        {//Disco dis = lista.get(i);
                                            
                                        if(dis!=null)
                                        {
                                        double precio = funcionesCanciones.getOne(dis.getUpc(), 0).getPrecio();
                                        total = total+precio;
                                        %> 
                                        
                                        <li>
                                            <button style="float: right;" onclick="borrar('<%out.print(dis.getUpc()); %>')"> 
                                            <img src="img/delete.png" alt="deleteItem" >
                                            </button> 
                                            
                                        <strong>Nombre: </strong><% out.print(dis.getArtista()); %><br>
                                        <strong>Album:</strong><% out.print(dis.getAlbum()); %><br>
                                        <strong>Precio Unitario: $</strong><% out.print(precio); %>
                                        </li>
                                        <li class="divider"></li>    
                                        
                                      <%}
                                        }
                                      session.setAttribute("valorTotalCarrito", total);
                                      %>
                                  
                                
                                    <li style="text-align: right; margin-right: 5px;"><strong>VALOR TOTAL: $</strong><% out.print(total); %><br><br></li>
                                    <li style="background-color:#2a6496; color: #ffffff; text-align: center;"><strong>MI PEDIDO</strong></li>    
                                    <li style="text-align: center;"><a href="p_confirmar.jsp"><strong>REALIZAR COMPRA</strong></a></li>
                                    <li class="divider"></li>  
                                  
                                    <li style="text-align: center;"><a href="cReset.do">Resetear pedido</a></li>
                                   
                                 <% }%>
                                
                                </ul>
                                 <%}%> 
                       </li>
                        
                   
                       
                       
                       
                       
                        
                    </ul>
                                 
                </div>
                            

	

            </nav>

          
             <%--MODAL FORMA DE PAGO--%>
            <div class="modal fade" id="Formasdepago" role="dialog" aria-labelledby="myModalLabelPagos" aria-hidden="true">
                <%--DECLARACIÓN DEL MODAL--%>
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                            <h2 class="modal-title" id="myModalLabelPagos">
                                Formas de pago.
                            </h2>
                        </div>
                        
                        <%--CONTENEDOR DEL MODAL--%>
                        <div class="modal-body">
                        <div class="row">
                            <div class="col-md-8">
                                <p> Contamos con diferentes formas de pago según las comodidades del cliente: <br/>
                                    Tarjeta de crédito<br/>
                                    MercadoPago<br/>
                                    Paypal<br/><br/>
                                <h4>PROMOCIONES</h4><br/>
                                <strong>VISA</strong>: 6 CUOTAS SIN INTERÉS.<br/>
                                <strong>MASTERCARD</strong>:6 CUOTAS SIN INTERÉS.<br/>
                                <strong>BANCO BBVA</strong>: 12 CUOTAS SIN INTERÉS.<br/>
                                <strong>Otros Bancos</strong>: 15% interés en 12 CUOTAS.
                             
                            </div>
                            
                            <div class="col-md-4">
                                <img src="img/mercadopago.png" alt="mercadopago" WIDTH=80  HEIGHT=80  />
                                <img src="img/mastercard.png" alt="mastercard" WIDTH=80 HEIGHT=80 />
                                <img src="img/visa.png" alt="visa" WIDTH=80 HEIGHT=80 />
                                <img src="img/paypal.png" alt="paypal" WIDTH=80 HEIGHT=80 /> 
                             </div>
                            
                        </div>
                       
                        
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button> 
                        </div>
                    </div>

                </div>
            </div>

       