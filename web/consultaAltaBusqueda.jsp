<%--
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>

<%@page import="com.Negocio.Federado"%>
<%@page import="com.Negocio.EstadoEconomico"%>
<%@page import="com.Negocio.EstadoLicencia"%>
<%@page import="com.Negocio.Entidad"%>
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

    function validarBusqueda()
    {
        var nombre = document.getElementById("nombre").value;
        var apellido1 = document.getElementById("apellido1").value;
        var apellido2 = document.getElementById("apellido2").value;
        var dni = document.getElementById("dni").value;
        var numLicencia = document.getElementById("numLicencia").value;
                

        if (nombre.length == 0 && apellido1.length == 0 && apellido2.length == 0 && dni.length == 0 && numLicencia.length == 0)
        {
            alert("Debes introducir algun campo para la busqueda");
            return false;
        }
        else
        {
            return true;
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
                <li><a id="activo" href="#">CONSULTA</a></li>
                <li><a href="confDEActividadServlet">DEPORTE ESCOLAR</a></li>
		<li><a href="http://www.bizkaiagolf.com">WEB</a></li>
	  </ul>
        </div>
          <div id="submenu">
            <ul id="lista_submenu">
                        <li><a id="activo" href="#">Alta</a></li>
                        <li><a href="consultaPendienteServlet">Pendientes</a></li>
                        <li><a href="consultaBusquedaServlet">Busqueda</a></li>
            </ul>
	</div>

 	<div id="principal">

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> BUSQUEDA FEDERADO</h1>

        <form autocomplete="off" action="consultaAltaBusquedaServlet" method="post">


        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Federado</div>
  		<div class="msg_body_gris">
        

        <div class="formulario_formato">
	<div class="formulario_dobles">Numero Licencia: </div>
	<div class="formulario_dobles_campos">
            <label><input name="numLicencia" type="text" class="campo_texto" id="numLicencia" size="50">
	</label></div>
	</div>


	<div class="formulario_formato">
	<div class="formulario_dobles">Nombre: </div>
	<div class="formulario_dobles_campos">
            <label><input name="nombre" type="text" class="campo_texto" id="nombre" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Primer Apellido: </div>
	<div class="formulario_dobles_campos">
            <label><input name="apellido1" type="text" class="campo_texto" id="apellido1" size="50">
	</label></div>
	</div>

       <div class="formulario_formato">
	<div class="formulario_dobles">Segundo Apellido: </div>
	<div class="formulario_dobles_campos">
            <label><input name="apellido2" type="text" class="campo_texto" id="apellido2" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">DNI: </div>
	<div class="formulario_dobles_campos">
            <label><input name="dni" type="text" class="campo_texto" id="dni" size="50">
	</label></div>
	</div>

        <div class="formulario_botones">
            <label><input name="enviar" type="submit" class="boton" id="alta" value="BUSQUEDA" onclick="return validarBusqueda()" >
	</label>

	</div>

        </div>
            <div class="ajustar"></div>
 	</div>


        </form>

 	</div>


    <!-- Resultado -->

    <%
       ArrayList<Federado> listaFederado = (ArrayList<Federado>)session.getAttribute("listaFederado");
        if(listaFederado != null)
        {
     %>

             <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Resultado</div>
  		<div class="msg_body_gris">

     <%
            if(listaFederado.size() == 0)
            {
    %>
                <div class="msg_head_gris">La busqueda no obtuvo ningun resultado</div>
    <%
            }
            else
            {
    %>

               <div class="capas_tablas_mm">

                <table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0">

                <thead>

                <tr>
                    <th class="titulos_tablas">Num. Federado</th>
                    <th class="titulos_tablas">Nombre</th>
                    <th class="titulos_tablas">Primer Apellido</th>
                    <th class="titulos_tablas">Segundo Apellido</th>
                    <th class="titulos_tablas">DNI</th>
                </tr>
                </thead>

                <tbody>

                    <% if (listaFederado != null)
                       {
                            for (int i = 0; i<listaFederado.size(); i++)
                            {
                    %>
                    <tr>
                        <td class="texto_tablas"><a href="consultaAltaResultadoServlet?var=<%=listaFederado.get(i).getIdFederado()%>"><%=listaFederado.get(i).getNumFederado()%></a></td>
                        <td class="texto_tablas"><a href="consultaAltaResultadoServlet?var=<%=listaFederado.get(i).getIdFederado()%>"><%=listaFederado.get(i).getNombre()%></a></td>
                        <td class="texto_tablas"><a href="consultaAltaResultadoServlet?var=<%=listaFederado.get(i).getIdFederado()%>"><%=listaFederado.get(i).getApellido1()%></a></td>
                        <td class="texto_tablas"><a href="consultaAltaResultadoServlet?var=<%=listaFederado.get(i).getIdFederado()%>"><%=listaFederado.get(i).getApellido2()%></a></td>
                        <td class="texto_tablas"><a href="consultaAltaResultadoServlet?var=<%=listaFederado.get(i).getIdFederado()%>"><%=listaFederado.get(i).getDni()%></a></td>
                    </tr>

                    <%
                            }
                    %>
                        <tr>
                            <td class="texto_tablas">&nbsp;</td>
                            <td class="texto_tablas">&nbsp;</td>
                            <td class="texto_tablas">&nbsp;</td>
                            <td class="texto_tablas">&nbsp;</td>
                            <td class="texto_tablas">&nbsp;</td>
                        </tr>
                    <%
                        }
                    %>


                </tbody>

                </table>
                </div>

    <%
            }
    %>
            </div>
                <div class="ajustar"></div>
 	</div>

    <%
        }
    %>

    <!-- Fin Resultado -->


<div id="pie">
     <div class="vcard">
        <div> <span class="name">Federación Vizcaina de Golf</span>-<span class="locality">Bilbao</span>-<span class="region">Bizkaia</span>-<span class="postal-code">48003</span></div>
	<div> <span class="tel">94 439 41 21</span>-<span class="email">info@bizkaiagolf.com</span></div>
    </div>
</div>

</div>

</body>
</html>

