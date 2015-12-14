/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.DE;

import com.Negocio.DEActividad;
import com.Negocio.DEAlumno;
import com.Negocio.DECurso;
import com.Negocio.DEEntidad;
import com.Negocio.DEResponsable;
import com.dal.DEActividadDAL;
import com.dal.DEAlumnoActividadDAL;
import com.dal.DEAlumnoDAL;
import com.dal.DEResponsableDAL;
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
public class confDEActividadMIBServlet extends HttpServlet {
   
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
            //Insercion Tipo Familiar
            if (request.getParameter("enviar").equals("CANCELAR"))
            {
                request.getSession().setAttribute("listaDEAlumno", null);
                request.getRequestDispatcher("confDEActividadServlet").forward(request, response);
                return;
            }

            if (request.getParameter("enviar").equals("CREAR CURSO"))
            {
                //Insertar Responsable
                DEResponsable unDEResponsable = (DEResponsable)request.getSession().getAttribute("unDEResponsable");
                DEResponsableDAL deResponsableDAL = new DEResponsableDAL();
                deResponsableDAL.insertarIDResponsable(unDEResponsable.getDni(), unDEResponsable.getNombre(), unDEResponsable.getApellidos(), unDEResponsable.getDireccion(), unDEResponsable.getPoblacion(), unDEResponsable.getCp(), unDEResponsable.getProvincia(), unDEResponsable.getFijo(), unDEResponsable.getMovil(), unDEResponsable.getEmail(), unDEResponsable.getFechaNac());
                unDEResponsable = deResponsableDAL.getDEResponsable(unDEResponsable.getDni());

                //Insertar Actividad
                DEEntidad unDEEntidad = (DEEntidad)request.getSession().getAttribute("unaDEEntidad");
                DECurso unDECurso = (DECurso)request.getSession().getAttribute("unDECurso");
                String temporada = (String)request.getSession().getAttribute("temporada");
                String strFechaInicio = (String)request.getSession().getAttribute("fechaInicio");
                String[] arrFechaInicio = strFechaInicio.split("-");
                strFechaInicio = arrFechaInicio[2] + "-" + arrFechaInicio[1] + "-" + arrFechaInicio[0];
                String strFechaFin = (String)request.getSession().getAttribute("fechaFin");
                String[] arrFechaFin = strFechaFin.split("-");
                strFechaFin = arrFechaFin[2] + "-" + arrFechaFin[1] + "-" + arrFechaFin[0];
                DEActividadDAL deActividadDAL = new DEActividadDAL();
                deActividadDAL.insertarDEActividad(unDEResponsable.getIdDEResponsable(), unDECurso.getIdCurso(), unDEEntidad.getIdDEEntidad(), temporada, Date.valueOf(strFechaInicio), Date.valueOf(strFechaFin));
                DEActividad unaDEActividad = null;
                int ultimo = deActividadDAL.ultimaActividad();


                //Insertar Alumno
                DEAlumnoDAL deAlumnoDAL = new DEAlumnoDAL();
                ArrayList<DEAlumno> listaDEAlumno = (ArrayList<DEAlumno>)request.getSession().getAttribute("listaDEAlumno");
                DEAlumno unDEAlumno = null;
                int ultimoAlumno = 0;
                for(int i = 0; i<listaDEAlumno.size();i++)
                {
                    unDEAlumno = listaDEAlumno.get(i);
                    deAlumnoDAL.insertarDEAlumno(unDEAlumno.getNombre(), unDEAlumno.getApellidos(), unDEAlumno.getFechaNac(), unDEAlumno.getCurso(), unDEAlumno.getNombreTutor(), unDEAlumno.getApellidosTutor(), unDEAlumno.getFijo(), unDEAlumno.getMovil(), unDEAlumno.getEmail());
                    ultimoAlumno = deAlumnoDAL.ultimoAlumno();
                    DEAlumnoActividadDAL unDEAlumnoActividadDAL = new DEAlumnoActividadDAL();
                    unDEAlumnoActividadDAL.insertarDEAlumnoActividad(ultimoAlumno, ultimo);
                }

                request.getRequestDispatcher("confDEActividadAlumnoFinal.jsp").forward(request, response);
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
