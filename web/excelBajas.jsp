<%-- 
    Document   : excelCurso
    Created on : 14-nov-2011, 17:19:40
    Author     : Julen
--%>


<%@page import="com.dal.TipoBajaDAL"%>
<%@page import="com.Negocio.TipoBaja"%>
<%@page import="com.Negocio.Federado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%

    response.setContentType ("application/vnd.ms-excel"); //Tipo de fichero.

response.setHeader ("Content-Disposition", "attachment;filename=\"bajasFederados.xls\"");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Curso Asignado</title>

</head>

<body>

    <%
         ArrayList<Federado> listaFederados = (ArrayList<Federado>)request.getSession().getAttribute("listaFederado");
    %>

<TABLE>
    <tr></tr>
    <tr>
        <td></td>
        <td style="color: red; font-size: 16pt"  >Bajas de Federados</td>
    </tr>
    <tr></tr>
    


<tr></tr>
<TR>
<td></td>
<th>Num. Federado</th>
<th>Nombre</th>
<th>Primer Apellido</th>
<th>Segundo Apellido</th>
<th>DNI</th>
<th>Fecha Baja</th>
<th>Razon Baja</th>
</TR>

         <%
            if (listaFederados != null)
            {
                String strFecha = "";
                TipoBaja unTipoBaja = null;
                TipoBajaDAL tipoBajaDAL = new TipoBajaDAL();
                for (int i = 0; i<listaFederados.size(); i++)
                {
                   strFecha = String.valueOf(listaFederados.get(i).getFechaBaja());
                   String arrFecha[] = strFecha.split("-");
                   strFecha = arrFecha[2] + "-" + arrFecha[1] + "-" + arrFecha[0];

                   unTipoBaja = tipoBajaDAL.getTipoBaja(listaFederados.get(i).getRazonBaja());
        %>


<TR>
    <td></td>
   <td><%=listaFederados.get(i).getNumFederado()%></td>
   <td><%=listaFederados.get(i).getNombre()%></td>
   <td><%=listaFederados.get(i).getApellido1()%></td>
   <td><%=listaFederados.get(i).getApellido2()%></td>
   <td><%=listaFederados.get(i).getDni()%></td>
   <td align="center"><%=strFecha%></td>
   <td><%=unTipoBaja.getRazon()%></td>
</TR>


        <%
            }
          }
       %>


</TABLE>

</body>

</html>


