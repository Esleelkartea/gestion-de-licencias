/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.consulta;

import com.Negocio.Consulta;
import com.Negocio.FederadoConsulta;
import com.dal.ConsultaDAL;
import com.dal.FederadoConsultaDAL;
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
public class consultaBusquedaDetServlet extends HttpServlet {
   
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

        FederadoConsulta unFederadoConsulta = null;

        try
        {

            FederadoConsultaDAL federadoConsultaDAL = new FederadoConsultaDAL();
            if(request.getParameter("var")!=null)
            {
               String idFederadoConsulta = request.getParameter("var");
               unFederadoConsulta = federadoConsultaDAL.getFederadoConsulta(Integer.parseInt(idFederadoConsulta));
               request.getSession().setAttribute("unFederadoConsulta", unFederadoConsulta);
            }
            ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();
            ConsultaDAL consultaDAL = new ConsultaDAL();
            listaConsultas = consultaDAL.getConsulta(-1, null, null);
            request.getSession().setAttribute("listaConsultas", listaConsultas);
        }
        finally
        {
            request.getSession().setAttribute("unFederadoConsulta", unFederadoConsulta);
            getServletContext().getRequestDispatcher("/consultaBusquedaDet.jsp").forward(request, response);
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
