<%@page import="Actions.Canciones.CancionesFunciones"%>
<%@page import="java.util.*"%>
<%@page import="Actions.Util"%>
<%@page import="Model.Disco"%>
<%@page import="Actions.Discos.DiscosFunciones"%>
<%@page import="Model.Cancion"%>

<div style="background-color: #ffffff; margin-top:75px; margin-bottom: 15px">
<!-- FORMULARIO DE EDITAR DISCO-->
<div class="row" style="margin-left: 15%; margin-right: 15%; margin-bottom: 2%" >
    <h2 style="text-align: center;">Modificar un disco</h2><hr>
        <%
        String s = (String)session.getAttribute("tipoUsuario");
        //VERIFICA QUE HAYA USUARIO LOGUEADO     
        if(s!=null){%>
                <!--VERIFICA QUE NO HAYA MENSAJES CARGADOS EN LA VARIABLE DE SESIÓN COMO RESPUESTA DEL SERVIDOR-->
                <% if(session.getAttribute("mensajeExito")!= null){ %>
                        <!--SERVIDOR DEVUELVE MENSAJE DE ÉXITO-->
                        <div class="alert alert-success" style="text-align: center;">
                        <%
                        out.print((String)session.getAttribute("mensajeExito"));
                        session.setAttribute("mensajeExito", null);
                        %>
                        </div>
                        <hr>
                        <div style="margin-left:  15px;"><a href="p_admin.jsp">
                                <h4>&laquo; Volver al menú principal..</h4></a>
                        </div>
                <% }
                else{
                    if(s.equals("admin")){
                        if (session.getAttribute("mensajeError")!=null){ %>
                            <!--SERVIDOR DEVUELVE MENSAJE DE ERROR-->
                            <div class="alert alert-warning" style="text-align: center;">
                                <%
                                out.print((String)session.getAttribute("mensajeError"));
                                session.setAttribute("mensajeError", null);
                                %>
                            </div>  
                        <% } %>  
                <!--FORMULARIO DE MODIFICAR-->
                <%
                String sUpc = (String)session.getAttribute("upc");
                
                int upc = (sUpc == null || sUpc.equals("")) ? 0 : Integer.parseInt(sUpc);
                DiscosFunciones funcionesDisco = new DiscosFunciones();
                Disco dis = funcionesDisco.getOne(upc);
                CancionesFunciones funcionesCanciones = new CancionesFunciones();
                float precio = funcionesCanciones.getOne(dis.getUpc(), 0).getPrecio();
                %>
                <form role="form" class="form-horizontal" enctype="multipart/form-data" id="dModificar" method="post" action="dModificar.do" onsubmit="/*validarForm()*/">
                    <h4>Datos del disco</h4>
                    <hr>
                    <div class="col-xs-8">
                       <label for="UPC" id="lblUPC">UPC:</label>
                       <input type="text" class="form-control" id="upc" name="upc" placeholder="Introduce UPC del disco" value="<%= dis.getUpc() %>">
                    </div>
                    <div class="col-xs-8">
                       <label for="Artista" id="lblArtista">Artista:</label>
                       <input type="text" class="form-control" id="artista"  name="artista" placeholder="Ingrese el artista." value="<%= dis.getArtista() %>">
                    </div>
                    <div class="col-xs-8">
                       <label for="album" id="lblAlbum">Album:</label>
                       <input type="text" class="form-control" placeholder="Ingrese el Album" name="album" id="album" value="<%= dis.getAlbum() %>"><br>
                    </div>
                    <div class="col-xs-8">
                       <label for="genero" id="lblGenero">Género:</label>
                       <input type="text" class="form-control" placeholder="Ingrese el genero" name="genero" id="genero" value="<%= dis.getGenero() %>"><br>
                    </div>
                    <div class="col-xs-8">
                       <label for="stock" id="lblStock">Stock:</label>
                       <input type="text" class="form-control" placeholder="Ingrese Stock" name="stock" id="stock" value="<%= dis.getStock() %>"><br>
                    </div>
                    <div class="col-xs-8">
                       <label for="descripcion" id="lblDescripcion">Descripción:</label>
                       <textarea rows="3" class="form-control" placeholder="Ingrese descripcion" name="descripcion" id="descripcion"><%= dis.getDescripcion() %></textarea>
                    </div>
                    <div class="col-xs-8"> 
                        <label for="precio" id="lblPrecio">Precio:</label>
                        <input type="text" class="form-control currency" id="precio" name="precio" value="<%= precio %>" />
                    </div>
                    
                    <div class="col-xs-12">
                        <h3> Canciones del disco </h3>
                        <div>
                            <%

                            Cancion can = new Cancion();
                            ArrayList<Model.Cancion> listaCancion;
                            
                            listaCancion = funcionesCanciones.getAll(upc);

                            int cantCanciones = listaCancion.size();
                            %>
                            <div>
                                <table class="table" style="margin-bottom: 10px;">
                                    <tr>
                                        <th style="width: 16%">ISRC</th>
                                        <th style="width: 10%">Track</th>
                                        <th style="width: 44%">Nombre</th>
                                        <th style="width: 10%">Duraci&oacute;n</th>
                                        <th style="width: 20%"></th>
                                    </tr>
                                    <% for(int j = 0; j < cantCanciones; j++){
                                        can = listaCancion.get(j); %>
                                        <tr id="<%= j %>">
                                            <td style="width: 16%">
                                                <span><%= can.getIsrc() %></span>
                                                <input type="text" class="form-control hidden" name="isrc" value="<%= can.getIsrc() %>">
                                            </td>
                                            <td style="width: 10%">
                                                <span><%= can.getTrack() %></span>
                                                <input type="text" class="form-control hidden" name="track" value="<%= can.getTrack() %>">
                                            </td>
                                            <td style="width: 44%">
                                                <span><%= can.getNombre() %></span>
                                                <input type="text" class="form-control hidden" name="cancion" value="<%= can.getNombre() %>">
                                            </td>
                                            <td style="width: 10%">
                                                <span><%= can.getDuracion() %></span>
                                                <input type="text" class="form-control hidden" name="duracion" value="<%= can.getDuracion() %>">
                                            </td>
                                            <td style="width: 20%">
                                                <a class="btn btn-primary btn-warning" onclick="editarCancion('<%= j %>')">e</a>
                                                <a class="btn btn-primary btn-danger" onclick="eliminarCancion('<%= j %>')">-</a>
                                                <a class="btn btn-primary btn-success hidden" onclick="confirmarCancion('<%= j %>')">c</a>
                                            </td>
                                        </tr>
                                    <% } %>
                                </table>
                                <a class="btn btn-primary btn-success" style="margin-bottom: 10px; margin-right: 10px; float: right;" onclick="agregarCancion()">+</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12" style="margin-bottom: 10px; text-align: center;">
                        <input type="submit" class="btn btn-primary" value="Confirmar" />
                        <a href="t_index_modificar.jsp" class="btn btn-primary" style="margin-left: 10px">Volver</a>
                    </div>
                </form>
                <% } else{ %>
                    <!--RESTRICCIÓN PARA LOS NO ADMINISTRADORES -->
                    <h3 style="text-align: center; font-style: italic;">
                    Lo sentimos, página sólo habilitada para administradores.
                    </h3>
                    <hr> 
                <% }
            }
        }
        else{%>
            <!--RESTRICCIÓN PARA USUARIO NO LOGUEADO-->
            <h3 style="text-align: center; font-style: italic;">
                Lo sentimos, debe iniciar sesión como administrador.
            </h3>
            <hr>                
        <%}%>
    </div>
</div>
<script>
    function editarCancion(i){
        var row = $("tr#" + i);
        row.find("span").addClass("hidden");
        row.find("input").removeClass("hidden");
        row.find("a").toggleClass("hidden");
        $("form a, form input[type=submit]").not("tr#" + i + " a").attr("disabled", "disabled");
    }
    function confirmarCancion(i){
        // Faltan validaciones
        var row = $("tr#" + i);
        $.each(row.find("td"), function(index, value){
            $(value).find("span").text($(value).find("input").val());
        });
        row.find("span").removeClass("hidden");
        row.find("input").addClass("hidden");
        row.find("a").toggleClass("hidden");
        $("form a, form input[type=submit]").removeAttr("disabled");
    }
    function eliminarCancion(i){
        if(confirm("¿Esta seguro de eliminar la canción?")){
            var row = $("tr#" + i);
            var upc = $("#upc").val();
            var isrc = row.find("td:first-child span").text();
            $.ajax("cBaja.do", {
                type: "POST",
                dataType: null,
                data: { "upc": upc, "isrc": isrc },
                error: function(){
                    alert("Error al eliminar la canción.");
                },
                success: function(){
                    row.remove();
                }
            });
        }
    }
    function agregarCancion(){
        var id = $("table tr").length;
        var tr = $("<tr>", { "id": id });
        
        var td = $("<td>", { "style": "width: 16%"});
        td.append($("<span>", { "class": "hidden" }));
        td.append($("<input>", { "type": "text", "class": "form-control", "name": "isrc" }));
        tr.append(td);
        
        td = $("<td>", { "style": "width: 10%"});
        td.append($("<span>", { "class": "hidden" }));
        td.append($("<input>", { "type": "text", "class": "form-control", "name": "track" }));
        tr.append(td);
        
        td = $("<td>", { "style": "width: 44%"});
        td.append($("<span>", { "class": "hidden" }));
        td.append($("<input>", { "type": "text", "class": "form-control", "name": "cancion" }));
        tr.append(td);
        
        td = $("<td>", { "style": "width: 10%"});
        td.append($("<span>", { "class": "hidden" }));
        td.append($("<input>", { "type": "text", "class": "form-control", "name": "duracion" }));
        tr.append(td);
        
        td = $("<td>", { "style": "width: 20%"});
        td.append($("<a>", { "class": "btn btn-primary btn-warning hidden", "onclick": "editarCancion(" + id + ")", "text": "e" }));
        td.append($("<a>", { "class": "btn btn-primary btn-danger hidden", "onclick": "eliminarCancion(" + id + ")", "style": "margin-left: 4px;", "text": "-" }));
        td.append($("<a>", { "class": "btn btn-primary btn-success", "onclick": "confirmarCancion(" + id + ")", "text": "c" }));
        tr.append(td);
        
        tr.appendTo("table");
        
        $("form a, form input[type=submit]").not("tr#" + id + " a").attr("disabled", "disabled");
    }
</script>