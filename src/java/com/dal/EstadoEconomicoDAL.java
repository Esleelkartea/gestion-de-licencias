/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.EstadoEconomico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class EstadoEconomicoDAL {


    Conexion conexion;

    public EstadoEconomicoDAL()
    {

    }

    public EstadoEconomico getEstadoEconomico(int pIdEstadoEconomico)
    {
        conexion = new Conexion();
        EstadoEconomico unEstadoEconomico = null;
        String consulta= "SELECT * FROM ESTADO_ECONOMICO WHERE ESTADO_ECONOMICO_ID = " + pIdEstadoEconomico;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unEstadoEconomico = new EstadoEconomico(rs.getInt("ESTADO_ECONOMICO_ID"), rs.getString("ESTADO_ECONOMICO_NOMBRE"), rs.getInt("ESTADO_ECONOMICO_NUMDIAS"));
        }
        catch(Exception e)
        {
            unEstadoEconomico = null;
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
            return unEstadoEconomico;
        }
     }


    public ArrayList<EstadoEconomico> getEstadoEconomico(int pIdEstadoEconomico, String pNombre, int pNumDias)
    {
        conexion = new Conexion();
        ArrayList<EstadoEconomico> listaEstadoEconomico = new ArrayList<EstadoEconomico>();
        EstadoEconomico unEstadoEconomico = null;
        String consulta= "SELECT * FROM ESTADO_ECONOMICO ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdEstadoEconomico != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE ESTADO_ECONOMICO_ID = " + pIdEstadoEconomico;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE ESTADO_ECONOMICO_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND ESTADO_ECONOMICO_NOMBRE = '" + pNombre + "'";
             }

             if (pNumDias != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE ESTADO_ECONOMICO_NUMDIAS = " + pNumDias;
                     bConsul=true;
                 }
                 else
                     consulta += " AND ESTADO_ECONOMICO_NUMDIAS = " + pNumDias;
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unEstadoEconomico = new EstadoEconomico(rs.getInt("ESTADO_ECONOMICO_ID"), rs.getString("ESTADO_ECONOMICO_NOMBRE"), rs.getInt("ESTADO_ECONOMICO_NUMDIAS"));
                listaEstadoEconomico.add(unEstadoEconomico);
            }
       }
        catch(SQLException ex)
        {
            listaEstadoEconomico = null;
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
            return listaEstadoEconomico;
        }
    }

    public boolean insertarEstadoEconomico(String pNombre, int pNumDias)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO ESTADO_ECONOMICO (ESTADO_ECONOMICO_NOMBRE, ESTADO_ECONOMICO_NUMDIAS) VALUES ('" + pNombre + "'," + pNumDias + ")";
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

    public boolean modificarEstadoEconomico(int pIdEstadoEconomico, String pNombre, int pNumDias)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE ESTADO_ECONOMICO SET ESTADO_ECONOMICO_NOMBRE = '" + pNombre + "', ESTADO_ECONOMICO_NUMDIAS = " + pNumDias + " WHERE ESTADO_ECONOMICO_ID =" + pIdEstadoEconomico;
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

    public boolean eliminarEstadoEconomico(int pIdEstadoEconomico)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM ESTADO_ECONOMICO WHERE ESTADO_ECONOMICO_ID=" + pIdEstadoEconomico;
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
