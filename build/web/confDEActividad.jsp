<%-- 
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>

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

    function validar()
    {
        var temporada = document.getElementById("temporada").value;
        var fechaInicio = document.getElementById("f_date_y").value;
        var fechaFin = document.getElementById("f_date_t").value;
        var nombre = document.getElementById("nombre").value;
        var apellidos = document.getElementById("apellidos").value;
        var dni = document.getElementById("dni").value;
        var fechaNac = document.getElementById("f_date_s").value;
        var direccion = document.getElementById("direccion").value;
        var poblacion = document.getElementById("poblacion").value;
        var provincia = document.getElementById("provincia").value;
        var cp = document.getElementById("cp").value;
        var fijo = document.getElementById("fijo").value;
        var movil = document.getElementById("movil").value;
        var email = document.getElementById("email").value;

        if (temporada.length == 0 || fechaInicio.length == 0 || fechaFin.length == 0 || nombre.length == 0 || apellidos.length == 0 || dni.length == 0 ||fechaNac.length == 0 || direccion.length == 0 || poblacion.length == 0 || provincia.length == 0 || cp.length == 0 || fijo.length == 0 || movil.length == 0 || email.length == 0)
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
     
        <form autocomplete="off" action="confDEActividadAlumnoServlet" method="post">


        <!-- Actividad -->
        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Actividad</div>
  		<div class="msg_body_gris">
 

        <%
         ArrayList<DECurso> listaDECurso = (ArrayList<DECurso>)session.getAttribute("listaDECurso");
         ArrayList<DEEntidad> listaDEEntidad = (ArrayList<DEEntidad>)session.getAttribute("listaDEEntidad");

       %>
       
           
	<div class="formulario_formato">
	<div class="formulario_dobles">Temporada: </div>
	<div class="formulario_dobles_campos">
            <label><input name="temporada" type="text" class="campo_texto" id="temporada" size="50">
	</label></div>
	</div>

       <div class="formulario_formato">
	<div class="formulario_dobles">Entidad: </div>
	<div class="formulario_dobles_campos">
            <select name="entidad" id="entidad">

             <%
                if (listaDEEntidad != null)
                {
                    for(int i = 0; i<listaDEEntidad.size();i++)
                    {
             %>
                        <option name="entidad" value="<%=listaDEEntidad.get(i).getIdDEEntidad()%>" ><%=listaDEEntidad.get(i).getEntidad()%></option>
           <%
                    }
                }
            %>
            </select></div>
	</div>


        <div class="formulario_formato">
	<div class="formulario_dobles">Curso: </div>
	<div class="formulario_dobles_campos">
            <select name="curso" id="curso">

             <%
                if (listaDECurso != null)
                {
                    for(int i = 0; i<listaDECurso.size();i++)
                    {
             %>
                        <option name="curso" value="<%=listaDECurso.get(i).getIdCurso()%>" ><%=listaDECurso.get(i).getNombre()%></option>
           <%
                    }
                }
            %>
            </select></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Fecha Inicio: </div>
	<div class="formulario_dobles_campos">
             <label><input name="fechaInicio" type="text" class="campo_texto" id="f_date_y" readonly="1" />
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

           <div class="formulario_formato">
	<div class="formulario_dobles">Fecha Fin: </div>
	<div class="formulario_dobles_campos">
        <label>
        <input name="fechaFin" type="text" class="campo_texto" id="f_date_t" readonly="1" />
	<img src="jscalendar/img.gif" id="f_trigger_t"/>

  	    <script type="text/javascript">
    	Calendar.setup({
        inputField     :    "f_date_t",     // id of the input field
        ifFormat       :    "%d-%m-%Y",      // format of the input field
        button         :    "f_trigger_t",  // trigger for the calendar (button ID)
        align          :    "Tl",           // alignment (defaults to "Bl")
        singleClick    :    true
   		});
		</script>
  	    </label>
        
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
            <label><input name="dni" type="text" class="campo_texto" id="dni" size="50">
	</label></div>
	</div>

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
            <div class="ajustar"></div>
 	</div>


       <!-- Fin Responsable -->  
       
       <div class="formulario_botones">
           <label><input name="enviar" type="submit" class="boton" id="alta" value="A&Ntilde;ADIR ALUMNOS" onclick="return validar()" >
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

