package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Usuario;
import Actions.Validacion;


public class UsuarioController extends HttpServlet {

    
    @SuppressWarnings("empty-statement")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession sesion = request.getSession(true); 
                
        Validacion validar = new Validacion();
        String funcion = request.getParameter("funcion");
        
        Actions.Usuarios.UsuariosFunciones funciones = new Actions.Usuarios.UsuariosFunciones();
        
        if(validar.estaVacio(funcion)==true)
        {  
            switch (funcion){
                case "login": { // <editor-fold desc="LOGIN">
                                try{
                                    String email = request.getParameter("email");
                                    String pass  = request.getParameter("pass");
                                    Usuario user = new Usuario(email, pass);
                                    
                                    String temp = (String)sesion.getAttribute("email"); 
                                    if( temp == null)        
                                    {if(funciones.login(user))
                                        {   
                                            user = funciones.getOne(email);
                                            //GUARDA LA INFORMACIÓN DEL USUARIO LOGUEADO
                                            
                                            /*
                                            *   NO ES LA MEJOR OPCIÓN, PUEDE MEJORAR, SE PUSO DE ESTA FORMA PARA PROBAR LA VARIABLE DE SESION
                                            *
                                            */
                                            
                                            sesion.setAttribute("email", email);
                                            sesion.setAttribute("pass", user.getPass());
                                            sesion.setAttribute("nombre", user.getNombre());
                                            sesion.setAttribute("apellido", user.getApellido());
                                            sesion.setAttribute("direccion", user.getDireccion());
                                            sesion.setAttribute("ciudad", user.getCiudad());
                                            sesion.setAttribute("dni", user.getdni());
                                            sesion.setAttribute("provincia", user.getProvincia());
                                            
                                            response.getWriter().print("Login exitoso.");

                                        }else{
                                                response.getWriter().print("Usuario no encontado.");
                                        }
                                    } else {response.getWriter().print("Ya hay un usuario registrado."); }
                                    
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
                                    String email = request.getParameter("email");
                                    String pass  = request.getParameter("pass");
                                    
                                    if(funciones.buscar(email))
                                    {response.getWriter().print("EL USUARIO YA SE ENCUENTRA REGISTRADO");
                                        
                                    }else{
                                        
                                        String nombre = request.getParameter("nombre");
                                        String apellido = request.getParameter("apellido");
                                        String direccion = request.getParameter("direccion");
                                        String ciudad = request.getParameter("ciudad");
                                        String provincia = request.getParameter("provincia");
                                        Integer dni = Integer.parseInt(request.getParameter("dni"));
                                        
                                        Usuario user = new Usuario(email, pass);
                                        user.setDatospersonales(nombre, apellido, direccion, ciudad, provincia, dni);
                                        
                                        funciones.alta(user);
                                        response.getWriter().print("USUARIO SE REGISTRO DE MANERA EXITOSA");
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
                                    String email = request.getParameter("email");
                                    String pass  = request.getParameter("pass");

                                    Usuario user = new Usuario(email, pass);
                                    

                                    if(funciones.login(user))
                                    {
                                        funciones.baja(user);
                                        response.getWriter().print("Usuario eliminado.");
                                        
                                    }else{
                                            response.getWriter().print("Usuario no encontrado.");
                                    }

                                    

                                    break;
                                    }
                                catch (Exception e)
                                    {
                                    response.getWriter().print("EL ERROR OCURRIDO ES:"+e);
                                    } 
                    
                    
                    
                               // </editor-fold>
                              }
                case "modificar":{// <editor-fold desc="MODIFICAR">
                                    
                                try{
                                    String passAnterior = request.getParameter("passAnterior");
                                    String temp = (String)sesion.getAttribute("email"); 
                                    
                                    if( temp != null)        
                                    {   if(passAnterior.equals((String)sesion.getAttribute("pass")))
                                        {   
                                            String email = temp;
                                            String pass = request.getParameter("pass");
                                            String nombre = request.getParameter("nombre");
                                            String apellido = request.getParameter("apellido");
                                            String direccion = request.getParameter("direccion");
                                            String ciudad = request.getParameter("ciudad");
                                            String provincia = request.getParameter("provincia");
                                            Integer dni = Integer.parseInt(request.getParameter("dni"));

                                            Usuario user = new Usuario (email, pass, nombre, apellido, direccion, ciudad, provincia, dni);

                                            funciones.modificar(user);
                                            
                                            response.getWriter().print("USUARIO SE ACTUALIZÓ DE MANERA EXITOSA");
                                            
                                        }
                                        else{
                                                 response.getWriter().print("La contraseña anterior no es correcta.");
                                            }
                                     } else { 
                                             response.getWriter().print("No hay ningún usuario logueado.");
                                            }
                                    
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
                                    String temp = (String)sesion.getAttribute("email"); 
                                    if( temp == null)        
                                    {
                                        response.getWriter().print("No hay ningún usuario logueado.");
                                        
                                    } else { 
                                        sesion.setAttribute("email", null);
                                        response.getWriter().print("Logout realizado correctamente.");
                                            }
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
