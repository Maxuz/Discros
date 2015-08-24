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
 
function validaBusqueda()
{
    var ok =0;
    
    var texto = $('#texto').val();
    var tipo = $('#tipo').val();;
    
    if(!estaVacio(texto))
    {   
        $("#formText").addClass('has-error');
    
    }else   {
             $("#formText").removeClass('has-error');
             ok=ok+1;
        
            }
            
    if(!estaVacio(tipo))
    {    $("#formTipo").addClass('has-error');
         e.preventDefault();
    }else   {
             $("#formTipo").removeClass('has-error');
             ok=ok+1;   
        
            }
    
    if(ok===2){
    window.location.href= "t_busqueda.jsp?texto="+texto+"&tipo="+tipo;
    }
}; 