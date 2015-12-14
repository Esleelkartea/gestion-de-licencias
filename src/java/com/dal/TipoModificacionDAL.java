/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.TipoModificacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class TipoModificacionDAL {

    Conexion conexion;

    public TipoModificacionDAL()
    {
        
    }

    public TipoModificacion getTipoModificacion(int pIdTipoModificacion)
    {
        conexion = new Conexion();
        TipoModificacion unTipoModificacion = null;
        String consulta= "SELECT * FROM TIPO_MODIFICACION WHERE TIPO_MODIFICACION_ID = " + pIdTipoModificacion;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unTipoModificacion = new TipoModificacion(rs.getInt("TIPO_MODIFICACION_ID"), rs.getString("TIPO_MODIFICACION_NOMBRE"));
        }
        catch(Exception e)
        {
            unTipoModificacion = null;
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
            return unTipoModificacion;
        }
     }

    public ArrayList<TipoModificacion> getTipoModificacions(int pIdModificacion, String pNombre)
    {
        conexion = new Conexion();
        ArrayList<TipoModificacion> listaTipoModificacion = new ArrayList<TipoModificacion>();
        TipoModificacion unTipoModificacion = null;

        String consulta= "SELECT * FROM TIPO_MODIFICACION";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdModificacion != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_MODIFICACION_ID=" + pIdModificacion;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_MODIFICACION_NOMBRE= " + pNombre;
                     bConsul=true;
                 }
                 else
                     consulta += " AND TIPO_MODIFICACION_NOMBRE = " + pNombre;
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unTipoModificacion = new TipoModificacion(rs.getInt("TIPO_MODIFICACION_ID"), rs.getString("TIPO_MODIFICACION_NOMBRE"));
                listaTipoModificacion.add(unTipoModificacion);
            }
       }
        catch(SQLException ex)
        {
            listaTipoModificacion = null;
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
            return listaTipoModificacion;
        }
    }

    public boolean insertarTipoModificacion(String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO TIPO_MODIFICACION (TIPO_MODIFICACION_NOMBRE) VALUES ('" + pNombre + "')";
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

    public boolean modificarTipoModificacion(int pIdTipoModificacion, String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE TIPO_MODIFICACION SET TIPO_MODIFICACION_NOMBRE = '" + pNombre + "' WHERE TIPO_MODIFICACION_ID=" + pIdTipoModificacion;
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

    public boolean eliminarTipoModificacion(int pIdTipoModificacion)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM TIPO_MODIFICACION WHERE TIPO_MODIFICACION_ID=" + pIdTipoModificacion;
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
