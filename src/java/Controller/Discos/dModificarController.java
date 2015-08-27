package Controller.Discos;

import Actions.Canciones.CancionesFunciones;
import Model.Disco;
import Model.Cancion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Actions.Discos.DiscosFunciones;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;


public class dModificarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession(true); 
        DiscosFunciones funciones = new DiscosFunciones();
	CancionesFunciones funcionesCanciones = new CancionesFunciones();
        try{
            //SE INSTANCIA UN DISCO Y SE CARGA CON LOS VALORES OBTENIDOS DEL FORMULARIO
            String artista = request.getParameter("artista");
            String album = request.getParameter("album");
            String genero = request.getParameter("genero");
            String descripcion = request.getParameter("descripcion");
          
            long upc= Long.parseLong(request.getParameter("upc1"));
            int stock = Integer.parseInt(request.getParameter("stock"));
           

            float precio = Float.parseFloat(request.getParameter("precio"));
            
            ArrayList<Cancion> canciones = new ArrayList<>();
            String[] isrc = request.getParameterValues("isrc"); // Trae todos los valores con el mismo name asociado
            String[] cancion = request.getParameterValues("cancion");
            String[] track = request.getParameterValues("track");
            String[] duracion = request.getParameterValues("duracion");
            
            for (int i = 0; i < isrc.length; i++) {
                // Cargar canciones en lista
                Cancion canc = new Cancion();
                canc.setDatos(cancion[i], 0, Long.parseLong(isrc[i]), upc, Float.parseFloat(duracion[i]), Integer.parseInt(track[i]));
                canciones.add(canc);
            }
            
            funcionesCanciones.modificarPrecio(precio, upc);
            Disco disco = new Disco(artista, album, genero, descripcion, null, upc, stock);
            funciones.modificar(disco, canciones, precio);
            sesion.setAttribute("upc", null);
            sesion.setAttribute("mensajeExito", "Disco modificado correctamente.");
            response.sendRedirect("exito.jsp");
        }
        catch (Exception e)
        {sesion.setAttribute("errorCatch", e.toString());
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