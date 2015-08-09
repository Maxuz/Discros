   
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
                     <ul class="nav navbar-nav navbar-right" style="margin-right: 10px;">
                    
                        <% if (session.getAttribute("nombre")== null)
                                {%>
                                <% if(session.getAttribute("paginaActual").equals("u_alta"))
                                    {%>
                                    <li class="active"><a href="u_alta.jsp">REGISTRATE</a></li>
                                    <%} else {%>
                                                 <li><a href="u_alta.jsp">REGISTRATE</a></li>
                                            <%} 
                                 }%>
                        

                    <li class="dropdown">
                            <!--INICIO DE SESIÓN O MENÚ DE OPCIONES PARA EL USUARIO-->
                            <% 
                            session.setAttribute("nombre", null);
                            String nombre2 = (String)session.getAttribute("nombre");
                            if(nombre2==null)
                            {%>  <%-- INICIAR SESIÓN --%>
                                 <a id="userclimodal1" href="#ModalInicioSesion" role="button" class="btn" data-toggle="modal">INICIA SESION</a>   
                            <%
                            }else{%>
                            
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <img src="img/usuario.png" alt="Usuario" WIDTH=20 HEIGHT=20/> <strong>
                                <% out.print(nombre2);  %> </strong>
                            </a>
                                        
                            <ul class="dropdown-menu">
                                
                                <li><a href="#">Cerrar Sesión</a></li>
                                
                            </ul>
                            
                                        
                                        
                            <%}%>
                           
                                               
                   </li>                             
                                                 
                                                 
                    <li class="dropdown">
                        
                            <%--BIENVENIDA USUARIO O MENU DE LOGUEO--%>
                            <% 
                            String nombre = (String)session.getAttribute("nombre");
                            if(nombre==null)
                            {out.print(" <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"> <img src=\"img/usuario.png\" alt=\"Usuario\" WIDTH=20 HEIGHT=20/> USUARIOS");
                            }else{out.print(" <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"> <img src=\"img/usuario.png\" alt=\"Usuario\" WIDTH=20 HEIGHT=20/> <strong>"+ nombre +  "</strong><strong class=\"caret\"></strong></a>");%>
                            <%}
                            Integer valor = 0;
                            
                            /*
                            if(valor==1)
                            { out.print(" <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"> <img src=\"img/usuario.png\" alt=\"Usuario\" WIDTH=20 HEIGHT=20/> <strong>"+ nombre +  "</strong><strong class=\"caret\"></strong></a>");
                            } 
                            else { out.print(" <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\"> <img src=\"img/usuario.png\" alt=\"Usuario\" WIDTH=20 HEIGHT=20/> USUARIOS");
                            };
                              */
                            %>
                            
                          
                            
                            <ul class="dropdown-menu">
                                <%--CONTROL DE INICIO DE SESIÓN DE USUARIO--%>
                                <%  String tipo = "admin";
                            
                            
                                    if (valor==0){
                                    /*USUARIO NO LOGUEADO*/
                                    out.println("<td> <li><a id=\"userclimodal1\" href=\"#ModalInicioSesion\" role=\"button\" class=\"btn\" data-toggle=\"modal\">Iniciar Sesion</a></li>");
                                    }
                                    else{  
                                        /*USUARIO LOGUEADO*/
                                        out.println("<td> <li><a id=\"userclimodal1\" href=\"#Modal_modificardatos\" role=\"button\" class=\"btn\" "
                                                     + "data-toggle=\"modal\"></i>Modificar mis datos.</a></li>");
                                        
                                        /*OPCIONES SEGÚN PRIVILEGIOS*/
                                        if(tipo.equals("")==false && tipo.equals("admin")){ 
                                         out.println("<td> <li><a href=\"\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Agregar Productos</a></td> </li>");
                                              
                                         } 
                                              
                                       }
                                 %>
                              
                            </ul>
                                 
                        </li>
                        
                   
                        
                    </ul>
                                 
                </div>
                            

	

            </nav>

            <%--MODAL CLIENTE--%>
            <div class="modal fade" id="ModalInicioSesion" role="dialog" aria-labelledby="myModalLabelInisioSesion" aria-hidden="true">
                <%--DECLARACIÓN DEL MODAL--%>
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
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
                                    <label for="lPass">Contraseña</label>
                                    <input type="password" class="form-control" id="pass" name="pass"  placeholder="Contraseña">
                                   
                                    <input type="text" name="funcion" id="funcion" size="5" value="login" hidden readonly="true">
                                    
                                    </div>
                                
                                     <button type="submit" class="btn btn-default">Enviar</button>
                                     
                                     <br><br><a href="#">Olvidé mi contraseña.</a>
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

            <%--MODAL MODIFICAR DATOS DE USUARIOS--%>           
            <div class="modal fade" id="Modal_modificardatos" role="dialog" aria-labelledby="myModalLabelModDatos" aria-hidden="true">
                <%--DECLARACIÓN DEL MODAL--%>
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title" id="myModalLabelModDatos">
                                MODIFICAR DATOS 
                            </h4>
                        </div>
                        
                        <%--CONTENEDOR DEL MODAL--%>
                        <div class="modal-body">
                           
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>

                </div>
            </div> 
            </div>