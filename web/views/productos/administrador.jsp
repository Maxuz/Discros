<!--MISION - VISION - VALORES -->
<div style="background-color: #fffefd; margin-top:65px; margin-bottom: 13px;">

    <%  String s = (String)session.getAttribute("tipoUsuario");
        
        //VERIFICA QUE HAYA USUARIO LOGUEADO     
        if(s!=null){
            
            if(s.equals("admin"))
                            { %>
                
    <div class="row">
        
        <br><h2 style="text-align: center;">Administración de Productos</h2>
        <br>
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="thumbnail" style="text-align: center; height: 225px;">
                <h3 style="font-weight: bold; text-decoration: underline;">Discos</h3>
                <div class="caption">
                 
                  <ul class="list-group">
                    <li class="list-group-item list-group-item-success"><a href="d_alta.jsp" >Agregar disco</a></li>
                    <li class="list-group-item list-group-item-warning"><a href="#" >Modificar disco</a></li>
                   
                  </ul>
                </div>
            </div>
        </div>
        

    </div>
                        
                        <% }else{%>
                                    <!--RESTRICCIÓN PARA LOS NO ADMINISTRADORES -->
                                    <h3 style="text-align: center; font-style: italic;">
                                    Lo sentimos, página sólo habilitada para administradores.
                                    </h3>
                                    <hr> 
                           <%}
            
        }else{   %>  <!--RESTRICCIÓN PARA USUARIO NO LOGUEADO-->
                        <h3 style="text-align: center; font-style: italic;">
                        <br><br>
                        Lo sentimos, debe iniciar sesión como administrador.
                            
                        </h3>
                        <hr> 
                        <br><br>
                    <%}%>

   

</div>  