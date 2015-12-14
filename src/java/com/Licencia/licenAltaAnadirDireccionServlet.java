/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Licencia;

import com.Negocio.FederadoDireccion;
import com.Negocio.TipoDireccion;
import com.dal.TipoDireccionDAL;
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
public class licenAltaAnadirDireccionServlet extends HttpServlet {
   
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
            ArrayList<FederadoDireccion> listaFederadoDireccion = (ArrayList<FederadoDireccion>)request.getSession().getAttribute("listaFederadoDireccion");

            String strTipoDireccion = request.getParameter("tipoDireccion");
            String strDomicilio = request.getParameter("domicilio");
            String strNumero = request.getParameter("numero");
            String strEscalera = request.getParameter("escalera");
            String strPiso = request.getParameter("piso");
            String strPuerta = request.getParameter("puerta");
            String strComplemento = request.getParameter("complemento");
            String strCP = request.getParameter("cp");
            String strPoblacion = request.getParameter("poblacion");
            String strProvincia = request.getParameter("provincia");

            TipoDireccion unTipoDireccion = null;
            TipoDireccionDAL tipoDireccionDAL = new TipoDireccionDAL();
            unTipoDireccion = tipoDireccionDAL.getTipoDireccion(Integer.parseInt(strTipoDireccion));
            
            FederadoDireccion unFederadoDireccion = new FederadoDireccion(strDomicilio, strNumero, strEscalera, strPiso, strPuerta, strComplemento, strPoblacion, strCP, strProvincia, unTipoDireccion, 0);

            if(listaFederadoDireccion == null)
            {
                listaFederadoDireccion = new ArrayList<FederadoDireccion>();
            }
            listaFederadoDireccion.add(unFederadoDireccion);

            request.getSession().setAttribute("listaFederadoDireccion", listaFederadoDireccion);

        }
        finally
        {
            getServletContext().getRequestDispatcher("/licenAlta2.jsp").forward(request, response);
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
