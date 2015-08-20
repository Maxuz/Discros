<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Confirmar Pedido - Discros INC</title>

    <%session.setAttribute("paginaActual", "p_confirmar");%>
    <script src="js/pedidos.js"></script>
    <jsp:include page="views/gral/referencias.jsp"/>
    
  </head>
  <body>

    <div class="container-fluid">
        
        <jsp:include page="views/gral/header.jsp"/>
        
        
        <%try{%>
        <jsp:include page="views/pedidos/contenido.jsp"/>
        <%}catch (Exception e)
                       {
                                        session.setAttribute("errorCatch", e.toString());
                                        RequestDispatcher rd =null;
                                                                               
                                        rd=request.getRequestDispatcher("error.jsp");
                                        rd.forward(request,response);
                       }%>
        
        <jsp:include page="views/gral/pie.jsp" />
        
   </div>