/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Vincular;

import com.Negocio.Colectivo;
import com.Negocio.Federado;
import com.dal.ColectivoDAL;
import com.dal.FederadoColectivoDAL;
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
public class vincularAltaMIBServlet extends HttpServlet {
   
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
            

            if (request.getParameter("enviar").equals("ALTA"))
            {

                String strIdFederado = request.getParameter("idFederado");
                String strIdColectivo = request.getParameter("colectivo");
                String strObservaciones = request.getParameter("observaciones");

                Federado unFederado = null;
                FederadoDAL federadoDAL = new FederadoDAL();
                unFederado = federadoDAL.getFederado(Integer.parseInt(strIdFederado));

                Colectivo unColectivo = null;
                ColectivoDAL colectivoDAL = new ColectivoDAL();
                unColectivo = colectivoDAL.getColectivo(Integer.parseInt(strIdColectivo));


                FederadoColectivoDAL federadoColectivoDAL = new FederadoColectivoDAL();

                
                if(federadoColectivoDAL.estaVinculado(unFederado.getIdFederado(), unColectivo.getIdColectivo()))
                {
                    request.getSession().setAttribute("unFederado", unFederado);
                    getServletContext().getRequestDispatcher("/vincularAltaError.jsp").forward(request, response);
                    return;
                }
                else
                {
                    federadoColectivoDAL.insertarFederadoColectivo(unFederado, unColectivo, strObservaciones);
                    getServletContext().getRequestDispatcher("/vincularAltaResultadoServlet?var=" + unFederado.getIdFederado()).forward(request, response);
                    return;
                }
   

                
            }

            if (request.getParameter("enviar").equals("Cancelar"))
            {
                request.getSession().setAttribute("unFederado", null);
                request.getSession().setAttribute("listaFederado", null);
                getServletContext().getRequestDispatcher("/vincularAltaServlet").forward(request, response);
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
