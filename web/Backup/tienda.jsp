<!DOCTYPE html>

<html>
   <%--HEAD--%>
   <head>
    <meta charset="utf-8">
    <title>DISCROS INC. - Tienda</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <jsp:include page="views/gral/referenciasCSS.jsp"/>
    
</head>

<body>
    
<%--CONTENEDOR PRINCIPAL--%>
<div class="container">
    <div class="row clearfix">     
        <div class="col-md-12 column">
           
            <%--MENÚ--%>
             <jsp:include page="views/gral/header.jsp" />
            
             <%--CONTENIDO--%>
            <jsp:include page="views/tienda/contenidoTienda.jsp"/>   
            
        </div>
    </div>       
        
 <%--PIE DE PÁGINA--%>               
    <jsp:include page="views/gral/piedepagina.jsp" />
    
</div>
</body>
</html>
