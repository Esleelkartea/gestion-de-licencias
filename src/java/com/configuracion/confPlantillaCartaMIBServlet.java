/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.configuracion;

import com.dal.PlantillaCartaDAL;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Julen
 */
public class confPlantillaCartaMIBServlet extends HttpServlet {
   
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
        
        try
        {
            PlantillaCartaDAL plantillaCartaDAL = new PlantillaCartaDAL();

            //Modificacion Plantilla Email
            if (request.getParameter("enviar").equals("MODIFICACION"))
            {
                String strIdPlantillaCarta = request.getParameter("idPlantillaCarta");
                String strPlantillaNombre = request.getParameter("plantillasNombre");
                plantillaCartaDAL.modificarPlantillaCarta(Integer.parseInt(strIdPlantillaCarta), strPlantillaNombre);
            }

            if (request.getParameter("enviar").equals("BAJA"))
            {
                HttpSession session = request.getSession(true);
                String strIdPlantillaCarta = request.getParameter("idPlantillaCarta");
                String strPlantillaNombre = request.getParameter("plantillasNombre");
                String strPlantillaFichero = request.getParameter("archivo");

                String[] archivos = strPlantillaFichero.split("/");
                ServletContext sc = request.getSession().getServletContext();
                String dirUploadFiles = sc.getRealPath("archivos/carta");
                //File fich=new File(strPlantillaFichero);
                File fich=new File(dirUploadFiles,archivos[2]);
                fich.delete();

                plantillaCartaDAL.eliminarPlantillaCarta(Integer.parseInt(strIdPlantillaCarta));
            }
        }
        catch(Exception ex)
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
