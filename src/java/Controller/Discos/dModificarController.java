package Controller.Discos;

import Actions.Canciones.CancionesFunciones;
import Model.Disco;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dModificarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Actions.Discos.DiscosFunciones funciones = new Actions.Discos.DiscosFunciones();
        Actions.Canciones.CancionesFunciones funcionesCanciones = new CancionesFunciones();
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
                                        Disco disco = new Disco(artista, album, genero, descripcion, imagen, upc, stock, fechafecha);
                                        
                                        
                                        
                                        funciones.modificar(disco);
                                        response.getWriter().print("Disco actualizado correctamente.");
                                
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR OCURRIDO ES:"+e);
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
