/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.FederadoDireccion;
import com.Negocio.TipoDireccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class FederadoDireccionDAL {

    Conexion conexion;

    public FederadoDireccionDAL()
    {

    }

    public FederadoDireccion getFederadoDireccion(int pIdFederadoDireccion)
    {
        conexion = new Conexion();
        FederadoDireccion unFederadoDireccion = null;
        TipoDireccion tipoDireccion = null;
        TipoDireccionDAL tipoDireccionDAL = new TipoDireccionDAL();
        String consulta= "SELECT * FROM FEDERADO_DIRECCION WHERE FEDERADO_DIRECCION_ID = " + pIdFederadoDireccion;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
             {
                tipoDireccion = tipoDireccionDAL.getTipoDireccion(rs.getInt("FEDERADO_DIRECCION_TIPO"));
                unFederadoDireccion = new FederadoDireccion(rs.getInt("FEDERADO_DIRECCION_ID"), rs.getString("FEDERADO_DIRECCION_CALLE"), rs.getString("FEDERADO_DIRECCION_NUMERO"), rs.getString("FEDERADO_DIRECCION_ESCALERA"), rs.getString("FEDERADO_DIRECCION_PISO"), rs.getString("FEDERADO_DIRECCION_PUERTA"), rs.getString("FEDERADO_DIRECCION_COMPLEMENTO"), rs.getString("FEDERADO_DIRECCION_POBLACION"), rs.getString("FEDERADO_DIRECCION_CP"), rs.getString("FEDERADO_DIRECCION_PROVINCIA"),  tipoDireccion, rs.getInt("FEDERADO_DIRECCION_FEDERADO_ID"));
             }
        }
        catch(Exception e)
        {
            unFederadoDireccion = null;
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
            return unFederadoDireccion;
        }
     }

    public ArrayList<FederadoDireccion> getFederadoDireccion(int pIdFederadoDireccion, String pCalle, String pNumero, String pEscalera, String pPiso, String pPuerta, String pComplemento, String pPoblacion, String pCP, String pProvincia, int pTipoDireccion, int pIdFederado)
    {
        conexion = new Conexion();
        ArrayList<FederadoDireccion> listaFederadoDireccion = new ArrayList<FederadoDireccion>();
        FederadoDireccion unFederadoDireccion = null;
        TipoDireccion unTipoDireccion = null;
        TipoDireccionDAL tipoDireccionDAL = new TipoDireccionDAL();
        String consulta= "SELECT * FROM FEDERADO_DIRECCION";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdFederadoDireccion != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DIRECCION_ID=" + pIdFederadoDireccion;
                     bConsul=true;
                 }
            }

            if (pCalle != null)
            {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DIRECCION_CALLE = '" + pCalle + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DIRECCION_CALLE = '" + pCalle + "'";
            }

            if (pNumero != null)
            {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DIRECCION_NUMERO = '" + pNumero + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DIRECCION_NUMERO = '" + pNumero + "'";
            }

            if (pEscalera != null)
            {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DIRECCION_ESCALERA = '" + pEscalera + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DIRECCION_ESCALERA = '" + pEscalera + "'";
            }

            if (pPiso != null)
            {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DIRECCION_PISO = '" + pPiso + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DIRECCION_PISO = '" + pPiso + "'";
            }

            if (pPuerta != null)
            {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DIRECCION_PUERTA = '" + pPuerta + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DIRECCION_PUERTA = '" + pPuerta + "'";
            }

            if (pComplemento != null)
            {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DIRECCION_COMPLEMENTO = '" + pComplemento + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DIRECCION_COMPLEMENTO = '" + pComplemento + "'";
            }


            if (pPoblacion != null)
            {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DIRECCION_POBLACION = '" + pPoblacion + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DIRECCION_POBLACION = '" + pPoblacion + "'";
            }

            if (pCP != null)
            {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DIRECCION_CP = '" + pCP + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DIRECCION_CP = '" + pCP + "'";
            }


             if (pProvincia != null)
            {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DIRECCION_PROVINCIA = '" + pProvincia + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DIRECCION_PROVINCIA = '" + pProvincia + "'";
            }


            if (pIdFederado != -1)
            {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DIRECCION_FEDERADO_ID = " + pIdFederado;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DIRECCION_FEDERADO_ID = " + pIdFederado;
             }

             if (pTipoDireccion != -1)
            {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DIRECCION_TIPO = " + pTipoDireccion;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DIRECCION_TIPO = " + pTipoDireccion;
             }


            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
             unTipoDireccion = tipoDireccionDAL.getTipoDireccion(rs.getInt("FEDERADO_DIRECCION_TIPO"));
             unFederadoDireccion = new FederadoDireccion(rs.getInt("FEDERADO_DIRECCION_ID"), rs.getString("FEDERADO_DIRECCION_CALLE"), rs.getString("FEDERADO_DIRECCION_NUMERO"), rs.getString("FEDERADO_DIRECCION_ESCALERA"), rs.getString("FEDERADO_DIRECCION_PISO"), rs.getString("FEDERADO_DIRECCION_PUERTA"), rs.getString("FEDERADO_DIRECCION_COMPLEMENTO"), rs.getString("FEDERADO_DIRECCION_POBLACION"), rs.getString("FEDERADO_DIRECCION_CP"), rs.getString("FEDERADO_DIRECCION_PROVINCIA"),  unTipoDireccion, rs.getInt("FEDERADO_DIRECCION_FEDERADO_ID"));
             listaFederadoDireccion.add(unFederadoDireccion);
            }
       }
        catch(SQLException ex)
        {
            listaFederadoDireccion = null;
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
            return listaFederadoDireccion;
        }
    }

    public boolean insertarFederadoDireccion(String pCalle, String pNumero, String pEscalera, String pPiso, String pPuerta, String pComplemento, String pPoblacion, String pCP, String pProvincia, TipoDireccion pTipoDireccion, int pIdFederado)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO FEDERADO_DIRECCION (FEDERADO_DIRECCION_CALLE, FEDERADO_DIRECCION_NUMERO, FEDERADO_DIRECCION_ESCALERA, FEDERADO_DIRECCION_PISO, FEDERADO_DIRECCION_PUERTA, FEDERADO_DIRECCION_COMPLEMENTO, FEDERADO_DIRECCION_POBLACION, FEDERADO_DIRECCION_CP, FEDERADO_DIRECCION_PROVINCIA, FEDERADO_DIRECCION_FEDERADO_ID, FEDERADO_DIRECCION_TIPO) VALUES ('" + pCalle + "','" + pNumero + "','" + pEscalera + "','" + pPiso + "','" + pPuerta + "','" + pComplemento + "','" + pPoblacion + "','" + pCP + "','" + pProvincia + "', " + pIdFederado + "," + pTipoDireccion.getIdTipoDireccion() + ")";
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


    public boolean modificarFederadoDireccion(int pIdFederadoDireccion, String pCalle, String pNumero, String pEscalera, String pPiso, String pPuerta, String pComplemento, String pPoblacion, String pCP, String pProvincia, int pIdFederado, TipoDireccion pTipoDireccion)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE FEDERADO_DIRECCION SET FEDERADO_DIRECCION_DIRECCION = '" + pCalle + "', FEDERADO_DIRECCION_NUMERO='" + pNumero + "' FEDERADO_DIRECCION_ESCALERA='" + pEscalera + "', FEDERADO_DIRECCION_PISO='" + pPiso + "', FEDERADO_DIRECCION_PUERTA='" + pPuerta + "', FEDERADO_DIRECCION_COMLEMENTO='" + pComplemento + "', FEDERADO_DIRECCION_POBLACION='" + pPoblacion + "', FEDERADO_DIRECCION_CP='" + pCP + "', FEDERADO_DIRECCION_PROVINCIA='" + pProvincia + "', FEDERADO_DIRECCION_FEDERADO_ID =" + pIdFederado + ", FEDERADO_DIRECCION_TIPO=" + pTipoDireccion + " WHERE FEDERADO_DIRECCION_ID=" + pIdFederadoDireccion;
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

    public boolean eliminarFederadoDireccion(int pIdFederadoDireccion)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM FEDERADO_DIRECCION WHERE FEDERADO_DIRECCION_ID=" + pIdFederadoDireccion;
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
