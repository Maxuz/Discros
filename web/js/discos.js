

//FUNCION PARA VALIDAR EL FORMULARIO ALTA

 
var funciones = {

    validaAlta: function(e){
    
    var upc = $("#upc").val();
    var artista = $("#artista").val();
    var album = $("#album").val();
    var genero = $("#genero").val();
    var stock = $("#stock").val();
    var descri = $("#descripcion").val();
    var precio = $("#precio").val();
    var img = $("#file").val();
    var mensaje ="";

    if(!estaVacio(upc)){
        $('#lblUPC').addClass('lblError').text("(*)UPC: - Debe ingresar un UPC.");
        mensaje = mensaje +"UPC\n";
    }else if(!soloNumero(upc)){
         $('#lblUPC').addClass('lblError').text("(*)UPC: - Debe ingresar solo n\u00fameros en UPC.");
        mensaje = mensaje +"UPC solo número \n";
    }else{
        $('#lblUPC').removeClass('lblError').text("UPC:");
    }
    if (!estaVacio(artista)){
        $('#lblArtista').addClass('lblError').text("Artista: - Debe ingresar un Artista.");
        mensaje = mensaje +"Aritsta\n";
    }else{
        $('#lblArtista').removeClass('lblError').text("Artista:");
    }
    if (!estaVacio(album)){
        $('#lblAlbum').addClass('lblError').text("(*)Album: - Debe ingresar un Album.");
        mensaje = mensaje + "album\n";
    }else{
        $('#lblAlbum').removeClass('lblError').text("Album:");
    }
    if (!estaVacio(genero)){
        $('#lblGenero').addClass('lblError').text("(*)G\u00e9nero: - Debe ingresar g\u00e9nero.");
        mensaje = mensaje + "genero\n";
    }else{
        $('#lblGenero').removeClass('lblError').text("G\u00e9nero:");
    }
    if (!estaVacio(stock)){
        $('#lblStock').addClass('lblError').text("(*)Stock: - Debe ingresar Stock.");
        mensaje = mensaje +"stock\n";
    }else if(!soloNumero(stock)){
       $('#lblStock').addClass('lblError').text("(*)Stock: - Debe ingresar s\u00f3lo n\u00fameros en Stock.");
       mensaje = mensaje +"stock sólo número\n";
    } else {
        $('#lblStock').removeClass('lblError').text("Stock:");
    }
    if (!estaVacio(descri)){
        $('#lblDescripcion').addClass('lblError').text("(*)Descripci\u00f3n: - Debe ingresar una descripci\u00f3n.");
        mensaje = mensaje +"descri\n";
    }else{
        $('#lblDescripcion').removeClass('lblError').text("Descripci\u00f3n: - Debe ingresar un UPC.");
    }
    if (precio == 0){
        $('#lblPrecio').addClass('lblError').text("(*)Precio: - El precio no puede ser cero.");
        mensaje = mensaje + "precio\n";
    }else {
        $('#lblPrecio').removeClass('lblError').text("Precio:");
    }
    if (mensaje === ""){
        return true;
    }else {
        e.preventDefault();
        console.log(mensaje+"imagen: "+img);
    }
},
    agregarCancion: function(){
        var upc = $("#upc").val();
        var isrc = $("#isrc").val();            //vacio y longitud 12
        var track = $("#track").val();          //vacio solo numero
        var nombre = $("#nombre").val();        //vacio 
        var duracion = $("#duracion").val();    //vacio y solo numero
        var precio = $("#precio2").val();       //vacio y solo numero
        var mensaje ="";
    
        if(!estaVacio(isrc)){
            $('#lblIsrc').addClass('lblError').text("(*)ISRC: - Debe ingresar un ISRC.");
            mensaje = mensaje + " ISRC\n";
        }else if(isrc.length !== 12){
            $('#lblIsrc').addClass('lblError').text("(*)ISRC: - La longitud del ISRC debe ser 12.");
            mensaje = mensaje + " ISRC\n";
        }else if(!soloNumero(isrc.length)) {
            $('#lblIsrc').addClass('lblError').text("(*)ISRC: - Sólo número.");
            mensaje = mensaje + " ISRC número\n";
        } else{
            $('#lblIsrc').removeClass('lblError').text("ISRC:");
        }
        if (!estaVacio(track)){
            $('#lblTrack').addClass('lblError').text("(*)Track: - Debe ingresar un Track.");
            mensaje = mensaje + " Track\n";
        }
        else if (!soloNumero(track)){
            $('#lblTrack').addClass('lblError').text("(*)Track: - El track acepta s\u00f3lo n\u00fameros.");
            mensaje = mensaje + " Track numero\n";
        }else {
            $('#lblTrack').removeClass('lblError').text("Track:");
        }
        if (!estaVacio(nombre)){
            $('#lblNombre').addClass('lblError').text("(*)Nombre: - Debe ingresar un Nombre.");
            mensaje = mensaje + " Nombre\n";
        }else{
            $('#lblNombre').removeClass('lblError').text("Nombre:");
        }
        if (!estaVacio(duracion)){
            $('#lblDuracion').addClass('lblError').text("(*)Duraci\u00f3n: - Debe ingresar la duraci\u00f3n.");
            mensaje = mensaje + " Duracion\n";
        }
        else if (!soloNumero(duracion)){
            $('#lblDuracion').addClass('lblError').text("(*)Duraci\u00f3n - La duracci\u00f3n acepta s\u00f3lo n\u00fameros.");
            mensaje = mensaje + " Duracion numero\n";
        }else {
            $('#lblDuracion').removeClass('lblError').text("Duraci\u00f3n:");
        }
         if (!estaVacio(precio)){
            $('#lblPrecio2').addClass('lblError').text("(*)Precio: - Debe ingresar el precio.");
            mensaje = mensaje + " Precio\n";
        }
        else if (!soloNumero(precio)){
            $('#lblPrecio2').addClass('lblError').text("(*)Precio: - El precio acepta s\u00f3lo n\u00fameros.");
            mensaje = mensaje + " Precio número\n";
        }else {
            $('#lblPrecio2').removeClass('lblError').text("Precio:");
        }
        
        if (mensaje ===""){
            agregar(upc,isrc,track,nombre,duracion,precio);
            var tds = '<tr>';
            tds += '<td>'+isrc+'</td>';
            tds += '<td>'+track+'</td>';
            tds += '<td>'+nombre+'</td>';
            tds += '<td>'+duracion+'</td>';
            tds += '<td>'+precio+'</td>';
            tds += '</tr>';
            $("#tablaCanciones").append(tds);
            $("#prueba").removeClass('hidden');
            
            $("#isrc").val("");         
            $("#track").val("");          
            $("#nombre").val("");         
            $("#duracion").val("");    
            $("#precio2").val("");       
            return true;
            
        }else{
            console.log(mensaje);
            return false;
        }
    }
};
function agregar(upc,isrc,track,nombre,duracion,precio){
       $.ajax("cAlta.do", {
             
             type: "POST",
             dataType: null,
             
             data: { "upc":upc, "isrc":isrc, "track":track, "nombre":nombre, "duracion":duracion, "precio":precio},
             
             error: function (a, b, c)
                     {
                        window.alert("ERROR A: "+a+"  | ERROR B: "+b+"  | ERROR C: "+c);
                 
             },
             success: function (data)
                     {
                        // alert("upc:"+upc+"isrc:"+isrc);
                     }
            
            });
 };
    

$(document).ready(function(){
   
    $("#dAlta").submit(function(e){
        funciones.validaAlta(e);
    });
    
    $("#add").click(function(e){
        e.preventDefault();
        funciones.agregarCancion();
    });
});

