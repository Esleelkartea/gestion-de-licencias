<%--
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>

<%@page import="com.Negocio.Grupo"%>
<%@page import="com.Negocio.Federado"%>
<%@page import="com.dal.TipoDireccionDAL"%>
<%@page import="com.Negocio.FederadoDireccion"%>
<%@page import="com.Negocio.TipoDireccion"%>
<%@page import="com.dal.TipoEmailDAL"%>
<%@page import="com.Negocio.FederadoEmail"%>
<%@page import="com.dal.TipoTelefonoDAL"%>
<%@page import="com.Negocio.FederadoTelefono"%>
<%@page import="com.Negocio.TipoEmail"%>
<%@page import="com.Negocio.TipoTelefono"%>
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
        var fechaNac = document.getElementById("f_date_y").value;
        var fechaPreAlta = document.getElementById("f_date_s").value;

  
        if (nombre.length == 0 || apellido1.length == 0 || fechaNac.length == 0 || fechaPreAlta.length == 0)
        {
            alert("Debes introducir el nombre, el primer apellido, la fecha de nacimiento y la fecha de Pre Alta como minimo");
            return false;
        }
        else
        {
            return true;
        }
    }

    function activar(elem)
    {
        if(document.getElementById(elem).disabled == true)
        {
            document.getElementById(elem).disabled = false;
            document.getElementById(elem).value = "36";
        }
        else
        {
            document.getElementById(elem).disabled = true;
            document.getElementById(elem).value = "";
        }
    }


    function activarMenor()
    {
        var vista = document.getElementById('dniTutor').style.display;
	if (vista=='none')
		vista='block';
	else
		vista='none';

	document.getElementById('dniTutor').style.display = vista;
        document.getElementById('textoDniTutor').style.display = vista;
        document.getElementById('nombreTutor').style.display = vista;
        document.getElementById('textoNombreTutor').style.display = vista;
        document.getElementById('apellido1Tutor').style.display = vista;
        document.getElementById('textoApellido1Tutor').style.display = vista;
        document.getElementById('apellido2Tutor').style.display = vista;
        document.getElementById('textoApellido2Tutor').style.display = vista;
        document.getElementById('tipoTutor').style.display = vista;
        document.getElementById('textoTipoTutor').style.display = vista;
        document.getElementById('numLicenTutor').style.display = vista;
        document.getElementById('textoNumLicenTutor').style.display = vista;
    }

    function activarHandicap()
    {
        var vista = document.getElementById('textoNumHandicap').style.display;
	if (vista=='none')
		vista='block';
	else
		vista='none';

	document.getElementById('textoNumHandicap').style.display = vista;
        document.getElementById('numHandicap').style.display = vista;
    }

    function validarEmail()
    {
        var email = document.getElementById("email").value;
        if(email.length == 0)
        {
            alert("Debes introducir un Email");
            return false;
        }
        else
        {
            if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))
            {
                return (true);
            }
            else
            {
                alert("La dirección de email es incorrecta.");
                return (false);
            }
        }
    }

    function validarTelefono()
    {
        var telefono = document.getElementById("telefono").value;
        if(telefono.length == 0)
        {
            alert("Debes introducir un numero de Telefono");
            return false;
        }
        else
        {
            return (true);
        }
    }

    function validarDireccion()
    {
        var domicilio = document.getElementById("domicilio").value;
        var numero = document.getElementById("numero").value;
        var cp = document.getElementById("cp").value;
        var poblacion = document.getElementById("poblacion").value;
        if(domicilio.length == 0 || numero.length == 0 || cp.length == 0 || poblacion.length == 0)
        {
            alert("Debes introducir como minimo el domicilio, el numero, el cp y la poblacion");
            return (false);
        }
        else
        {
            if(isNaN(cp))
            {
                alert("El codigo postal no es correcto");
                return (false);
            }
            else
            {
                if(cp.length>5)
                {
                    alert("El codigo postal no es correcto");
                    return (false);
                }
                else
                {
                    return (true);
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
		<li><a id="activo" href="#">FEDERADOS</a></li>
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
                        <li><a href="licenBusquedaServlet">Busqueda</a></li>
            </ul>
	</div>

 	<div id="principal">

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> LICENCIA Paso 1</h1>

        <form autocomplete="off" action="licenAltaMIBServlet" method="post">


        <!-- Actividad -->
        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Federado</div>
  		<div class="msg_body_gris">


        <%
         ArrayList<EstadoEconomico> listaEstadoEconomico = (ArrayList<EstadoEconomico>)session.getAttribute("listaEstadoEconomico");
         ArrayList<EstadoLicencia> listaEstadoLicencia = (ArrayList<EstadoLicencia>)session.getAttribute("listaEstadoLicencia");
         ArrayList<Entidad> listaEntidad = (ArrayList<Entidad>)session.getAttribute("listaEntidad");

         ArrayList<Grupo> listaGrupos = (ArrayList<Grupo>)session.getAttribute("listaGrupos");

       %>

       <div class="formulario_formato">
	<div class="formulario_dobles">Entidad: </div>
	<div class="formulario_dobles_campos">
            <select name="entidad" id="entidad">

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
	<div class="formulario_dobles">Nombre: </div>
	<div class="formulario_dobles_campos">
            <label><input name="nombre" type="text" class="campo_texto" id="nombre" size="50" >
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Primer Apellido: </div>
	<div class="formulario_dobles_campos">
            <label><input name="apellido1" type="text" class="campo_texto" id="apellido1" size="50" >
	</label></div>
	</div>

       <div class="formulario_formato">
	<div class="formulario_dobles">Segundo Apellido: </div>
	<div class="formulario_dobles_campos">
            <label><input name="apellido2" type="text" class="campo_texto" id="apellido2" size="50" >
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">DNI: </div>
	<div class="formulario_dobles_campos">
            <label><input name="dni" type="text" class="campo_texto" id="dni" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Sexo: </div>
	<div class="formulario_dobles_campos">
            <select name="sexo" id="sexo">
                <option name="sexo" value="Masculino" >Masculino</option>
                <option name="sexo" value="Femenino" >Femenino</option>
            </select></div>
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

            <!-- MENOR -->

        <div class="formulario_formato">

	<div class="formulario_dobles">
            <input type="checkbox" name="menor" value="On" onclick="activarMenor()" /> Menor<br />
        </div>
            <div class="formulario_dobles"></div>
	</div>

        <div class="formulario_formato">
        <div class="formulario_dobles" id="textoTipoTutor" style="display: none" >Tutor: </div>
	<div class="formulario_dobles_campos">
            <div class="formulario_dobles_campos">
            <select name="tipoTutor" id="tipoTutor" style="display: none" >
                <option name="sexo" value="0" ></option>
                <option name="sexo" value="Madre" >Madre</option>
                <option name="sexo" value="Padre" >Padre</option>
                <option name="sexo" value="Tutor" >Tutor</option>
            </select></div>
        </div>
	</div>

        <div class="formulario_formato">
            <div class="formulario_dobles" id="textoNumLicenTutor" style="display: none" >Num. Licencia Tutor: </div>
	<div class="formulario_dobles_campos">
            <label><input name="numLicenTutor" type="text" class="campo_texto" id="numLicenTutor" size="50" style="display: none" >
	</label></div>
	</div>

        <div class="formulario_formato">
            <div class="formulario_dobles" id="textoDniTutor" style="display: none" >DNI Tutor: </div>
	<div class="formulario_dobles_campos">
            <label><input name="dniTutor" type="text" class="campo_texto" id="dniTutor" size="50" style="display: none" >
	</label></div>
	</div>

        <div class="formulario_formato">
            <div class="formulario_dobles" id="textoNombreTutor" style="display: none" >Nombre Tutor: </div>
	<div class="formulario_dobles_campos">
            <label><input name="nombreTutor" type="text" class="campo_texto" id="nombreTutor" size="50" style="display: none" >
	</label></div>
	</div>

        <div class="formulario_formato">
        <div class="formulario_dobles" id="textoApellido1Tutor" style="display: none" >Primer Apellido Tutor: </div>
	<div class="formulario_dobles_campos">
            <label><input name="apellido1Tutor" type="text" class="campo_texto" id="apellido1Tutor" size="50" style="display: none" ></label>
        </div>
	</div>

        <div class="formulario_formato">
        <div class="formulario_dobles" id="textoApellido2Tutor" style="display: none" >Segundo Apellido Tutor: </div>
	<div class="formulario_dobles_campos">
            <label><input name="apellido2Tutor" type="text" class="campo_texto" id="apellido2Tutor" size="50" style="display: none" ></label>
        </div>
	</div>

            <!-- FIN MENOR -->
        


            <!--  NACIONALIDAD -->

       <div class="formulario_formato">
	<div class="formulario_dobles">Pais de nacimiento: </div>
	<div class="formulario_dobles_campos">
            <select name="nacionalidad" id="nacionalidad">
                
                    <option value="Afganistan">Afganistan</option>
                    <option value="Africa Central">Africa Central</option>
                    <option value="Albania">Albania</option>
                    <option value="Alemania">Alemania</option>
                    <option value="Andorra">Andorra</option>
                    <option value="Angola">Angola</option>
                    <option value="Anguilla">Anguilla</option>
                    <option value="Antartida">Antartida</option>
                    <option value="Antigua y Barbuda">Antigua y Barbuda</option>
                    <option value="Arabia Saudita">Arabia Saudita</option>
                    <option value="Argelia">Argelia</option>
                    <option value="Argentina">Argentina</option>
                    <option value="Armenia">Armenia</option>
                    <option value="Aruba">Aruba</option>
                    <option value="Australia">Australia</option>
                    <option value="Austria">Austria</option>
                    <option value="Azerbaiyan">Azerbaiyan</option>
                    <option value="Bahamas">Bahamas</option>
                    <option value="Bahrein">Bahrein</option>
                    <option value="Bangladesh">Bangladesh</option>
                    <option value="Barbados">Barbados</option>
                    <option value="Bielorrusia">Bielorrusia</option>
                    <option value="Belgica">Belgica</option>
                    <option value="Belice">Belice</option>
                    <option value="Benin">Benin</option>
                    <option value="Bermuda">Bermuda</option>
                    <option value="Butan">Butan</option>
                    <option value="Bolivia">Bolivia</option>
                    <option value="Bosnia y Herzegovina">Bosnia y Herzegovina</option>
                    <option value="Botswana">Botswana</option>
                    <option value="Brasil">Brasil</option>
                    <option value="Brunei">Brunei</option>
                    <option value="Bulgaria">Bulgaria</option>
                    <option value="Burkina Faso">Burkina Faso</option>
                    <option value="Burundi">Burundi</option>
                    <option value="Camboya">Camboya</option>
                    <option value="Camerun">Camerun</option>
                    <option value="Canada">Canada</option>
                    <option value="Cabo Verde">Cabo Verde</option>
                    <option value="Ciudad del Vaticano">Ciudad del Vaticano</option>
                    <option value="Chad">Chad</option>
                    <option value="Chile">Chile</option>
                    <option value="China">China</option>
                    <option value="Colombia">Colombia</option>
                    <option value="Comoras">Comoras</option>
                    <option value="Congo">Congo</option>
                    <option value="Corea del Norte">Corea del Norte</option>
                    <option value="Corea del Sur">Corea del Sur</option>
                    <option value="Costa Rica">Costa Rica</option>
                    <option value="Costa de Marfil">Costa de Marfil</option>
                    <option value="Croacia">Croacia</option>
                    <option value="Cuba">Cuba</option>
                    <option value="Chipre">Chipre</option>
                    <option value="Dinamarca">Dinamarca</option>
                    <option value="Dominica">Dominica</option>
                    <option value="Ecuador">Ecuador</option>
                    <option value="Egipto">Egipto</option>
                    <option value="El Salvador">El Salvador</option>
                    <option value="Emiratos Arabes">Emiratos Arabes</option>
                    <option value="Eritrea">Eritrea</option>
                    <option value="Eslovaquia">Eslovaquia</option>
                    <option value="Eslovenia">Eslovenia</option>
                    <option value="España" selected >España</option>
                    <option value="Estados Unidos">Estados Unidos</option>
                    <option value="Estonia">Estonia</option>
                    <option value="Etiopia">Etiopia</option>
                    <option value="Fiji">Fiji</option>
                    <option value="Filipinas">Filipinas</option>
                    <option value="Finlandia">Finlandia</option>
                    <option value="Francia">Francia</option>
                    <option value="Gabon">Gabon</option>
                    <option value="Gambia">Gambia</option>
                    <option value="Georgia">Georgia</option>
                    <option value="Ghana">Ghana</option>
                    <option value="Gibraltar">Gibraltar</option>
                    <option value="Grecia">Grecia</option>
                    <option value="Granada">Granada</option>
                    <option value="Groenlandia">Groenlandia</option>
                    <option value="Guadalupe">Guadalupe</option>
                    <option value="Guam">Guam</option>
                    <option value="Guatemala">Guatemala</option>
                    <option value="Guinea">Guinea</option>
                    <option value="Guinea-bissau">Guinea-bissau</option>
                    <option value="Guinea Ecuatorial">Guinea Ecuatorial</option>
                    <option value="Guyana">Guyana</option>
                    <option value="Guyana Francesa">Guyana Francesa</option>
                    <option value="Haiti">Haiti</option>
                    <option value="Holanda">Holanda</option>
                    <option value="Honduras">Honduras</option>
                    <option value="Hong Kong">Hong Kong</option>
                    <option value="Hungria">Hungria</option>
                    <option value="India">India</option>
                    <option value="Indonesia">Indonesia</option>
                    <option value="Iran">Iran</option>
                    <option value="Irak">Irak</option>
                    <option value="Irlanda">Irlanda</option>
                    <option value="Isla Bouvet">Isla Bouvet</option>
                    <option value="Isla de Coco">Isla de Coco</option>
                    <option value="Isla de Navidad">Isla de Navidad</option>
                    <option value="Isla de Pascua">Isla de Pascua</option>
                    <option value="Isla Norfolk">Isla Norfolk</option>
                    <option value="Islandia">Islandia</option>
                    <option value="Islas Cayman">Islas Cayman</option>
                    <option value="Islas Cook">Islas Cook</option>
                    <option value="Islas Feroe">Islas Feroe</option>
                    <option value="Islas Heard y McDonald">Islas Heard y McDonald</option>
                    <option value="Islas Malvinas">Islas Malvinas</option>
                    <option value="Islas Marianas del Norte">Islas Marianas del Norte</option>
                    <option value="Islas Marshall">Islas Marshall</option>
                    <option value="Islas Pitcairn">Islas Pitcairn</option>
                    <option value="Islas Salomon">Islas Salomon</option>
                    <option value="Islas Turcas y Caicos">Islas Turcas y Caicos</option>
                    <option value="Islas Virgenes">Islas Virgenes</option>
                    <option value="Israel">Israel</option>
                    <option value="Italia">Italia</option>
                    <option value="Jamaica">Jamaica</option>
                    <option value="Japon">Japon</option>
                    <option value="Jordania">Jordania</option>
                    <option value="Kazakhstan">Kazakhstan</option>
                    <option value="Kenia">Kenia</option>
                    <option value="Kiribati">Kiribati</option>
                    <option value="Kosovo">Kosovo</option>
                    <option value="Kuwait">Kuwait</option>
                    <option value="Kirguistan">Kirguistan</option>
                    <option value="Laos">Laos</option>
                    <option value="Letonia">Letonia</option>
                    <option value="Libano">Libano</option>
                    <option value="Lesoto">Lesoto</option>
                    <option value="Liberia">Liberia</option>
                    <option value="Libia">Libia</option>
                    <option value="Liechtenstein">Liechtenstein</option>
                    <option value="Lituania">Lituania</option>
                    <option value="Luxemburgo">Luxemburgo</option>
                    <option value="Macao">Macao</option>
                    <option value="Macedonia">Macedonia</option>
                    <option value="Madagascar">Madagascar</option>
                    <option value="Malawi">Malawi</option>
                    <option value="Malasia">Malasia</option>
                    <option value="Maldivas">Maldivas</option>
                    <option value="Mali">Mali</option>
                    <option value="Malta">Malta</option>
                    <option value="Martinica">Martinica</option>
                    <option value="Mauritania">Mauritania</option>
                    <option value="Mauricio">Mauricio</option>
                    <option value="Mayotte">Mayotte</option>
                    <option value="Mexico">Mexico</option>
                    <option value="Micronesia">Micronesia</option>
                    <option value="Moldavia">Moldavia</option>
                    <option value="Monaco">Monaco</option>
                    <option value="Mongolia">Mongolia</option>
                    <option value="Montenegro">Montenegro</option>
                    <option value="Montserrat">Montserrat</option>
                    <option value="Marruecos">Marruecos</option>
                    <option value="Mozambique">Mozambique</option>
                    <option value="Myanmar">Myanmar</option>
                    <option value="Namibia">Namibia</option>
                    <option value="Nauru">Nauru</option>
                    <option value="Nepal">Nepal</option>
                    <option value="Nicaragua">Nicaragua</option>
                    <option value="Niger">Niger</option>
                    <option value="Nigeria">Nigeria</option>
                    <option value="Niue">Niue</option>
                    <option value="Noruega">Noruega</option>
                    <option value="Nueva Caledonia">Nueva Caledonia</option>
                    <option value="166">Nueva Zelanda</option>
                    <option value="Oman">Oman</option>
                    <option value="Pakistan">Pakistan</option>
                    <option value="Palau">Palau</option>
                    <option value="Palestina">Palestina</option>
                    <option value="Panama">Panama</option>
                    <option value="Papua Nueva Guinea">Papua Nueva Guinea</option>
                    <option value="Paraguay">Paraguay</option>
                    <option value="Peru">Peru</option>
                    <option value="Polinesia Francesa">Polinesia Francesa</option>
                    <option value="Polonia">Polonia</option>
                    <option value="Portugal">Portugal</option>
                    <option value="Puerto Rico">Puerto Rico</option>
                    <option value="Qatar">Qatar</option>
                    <option value="Republica Checa">Republica Checa</option>
                    <option value="Republica Dominicana">Republica Dominicana</option>
                    <option value="Reino Unido">Reino Unido</option>
                    <option value="Reunion">Reunion</option>
                    <option value="Rumania">Rumania</option>
                    <option value="Rusia">Rusia</option>
                    <option value="Ruanda">Ruanda</option>
                    <option value="Sahara Occidental">Sahara Occidental</option>
                    <option value="Samoa">Samoa</option>
                    <option value="Santa Helena">Santa Helena</option>
                    <option value="San Cristobal y Nieves">San Cristobal y Nieves</option>
                    <option value="Santa Lucia">Santa Lucia</option>
                    <option value="San Pedro y Miguelon">San Pedro y Miguelon</option>
                    <option value="San Vicente y las Granadinas">San Vicente y las Granadinas</option>
                    <option value="Samoa">Samoa</option>
                    <option value="San Marino">San Marino</option>
                    <option value="Santo Tome y Princip">Santo Tome y Principe</option>
                    <option value="Senegal">Senegal</option>
                    <option value="Serbia y Montenegro">Serbia y Montenegro</option>
                    <option value="Seychelles">Seychelles</option>
                    <option value="Sierra Leona">Sierra Leona</option>
                    <option value="Singapur">Singapur</option>
                    <option value="Siria">Siria</option>
                    <option value="Somalia">Somalia</option>
                    <option value="Sri Lanka">Sri Lanka</option>
                    <option value="Sudafrica">Sudafrica</option>
                    <option value="Sudan">Sudan</option>
                    <option value="Surinam">Surinam</option>
                    <option value="Suazilandia">Suazilandia</option>
                    <option value="Suecia">Suecia</option>
                    <option value="Suiza">Suiza</option>
                    <option value="Taiwan">Taiwan</option>
                    <option value="Tayikistan">Tayikistan</option>
                    <option value="Tanzania">Tanzania</option>
                    <option value="Tailandia">Tailandia</option>
                    <option value="Timor Oriental">Timor Oriental</option>
                    <option value="Togo">Togo</option>
                    <option value="Tokelau">Tokelau</option>
                    <option value="Tonga">Tonga</option>
                    <option value="Trinidad y Tobago">Trinidad y Tobago</option>
                    <option value="Tunez">Tunez</option>
                    <option value="Turquia">Turquia</option>
                    <option value="Turkmenistan">Turkmenistan</option>
                    <option value="Tuvalu">Tuvalu</option>
                    <option value="Uganda">Uganda</option>
                    <option value="Ukrania">Ukrania</option>
                    <option value="Uruguay">Uruguay</option>
                    <option value="Uzbekistan">Uzbekistan</option>
                    <option value="Vanuatu">Vanuatu</option>
                    <option value="Venezuela">Venezuela</option>
                    <option value="Vietnam">Vietnam</option>
                    <option value="Wallis y Futuna">Wallis y Futuna</option>
                    <option value="Yemen">Yemen</option>
                    <option value="Yibuti">Yibuti</option>
                    <option value="Zambia">Zambia</option>
                    <option value="Zimbaue">Zimbaue</option>
                    <option value="Otro">Otro</option>
             
            </select></div>
	</div>

            <!--  FIN NACIONALIDAD -->
            

        <div class="formulario_formato">

	<div class="formulario_dobles">
            <input type="checkbox" name="residente" value="On" checked /> Residente<br />
        </div>
            <div class="formulario_dobles"></div>
	</div>

           

        </div>
            <div class="ajustar"></div>
 	</div>



       <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Federado</div>
  		<div class="msg_body_gris">

        <div class="formulario_formato">

	<div class="formulario_dobles">
            <input type="checkbox" name="handicap" value="On" onclick="activarHandicap()" /> Handicap<br />
        </div>
            <div class="formulario_dobles"></div>
	</div>


        <div class="formulario_formato">
        <div class="formulario_dobles" id="textoNumHandicap" style="display: none">Numero Handicap: </div>
	<div class="formulario_dobles_campos">
            <label><input name="numHandicap" type="text" class="campo_texto" id="numHandicap" size="5" value="36" style="display: none" >
	</label></div>
	</div>

        <div class="formulario_formato">

	<div class="formulario_dobles">
            <input type="checkbox" name="homologada" value="On" checked /> Homologada<br />
        </div>
            <div class="formulario_dobles"></div>
	</div>
                    

       <div class="formulario_formato">
	<div class="formulario_dobles">Grupo: </div>
	<div class="formulario_dobles_campos">
            <select name="grupo" id="grupo">

             <%
                if (listaGrupos != null)
                {
                    for(int i = 0; i<listaGrupos.size();i++)
                    {
             %>
                        <option name="grupo" value="<%=listaGrupos.get(i).getIdGrupo()%>" ><%=listaGrupos.get(i).getNombre()%></option>
           <%
                    }
                }
            %>
            </select></div>
	</div>

                    
        <div class="formulario_formato">
	<div class="formulario_dobles">Forma de Pago: </div>
	<div class="formulario_dobles_campos">
            <select name="formaPago" id="formaPago">
                <option name="formaPago" value="0" >--</option>
                <option name="formaPago" value="domiciliacion" >Domiciliacion</option>
                <option name="formaPago" value="transferencia" >Transferencia</option>
            </select></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Numero de Cuenta: </div>
	<div class="formulario_dobles_campos">
            <label><input name="numCuenta" type="text" class="campo_texto" id="numCuenta" ></label>
            
        </div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Estado Licencia: </div>
	<div class="formulario_dobles_campos">
            <select name="estadoLicencia" id="estadoLicencia">

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


        <div class="formulario_formato">
	<div class="formulario_dobles">Fecha Pre Alta: </div>
	<div class="formulario_dobles_campos">
             <label><input name="fechaPreAlta" type="text" class="campo_texto" id="f_date_s" readonly="1" />
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
	<div class="formulario_dobles">Fecha Alta: </div>
	<div class="formulario_dobles_campos">
             <label><input name="fechaAlta" type="text" class="campo_texto" id="f_date_t" readonly="1" />
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





        <div class="formulario_formato">

	<div class="formulario_dobles_campos">
            <input type="checkbox" name="nota1" value="On" /> No deseo recibir información de la RFEG, ni de la FVG, ni F.T <br />
            <input type="checkbox" name="nota2" value="On" /> No deseo recibir información de los patrocinadores de la RFEG, ni de la FVG ni F.T <br />
            <input type="checkbox" name="nota3" value="On" checked /> No deseo recibir información sobre la Tarjeta Visa Golf <br />
        </div>
            <div class="formulario_dobles"></div>
	</div>


        <div class="formulario_botones">
            <label><input name="enviar" type="submit" class="boton" id="alta" value="ALTA" onclick="return validar()" ></label>
           <label><input name="enviar" type="submit" class="boton" id="alta" value="Siguiente" onclick="return validar()" ></label>
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

