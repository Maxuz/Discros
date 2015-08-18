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