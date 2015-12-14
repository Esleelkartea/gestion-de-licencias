/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.DE;

import com.Negocio.DECurso;
import com.Negocio.DEEntidad;
import com.Negocio.DEResponsable;
import com.dal.DECursoDAL;
import com.dal.DEEntidadDAL;
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
public class confDEActividadAlumnoServlet extends HttpServlet {
   
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

            //Entidad
            String strIdEntidad = request.getParameter("entidad");
            DEEntidad unaDEEntidad = null;
            DEEntidadDAL deEntidadDAL = new DEEntidadDAL();
            unaDEEntidad = deEntidadDAL.getDEEntidad(Integer.parseInt(strIdEntidad));
            request.getSession().setAttribute("unaDEEntidad", unaDEEntidad);

            //Curso
            String strIdCurso = request.getParameter("curso");
            DECurso unDECurso = null;
            DECursoDAL deCursoDAL = new DECursoDAL();
            unDECurso = deCursoDAL.getDECurso(Integer.parseInt(strIdCurso));
            request.getSession().setAttribute("unDECurso", unDECurso);

            //Responsable
            String strNombre = request.getParameter("nombre");
            String strApellidos = request.getParameter("apellidos");
            String strDNI = request.getParameter("dni");
            String strFechaNac = request.getParameter("fechaNac");
            String[] arrFechaNac = strFechaNac.split("-");
            strFechaNac = arrFechaNac[2] + "-" + arrFechaNac[1] + "-" + arrFechaNac[0];

            String strDireccion = request.getParameter("direccion");
            String strPoblacion = request.getParameter("poblacion");
            String strProvincia = request.getParameter("provincia");
            String strCP = request.getParameter("cp");
            String strFijo = request.getParameter("fijo");
            String strMovil = request.getParameter("movil");
            String strEmail = request.getParameter("email");
            DEResponsable unDEResponsable = new DEResponsable(strDNI, strNombre, strApellidos, Date.valueOf(strFechaNac), strDireccion, strPoblacion, strCP, strProvincia, strFijo, strMovil, strEmail);
            request.getSession().setAttribute("unDEResponsable", unDEResponsable);

            String strTemporada = request.getParameter("temporada");
            request.getSession().setAttribute("temporada", strTemporada);
            String strFechaInicio = request.getParameter("fechaInicio");
            request.getSession().setAttribute("fechaInicio", strFechaInicio);
            String strFechaFin = request.getParameter("fechaFin");
            request.getSession().setAttribute("fechaFin", strFechaFin);
            
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
