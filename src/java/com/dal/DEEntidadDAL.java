/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.DEEntidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class DEEntidadDAL {


    Conexion conexion;

    public DEEntidadDAL()
    {
        
    }

    public DEEntidad getDEEntidad(int pIdDEEntidad)
    {
        conexion = new Conexion();
        DEEntidad unaDEEntidad = null;
        String consulta= "SELECT * FROM DE_ENTIDAD WHERE DE_ENTIDAD_ID = " + pIdDEEntidad;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unaDEEntidad = new DEEntidad(rs.getInt("DE_ENTIDAD_ID"), rs.getString("DE_ENTIDAD_NOMBRE"), rs.getInt("DE_ENTIDAD_NUMENTIDAD"));
        }
        catch(Exception e)
        {
            unaDEEntidad = null;
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
            return unaDEEntidad;
        }
     }


    public ArrayList<DEEntidad> getDEEntidad(int pIdDEEntidad, String pNombre, int pNumEntidad)
    {
        conexion = new Conexion();
        ArrayList<DEEntidad> listaDEEntidad = new ArrayList<DEEntidad>();
        DEEntidad unaDEEntidad = null;
        String consulta= "SELECT * FROM DE_ENTIDAD ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdDEEntidad != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ENTIDAD_ID = " + pIdDEEntidad;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ENTIDAD_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ENTIDAD_NOMBRE = '" + pNombre + "'";
             }

             

             if (pNumEntidad != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ENTIDAD_NUMENTIDAD = " + pNumEntidad;
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ENTIDAD_NUMENTIDAD = " + pNumEntidad;
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unaDEEntidad = new DEEntidad(rs.getInt("DE_ENTIDAD_ID"), rs.getString("DE_ENTIDAD_NOMBRE"), rs.getInt("DE_ENTIDAD_NUMENTIDAD"));
                listaDEEntidad.add(unaDEEntidad);
            }
       }
        catch(SQLException ex)
        {
            listaDEEntidad = null;
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
            return listaDEEntidad;
        }
    }

    public boolean insertarDEEntidad(String pNombre, int pNumEntidad)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO DE_ENTIDAD (DE_ENTIDAD_NOMBRE, DE_ENTIDAD_NUMENTIDAD) VALUES ('" + pNombre + "'," + pNumEntidad + ")";
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

    public boolean modificarDEEntidad(int pIdDEEntidad, String pNombre, int pNumEntidad)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE DE_ENTIDAD SET DE_ENTIDAD_NOMBRE = '" + pNombre + "', DE_ENTIDAD_NUMENTIDAD=" + pNumEntidad + " WHERE DE_ENTIDAD_ID=" + pIdDEEntidad;
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

    public boolean eliminarDEEntidad(int pIdDEEntidad)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM DE_ENTIDAD WHERE DE_ENTIDAD_ID=" + pIdDEEntidad;
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
