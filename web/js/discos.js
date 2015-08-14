/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var validaAlta = function(event){
    var upc = $("#upc").val();
    var artista = $("#artista").val();
    var album = $("#album").val();
    var genero = $("#genero").val();
    var descri = $("#descripcion").val();
    var precio = $("#precio").val();
    var img = $("#imagen").val();
    var mensaje ="";
    
    console.log("Sabe vieja");
    event.preventDefault();
    $('#lblemail1').addClass('lblError').text("(*)Email - Debe ingresar un email.");
    
};

var estaVacio = function(campo){
    if (campo === undefined || campo==="")
        {
           return false; 
        }
    return true;        
};