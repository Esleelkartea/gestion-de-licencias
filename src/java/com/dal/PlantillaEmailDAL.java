/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.PlantillaEmail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class PlantillaEmailDAL {

    Conexion conexion;

    public PlantillaEmailDAL()
    {
        
    }

    public PlantillaEmail getPlantillaEmail(int pIdPlantillaEmail)
    {
        conexion = new Conexion();
        PlantillaEmail unaPlantillaEmail = null;
        String consulta= "SELECT * FROM PLANTILLA_EMAIL WHERE PLANTILLA_EMAIL_ID = " + pIdPlantillaEmail;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unaPlantillaEmail = new PlantillaEmail(rs.getInt("PLANTILLA_EMAIL_ID"), rs.getString("PLANTILLA_EMAIL_NOMBRE"), rs.getString("PLANTILLA_EMAIL_FICHERO"));
                 
        }
        catch(Exception e)
        {
            unaPlantillaEmail = null;
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
            return unaPlantillaEmail;
        }
     }

    public ArrayList<PlantillaEmail> getPlantillaEmail(int pIdPlantillaEmail, String pNombre, String pFichero)
    {
        conexion = new Conexion();
        ArrayList<PlantillaEmail> listaPlantillaEmail = new ArrayList<PlantillaEmail>();
        PlantillaEmail unaPlantillaEmail = null;
        String consulta= "SELECT * FROM PLANTILLA_EMAIL ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdPlantillaEmail != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE PLANTILLA_EMAIL_ID = " + pIdPlantillaEmail;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE PLANTILLA_EMAIL_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND PLANTILLA_EMAIL_NOMBRE = '" + pNombre + "'";
             }

             if (pFichero != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE PLANTILLA_EMAIL_FICHERO = '" + pFichero + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND PLANTILLA_EMAIL_FICHERO = '" + pFichero + "'";
             }
             
            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unaPlantillaEmail = new PlantillaEmail(rs.getInt("PLANTILLA_EMAIL_ID"), rs.getString("PLANTILLA_EMAIL_NOMBRE"), rs.getString("PLANTILLA_EMAIL_FICHERO"));
                listaPlantillaEmail.add(unaPlantillaEmail);
            }
       }
        catch(SQLException ex)
        {
            listaPlantillaEmail = null;
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
            return listaPlantillaEmail;
        }
    }

    public boolean insertarPlantillaEmail(String pNombre, String pFichero)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO PLANTILLA_EMAIL (PLANTILLA_EMAIL_NOMBRE, PLANTILLA_EMAIL_FICHERO) VALUES ('" + pNombre + "','" + pFichero + "')";
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
    
    public boolean modificarPlantillaEmail(int pIdPlantillaEmail, String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE PLANTILLA_EMAIL SET PLANTILLA_EMAIL_NOMBRE = '" + pNombre + "' WHERE PLANTILLA_EMAIL_ID =" + pIdPlantillaEmail;
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

    public boolean eliminarPlantillaEmail(int pIdPlantillaEmail)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM PLANTILLA_EMAIL WHERE PLANTILLA_EMAIL_ID=" + pIdPlantillaEmail;
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
