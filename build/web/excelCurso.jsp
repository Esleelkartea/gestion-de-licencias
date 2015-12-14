<%-- 
    Document   : excelCurso
    Created on : 14-nov-2011, 17:19:40
    Author     : Julen
--%>

<%@page import="com.Negocio.DEResponsable"%>
<%@page import="com.Negocio.DECurso"%>
<%@page import="com.Negocio.DEEntidad"%>
<%@page import="com.Negocio.DEAlumno"%>
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

    <%

         String strTemporada = (String)session.getAttribute("temporada");
         DEEntidad unDEEntidad = (DEEntidad)session.getAttribute("unaDEEntidad");
         DECurso unDECurso = (DECurso)session.getAttribute("unDECurso");
         String strFechaInicio = (String)session.getAttribute("fechaInicio");
         String strFechaFin = (String)session.getAttribute("fechaFin");
         DEResponsable unDEResponsable = (DEResponsable)session.getAttribute("unDEResponsable");


    %>



<TABLE>
    <tr></tr>
    <tr>
        <td></td>
        <td style="color: red; font-size: 16pt"  >Curso Asignado</td>
    </tr>
    <tr></tr>
    <tr>
        <td>Actividad</td>
        <td></td>
        <td></td>
        <td></td>
        <td>Responsable</td>
        <td></td>
    </tr>
    <tr>
        <td>Temporada</td>
        <td><%=strTemporada%></td>
        <td></td>
        <td></td>
        <td>DNI</td>
        <td><%=unDEResponsable.getDni()%></td>
    </tr>
    <tr>
        <td>Entidad</td>
        <td><%=unDEEntidad.getEntidad()%></td>
        <td></td>
        <td></td>
        <td>Nombre</td>
        <td><%=unDEResponsable.getNombre()%></td>
    </tr>
     <tr>
        <td>Num. Entidad</td>
        <td><%=unDEEntidad.getIdDEEntidad()%></td>
        <td></td>
        <td></td>
        <td>Apellidos</td>
        <td><%=unDEResponsable.getApellidos()%></td>
    </tr>
    <tr>
        <td>Fecha Inicio</td>
        <td><%=strFechaInicio%></td>
        <td></td>
        <td></td>
        <td>Fecha Nacimiento</td>
        <td><%=unDEResponsable.getFechaNac()%></td>
    </tr>
    <tr>
        <td>Fecha Fin</td>
        <td><%=strFechaFin%></td>
        <td></td>
        <td></td>
        <td>Direccion</td>
        <td><%=unDEResponsable.getDireccion()%></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>Poblacion</td>
        <td><%=unDEResponsable.getPoblacion()%></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>CP</td>
        <td><%=unDEResponsable.getCp()%></td>
    </tr>
    
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>Telefono Fijo</td>
        <td><%=unDEResponsable.getFijo()%></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>Telefono Movil</td>
        <td><%=unDEResponsable.getMovil()%></td>
    </tr>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>Email</td>
        <td><%=unDEResponsable.getEmail()%></td>
    </tr>
<tr></tr>
<tr></tr>

<tr></tr>
<TR>
<td></td>
<th>Nombre</th>
<th>Apellidos</th>
<th>Curso</th>
<th>Fecha Nacimiento</th>
<th>Nombre Tutor</th>
<th>Apellidos Tutor</th>
<th>Telefono Fijo</th>
<th>Telefono Movil</th>
<th>Email</th>
</TR>

         <%
            ArrayList<DEAlumno> listaDEAlumno = (ArrayList<DEAlumno>)session.getAttribute("listaDEAlumno");
            if (listaDEAlumno != null)
            {
                String strFecha = "";
                for (int i = 0; i<listaDEAlumno.size(); i++)
                {
                   strFecha = String.valueOf(listaDEAlumno.get(i).getFechaNac());
                   String arrFecha[] = strFecha.split("-");
                   strFecha = arrFecha[2] + "-" + arrFecha[1] + "-" + arrFecha[0];
        %>


<TR>
    <td></td>
    
   <td><%=listaDEAlumno.get(i).getNombre()%></td>
   <td><%=listaDEAlumno.get(i).getApellidos()%></td>
   <td><%=listaDEAlumno.get(i).getCurso()%></td>
   <td align="center"><%=strFecha%></td>
   <td><%=listaDEAlumno.get(i).getNombreTutor()%></td>
   <td><%=listaDEAlumno.get(i).getApellidosTutor()%></td>
   <td><%=listaDEAlumno.get(i).getFijo()%></td>
   <td><%=listaDEAlumno.get(i).getMovil()%></td>
   <td><%=listaDEAlumno.get(i).getEmail()%></td>

</TR>


        <%
            }
          }
       %>


</TABLE>

</body>

</html>


