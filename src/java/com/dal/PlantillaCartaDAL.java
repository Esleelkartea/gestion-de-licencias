/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.PlantillaCarta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class PlantillaCartaDAL {

    Conexion conexion;

    public PlantillaCartaDAL()
    {

    }

    public PlantillaCarta getPlantillaCarta(int pIdPlantillaCarta)
    {
        conexion = new Conexion();
        PlantillaCarta unaPlantillaCarta = null;
        String consulta= "SELECT * FROM PLANTILLA_CARTA WHERE PLANTILLA_CARTA_ID = " + pIdPlantillaCarta;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unaPlantillaCarta = new PlantillaCarta(rs.getInt("PLANTILLA_CARTA_ID"), rs.getString("PLANTILLA_CARTA_NOMBRE"), rs.getString("PLANTILLA_CARTA_FICHERO"));

        }
        catch(Exception e)
        {
            unaPlantillaCarta = null;
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
            return unaPlantillaCarta;
        }
     }

    public ArrayList<PlantillaCarta> getPlantillaCarta(int pIdPlantillaCarta, String pNombre, String pFichero)
    {
        conexion = new Conexion();
        ArrayList<PlantillaCarta> listaPlantillaCarta = new ArrayList<PlantillaCarta>();
        PlantillaCarta unaPlantillaCarta = null;
        String consulta= "SELECT * FROM PLANTILLA_CARTA ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdPlantillaCarta != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE PLANTILLA_CARTA_ID = " + pIdPlantillaCarta;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE PLANTILLA_CARTA_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND PLANTILLA_CARTA_NOMBRE = '" + pNombre + "'";
             }

             if (pFichero != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE PLANTILLA_CARTA_FICHERO = '" + pFichero + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND PLANTILLA_CARTA_FICHERO = '" + pFichero + "'";
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unaPlantillaCarta = new PlantillaCarta(rs.getInt("PLANTILLA_CARTA_ID"), rs.getString("PLANTILLA_CARTA_NOMBRE"), rs.getString("PLANTILLA_CARTA_FICHERO"));
                listaPlantillaCarta.add(unaPlantillaCarta);
            }
       }
        catch(SQLException ex)
        {
            listaPlantillaCarta = null;
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
            return listaPlantillaCarta;
        }
    }

    public boolean insertarPlantillaCarta(String pNombre, String pFichero)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO PLANTILLA_CARTA (PLANTILLA_CARTA_NOMBRE, PLANTILLA_CARTA_FICHERO) VALUES ('" + pNombre + "','" + pFichero + "')";
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

    public boolean modificarPlantillaCarta(int pIdPlantillaCarta, String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE PLANTILLA_CARTA SET PLANTILLA_CARTA_NOMBRE = '" + pNombre + "' WHERE PLANTILLA_CARTA_ID =" + pIdPlantillaCarta;
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

    public boolean eliminarPlantillaCarta(int pIdPlantillaCarta)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM PLANTILLA_CARTA WHERE PLANTILLA_CARTA_ID=" + pIdPlantillaCarta;
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
