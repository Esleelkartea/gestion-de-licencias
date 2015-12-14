<%--
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>

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

    function validar()
    {
        var nombre = document.getElementById("nombre").value;
        var apellido1 = document.getElementById("apellido1").value;
        var apellido2 = document.getElementById("apellido2").value;
        var dni = document.getElementById("dni").value;
        var fechaNac = document.getElementById("f_date_y").value;
        var nacionalidad = document.getElementById("nacionalidad").value;
        var direccion = document.getElementById("direccion").value;
        var poblacion = document.getElementById("poblacion").value;
        var cp = document.getElementById("cp").value;
        var provincia = document.getElementById("provincia").value;
        var telefono = document.getElementById("telefono").value;
        var email = document.getElementById("email").value;
        var formaPago = document.getElementById("formaPago").value;
        var numCuenta = document.getElementById("numCuenta").value;
                

        if (nombre.length == 0 || apellido1.length == 0 || apellido2.length == 0 || dni.length == 0 || fechaNac.length == 0 || nacionalidad.length == 0 || direccion.length == 0 || poblacion.length == 0 || cp.length == 0 || provincia.length == 0 || cp.length == 0 || telefono.length == 0 || formaPago.length == 0 || numCuenta.length == 0)
        {
            alert("Debes introducir todos los datos");
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
		<li><a id="activo" href="#">FEDERADOS</a></li>
		<li><a href="confAccionServlet">CONFIGURACIÓN</a></li>
                <li><a href="informes.html">INFORMES</a></li>
                <li><a href="confDEActividadServlet">DEPORTE ESCOLAR</a></li>
		<li><a href="http://www.bizkaiagolf.com">WEB</a></li>
	  </ul>
        </div>
          <div id="submenu">
            <ul id="lista_submenu">
                        <li><a id="activo" href="licenAltaServlet">Alta</a></li>
                        <li><a id="activo" href="#">Busqueda</a></li>
            </ul>
	</div>

 	<div id="principal">

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> BUSQUEDA LICENCIA</h1>

        <form autocomplete="off" action="licenBusquedaMIBServlet" method="post">


        <!-- Actividad -->
        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Licencia</div>
  		<div class="msg_body_gris">


        <%
         ArrayList<EstadoEconomico> listaEstadoEconomico = (ArrayList<EstadoEconomico>)session.getAttribute("listaEstadoEconomico");
         ArrayList<EstadoLicencia> listaEstadoLicencia = (ArrayList<EstadoLicencia>)session.getAttribute("listaEstadoLicencia");
         ArrayList<Entidad> listaEntidad = (ArrayList<Entidad>)session.getAttribute("listaEntidad");

       %>

       <div class="formulario_formato">
	<div class="formulario_dobles">Entidad: </div>
	<div class="formulario_dobles_campos">
            <select name="entidad" id="entidad">
                <option name="entidad" value="-1"></option>
             <%
                if (listaEntidad != null)
                {
                    for(int i = 0; i<listaEntidad.size();i++)
                    {
             %>
                        <option name="entidad" value="<%=listaEntidad.get(i).getIdEntidad()%>" ><%=listaEntidad.get(i).getDesCastellano()%></option>
           <%
                    }
                }
            %>
            </select></div>
	</div>

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

        <div class="formulario_formato">
	<div class="formulario_dobles">Fecha Nacimiento: </div>
	<div class="formulario_dobles_campos">
             <label><input name="fechaNacimiento" type="text" class="campo_texto" id="f_date_y" readonly="1" />
  	    <img src="jscalendar/img.gif" id="f_trigger_y"/>

  	    <script type="text/javascript">
                Calendar.setup({
                inputField     :    "f_date_y",     // id of the input field
                ifFormat       :    "%d-%m-%Y",      // format of the input field
                button         :    "f_trigger_y",  // trigger for the calendar (button ID)
                align          :    "Tl",           // alignment (defaults to "Bl")
                singleClick    :    true
                        });
		</script>
  	    </label></div>
	</div>

      
               
       <!-- Quitar el Jueves -->

       <div class="formulario_formato">
	<div class="formulario_dobles">Direccion: </div>
	<div class="formulario_dobles_campos">
            <label><input name="direccion" type="text" class="campo_texto" id="direccion" size="50">
	</label></div>
	</div>

       <div class="formulario_formato">
	<div class="formulario_dobles">Poblacion: </div>
	<div class="formulario_dobles_campos">
            <label><input name="poblacion" type="text" class="campo_texto" id="poblacion" size="50">
	</label></div>
	</div>

       <div class="formulario_formato">
	<div class="formulario_dobles">CP: </div>
	<div class="formulario_dobles_campos">
            <label><input name="cp" type="text" class="campo_texto" id="cp" size="50">
	</label></div>
	</div>

       <div class="formulario_formato">
	<div class="formulario_dobles">Provincia: </div>
	<div class="formulario_dobles_campos">
            <label><input name="provincia" type="text" class="campo_texto" id="provincia" size="50">
	</label></div>
	</div>

       <div class="formulario_formato">
	<div class="formulario_dobles">Telefono: </div>
	<div class="formulario_dobles_campos">
            <label><input name="telefono" type="text" class="campo_texto" id="telefono" size="50">
	</label></div>
	</div>

       <div class="formulario_formato">
	<div class="formulario_dobles">Email: </div>
	<div class="formulario_dobles_campos">
            <label><input name="email" type="text" class="campo_texto" id="email" size="50">
	</label></div>
	</div>

       <!-- Fin Quitar el Jueves -->


        <div class="formulario_formato">
	<div class="formulario_dobles">Numero Handicap: </div>
	<div class="formulario_dobles_campos">
            <label><input name="numHandicap" type="text" class="campo_texto" id="numHandicap" size="5">
	</label></div>
	</div>
        

        <div class="formulario_formato">
	<div class="formulario_dobles">Estado Licencia: </div>
	<div class="formulario_dobles_campos">
            <select name="estadoLicencia" id="estadoLicencia">
                <option name="estadoLicencia" value="-1"></option>

             <%
                if (listaEstadoLicencia!= null)
                {
                    for(int i = 0; i<listaEstadoLicencia.size();i++)
                    {
             %>
                        <option name="estadoLicencia" value="<%=listaEstadoLicencia.get(i).getIdEstadoLicencia()%>" ><%=listaEstadoLicencia.get(i).getEstado()%></option>
           <%
                    }
                }
            %>
            </select></div>
	</div>


        <div class="formulario_formato">
	<div class="formulario_dobles">Estado Economico: </div>
	<div class="formulario_dobles_campos">
            <select name="estadoEconomico" id="estadoEconomico">
                <option name="estadoEconomico" value="-1"></option>
             <%
                if (listaEstadoEconomico!= null)
                {
                    for(int i = 0; i<listaEstadoEconomico.size();i++)
                    {
             %>
                        <option name="estadoEconomico" value="<%=listaEstadoEconomico.get(i).getIdEstadoEconomico()%>" ><%=listaEstadoEconomico.get(i).getEstado()%></option>
           <%
                    }
                }
            %>
            </select></div>
	</div>
  
            

        </div>
            <div class="ajustar"></div>
 	</div>

       <!-- Fin Actividad -->


       <div class="formulario_botones">
           <label><input name="enviar" type="submit" class="boton" id="alta" value="BUSQUEDA">
	</label>

	</div>

        </form>

 	</div>


<div id="pie">
     <div class="vcard">
        <div> <span class="name">Federación Vizcaina de Golf</span>-<span class="locality">Bilbao</span>-<span class="region">Bizkaia</span>-<span class="postal-code">48003</span></div>
	<div> <span class="tel">94 439 41 21</span>-<span class="email">info@bizkaiagolf.com</span></div>
    </div>
</div>

</div>

</body>
</html>

