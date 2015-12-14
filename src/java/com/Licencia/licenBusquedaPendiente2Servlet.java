/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Licencia;

import com.Negocio.Federado;
import com.dal.FederadoDAL;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julen
 */
public class licenBusquedaPendiente2Servlet extends HttpServlet {
   
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

        ArrayList<Federado> listaFederado = new ArrayList<Federado>();
        FederadoDAL federadoDAL = new FederadoDAL();

        try
        {

            String strNumFederado = request.getParameter("numLicencia");
            if (strNumFederado.equals(""))
                strNumFederado = null;

            String strNombre = request.getParameter("nombre");
            if (strNombre.equals(""))
                strNombre = null;

            String strApellido1 = request.getParameter("apellido1");
            if (strApellido1.equals(""))
                strApellido1 = null;

            String strApellido2 = request.getParameter("apellido2");
            if (strApellido2.equals(""))
                strApellido2 = null;

            String strDNI = request.getParameter("dni");
            if (strDNI.equals(""))
                strDNI = null;

            String strEntidad = request.getParameter("entidad");

            String strFechaInicio = request.getParameter("fechaInicio");
            Date dFechaInicio = null;
            if(!strFechaInicio.equals(""))
            {
                String[] arrFechaInicio = strFechaInicio.split("-");
                strFechaInicio = arrFechaInicio[2] + "-" + arrFechaInicio[1] + "-" + arrFechaInicio[0];
                dFechaInicio = Date.valueOf(strFechaInicio);
            }

            String strFechaFin = request.getParameter("fechaFin");
            Date dFechaFin = null;
            if(!strFechaFin.equals(""))
            {
                String[] arrFechaFin = strFechaFin.split("-");
                strFechaFin = arrFechaFin[2] + "-" + arrFechaFin[1] + "-" + arrFechaFin[0];
                dFechaFin = Date.valueOf(strFechaFin);
            }

            listaFederado = federadoDAL.getFederadoBusquedaPendiente(-1, strNumFederado, strNombre, strApellido1, strApellido2, strDNI, Integer.parseInt(strEntidad), dFechaInicio, dFechaFin);
            request.getSession().setAttribute("listaFederado", listaFederado);

        }
        finally
        {
            request.getRequestDispatcher("/licenBusquedaPendienteResultado.jsp").forward(request, response);
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
