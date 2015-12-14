/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.DEActividad;
import com.Negocio.DECurso;
import com.Negocio.DEEntidad;
import com.Negocio.DEResponsable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class DEActividadDAL {

    Conexion conexion;

    public DEActividadDAL()
    {

    }

    public DEActividad getDEActividad(int pIdDEActividad)
    {
        conexion = new Conexion();
        DEActividad unDEActividad = null;
        DECurso unDECurso = null;
        DECursoDAL deCursoDAL = new DECursoDAL();
        DEResponsable unDEResponsable = null;
        DEResponsableDAL deResponsableDAL = new DEResponsableDAL();
        DEEntidad unDEEntidad = null;
        DEEntidadDAL deEntidadDAL = new DEEntidadDAL();
        String consulta= "SELECT * FROM DE_ACTIVIDAD WHERE DE_ACTIVIDAD_ID = " + pIdDEActividad;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
             {
                 unDECurso = deCursoDAL.getDECurso(rs.getInt("DE_ACTIVIDAD_CURSO_ID"));
                 unDEResponsable = deResponsableDAL.getDEResponsable(rs.getInt("DE_ACTIVIDAD_RESPONSABLE_ID"));
                 unDEEntidad = deEntidadDAL.getDEEntidad(rs.getInt("DE_ACTIVIDAD_ENTIDAD_ID"));
                 unDEActividad = new DEActividad(rs.getInt("DE_ACTIVIDAD_ID"), unDEResponsable, unDECurso, unDEEntidad, rs.getString("DE_ACTIVIDAD_TEMPORADA"), rs.getDate("DE_ALUMNO_FINICIO"), rs.getDate("DE_ALUMNO_FFIN"));
             }
        }
        catch(Exception e)
        {
            unDEActividad = null;
        }
        finally
        {
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException ex)
                {
                    System.out.println("No se ha podido cerrar el ResulSet.");
                }
            }
            conexion.cerrar();
            return unDEActividad;
        }
     }

    public int ultimaActividad()
    {
        int ultimo = 0;
         conexion = new Conexion();
         String consulta= "SELECT MAX(DE_ACTIVIDAD_ID) AS MAXIMO FROM DE_ACTIVIDAD";
         ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
             {
                 ultimo = rs.getInt("MAXIMO");
             }
        }
        catch(Exception e)
        {
            ultimo = 0;
        }
        finally
        {
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException ex)
                {
                    System.out.println("No se ha podido cerrar el ResulSet.");
                }
            }
            conexion.cerrar();
            return ultimo;
        }
    }

    public ArrayList<DEActividad> getDEActividad(int pIdDEActividad, int pResponsable, int pCurso, int pEntidad, String pTemporada, Date pFechaInicio, Date pFechaFin)
    {
        conexion = new Conexion();
        DEActividad unDEActividad = null;
        DECurso unDECurso = null;
        DECursoDAL deCursoDAL = new DECursoDAL();
        DEResponsable unDEResponsable = null;
        DEResponsableDAL deResponsableDAL = new DEResponsableDAL();
        DEEntidad unDEEntidad = null;
        DEEntidadDAL deEntidadDAL = new DEEntidadDAL();
        ArrayList<DEActividad> listaDEActividad = new ArrayList<DEActividad>();
        
        String consulta= "SELECT * FROM DE_ACTIVIDAD ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdDEActividad != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ACTIVIDAD_ID = " + pIdDEActividad;
                     bConsul=true;
                 }
            }

            if (pResponsable != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ACTIVIDAD_RESPONSABLE_ID = " + pResponsable;
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ACTIVIDAD_RESPONSABLE_ID = " + pResponsable;
             }

             if (pCurso != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ACTIVIDAD_CURSO_ID =" + pCurso;
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ACTIVIDAD_CURSO_ID =" + pCurso;
             }

             if (pEntidad != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ACTIVIDAD_ENTIDAD_ID =" + pEntidad;
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ACTIVIDAD_ENTIDAD_ID =" + pEntidad;
             }      

             
             if (pTemporada != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ACTIVIDAD_TEMPORADA = '" + pTemporada + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_ACTIVIDAD_TEMPORADA = '" + pTemporada + "'";
             }

             if (pFechaInicio != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ACTIVIDAD_FINICIO = '" + pFechaInicio + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ACTIVIDAD_FINICIO = '" + pFechaInicio + "'";
             }

             if (pFechaFin != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ACTIVIDAD_FFIN = '" + pFechaFin + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ACTIVIDAD_FFIN = '" + pFechaFin + "'";
             }



            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unDECurso = deCursoDAL.getDECurso(rs.getInt("DE_ACTIVIDAD_CURSO_ID"));
                 unDEResponsable = deResponsableDAL.getDEResponsable(rs.getInt("DE_ACTIVIDAD_RESPONSABLE_ID"));
                 unDEEntidad = deEntidadDAL.getDEEntidad(rs.getInt("DE_ACTIVIDAD_ENTIDAD_ID"));
                 unDEActividad = new DEActividad(rs.getInt("DE_ACTIVIDAD_ID"), unDEResponsable, unDECurso, unDEEntidad, rs.getString("DE_ACTIVIDAD_TEMPORADA"), rs.getDate("DE_ACTIVIDAD_FINICIO"), rs.getDate("DE_ACTIVIDAD_FFIN"));
                 listaDEActividad.add(unDEActividad);
            }
       }
        catch(SQLException ex)
        {
            listaDEActividad = null;
        }
        finally
        {
            if (rs != null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException ex)
                {
                    System.out.println("No se ha podido cerrar el ResulSet.");
                }
            }
            conexion.cerrar();
            return listaDEActividad;
        }
    }

    public boolean insertarDEActividad(int pIdResponsable, int pIdCurso, int pIdEntidad, String pTemporada, Date pFechaInicio, Date pFechaFin)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO DE_ACTIVIDAD (DE_ACTIVIDAD_RESPONSABLE_ID, DE_ACTIVIDAD_CURSO_ID, DE_ACTIVIDAD_ENTIDAD_ID, DE_ACTIVIDAD_TEMPORADA, DE_ACTIVIDAD_FINICIO, DE_ACTIVIDAD_FFIN) VALUES (" + pIdResponsable + "," + pIdCurso + "," + pIdEntidad + ",'" + pTemporada + "','" + pFechaInicio + "','" + pFechaFin + "')";
        try
        {
            numFilas = conexion.getStatement().executeUpdate(consulta);
            if (numFilas == 0) exito = false;
        }
        catch(SQLException ex)
        {
            System.out.println("No se ha podido realizar la inserción.");
        }
        finally
        {
            conexion.cerrar();
            return exito;
        }
    }

    public boolean modificarDEActividad(int pIdDEActividad, int pIdDEResponsable, int pIdDECurso, int pIdDEEntidad, String pTemporada, Date pFechaInicio, Date pFechaFin)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE DE_ACTIVIDAD SET DE_ACTIVIDAD_RESPONSABLE_ID = " + pIdDEResponsable + " DE_ACTIVIDAD_CURSO_ID =" + pIdDECurso + " DE_ACTIVIDAD_ENTIDAD_ID=" + pIdDEEntidad + " DE_ACTIVIDAD_TEMPORADA ='" + pTemporada + "' DE_ACTIVIDAD_FINICIO ='" + pFechaInicio + "' DE_ACTIVIDAD_FFIN ='" + pFechaFin + "' WHERE DE_ACTIVIDAD_ID=" + pIdDEActividad;
        try
        {
            numFilas = conexion.getStatement().executeUpdate(consulta);
            if (numFilas == 0) exito = false;
        }
        catch(SQLException ex)
        {
            System.out.println("No se ha podido realizar la modificación.");
        }
        finally
        {
            conexion.cerrar();
            return exito;
        }
    }

    public boolean eliminarDEActividad(int pIdDEActividad)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM DE_ACTIVIDAD WHERE DE_ACTIVIDAD_ID=" + pIdDEActividad;
        try
        {
            numFilas = conexion.getStatement().executeUpdate(consulta);
            if (numFilas == 0) exito = false;
        }
        catch(SQLException ex)
        {
            System.out.println("No se ha podido realizar la eliminación.");
        }
        finally
        {
            conexion.cerrar();
            return exito;
        }
    }


}
