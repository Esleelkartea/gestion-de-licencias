/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.PlantillaSMS;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class PlantillaSMSDAL {

    Conexion conexion;

    public PlantillaSMSDAL()
    {

    }

    public PlantillaSMS getPlantillaSMS(int pIdPlantillaSMS)
    {
        conexion = new Conexion();
        PlantillaSMS unaPlantillaSMS = null;
        String consulta= "SELECT * FROM PLANTILLA_SMS WHERE PLANTILLA_SMS_ID = " + pIdPlantillaSMS;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unaPlantillaSMS = new PlantillaSMS(rs.getInt("PLANTILLA_SMS_ID"), rs.getString("PLANTILLA_SMS_NOMBRE"), rs.getString("PLANTILLA_SMS_TEXTO"));
        }
        catch(Exception e)
        {
            unaPlantillaSMS = null;
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
            return unaPlantillaSMS;
        }
     }

    public ArrayList<PlantillaSMS> getPlantillaSMS(int pIdPlantillaSMS, String pNombre, String pTexto)
    {
        conexion = new Conexion();
        ArrayList<PlantillaSMS> listaPlantillaSMS = new ArrayList<PlantillaSMS>();
        PlantillaSMS unaPlantillaSMS = null;

        String consulta= "SELECT * FROM PLANTILLA_SMS ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdPlantillaSMS != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE PLANTILLA_SMS=" + pIdPlantillaSMS;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE PLANTILLA_SMS_NOMBRE= '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND PLANTILLA_SMS_NOMBRE = '" + pNombre + "'";
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unaPlantillaSMS = new PlantillaSMS(rs.getInt("PLANTILLA_SMS_ID"), rs.getString("PLANTILLA_SMS_NOMBRE"), rs.getString("PLANTIlLA_SMS_TEXTO"));
                listaPlantillaSMS.add(unaPlantillaSMS);
            }
       }
        catch(SQLException ex)
        {
            listaPlantillaSMS = null;
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
            return listaPlantillaSMS;
        }
    }

    public boolean insertarPlantillaSMS(String pNombre, String pTexto)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO PLANTILLA_SMS (PLANTILLA_SMS_NOMBRE, PLANTILLA_SMS_TEXTO) VALUES ('" + pNombre + "','" + pTexto + "')";
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

    public boolean modificarPlantillaSMS(int pIdPlantillaSMS, String pNombre, String pTexto)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE PLANTILLA_SMS SET PLANTILLA_SMS_NOMBRE = '" + pNombre + "', PLANTILLA_SMS_TEXTO = '" + pTexto + "' WHERE PLANTILLA_SMS_ID=" + pIdPlantillaSMS;
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

    public boolean eliminarPlantillaSMS(int pIdPlantillaSMS)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM PLANTILLA_SMS WHERE PLANTILLA_SMS_ID=" + pIdPlantillaSMS;
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
