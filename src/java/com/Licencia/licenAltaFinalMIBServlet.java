/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Licencia;

import com.Negocio.Federado;
import com.Negocio.FederadoDireccion;
import com.Negocio.FederadoEmail;
import com.Negocio.FederadoTelefono;
import com.Negocio.TipoDireccion;
import com.Negocio.TipoEmail;
import com.Negocio.TipoTelefono;
import com.dal.FederadoDAL;
import com.dal.FederadoDireccionDAL;
import com.dal.FederadoEmailDAL;
import com.dal.FederadoTelefonoDAL;
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
public class licenAltaFinalMIBServlet extends HttpServlet {
   
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
                Federado unFederado = (Federado)request.getSession().getAttribute("unFederado");
                FederadoDAL federadoDAL = new FederadoDAL();
                federadoDAL.insertarFederado(unFederado.getNumFederado(), unFederado.getNombre(), unFederado.getApellido1(), unFederado.getApellido2(), unFederado.getDni(), unFederado.getFechaNac(), unFederado.getSexo(), unFederado.getNacionalidad(), unFederado.isResidente(), unFederado.isTutor(), unFederado.getTutorTipo(), unFederado.getTutorNombre(), unFederado.getTutorApellido1(), unFederado.getTutorApellido2(), unFederado.getDniTutor(), unFederado.isHandicap(), unFederado.getNumHandicap(), unFederado.getFormaPago(), unFederado.getNumCuenta(), unFederado.isNota1(), unFederado.isNota2(), unFederado.isNota3(), unFederado.getIdEntidad(), unFederado.getEstadoEconomico(), unFederado.getEstadoLicencia(), unFederado.getFechaPreAlta(), unFederado.getFechaAlta(), unFederado.getFechaBaja(), unFederado.getRazonBaja(), unFederado.isHomolagada(), unFederado.getTutorNumFederado());

                ArrayList<FederadoDireccion> listaFederadoDireccion = (ArrayList<FederadoDireccion>)request.getSession().getAttribute("listaFederadoDireccion");
                ArrayList<FederadoTelefono> listaFederadoTelefono = (ArrayList<FederadoTelefono>)request.getSession().getAttribute("listaFederadoTelefono");
                ArrayList<FederadoEmail> listaFederadoEmail = (ArrayList<FederadoEmail>)request.getSession().getAttribute("listaFederadoEmail");

                unFederado = federadoDAL.getFederado2(unFederado.getNumFederado());

                FederadoDireccionDAL federadoDireccionDAL = new FederadoDireccionDAL();


                if(listaFederadoDireccion != null)
                {
                    for(int i = 0; i<listaFederadoDireccion.size();i++)
                    {
                        federadoDireccionDAL.insertarFederadoDireccion(listaFederadoDireccion.get(i).getCalle(), listaFederadoDireccion.get(i).getNumero(), listaFederadoDireccion.get(i).getEscalera(), listaFederadoDireccion.get(i).getPiso(), listaFederadoDireccion.get(i).getPuerta(), listaFederadoDireccion.get(i).getComplemento(), listaFederadoDireccion.get(i).getPoblacion(), listaFederadoDireccion.get(i).getCp(), listaFederadoDireccion.get(i).getProvincia(), listaFederadoDireccion.get(i).getTipoDireccion(), unFederado.getIdFederado());
                    }
                }

                    FederadoTelefonoDAL federadoTelefonoDAL = new FederadoTelefonoDAL();

                if(listaFederadoTelefono != null)
                {
                    for(int i = 0; i<listaFederadoTelefono.size();i++)
                    {
                        federadoTelefonoDAL.insertarFederadoTelefono(listaFederadoTelefono.get(i).getTelefono(), listaFederadoTelefono.get(i).getTipoTelefono(), unFederado.getIdFederado());
                    }
                }

                    FederadoEmailDAL federadoEmailDAL = new FederadoEmailDAL();

                if(listaFederadoEmail != null)
                {
                    for(int i = 0; i<listaFederadoEmail.size();i++)
                    {
                        federadoEmailDAL.insertarFederadoEmail(listaFederadoEmail.get(i).getEmail(), listaFederadoEmail.get(i).getTipoEmail(), unFederado.getIdFederado());
                    }
                }

           }
           if (request.getParameter("enviar").equals("Cancelar"))
           {
               
           }
        }
        finally
        {
            request.getSession().setAttribute("listaFederadoDireccion", null);
            request.getSession().setAttribute("listaFederadoTelefono", null);
            request.getSession().setAttribute("listaFederadoEmail", null);
            request.getSession().setAttribute("unFederado", null);

            getServletContext().getRequestDispatcher("/licenAltaServlet").forward(request, response);
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
