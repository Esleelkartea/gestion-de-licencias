/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.EstadoLicencia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class EstadoLicenciaDAL {

    Conexion conexion;

    public EstadoLicenciaDAL()
    {

    }


    public EstadoLicencia getEstadoLicencia(int pIdEstadoLicencia)
    {
        conexion = new Conexion();
        EstadoLicencia unEstadoLicencia = null;
        String consulta= "SELECT * FROM ESTADO_LICENCIA WHERE ESTADO_LICENCIA_ID = " + pIdEstadoLicencia;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unEstadoLicencia = new EstadoLicencia(rs.getInt("ESTADO_LICENCIA_ID"), rs.getString("ESTADO_LICENCIA_NOMBRE"));
        }
        catch(Exception e)
        {
            unEstadoLicencia = null;
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
            return unEstadoLicencia;
        }
     }

    public ArrayList<EstadoLicencia> getEstadoLicencia(int pIdEstadoLicencia, String pNombre)
    {
        conexion = new Conexion();
        ArrayList<EstadoLicencia> listaEstadoLicencia = new ArrayList<EstadoLicencia>();
        EstadoLicencia unEstadoLicencia = null;
        String consulta= "SELECT * FROM ESTADO_LICENCIA ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdEstadoLicencia != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE ESTADO_LICENCIA_ID = " + pIdEstadoLicencia;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE ESTADO_LICENCIA_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND ESTADO_LICENCIA_NOMBRE = '" + pNombre + "'";
             }           

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unEstadoLicencia = new EstadoLicencia(rs.getInt("ESTADO_LICENCIA_ID"), rs.getString("ESTADO_LICENCIA_NOMBRE"));
                listaEstadoLicencia.add(unEstadoLicencia);
            }
       }
        catch(SQLException ex)
        {
            listaEstadoLicencia = null;
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
            return listaEstadoLicencia;
        }
    }


    public boolean insertarEstadoLicencia(String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO ESTADO_LICENCIA (ESTADO_LICENCIA_NOMBRE) VALUES ('" + pNombre + "')";
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

    public boolean modificarEstadoLicencia(int pIdEstadoLicencia, String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE ESTADO_LICENCIA SET ESTADO_LICENCIA_NOMBRE = '" + pNombre + "' WHERE ESTADO_LICENCIA_ID=" + pIdEstadoLicencia;
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

    public boolean eliminarEstadoLicencia(int pIdEstadoLicencia)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM ESTADO_LICENCIA WHERE ESTADO_LICENCIA_ID=" + pIdEstadoLicencia;
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
