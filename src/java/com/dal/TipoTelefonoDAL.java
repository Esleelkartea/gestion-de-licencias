/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.TipoTelefono;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class TipoTelefonoDAL {

    Conexion conexion;
    
    public TipoTelefonoDAL()
    {
        
    }
    
    public TipoTelefono getTipoTelefono(int pIdTipoTelefono)
    {
        conexion = new Conexion();
        TipoTelefono unTipoTelefono = null;
        String consulta= "SELECT * FROM TIPO_TELEFONO WHERE TIPO_TELEFONO_ID = " + pIdTipoTelefono;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unTipoTelefono = new TipoTelefono(rs.getInt("TIPO_TELEFONO_ID"), rs.getString("TIPO_TELEFONO_NOMBRE"));
        }
        catch(Exception e)
        {
            unTipoTelefono = null;
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
            return unTipoTelefono;
        }
     }

    public ArrayList<TipoTelefono> getTipoTelefono(int pIdTelefono, String pNombre)
    {
        conexion = new Conexion();
        ArrayList<TipoTelefono> listaTipoTelefono = new ArrayList<TipoTelefono>();
        TipoTelefono unTipoTelefono = null;
        
        String consulta= "SELECT * FROM TIPO_TELEFONO ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdTelefono != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_TELEFONO_ID=" + pIdTelefono;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE TIPO_TELEFONO_NOMBRE= " + pNombre;
                     bConsul=true;
                 }
                 else
                     consulta += " AND TIPO_TELEFONO_NOMBRE = " + pNombre;
             }            

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unTipoTelefono = new TipoTelefono(rs.getInt("TIPO_TELEFONO_ID"), rs.getString("TIPO_TELEFONO_NOMBRE"));
                listaTipoTelefono.add(unTipoTelefono);
            }
       }
        catch(SQLException ex)
        {
            listaTipoTelefono = null;
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
            return listaTipoTelefono;
        }
    }

    
    public boolean insertarTipoTelefono(String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO TIPO_TELEFONO (TIPO_TELEFONO_NOMBRE) VALUES ('" + pNombre + "')";
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

    public boolean modificarTipoTelefono(int pIdTipoTelefono, String pNombre)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE TIPO_TELEFONO SET TIPO_TELEFONO_NOMBRE = '" + pNombre + "' WHERE TIPO_TELEFONO_ID=" + pIdTipoTelefono;
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


    public boolean eliminarTipoTelefono(int pIdTipoTelefono)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM TIPO_TELEFONO WHERE TIPO_TELEFONO_ID=" + pIdTipoTelefono;
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
