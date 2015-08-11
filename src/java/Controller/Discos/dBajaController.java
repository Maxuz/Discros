package Controller.Discos;

import Actions.Canciones.CancionesFunciones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dBajaController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Actions.Discos.DiscosFunciones funciones = new Actions.Discos.DiscosFunciones();
        Actions.Canciones.CancionesFunciones funcionesCanciones = new CancionesFunciones();
         try{
                                    if(funciones.buscar(Integer.parseInt(request.getParameter("upc"))))
                                    {
                                        funcionesCanciones.bajaAll(Integer.parseInt(request.getParameter("upc")));
                                        
                                        funciones.baja(Integer.parseInt(request.getParameter("upc")));
                                        response.getWriter().print("El disco y sus canciones han sido eliminados correctamente.");
                                    } else {
                                             response.getWriter().print("Disco no encontrado.");
                                            }
                               
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR ES EL SIGUIENTE:  "+e);
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
