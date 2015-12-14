/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.TipoEmail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class TipoEmailDAL {

    Conexion conexion;

    public TipoEmailDAL()
    {

    }

    public TipoEmail getTipoEmail(int pIdTipoEmail)
    {
        conexion = new Conexion();
        TipoEmail unTipoEmail = null;
        String consulta= "SELECT * FROM TIPO_EMAIL WHERE TIPO_EMAIL_ID = " + pIdTipoEmail;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unTipoEmail = new TipoEmail(rs.getInt("TIPO_EMAIL_ID"), rs.getString("TIPO_EMAIL_NOMBRE"));
        }
        catch(Exception e)
        {
            unTipoEmail = null;
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
            return unTipoEmail;
        }
     }

    public ArrayList<TipoEmail> getTipoEmail(int pIdEmail, String pNombre)
    {
        conexion = new Conexion();
        ArrayList<TipoEmail> listaTipoEmail = new ArrayList<TipoEmail>();
        TipoEmail unTipoEmail = null;

        String consulta= "SELECT * FROM TIPO_EMAIL ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdEmail != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_EMAIL_ID=" + pIdEmail;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_EMAIL_NOMBRE= '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND TIPO_EMAIL_NOMBRE = '" + pNombre + "'";
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unTipoEmail = new TipoEmail(rs.getInt("TIPO_EMAIL_ID"), rs.getString("TIPO_EMAIL_NOMBRE"));
                listaTipoEmail.add(unTipoEmail);
            }
       }
        catch(SQLException ex)
        {
            listaTipoEmail = null;
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
            return listaTipoEmail;
        }
    }

    public boolean insertarTipoEmail(String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO TIPO_EMAIL (TIPO_EMAIL_NOMBRE) VALUES ('" + pNombre + "')";
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

    public boolean modificarTipoEmail(int pIdTipoEmail, String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE TIPO_EMAIL SET TIPO_EMAIL_NOMBRE = '" + pNombre + "' WHERE TIPO_EMAIL_ID=" + pIdTipoEmail;
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

    public boolean eliminarTipoEmail(int pIdTipoEmail)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM TIPO_EMAIL WHERE TIPO_EMAIL_ID=" + pIdTipoEmail;
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
