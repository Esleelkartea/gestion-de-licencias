/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Licencia;

import com.Negocio.Entidad;
import com.Negocio.EstadoEconomico;
import com.Negocio.EstadoLicencia;
import com.Negocio.Federado;
import com.Negocio.Grupo;
import com.dal.EntidadDAL;
import com.dal.EstadoEconomicoDAL;
import com.dal.EstadoLicenciaDAL;
import com.dal.GrupoDAL;
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
public class licenAltaMIBServlet extends HttpServlet {
   
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
            Entidad unaEntidad = null;
            EntidadDAL entidadDAL = new EntidadDAL();
            unaEntidad = entidadDAL.getEntidad(Integer.parseInt(strIdEntidad));
            request.getSession().setAttribute("unaEntidad", unaEntidad);
            
            String strNombre = request.getParameter("nombre");
            String strApellido1 = request.getParameter("apellido1");
            String strApellido2 = request.getParameter("apellido2");
            String strDNI = request.getParameter("dni");

            String strFechaNac = request.getParameter("fechaNacimiento");
            String[] arrFechaNac = strFechaNac.split("-");
            strFechaNac = arrFechaNac[2] + "-" + arrFechaNac[1] + "-" + arrFechaNac[0];
            Date dFechaNac = Date.valueOf(strFechaNac);

            String strSexo = request.getParameter("sexo");
            String strMenor = request.getParameter("menor");

            String strNombreTutor = "";
            String strApellido1Tutor = "";
            String strApellido2Tutor = "";
            String strDniTutor = "";
            String strNumLicenciaTutor = "";
            String strTipoTutor = "";

            boolean menor = false;
            if(strMenor != null)
            {
                if(strMenor.equals("On"))
                {
                    menor = true;
                    strTipoTutor = request.getParameter("tipoTutor");
                    strNumLicenciaTutor = request.getParameter("numLicenTutor");
                    strDniTutor = request.getParameter("dniTutor");
                    strNombreTutor = request.getParameter("nombreTutor");
                    strApellido1Tutor = request.getParameter("apellido1Tutor");
                    strApellido2Tutor = request.getParameter("apellido2Tutor");
                }
            }

            String strNacionalidad = request.getParameter("nacionalidad");
            
            String strResidente = request.getParameter("residente");
            boolean residente = false;
            if(strResidente != null)
            {
                if(strResidente.equals("On"))
                {
                    residente = true;
                }
            }

            
            String strHandicap = request.getParameter("handicap");
            boolean handicap = false;
            if(strHandicap != null)
            {
                if(strHandicap.equals("On"))
                {
                    handicap = true;
                }
            }
            
            String strNumHandicap = request.getParameter("numHandicap");
            if(strNumHandicap == "" || strNumHandicap == null)
            {
                strNumHandicap = "0.0";
            }


            String strHomologada = request.getParameter("homologada");
            boolean homologada = false;
            if(strHomologada != null)
            {
                if(strHomologada.equals("On"))
                {
                    homologada = true;
                }
            }

            //Grupo
            String strIdGrupo = request.getParameter("grupo");
            Grupo unGrupo = null;
            GrupoDAL grupoDAL = new GrupoDAL();
            unGrupo = grupoDAL.getGrupo(Integer.parseInt(strIdGrupo));
            request.getSession().setAttribute("unGrupo", unGrupo);


            String strFormaPago = request.getParameter("formaPago");
            String strNumCuenta = request.getParameter("numCuenta");


            //Estado Licencia
            String strEstadoLicencia = request.getParameter("estadoLicencia");
            EstadoLicencia unEstadoLicencia = null;
            EstadoLicenciaDAL estadoLicenciaDAL = new EstadoLicenciaDAL();
            unEstadoLicencia = estadoLicenciaDAL.getEstadoLicencia(Integer.parseInt(strEstadoLicencia));
            request.getSession().setAttribute("unEstadoLicencia", unEstadoLicencia);

            //Estado Licencia
            String strEstadoEconomico = request.getParameter("estadoEconomico");
            EstadoEconomico unEstadoEconomico = null;
            EstadoEconomicoDAL estadoEconomicoDAL = new EstadoEconomicoDAL();
            unEstadoEconomico = estadoEconomicoDAL.getEstadoEconomico(Integer.parseInt(strEstadoEconomico));
            request.getSession().setAttribute("unEstadoEconomico", unEstadoEconomico);


            
            String strFechaPreAlta = request.getParameter("fechaPreAlta");
            String[] arrFechaPreAlta = strFechaPreAlta.split("-");
            strFechaPreAlta = arrFechaPreAlta[2] + "-" + arrFechaPreAlta[1] + "-" + arrFechaPreAlta[0];
            Date dFechaPreAlta = Date.valueOf(strFechaPreAlta);

            Date dFechaAlta = null;
            String strFechaAlta = request.getParameter("fechaAlta");
            if(strFechaAlta != null && !strFechaAlta.equals(""))
            {
                String[] arrFechaAlta = strFechaPreAlta.split("-");
                strFechaAlta = arrFechaAlta[2] + "-" + arrFechaAlta[1] + "-" + arrFechaAlta[0];
                dFechaAlta = Date.valueOf(strFechaAlta);
            }

            
            String strNota1 = request.getParameter("nota1");
            String strNota2 = request.getParameter("nota2");
            String strNota3 = request.getParameter("nota3");

            boolean nota1 = false;
            if(strNota1 != null)
            {
                if(strNota1.equals("On"))
                {
                    nota1 = true;
                }
            }

            boolean nota2 = false;
            if(strNota2 != null)
            {
                if(strNota2.equals("On"))
                {
                    nota2 = true;
                }
            }

            boolean nota3 = false;
            if(strNota3 != null)
            {
                if(strNota3.equals("On"))
                {
                    nota3 = true;
                }
            }

             //Numero de Licencia
            int valorEntero = (int) Math.floor(Math.random()*(8000-1000+1)+1000);
            String strNumLicencia = "VB" + unaEntidad.getCodigo() + "72" + String.valueOf(valorEntero) + " - " + unGrupo.getLetra();


            Federado unFederado = new Federado(strNumLicencia, strNombre, strApellido1, strApellido2, strDNI, dFechaNac, strSexo, strNacionalidad, residente, menor, strTipoTutor, strNombreTutor, strApellido1Tutor, strApellido2Tutor, strDniTutor, handicap, Double.valueOf(strNumHandicap), strFormaPago, strNumCuenta, nota1, nota2, nota3, unaEntidad.getIdEntidad(), unEstadoEconomico.getIdEstadoEconomico(), unEstadoLicencia.getIdEstadoLicencia(), dFechaPreAlta, dFechaAlta, null, 0, homologada, strNumLicenciaTutor);
            request.getSession().setAttribute("unFederado", unFederado);

            if (request.getParameter("enviar").equals("ALTA"))
            {
                getServletContext().getRequestDispatcher("/licenAltaPrevia.jsp").forward(request, response);
                return;
            }
            if (request.getParameter("enviar").equals("Siguiente"))
            {
                getServletContext().getRequestDispatcher("/licenAltaSigServlet").forward(request, response);
                return;
            }

        }
        catch(Exception ex)
        {
           getServletContext().getRequestDispatcher("/licenAltaPrevia.jsp").forward(request, response);
           return;
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
