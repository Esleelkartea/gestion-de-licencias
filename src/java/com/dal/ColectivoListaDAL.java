/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Colectivo;
import com.Negocio.ColectivoLista;
import com.Negocio.Federado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class ColectivoListaDAL {

    Conexion conexion;

    public ColectivoListaDAL()
    {

    }

    public ColectivoLista getColectivoLista(int pIdColectivoLista)
    {
        conexion = new Conexion();
        ColectivoLista unColectivoLista = null;
        Colectivo unColectivo = null;
        ColectivoDAL colectivoDAL = new ColectivoDAL();
        Federado unFederado = null;
        FederadoDAL federadoDAL = new FederadoDAL();
        String consulta= "SELECT * FROM COLECTIVO_LISTA WHERE COLECTIVO_LISTA_ID = " + pIdColectivoLista;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
             {
                unColectivo = colectivoDAL.getColectivo(rs.getInt("COLECTIVO_LISTA_COLECTIVO_ID"));
                unColectivoLista = new ColectivoLista(rs.getInt("COLECTIVO_LISTA_ID"), unColectivo, unFederado);
             }
        }
        catch(Exception e)
        {
            unColectivoLista = null;
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
            return unColectivoLista;
        }
     }

    public ArrayList<ColectivoLista> getColectivoLista(int pIdColectivoLista, int pIdColectivo, int pIdFederado)
    {
        conexion = new Conexion();
        ArrayList<ColectivoLista> listaColectivoLista = new ArrayList<ColectivoLista>();
        ColectivoLista unColectivoLista = null;
        Colectivo unColectivo = null;
        ColectivoDAL colectivoDAL = new ColectivoDAL();
        Federado unFederado = null;
        FederadoDAL federadoDAL = new FederadoDAL();
        String consulta= "SELECT * FROM COLECTIVO_LISTA";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdColectivoLista != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE COLECTIVO_LISTA_ID = " + pIdColectivoLista;
                     bConsul=true;
                 }
            }

            if (pIdColectivo != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE COLECTIVO_LISTA_COLECTIVO_ID= " + pIdColectivo;
                     bConsul=true;
                 }
                 else
                     consulta += " AND COLECTIVO_LISTA_COLECTIVO_ID= " + pIdColectivo;
             }

             if (pIdFederado != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE COLECTIVO_LISTA_FEDERADO_ID = " + pIdFederado;
                     bConsul=true;
                 }
                 else
                     consulta += " AND COLECTIVO_LISTA_FEDERADO_ID = " + pIdFederado;
             }            

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unColectivo = colectivoDAL.getColectivo(rs.getInt("COLECTIVO_LISTA_COLECTIVO_ID"));
                unColectivoLista = new ColectivoLista(rs.getInt("COLECTIVO_LISTA_ID"), unColectivo, unFederado);
                listaColectivoLista.add(unColectivoLista);
            }
       }
        catch(SQLException ex)
        {
            listaColectivoLista = null;
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
            return listaColectivoLista;
        }
    }

    public boolean insertarColectivoLista(int pIdColectivo, int pIdFederado)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO COLECTIVO_LISTA (COLECTIVO_LISTA_COLECTIVO_ID, COLECTIVO_LISTA_FEDERADO_ID) VALUES (" + pIdColectivo + "," + pIdFederado +  ")";
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

    public boolean modificarColectivoLista(int pIdColectivoLista, int pIdColectivo, int pIdFederado)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE CATEGORIA_LISTA SET COLECTIVO_LISTA_COLECTIVO_ID= " + pIdColectivo + ", COLECTIVO_LISTA_FEDERADO_ID=" + pIdFederado + " WHERE COLECTIVO_LISTA_ID=" + pIdColectivoLista;
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

    public boolean eliminarColectivoLista(int pIdColectivoLista)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM COLECTIVO_LISTA WHERE COLECTIVO_LISTA_ID = " + pIdColectivoLista;
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
