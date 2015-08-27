<div style="background-color: #ffffff; margin-top:75px; margin-bottom: 15px">
  

<!-- FORMULARIO DE REGISTRO DE NUEVO DISCO-->
<div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >
    <br>
    <h2 style="text-align: center;">Registro de canciones para el disco UPC: <% out.print(session.getAttribute("ultimoUpc"));%></h2><hr>
    
    <%  String s = (String)session.getAttribute("tipoUsuario");
     if(s!=null){%>
                
                <!--VERIFICA QUE NO HAYA MENSAJES CARGADOS EN LA VARIABLE DE SESIÓN COMO RESPUESTA DEL SERVIDOR-->
                <% if(session.getAttribute("mensajeExito")!= null)
                {%>
                        <!--SERVIDOR DEVUELVE MENSAJE DE ÉXITO-->
                      
                        <div class="alert alert-success" style="text-align: center;">
                           
                       <% out.print((String)session.getAttribute("mensajeExito"));
                       session.setAttribute("mensajeExito", null);
                       session.setAttribute("ultimoUpc",null);
                       %>
                       </div>
                       <hr><div style="margin-left:  15px;"><a href="d_alta.jsp"><h3>Crear otro disco</h3></a></div> <br><br>
                       <hr><div style="margin-left:  15px;"><a href="p_admin.jsp"><h4>&laquo; Volver al menú principal..</h4></a></div> <br><br>
                            
                       
                       <%}
                              
                
                else{   if(s.equals("admin"))
                        { 
                            if (session.getAttribute("mensajeError")!=null)
                                { %>
                                
                                    <!--SERVIDOR DEVUELVE MENSAJE DE ERROR-->
                                    <br><br>    
                                    <div class="alert alert-warning" style="text-align: center;">
                                    <% out.print((String)session.getAttribute("mensajeError"));
                                    session.setAttribute("mensajeError", null);
                                    %>
                                    </div>  
                              <%    };
                              
                              if(session.getAttribute("ultimoUpc")!= null){
                              %>  
                              
                            <!--FORMULARIO DE ALTA-->
                            <form role="form" class="form-horizontal" id="cAlta" method="post" action="cAlta.do" >
                            
                             <h3> Canciones del disco </h3>
                             <h4>  Si desea registrar las canciones luego presione <a href="p_admin.jsp">aqui</a></h4>
                             <br><br>

                             <div class="col-xs-8">
                             <label for="isrc" id="lblIsrc">ISRC:</label>
                             <input type="text" class="form-control" placeholder="Ingrese ISRC" name="isrc" id="isrc"><br>
                             </div>
                             <br><br><br><br>

                             <div class="col-xs-8">
                             <label for="track" id="lblTrack">Track:</label>
                             <input type="text" class="form-control" placeholder="Ingrese Track" name="track" id="track"><br>
                             </div>
                             <br><br><br><br>

                             <div class="col-xs-8">
                             <label for="nombre" id="lblNombre">Nombre:</label>
                             <input type="text" class="form-control" placeholder="Ingrese Nombre" name="nombre" id="nombre"><br>
                             </div>
                             <br><br><br><br>

                             <div class="col-xs-8">
                             <label for="duracion" id="lblDuracion">Duración:</label>
                             <input type="text" class="form-control" placeholder="Ingrese Duración" name="duracion" id="duracion"><br>
                             </div>
                             <br><br><br><br>

                             <div class="col-xs-8">
                             <label for="precio" id="lblPrecio2">Precio:</label>
                             <input type="text" class="form-control" placeholder="Ingrese Precio" name="precio2" id="precio2"><br>
                             </div>
                             <br><br><br><br>


                             <button id="add">Añadir Canción</button>

                             <br><br>
                              <!-- TABLA DE CANCIONES: RECORDAR QUE EL PRECIO DE UN DISCO ES LA CANCION DEL DISCO CON CÓDIGO = 0-->
                             <div class="table-responsive">
                             <table class="table" id="tablaCanciones">
                                 <!-- CODIGO PARA EL ENCABEZADO-->
                                 <tr>
                                     <td><strong>ISRC</strong></td>
                                     <td><strong>Track</strong></td>
                                     <td><strong>Nombre</strong></td>
                                     <td><strong>Duración</strong></td>
                                     <td><strong>Precio</strong></td>
                                 </tr>
                             </table>
                             </div>
                             <br><br>

                             <button type="submit" class="btn btn-default" style="width: 220px; margin-left: 15px;">Registrar Disco</button>
                             &nbsp;&nbsp;&nbsp;&nbsp;
                             
                         </form>                     
                         <br><br>
                      <% }else{ %>
                                    <!--RESTRICCIÓN PARA LOS NO ADMINISTRADORES -->
                                    <h3 style="text-align: center; font-style: italic;">
                                    Lo sentimos, página sólo habilitada para administradores.
                                    </h3>
                                    <hr> 
                           <%}
                        }else{%>
                                    <!--RESTRICCIÓN PARA LOS NO ADMINISTRADORES -->
                                    <h3 style="text-align: center; font-style: italic;">
                                    Lo sentimos, no puede cargar canciones sin haber dado de alta el disco.
                                    </h3>
                                    <hr> 
                           <%}
                    
                  }%>
            
        <%}else{%>     <!--RESTRICCIÓN PARA USUARIO NO LOGUEADO-->
                        <h3 style="text-align: center; font-style: italic;">
                        Lo sentimos, debe iniciar sesión como administrador.
                        </h3>
                        <hr> 
                        
                    <%}%>
              
       
        
    
  </div>
</div>

    