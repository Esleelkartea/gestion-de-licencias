/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.consulta;

import com.Negocio.Consulta;
import com.Negocio.Federado;
import com.dal.ConsultaDAL;
import com.dal.FederadoConsultaDAL;
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
public class consultaBusquedaMIBServlet extends HttpServlet {
   
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
            FederadoConsultaDAL federadoConsultaDAL = new FederadoConsultaDAL();

             //Modificar Consulta
            if (request.getParameter("enviar").equals("Modificar"))
            {
                String strIdFederadoConsulta = request.getParameter("idFederadoConsulta");

                String strIdConsulta = request.getParameter("consulta");
                ConsultaDAL consultaDAL = new ConsultaDAL();
                Consulta unaConsulta = null;
                unaConsulta = consultaDAL.getConsulta(Integer.parseInt(strIdConsulta));

                FederadoDAL federadoDAL = new FederadoDAL();
                String strIdFederado = request.getParameter("idFederado");
                Federado unFederado = federadoDAL.getFederado(Integer.parseInt(strIdFederado));

                String strObsservaciones = request.getParameter("observaciones");

                String strPendiente = request.getParameter("pendiente");
                boolean pendiente = false;
                if(strPendiente != null)
                {
                    if(strPendiente.equals("On"))
                    {
                        pendiente = true;
                    }
                }

                String strFecha = request.getParameter("fecha");
                String[] arrFecha = strFecha.split("-");
                strFecha = arrFecha[2] + "-" + arrFecha[1] + "-" + arrFecha[0];

                federadoConsultaDAL.modificarFederadoConsulta(Integer.parseInt(strIdFederadoConsulta), unFederado, unaConsulta, Date.valueOf(strFecha), pendiente, strObsservaciones);

            }

             //Eliminar Consulta
            if (request.getParameter("enviar").equals("Eliminar"))
            {
                String strIdFederadoConsulta = request.getParameter("idFederadoConsulta");
                federadoConsultaDAL.eliminarFederadoConsulta(Integer.parseInt(strIdFederadoConsulta));
            }

             //Cancelar
            if (request.getParameter("enviar").equals("Cancelar"))
            {
            
            }
          
        } 
        finally
        {
            getServletContext().getRequestDispatcher("/consultaBusquedaServlet").forward(request, response);
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
