/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Grupo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class GrupoDAL {

    Conexion conexion;

    public GrupoDAL()
    {
        
    }

    public Grupo getGrupo(int pIdGrupo)
    {
        conexion = new Conexion();
        Grupo unGrupo = null;
        String consulta= "SELECT * FROM GRUPO WHERE GRUPO_ID = " + pIdGrupo;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unGrupo = new Grupo(rs.getInt("GRUPO_ID"), rs.getString("GRUPO_LETRA"), rs.getString("GRUPO_NOMBRE"), rs.getString("GRUPO_DESCRIPCION"));
        }
        catch(Exception e)
        {
            unGrupo = null;
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
            return unGrupo;
        }
     }

    public ArrayList<Grupo> getGrupo(int pIdGrupo, String pLetra, String pNombre, String pDescripcion)
    {
        conexion = new Conexion();
        ArrayList<Grupo> listaGrupos = new ArrayList<Grupo>();
        Grupo unGrupo = null;
        String consulta= "SELECT * FROM GRUPO ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdGrupo != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE GRUPO_ID = " + pIdGrupo;
                     bConsul=true;
                 }
            }

            if (pLetra != null)
            {
                 if (bConsul==false)
                 {
                     consulta += "WHERE GRUPO_LETRA = '" + pLetra + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND GRUPO_LETRA = '" + pLetra + "'";
             }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE GRUPO_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND GRUPO_NOMBRE = '" + pNombre + "'";
             }

             if (pDescripcion != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE GRUPO_DESCRIPCION = '" + pDescripcion + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND GRUPO_DESCRIPCION = '" + pDescripcion + "'";
             }


            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unGrupo = new Grupo(rs.getInt("GRUPO_ID"), rs.getString("GRUPO_LETRA"), rs.getString("GRUPO_NOMBRE"), rs.getString("GRUPO_DESCRIPCION"));
                listaGrupos.add(unGrupo);
            }
       }
        catch(SQLException ex)
        {
            listaGrupos = null;
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
            return listaGrupos;
        }
    }

    public boolean insertarGrupo(String pLetra, String pNombre, String pDescripcion)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO GRUPO (GRUPO_LETRA, GRUPO_NOMBRE, GRUPO_DESCRIPCION) VALUES ('" + pLetra + "','" + pNombre + "','" + pDescripcion + "')";
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

    public boolean modificarGrupo(int pIdGrupo, String pLetra, String pNombre, String pDescripcion)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE GRUPO SET GRUPO_LETRA = '" + pLetra + "' , GRUPO_NOMBRE = '" + pNombre + "', GRUPO_DESCRIPCION='" + pDescripcion + "' WHERE GRUPO_ID=" + pIdGrupo;
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

    public boolean eliminarGrupo(int pIdGrupo)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM GRUPO WHERE GRUPO_ID=" + pIdGrupo;
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
