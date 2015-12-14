/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Colectivo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class ColectivoDAL {

    Conexion conexion;

    public ColectivoDAL()
    {

    }

    public Colectivo getColectivo(int pIdColectivo)
    {
        conexion = new Conexion();
        Colectivo unColectivo = null;
        String consulta= "SELECT * FROM COLECTIVO WHERE COLECTIVO_ID = " + pIdColectivo;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unColectivo = new Colectivo(rs.getInt("COLECTIVO_ID"),rs.getString("COLECTIVO_NOMBRE"), rs.getString("COLECTIVO_DESCRIPCION"));
        }
        catch(Exception e)
        {
            unColectivo = null;
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
            return unColectivo;
        }
     }

    public ArrayList<Colectivo> getColectivo(int pIdColectivo, String pNombre)
    {
        conexion = new Conexion();
        ArrayList<Colectivo> listaColectivos = new ArrayList<Colectivo>();
        Colectivo unColectivo = null;
        String consulta= "SELECT * FROM COLECTIVO ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdColectivo != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE COLECTIVO_ID = " + pIdColectivo;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE COLECTIVO_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND COLECTIVO_NOMBRE = '" + pNombre + "'";
             }
             

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unColectivo = new Colectivo(rs.getInt("COLECTIVO_ID"),rs.getString("COLECTIVO_NOMBRE"), rs.getString("COLECTIVO_DESCRIPCION"));
                listaColectivos.add(unColectivo);
            }
       }
        catch(SQLException ex)
        {
            listaColectivos = null;
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
            return listaColectivos;
        }
    }

    public boolean insertarColectivo(String pNombre, String pDescripcion)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO COLECTIVO (COLECTIVO_NOMBRE, COLECTIVO_DESCRIPCION) VALUES ('" + pNombre + "','" + pDescripcion + "')";
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

    public boolean modificarColectivo(int pIdColectivo, String pNombre, String pDescripcion)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE COLECTIVO SET COLECTIVO_NOMBRE = '" + pNombre + "', COLECTIVO_DESCRIPCION='" + pDescripcion + "' WHERE COLECTIVO_ID=" + pIdColectivo;
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

    public boolean eliminarColectivo(int pIdColectivo)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM COLECTIVO WHERE COLECTIVO_ID=" + pIdColectivo;
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
