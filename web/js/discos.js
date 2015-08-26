

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
        $('#lblDescripcion').removeClass('lblError').text("Descripci\u00f3n: ");
    }
    if (precio == 0){
        $('#lblPrecio').addClass('lblError').text("(*)Precio: - El precio no puede ser cero.");
        mensaje = mensaje + "precio\n";
    }else {
        $('#lblPrecio').removeClass('lblError').text("Precio:");
    }
    if (!estaVacio(img)){
        $('#lblImagen').addClass('lblError').text("(*)Imagen de la tapa del disco: - Debe seleccionar una imagen.");
        mensaje = mensaje + "img\n";
    }else if(!isJpg(img)){
        $('#lblImagen').addClass('lblError').text("(*)Imagen de la tapa del disco: - La extensión de la imagen debe ser jpg.");
        mensaje = mensaje + "img jpg\n";
    }
    else{
        $('#lblImagen').removeClass('lblError').text("Imagen de la tapa del disco:");
      
    }
        
    if (mensaje === ""){
        
        console.log(img);
        return true;
    }else {
        e.preventDefault();
        console.log(mensaje);
    }
    }
};

$(document).ready(function(){
   
    $("#dAlta").submit(function(e){
        funciones.validaAlta(e);
    });
});

