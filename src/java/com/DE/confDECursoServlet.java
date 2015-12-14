/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.DE;

import com.Negocio.DECurso;
import com.dal.DECursoDAL;
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
public class confDECursoServlet extends HttpServlet {
   
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

        ArrayList<DECurso> listaDECurso = new ArrayList<DECurso>();
        DECursoDAL deCursoDAL = new DECursoDAL();

        try
        {
            listaDECurso = deCursoDAL.getDECurso(-1, null);

            DECurso unDECurso;
            if(request.getParameter("var")!=null)
            {
               String idDECurso = request.getParameter("var");
               unDECurso = deCursoDAL.getDECurso(Integer.parseInt(idDECurso));
               request.getSession().setAttribute("unDECurso", unDECurso);
            }
            else
            {
               request.getSession().setAttribute("unDECurso", null);
            }

        }
        finally
        {
            request.getSession().setAttribute("listaDECurso", listaDECurso);
            getServletContext().getRequestDispatcher("/confDECurso.jsp").forward(request, response);
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
