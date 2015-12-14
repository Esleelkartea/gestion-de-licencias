/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.servlets;


import com.Negocio.Usuario;

import com.dal.UsuarioDAL;
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
public class LoginServlet extends HttpServlet {
   
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
        try
        {
            String strNombre = request.getParameter("usuario");
            String strPassword = request.getParameter("contrasena");
            
            UsuarioDAL usuarioDAL = new UsuarioDAL();
            Usuario unUsuario;
            unUsuario = usuarioDAL.getUsuario(strNombre, strPassword);

            if (unUsuario == null)
            {
                request.getSession().setAttribute("errorLogin", true);
                request.getSession().setAttribute("usuario", null);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else
            {
                request.getSession().setAttribute("usuario", unUsuario);
                getServletContext().getRequestDispatcher("/confTipoTelefonoServlet").forward(request, response);
            }
        }
        catch(Exception ex)
        {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            return;
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
