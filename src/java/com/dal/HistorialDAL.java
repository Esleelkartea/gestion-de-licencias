/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dal;

import com.Negocio.Historial;
import com.Negocio.TipoCanal;
import com.Negocio.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Julen
 */
public class HistorialDAL {

    Conexion conexion;

    public HistorialDAL()
    {
        
    }

    public Historial getHistorial(int pIdHistorial)
    {
        conexion = new Conexion();
        Historial unHistorial = null;
        Usuario unUsuario = null;
        UsuarioDAL usuarioDAL = new UsuarioDAL();
        TipoCanal unTipoCanal = null;
        TipoCanalDAL tipoCanalDAL = new TipoCanalDAL();
        String consulta= "SELECT * FROM HISTORIAL WHERE HISTORIAL_ID = " + pIdHistorial;
        ResultSet rs = null;
        try
        {
             rs = conexion.getStatement().executeQuery(consulta);
             if(rs.next())
             {
                // unHistorial = new Historial(rs.getInt("HISTORIAL_ID"), rs.getString("HISTORIAL_CAMPO"), rs.getString("HISTORIAL_VALOR_ANTIGUO"), rs.getString("HISTORIAL_VALOR_NUEVO"), rs.getDate("HISTORIAL_FECHA"),);
             }
        }
        catch(Exception e)
        {
            unHistorial = null;
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
            return unHistorial;
        }
     }

}
