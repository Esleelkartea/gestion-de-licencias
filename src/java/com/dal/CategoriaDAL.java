/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class CategoriaDAL {

    Conexion conexion;

    public CategoriaDAL()
    {

    }

    public Categoria getCategoria(int pIdCategoria)
    {
        conexion = new Conexion();
        Categoria unaCategoria = null;
        String consulta= "SELECT * FROM CATEGORIA WHERE CATEGORIA_ID = " + pIdCategoria;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unaCategoria = new Categoria(rs.getInt("CATEGORIA_ID"),rs.getString("CATEGORIA_CODIGO"), rs.getString("CATEGORIA_CASTELLANO"), rs.getString("CATEGORIA_EUSKERA"), rs.getInt("CATEGORIA_EDAD_MINIMA"), rs.getInt("CATEGORIA_EDAD_MAXIMA"));
        }
        catch(Exception e)
        {
            unaCategoria = null;
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
            return unaCategoria;
        }
     }

    public ArrayList<Categoria> getCategoria(int pIdCategoria, String pCodigo, String pCastellano, String pEuskera, int pEdadMinima, int pEdadMaxima)
    {
        conexion = new Conexion();
        ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
        Categoria unaCategoria = null;
        String consulta= "SELECT * FROM CATEGORIA ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdCategoria != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE CATEGORIA_ID = " + pIdCategoria;
                     bConsul=true;
                 }
            }

            if (pCodigo != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE CATEGORIA_CODIGO= '" + pCodigo + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND CATEGORIA_CODIGO = '" + pCodigo + "'";
             }

             if (pCastellano != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE CATEGORIA_CASTELLANO = '" + pCastellano + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND CATEGORIA_CASTELLANO = '" + pCastellano + "'";
             }

             if (pEuskera != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE CATEGORIA_EUSKERA = '" + pEuskera + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND CATEGORIA_EUSKERA = '" + pEuskera + "'";
             }

             if (pEdadMinima != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE CATEGORIA_EDAD_MINIMA= " + pEdadMinima;
                     bConsul=true;
                 }
                 else
                     consulta += " AND CATEGORIA_EDAD_MINIMA= '" + pEdadMinima;
             }

             if (pEdadMaxima != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE CATEGORIA_EDAD_MAXIMA = " + pEdadMaxima;
                     bConsul=true;
                 }
                 else
                     consulta += " AND CATEGORIA_EDAD_MAXIMA = '" + pEdadMaxima;
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unaCategoria = new Categoria(rs.getInt("CATEGORIA_ID"),rs.getString("CATEGORIA_CODIGO"), rs.getString("CATEGORIA_CASTELLANO"), rs.getString("CATEGORIA_EUSKERA"), rs.getInt("CATEGORIA_EDAD_MINIMA"), rs.getInt("CATEGORIA_EDAD_MAXIMA"));
                listaCategorias.add(unaCategoria);
            }
       }
        catch(SQLException ex)
        {
            listaCategorias = null;
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
            return listaCategorias;
        }
    }

    public boolean insertarCategoria(String pCodigo, String pCastellano, String pEuskera, int pEdadMinima, int pEdadMaxima)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO CATEGORIA (CATEGORIA_CODIGO, CATEGORIA_CASTELLANO, CATEGORIA_EUSKERA, CATEGORIA_EDAD_MINIMA, CATEGORIA_EDAD_MAXIMA) VALUES ('" + pCodigo + "','" + pCastellano + "','" + pEuskera + "'," + pEdadMinima + "," + pEdadMaxima + ")";
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

    public boolean modificarCategoria(int pIdCategoria, String pCodigo, String pCastellano, String pEuskera, int pEdadMinima, int pEdadMaxima)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE CATEGORIA SET CATEGORIA_CODIGO = '" + pCodigo + "', CATEGORIA_CASTELLANO='" + pCastellano + "', CATEGORIA_EUSKERA ='" + pEuskera + "', CATEGORIA_EDAD_MINIMA=" + pEdadMinima + ", CATEGORIA_EDAD_MAXIMA = " + pEdadMaxima + " WHERE CATEGORIA_ID=" + pIdCategoria;
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

    public boolean eliminarCategoria(int pIdCategoria)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM CATEGORIA WHERE CATEGORIA_ID=" + pIdCategoria;
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
