<%--
    Document   : excelLicencia
    Created on : 14-nov-2011, 17:19:40
    Author     : Julen
--%>

<%@page import="com.Negocio.FederadoConsulta"%>
<%@page import="com.Negocio.DEResponsable"%>
<%@page import="com.Negocio.Federado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%

    response.setContentType ("application/vnd.ms-excel"); //Tipo de fichero.

response.setHeader ("Content-Disposition", "attachment;filename=\"consulta.xls\"");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Consulta</title>

</head>

<body>




<TABLE>
    <tr></tr>
    <tr>
        <td></td>
        <td style="color: red; font-size: 16pt"  >Busqueda Realizada</td>
    </tr>
    <tr></tr>

<tr></tr>
<tr>
    <td></td>
    <td>Consultas</td>
</tr>

<tr></tr>
<TR>
<td></td>
<th>Num. Federado</th>
<th>Nombre</th>
<th>Primer Apellido</th>
<th>Segundo Apellido</th>
<th>DNI</th>
<th>Fecha</th>
<th>Consulta</th>
<th>Observaciones</th>
</TR>

         <%
            ArrayList<FederadoConsulta> listaFederadoConsulta = (ArrayList<FederadoConsulta>)session.getAttribute("listaFederadoConsulta");
            if (listaFederadoConsulta != null)
            {
                String strFecha = "";
                for (int i = 0; i<listaFederadoConsulta.size(); i++)
                {
                   strFecha = String.valueOf(listaFederadoConsulta.get(i).getFechaConsulta());
                   String arrFecha[] = strFecha.split("-");
                   strFecha = arrFecha[2] + "-" + arrFecha[1] + "-" + arrFecha[0];
        %>


<TR>
    <td></td>

   <td><%=listaFederadoConsulta.get(i).getFederado().getNumFederado()%></td>
   <td><%=listaFederadoConsulta.get(i).getFederado().getNombre()%></td>
   <td><%=listaFederadoConsulta.get(i).getFederado().getApellido1()%></td>
   <td><%=listaFederadoConsulta.get(i).getFederado().getApellido2()%></td>
   <td><%=listaFederadoConsulta.get(i).getFederado().getDni()%></td>
   <td align="center"><%=strFecha%></td>
   <td><%=listaFederadoConsulta.get(i).getConsulta().getConsulta()%></td>
   <td><%=listaFederadoConsulta.get(i).getObservaciones()%></td>

</TR>


        <%
            }
          }
       %>


</TABLE>

</body>

</html>


