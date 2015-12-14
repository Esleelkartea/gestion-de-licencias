/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Colectivo;
import com.Negocio.Federado;
import com.Negocio.FederadoColectivo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class FederadoColectivoDAL {

    Conexion conexion;

    public FederadoColectivoDAL()
    {
        
    }

    public FederadoColectivo getFederadoColectivo(int pIdFederadoColectivo)
    {
        conexion = new Conexion();
        FederadoColectivo unFederadoColectivo = null;
        Federado unFederado = null;
        Colectivo unColectivo = null;
        FederadoDAL federadoDAL = new FederadoDAL();
        ColectivoDAL colectivoDAL = new ColectivoDAL();
        String consulta= "SELECT * FROM FEDERADO_COLECTIVO WHERE FEDERADO_COLECTIVO_ID = " + pIdFederadoColectivo;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
             {
                unFederado = federadoDAL.getFederado(rs.getInt("FEDERADO_COLECTIVO_FEDERADO_ID"));
                unColectivo = colectivoDAL.getColectivo(rs.getInt("FEDERADO_COLECTIVO_COLECTIVO_ID"));
                unFederadoColectivo = new FederadoColectivo(rs.getInt("FEDERADO_COLECTIVO_ID"), unFederado, unColectivo, rs.getString("FEDERADO_COLECTIVO_OBSERVACIONES"));
             }
        }
        catch(Exception e)
        {
            unFederadoColectivo = null;
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
            return unFederadoColectivo;
        }
     }

    public ArrayList<FederadoColectivo> getFederadoColectivo(int pIdFederadoColectivo, int pIdFederado, int pIdColectivo)
    {
        conexion = new Conexion();
        ArrayList<FederadoColectivo> listaFederadoColectivo = new ArrayList<FederadoColectivo>();
        FederadoColectivo unFederadoColectivo = null;
        Federado unFederado = null;
        Colectivo unColectivo = null;
        FederadoDAL federadoDAL = new FederadoDAL();
        ColectivoDAL colectivoDAL = new ColectivoDAL();
        String consulta= "SELECT * FROM FEDERADO_COLECTIVO";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdFederadoColectivo != -1){
                 if (bConsul==false)
                 {
                     consulta += " WHERE FEDERADO_COLECTIVO_ID=" + pIdFederadoColectivo;
                     bConsul=true;
                 }
            }

            if (pIdFederado != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += " WHERE FEDERADO_COLECTIVO_FEDERADO_ID = " + pIdFederado;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_COLECTIVO_FEDERADO_ID = " + pIdFederado;
             }

             if (pIdColectivo != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += " WHERE FEDERADO_COLECTIVO_COLECTIVO_ID = " + pIdColectivo;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_COLECTIVO_COLECTIVO_ID = " + pIdColectivo;
             }
            

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unFederado = federadoDAL.getFederado(rs.getInt("FEDERADO_COLECTIVO_FEDERADO_ID"));
                unColectivo = colectivoDAL.getColectivo(rs.getInt("FEDERADO_COLECTIVO_COLECTIVO_ID"));
                unFederadoColectivo = new FederadoColectivo(rs.getInt("FEDERADO_COLECTIVO_ID"), unFederado, unColectivo, rs.getString("FEDERADO_COLECTIVO_OBSERVACIONES"));
                listaFederadoColectivo.add(unFederadoColectivo);
            }
       }
        catch(SQLException ex)
        {
            listaFederadoColectivo = null;
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
            return listaFederadoColectivo;
        }
    }

    public boolean estaVinculado(int pIdFederado, int pIdColectivo)
    {
        conexion = new Conexion();
        boolean estaVinculado = false;
        String consulta= "SELECT * FROM FEDERADO_COLECTIVO WHERE FEDERADO_COLECTIVO_COLECTIVO_ID = " + pIdColectivo + " AND FEDERADO_COLECTIVO_FEDERADO_ID=" + pIdFederado;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
             {
                estaVinculado = true;
             }
        }
        catch(Exception e)
        {
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
            return estaVinculado;
        }
     }


    public boolean insertarFederadoColectivo(Federado pFederado,Colectivo pColectivo, String pObservaciones)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO FEDERADO_COLECTIVO (FEDERADO_COLECTIVO_FEDERADO_ID, FEDERADO_COLECTIVO_COLECTIVO_ID, FEDERADO_COLECTIVO_OBSERVACIONES) VALUES (" + pFederado.getIdFederado() + "," + pColectivo.getIdColectivo() + ",'" + pObservaciones + "')";
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

    public boolean modificarFederadoColectivo(int pIdFederadoColectivo, Federado pFederado, Colectivo pColectivo, String pObservaciones)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE FEDERADO_COLECTIVO SET FEDERADO_COLECTIVO_FEDERADO_ID = " + pFederado.getIdFederado() + ", FEDERADO_COLECTIVO_COLECTIVO_ID = " + pColectivo.getIdColectivo() + ", FEDERADO_COLECTIVO_OBSERVACIONES ='" + pObservaciones + "' WHERE FEDERADO_COLECTIVO_ID=" + pIdFederadoColectivo;
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

    public boolean modificarFederadoColectivo2(int pIdFederadoColectivo, int pFederado, int pColectivo, String pObservaciones)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE FEDERADO_COLECTIVO SET FEDERADO_COLECTIVO_FEDERADO_ID = " + pFederado + ", FEDERADO_COLECTIVO_COLECTIVO_ID = " + pColectivo + ", FEDERADO_COLECTIVO_OBSERVACIONES ='" + pObservaciones + "' WHERE FEDERADO_COLECTIVO_ID=" + pIdFederadoColectivo;
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

    public boolean eliminarFederadoColectivo(int pIdFederadoColectivo)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM FEDERADO_COLECTIVO WHERE FEDERADO_COLECTIVO_ID=" + pIdFederadoColectivo;
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

    public boolean eliminarFederadoColectivo(int pIdFederado, int pIdColectivo)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM FEDERADO_COLECTIVO WHERE FEDERADO_COLECTIVO_FEDERADO_ID=" + pIdFederado + " AND FEDERADO_COLECTIVO_COLECTIVO_ID=" + pIdColectivo;
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
