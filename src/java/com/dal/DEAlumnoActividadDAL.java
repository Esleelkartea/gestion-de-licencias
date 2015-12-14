/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.DEAlumnoActividad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class DEAlumnoActividadDAL {

    Conexion conexion;

    public DEAlumnoActividadDAL()
    {
        
    }

    public DEAlumnoActividad getDEAlumnoActividad(int pIdDEAlumnoActividad)
    {
        conexion = new Conexion();
        DEAlumnoActividad unDEAlumnoActividad = null;
        String consulta= "SELECT * FROM DE_ALUMNO_ACTIVIDAD WHERE DE_ALUMNO_ACTIVIDAD_ID = " + pIdDEAlumnoActividad;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unDEAlumnoActividad = new DEAlumnoActividad(rs.getInt("DE_ALUMNO_ACTIVIDAD_ID"), rs.getInt("DE_ALUMNO_ACTIVIDAD_ALUMNO_ID"), rs.getInt("DE_ALUMNO_ACTIVIDAD_ACTIVIDAD_ID"));
        }
        catch(Exception e)
        {
            unDEAlumnoActividad = null;
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
            return unDEAlumnoActividad;
        }
     }

    public ArrayList<DEAlumnoActividad> getDEAlumnoActividad(int pIdDEAlumnoActividad, int pIdDEAlumno, int pIdDEActividad)
    {
        conexion = new Conexion();
        ArrayList<DEAlumnoActividad> listaDEAlumnoActividad = new ArrayList<DEAlumnoActividad>();
        DEAlumnoActividad unDEAlumnoActividad = null;
        String consulta= "SELECT * FROM DE_ALUMNO_ACTIVIDAD ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdDEAlumnoActividad != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_ACTIVIDAD_ID = " + pIdDEAlumnoActividad;
                     bConsul=true;
                 }
            }

            if (pIdDEAlumno != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_ACTIVIDAD_ALUMNO_ID =" + pIdDEAlumno;
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ALUMNO_ACTIVIDAD_ALUMNO_ID = " + pIdDEAlumno;
             }

             if (pIdDEActividad != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_ACTIVIDAD_ACTIVIDAD_ID = " + pIdDEActividad;
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ALUMNO_ACTIVIDAD_ACTIVIDAD_ID = " + pIdDEActividad;
             }

             

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unDEAlumnoActividad = new DEAlumnoActividad(rs.getInt("DE_ALUMNO_ACTIVIDAD_ID"), rs.getInt("DE_ALUMNO_ACTIVIDAD_ALUMNO_ID"), rs.getInt("DE_ALUMNO_ACTIVIDAD_ACTIVIDAD_ID"));
                listaDEAlumnoActividad.add(unDEAlumnoActividad);
            }
       }
        catch(SQLException ex)
        {
            listaDEAlumnoActividad = null;
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
            return listaDEAlumnoActividad;
        }
    }

    public boolean insertarDEAlumnoActividad(int pIdAlumno, int pIdActividad)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO DE_ALUMNO_ACTIVIDAD (DE_ALUMNO_ACTIVIDAD_ALUMNO_ID, DE_ALUMNO_ACTIVIDAD_ACTIVIDAD_ID) VALUES (" + pIdAlumno + "," + pIdActividad + ")";
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

}
