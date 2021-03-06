<%-- 
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>

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
		<li><a href="licenAltaServlet">FEDERADOS</a></li>
		<li><a href="confAccionServlet">CONFIGURACIÓN</a></li>
                <li><a href="informes.html">INFORMES</a></li>
                <li><a id="activo" href="#">DEPORTE ESCOLAR</a></li>
		<li><a href="http://www.bizkaiagolf.com">WEB</a></li>
	  </ul>
        </div>
         <div id="submenu">
            <ul id="lista_submenu">
                        <li><a id="activo" href="#">Actividad</a></li>
                        <li><a href="confDEEntidadServlet">Entidad</a></li>
                        <li><a href="confDECursoServlet">Curso</a></li>
                        <li><a href="confDEBusquedaServlet">Busqueda</a></li>
            </ul>
	</div>

 	<div id="principal">

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> ACTIVIDAD</h1>
     
        


        <!-- Actividad -->
        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Actividad</div>
  		<div class="msg_body_gris">
 

        <%
         String strTemporada = (String)session.getAttribute("temporada");
         DEEntidad unDEEntidad = (DEEntidad)session.getAttribute("unaDEEntidad");
         DECurso unDECurso = (DECurso)session.getAttribute("unDECurso");
         String strFechaInicio = (String)session.getAttribute("fechaInicio");
         String strFechaFin = (String)session.getAttribute("fechaFin");
         DEResponsable unDEResponsable = (DEResponsable)session.getAttribute("unDEResponsable");

       %>   
           
	<div class="formulario_formato">
	<div class="formulario_dobles">Temporada: </div>
	<div class="formulario_dobles_campos">
            <label><%=strTemporada%>
	</label></div>
	</div>

       <div class="formulario_formato">
	<div class="formulario_dobles">Entidad: </div>
	<div class="formulario_dobles_campos">
            <label><%=unDEEntidad.getEntidad()%></label>
        </div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Numero Entidad: </div>
	<div class="formulario_dobles_campos">
            <label><%=unDEEntidad.getNumEntidad()%></label>
        </div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Curso: </div>
	<div class="formulario_dobles_campos">
            <label><%=unDECurso.getNombre()%></label>
        </div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Fecha Inicio: </div>
	<div class="formulario_dobles_campos">
            <label><%=strFechaInicio%></label>
        </div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Fecha Fin: </div>
	<div class="formulario_dobles_campos">
            <label><%=strFechaFin%></label>
        </div>
	</div>


        </div>
        <div class="ajustar"></div>
 	</div>

       <!-- Fin Actividad -->

       <!-- Responsable -->


        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Responsable</div>
  		<div class="msg_body_gris">

        <div class="formulario_formato">
	<div class="formulario_dobles">DNI: </div>
	<div class="formulario_dobles_campos">
            <label><%=unDEResponsable.getDni()%>
	</label></div>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Nombre: </div>
	<div class="formulario_dobles_campos">
            <label><%=unDEResponsable.getNombre()%>
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Apellidos: </div>
	<div class="formulario_dobles_campos">
            <label><%=unDEResponsable.getApellidos()%>
	</label></div>
	</div>


        <div class="formulario_formato">
	<div class="formulario_dobles">Fecha Nacimiento: </div>
	<div class="formulario_dobles_campos">
             <label><%=unDEResponsable.getFechaNac()%>
  	    </label></div>
	</div>


        <div class="formulario_formato">
	<div class="formulario_dobles">Direccion: </div>
	<div class="formulario_dobles_campos">
            <label><%=unDEResponsable.getDireccion()%>
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Poblacion: </div>
	<div class="formulario_dobles_campos">
            <label><%=unDEResponsable.getPoblacion()%>
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">CP: </div>
	<div class="formulario_dobles_campos">
            <label><%=unDEResponsable.getCp()%>
	</label></div>
	</div>


        <div class="formulario_formato">
	<div class="formulario_dobles">Telefono Fijo: </div>
	<div class="formulario_dobles_campos">
            <label><%=unDEResponsable.getFijo()%>
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Telefono Movil: </div>
	<div class="formulario_dobles_campos">
            <label><%=unDEResponsable.getMovil()%>
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Email: </div>
	<div class="formulario_dobles_campos">
            <label><%=unDEResponsable.getEmail()%>
	</label></div>
	</div>


        </div>
        <div class="ajustar"></div>
 	</div>


       <!-- Fin Responsable -->
       <div class="marco">
        <div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Listado de Alumnos del Curso</div>
       <%
       ArrayList<DEAlumno> listaDEAlumno = (ArrayList<DEAlumno>)session.getAttribute("listaDEAlumno");


       %>

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
        <th class="titulos_tablas_tx">Nombre</th>
        <th class="titulos_tablas_tx">Apellidos</th>
        <th class="titulos_tablas_tx">Curso</th>
        <th class="titulos_tablas_tx">Fecha Nacimiento</th>
        <th class="titulos_tablas_tx">Nombre Tutor</th>
        <th class="titulos_tablas_tx">Apellidos Tutor</th>
        <th class="titulos_tablas_tx">Telefono Fijo</th>
        <th class="titulos_tablas_tx">Telefono Movil</th>
        <th class="titulos_tablas_tx">Email</th>
        </tr>
	</thead>

        <tbody>

            <% if (listaDEAlumno != null)
               {
                    for (int i = 0; i<listaDEAlumno.size(); i++)
                    {
            %>
            <tr>
                    <td class="texto_tablas_tx"><%=listaDEAlumno.get(i).getNombre()%></td>
                    <td class="texto_tablas_tx"><%=listaDEAlumno.get(i).getApellidos()%></td>
                    <td class="texto_tablas_tx"><%=listaDEAlumno.get(i).getCurso()%></td>
                    <td class="texto_tablas_tx"><%=listaDEAlumno.get(i).getFechaNac()%></td>
                    <td class="texto_tablas_tx"><%=listaDEAlumno.get(i).getNombreTutor()%></td>
                    <td class="texto_tablas_tx"><%=listaDEAlumno.get(i).getApellidosTutor()%></td>
                    <td class="texto_tablas_tx"><%=listaDEAlumno.get(i).getFijo()%></td>
                    <td class="texto_tablas_tx"><%=listaDEAlumno.get(i).getMovil()%></td>
                    <td class="texto_tablas_tx"><%=listaDEAlumno.get(i).getEmail()%></td>
            </tr>

            <%
                    }
            %>
                <tr>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                </tr>

            <%
                }
                else 
                {
            %>

            <tr>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                </tr>
            <%
                }
            %>
	</tbody>

	</table>
	</div>

        <form autocomplete="off" action="confDEActividadMIBServlet" method="post">
            <div class="formulario_botones">
            <label><input name="enviar" type="submit" class="boton" id="crear" value="CREAR CURSO" >
	</label>
        <label><input name="enviar" type="submit" class="boton" id="cancelar" value="CANCELAR" >
	</label>
	</div>
        </form>

        <div class="ajustar"></div>
       </div>
        <form autocomplete="off" action="confDEActividadAnadirServlet" method="post">

        <!-- Alumnos -->
        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Alumnos</div>
  		<div class="msg_body_gris">
       
        <div class="formulario_formato">
	<div class="formulario_dobles">Nombre: </div>
	<div class="formulario_dobles_campos">
            <label><input name="nombre" type="text" class="campo_texto" id="nombre" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Apellidos: </div>
	<div class="formulario_dobles_campos">
            <label><input name="apellidos" type="text" class="campo_texto" id="apellidos" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Curso: </div>
	<div class="formulario_dobles_campos">
            <label><input name="curso" type="text" class="campo_texto" id="curso" size="50">
	</label></div>
	</div>


        <div class="formulario_formato">
	<div class="formulario_dobles">Fecha Nacimiento: </div>
	<div class="formulario_dobles_campos">
             <label><input name="fechaNac" type="text" class="campo_texto" id="f_date_s" readonly="1" />
  	    <img src="jscalendar/img.gif" id="f_trigger_s"/>

  	    <script type="text/javascript">
                Calendar.setup({
                inputField     :    "f_date_s",     // id of the input field
                ifFormat       :    "%d-%m-%Y",      // format of the input field
                button         :    "f_trigger_s",  // trigger for the calendar (button ID)
                align          :    "Tl",           // alignment (defaults to "Bl")
                singleClick    :    true
                        });
		</script>
  	    </label></div>
	</div>


        <div class="formulario_formato">
	<div class="formulario_dobles">Nombre Tutor: </div>
	<div class="formulario_dobles_campos">
            <label><input name="nombreTutor" type="text" class="campo_texto" id="nombreTutor" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Apellidos Tutor: </div>
	<div class="formulario_dobles_campos">
            <label><input name="apellidosTutor" type="text" class="campo_texto" id="apellidosTutor" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Telefono Fijo: </div>
	<div class="formulario_dobles_campos">
            <label><input name="fijo" type="text" class="campo_texto" id="fijo" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Telefono Movil: </div>
	<div class="formulario_dobles_campos">
            <label><input name="movil" type="text" class="campo_texto" id="movil" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Email: </div>
	<div class="formulario_dobles_campos">
            <label><input name="email" type="text" class="campo_texto" id="email" size="50">
	</label></div>
	</div>


        </div>
             <div class="formulario_botones">
           <label><input name="enviar" type="submit" class="boton" id="alta" value="A&Ntilde;ADIR ALUMNO" onclick="return validar()" >
	</label>
	</div>
            <div class="ajustar"></div>
 	</div>

       <!-- Fin Alumnos -->

       
    

        </form>
       
       

 	</div>


<div id="pie"></div>

</div>

</body>
</html>

