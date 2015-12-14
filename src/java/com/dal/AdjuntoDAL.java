/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Adjunto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class AdjuntoDAL {

    Conexion conexion;

    public AdjuntoDAL()
    {

    }

    public Adjunto getAdjunto(int pIdAdjunto)
    {
        conexion = new Conexion();
        Adjunto unAdjunto = null;
        String consulta= "SELECT * FROM ADJUNTO WHERE ADJUNTO_ID = " + pIdAdjunto;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unAdjunto = new Adjunto(rs.getInt("ADJUNTO_ID"), rs.getString("ADJUNTO_NOMBRE"));
        }
        catch(Exception e)
        {
            unAdjunto = null;
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
            return unAdjunto;
        }
     }

    public ArrayList<Adjunto> getAdjunto(int pIdAdjunto, String pNombre)
    {
        conexion = new Conexion();
        ArrayList<Adjunto> listaAdjunto = new ArrayList<Adjunto>();
        Adjunto unAdjunto = null;

        String consulta= "SELECT * FROM ADJUNTO ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdAdjunto != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE ADJUNTO_ID=" + pIdAdjunto;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE ADJUNTO_NOMBRE= '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND ADJUNTO_NOMBRE = '" + pNombre + "'";
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unAdjunto = new Adjunto(rs.getInt("ADJUNTO_ID"), rs.getString("ADJUNTO_NOMBRE"));
                listaAdjunto.add(unAdjunto);
            }
       }
        catch(SQLException ex)
        {
            listaAdjunto = null;
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
            return listaAdjunto;
        }
    }

    public boolean insertarAdjunto(String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO ADJUNTO (ADJUNTO_NOMBRE) VALUES ('" + pNombre + "')";
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


    public boolean modificarAdjunto(int pIdAdjunto, String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE ADJUNTO SET ADJUNTO_NOMBRE = '" + pNombre + "' WHERE ADJUNTO_ID=" + pIdAdjunto;
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

    public boolean eliminarAdjunto(int pIdAdjunto)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM ADJUNTO WHERE ADJUNTO_ID=" + pIdAdjunto;
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
