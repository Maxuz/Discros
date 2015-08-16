//FUNCION PARA REFACTORIZAR LA TABLA DE CANCIONES
$("#add").click(function(event) 
{
    var isrc = $("#isrc").val();
    var track = $("#track").val();
    var nombre = $("#nombre").val();
    var duracion = $("#duracion").val();
    var precio = $("#precio").val();
    
    var n = $('tr:last td', $("#tablaCanciones")).length;
    var tds = '<tr>';
    
    for(var i = 0; i < n; i++){
        tds += '<td>'+isrc+'</td>';
        tds += '<td>'+track+'</td>';
        tds += '<td>'+nombre+'</td>';
        tds += '<td>'+duracion+'</td>';
        tds += '<td>'+precio+'</td>';
        }
        
    tds += '</tr>';
    
    $("#tablaCanciones").append(tds);
    
    $("#prueba").removeClass('hidden');
}
                );


//FUNCION PARA VALIDAR EL FORMULARIO ALTA
var validaAlta = function(event){
    
    
    
     var isrc = $("#isrc").val();
    var track = $("#track").val();
    var nombre = $("#nombre").val();
    var duracion = $("#duracion").val();
    var precio = $("#precio").val();
    
    
    var tds = '<tr>';
    
        tds += '<td>'+isrc+'</td>';
        tds += '<td>'+track+'</td>';
        tds += '<td>'+nombre+'</td>';
        tds += '<td>'+duracion+'</td>';
        tds += '<td>'+precio+'</td>';
           
    tds += '</tr>';
    
    $("#tablaCanciones").append(tds);
    
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
        event.preventDefault();
    }
};

//FUNCIONES PARA VALIDAR CAMPOS DEL FORMULARIO
var estaVacio = function(campo){
    if (campo === undefined || campo==="")
        {
           return false; 
        }
    return true;        
};
var soloNumero = function(campo){
    expr = /^([0-9])*$/;
    if(expr.test(campo))
        return true;
    else{
        return false;
    }
};
var soloTexto = function(campo){
  expr = /^[A-Za-z\_\-\.\s\xF1\xD1]+$/;
    if (expr.test(campo)){
        return true;
    }else {
        return false;
    }
};