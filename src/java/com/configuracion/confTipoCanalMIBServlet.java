/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.configuracion;

import com.dal.TipoCanalDAL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julen
 */
public class confTipoCanalMIBServlet extends HttpServlet {
   
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

            TipoCanalDAL tipoCanalDAL = new TipoCanalDAL();

           //Insercion TipoCanal
            if (request.getParameter("enviar").equals("ALTA"))
            {
                String strNombre = request.getParameter("nombre");
                String strDescripcion = request.getParameter("descripcion");
                tipoCanalDAL.insertarTipoCanal(strNombre, strDescripcion);
                request.getRequestDispatcher("confTipoCanalServlet").forward(request, response);
                return;
            }

            //Modificacion TipoCanal
            if (request.getParameter("enviar").equals("MODIFICACION"))
            {
                String strIdTipoCanal = request.getParameter("idTipoCanal");
                String strNombre = request.getParameter("nombre");
                String strDescripcion = request.getParameter("descripcion");
                tipoCanalDAL.modificarTipoCanal(Integer.parseInt(strIdTipoCanal), strNombre, strDescripcion);
                request.getRequestDispatcher("confTipoCanalServlet").forward(request, response);
                return;
            }

            //Eliminar TipoCanal
            if (request.getParameter("enviar").equals("BAJA"))
            {
                String strIdTipoCanal = request.getParameter("idTipoCanal");
                tipoCanalDAL.eliminarTipoCanal(Integer.parseInt(strIdTipoCanal));
                request.getRequestDispatcher("confTipoCanalServlet").forward(request, response);
                return;
            }

        }
        catch(Exception ex)
        {
            request.getRequestDispatcher("confTipoCanalServlet").forward(request, response);
            out.close();
        }
        finally
        {
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
