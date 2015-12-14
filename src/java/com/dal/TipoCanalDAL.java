/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.TipoCanal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class TipoCanalDAL {

    Conexion conexion;

    public TipoCanal getTipoCanal(int pIdTipoCanal)
    {
        conexion = new Conexion();
        TipoCanal unTipoCanal = null;
        String consulta= "SELECT * FROM TIPO_CANAL WHERE TIPO_CANAL_ID = " + pIdTipoCanal;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unTipoCanal = new TipoCanal(rs.getInt("TIPO_CANAL_ID"),rs.getString("TIPO_CANAL_NOMBRE"), rs.getString("TIPO_CANAL_DESCRIPCION"));
        }
        catch(Exception e)
        {
            unTipoCanal = null;
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
            return unTipoCanal;
        }

     }

    public ArrayList<TipoCanal> getTipoCanal(int pIdTipoCanal, String pNombre, String pDescripcion)
    {
        conexion = new Conexion();
        ArrayList<TipoCanal> listaTipoCanal = new ArrayList<TipoCanal>();
        TipoCanal unTipoCanal = null;
        String consulta= "SELECT * FROM TIPO_CANAL ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdTipoCanal != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_CANAL_ID = " + pIdTipoCanal;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_CANAL_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND TIPO_CANAL_NOMBRE = '" + pNombre + "'";
             }

             if (pDescripcion != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_CANAL_DESCRIPCION  = '" + pDescripcion + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND TIPO_CANAL_DESCRIPCION = '" + pDescripcion + "'";
             }


            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unTipoCanal = new TipoCanal(rs.getInt("TIPO_CANAL_ID"),rs.getString("TIPO_CANAL_NOMBRE"), rs.getString("TIPO_CANAL_DESCRIPCION"));
                listaTipoCanal.add(unTipoCanal);
            }
       }
        catch(SQLException ex)
        {
            listaTipoCanal  = null;
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
            return listaTipoCanal;
        }
    }

    public boolean insertarTipoCanal(String pNombre, String pDescripcion)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO TIPO_CANAL (TIPO_CANAL_NOMBRE, TIPO_CANAL_DESCRIPCION) VALUES ('" + pNombre + "','" + pDescripcion + "')";
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

    public boolean modificarTipoCanal(int pIdTipoCanal, String pNombre, String pDescripcion)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE TIPO_CANAL SET TIPO_CANAL_NOMBRE = '" + pNombre + "', TIPO_CANAL_DESCRIPCION='" + pDescripcion + "' WHERE TIPO_CANAL_ID=" + pIdTipoCanal;
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

    public boolean eliminarTipoCanal(int pIdTipoCanal)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM TIPO_CANAL WHERE TIPO_CANAL_ID=" + pIdTipoCanal;
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
