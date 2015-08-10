
            <%--BARRA DE MEN�--%>
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
                    
                         <%--BOT�N PARA REGISTRARSE REGISTRARSE--%>
                        <% 
                                session.setAttribute("nombre", null);
                        
                                if (session.getAttribute("nombre")== null)
                                {%>
                                <% if(session.getAttribute("paginaActual").equals("u_alta"))
                                    {%>
                                    <li class="active"><a href="u_alta.jsp">REGISTRATE</a></li>
                                    <%} else {%>
                                                 <li><a href="u_alta.jsp">REGISTRATE</a></li>
                                            <%} 
                                 }%>
                                                 
                        
                    <li class="dropdown">
                    <!--INICIO DE SESI�N O MEN� DE OPCIONES PARA EL USUARIO-->
                    <li class="dropdown">
                            
                            <% 
                            
                            String nombre2 = (String)session.getAttribute("nombre");
                            if(nombre2==null)
                            {%>  
                            <%-- INICIAR SESI�N --%>
                            <a id="userclimodal1" href="#ModalInicioSesion" role="button" class="btn" data-toggle="modal">INICIA SESION</a>   
                            <%
                            }else{%>
                            
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="img/usuario.png" alt="Usuario" WIDTH=20 HEIGHT=20/> <strong>
                                <% out.print(nombre2);  %> </strong><strong class="caret"></strong>
                            </a>
                                        
                            <ul class="dropdown-menu">
                                
                                <li><a href="#">Cerrar Sesi�n</a></li>
                                <li><a id="userclimodal1" href="u_modificar.jsp" role="button" class="btn" ></i>Modificar mis datos.</a></li>
                                
                            </ul>
                            
                                        
                                        
                            <%}%>
                           
                                               
                   </li>                             
                                                 
                     <%--CARRITO DE COMPRAS--%>                            
                    <li class="dropdown">
                       
                            
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="img/carrito.png" alt="Usuario" WIDTH=20 HEIGHT=20/> <strong>
                                Carrito 
                                <% 
                                    String cantidad = (String)session.getAttribute("itemsTotal");
                                    if(cantidad==null)
                                    {
                                        out.print("(0)");
                                        
                                    } else {
                                            out.print("("+cantidad+")");
                                            }
                                
                                %>
                                
                                </strong><strong class="caret"></strong>
                            </a>
                            
                            
                             <ul class="dropdown-menu">                             
                                 <% 
                                    if(cantidad==null)
                                    {
                                        %> 
                                        <p style="margin: 2px; text-align: center;"> UPS!<br> Carrito vac�o <br> <br><a href="t_index.jsp">Agregue su primer producto</a> </p>
                                        <%
                                     } else{
                                 %>
                                        
                                            <li><a href="#">Cerrar Sesi�n</a></li>
                                 <% }%>
                                
                            </ul>
                       </li>
                        
                   
                        
                    </ul>
                                 
                </div>
                            

	

            </nav>

            <%--MODAL LOGIN--%>
            <div class="modal fade" id="ModalInicioSesion" role="dialog" aria-labelledby="myModalLabelInisioSesion" aria-hidden="true">
                
                <%--DECLARACI�N DEL MODAL--%>
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
                            <h4 class="modal-title" id="myModalLabelInisioSesion">
                                Ingreso de usuarios.
                            </h4>
                        </div>
                        
                        <%--CONTENEDOR DEL MODAL--%>
                        <div class="modal-body">
                            <%--FORMULARIO DE INGRESO--%>
                            <form role="form" id="login" method="post" >
                                      
                                    <div class="form-group">
                                    <label for="lEmail">Email</label>
                                    <input type="email" class="form-control" name="email" id="email" placeholder="Introduce tu email">
                                    </div>
                                  
                                    <div class="form-group">
                                    <label for="lPass">Contrase�a</label>
                                    <input type="password" class="form-control" id="pass" name="pass"  placeholder="Contrase�a">
                                   
                                    <input type="text" name="funcion" id="funcion" size="5" value="login" hidden readonly="true">
                                    
                                    </div>
                                
                                     <button type="submit" class="btn btn-default">Enviar</button>
                                     
                                     <br><br><a href="#">Olvid� mi contrase�a.</a>
                                     <br><a href="views/usuario/registroUsuario.jsp">Registrarme.</a><br><br>
                                     
                                      <div>
                                   <!--DIV PARA MOSTRAR ERRORES-->
                                   <div id="divError" class="alert alert-danger hidden"></div>
                                   
                                   
                                    </div>
                                    </form>
                            
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>

                </div>
            </div>

             <%--MODAL FORMA DE PAGO--%>
            <div class="modal fade" id="Formasdepago" role="dialog" aria-labelledby="myModalLabelPagos" aria-hidden="true">
                <%--DECLARACI�N DEL MODAL--%>
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
                                <p> Contamos con diferentes formas de pago seg�n las comodidades del cliente: <br/>
                                    Tarjeta de cr�dito<br/>
                                    MercadoPago<br/>
                                    Paypal<br/><br/>
                                <h4>PROMOCIONES</h4><br/>
                                <strong>VISA</strong>: 6 CUOTAS SIN INTER�S.<br/>
                                <strong>MASTERCARD</strong>:6 CUOTAS SIN INTER�S.<br/>
                                <strong>BANCO BBVA</strong>: 12 CUOTAS SIN INTER�S.<br/>
                                <strong>Otros Bancos</strong>: 15% inter�s en 12 CUOTAS.
                             
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

       