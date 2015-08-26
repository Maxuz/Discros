/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var funciones = {
agregarCancion:  function(){
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
            agregar(isrc,track,nombre,duracion,precio);
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
    
function agregar(isrc,track,nombre,duracion,precio){
   $.ajax("caAdd.do", {

         type: "POST",
         dataType: null,

         data: { "isrc":isrc, "track":track, "nombre":nombre, "duracion":duracion, "precio":precio},

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
    
    $("#add").click(function(e){
        e.preventDefault();
        funciones.agregarCancion();
    });
    
});

