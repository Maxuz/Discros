package Controller.Discos;

import Actions.Discos.DiscosFunciones;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class dBuscarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession sesion = request.getSession(true); 
        DiscosFunciones funciones = new DiscosFunciones();
        try{                       
                                   
                                    long upc = Long.parseLong(request.getParameter("upc"));
                                    if(funciones.buscar(upc))
                                        {   
                                            String UPC = request.getParameter("upc");
                                            sesion.setAttribute("upc", UPC);
                                            response.sendRedirect("d_modificar.jsp");
                                            
                                        }else{  
                                                sesion.setAttribute("mensajeError", "Disco no encontrado.");
                                                response.sendRedirect("d_buscar.jsp");
                                        }
                                    
                                                                      
                                    }
                                catch (Exception e)
                                    {   sesion.setAttribute("errorCatch", e.toString());
                                                                               
                                             response.sendRedirect("error.jsp");
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
