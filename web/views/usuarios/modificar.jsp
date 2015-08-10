
<% 
    String nombre = (String)session.getAttribute("nombre");
    
    if(nombre==null)
    {%>
    
        <div class="row" style="margin-top: 80px; background-color: #ffffff; margin-bottom: 15px;">
            <br>
            <img class="img-responsive" src="img/userunknow.png" style="margin:auto;"/>
            <h3 style="text-align:center;"> NO HAY USUARIO LOGUEADO </h3><br><br><br><br><br><br><br><br>
        </div>
        
        
    <% } else{
%>
    
    <div class="row" style="margin-top: 80px; background-color: #ffffff; margin-bottom: 15px;">
        <h1 style="text-align:center;"> Modificar datos de usuario </h1><br><br><br><br><br><br><br><br>
    </div>

<%}%>
    
