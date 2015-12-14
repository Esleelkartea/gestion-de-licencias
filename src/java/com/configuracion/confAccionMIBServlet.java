/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.configuracion;

import com.dal.AccionDAL;
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
public class confAccionMIBServlet extends HttpServlet {
   
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

            AccionDAL accionDAL = new AccionDAL();
            
           //Insercion Accion
            if (request.getParameter("enviar").equals("ALTA"))
            {
                String strAccion = request.getParameter("accion");
                accionDAL.insertarAccion(strAccion);
                request.getRequestDispatcher("confAccionServlet").forward(request, response);
                return;
            }

            //Modificacion Accion
            if (request.getParameter("enviar").equals("MODIFICACION"))
            {
                String strAccion = request.getParameter("accion");
                String strIdAccion = request.getParameter("idAccion");
                accionDAL.modificarAccion(Integer.parseInt(strIdAccion), strAccion);
                request.getRequestDispatcher("confAccionServlet").forward(request, response);
                return;
            }

            //Eliminar la Accion
            if (request.getParameter("enviar").equals("BAJA"))
            {
                String strIdAccion = request.getParameter("idAccion");
                accionDAL.eliminarAccion(Integer.parseInt(strIdAccion));
                
                request.getRequestDispatcher("confAccionServlet").forward(request, response);
                return;
            }

        }
        catch(Exception ex)
        {
            request.getRequestDispatcher("confAccionServlet").forward(request, response);
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
