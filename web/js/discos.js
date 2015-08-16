

//FUNCION PARA VALIDAR EL FORMULARIO ALTA
var funciones = {

    validaAlta: function(){
    
    var upc = $("#upc").val();
    var artista = $("#artista").val();
    var album = $("#album").val();
    var genero = $("#genero").val();
    var stock = $("#stock").val();
    var descri = $("#descripcion").val();
    var precio = $("#precio").val();
    var img = $("#imagen").val();
    var mensaje ="";

    if(!estaVacio(upc)){
        $('#lblUPC').addClass('lblError').text("(*)UPC: - Debe ingresar un UPC.");
        mensaje = mensaje +"UPC\n";
    }else if(!soloNumero(upc)){
         $('#lblUPC').addClass('lblError').text("(*)UPC: - Debe ingresar solo números en UPC.");
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
        $('#lblGenero').addClass('lblError').text("(*)Género: - Debe ingresar género.");
        mensaje = mensaje + "genero\n";
    }else{
        $('#lblGenero').removeClass('lblError').text("Genero:");
    }
    if (!estaVacio(stock)){
        $('#lblStock').addClass('lblError').text("(*)Stock: - Debe ingresar Stock.");
        mensaje = mensaje +"stock\n";
    }else if(!soloNumero(stock)){
       $('#lblStock').addClass('lblError').text("(*)Stock: - Debe ingresar sólo números en Stock.");
       mensaje = mensaje +"stock sólo número\n";
    } else {
        $('#lblStock').removeClass('lblError').text("Stock:");
    }
    if (!estaVacio(descri)){
        $('#lblDescripcion').addClass('lblError').text("(*)Descripción: - Debe ingresar una descripción.");
        mensaje = mensaje +"descri\n";
    }else{
        $('#lblDescripcion').removeClass('lblError').text("Descripción: - Debe ingresar un UPC.");
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
        console.log(mensaje+"imagen: "+img);
    }
},

    agregarCancion: function(){
        
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
        } else{
            $('#lblIsrc').removeClass('lblError').text("ISRC:");
        }
        if (!estaVacio(track)){
            $('#lblTrack').addClass('lblError').text("(*)Track: - Debe ingresar un Track.");
            mensaje = mensaje + " Track\n";
        }
        else if (!soloNumero(track)){
            $('#lblTrack').addClass('lblError').text("(*)Track: - El track debe ser sólo númerico.");
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
            $('#lblTrack').addClass('lblError').text("(*)Duracion: - Debe ingresar un Track.");
            mensaje = mensaje + " Duracion\n";
        }
        else if (!soloNumero(duracion)){
            $('#lblTrack').addClass('lblError').text("(*)Track: - El track debe ser sólo númerico.");
            mensaje = mensaje + " Duracion numero\n";
        }else {
            $('#lblTrack').removeClass('lblError').text("Track:");
        }
        if (mensaje ===""){
            var tds = '<tr>';
            tds += '<td>'+isrc+'</td>';
            tds += '<td>'+track+'</td>';
            tds += '<td>'+nombre+'</td>';
            tds += '<td>'+duracion+'</td>';
            tds += '<td>'+precio+'</td>';
            tds += '</tr>';
            $("#tablaCanciones").append(tds);
            $("#prueba").removeClass('hidden');
            return true;
        }else{
            console.log(mensaje);
            return false;
        }
    }
        
    
};

$(document).ready(function(){
    $("#dAlta").submit(function(e){
        e.preventDefault();
        funciones.validaAlta();
    });
});

$(document).ready(function(){
    $("#add").click(function(e){
        e.preventDefault();
        funciones.agregarCancion();
    });
});

