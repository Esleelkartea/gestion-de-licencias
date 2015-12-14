/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.DEResponsable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class DEResponsableDAL {

    Conexion conexion;

    public DEResponsableDAL()
    {

    }


    public DEResponsable getDEResponsable(int pIdDEResponsable)
    {
        conexion = new Conexion();
        DEResponsable unDEResponsable = null;
        String consulta= "SELECT * FROM DE_RESPONSABLE WHERE DE_RESPONSABLE_ID = " + pIdDEResponsable;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unDEResponsable = new DEResponsable(rs.getInt("DE_RESPONSABLE_ID"), rs.getString("DE_RESPONSABLE_DNI"), rs.getString("DE_RESPONSABLE_NOMBRE"), rs.getString("DE_RESPONSABLE_APELLIDOS"), rs.getDate("DE_RESPONSABLE_FECHANAC"), rs.getString("DE_RESPONSABLE_DIRECCION"), rs.getString("DE_RESPONSABLE_POBLACION"), rs.getString("DE_RESPONSABLE_CP"), rs.getString("DE_RESPONSABLE_PROVINCIA"), rs.getString("DE_RESPONSABLE_FIJO"), rs.getString("DE_RESPONSABLE_MOVIL"), rs.getString("DE_RESPONSABLE_EMAIL"));
        }
        catch(Exception e)
        {
            unDEResponsable = null;
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
            return unDEResponsable;
        }
     }

    public DEResponsable getDEResponsable(String pDNI)
    {
        conexion = new Conexion();
        DEResponsable unDEResponsable = null;
        String consulta= "SELECT * FROM DE_RESPONSABLE WHERE DE_RESPONSABLE_DNI = '" + pDNI + "'";
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unDEResponsable = new DEResponsable(rs.getInt("DE_RESPONSABLE_ID"), rs.getString("DE_RESPONSABLE_DNI"), rs.getString("DE_RESPONSABLE_NOMBRE"), rs.getString("DE_RESPONSABLE_APELLIDOS"), rs.getDate("DE_RESPONSABLE_FECHANAC"), rs.getString("DE_RESPONSABLE_DIRECCION"), rs.getString("DE_RESPONSABLE_POBLACION"), rs.getString("DE_RESPONSABLE_CP"), rs.getString("DE_RESPONSABLE_PROVINCIA"), rs.getString("DE_RESPONSABLE_FIJO"), rs.getString("DE_RESPONSABLE_MOVIL"), rs.getString("DE_RESPONSABLE_EMAIL"));
        }
        catch(Exception e)
        {
            unDEResponsable = null;
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
            return unDEResponsable;
        }
     }


    public DEResponsable getDEResponsable(String pNombre, String pApellidos, String pDNI)
    {
        conexion = new Conexion();
        DEResponsable unDEResponsable = null;
        String consulta= "SELECT * FROM DE_RESPONSABLE WHERE DE_RESPONSABLE_DNI = '" + pDNI + "' AND DE_RESPONSABLE_NOMBRE='" + pNombre + "' AND DE_RESPONSABLE_APELLIDOS='" + pApellidos + "'";
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unDEResponsable = new DEResponsable(rs.getInt("DE_RESPONSABLE_ID"), rs.getString("DE_RESPONSABLE_DNI"), rs.getString("DE_RESPONSABLE_NOMBRE"), rs.getString("DE_RESPONSABLE_APELLIDOS"), rs.getDate("DE_RESPONSABLE_FECHANAC"), rs.getString("DE_RESPONSABLE_DIRECCION"), rs.getString("DE_RESPONSABLE_POBLACION"), rs.getString("DE_RESPONSABLE_CP"), rs.getString("DE_RESPONSABLE_PROVINCIA"), rs.getString("DE_RESPONSABLE_FIJO"), rs.getString("DE_RESPONSABLE_MOVIL"), rs.getString("DE_RESPONSABLE_EMAIL"));
        }
        catch(Exception e)
        {
            unDEResponsable = null;
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
            return unDEResponsable;
        }
     }


    public ArrayList<DEResponsable> getDEResponsable(int pIdDEResponsable, String pDNI, String pNombre, String pApellidos, Date pFechaNac, String pDireccion, String pPoblacion, String pCP, String pProvincia, String pFijo, String pMovil, String pEmail)
    {
        conexion = new Conexion();
        ArrayList<DEResponsable> listaDEResponsable = new ArrayList<DEResponsable>();
        DEResponsable unDEResponsable = null;
        String consulta= "SELECT * FROM DE_RESPONSABLE ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdDEResponsable != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_ID = " + pIdDEResponsable;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_RESPONSABLE_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_RESPONSABLE_NOMBRE = '" + pNombre + "'";
             }

             if (pApellidos != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_RESPONSABLE_APELLIDOS = '" + pApellidos + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ALUMNO_APELLIDOS = '" + pApellidos + "'";
             }

             if (pFechaNac != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_RESPONSABLE_FECHANAC = '" + pFechaNac + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_RESPONSABLE_FECHANAC = '" + pFechaNac + "'";
             }

             if (pDNI != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_RESPONSABLE_DNI = '" + pDNI + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_RESPONSABLE_DNI= '" + pDNI + "'";
             }

             if (pDireccion != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_RESPONSABLE_DIRECCION = '" + pDireccion + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_RESPONSABLE_DIRECCION = '" + pDireccion + "'";
             }

             if (pPoblacion != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_RESPONSABLE_POBLACION = '" + pPoblacion + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_RESPONSABLE_POBLACION = '" + pPoblacion + "'";
             }

             if (pCP != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_RESPONSABLE_CP = '" + pCP + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_RESPONSABLE_CP = '" + pCP + "'";
             }

             if (pProvincia != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_RESPONSABLE_PROVINCIA = '" + pProvincia + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_RESPONSABLE_PROVINCIA = '" + pProvincia + "'";
             }

             if (pFijo != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_RESPONSABLE_FIJO = '" + pFijo + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_RESPONSABLE_FIJO = '" + pFijo + "'";
             }

             if (pMovil != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_RESPONSABLE_MOVIL = '" + pMovil + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_RESPONSABLE_MOVIL = '" + pMovil + "'";
             }

             if (pEmail != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_RESPONSABLE_EMAIL = '" + pEmail + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_RESPONSABLE_EMAIL = '" + pEmail + "'";
             }



            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unDEResponsable = new DEResponsable(rs.getInt("DE_RESPONSABLE_ID"), rs.getString("DE_RESPONSABLE_DNI"), rs.getString("DE_RESPONSABLE_NOMBRE"), rs.getString("DE_RESPONSABLE_APELLIDOS"), rs.getDate("DE_RESPONSABLE_FECHANAC"), rs.getString("DE_RESPONSABLE_DIRECCION"), rs.getString("DE_RESPONSABLE_POBLACION"), rs.getString("DE_RESPONSABLE_CP"), rs.getString("DE_RESPONSABLE_PROVINCIA"), rs.getString("DE_RESPONSABLE_FIJO"), rs.getString("DE_RESPONSABLE_MOVIL"), rs.getString("DE_RESPONSABLE_EMAIL"));
                listaDEResponsable.add(unDEResponsable);
            }
       }
        catch(SQLException ex)
        {
            listaDEResponsable = null;
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
            return listaDEResponsable;
        }
    }

    public boolean insertarIDResponsable(String pDNI, String pNombre, String pApellidos, String pDireccion, String pPoblacion, String pCP, String pProvincia, String pFijo, String pMovil, String pEmail, Date pFechaNac)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO DE_RESPONSABLE(DE_RESPONSABLE_DNI, DE_RESPONSABLE_NOMBRE, DE_RESPONSABLE_APELLIDOS, DE_RESPONSABLE_DIRECCION, DE_RESPONSABLE_POBLACION, DE_RESPONSABLE_CP, DE_RESPONSABLE_PROVINCIA, DE_RESPONSABLE_FIJO, DE_RESPONSABLE_MOVIL, DE_RESPONSABLE_EMAIL, DE_RESPONSABLE_FECHANAC) VALUES ('" + pDNI + "','" + pNombre + "','" + pApellidos + "','" + pDireccion + "','" + pPoblacion + "','" + pCP + "','" + pProvincia + "','" + pFijo + "','" + pMovil + "','" + pEmail + "','" + pFechaNac + "')";
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


    public boolean modificarDEResponsable(int pIdDEResponsable, String pDNI, String pNombre, String pApellidos, Date pFechaNac, String pDireccion, String pPoblacion, String pCP, String pProvincia, String pFijo, String pMovil, String pEmail)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE DE_RESPONSABLE SET DE_RESPONSABLE_NOMBRE = '" + pNombre + "' DE_RESPONSABLE_APELLIDOS='" + pApellidos + "' DE_RESPONSABLE_FECHANAC='" + pFechaNac + "' DE_RESPONSABLE_DNI='" + pDNI + "' DE_RESPONSABLE_DIRECCION='" + pDireccion + "' DE_RESPONSABLE_POBLACION='" + pPoblacion + "' DE_RESPONSABLE_CP='" + pCP + "' DE_RESPONSABLE_PROVINCIA='" + pProvincia + "' DE_RESPONSABLE_FIJO='" + pFijo + "' DE_RESPONSABLE_MOVIL='" + pMovil + "' DE_RESPONSABLE_EMAIL='" + pEmail + "' WHERE DE_RESPONSABLE_ID=" + pIdDEResponsable;
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

    public boolean eliminarDEResponsable(int pIdDEResponsable)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM DE_RESPONSABLE WHERE DE_RESPONSABLE_ID=" + pIdDEResponsable;
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
