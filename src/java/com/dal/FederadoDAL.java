/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Federado;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class FederadoDAL {

    Conexion conexion;

    public FederadoDAL()
    {

    }

    public Federado getFederado(int pIdFederado)
    {
        conexion = new Conexion();
        Federado unFederado = null;
        String consulta= "SELECT * FROM FEDERADO WHERE FEDERADO_ID = " + pIdFederado;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unFederado = new Federado(rs.getInt("FEDERADO_ID"), rs.getString("FEDERADO_NUMFEDERADO"), rs.getString("FEDERADO_NOMBRE"), rs.getString("FEDERADO_APELLIDO1"), rs.getString("FEDERADO_APELLIDO2"), rs.getString("FEDERADO_DNI"), rs.getDate("FEDERADO_FECHANAC"), rs.getString("FEDERADO_SEXO"), rs.getString("FEDERADO_NACIONALIDAD"), rs.getBoolean("FEDERADO_RESIDENTE"), rs.getBoolean("FEDERADO_TUTOR"),rs.getString("FEDERADO_TUTOR_TIPO"), rs.getString("FEDERADO_TUTOR_NOMBRE"), rs.getString("FEDERADO_TUTOR_APELLIDO1"), rs.getString("FEDERADO_TUTOR_APELLIDO2"), rs.getString("FEDERADO_TUTOR_DNI"), rs.getBoolean("FEDERADO_HANDICAP"), rs.getDouble("FEDERADO_NUMHANDICAP"), rs.getString("FEDERADO_FORMAPAGO"), rs.getString("FEDERADO_NUMCUENTA"), rs.getBoolean("FEDERADO_NOTA1"), rs.getBoolean("FEDERADO_NOTA2"), rs.getBoolean("FEDERADO_NOTA3"), rs.getInt("FEDERADO_ENTIDAD_ID"), rs.getInt("FEDERADO_ESTADO_LICENCIA"), rs.getInt("FEDERADO_ESTADO_ECONOMICO"), rs.getDate("FEDERADO_FECHA_PRE_ALTA"), rs.getDate("FEDERADO_FECHA_ALTA"), rs.getDate("FEDERADO_FECHA_BAJA"), rs.getInt("FEDERADO_RAZON_BAJA"), rs.getBoolean("FEDERADO_HOMOLOGADO"), rs.getString("FEDERADO_TUTOR_NUMFEDERADO"));
        }
        catch(Exception e)
        {
            unFederado = null;
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
            return unFederado;
        }
     }



    public Federado getFederado2(String pNumFederado)
    {
        conexion = new Conexion();
        Federado unFederado = null;
        String consulta= "SELECT * FROM FEDERADO WHERE FEDERADO_NUMFEDERADO = '" + pNumFederado + "'";
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unFederado = new Federado(rs.getInt("FEDERADO_ID"), rs.getString("FEDERADO_NUMFEDERADO"), rs.getString("FEDERADO_NOMBRE"), rs.getString("FEDERADO_APELLIDO1"), rs.getString("FEDERADO_APELLIDO2"), rs.getString("FEDERADO_DNI"), rs.getDate("FEDERADO_FECHANAC"), rs.getString("FEDERADO_SEXO"), rs.getString("FEDERADO_NACIONALIDAD"), rs.getBoolean("FEDERADO_RESIDENTE"), rs.getBoolean("FEDERADO_TUTOR"),rs.getString("FEDERADO_TUTOR_TIPO"), rs.getString("FEDERADO_TUTOR_NOMBRE"), rs.getString("FEDERADO_TUTOR_APELLIDO1"), rs.getString("FEDERADO_TUTOR_APELLIDO2"), rs.getString("FEDERADO_TUTOR_DNI"), rs.getBoolean("FEDERADO_HANDICAP"), rs.getDouble("FEDERADO_NUMHANDICAP"), rs.getString("FEDERADO_FORMAPAGO"), rs.getString("FEDERADO_NUMCUENTA"), rs.getBoolean("FEDERADO_NOTA1"), rs.getBoolean("FEDERADO_NOTA2"), rs.getBoolean("FEDERADO_NOTA3"), rs.getInt("FEDERADO_ENTIDAD_ID"), rs.getInt("FEDERADO_ESTADO_LICENCIA"), rs.getInt("FEDERADO_ESTADO_ECONOMICO"), rs.getDate("FEDERADO_FECHA_PRE_ALTA"), rs.getDate("FEDERADO_FECHA_ALTA"), rs.getDate("FEDERADO_FECHA_BAJA"), rs.getInt("FEDERADO_RAZON_BAJA"), rs.getBoolean("FEDERADO_HOMOLOGADO"), rs.getString("FEDERADO_TUTOR_NUMFEDERADO"));
        }
        catch(Exception e)
        {
            unFederado = null;
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
            return unFederado;
        }
     }


    public ArrayList<Federado> getFederado(int pIdFederado, String pNumFederado, String pNombre, String pApellido1, String pApellido2, String pDNI, Date pFechaNac, String pSexo, String pNacionalidad, String pNombreTutor, String pApellido1Tutor, String pApellido2Tutor, String pDNITutor, double pNumHandicap, String pFormaPago, String pNumCuenta, int pIdEntidad, int pIdEstadoEconomico, int pIdEstadoLicencia, Date pFechaPreAlta, Date pFechaAlta, Date pFechaBaja, int pRazonBaja, String pTutorNumFederado)
    {
        conexion = new Conexion();
        ArrayList<Federado> listaFederado = new ArrayList<Federado>();
        Federado unFederado = null;
        String consulta= "SELECT * FROM FEDERADO ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdFederado != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_ID = " + pIdFederado;
                     bConsul=true;
                 }
            }

             if (pNumFederado != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_NUMFEDERADO = '" + pNumFederado + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_NUMFEDERADO = '" + pNumFederado + "'";
             }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_NOMBRE = '" + pNombre + "'";
             }

             if (pApellido1 != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_APELLIDO1 = '" + pApellido1 + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_APELLIDO1 = '" + pApellido1 + "'";
             }

             if (pApellido2 != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_APELLIDO2 = '" + pApellido2 + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_APELLIDO2 = '" + pApellido2 + "'";
             }

             if (pDNI != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DNI = '" + pDNI + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DNI = '" + pDNI + "'";
             }

             if (pFechaNac != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_FECHANAC = '" + pFechaNac + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_FECHANAC = '" + pFechaNac + "'";
             }

             if (pSexo != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_SEXO = '" + pSexo + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_SEXO = '" + pSexo + "'";
             }

             if (pNacionalidad != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_NACIONALIDAD = '" + pNacionalidad + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_NACIONALIDAD = '" + pNacionalidad + "'";
             }

             if (pNombreTutor != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_TUTOR_NOMBRE = '" + pNombreTutor + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  FEDERADO_TUTOR_NOMBRE= '" + pNombreTutor + "'";
             }

             if (pApellido1Tutor != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_TUTOR_APELLIDO1 = '" + pApellido1Tutor + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  FEDERADO_TUTOR_APELLIDO1 = '" + pApellido1Tutor + "'";
             }

             if (pApellido2Tutor != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_TUTOR_APELLIDO2 = '" + pApellido2Tutor + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  FEDERADO_TUTOR_APELLIDO2 = '" + pApellido2Tutor + "'";
             }

             if (pDNITutor != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_TUTOR_DNI = '" + pDNITutor + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_TUTOR_DNI = '" + pDNITutor + "'";
             }

             if (pNumHandicap != -1.0)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_NUMHANDICAP = '" + pNumHandicap;
                     bConsul=true;
                 }
                 else
                     consulta += " AND  FEDERADO_NUMHANDICAP = '" + pNumHandicap;
             }

             if (pFormaPago != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_FORMAPAGO = '" + pFormaPago + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  FEDERADO_FORMAPAGO = '" + pFormaPago + "'";
             }

             if (pNumCuenta != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_NUMCUENTA = '" + pNumCuenta + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_NUMCUENTA = '" + pNumCuenta + "'";
             }

             if (pIdEntidad != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_ENTIDAD_ID = " + pIdEntidad;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_ENTIDAD_ID = " + pIdEntidad;
             }

             if (pIdEstadoEconomico != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_ESTADO_LICENCIA = " + pIdEstadoEconomico;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_ESTADO_LICENCIA = " + pIdEstadoEconomico;
             }

             if (pIdEstadoLicencia != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_ESTADO_ECONOMICO = " + pIdEstadoLicencia;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_ESTADO_ECONOMICO = " + pIdEstadoLicencia;
             }

             if (pFechaPreAlta != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_FECHA_PRE_ALTA = '" + pFechaPreAlta + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_FECHA_PRE_ALTA = '" + pFechaPreAlta + "'";
             }

             if (pFechaAlta != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_FECHA_ALTA = '" + pFechaAlta + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_FECHA_ALTA = '" + pFechaAlta + "'";
             }

             if (pFechaBaja != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_FECHA_BAJA = '" + pFechaBaja + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_FECHA_BAJA = '" + pFechaBaja + "'";
             }

             if (pRazonBaja != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_RAZON_BAJA = " + pRazonBaja;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_RAZON_BAJA = " + pRazonBaja;
             }


             if (pTutorNumFederado != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_TUTOR_NUMFEDERADO = '" + pTutorNumFederado + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_TUTOR_NUMFEDERADO = '" + pTutorNumFederado + "'";
             }

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unFederado = new Federado(rs.getInt("FEDERADO_ID"), rs.getString("FEDERADO_NUMFEDERADO"), rs.getString("FEDERADO_NOMBRE"), rs.getString("FEDERADO_APELLIDO1"), rs.getString("FEDERADO_APELLIDO2"), rs.getString("FEDERADO_DNI"), rs.getDate("FEDERADO_FECHANAC"), rs.getString("FEDERADO_SEXO"), rs.getString("FEDERADO_NACIONALIDAD"), rs.getBoolean("FEDERADO_RESIDENTE"), rs.getBoolean("FEDERADO_TUTOR"),rs.getString("FEDERADO_TUTOR_TIPO"), rs.getString("FEDERADO_TUTOR_NOMBRE"), rs.getString("FEDERADO_TUTOR_APELLIDO1"), rs.getString("FEDERADO_TUTOR_APELLIDO2"), rs.getString("FEDERADO_TUTOR_DNI"), rs.getBoolean("FEDERADO_HANDICAP"), rs.getDouble("FEDERADO_NUMHANDICAP"), rs.getString("FEDERADO_FORMAPAGO"), rs.getString("FEDERADO_NUMCUENTA"), rs.getBoolean("FEDERADO_NOTA1"), rs.getBoolean("FEDERADO_NOTA2"), rs.getBoolean("FEDERADO_NOTA3"), rs.getInt("FEDERADO_ENTIDAD_ID"), rs.getInt("FEDERADO_ESTADO_LICENCIA"), rs.getInt("FEDERADO_ESTADO_ECONOMICO"), rs.getDate("FEDERADO_FECHA_PRE_ALTA"), rs.getDate("FEDERADO_FECHA_ALTA"), rs.getDate("FEDERADO_FECHA_BAJA"), rs.getInt("FEDERADO_RAZON_BAJA"), rs.getBoolean("FEDERADO_HOMOLOGADO"), rs.getString("FEDERADO_TUTOR_NUMFEDERADO"));
                listaFederado.add(unFederado);
            }
       }
        catch(SQLException ex)
        {
            listaFederado = null;
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
            return listaFederado;
        }
    }


    public ArrayList<Federado> getFederadoConsulta(int pIdFederado, String pNumFederado, String pNombre, String pApellido1, String pApellido2, String pDNI)
    {
        conexion = new Conexion();
        ArrayList<Federado> listaFederado = new ArrayList<Federado>();
        Federado unFederado = null;
        String consulta= "SELECT * FROM FEDERADO ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdFederado != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_ID = " + pIdFederado;
                     bConsul=true;
                 }
            }

             if (pNumFederado != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_NUMFEDERADO = '" + pNumFederado + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_NUMFEDERADO = '" + pNumFederado + "'";
             }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_NOMBRE = '" + pNombre + "'";
             }

             if (pApellido1 != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_APELLIDO1 = '" + pApellido1 + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_APELLIDO1 = '" + pApellido1 + "'";
             }

             if (pApellido2 != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_APELLIDO2 = '" + pApellido2 + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_APELLIDO2 = '" + pApellido2 + "'";
             }

             if (pDNI != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DNI = '" + pDNI + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DNI = '" + pDNI + "'";
             }

             consulta += " AND FEDERADO_RAZON_BAJA = 0";

             
            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unFederado = new Federado(rs.getInt("FEDERADO_ID"), rs.getString("FEDERADO_NUMFEDERADO"), rs.getString("FEDERADO_NOMBRE"), rs.getString("FEDERADO_APELLIDO1"), rs.getString("FEDERADO_APELLIDO2"), rs.getString("FEDERADO_DNI"), rs.getDate("FEDERADO_FECHANAC"), rs.getString("FEDERADO_SEXO"), rs.getString("FEDERADO_NACIONALIDAD"), rs.getBoolean("FEDERADO_RESIDENTE"), rs.getBoolean("FEDERADO_TUTOR"),rs.getString("FEDERADO_TUTOR_TIPO"), rs.getString("FEDERADO_TUTOR_NOMBRE"), rs.getString("FEDERADO_TUTOR_APELLIDO1"), rs.getString("FEDERADO_TUTOR_APELLIDO2"), rs.getString("FEDERADO_TUTOR_DNI"), rs.getBoolean("FEDERADO_HANDICAP"), rs.getDouble("FEDERADO_NUMHANDICAP"), rs.getString("FEDERADO_FORMAPAGO"), rs.getString("FEDERADO_NUMCUENTA"), rs.getBoolean("FEDERADO_NOTA1"), rs.getBoolean("FEDERADO_NOTA2"), rs.getBoolean("FEDERADO_NOTA3"), rs.getInt("FEDERADO_ENTIDAD_ID"), rs.getInt("FEDERADO_ESTADO_LICENCIA"), rs.getInt("FEDERADO_ESTADO_ECONOMICO"), rs.getDate("FEDERADO_FECHA_PRE_ALTA"), rs.getDate("FEDERADO_FECHA_ALTA"), rs.getDate("FEDERADO_FECHA_BAJA"), rs.getInt("FEDERADO_RAZON_BAJA"), rs.getBoolean("FEDERADO_HOMOLOGADO"), rs.getString("FEDERADO_TUTOR_NUMFEDERADO"));
                listaFederado.add(unFederado);
            }
       }
        catch(SQLException ex)
        {
            listaFederado = null;
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
            return listaFederado;
        }
    }


    public ArrayList<Federado> getFederadoBusquedaBaja(int pIdFederado, String pNumFederado, String pNombre, String pApellido1, String pApellido2, String pDNI, int pEntidad, Date pFechaInicio, Date pFechaFin)
    {
        conexion = new Conexion();
        ArrayList<Federado> listaFederado = new ArrayList<Federado>();
        Federado unFederado = null;
        String consulta= "SELECT * FROM FEDERADO ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdFederado != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_ID = " + pIdFederado;
                     bConsul=true;
                 }
            }

             if (pNumFederado != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_NUMFEDERADO = '" + pNumFederado + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_NUMFEDERADO = '" + pNumFederado + "'";
             }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_NOMBRE = '" + pNombre + "'";
             }

             if (pApellido1 != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_APELLIDO1 = '" + pApellido1 + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_APELLIDO1 = '" + pApellido1 + "'";
             }

             if (pApellido2 != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_APELLIDO2 = '" + pApellido2 + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_APELLIDO2 = '" + pApellido2 + "'";
             }

             if (pDNI != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DNI = '" + pDNI + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DNI = '" + pDNI + "'";
             }

             if (pFechaInicio != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_FECHA_BAJA >= '" + pFechaInicio + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_FECHA_BAJA >= '" + pFechaInicio + "'";
             }

             if (pFechaFin != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_FECHA_BAJA <= '" + pFechaFin + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_FECHA_BAJA <= '" + pFechaFin + "'";
             }

             if (pEntidad != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_ENTIDAD_ID = " + pEntidad;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_ENTIDAD_ID = " + pEntidad;
             }

             if (bConsul==false)
             {
                consulta += " WHERE FEDERADO_RAZON_BAJA <> 0 ORDER BY FEDERADO_FECHA_BAJA DESC";
                bConsul=true;
             }
             else
                     consulta += " AND FEDERADO_RAZON_BAJA <> 0 ORDER BY FEDERADO_FECHA_BAJA DESC";



            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unFederado = new Federado(rs.getInt("FEDERADO_ID"), rs.getString("FEDERADO_NUMFEDERADO"), rs.getString("FEDERADO_NOMBRE"), rs.getString("FEDERADO_APELLIDO1"), rs.getString("FEDERADO_APELLIDO2"), rs.getString("FEDERADO_DNI"), rs.getDate("FEDERADO_FECHANAC"), rs.getString("FEDERADO_SEXO"), rs.getString("FEDERADO_NACIONALIDAD"), rs.getBoolean("FEDERADO_RESIDENTE"), rs.getBoolean("FEDERADO_TUTOR"),rs.getString("FEDERADO_TUTOR_TIPO"), rs.getString("FEDERADO_TUTOR_NOMBRE"), rs.getString("FEDERADO_TUTOR_APELLIDO1"), rs.getString("FEDERADO_TUTOR_APELLIDO2"), rs.getString("FEDERADO_TUTOR_DNI"), rs.getBoolean("FEDERADO_HANDICAP"), rs.getDouble("FEDERADO_NUMHANDICAP"), rs.getString("FEDERADO_FORMAPAGO"), rs.getString("FEDERADO_NUMCUENTA"), rs.getBoolean("FEDERADO_NOTA1"), rs.getBoolean("FEDERADO_NOTA2"), rs.getBoolean("FEDERADO_NOTA3"), rs.getInt("FEDERADO_ENTIDAD_ID"), rs.getInt("FEDERADO_ESTADO_LICENCIA"), rs.getInt("FEDERADO_ESTADO_ECONOMICO"), rs.getDate("FEDERADO_FECHA_PRE_ALTA"), rs.getDate("FEDERADO_FECHA_ALTA"), rs.getDate("FEDERADO_FECHA_BAJA"), rs.getInt("FEDERADO_RAZON_BAJA"), rs.getBoolean("FEDERADO_HOMOLOGADO"), rs.getString("FEDERADO_TUTOR_NUMFEDERADO"));
                listaFederado.add(unFederado);
            }
       }
        catch(SQLException ex)
        {
            listaFederado = null;
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
            return listaFederado;
        }
    }


    public ArrayList<Federado> getFederadoBusquedaPendiente(int pIdFederado, String pNumFederado, String pNombre, String pApellido1, String pApellido2, String pDNI, int pEntidad, Date pFechaInicio, Date pFechaFin)
    {
        conexion = new Conexion();
        ArrayList<Federado> listaFederado = new ArrayList<Federado>();
        Federado unFederado = null;
        String consulta= "SELECT * FROM FEDERADO ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdFederado != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_ID = " + pIdFederado;
                     bConsul=true;
                 }
            }

             if (pNumFederado != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_NUMFEDERADO = '" + pNumFederado + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_NUMFEDERADO = '" + pNumFederado + "'";
             }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_NOMBRE = '" + pNombre + "'";
             }

             if (pApellido1 != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_APELLIDO1 = '" + pApellido1 + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_APELLIDO1 = '" + pApellido1 + "'";
             }

             if (pApellido2 != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_APELLIDO2 = '" + pApellido2 + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_APELLIDO2 = '" + pApellido2 + "'";
             }

             if (pDNI != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_DNI = '" + pDNI + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_DNI = '" + pDNI + "'";
             }

             if (pFechaInicio != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_FECHA_PRE_ALTA >= '" + pFechaInicio + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_FECHA_PRE_ALTA >= '" + pFechaInicio + "'";
             }

             if (pFechaFin != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_FECHA_PRE_ALTA <= '" + pFechaFin + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_FECHA_PRE_ALTA <= '" + pFechaFin + "'";
             }

             if (pEntidad != -1)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE FEDERADO_ENTIDAD_ID = " + pEntidad;
                     bConsul=true;
                 }
                 else
                     consulta += " AND FEDERADO_ENTIDAD_ID = " + pEntidad;
             }

             if (bConsul==false)
             {
                consulta += " WHERE FEDERADO_FECHA_ALTA IS NULL AND FEDERADO_FECHA_BAJA IS NULL ORDER BY FEDERADO_FECHA_PRE_ALTA DESC";
                bConsul=true;
             }
             else
                     consulta += " AND FEDERADO_FECHA_ALTA IS NULL AND FEDERADO_FECHA_BAJA IS NULL ORDER BY FEDERADO_FECHA_PRE_ALTA DESC";



            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unFederado = new Federado(rs.getInt("FEDERADO_ID"), rs.getString("FEDERADO_NUMFEDERADO"), rs.getString("FEDERADO_NOMBRE"), rs.getString("FEDERADO_APELLIDO1"), rs.getString("FEDERADO_APELLIDO2"), rs.getString("FEDERADO_DNI"), rs.getDate("FEDERADO_FECHANAC"), rs.getString("FEDERADO_SEXO"), rs.getString("FEDERADO_NACIONALIDAD"), rs.getBoolean("FEDERADO_RESIDENTE"), rs.getBoolean("FEDERADO_TUTOR"),rs.getString("FEDERADO_TUTOR_TIPO"), rs.getString("FEDERADO_TUTOR_NOMBRE"), rs.getString("FEDERADO_TUTOR_APELLIDO1"), rs.getString("FEDERADO_TUTOR_APELLIDO2"), rs.getString("FEDERADO_TUTOR_DNI"), rs.getBoolean("FEDERADO_HANDICAP"), rs.getDouble("FEDERADO_NUMHANDICAP"), rs.getString("FEDERADO_FORMAPAGO"), rs.getString("FEDERADO_NUMCUENTA"), rs.getBoolean("FEDERADO_NOTA1"), rs.getBoolean("FEDERADO_NOTA2"), rs.getBoolean("FEDERADO_NOTA3"), rs.getInt("FEDERADO_ENTIDAD_ID"), rs.getInt("FEDERADO_ESTADO_LICENCIA"), rs.getInt("FEDERADO_ESTADO_ECONOMICO"), rs.getDate("FEDERADO_FECHA_PRE_ALTA"), rs.getDate("FEDERADO_FECHA_ALTA"), rs.getDate("FEDERADO_FECHA_BAJA"), rs.getInt("FEDERADO_RAZON_BAJA"), rs.getBoolean("FEDERADO_HOMOLOGADO"), rs.getString("FEDERADO_TUTOR_NUMFEDERADO"));
                listaFederado.add(unFederado);
            }
       }
        catch(SQLException ex)
        {
            listaFederado = null;
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
            return listaFederado;
        }
    }

    public ArrayList<Federado> getFederadoBaja()
    {
        conexion = new Conexion();
        ArrayList<Federado> listaFederado = new ArrayList<Federado>();
        Federado unFederado = null;
        String consulta= "SELECT * FROM FEDERADO WHERE FEDERADO_RAZON_BAJA <> 0 ORDER BY FEDERADO_FECHA_BAJA DESC";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unFederado = new Federado(rs.getInt("FEDERADO_ID"), rs.getString("FEDERADO_NUMFEDERADO"), rs.getString("FEDERADO_NOMBRE"), rs.getString("FEDERADO_APELLIDO1"), rs.getString("FEDERADO_APELLIDO2"), rs.getString("FEDERADO_DNI"), rs.getDate("FEDERADO_FECHANAC"), rs.getString("FEDERADO_SEXO"), rs.getString("FEDERADO_NACIONALIDAD"), rs.getBoolean("FEDERADO_RESIDENTE"), rs.getBoolean("FEDERADO_TUTOR"),rs.getString("FEDERADO_TUTOR_TIPO"), rs.getString("FEDERADO_TUTOR_NOMBRE"), rs.getString("FEDERADO_TUTOR_APELLIDO1"), rs.getString("FEDERADO_TUTOR_APELLIDO2"), rs.getString("FEDERADO_TUTOR_DNI"), rs.getBoolean("FEDERADO_HANDICAP"), rs.getDouble("FEDERADO_NUMHANDICAP"), rs.getString("FEDERADO_FORMAPAGO"), rs.getString("FEDERADO_NUMCUENTA"), rs.getBoolean("FEDERADO_NOTA1"), rs.getBoolean("FEDERADO_NOTA2"), rs.getBoolean("FEDERADO_NOTA3"), rs.getInt("FEDERADO_ENTIDAD_ID"), rs.getInt("FEDERADO_ESTADO_LICENCIA"), rs.getInt("FEDERADO_ESTADO_ECONOMICO"), rs.getDate("FEDERADO_FECHA_PRE_ALTA"), rs.getDate("FEDERADO_FECHA_ALTA"), rs.getDate("FEDERADO_FECHA_BAJA"), rs.getInt("FEDERADO_RAZON_BAJA"), rs.getBoolean("FEDERADO_HOMOLOGADO"), rs.getString("FEDERADO_TUTOR_NUMFEDERADO"));
                listaFederado.add(unFederado);
            }
       }
        catch(SQLException ex)
        {
            listaFederado = null;
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
            return listaFederado;
        }
    }



    public boolean insertarFederado(String pNumFederado, String pNombre, String pApellido1, String pApellido2, String pDNI, Date pFechaNac, String pSexo, String pNacionalidad, boolean pResidente, boolean pTutor, String pTutorTipo, String pTutorNombre, String pTutorApellido1, String pTutorApellido2, String pTutorDNI, boolean pHandicap, double pNumHandicap, String pFormaPago, String pNumCuenta, boolean pNota1, boolean pNota2, boolean pNota3, int pIdEntidad, int pEstadoEconomico, int pEstadoLicencia, Date pFechaPreAlta, Date pFechaAlta, Date pFechaBaja, int pRazonBaja, boolean pHomologado, String pTutorNumFederado)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();

        String strFechaAlta;
        if(pFechaAlta != null)
        {
            strFechaAlta = "'" + String.valueOf(pFechaAlta) + "'";
        }
        else
        {
            strFechaAlta = null;
        }

        String strFechaBaja;
        if(pFechaBaja != null)
        {
            strFechaBaja = "'" + String.valueOf(pFechaBaja) + "'";
        }
        else
        {
            strFechaBaja = null;
        }

        String consulta= "INSERT INTO FEDERADO(FEDERADO_NUMFEDERADO, FEDERADO_NOMBRE, FEDERADO_APELLIDO1, FEDERADO_APELLIDO2, FEDERADO_DNI, FEDERADO_FECHANAC, FEDERADO_SEXO, FEDERADO_NACIONALIDAD, FEDERADO_RESIDENTE, FEDERADO_TUTOR, FEDERADO_TUTOR_TIPO, FEDERADO_TUTOR_NOMBRE, FEDERADO_TUTOR_APELLIDO1, FEDERADO_TUTOR_APELLIDO2, FEDERADO_TUTOR_DNI, FEDERADO_HANDICAP, FEDERADO_NUMHANDICAP, FEDERADO_FORMAPAGO, FEDERADO_NUMCUENTA, FEDERADO_NOTA1, FEDERADO_NOTA2, FEDERADO_NOTA3, FEDERADO_ENTIDAD_ID, FEDERADO_ESTADO_LICENCIA, FEDERADO_ESTADO_ECONOMICO, FEDERADO_FECHA_PRE_ALTA, FEDERADO_FECHA_ALTA, FEDERADO_FECHA_BAJA, FEDERADO_RAZON_BAJA, FEDERADO_HOMOLOGADO, FEDERADO_TUTOR_NUMFEDERADO) VALUES ('" + pNumFederado + "','" + pNombre + "','" + pApellido1 + "','" + pApellido2 +  "','" + pDNI + "','" + pFechaNac + "','" + pSexo + "','" + pNacionalidad + "'," + pResidente + "," + pTutor + ",'" + pTutorTipo + "','" + pTutorNombre + "','" + pTutorApellido1 + "','" + pTutorApellido2 + "','" + pTutorDNI + "'," + pHandicap + "," + pNumHandicap + ",'" + pFormaPago + "','" + pNumCuenta + "'," + pNota1 + "," + pNota2 + "," + pNota3 + "," + pIdEntidad + "," + pEstadoEconomico + "," + pEstadoLicencia + ",'" + pFechaPreAlta + "'," + strFechaAlta + "," + strFechaBaja + "," + pRazonBaja + "," + pHomologado + ",'" + pTutorNumFederado + "')";
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

    public boolean modificarFederado(int pIdFederado, String pNumFederado, String pNombre, String pApellido1, String pApellido2, String pDNI, Date pFechaNac, String pSexo, String pNacionalidad, boolean pResidente, boolean pTutor, String pTutorTipo, String pTutorNombre, String pTutorApellido1, String pTutorApellido2, String pTutorDNI, boolean pHandicap, double pNumHandicap, String pFormaPago, String pNumCuenta, boolean pNota1, boolean pNota2, boolean pNota3, int pIdEntidad, int pEstadoEconomico, int pEstadoLicencia, Date pFechaPreAlta, Date pFechaAlta, Date pFechaBaja, int pRazonBaja, boolean pHomologado, String pTutorNumFederado)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE FEDERADO SET FEDERADO_NUMFEDERADO='" + pNumFederado + "', FEDERADO_NOMBRE = '" + pNombre + "', FEDERADO_APELLIDO1='" + pApellido1 + "', FEDERADO_APELLIDO2='" + pApellido2 + "', FEDERADO_DNI='" + pDNI + "', FEDERADO_FECHANAC='" + pFechaNac + "', FEDERADO_SEXO='" + pSexo + "', FEDERADO_NACIONALIDAD='" + pNacionalidad + "', FEDERADO_RESIDENTE=" + pResidente + ", FEDERADO_TUTOR=" + pTutor + ", FEDERADO_TUTOR_TIPO='" + pTutorTipo + "', FEDERADO_TUTOR_NOMBRE='" + pTutorNombre + "', FEDERADO_TUTOR_APELLIDO1='" + pTutorApellido1 + "', FEDERADO_TUTOR_APELLIDO2='" + pTutorApellido2 + "', FEDERADO_TUTOR_DNI='" + pTutorDNI + "', FEDERADO_HANDICAP=" + pHandicap + ", FEDERADO_NUMHANDICAP=" + pNumHandicap + ", FEDERADO_FORMAPAGO='" + pFormaPago + "', FEDERADO_NUMCUENTA='" + pNumCuenta + "', FEDERADO_NOTA1=" + pNota1 + ", FEDERADO_NOTA2=" + pNota2 + ", FEDERADO_NOTA3=" + pNota3 + ", FEDERADO_ENTIDAD_ID=" + pIdEntidad + ", FEDERADO_ESTADO_ECONOMICO=" + pEstadoEconomico + ", FEDERADO_ESTADO_LICENCIA=" + pEstadoLicencia + ", FEDERADO_FECHA_PRE_ALTA='" + pFechaPreAlta + "', FEDERADO_FECHA_ALTA='" + pFechaAlta + "', FEDERADO_FECHA_BAJA='" + pFechaBaja + "', FEDERADO_RAZON_BAJA=" + pRazonBaja + ", FEDERADO_HOMOLOGADO=" + pHomologado + ", FEDERADO_TUTOR_NUMFEDERADO='" + pTutorNumFederado + "' WHERE FEDERADO_ID=" + pIdFederado;
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

    public boolean darDeBaja(int pIdFederado, Date pFechaBaja, int pRazonBaja)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE FEDERADO SET FEDERADO_FECHA_BAJA='" + pFechaBaja + "', FEDERADO_RAZON_BAJA=" + pRazonBaja + " WHERE FEDERADO_ID=" + pIdFederado;
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

    public boolean eliminarFederado(int pIdFederado)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM FEDERADO WHERE FEDERADO_ID=" + pIdFederado;
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
