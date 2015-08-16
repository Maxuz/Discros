package Controller.Discos;

import Actions.Canciones.CancionesFunciones;
import Model.Cancion;
import Model.Disco;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class dAltaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Actions.Discos.DiscosFunciones funciones = new Actions.Discos.DiscosFunciones();
        Actions.Canciones.CancionesFunciones funcionesCanciones = new CancionesFunciones();
        HttpSession sesion = request.getSession(true); 
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
                                        Disco disco = new Disco(artista, album, genero, descripcion, imagen, upc, stock, fechafecha);
                                                                              
                                        funciones.alta(disco);
                                        funcionesCanciones.alta(cancion);
                                    
                                        
                                        sesion.setAttribute("mensajeExito", "Disco agregado correctamente.");
                                        RequestDispatcher rd =null;
                                                                               
                                        rd=request.getRequestDispatcher("d_alta.jsp");
                                        rd.forward(request,response);
                                        
                                        }
                                    
                                  
                                    }
                                catch (Exception e)
                                    {
                                        sesion.setAttribute("errorCatch", e.toString());
                                        RequestDispatcher rd =null;
                                                                               
                                        rd=request.getRequestDispatcher("error.jsp");
                                        rd.forward(request,response);
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
