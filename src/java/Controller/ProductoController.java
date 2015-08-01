/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Disco;
import Actions.Validacion;

/**
 *
 * @author Dormitorio
 */
public class ProductoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Validacion validar = new Validacion();
        String funcion = request.getParameter("funcion");
        
        Actions.Productos.ProductosFunciones funciones = new Actions.Productos.ProductosFunciones();
        
        if(validar.estaVacio(funcion)==true)
        {  
            switch (funcion){
                case "login": { // <editor-fold desc="LOGIN">
                                try{
                                    
                                    break;
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("ERROR OCURRIDO:  "+e);break;
                                    }
                                // </editor-fold>
                              }
                case "alta":  {// <editor-fold desc="ALTA">
                               try{
                                    Disco prod = new Disco();
                                   
                                    String tipo = request.getParameter("tipo");
                                    int codigo;
                                    
                                    //BUSCA EL PRODUCTO SEGÚN EL TIPO DE PRODUCTO QUE SE HAYA QUERIDO CARGAR
                                    if(tipo.equals("cancion")){
                                        codigo = Integer.parseInt(request.getParameter("isrc"));
                                        
                                    } else { 
                                        codigo = Integer.parseInt(request.getParameter("upc"));
                                    }
                                    
                                    if(funciones.buscar(prod, tipo, codigo))
                                    {response.getWriter().print("EL PRODUCTO YA SE ENCUENTRA REGISTRADO");
                                        
                                    }else{
                                        funciones.alta(prod);
                                        response.getWriter().print("PRODUCTO SE REGISTRO DE MANERA EXITOSA");
                                    }
                                    break;
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR ES EL SIGUIENTE:  "+e);break;
                                    }     
                               // </editor-fold>
                              }
                case "baja":  {// <editor-fold desc="BAJA">
                                   
                                try{
                                    
                                  /*  Producto prod = new Producto();
                                    

                                    if(funciones.buscar(prod))
                                    {
                                        funciones.baja(prod);
                                        response.getWriter().print("Usuario eliminado.");
                                        
                                    }else{
                                            response.getWriter().print("Usuario no encontrado.");
                                    }
                                  */
                                    

                                    break;
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR OCURRIDO ES:"+e);
                                    } 
                    
                    
                    
                               // </editor-fold>
                              }
                case "modificar":{// <editor-fold desc="MODIFICAR">
                                    
                                try{    Disco prod = new Disco();
                                
                                        funciones.actualizar(prod);
                                        response.getWriter().print("USUARIO SE ACTUALIZÓ DE MANERA EXITOSA");
                                            
                                        break;
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR OCURRIDO ES:"+e);break;
                                    }
                                    // </editor-fold>
                                 }
                case "logout":{// <editor-fold desc="LOGOUT">
                                
                                
                                try{
                                   
                                   
                                    break;
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR OCURRIDO ES: "+e);break;
                                    }
                     
                               // </editor-fold>
                              }
                
                case "listar":{// <editor-fold desc="LISTAR">
                                    
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
