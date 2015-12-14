/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.configuracion;

import com.dal.PlantillaCartaDAL;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julen
 */
public class confPlantillaCartaAltaServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //Comprobacion del login
        if(request.getSession().getAttribute("usuario") == null)
        {
             request.getRequestDispatcher("index.jsp").forward(request, response);
             return;
        }

        String nombre="";
        String url="";

        PlantillaCartaDAL plantillaCartaDAL = new PlantillaCartaDAL();

        try
        {
           boolean fin = false;
           MultipartParser mp = new MultipartParser(request, 50 * 1024 * 1024, false, false); // 50MB
           Part part;
           while ((part = mp.readNextPart()) != null)  // recorremos el 'formulario'
           {
           if (part.isParam())
           {
                String n=part.getName();
                ParamPart p=(ParamPart)part;
                String valorcadena=p.getStringValue();
                fin=null==valorcadena;
                String id="";
                if(!fin)
                {
                    if (n.equals("ArchivoId"))
                          id=valorcadena;
                    if(n.equals("plantillasNombre"))
                        nombre=valorcadena;

                }
            }
            else if (part.isFile()) //es el fichero??
            {
                FilePart filePart = (FilePart)part;
                String nombreFichero = filePart.getFileName();
                 // Obtener la extension
                    String extension = nombreFichero.substring( nombreFichero.lastIndexOf( "." ) );
                    extension = extension.toLowerCase();

                 //directorio donde se guardara los archivos
                String dirUploadFiles;
                // Obtengo el directorio donde guardare los archivos
                ServletContext sc = request.getSession().getServletContext();
                dirUploadFiles = sc.getRealPath("archivos/carta");
                File archivo = new File( dirUploadFiles, nombreFichero );
                filePart.writeTo(archivo);
                url="archivos/carta/"+nombreFichero;

            }
          }
           plantillaCartaDAL.insertarPlantillaCarta(nombre, url);

        }
        catch (Exception e)
        {

        }
        finally
        {
            request.getRequestDispatcher("confPlantillaCartaServlet").forward(request, response);
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
