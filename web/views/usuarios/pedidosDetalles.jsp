
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
     
      <%}  
    else{
            if(request.getParameter("id")==null)
           {%>
            <h1 style="text-align: center;"> Detalles del pedido</h1>
        
         <%}else{
               
               }
        }%>
</div>                
</div>                
    