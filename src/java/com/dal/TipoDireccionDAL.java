/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.TipoDireccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class TipoDireccionDAL {

    Conexion conexion;

    public TipoDireccionDAL()
    {

    }

    public TipoDireccion getTipoDireccion(int pIdTipoDireccion)
    {
        conexion = new Conexion();
        TipoDireccion unTipoDireccion = null;
        String consulta= "SELECT * FROM TIPO_DIRECCION WHERE TIPO_DIRECCION_ID = " + pIdTipoDireccion;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unTipoDireccion = new TipoDireccion(rs.getInt("TIPO_DIRECCION_ID"), rs.getString("TIPO_DIRECCION_NOMBRE"));
        }
        catch(Exception e)
        {
            unTipoDireccion = null;
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
            return unTipoDireccion;
        }
     }

    public ArrayList<TipoDireccion> getTipoDireccion(int pIdDireccion, String pNombre)
    {
        conexion = new Conexion();
        ArrayList<TipoDireccion> listaTipoDireccion = new ArrayList<TipoDireccion>();
        TipoDireccion unTipoDireccion = null;

        String consulta= "SELECT * FROM TIPO_DIRECCION ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdDireccion != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_DIRECCION_ID=" + pIdDireccion;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_DIRECCION_NOMBRE= '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND TIPO_DIRECCION_NOMBRE = '" + pNombre + "'";
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unTipoDireccion = new TipoDireccion(rs.getInt("TIPO_DIRECCION_ID"), rs.getString("TIPO_DIRECCION_NOMBRE"));
                listaTipoDireccion.add(unTipoDireccion);
            }
       }
        catch(SQLException ex)
        {
            listaTipoDireccion = null;
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
            return listaTipoDireccion;
        }
    }

    public boolean insertarTipoDireccion(String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO TIPO_DIRECCION(TIPO_DIRECCION_NOMBRE) VALUES ('" + pNombre + "')";
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

    public boolean modificarTipoDireccion(int pIdTipoDireccion, String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE TIPO_DIRECCION SET TIPO_DIRECCION_NOMBRE = '" + pNombre + "' WHERE TIPO_DIRECCION_ID=" + pIdTipoDireccion;
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

    public boolean eliminarTipoDireccion(int pIdTipoDireccion)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM TIPO_DIRECCION WHERE TIPO_DIRECCION_ID=" + pIdTipoDireccion;
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
