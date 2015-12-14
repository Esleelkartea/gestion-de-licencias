<%--
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>

<%@page import="com.Negocio.Entidad"%>
<%@page import="com.Negocio.Federado"%>
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
        miCampoTexto = document.getElementById("f_date_s").value;
        miCampoTexto2 = document.getElementById("f_date_t").value;
        if(miCampoTexto.length != 0 && miCampoTexto2.length != 0)
        {
            var xMes=miCampoTexto.substring(3, 5);
            var xDia=miCampoTexto.substring(0, 2);
            var xAno=miCampoTexto.substring(6,10);
            var yMes=miCampoTexto2.substring(3, 5);
            var yDia=miCampoTexto2.substring(0, 2);
            var yAno=miCampoTexto2.substring(6,10);

            if(xAno > yAno)
            {
                alert("La fecha final debe ser posterior a la inicial");
                document.getElementById("f_date_s").value = "";
                document.getElementById("f_date_t").value = "";
                return false;
            }
            else
            {
                if (xAno == yAno)
                {
                    if (xMes > yMes)
                    {
                        alert("La fecha final debe ser posterior a la inicial");
                        document.getElementById("f_date_s").value = "";
                        document.getElementById("f_date_t").value = "";
                        return false;
                    }
                    else
                    {
                        if (xMes == yMes)
                        {
                            if (xDia > yDia)
                            {
                                alert("La fecha final debe ser posterior a la inicial");
                                document.getElementById("f_date_s").value = "";
                                document.getElementById("f_date_t").value = "";
                                return false;
                            }
                            else
                            {
                                return true;
                            }
                        }
                        else
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    return true;
                }
            }
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
		<li><a id="activo" href="">FEDERADOS</a></li>
		<li><a href="confAccionServlet">CONFIGURACIÓN</a></li>
                <li><a href="consultaServlet">CONSULTA</a></li>
                <li><a href="#">VINCULAR A COLECTIVOS</a></li>
                <li><a href="informes.html">INFORMES</a></li>
                <li><a href="confDEActividadServlet">DEPORTE ESCOLAR</a></li>
		<li><a href="http://www.bizkaiagolf.com">WEB</a></li>
	  </ul>
        </div>
          <div id="submenu">
            <ul id="lista_submenu">
                        <li><a id="activo" href="#">Busqueda Baja</a></li>
            </ul>
	</div>

        <%
            ArrayList<Entidad> listaEntidades = (ArrayList<Entidad>)session.getAttribute("listaEntidad");
        %>


 	<div id="principal">

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> Busqueda Baja</h1>

        <form autocomplete="off" action="licenBusquedaBaja2Servlet" method="post">


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

         <div class="formulario_formato">
	<div class="formulario_dobles">Entidad: </div>
	<div class="formulario_dobles_campos">
            <select name="entidad" id="entidad">
             <option name="entidad" value="-1" ></option>
             <%
                if (listaEntidades != null)
                {
                    for(int i = 0; i<listaEntidades.size();i++)
                    {
             %>
                        <option name="entidad" value="<%=listaEntidades.get(i).getIdEntidad()%>" ><%=listaEntidades.get(i).getDesCastellano()%></option>
           <%
                    }
                }
            %>
            </select></div>
	</div>

            <div class="formulario_formato">
	<div class="formulario_dobles">Fecha de: </div>
	<div class="formulario_dobles_campos">
             <label><input name="fechaInicio" type="text" class="campo_texto" id="f_date_s" readonly="1" />
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
	<div class="formulario_dobles">Fecha a: </div>
	<div class="formulario_dobles_campos">
             <label><input name="fechaFin" type="text" class="campo_texto" id="f_date_t" readonly="1" />
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
  	    </label></div>
	</div>

        <div class="formulario_botones">
            <label><input name="enviar" type="submit" class="boton" id="alta" value="BUSQUEDA" onclick="return validar()" >
	</label>

	</div>

        </div>
            <div class="ajustar"></div>
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

