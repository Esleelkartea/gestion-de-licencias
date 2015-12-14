/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Accion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class AccionDAL {

    Conexion conexion;

    public AccionDAL()
    {
        
    }

    public Accion getAccion(int pIdAccion)
    {
        conexion = new Conexion();
        Accion unaAccion = null;
        String consulta= "SELECT * FROM ACCION WHERE ACCION_ID = " + pIdAccion;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unaAccion = new Accion(rs.getInt("ACCION_ID"), rs.getString("ACCION_NOMBRE"));
        }
        catch(Exception e)
        {
            unaAccion = null;
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
            return unaAccion;
        }
     }


    public ArrayList<Accion> getAccion(int pIdAccion, String pNombre)
    {
        conexion = new Conexion();
        ArrayList<Accion> listaAccion = new ArrayList<Accion>();
        Accion unaAccion = null;
        String consulta= "SELECT * FROM ACCION ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdAccion != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE ACCION_ID = " + pIdAccion;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE ACCION_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND ACCION_NOMBRE = '" + pNombre + "'";
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unaAccion = new Accion(rs.getInt("ACCION_ID"), rs.getString("ACCION_NOMBRE"));
                listaAccion.add(unaAccion);
            }
       }
        catch(SQLException ex)
        {
            listaAccion = null;
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
            return listaAccion;
        }
    }

    public boolean insertarAccion(String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO ACCION (ACCION_NOMBRE) VALUES ('" + pNombre + "')";
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

    public boolean modificarAccion(int pIdAccion, String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE ACCION SET ACCION_NOMBRE = '" + pNombre + "' WHERE ACCION_ID=" + pIdAccion;
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

    public boolean eliminarAccion(int pIdAccion)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM ACCION WHERE ACCION_ID=" + pIdAccion;
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
