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
        Actions.Discos.DiscosFunciones funcionesDisco = new DiscosFunciones();
        
    try{                        
        HttpSession sesion = request.getSession(true);

         //SE INSTANCIA UNA CANCIÓN Y SE CARGA CON LOS VALORES OBTENIDOS DEL FORMULARIO
        
                    String nombre = request.getParameter("nombre");
                    int upc = Integer.parseInt(request.getParameter("upc"));
                    long isrc  = Long.parseLong(request.getParameter("isrc"));
                    int track  = Integer.parseInt(request.getParameter("track"));
                    float precio = Float.parseFloat(request.getParameter("precio"));
                    float duracion = Float.parseFloat(request.getParameter("duracion"));

                    Cancion cancion = new Cancion(nombre, precio, isrc, upc, duracion, track);
                    ArrayList<Model.Cancion> lista = new ArrayList<>();
                    ArrayList<Model.Cancion> listaAux = (ArrayList<Model.Cancion>)sesion.getAttribute("cancionesDisco");
                    
                     if ( listaAux == null){
                        lista.add(cancion);
                        sesion.setAttribute("cancionesDisco", lista);
                       }
                     else{
                         listaAux.add(cancion);
                         sesion.setAttribute("cancionesDisco", listaAux); 
                         sesion.setAttribute("UltimoUpc",upc);
                     }
                    
                    //response.getWriter().print("LA CANCIÓN SE REGISTRÓ CORRECTAMENTE");
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
