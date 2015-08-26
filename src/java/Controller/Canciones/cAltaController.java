package Controller.Canciones;

import Actions.Discos.DiscosFunciones;
import Model.Cancion;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class cAltaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        Actions.Canciones.CancionesFunciones funciones = new Actions.Canciones.CancionesFunciones();
        
        
    try{                        
        HttpSession sesion = request.getSession(true);
        if (sesion.getAttribute("ultimoUpc")!= null) {
            
            if (sesion.getAttribute("cancionesDisco") != null) {
              ArrayList<Model.Cancion> lista = (ArrayList<Model.Cancion>) sesion.getAttribute("cancionesDisco");
                funciones.alta(lista, (String) sesion.getAttribute("ultimoUpc"));
            }else {
             sesion.setAttribute("mensajeError", "Debe registrar al menos una canción.");
             response.sendRedirect("c_alta.jsp");
            }
            
        }else{
         sesion.setAttribute("mensajeError", "Debe registrar un disco para crear canciones.");
         response.sendRedirect("u_alta.jsp");
        }
         //SE INSTANCIA UNA CANCIÓN Y SE CARGA CON LOS VALORES OBTENIDOS DEL FORMULARIO
            
    }
    catch (Exception e)
        {
        response.getWriter().print("ERROR OCURRIDO:  "+e);
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
