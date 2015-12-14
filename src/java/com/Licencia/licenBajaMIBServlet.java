/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Licencia;

import com.Negocio.Federado;
import com.Negocio.TipoBaja;
import com.dal.FederadoDAL;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julen
 */
public class licenBajaMIBServlet extends HttpServlet {
   
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
        FederadoDAL federadoDAL = new FederadoDAL();
        Federado unFederado = null;

        try
        {
            if (request.getParameter("enviar").equals("Confirmar"))
            {
                unFederado = (Federado)request.getSession().getAttribute("unFederado");
                String fecha = (String)request.getSession().getAttribute("fecha");
                String[] arrFecha = fecha.split("-");
                fecha = arrFecha[2] + "-" + arrFecha[1] + "-" + arrFecha[0];
                TipoBaja unTipoBaja = (TipoBaja)request.getSession().getAttribute("razonBaja");
                federadoDAL.darDeBaja(unFederado.getIdFederado(), Date.valueOf(fecha), unTipoBaja.getIdTipoBaja());
                request.getRequestDispatcher("/licenBajaCorrecta.jsp").forward(request, response);
                return;

            }
            if (request.getParameter("enviar").equals("Cancelar"))
            {
                request.getSession().setAttribute("unFederado", null);
                request.getSession().setAttribute("fecha", null);
                request.getSession().setAttribute("razonBaja", null);
                request.getRequestDispatcher("/licenBajaServlet").forward(request, response);
                return;
            }
            
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
