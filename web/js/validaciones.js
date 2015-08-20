var isEmail = function(email){
    expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (expr.test(email)){
        return true;
    } else {
        return false;
    }
};
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
var isJpg = function(campo){
    expr = /\.jpg$/i;
    
    if (expr.test(campo)){
        return true;
    }else {
        return false;
    }        
};
/*
\u00e1 -> á 
\u00e9 -> é 
\u00ed -> í 
\u00f3 -> ó 
\u00fa -> ú 
\u00c1 -> Á 
\u00c9 -> É 
\u00cd -> Í 
\u00d3 -> Ó 
\u00da -> Ú 
\u00f1 -> ñ 
\u00d1 -> Ñ
 */

