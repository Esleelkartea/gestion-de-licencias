<%-- 
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>

<%@page import="com.Negocio.Consulta"%>
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

    function validar()
    {
        var fecha = document.getElementById("f_date_y").value;
        if(fecha.length == 0)
        {
            alert("Debes seleccionar la fecha de la consulta")
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
                        <li><a href="consultaServlet">Pendientes</a></li>
                        <li><a href="consultaBusquedaServlet">Busqueda</a></li>
            </ul>
	</div>


 	<div id="principal">

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> Alta Consulta </h1>
     
        

       <%
           Federado unFederado = (Federado)session.getAttribute("unFederado");
           session.setAttribute("unFederado", null);
           ArrayList<Consulta> listaConsultas = (ArrayList<Consulta>)session.getAttribute("listaConsultas");
       %>

     

         <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Federado</div>
  		<div class="msg_body_gris">

       
         <div class="formulario_formato">
	<div class="formulario_dobles">Numero Federado: </div>
	<div class="formulario_dobles_campos">
            <label><%=unFederado.getNumFederado()%>
	</label></div>
	</div>


	<div class="formulario_formato">
	<div class="formulario_dobles">Nombre: </div>
	<div class="formulario_dobles_campos">
            <label><%=unFederado.getNombre()%>
	</label></div>
	</div>

       <div class="formulario_formato">
	<div class="formulario_dobles">Primer Apellido: </div>
	<div class="formulario_dobles_campos">
            <label><%=unFederado.getApellido1()%></label>
        </div>
	</div>


        <%
            if(!unFederado.getApellido2().equals(""))
            {
        %>
                <div class="formulario_formato">
                <div class="formulario_dobles">Segundo Apellido: </div>
                <div class="formulario_dobles_campos">
                    <label><%=unFederado.getApellido2()%></label>
                </div>
                </div>
        <%
            }
        %>

        <%
            if(!unFederado.getDni().equals(""))
            {
        %>

                <div class="formulario_formato">
                <div class="formulario_dobles">DNI: </div>
                <div class="formulario_dobles_campos">
                    <label><%=unFederado.getDni()%></label>
                </div>
                </div>
        <%
            }
        %>

         </div>
        <div class="ajustar"></div>
 	</div>



         <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Consulta</div>
  		<div class="msg_body_gris">

            <form autocomplete="off" action="consultaAltaMIBServlet" method="post">

                <input type="hidden" id="idFederado" name="idFederado" value="<%=unFederado.getIdFederado()%>" />

             <div class="formulario_formato">
                <div class="formulario_dobles">Consulta: </div>
                <div class="formulario_dobles_campos">
                    <select name="consulta" id="consulta">

                     <%
                        if (listaConsultas != null)
                        {
                            for(int i = 0; i<listaConsultas.size();i++)
                            {
                     %>
                                <option name="consulta" value="<%=listaConsultas.get(i).getIdConsulta()%>" ><%=listaConsultas.get(i).getConsulta()%></option>
                   <%
                            }
                        }
                    %>
                    </select></div>
                </div>



             <div class="formulario_formato">
                <div class="formulario_dobles">Fecha Consulta: </div>
                <div class="formulario_dobles_campos">
                    <label><input name="fechaConsulta" type="text" class="campo_texto" id="f_date_y" readonly="1" />
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

                <div class="formulario_dobles">
                    <input type="checkbox" name="pendiente" id="pendiente" value="On" /> Pendiente<br /></div>
                <div class="formulario_dobles"></div>
            </div>    

                
            <div class="formulario_formato">
                <div class="formulario_dobles">Observaciones: </div>
                    <div class="formulario_dobles_campos">
                        <label><input name="observaciones" type="text" class="campo_texto" id="dni" size="100"></label></div>
            </div>


                <div class="formulario_botones">
                    <label><input name="enviar" type="submit" class="boton" id="alta" value="ALTA" onclick="return validar()" ></label>
                    <label><input name="enviar" type="submit" class="boton" id="cancelar" value="Cancelar" ></label>
                </div>
            </form>


        </div>
        <div class="ajustar"></div>
 	</div>

 	</div>


<div id="pie"></div>

</div>

</body>
</html>

