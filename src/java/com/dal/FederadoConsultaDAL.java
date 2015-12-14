/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Consulta;
import com.Negocio.Federado;
import com.Negocio.FederadoConsulta;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class FederadoConsultaDAL {

    Conexion conexion;

    public FederadoConsultaDAL()
    {

    }

    public FederadoConsulta getFederadoConsulta(int pIdFederadoConsulta)
    {
        conexion = new Conexion();
        FederadoConsulta unFederadoConsulta = null;
        Federado unFederado = null;
        Consulta unaConsulta = null;
        FederadoDAL federadoDAL = new FederadoDAL();
        ConsultaDAL consultaDAL = new ConsultaDAL();
        String consulta= "SELECT * FROM FEDERADO_CONSULTA WHERE FEDERADO_CONSULTA_ID = " + pIdFederadoConsulta;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
             {
                unFederado = federadoDAL.getFederado(rs.getInt("FEDERADO_CONSULTA_FEDERADO_ID"));
                unaConsulta = consultaDAL.getConsulta(rs.getInt("FEDERADO_CONSULTA_CONSULTA_ID"));
                unFederadoConsulta = new FederadoConsulta(rs.getInt("FEDERADO_CONSULTA_ID"), unFederado, unaConsulta, rs.getDate("FEDERADO_CONSULTA_FECHA"), rs.getBoolean("FEDERADO_CONSULTA_PENDIENTE"), rs.getString("FEDERADO_CONSULTA_OBSERVACIONES"));
             }
        }
        catch(Exception e)
        {
            unFederadoConsulta = null;
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
            return unFederadoConsulta;
        }
     }

    public ArrayList<FederadoConsulta> getFederadoConsulta(int pIdFederadoConsulta, int pIdFederado, int pIdConsulta, Date pFecha, String pPendiente)
    {
        conexion = new Conexion();
        ArrayList<FederadoConsulta> listaFederadoConsulta = new ArrayList<FederadoConsulta>();
        FederadoConsulta unFederadoConsulta = null;
        Federado unFederado = null;
        Consulta unaConsulta = null;
        FederadoDAL federadoDAL = new FederadoDAL();
        ConsultaDAL consultaDAL = new ConsultaDAL();
        String consulta= "SELECT * FROM FEDERADO_CONSULTA";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdFederadoConsulta != -1){
                 if (bConsul==false)
                 {
                     consulta += " WHERE FEDERADO_CONSULTA_ID=" + pIdFederadoConsulta;
                     bConsul=true;
                 }
            }

            if (pIdFederado != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += " WHERE FEDERADO_CONSULTA_FEDERADO_ID = " + pIdFederado;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_CONSULTA_FEDERADO_ID = " + pIdFederado;
             }

             if (pIdConsulta != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += " WHERE FEDERADO_CONSULTA_CONSULTA_ID = " + pIdConsulta;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_CONSULTA_CONSULTA_ID = " + pIdConsulta;
             }

             if (pFecha != null)
             {
                 if (bConsul==false)
                 {
                     consulta += " WHERE FEDERADO_CONSULTA_FECHA = '" + pFecha + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_CONSULTA_FECHA = " + pFecha + "'";
             }

             if (pPendiente != null)
             {
                 if (bConsul==false)
                 {
                     consulta += " WHERE FEDERADO_CONSULTA_PENDIENTE =" + pPendiente;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_CONSULTA_PENDIENTE = " + pPendiente;
             }


            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unFederado = federadoDAL.getFederado(rs.getInt("FEDERADO_CONSULTA_FEDERADO_ID"));
                unaConsulta = consultaDAL.getConsulta(rs.getInt("FEDERADO_CONSULTA_CONSULTA_ID"));
                unFederadoConsulta = new FederadoConsulta(rs.getInt("FEDERADO_CONSULTA_ID"), unFederado, unaConsulta, rs.getDate("FEDERADO_CONSULTA_FECHA"), rs.getBoolean("FEDERADO_CONSULTA_PENDIENTE"), rs.getString("FEDERADO_CONSULTA_OBSERVACIONES"));
                listaFederadoConsulta.add(unFederadoConsulta);
            }
       }
        catch(SQLException ex)
        {
            listaFederadoConsulta = null;
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
            return listaFederadoConsulta;
        }
    }

    public ArrayList<FederadoConsulta> getFederadoConsultaPendientes()
    {
        conexion = new Conexion();
        ArrayList<FederadoConsulta> listaFederadoConsulta = new ArrayList<FederadoConsulta>();
        FederadoConsulta unFederadoConsulta = null;
        Federado unFederado = null;
        Consulta unaConsulta = null;
        FederadoDAL federadoDAL = new FederadoDAL();
        ConsultaDAL consultaDAL = new ConsultaDAL();
        String consulta= "SELECT * FROM FEDERADO_CONSULTA WHERE FEDERADO_CONSULTA_PENDIENTE=TRUE";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unFederado = federadoDAL.getFederado(rs.getInt("FEDERADO_CONSULTA_FEDERADO_ID"));
                unaConsulta = consultaDAL.getConsulta(rs.getInt("FEDERADO_CONSULTA_CONSULTA_ID"));
                unFederadoConsulta = new FederadoConsulta(rs.getInt("FEDERADO_CONSULTA_ID"), unFederado, unaConsulta, rs.getDate("FEDERADO_CONSULTA_FECHA"), rs.getBoolean("FEDERADO_CONSULTA_PENDIENTE"), rs.getString("FEDERADO_CONSULTA_OBSERVACIONES"));
                listaFederadoConsulta.add(unFederadoConsulta);
            }
       }
        catch(SQLException ex)
        {
            listaFederadoConsulta = null;
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
            return listaFederadoConsulta;
        }
    }
   

    public boolean insertarFederadoConsulta(Federado pFederado,Consulta pConsulta, Date pFecha, boolean pPendiente, String pObservaciones)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO FEDERADO_CONSULTA (FEDERADO_CONSULTA_FEDERADO_ID, FEDERADO_CONSULTA_CONSULTA_ID, FEDERADO_CONSULTA_FECHA, FEDERADO_CONSULTA_PENDIENTE, FEDERADO_CONSULTA_OBSERVACIONES) VALUES (" + pFederado.getIdFederado() + "," + pConsulta.getIdConsulta() + ",'" + pFecha + "'," + pPendiente + ",'" + pObservaciones + "')";
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

    public boolean modificarFederadoConsulta(int pIdFederadoConsulta, Federado pFederado, Consulta pConsulta, Date pFecha, boolean pPendiente, String pObservaciones)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE FEDERADO_CONSULTA SET FEDERADO_CONSULTA_FEDERADO_ID = " + pFederado.getIdFederado() + ", FEDERADO_CONSULTA_CONSULTA_ID = " + pConsulta.getIdConsulta() + ", FEDERADO_CONSULTA_FECHA ='" + pFecha + "', FEDERADO_CONSULTA_PENDIENTE =" + pPendiente + ", FEDERADO_CONSULTA_OBSERVACIONES ='" + pObservaciones + "' WHERE FEDERADO_CONSULTA_ID=" + pIdFederadoConsulta;
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

    public boolean observacionesFederadoConsulta(int pIdFederadoConsulta, String pObservaciones)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE FEDERADO_CONSULTA SET FEDERADO_CONSULTA_OBSERVACIONES ='" + pObservaciones + "' WHERE FEDERADO_CONSULTA_ID=" + pIdFederadoConsulta;
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


    public boolean finalizarFederadoConsulta(int pIdFederadoConsulta, String pObservaciones)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE FEDERADO_CONSULTA SET  FEDERADO_CONSULTA_PENDIENTE =false, FEDERADO_CONSULTA_OBSERVACIONES ='" + pObservaciones + "' WHERE FEDERADO_CONSULTA_ID=" + pIdFederadoConsulta;
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

    public boolean eliminarFederadoConsulta(int pIdFederadoConsulta)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM FEDERADO_CONSULTA WHERE FEDERADO_CONSULTA_ID=" + pIdFederadoConsulta;
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
