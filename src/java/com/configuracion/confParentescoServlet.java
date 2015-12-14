/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.configuracion;

import com.Negocio.TipoFamiliar;
import com.dal.TipoFamiliarDAL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julen
 */
public class confParentescoServlet extends HttpServlet {
   
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

        ArrayList<TipoFamiliar> listaTipoFamiliar = new ArrayList<TipoFamiliar>();
        TipoFamiliarDAL tipoFamiliarDAL = new TipoFamiliarDAL();
        
        try
        {
            listaTipoFamiliar = tipoFamiliarDAL.getTipoFamiliar(-1, null);

            TipoFamiliar unTipoFamiliar;
            if(request.getParameter("var")!=null)
            {
               String idTipoFamiliar = request.getParameter("var");
               unTipoFamiliar = tipoFamiliarDAL.getTipoFamiliar(Integer.parseInt(idTipoFamiliar));
               request.getSession().setAttribute("unTipoFamiliar", unTipoFamiliar);
            }
            else
            {
               request.getSession().setAttribute("unTipoFamiliar", null);
            }

        }
        finally
        {
            request.getSession().setAttribute("listaTipoFamiliar", listaTipoFamiliar);
            getServletContext().getRequestDispatcher("/confParentescos.jsp").forward(request, response);
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
