package Controller.Carrito;

import Actions.Discos.DiscosFunciones;
import Model.Disco;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Actions.Util;

public class cDeleteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try
        {   HttpSession sesion = request.getSession(true);
            
            Util util = new Util();
            
            String UPC = request.getParameter("upc");
            int upc = Integer.parseInt(UPC);
            
            //SETEO DE LA CANTIDAD DE ITEMS EN EL CARRITO VERIFICANDO LA CANTIDAD ACTUAL
            int cant = Integer.parseInt(sesion.getAttribute("itemsTotal").toString());
            cant = cant+1;
            sesion.setAttribute("itemsTotal", cant);
            
            //SETEO EL DISCO EN LA SESION PARA MOSTRAR LUEGO EN EL CARRITO
            DiscosFunciones funciones = new DiscosFunciones();
            Disco dis = funciones.getOne(upc);
            
            ArrayList<Disco> lista = new ArrayList<>();
            ArrayList<Disco> listaAux = (ArrayList<Disco>)sesion.getAttribute("listaCarrito");
            
            
            if(listaAux==null)
            {    lista.remove(dis);
                 sesion.setAttribute("listaCarrito", lista);
                 
            }else {
                    int i = util.getIndice(listaAux, dis);
                    listaAux.remove(i);
                    sesion.setAttribute("listaCarrito", listaAux); 
                    
                  }
           
            
            
            //DETERMINA EL NOMBRE DEL CAMPO DE LA VARIABLE DE SESION: invento para establecer un índice
            String nombreVariable = "item"+cant;
            
           
        
        
        }
        catch(Exception e)
        {
        
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
