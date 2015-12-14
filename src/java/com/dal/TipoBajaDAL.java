/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.TipoBaja;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class TipoBajaDAL {

    Conexion conexion;

    public TipoBajaDAL()
    {

    }

    public TipoBaja getTipoBaja(int pIdTipoBaja)
    {
        conexion = new Conexion();
        TipoBaja unTipoBaja = null;
        String consulta= "SELECT * FROM TIPO_BAJA WHERE TIPO_BAJA_ID = " + pIdTipoBaja;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unTipoBaja = new TipoBaja(rs.getInt("TIPO_BAJA_ID"), rs.getString("TIPO_BAJA_RAZON"));
        }
        catch(Exception e)
        {
            unTipoBaja = null;
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
            return unTipoBaja;
        }
     }

    public ArrayList<TipoBaja> getTipoBaja(int pIdTipoBaja, String pRazon)
    {
        conexion = new Conexion();
        ArrayList<TipoBaja> listaTipoBaja = new ArrayList<TipoBaja>();
        TipoBaja unTipoBaja = null;

        String consulta= "SELECT * FROM TIPO_BAJA ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdTipoBaja != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_BAJA_ID=" + pIdTipoBaja;
                     bConsul=true;
                 }
            }

            if (pRazon != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_BAJA_RAZON= '" + pRazon + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND TIPO_BAJA_RAZON = '" + pRazon + "'";
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unTipoBaja = new TipoBaja(rs.getInt("TIPO_BAJA_ID"), rs.getString("TIPO_BAJA_RAZON"));
                listaTipoBaja.add(unTipoBaja);
            }
       }
        catch(SQLException ex)
        {
            listaTipoBaja = null;
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
            return listaTipoBaja;
        }
    }

    public boolean insertarTipoBaja(String pRazon)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO TIPO_BAJA (TIPO_BAJA_RAZON) VALUES ('" + pRazon + "')";
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

    public boolean modificarTipoBaja(int pIdTipoBaja, String pRazon)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE TIPO_BAJA SET TIPO_BAJA_RAZON = '" + pRazon + "' WHERE TIPO_BAJA_ID=" + pIdTipoBaja;
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

    public boolean eliminarTipoBaja(int pIdTipoBaja)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM TIPO_BAJA WHERE TIPO_BAJA_ID=" + pIdTipoBaja;
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
