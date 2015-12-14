/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.FederadoEmail;
import com.Negocio.TipoEmail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class FederadoEmailDAL {

    Conexion conexion;

    public FederadoEmailDAL()
    {

    }

    public FederadoEmail getFederadoEmail(int pIdFederadoEmail)
    {
        conexion = new Conexion();
        FederadoEmail unFederadoEmail = null;
        TipoEmail tipoEmail = null;
        TipoEmailDAL tipoEmailDAL = new TipoEmailDAL();
        String consulta= "SELECT * FROM FEDERADO_EMAIL WHERE FEDERADO_EMAIL_ID = " + pIdFederadoEmail;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
             {
                tipoEmail = tipoEmailDAL.getTipoEmail(rs.getInt("FEDERADO_EMAIL_TIPO"));
                unFederadoEmail = new FederadoEmail(rs.getInt("FEDERADO_EMAIL_ID"), rs.getString("FEDERADO_EMAIL_CORREO"), tipoEmail, rs.getInt("FEDERADO_EMAIL_ID_FEDERADO"));
             }
        }
        catch(Exception e)
        {
            unFederadoEmail = null;
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
            return unFederadoEmail;
        }
     }


    public ArrayList<FederadoEmail> getFederadoEmail(int pIdFederadoEmail, int pIdFederado)
    {
        conexion = new Conexion();
        ArrayList<FederadoEmail> listaFederadoEmail = new ArrayList<FederadoEmail>();
        FederadoEmail unFederadoEmail = null;
        TipoEmail unTipoEmail = null;
        TipoEmailDAL tipoEmailDAL = new TipoEmailDAL();
        String consulta= "SELECT * FROM FEDERADO_EMAIL";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdFederadoEmail != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_EMAIL_ID=" + pIdFederadoEmail;
                     bConsul=true;
                 }
            }

            if (pIdFederado != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_EMAIL_ID_FEDERADO= " + pIdFederado;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_EMAIL_ID_FEDERADO = " + pIdFederado;
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
             unTipoEmail = tipoEmailDAL.getTipoEmail(rs.getInt("FEDERADO_EMAIL_TIPO"));
             unFederadoEmail = new FederadoEmail(rs.getInt("FEDERADO_EMAIL_ID"), rs.getString("FEDERADO_EMAIL_CORREO"), unTipoEmail, rs.getInt("FEDERADO_EMAIL_ID_FEDERADO"));
             listaFederadoEmail.add(unFederadoEmail);
            }
       }
        catch(SQLException ex)
        {
            listaFederadoEmail = null;
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
            return listaFederadoEmail;
        }
    }

    public boolean insertarFederadoEmail(String pCorreo, TipoEmail pTipoEmail, int pIdFederado)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO FEDERADO_EMAIL (FEDERADO_EMAIL_CORREO, FEDERADO_EMAIL_TIPO, FEDERADO_EMAIL_ID_FEDERADO) VALUES ('" + pCorreo + "'," + pTipoEmail.getIdTipoEmail() + "," + pIdFederado + ")";
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

    public boolean modificarFederadoEmail(int pIdFederadoEmail, String pCorreo, TipoEmail pTipoEmail, int pIdFederado)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE FEDERADO_EMAIL SET FEDERADO_EMAIL_CORREO = '" + pCorreo + "', FEDERADO_EMAIL_TIPO = " + pTipoEmail.getIdTipoEmail() + ", FEDERADO_EMAIL_ID_FEDERADO =" + pIdFederado + " WHERE FEDERADO_EMAIL_ID=" + pIdFederadoEmail;
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

    public boolean eliminarFederadoEmail(int pIdFederadoEmail)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM FEDERADO_EMAIL WHERE FEDERADO_EMAIL_ID=" + pIdFederadoEmail;
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
