package Controller.Discos;

import Actions.Canciones.CancionesFunciones;
import Model.Cancion;
import Model.Disco;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(location="./img", fileSizeThreshold=1024*1024,maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class dAltaController extends HttpServlet {
    private final static Logger LOGGER =  Logger.getLogger(dAltaController.class.getCanonicalName());
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //String prePath = new File(".").getCanonicalPath();
        
        //final String path = getServletContext().getRealPath("/uploads");
        String p1 = System.getProperty("user.home");
        final String path = p1+"\\Documents\\Discros\\web\\uploads";
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);
        
        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();
        
        Actions.Discos.DiscosFunciones funciones = new Actions.Discos.DiscosFunciones();
        HttpSession sesion = request.getSession(true); 
        try{
                        
                                    if(funciones.buscar(Integer.parseInt(request.getParameter("upc"))))
                                    {   sesion.setAttribute("mensajeError", "El disco ya se encuentra registrado, por favor ingrese otro UPC.");
                                        response.sendRedirect("d_alta.jsp");
                                       
                                        
                                    } else if((ArrayList<Model.Cancion>)sesion.getAttribute("cancionesDisco") == null){
                                        sesion.setAttribute("mensajeError", "No puede registrar un disco sin canciones, por favor ingrese al menos una canción");
                                        response.sendRedirect("d_alta.jsp");
                                    }else{
                                         
                                        //SE INSTANCIA UN DISCO Y SE CARGA CON LOS VALORES OBTENIDOS DEL FORMULARIO
                                        String artista = request.getParameter("artista");
                                        String album = request.getParameter("album");
                                        String genero = request.getParameter("genero");
                                        String descripcion = request.getParameter("descripcion");
                                        int upc= Integer.parseInt(request.getParameter("upc"));
                                        int stock = Integer.parseInt(request.getParameter("stock"));
                                        String fechafecha = request.getParameter("fecha");
                                        float precio = Float.parseFloat(request.getParameter("precio"));
                                        
                                        //aca se comienza con guardar la img
                                        out = new FileOutputStream(new File(path+File.separator+upc+".jpg"));
                                        //out = new FileOutputStream(new File(path + File.separator + fileName));
                                        filecontent = filePart.getInputStream();
                                        String imagen = "uploads/"+upc+".jpg";
                                        //String imagen = path+"/"+upc+".jpg";
                                        int read = 0;
                                        final byte[] bytes = new byte[1024];
                                        
                                        while ((read= filecontent.read(bytes)) != -1) {
                                            out.write(bytes,0,read);   
                                        }
                                        //fue modificado fileName por upc
                                        writer.println("New file " + fileName + " created at " + path);
                                        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",new Object[]{fileName, path});
                                        // aca termina
                                        
                                        
                                        ArrayList<Model.Cancion> canciones = (ArrayList<Model.Cancion>)sesion.getAttribute("cancionesDisco");
                                        Disco disco = new Disco(artista, album, genero, descripcion, imagen, upc, stock, fechafecha);
                                        
                                        funciones.alta(disco,canciones,precio);
                                           
                                        sesion.setAttribute("mensajeExito", "Disco agregado correctamente.");
                                        response.sendRedirect("d_alta.jsp");
                                        
                                        }
                                    }
                                    catch (FileNotFoundException fne) {
                                    writer.println("You either did not specify a file to upload or are "
                                            + "trying to upload a file to a protected or nonexistent "
                                            + "location.");
                                    writer.println("<br/> ERROR: " + fne.getMessage());

                                    LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
                                            new Object[]{fne.getMessage()});
                                    sesion.setAttribute("errorCatch", fne.toString());}
                                catch (Exception e)
                                    {
                                        sesion.setAttribute("errorCatch", e.toString());
                                        response.sendRedirect("error.jsp");
                                    }
                                finally{
                                    if (out != null) {
                                        out.close();
                                    }
                                    if (filecontent != null) {
                                        filecontent.close();              
                                    }
                                    if (writer != null){
                                        writer.close();                                
                                    }
                                }
    }

    private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
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
