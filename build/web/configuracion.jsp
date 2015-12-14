<%-- 
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Federaci&oacute;n de Golf de Vizcaya</title>
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
            <img src="imagenes/loguito.png" alt="Federaci&oacute;n de Golf de Bizkaia" width="123" height="115" style="float:left;">
            <h1 style="float:right;">Federación de Golf de Bizkaia</h1><br/>
            <h1 style="float:right;">Bizkaiko Golf federazioa</h1>
	</div>

	<div id="menu">
		<ul id="lista_menu">
		<li><a href="federados.html">FEDERADOS</a></li>
		<li id="activo"><a href="configuracion.html">CONFIGURACIÓN</a></li>
        <li><a href="informes.html">INFORMES</a></li>
        <li><a href="usuarios.html">USUARIOS</a></li>
		<li><a href="#">WEB</a></li>
	  </ul>
	</div>

 	<div id="principal">

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> CONFIGURACI&Oacute;N</h1>

	
        <form autocomplete="off" action="" method="post">
        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Estados de la Licencia</div>
  	<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
            <th class="titulos_tablas">Estados de la Licencia</th>
        </tr>
	</thead>

	<tbody>	
            <tr>
                <td class="texto_tablas">&nbsp;</td>
            </tr>
            <tr>
                <td class="texto_tablas">&nbsp;</td>
            </tr>
	</tbody>
	</table>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Estado Licencia:</div>
	<div class="formulario_dobles_campos">
	<label><input name="licenciaEstado" type="text" class="campo_texto" id="licenciaEstado" size="100">
	</label></div>
	</div>

	<div class="formulario_botones">
	  <label><input name="alta" type="submit" class="boton" id="enviar" value="ALTA">
	</label>
	<label><input name="baja" type="submit" class="boton" id="enviar" value="BAJA">
	</label>
	<label><input name="modificacion" type="submit" class="boton" id="enviar" value="MODIFICACI&Oacute;N">
	</label>
	</div>

    </div>
             <div class="ajustar"></div>
 	</div>
        </form>

    <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Colectivos</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0" summary="Tabla de datos de categorías de Incidencias">


	<thead>

	<tr>

    <th class="titulos_tablas">Nombre Colectivos</th>
    </tr>
	</thead>

	<tbody>
	<tr>

    <td class="texto_tablas">xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	</tbody>
	</table>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Colectivo: </div>
	<div class="formulario_dobles_campos">
	<label><input name="colectivo" type="text" class="campo_texto" id="colectivo" size="100">
	</label></div>
	</div>


	<div class="formulario_botones">
	<label><input name="alta" type="submit" class="boton" id="enviar" value="ALTA">
	</label>
	<label><input name="baja" type="submit" class="boton" id="enviar" value="BAJA">
	</label>
	<label><input name="modificacion" type="submit" class="boton" id="enviar" value="MODIFICACI&Oacute;N">
	</label>
	</div>



        </div>
         <div class="ajustar"></div>
 	</div>

    <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Categor&iacute;as Jugadores</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0" summary="Tabla de datos de categorías de Incidencias">


	<thead>

	<tr>

    <th class="titulos_tablas">Categor&iacute;as de Jugadores</th>
    </tr>
	</thead>

	<tbody>
	<tr>

    <td class="texto_tablas">xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	</tbody>
	</table>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Categor&iacute;a: </div>
	<div class="formulario_dobles_campos">
	<label><input name="categoria" type="text" class="campo_texto" id="categoria" size="100">
	</label></div>
	</div>

    <div class="formulario_formato">
	<div class="formulario_dobles">Edad Inicio: </div>
	<div class="formulario_dobles_campos">
	<label><input name="edadInicio" type="text" class="campo_texto" id="edadInicio" size="40">
	</label></div>
	</div>

    <div class="formulario_formato">
	<div class="formulario_dobles">Edad Fin:</div>
	<div class="formulario_dobles_campos">
	<label><input name="edadFin" type="text" class="campo_texto" id="edadFin" size="40">
	</label></div>
	</div>



	<div class="formulario_botones">
	<label><input name="alta" type="submit" class="boton" id="enviar" value="ALTA">
	</label>
	<label><input name="baja" type="submit" class="boton" id="enviar" value="BAJA">
	</label>
	<label><input name="modificacion" type="submit" class="boton" id="enviar" value="MODIFICACI&Oacute;N">
	</label>
	</div>
        </div>
         <div class="ajustar"></div>
 	</div>

    <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Entidades (Clubes)</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0" summary="Tabla de datos de categorías de Incidencias">


	<thead>

	<tr>

    <th class="titulos_tablas">Nombre de la Entidad (Club)</th>
    </tr>
	</thead>

	<tbody>
	<tr>

    <td class="texto_tablas">xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	</tbody>
	</table>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Entidad (Club): </div>
	<div class="formulario_dobles_campos">
	<label><input name="entidad" type="text" class="campo_texto" id="entidad" size="100">
	</label></div>
	</div>


	<div class="formulario_botones">
	<label><input name="alta" type="submit" class="boton" id="enviar" value="ALTA">
	</label>
	<label><input name="baja" type="submit" class="boton" id="enviar" value="BAJA">
	</label>
	<label><input name="modificacion" type="submit" class="boton" id="enviar" value="MODIFICACI&Oacute;N">
	</label>
	</div>
        </div>
         <div class="ajustar"></div>
 	</div>

    <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Estados Econ&oacute;micos</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0" summary="Tabla de datos de categorías de Incidencias">


	<thead>

	<tr>

    <th class="titulos_tablas">Estado Econ&oacute;mico</th>
    </tr>
	</thead>

	<tbody>
	<tr>

    <td class="texto_tablas">xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	</tbody>
	</table>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Estado econ&oacute;mico: </div>
	<div class="formulario_dobles_campos">
	<label><input name="estadoEconomico" type="text" class="campo_texto" id="estadoEconomico" size="140">
	</label></div>
	</div>



	<div class="formulario_botones">
	<label><input name="alta" type="submit" class="boton" id="enviar" value="ALTA">
	</label>
	<label><input name="baja" type="submit" class="boton" id="enviar" value="BAJA">
	</label>
	<label><input name="modificacion" type="submit" class="boton" id="enviar" value="MODIFICACI&Oacute;N">
	</label>
	</div>
        </div>
         <div class="ajustar"></div>
 	</div>

    <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Parentescos (Familias)</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0" summary="Tabla de datos de categorías de Incidencias">


	<thead>

	<tr>

    <th class="titulos_tablas">Tipos de Parentesco</th>
    </tr>
	</thead>

	<tbody>
	<tr>

    <td class="texto_tablas">xxxxxxxxxxxxxxxxxxxxxxxx</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	</tbody>
	</table>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Parentesco: </div>
	<div class="formulario_dobles_campos">
	<label><input name="parentesco" type="text" class="campo_texto" id="parentesco" size="100">
	</label></div>
	</div>


	<div class="formulario_botones">
	<label><input name="alta" type="submit" class="boton" id="enviar" value="ALTA">
	</label>
	<label><input name="baja" type="submit" class="boton" id="enviar" value="BAJA">
	</label>
	<label><input name="modificacion" type="submit" class="boton" id="enviar" value="MODIFICACI&Oacute;N">
	</label>
	</div>

    </div>
         <div class="ajustar"></div>
 	</div>

    <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Categor&iacute;as de Acciones</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0" summary="Tabla de datos de categorías de Incidencias">


	<thead>

	<tr>

    <th class="titulos_tablas">Categor&iacute;as de Acciones</th>
    </tr>
	</thead>

	<tbody>
	<tr>

    <td class="texto_tablas">xxxxxxxxxxxxxxxxxxxxxxxx</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	</tbody>
	</table>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Categor&iacute;a: </div>
	<div class="formulario_dobles_campos">
	<label><input name="categoria" type="text" class="campo_texto" id="categoria" size="100">
	</label></div>
	</div>

	<div class="formulario_botones">
	<label><input name="alta" type="submit" class="boton" id="enviar" value="ALTA">
	</label>
	<label><input name="baja" type="submit" class="boton" id="enviar" value="BAJA">
	</label>
	<label><input name="modificacion" type="submit" class="boton" id="enviar" value="MODIFICACI&Oacute;N">
	</label>
	</div>

    </div>
         <div class="ajustar"></div>
 	</div>

        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/bullet_toggle_plus.png" width="16" height="16" />Categor&iacute;as de Adjuntos</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0" summary="Tabla de datos de categorías de Incidencias">


	<thead>

	<tr>

    <th class="titulos_tablas">Categor&iacute;as de Adjuntos</th>
    </tr>
	</thead>

	<tbody>
	<tr>

    <td class="texto_tablas">xxxxxxxxxxxxxxxxxxxxxxxx</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	</tbody>
	</table>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Categor&iacute;a adjunto: </div>
	<div class="formulario_dobles_campos">
	<label><input name="adjuntoCategoria" type="text" class="campo_texto" id="adjuntoCategoria" size="100">
	</label></div>
	</div>

	<div class="formulario_botones">
	<label><input name="alta" type="submit" class="boton" id="enviar" value="ALTA">
	</label>
	<label><input name="baja" type="submit" class="boton" id="enviar" value="BAJA">
	</label>
	<label><input name="modificacion" type="submit" class="boton" id="enviar" value="MODIFICACI&Oacute;N">
	</label>
	</div>

    </div>
             <div class="ajustar"></div>
 	</div>

        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/bullet_toggle_plus.png" width="16" height="16" />Gesti&oacute;n de Plantillas Email</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0" summary="Tabla de datos de categorías de Incidencias">


	<thead>

	<tr>

    <th class="titulos_tablas">Plantillas Email</th>
    <th class="titulos_tablas">Ficheros Plantillas</th>
    </tr>
	</thead>

	<tbody>
	<tr>

    <td class="texto_tablas">xxxxxxxxxxxxxxxxxxxxxxxx</td>
    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    <td class="texto_tablas">&nbsp;</td>
    </tr>
	</tbody>
	</table>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Nombre plantilla:</div>
	<div class="formulario_dobles_campos">
	<label><input name="plantillasNombre" type="text" class="campo_texto" id="plantillasNombre" size="100">
	</label></div>
	</div>

    <div class="formulario_formato">
	<div class="formulario_dobles">Adjuntar plantilla:</div>
	<div class="formulario_dobles_campos">
	<label><input name="plantilla" type="file" id="plantilla" /></label></div>
	</div>

	<div class="formulario_botones">
	<label><input name="alta" type="submit" class="boton" id="enviar" value="ALTA">
	</label>
	<label><input name="baja" type="submit" class="boton" id="enviar" value="BAJA">
	</label>
	<label><input name="modificacion" type="submit" class="boton" id="enviar" value="MODIFICACI&Oacute;N">
	</label>
	</div>

    </div>
             <div class="ajustar"></div>
 	</div>

        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/bullet_toggle_plus.png" width="16" height="16" />Tipolog&iacute;a de Env&iacute;os (Tipos de Cartas)</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0" summary="Tabla de datos de categorías de Incidencias">


	<thead>

	<tr>

    <th class="titulos_tablas">Tipos de Cartas</th>
    <th class="titulos_tablas">Ficheros Cartas</th>
    </tr>
	</thead>

	<tbody>
	<tr>

    <td class="texto_tablas">xxxxxxxxxxxxxxxxxxxxxxxx</td>
    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    <td class="texto_tablas">&nbsp;</td>
    </tr>
	</tbody>
	</table>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Tipo carta:</div>
	<div class="formulario_dobles_campos">
	<label><input name="tipoCarta" type="text" class="campo_texto" id="tipoCarta" size="100">
	</label></div>
	</div>

    <div class="formulario_formato">
	<div class="formulario_dobles">Adjuntar plantilla:</div>
	<div class="formulario_dobles_campos">
	<label><input name="plantilla" type="file" id="plantilla" /></label></div>
	</div>

	<div class="formulario_botones">
	<label><input name="alta" type="submit" class="boton" id="enviar" value="ALTA">
	</label>
	<label><input name="baja" type="submit" class="boton" id="enviar" value="BAJA">
	</label>
	<label><input name="modificacion" type="submit" class="boton" id="enviar" value="MODIFICACI&Oacute;N">
	</label>
	</div>

    </div>
             <div class="ajustar"></div>
 	</div>

        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/bullet_toggle_plus.png" width="16" height="16" />Tipos SMS</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0" summary="Tabla de datos de categorías de Incidencias">


	<thead>

	<tr>

    <th class="titulos_tablas">Tipos de SMS</th>
    </tr>
	</thead>

	<tbody>
	<tr>

    <td class="texto_tablas">xxxxxxxxxxxxxxxxxxxxxxxx</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	</tbody>
	</table>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Tipo SMS: </div>
	<div class="formulario_dobles_campos">
	<label><input name="SMS" type="text" class="campo_texto" id="SMS" size="100">
	</label></div>
	</div>

    <div class="formulario_formato">
	<div class="formulario_dobles">Texto tipo:</div>
	<div class="formulario_dobles_campos">
	<label>
	  <textarea name="SMS" cols="100" rows="2" class="campo_texto" id="SMS"></textarea>
	</label></div>
	</div>

	<div class="formulario_botones">
	<label><input name="alta" type="submit" class="boton" id="enviar" value="ALTA">
	</label>
	<label><input name="baja" type="submit" class="boton" id="enviar" value="BAJA">
	</label>
	<label><input name="modificacion" type="submit" class="boton" id="enviar" value="MODIFICACI&Oacute;N">
	</label>
	</div>

    </div>
             <div class="ajustar"></div>
 	</div>

    <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/bullet_toggle_plus.png" width="16" height="16" />Gestión de Bajas</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0" summary="Tabla de datos de categorías de Incidencias">


	<thead>

	<tr>

    <th class="titulos_tablas">Razones Baja</th>
    </tr>
	</thead>

	<tbody>
	<tr>

    <td class="texto_tablas">xxxxxxxxxxxxxxxxxxxxxxxx</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	<tr>


    <td class="texto_tablas">&nbsp;</td>
    </tr>
	</tbody>
	</table>
	</div>

	<div class="formulario_formato">
	<div class="formulario_dobles">Raz&oacute;n baja:</div>
	<div class="formulario_dobles_campos">
	<label><input name="razonBaja" type="text" class="campo_texto" id="razonBaja" size="100">
	</label></div>
	</div>


	<div class="formulario_botones">
	<label><input name="alta" type="submit" class="boton" id="enviar" value="ALTA">
	</label>
	<label><input name="baja" type="submit" class="boton" id="enviar" value="BAJA">
	</label>
	<label><input name="modificacion" type="submit" class="boton" id="enviar" value="MODIFICACI&Oacute;N">
	</label>
	</div>

    </div>
         <div class="ajustar"></div>
 	</div>

	

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

