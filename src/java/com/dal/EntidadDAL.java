/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Entidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class EntidadDAL {

    Conexion conexion;

    public EntidadDAL()
    {

    }

   public Entidad getEntidad(int pIdEntidad)
    {
        conexion = new Conexion();
        Entidad unaEntidad = null;
        String consulta= "SELECT * FROM ENTIDAD WHERE ENTIDAD_ID = " + pIdEntidad;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unaEntidad = new Entidad(rs.getInt("ENTIDAD_ID"), rs.getString("ENTIDAD_CODIGO"), rs.getString("ENTIDAD_CASTELLANO"), rs.getString("ENTIDAD_EUSKERA"), rs.getString("ENTIDAD_EMAIL"));
        }
        catch(Exception e)
        {
            unaEntidad = null;
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
            return unaEntidad;
        }
     }

    public ArrayList<Entidad> getEntidad(int pIdEntidad, String pCodigo, String pCastellano, String pEuskera)
    {
        conexion = new Conexion();
        ArrayList<Entidad> listaEntidades = new ArrayList<Entidad>();
        Entidad unaEntidad = null;
        String consulta= "SELECT * FROM ENTIDAD ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdEntidad != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE ENTIDAD_ID = " + pIdEntidad;
                     bConsul=true;
                 }
            }

            if (pCodigo != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE ENTIDAD_CODIGO= '" + pCodigo + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND ENTIDAD_CODIGO = '" + pCodigo + "'";
             }

             if (pCastellano != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE ENTIDAD_CASTELLANO = '" + pCastellano + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND ENTIDAD_CASTELLANO = '" + pCastellano + "'";
             }

             if (pEuskera != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE ENTIDAD_EUSKERA = '" + pEuskera + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND ENTIDAD_EUSKERA = '" + pEuskera + "'";
             }
            
            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unaEntidad = new Entidad(rs.getInt("ENTIDAD_ID"), rs.getString("ENTIDAD_CODIGO"), rs.getString("ENTIDAD_CASTELLANO"), rs.getString("ENTIDAD_EUSKERA"), rs.getString("ENTIDAD_EMAIL"));
                listaEntidades.add(unaEntidad);
            }
       }
        catch(SQLException ex)
        {
            listaEntidades = null;
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
            return listaEntidades;
        }
    }

    public boolean insertarEntidad(String pCodigo, String pCastellano, String pEuskera, String pEmail)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO ENTIDAD (ENTIDAD_CODIGO, ENTIDAD_CASTELLANO, ENTIDAD_EUSKERA, ENTIDAD_EMAIL) VALUES ('" + pCodigo + "','" + pCastellano + "','" + pEuskera + "','" + pEmail +"')";
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

    public boolean modificarEntidad(int pIdEntidad, String pCodigo, String pCastellano, String pEuskera, String pEmail)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE ENTIDAD SET ENTIDAD_CODIGO = '" + pCodigo + "', ENTIDAD_CASTELLANO='" + pCastellano + "', ENTIDAD_EUSKERA ='" + pEuskera + "' ENTIDAD_EMAIL='" + pEmail + "' WHERE ENTIDAD_ID=" + pIdEntidad;
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


    public boolean eliminarEntidad(int pIdEntidad)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM ENTIDAD WHERE ENTIDAD_ID=" + pIdEntidad;
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
