<%--
    Document   : excelLicencia
    Created on : 14-nov-2011, 17:19:40
    Author     : Julen
--%>

<%@page import="com.Negocio.DEResponsable"%>
<%@page import="com.Negocio.Federado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%

    response.setContentType ("application/vnd.ms-excel"); //Tipo de fichero.

response.setHeader ("Content-Disposition", "attachment;filename=\"curso.xls\"");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Curso Asignado</title>

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
<tr></tr>

<tr></tr>
<TR>
<td></td>
<th>Numero Federacion</th>
<th>Nombre</th>
<th>Primer Apellido</th>
<th>Segundo Apellido</th>
<th>DNI</th>
<th>Fecha Nacimiento</th>
<th>Direccion</th>
<th>Poblacion</th>
<th>CP</th>
<th>Provincia</th>
<th>Sexo</th>
<th>Nacionalidad</th>
<th>Email</th>
<th>Telefono</th>
<th>Forma de Pago</th>
<th>Num de Cuenta</th>
</TR>

         <%
            ArrayList<Federado> listaFederado = (ArrayList<Federado>)session.getAttribute("listaFederado");
            if (listaFederado != null)
            {
                String strFecha = "";
                for (int i = 0; i<listaFederado.size(); i++)
                {
                   strFecha = String.valueOf(listaFederado.get(i).getFechaNac());
                   String arrFecha[] = strFecha.split("-");
                   strFecha = arrFecha[2] + "-" + arrFecha[1] + "-" + arrFecha[0];
        %>


<TR>
    <td></td>

   <td><%=listaFederado.get(i).getNumFederado()%></td>
   <td><%=listaFederado.get(i).getNombre()%></td>
   <td><%=listaFederado.get(i).getApellido1()%></td>
   <td><%=listaFederado.get(i).getApellido2()%></td>
   <td><%=listaFederado.get(i).getDni()%></td>
   <td align="center"><%=strFecha%></td>
   <td><%=listaFederado.get(i).getDireccion()%></td>
   <td><%=listaFederado.get(i).getPoblacion()%></td>
   <td><%=listaFederado.get(i).getCp()%></td>
   <td><%=listaFederado.get(i).getProvincia()%></td>
   <td><%=listaFederado.get(i).getSexo()%></td>
   <td><%=listaFederado.get(i).getNacionalidad()%></td>
   <td><%=listaFederado.get(i).getEmail()%></td>
   <td><%=listaFederado.get(i).getTelefono()%></td>
   <td><%=listaFederado.get(i).getFormaPago()%></td>
   <td><%=listaFederado.get(i).getNumCuenta()%></td>

</TR>


        <%
            }
          }
       %>


</TABLE>

</body>

</html>


