/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.DECurso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class DECursoDAL {

    Conexion conexion;

    public DECursoDAL()
    {

    }

    public DECurso getDECurso(int pIdDECurso)
    {
        conexion = new Conexion();
        DECurso unDECurso = null;
        String consulta= "SELECT * FROM DE_CURSO WHERE DE_CURSO_ID = " + pIdDECurso;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unDECurso = new DECurso (rs.getInt("DE_CURSO_ID"), rs.getString("DE_CURSO_NOMBRE"));
        }
        catch(Exception e)
        {
            unDECurso = null;
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
            return unDECurso;
        }
     }
    
     public ArrayList<DECurso> getDECurso(int pIdDECurso, String pNombre)
    {
        conexion = new Conexion();
        ArrayList<DECurso> listaDECurso = new ArrayList<DECurso>();
        DECurso unDECurso = null;
        String consulta= "SELECT * FROM DE_CURSO ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdDECurso != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_CURSO_ID = " + pIdDECurso;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_CURSO_ID = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_CURSO_NOMBRE = '" + pNombre + "'";
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unDECurso = new DECurso(rs.getInt("DE_CURSO_ID"), rs.getString("DE_CURSO_NOMBRE"));
                listaDECurso.add(unDECurso);
            }
       }
        catch(SQLException ex)
        {
            listaDECurso = null;
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
            return listaDECurso;
        }
    }

    public boolean insertarDECurso(String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO DE_CURSO (DE_CURSO_NOMBRE) VALUES ('" + pNombre + "')";
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

    public boolean modificarDECurso(int pIdDECurso, String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE DE_CURSO SET DE_CURSO_NOMBRE = '" + pNombre + "' WHERE DE_CURSO_ID=" + pIdDECurso;
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

    public boolean eliminarDECurso(int pIdDECurso)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM DE_CURSO WHERE DE_CURSO_ID=" + pIdDECurso;
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
