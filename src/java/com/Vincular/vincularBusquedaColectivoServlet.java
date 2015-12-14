/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Vincular;

import com.Negocio.Colectivo;
import com.Negocio.Federado;
import com.Negocio.FederadoColectivo;
import com.dal.ColectivoDAL;
import com.dal.FederadoColectivoDAL;
import com.dal.FederadoDAL;
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
public class vincularBusquedaColectivoServlet extends HttpServlet {
   
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
            String strIdColectivo = request.getParameter("colectivo");

            Colectivo unColectivo = null;
            ColectivoDAL colectivoDAL = new ColectivoDAL();
            unColectivo = colectivoDAL.getColectivo(Integer.parseInt(strIdColectivo));
            
            ArrayList<FederadoColectivo> listaFederadoColectivo = new ArrayList<FederadoColectivo>();
            FederadoColectivoDAL federadoColectivoDAL = new FederadoColectivoDAL();

            listaFederadoColectivo = federadoColectivoDAL.getFederadoColectivo(-1, -1, Integer.parseInt(strIdColectivo));

            ArrayList<Federado> listaFederados = new ArrayList<Federado>();
            FederadoDAL federadoDAL = new FederadoDAL();
            Federado unFederado = null;
            for(int i =0;i<listaFederadoColectivo.size();i++)
            {
                unFederado = federadoDAL.getFederado(listaFederadoColectivo.get(i).getFederado().getIdFederado());
                listaFederados.add(unFederado);
            }

            request.getSession().setAttribute("listaFederados", listaFederados);
            request.getSession().setAttribute("nombreColectivo", unColectivo.getNombre());
            request.getSession().setAttribute("idColectivo", strIdColectivo);
        }
        finally
        {
            getServletContext().getRequestDispatcher("/vincularBusquedaColectivo.jsp").forward(request, response);
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
