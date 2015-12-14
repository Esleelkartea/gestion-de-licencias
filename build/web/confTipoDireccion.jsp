<%-- 
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>

<%@page import="com.Negocio.TipoDireccion"%>
<%@page import="com.Negocio.Colectivo"%>
<%@page import="java.util.ArrayList"%>
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

    function validar()
    {
        var tipoDireccion = document.getElementById("tipo").value;
        if (tipoDireccion.length == 0)
        {
            alert("Debes introducir un Tipo de Direccion");
            return false;
        }
        else
        {
            return true;
        }
    }

    function validarBaja()
    {
        var idTipoDireccion = document.getElementById("idTipoDireccion").value;
        if (idTipoDireccion.length == 0 || idTipoDireccion == "/")
        {
            alert("Debes seleccionar un Tipo de Direccion para dar de baja");
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
		<li><a id="activo" href="#">CONFIGURACIÓN</a></li>
                <li><a href="informes.html">INFORMES</a></li>
                <li><a href="consultaServlet">CONSULTA</a></li>
                <li><a href="confDEActividadServlet">DEPORTE ESCOLAR</a></li>
		<li><a href="http://www.bizkaiagolf.com">WEB</a></li>
	  </ul>
        </div>
         <div id="submenu">
            <ul id="lista_submenu">
                        <li><a href="confAccionServlet">Acciones</a></li>
                        <li><a href="confAdjuntoServlet">Adjuntos</a></li>
                        <li><a href="confCategoriaServlet">Categorias</a></li>
                        <li><a href="confColectivoServlet">Colectivos</a></li>
                        <li><a href="confConsultaServlet">Consultas</a></li>
                        <li><a href="confEntidadServlet">Entidades</a></li>
                        <li><a href="confEstadoEconomicoServlet">Estado económico</a></li>
                        <li><a href="confEstadoLicenciaServlet">Estado Licencia</a></li>
                        <li><a href="confGrupoServlet">Grupos</a></li>
                        <li><a href="confParentescoServlet">Parentescos</a></li>
                        <li><a href="confPerfilServlet">Perfiles</a></li>
                        <li><a href="confPlantillaCartaServlet">Plantilla carta</a></li>
                        <li><a href="confPlantillaEmailServlet">Plantilla email</a></li>
                        <li><a href="confPlantillaSMSServlet">Plantilla SMS</a></li>
                        <li><a href="confRazonBajaServlet">Razón baja</a></li>
                        <li><a href="confTipoCanalServlet">Tipo canal</a></li>
                        <li><a id="activo" href="#">Tipo dirección</a></li>
                        <li><a href="confTipoEmailServlet">Tipo email</a></li>
                        <li><a href="confTipoTelefonoServlet">Tipo telefono</a></li>
            </ul>
	</div>

     <%
            ArrayList<TipoDireccion> listaTipoDireccion = (ArrayList<TipoDireccion>)session.getAttribute("listaTipoDirecciones");
     %>

 	<div id="principal">

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> CONFIGURACI&Oacute;N TIPOS DIRECCION</h1>
     

           <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Tipos Direccion</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0">


	<thead>

	<tr>
            <th class="titulos_tablas">Tipo Direccion</th>
        </tr>
	</thead>

        <tbody>

            <% if (listaTipoDireccion != null)
               {
                    for (int i = 0; i<listaTipoDireccion.size(); i++)
                    {
            %>
            <tr>
                <td class="texto_tablas"><a href="confTipoDireccionServlet?var=<%=listaTipoDireccion.get(i).getIdTipoDireccion()%>"><%=listaTipoDireccion.get(i).getTipo()%></a></td>
            </tr> 

            <%
                    }
            %>
                <tr>
                    <td class="texto_tablas">&nbsp;</td>
                </tr>
            <%
                }
                else
                {
            %>

            <tr>
                <td class="texto_tablas">&nbsp;</td>
            </tr>
            <%
                }
            %>
	</tbody>

	</table>
	</div>

        <%
        TipoDireccion unTipoDireccion = (TipoDireccion)session.getAttribute("unTipoDireccion");
        String idTipoDireccion = "";
        String tipo = "";

        if (unTipoDireccion != null)
        {
            idTipoDireccion = String.valueOf(unTipoDireccion.getIdTipoDireccion());
            tipo = unTipoDireccion.getTipo();
        }
       %>

       <form autocomplete="off" action="confTipoDireccionMIBServlet" method="post">
           
	<div class="formulario_formato">
	<div class="formulario_dobles">Tipo Direccion: </div>
	<div class="formulario_dobles_campos">
            <label><input name="tipo" type="text" class="campo_texto" id="tipo" size="100" value="<%=tipo%>" >
	</label></div>
	</div>
       
              
        <input type="hidden"  id="idTipoDireccion" name="idTipoDireccion" value=<%=idTipoDireccion%> /><br/>

	<div class="formulario_botones">
	<label><input name="enviar" type="submit" class="boton" id="alta" value="ALTA" onclick="return validar()">
	</label>
	<label><input name="enviar" type="submit" class="boton" id="baja" value="BAJA" onclick="return validarBaja()">
	</label>
	<label><input name="enviar" type="submit" class="boton" id="modificacion" value="MODIFICACION" onclick="return validar()">
	</label>
	</div>

        </form>

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

