/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.DE;

import com.Negocio.DEAlumno;
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
public class confDEActividadAnadirServlet extends HttpServlet {
   
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
            ArrayList<DEAlumno> listaDEAlumno = (ArrayList<DEAlumno>)request.getSession().getAttribute("listaDEAlumno");

            String strNombre = request.getParameter("nombre");
            String strApellidos = request.getParameter("apellidos");
            String strCurso = request.getParameter("curso");
            String strFechaNac = request.getParameter("fechaNac");
            String[] arrFechaNac = strFechaNac.split("-");
            strFechaNac = arrFechaNac[2] + "-" + arrFechaNac[1] + "-" + arrFechaNac[0];

            String strNombreTutor  = request.getParameter("nombreTutor");
            String strApellidosTutor = request.getParameter("apellidosTutor");
            String strFijo = request.getParameter("fijo");
            String strMovil = request.getParameter("movil");
            String strEmail = request.getParameter("email");

            DEAlumno unDEAlumno = new DEAlumno(strNombre, strApellidos, Date.valueOf(strFechaNac), strCurso, strNombreTutor, strApellidosTutor, strFijo, strMovil, strEmail);
            if(listaDEAlumno == null)
            {
                listaDEAlumno = new ArrayList<DEAlumno>();
            }
            listaDEAlumno.add(unDEAlumno);

            request.getSession().setAttribute("listaDEAlumno", listaDEAlumno);
        }
        finally
        {
            getServletContext().getRequestDispatcher("/confDEActividadAlumno.jsp").forward(request, response);
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
