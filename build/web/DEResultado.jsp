<%-- 
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>

<%@page import="com.dal.DEAlumnoDAL"%>
<%@page import="com.dal.DEResponsableDAL"%>
<%@page import="com.Negocio.DEActividad"%>
<%@page import="com.Negocio.Federado"%>
<%@page import="com.Negocio.DEAlumno"%>
<%@page import="com.Negocio.DEResponsable"%>
<%@page import="com.Negocio.DEEntidad"%>
<%@page import="com.Negocio.DECurso"%>
<%@page import="com.Negocio.Colectivo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Federaci&oacute;n de Golf de Vizcaya</title>

<link rel="stylesheet" type="text/css" media="all" href="jscalendar/calendar-blue2.css" title="blue2" />
<!-- main calendar program -->
<script type="text/javascript" src="jscalendar/calendar.js"></script>
<!-- language for the calendar -->
<script type="text/javascript" src="jscalendar/lang/calendar-es.js"></script>
<!-- the following script defines the Calendar.setup helper function, which makes
       adding a calendar a matter of 1 or 2 lines of code. -->
<script type="text/javascript" src="jscalendar/calendar-setup.js"></script>


<link href="estilos/estilos.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="jquery.js"></script>
 <script type="text/javascript">
    $(document).ready(function() {
        if($('#menorcheckbox').is(':checked')){
            $('div.menor').show();

        }else{
            $('div.menor').hide();

        }

	$(".msg_body").hide();
	$(".msg_head").click(function(){
		$(this).next(".msg_body").slideToggle(350);
	});

	$(".msg_body_gris").hide();
	$(".msg_head_gris").click(function(){
		$(this).next(".msg_body_gris").slideToggle(350);
	});

    });

    $(document).ready(function() {
        if($('#menorcheckboxdos').is(':checked')){
            $('div.menoresultados').show();

        }else{
            $('div.menoresultados').hide();

        }

    });
	function cambiarEstado(){
        if($('#menorcheckbox').is(':checked')){
            $('div.menor').show('slow');
        }else{
            $('div.menor').hide('slow');
        }
    }

	function cambiarEstado2(){
        if($('#menorcheckboxdos').is(':checked')){
            $('div.menoresultados').show('slow');
        }else{
            $('div.menoresultados').hide('slow');
        }
    }

    
    

</script>
</head>

<body>

<div id="contenedor">

	<div id="cabecera">
            <img src="imagenes/logotipo.png" alt="Federaci&oacute;n de Golf de Bizkaia" width="123" height="115" style="float:left;">
            <h1 style="float:right;">Federación de Golf de Bizkaia</h1><br/>
            <h1 style="float:right;">Bizkaiko Golf Federazioa</h1>
	</div>


	<div id="menu">
		<ul id="lista_menu">
		<li><a id="activo" href="#">FEDERADOS</a></li>
		<li><a href="confAccionServlet">CONFIGURACIÓN</a></li>
                <li><a href="informes.html">INFORMES</a></li>
                <li><a href="consultaServlet">CONSULTA</a></li>
                <li><a href="confDEActividadServlet">DEPORTE ESCOLAR</a></li>
		<li><a href="http://www.bizkaiagolf.com">WEB</a></li>
	  </ul>
        </div>
           <div id="submenu">
            <ul id="lista_submenu">
                        <li><a href="confDEActividadServlet">Actividad</a></li>
                        <li><a  href="confDEEntidadServlet">Entidad</a></li>
                        <li><a href="confDECursoServlet">Curso</a></li>
                        <li><a id="activo" href="#">Busqueda</a></li>
            </ul>
	</div>
 	<div id="principal">

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> Resultados de Busqueda </h1>
     
        

       <%
           ArrayList<DEActividad> listaDEActividad = (ArrayList<DEActividad>)session.getAttribute("listaDEActividad");
       %>

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
        <th class="titulos_tablas">Nombre Responsable</th>
        <th class="titulos_tablas">Apellidos</th>
        <th class="titulos_tablas">DNI</th>
        <th class="titulos_tablas">Telefono</th>
        <th class="titulos_tablas">Email</th>
        </tr>
	</thead>

        <tbody>

            <% if (listaDEActividad != null)
               {
                    if (listaDEActividad.size()>0)
                    {
                        DEResponsable unDEResponsable = null;
                        DEResponsableDAL unDEResponsableDAL = new DEResponsableDAL();
                        unDEResponsable = unDEResponsableDAL.getDEResponsable(listaDEActividad.get(0).getResponsable().getIdDEResponsable());
                     
            %>

            <tr>
                    <td class="texto_tablas"><%=unDEResponsable.getNombre()%></td>
                    <td class="texto_tablas"><%=unDEResponsable.getApellidos()%></td>
                    <td class="texto_tablas"><%=unDEResponsable.getDni()%></td>
                    <td class="texto_tablas"><%=unDEResponsable.getMovil()%></td>
                    <td class="texto_tablas"><%=unDEResponsable.getEmail()%></td>
                </tr>
                <%
                    }
                 }
                %>
	</tbody>

	</table>

	</div>

        <form action="excelLicencia.jsp" method="post">
            <div class="formulario_botones">
                <label><input name="enviar" type="submit" class="boton" id="crear" value="Exportar a Excel" ></label>
            </div>
        </form>
        <form autocomplete="off" action="confDEBusquedaServlet" method="post">
            <div class="formulario_botones">
                <label><input name="enviar" type="submit" class="boton" id="volver" value="Volver" ></label>
            </div>
        </form>
      

 	</div>


<div id="pie"></div>

</div>

</body>
</html>

