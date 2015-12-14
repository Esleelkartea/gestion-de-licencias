/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Perfil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class PerfilDAL {

    Conexion conexion;

    public PerfilDAL()
    {

    }


    public Perfil getPerfil(int pIdPerfil)
    {
        conexion = new Conexion();
        Perfil unPerfil = null;
        String consulta= "SELECT * FROM PERFIL WHERE PERFIL_ID = " + pIdPerfil;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unPerfil = new Perfil(rs.getInt("PERFIL_ID"),rs.getString("PERFIL_NOMBRE"), rs.getString("PERFIL_DESCRIPCION"));
        }
        catch(Exception e)
        {
            unPerfil = null;
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
            return unPerfil;
        }
     }

    public ArrayList<Perfil> getPerfil(int pIdPerfil, String pNombre, String pDescripcion)
    {
        conexion = new Conexion();
        ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();
        Perfil unPerfil = null;
        String consulta= "SELECT * FROM PERFIL ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdPerfil != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE PERFIL_ID = " + pIdPerfil;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE PERFIL_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND PERFIL_NOMBRE = '" + pNombre + "'";
             }

             if (pDescripcion != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE PERFIL_DESCRIPCION = '" + pDescripcion + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND PERFIL_DESCRIPCION = '" + pDescripcion + "'";
             }


            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unPerfil = new Perfil(rs.getInt("PERFIL_ID"),rs.getString("PERFIL_NOMBRE"), rs.getString("PERFIL_DESCRIPCION"));
                listaPerfiles.add(unPerfil);
            }
       }
        catch(SQLException ex)
        {
            listaPerfiles = null;
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
            return listaPerfiles;
        }
    }

    public boolean insertarPerfil(String pNombre, String pDescripcion)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO PERFIL (PERFIL_NOMBRE, PERFIL_DESCRIPCION) VALUES ('" + pNombre + "','" + pDescripcion + "')";
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

    public boolean modificarPerfil(int pIdPerfil, String pNombre, String pDescripcion)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE PERFIL SET PERFIL_NOMBRE = '" + pNombre + "', PERFIL_DESCRIPCION='" + pDescripcion + "' WHERE PERFIL_ID=" + pIdPerfil;
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

    public boolean eliminarPerfil(int pIdPerfil)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM PERFIL WHERE PERFIL_ID=" + pIdPerfil;
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
