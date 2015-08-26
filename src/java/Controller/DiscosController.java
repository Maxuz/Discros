package Controller;

import Actions.Canciones.CancionesFunciones;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Actions.Util;
import Model.Disco;
import Model.Cancion;

public class DiscosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        Util validar = new Util();
        String funcion = request.getParameter("funcion");
        
        Actions.Discos.DiscosFunciones funciones = new Actions.Discos.DiscosFunciones();
        Actions.Canciones.CancionesFunciones funcionesCanciones = new CancionesFunciones();
        
        if(validar.estaVacio(funcion)==true)
        {  
            switch (funcion){
                case "alta": { // <editor-fold desc="ALTA">
                                try{
                                    if(funciones.buscar(Integer.parseInt(request.getParameter("upc"))))
                                    {
                                        response.getWriter().print("EL DISCO YA SE ENCUENTRA REGISTRADO");
                                        
                                    } else{
                                        
                                        //SE INSTANCIA UN DISCO Y SE CARGA CON LOS VALORES OBTENIDOS DEL FORMULARIO
                                        String artista = request.getParameter("artista");
                                        String album = request.getParameter("album");
                                        String genero = request.getParameter("genero");
                                        String descripcion = request.getParameter("descripcion");
                                        String imagen = request.getParameter("imagen");
                                        int upc= Integer.parseInt(request.getParameter("upc"));
                                        int stock = Integer.parseInt(request.getParameter("stock"));
                                        String fechafecha = request.getParameter("fecha");
                                        
                                        float precio = Float.parseFloat(request.getParameter("precio"));
                                        
                                        Cancion cancion = new Cancion(null, precio, 0, upc, 0, 0);
                                        Disco disco = new Disco(artista, album, genero, descripcion, imagen, upc, stock);
                                                                              
                                        funcionesCanciones.alta(cancion);
                                        response.getWriter().print("EL DISCO SE REGISTRÓ CORRECTAMENTE");
                                        
                                        }
                                    
                                    break;
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("ERROR OCURRIDO:  "+e);break;
                                    }
                                // </editor-fold>
                              }
                case "baja":  {// <editor-fold desc="BAJA">
                               try{
                                    if(funciones.buscar(Integer.parseInt(request.getParameter("upc"))))
                                    {
                                        funcionesCanciones.bajaAll(Integer.parseInt(request.getParameter("upc")));
                                        
                                        funciones.baja(Integer.parseInt(request.getParameter("upc")));
                                        response.getWriter().print("El disco y sus canciones han sido eliminados correctamente.");
                                    } else {
                                             response.getWriter().print("Disco no encontrado.");
                                            }
                                    break;
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR ES EL SIGUIENTE:  "+e);break;
                                    }     
                               // </editor-fold>
                              }
                case "modificar":{// <editor-fold desc="MODIFICAR">
                                   
                                try{
                                    //SE INSTANCIA UN DISCO Y SE CARGA CON LOS VALORES OBTENIDOS DEL FORMULARIO
                                        String artista = request.getParameter("artista");
                                        String album = request.getParameter("album");
                                        String genero = request.getParameter("genero");
                                        String descripcion = request.getParameter("descripcion");
                                        String imagen = request.getParameter("imagen");
                                        int upc= Integer.parseInt(request.getParameter("upc"));
                                        int stock = Integer.parseInt(request.getParameter("stock"));
                                        String fechafecha = request.getParameter("fecha");
                                        
                                        float precio = Float.parseFloat(request.getParameter("precio"));
                                        
                                        funcionesCanciones.modificarPrecio(precio, upc);
                                        Disco disco = new Disco(artista, album, genero, descripcion, imagen, upc, stock);
                                        
                                        
                                        
                                        funciones.modificar(disco);
                                        response.getWriter().print("Disco actualizado correctamente.");
                                    break;
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR OCURRIDO ES:"+e);
                                    } 
                    
                    
                    
                               // </editor-fold>
                              }
                case "getOne":{// <editor-fold desc="GETONE">
                                    
                                try{    Disco disco = new Disco();
                                        int upc = Integer.parseInt(request.getParameter("upc"));
                                        disco = funciones.getOne(upc);
                                        response.getWriter().print("El disco ha sido obtenido correctamente");
                                            break;
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR OCURRIDO ES:"+e);break;
                                    }
                                    // </editor-fold>
                                 }
                
                default: break;
            }
            }
            
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
