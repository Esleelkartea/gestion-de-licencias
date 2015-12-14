/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.FederadoTelefono;
import com.Negocio.TipoTelefono;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class FederadoTelefonoDAL {

    Conexion conexion;

    public FederadoTelefonoDAL()
    {
        
    }

    public FederadoTelefono getFederadoTelefono(int pIdFederadoTelefono)
    {
        conexion = new Conexion();
        FederadoTelefono unFederadoTelefono = null;
        TipoTelefono tipoTelefono = null;
        TipoTelefonoDAL tipoTelefonoDAL = new TipoTelefonoDAL();
        String consulta= "SELECT * FROM FEDERADO_TELEFONO WHERE FEDERADO_TELEFONO_ID = " + pIdFederadoTelefono;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
             {
                tipoTelefono = tipoTelefonoDAL.getTipoTelefono(rs.getInt("FEDERADO_TELEFONO_TIPO"));
                unFederadoTelefono = new FederadoTelefono(rs.getInt("FEDERADO_TELEFONO_ID"), rs.getString("FEDERADO_TELEFONO_NUMERO"), tipoTelefono, rs.getInt("FEDERADO_TELEFONO_ID_FEDERADO"));
             }
        }
        catch(Exception e)
        {
            unFederadoTelefono = null;
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
            return unFederadoTelefono;
        }
     }


    public ArrayList<FederadoTelefono> getFederadoTelefono(int pIdFederadoTelefono, int pIdFederado)
    {
        conexion = new Conexion();
        ArrayList<FederadoTelefono> listaFederadoTelefonos = new ArrayList<FederadoTelefono>();
        FederadoTelefono unFederadoTelefono = null;
        TipoTelefono unTipoTelefono = null;
        TipoTelefonoDAL tipoTelefonoDAL = new TipoTelefonoDAL();
        String consulta= "SELECT * FROM FEDERADO_TELEFONO ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdFederadoTelefono != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_TELEFONO_ID=" + pIdFederadoTelefono;
                     bConsul=true;
                 }
            }

            if (pIdFederado != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_TELEFONO_ID_FEDERADO= " + pIdFederado;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_TELEFONO_ID_FEDERADO = " + pIdFederado;
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
             unTipoTelefono = tipoTelefonoDAL.getTipoTelefono(rs.getInt("FEDERADO_TELEFONO_TIPO"));
             unFederadoTelefono = new FederadoTelefono(rs.getInt("FEDERADO_TELEFONO_ID"), rs.getString("FEDERADO_TELEFONO_NUMERO"), unTipoTelefono, rs.getInt("FEDERADO_TELEFONO_ID_FEDERADO"));
             listaFederadoTelefonos.add(unFederadoTelefono);
            }
       }
        catch(SQLException ex)
        {
            listaFederadoTelefonos = null;
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
            return listaFederadoTelefonos;
        }
    }


    public boolean insertarFederadoTelefono(String pNumero, TipoTelefono pTipoTelefono, int pIdFederado)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO FEDERADO_TELEFONO (FEDERADO_TELEFONO_NUMERO, FEDERADO_TELEFONO_TIPO, FEDERADO_TELEFONO_ID_FEDERADO) VALUES ('" + pNumero + "'," + pTipoTelefono.getIdTipoTelefono() + "," + pIdFederado + ")";
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

    public boolean modificarFederadoTelefono(int pIdFederadoTelefono, String pNumero, TipoTelefono pTipoTelefono, int pIdFederado)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE FEDERADO_TELEFONO SET FEDERADO_TELEFONO_NUMERO = '" + pNumero + "', FEDERADO_TELEFONO_TIPO = " + pTipoTelefono.getIdTipoTelefono() + ", FEDERADO_TELEFONO_ID_FEDERADO =" + pIdFederado + " WHERE FEDERADO_TELEFONO_ID=" + pIdFederadoTelefono;
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


    public boolean eliminarFederadoTelefono(int pIdFederadoTelefono)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM FEDERADO_TELEFONO WHERE FEDERADO_TELEFONO_ID=" + pIdFederadoTelefono;
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
