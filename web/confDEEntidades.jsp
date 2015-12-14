<%-- 
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>

<%@page import="com.Negocio.DEEntidad"%>
<%@page import="com.Negocio.Entidad"%>
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
        var nombre = document.getElementById("entidad").value;
        var numero = document.getElementById("numero").value;
        if (nombre.length == 0)
        {
            alert("Debes introducir el nombre de la Entidad");
            return false;
        }
        else
        {
            if(numero.length == 0)
            {
                alert("Debes introducir el numero de la Entidad");
            }
            else
            {
                if(isNaN(numero))
                {
                    alert("El número de la Entidad debe ser un dato numerico");
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }
    }

    function validarBaja()
    {
        var idDEEntidad = document.getElementById("idDEEntidad").value;
        if (idDEEntidad.length == 0 || idDEEntidad == "/")
        {
            alert("Debes seleccionar una Entidad para dar de baja");
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
                        <li><a href="confDEActividadServlet">Actividad</a></li>
                        <li><a id="activo" href="#">Entidad</a></li>
                        <li><a href="confDECursoServlet">Curso</a></li>
                        <li><a href="confDEBusquedaServlet">Busqueda</a></li>
            </ul>
	</div>
     <%
            ArrayList<DEEntidad> listaDEEntidad = (ArrayList<DEEntidad>)session.getAttribute("listaDEEntidad");
     %>

 	<div id="principal">

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> CONFIGURACI&Oacute;N ENTIDADES (Colegios)</h1>
     

           <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Entidades (Colegios)</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0">


	<thead>

	<tr>
            <th class="titulos_tablas">Entidad</th>
            <th class="titulos_tablas">N&uacute;mero de Entidad</th>
        </tr>
	</thead>

        <tbody>

            <% if (listaDEEntidad != null)
               {
                    for (int i = 0; i<listaDEEntidad.size(); i++)
                    {
            %>
            <tr>
                <td class="texto_tablas"><a href="confDEEntidadServlet?var=<%=listaDEEntidad.get(i).getIdDEEntidad()%>"><%=listaDEEntidad.get(i).getEntidad()%></a></td>
                <td class="texto_tablas"><a href="confDEEntidadServlet?var=<%=listaDEEntidad.get(i).getIdDEEntidad()%>"><%=listaDEEntidad.get(i).getNumEntidad()%></a></td>
            </tr>

            <%
                    }
            %>
                <tr>
                    <td class="texto_tablas">&nbsp;</td>
                    <td class="texto_tablas">&nbsp;</td>
                </tr>
            <%
                }
                else
                {
            %>

            <tr>
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
        DEEntidad unDEEntidad = (DEEntidad)session.getAttribute("unaDEEntidad");
        String idDEEntidad = "";
        String entidad = "";
        String numEntidad = "";

        if (unDEEntidad != null)
        {
            idDEEntidad = String.valueOf(unDEEntidad.getIdDEEntidad());
            entidad = unDEEntidad.getEntidad();
            numEntidad = String.valueOf(unDEEntidad.getNumEntidad());
        }
       %>

       <form autocomplete="off" action="confDEEntidadMIBServlet" method="post">
           
	<div class="formulario_formato">
            <div class="formulario_dobles">Entidad: </div>
	<div class="formulario_dobles_campos">
            <label><input name="entidad" type="text" class="campo_texto" id="entidad" size="100" value="<%=entidad%>" >
	</label></div>
	</div>

        <div class="formulario_formato">
            <div class="formulario_dobles">N&uacute;mero: </div>
	<div class="formulario_dobles_campos">
            <label><input name="numero" type="text" class="campo_texto" id="numero" size="100" value="<%=numEntidad%>" >
	</label></div>
	</div>
                     
       <input type="hidden" id="idDEEntidad"  name="idDEEntidad" value=<%=idDEEntidad%> /><br/>

	<div class="formulario_botones">
            <label><input name="enviar" type="submit" class="boton" id="alta" value="ALTA" onclick="return validar()" >
	</label>
	<label><input name="enviar" type="submit" class="boton" id="baja" value="BAJA" onclick="return validarBaja()" >
	</label>
	<label><input name="enviar" type="submit" class="boton" id="modificacion" value="MODIFICACION" onclick="return validar()" >
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

