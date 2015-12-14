/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.DEAlumno;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Julen
 */
public class DEAlumnoDAL {

    Conexion conexion;

    public DEAlumnoDAL()
    {

    }


    public DEAlumno getDEAlumno(int pIdDEAlumno)
    {
        conexion = new Conexion();
        DEAlumno unDEAlumno = null;
        String consulta= "SELECT * FROM DE_ALUMNO WHERE DE_ALUMNO_ID = " + pIdDEAlumno;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
                 unDEAlumno = new DEAlumno(rs.getInt("DE_ALUMNO_ID"), rs.getString("DE_ALUMNO_NOMBRE"), rs.getString("DE_ALUMNO_APELLIDOS"), rs.getDate("DE_ALUMNO_FECHANAC"), rs.getString("DE_ALUMNO_CURSO"), rs.getString("DE_ALUMNO_TUTOR_NOMBRE"), rs.getString("DE_ALUMNO_TUTOR_APELLIDOS"), rs.getString("DE_ALUMNO_TELEFONO_FIJO"), rs.getString("DE_ALUMNO_TELEFONO_MOVIL"), rs.getString("DE_ALUMNO_EMAIL"));
        }
        catch(Exception e)
        {
            unDEAlumno = null;
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
            return unDEAlumno;
        }
     }

    public int ultimoAlumno()
    {
        int ultimo = 0;
         conexion = new Conexion();
         String consulta= "SELECT MAX(DE_ALUMNO_ID) AS MAXIMO FROM DE_ALUMNO";
         ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
             {
                 ultimo = rs.getInt("MAXIMO");
             }
        }
        catch(Exception e)
        {
            ultimo = 0;
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
            return ultimo;
        }
    }


    public ArrayList<DEAlumno> getDEAlumno(int pIdDEAlumno, String pNombre, String pApellidos, Date pFechaNac, String pCurso, String pNombreTutor, String pApellidosTutor, String pFijo, String pMovil, String pEmail)
    {
        conexion = new Conexion();
        ArrayList<DEAlumno> listaDEAlumno = new ArrayList<DEAlumno>();
        DEAlumno unDEAlumno = null;
        String consulta= "SELECT * FROM DE_ALUMNO ";
        ResultSet rs = null;
        boolean bConsul = false;

        try
        {
             if (pIdDEAlumno != -1){
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_ID = " + pIdDEAlumno;
                     bConsul=true;
                 }
            }

            if (pNombre != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_NOMBRE = '" + pNombre + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ALUMNO_NOMBRE = '" + pNombre + "'";
             }

             if (pApellidos != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_APELLIDOS = '" + pApellidos + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ALUMNO_APELLIDOS = '" + pApellidos + "'";
             }

             if (pFechaNac != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_FECHANAC = '" + pFechaNac + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND DE_ALUMNO_FECHANAC = '" + pFechaNac + "'";
             }

             if (pCurso != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_CURSO = '" + pCurso + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_ALUMNO_CURSO= '" + pCurso + "'";
             }

             if (pNombreTutor != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_TUTOR_NOMBRE = '" + pNombreTutor + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_ALUMNO_TUTOR_NOMBRE = '" + pNombreTutor + "'";
             }

             if (pApellidosTutor != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_TUTOR_APELLIDOS = '" + pApellidosTutor + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_ALUMNO_TUTOR_APELLIDOS = '" + pApellidosTutor + "'";
             }

             if (pFijo != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_TELEFONO_FIJO = '" + pFijo + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_ALUMNO_TELEFONO_FIJO = '" + pFijo + "'";
             }

             if (pMovil != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_TELEFONO_MOVIL = '" + pMovil + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_ALUMNO_TELEFONO_MOVIL = '" + pMovil + "'";
             }

             if (pEmail != null)
             {
                 if (bConsul==false)
                 {
                     consulta += "WHERE DE_ALUMNO_EMAIL = '" + pEmail + "'";
                     bConsul=true;
                 }
                 else
                     consulta += " AND  DE_ALUMNO_EMAIL = '" + pEmail + "'";
             }

             

            rs = conexion.getStatement().executeQuery(consulta);
            while(rs.next())
            {
                unDEAlumno = new DEAlumno(rs.getInt("DE_ALUMNO_ID"), rs.getString("DE_ALUMNO_NOMBRE"), rs.getString("DE_ALUMNO_APELLIDOS"), rs.getDate("DE_ALUMNO_FECHANAC"), rs.getString("DE_ALUMNO_CURSO"), rs.getString("DE_ALUMNO_TUTOR_NOMBRE"), rs.getString("DE_ALUMNO_TUTOR_APELLIDOS"), rs.getString("DE_ALUMNO_TELEFONO_FIJO"), rs.getString("DE_ALUMNO_TELEFONO_MOVIL"), rs.getString("DE_ALUMNO_EMAIL"));
                listaDEAlumno.add(unDEAlumno);
            }
       }
        catch(SQLException ex)
        {
            listaDEAlumno = null;
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
            return listaDEAlumno;
        }
    }

    public boolean insertarDEAlumno(String pNombre, String pApellidos, Date pFechaNac, String pCurso, String pNombreTutor, String pApellidosTutor, String pFijo, String pMovil, String pEmail)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "INSERT INTO DE_ALUMNO (DE_ALUMNO_NOMBRE, DE_ALUMNO_APELLIDOS, DE_ALUMNO_FECHANAC, DE_ALUMNO_CURSO, DE_ALUMNO_TUTOR_NOMBRE, DE_ALUMNO_TUTOR_APELLIDOS, DE_ALUMNO_TELEFONO_FIJO, DE_ALUMNO_TELEFONO_MOVIL, DE_ALUMNO_EMAIL) VALUES ('" + pNombre + "','" + pApellidos + "','" + pFechaNac + "','" + pCurso + "','" + pNombreTutor + "','" + pApellidosTutor + "','" + pFijo + "','" + pMovil + "','" + pEmail + "')";
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

    public boolean modificarDEAlumno(int pIdDEAlumno, String pNombre, String pApellidos, Date pFechaNac, String pCurso, String pNombreTutor, String pApellidosTutor, String pFijo, String pMovil, String pEmail)
    {
        boolean exito = true;
        int numFilas;
        conexion = new Conexion();
        String consulta= "UPDATE DE_ALUMNO SET DE_ALUMNO_NOMBRE = '" + pNombre + "' DE_ALUMNO_APELLIDOS='" + pApellidos + "' DE_ALUMNO_FECHANAC='" + pFechaNac + "' DE_ALUMNO_CURSO='" + pCurso + "' DE_ALUMNO_TUTOR_NOMBRE='" + pNombreTutor + "' DE_ALUMNO_TUTOR_APELLIDOS='" + pApellidosTutor + "' DE_ALUMNO_TELEFONO_FIJO='" + pFijo + "' DE_ALUMNO_TELEFONO_MOVIL='" + pMovil + "' DE_ALUMNO_EMAIL='" + pEmail + "' WHERE DE_ALUMNO_ID=" + pIdDEAlumno;
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

    public boolean eliminarDEAlumno(int pIdDEAlumno)
    {
        boolean exito = true;
        int numFilas;
        conexion= new Conexion();
        String consulta="DELETE FROM DE_ALUMNO WHERE DE_ALUMNO_ID=" + pIdDEAlumno;
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
