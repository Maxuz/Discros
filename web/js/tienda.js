function agregar(upc){
       $.ajax("cAdd.do", {
             
             type: "POST",
             dataType: null,
             
             data: { "upc": upc},
             
             error: function (a, b, c)
                     {
                        window.alert("ERROR A: "+a+"  | ERROR B: "+b+"  | ERROR C: "+c);
                 
             },
             success: function (data)
                     {
                         location.reload();
                     }
            
            });
 };
                            
function show(id) {
    var obj = document.getElementById(id);
    obj.style.display = (obj.style.display === 'none') ? 'block' : 'none';
}
                               
 
function borrar(upc){
       $.ajax("cDelete.do", {
             
             type: "POST",
             dataType: null,
             
             data: { "upc": upc},
             
             error: function (a, b, c)
                     {
                        window.alert("ERROR A: "+a+"  | ERROR B: "+b+"  | ERROR C: "+c);
                 
             },
             success: function (data)
                     {
                         location.reload();
                     }
            
            });
 };
 
var funciones = {
 validarr: function(e)
{ 
    var msj = "";
    
    var tipo = $('#tipo').val();
    var texto = $('#texto').val();          
     
    if(!estaVacio(tipo))
    {    $("#formTipo").addClass('has-error');
         msj="error";
    }else   {
             $("#formTipo").removeClass('has-error');
            }
            
    if(!estaVacio(texto))
    {    $("#formText").addClass('has-error');
         msj="error";
    }else if(!soloNumero(texto)){
             $("#formText").addClass('has-error');
            }
            else{ $("#formText").removeClass('has-error');}
       
    
    if(msj==="")
    {
      
        
    }else{
        
     e.preventDefault();  
    }
         
  
}
}; 

$(document).ready(function(){

    $("#actualizarAdmin").submit(function(e){
    funciones.validarr(e);
    });   


    $("#actualizarCliente").submit(function(e){
    funciones.validarr(e);
    }); 
});
