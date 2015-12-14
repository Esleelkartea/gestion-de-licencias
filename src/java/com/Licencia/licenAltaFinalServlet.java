/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Licencia;

import com.Negocio.Federado;
import com.dal.FederadoDAL;
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
public class licenAltaFinalServlet extends HttpServlet {
   
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
             //Alta
            if (request.getParameter("enviar").equals("Alta"))
            {
                Federado unFederado = (Federado)request.getSession().getAttribute("unFederado");
                FederadoDAL federadoDAL = new FederadoDAL();
                federadoDAL.insertarFederado(unFederado.getNumFederado(), unFederado.getNombre(), unFederado.getApellido1(), unFederado.getApellido2(), unFederado.getDni(), unFederado.getFechaNac(), unFederado.getSexo(), unFederado.getNacionalidad(), unFederado.isResidente(), unFederado.isTutor(), unFederado.getTutorTipo(), unFederado.getTutorNombre(), unFederado.getTutorApellido1(), unFederado.getTutorApellido2(), unFederado.getDniTutor(), unFederado.isHandicap(), unFederado.getNumHandicap(), unFederado.getFormaPago(), unFederado.getNumCuenta(), unFederado.isNota1(), unFederado.isNota2(), unFederado.isNota3(), unFederado.getIdEntidad(), unFederado.getEstadoEconomico(), unFederado.getEstadoLicencia(), unFederado.getFechaPreAlta(), unFederado.getFechaAlta(), unFederado.getFechaBaja(), unFederado.getRazonBaja(), unFederado.isHomolagada(), unFederado.getTutorNumFederado());
                
            }
            //Cancelar
            if (request.getParameter("enviar").equals("Cancelar"))
            {
                
            }

            
            
        }
        finally
        {
            request.getRequestDispatcher("licenAltaServlet").forward(request, response);
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
