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
public class licenBusquedaMIBServlet extends HttpServlet {
   
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

            String strFechaNac = request.getParameter("fechaNacimiento");
            Date dFechaNac;
            if (strFechaNac.equals(""))
            {
                strFechaNac = null;
                dFechaNac = null;
            }
            else
            {
                String[] arrFechaNac = strFechaNac.split("-");
                strFechaNac = arrFechaNac[2] + "-" + arrFechaNac[1] + "-" + arrFechaNac[0];
                dFechaNac = Date.valueOf(strFechaNac);
            }

            String strTelefono = request.getParameter("telefono");
            if (strTelefono.equals(""))
                strTelefono = null;

            String strEmail = request.getParameter("email");
            if (strEmail.equals(""))
                strEmail = null;
            
            String strDireccion = request.getParameter("direccion");
            if (strDireccion.equals(""))
                strDireccion = null;

            String strPoblacion = request.getParameter("poblacion");
            if (strPoblacion.equals(""))
                strPoblacion = null;

            String strProvincia = request.getParameter("provincia");
            if (strProvincia.equals(""))
                strProvincia = null;

            String strCP = request.getParameter("cp");
            if (strCP.equals(""))
                strCP = null;

            String strNumHandicap = request.getParameter("numHandicap");
            if (strNumHandicap.equals(""))
                strNumHandicap = "-1.0";

            String strEstadoLicencia = request.getParameter("estadoLicencia");

            String strEstadoEconomico = request.getParameter("estadoEconomico");

            String strIdEntidad = request.getParameter("entidad");


            ArrayList<Federado> listaFederado = new ArrayList<Federado>();
            FederadoDAL federadoDAL = new FederadoDAL();
            //listaFederado = federadoDAL.getFederado(-1, strNumFederado, strNombre, strApellido1, strApellido2, strDNI, dFechaNac, null, null, null, null, null, null, Double.parseDouble(strNumHandicap), null, null, Integer.parseInt(strIdEntidad), Integer.parseInt(strEstadoEconomico), Integer.parseInt(strEstadoLicencia));
            request.getSession().setAttribute("listaFederado", listaFederado);

        } 
        finally
        {
            getServletContext().getRequestDispatcher("/licenResultado.jsp").forward(request, response);
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
