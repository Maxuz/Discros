package Controller.Usuario;

import Actions.StringMD;
import Actions.Usuarios.UsuariosFunciones;
import Model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class uModificarController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
         HttpSession sesion = request.getSession(true); 
         UsuariosFunciones funciones = new UsuariosFunciones();
         try{
            //String passAnterior = request.getParameter("passAnterior");
            String temp = (String)sesion.getAttribute("email"); // Si esta logueado el usuario

            if( temp != null)
            {
                Usuario usuActual = funciones.getOne(temp);
                
                String passAnterior = request.getParameter("passVieja");
                String passNueva = request.getParameter("pass");
                String passRepetida = request.getParameter("pass2");
                
                // Si modifico contraseña...
                if(!passAnterior.trim().isEmpty() && !passNueva.trim().isEmpty() && !passRepetida.trim().isEmpty()){
                    passAnterior = StringMD.getStringMessageDigest(request.getParameter("passVieja"), StringMD.SHA1);
                    if(passAnterior.equals(usuActual.getPass()) && passNueva.equals(passRepetida)){
                        usuActual.setPass(StringMD.getStringMessageDigest(passNueva, StringMD.SHA1));
                    }
                    else
                    {
                        response.getWriter().print("La contraseña anterior no es correcta.");
                    }
                }
                
                // REALIZAR MÉTODO PARA ENCRIPTAR
                //  String pass  = MÉTODOENCRIPTAR(request.getParameter("pass"));

                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String direccion = request.getParameter("direccion");
                String ciudad = request.getParameter("ciudad");
                String provincia = request.getParameter("provincia");
                Integer dni = Integer.parseInt(request.getParameter("dni"));

                usuActual.setDatosPersonales(temp, nombre, apellido, direccion, ciudad, provincia, dni);

                funciones.modificar(usuActual);

                //response.getWriter().print("USUARIO SE ACTUALIZÓ DE MANERA EXITOSA");
                sesion.setAttribute("mensajeExito", "Datos modificados correctamente.");
                response.sendRedirect("u_modificar.jsp");
            }
            else { 
                response.getWriter().print("No hay ningún usuario logueado.");
            }
        }catch (Exception e)
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
