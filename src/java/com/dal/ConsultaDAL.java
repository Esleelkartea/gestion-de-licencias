/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Consulta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class ConsultaDAL {

    Conexion conexion;

    public ConsultaDAL()
    {

    }

    public Consulta getConsulta(int pIdConsulta)
    {
        conexion = new Conexion();
        Consulta unaConsulta = null;
        String consulta= "SELECT * FROM TIPO_CONSULTA WHERE TIPO_CONSULTA_ID = " + pIdConsulta;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unaConsulta = new Consulta(rs.getInt("TIPO_CONSULTA_ID"),rs.getString("TIPO_CONSULTA_CONSULTA"), rs.getString("TIPO_CONSULTA_DESCRIPCION"));
        }
        catch(Exception e)
        {
            unaConsulta = null;
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
            return unaConsulta;
        }
     }

    public ArrayList<Consulta> getConsulta(int pIdConsulta, String pNombre, String pDescripcion)
    {
        conexion = new Conexion();
        ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();
        Consulta unaConsulta = null;
        String consulta= "SELECT * FROM TIPO_CONSULTA ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdConsulta != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_CONSULTA_ID = " + pIdConsulta;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_CONSULTA_CONSULTA = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND TIPO_CONSULTA_CONSULTA = '" + pNombre + "'";
             }

             if (pDescripcion != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_CONSULTA_DESCRIPCION = '" + pDescripcion + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND TIPO_CONSULTA_DESCRIPCION = '" + pDescripcion + "'";
             }


            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unaConsulta = new Consulta(rs.getInt("TIPO_CONSULTA_ID"),rs.getString("TIPO_CONSULTA_CONSULTA"), rs.getString("TIPO_CONSULTA_DESCRIPCION"));
                listaConsultas.add(unaConsulta);
            }
       }
        catch(SQLException ex)
        {
            listaConsultas  = null;
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
            return listaConsultas;
        }
    }



    public boolean insertarConsulta(String pNombre, String pDescripcion)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO TIPO_CONSULTA (TIPO_CONSULTA_CONSULTA, TIPO_CONSULTA_DESCRIPCION) VALUES ('" + pNombre + "','" + pDescripcion + "')";
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

    public boolean modificarConsulta(int pIdConsulta, String pNombre, String pDescripcion)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE TIPO_CONSULTA SET TIPO_CONSULTA_CONSULTA = '" + pNombre + "', TIPO_CONSULTA_DESCRIPCION='" + pDescripcion + "' WHERE TIPO_CONSULTA_ID=" + pIdConsulta;
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

    public boolean eliminarConsulta(int pIdConsulta)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM TIPO_CONSULTA WHERE TIPO_CONSULTA_ID=" + pIdConsulta;
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
