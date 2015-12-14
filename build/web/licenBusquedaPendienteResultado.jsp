<%-- 
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>

<%@page import="com.dal.EntidadDAL"%>
<%@page import="com.Negocio.Entidad"%>
<%@page import="com.dal.TipoBajaDAL"%>
<%@page import="com.Negocio.TipoBaja"%>
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
            ArrayList<Federado> listaFederados = (ArrayList<Federado>)session.getAttribute("listaFederado");
     %>

 	<div id="principal">

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> Busqueda Bajas</h1>
     

           <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Licencias Pendientes</div>
  		<div class="msg_body_gris">

        <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0">


	<thead>

	<tr>
            <th class="titulos_tablas">Entidad</th>
            <th class="titulos_tablas">Num. Federado</th>
            <th class="titulos_tablas">Nombre</th>
            <th class="titulos_tablas">Primer Apellido</th>
            <th class="titulos_tablas">Segundo Apellido</th>
            <th class="titulos_tablas">DNI</th>
            <th class="titulos_tablas">Fecha Pre Alta</th>
        </tr>
	</thead>

        <tbody>

            <% if (listaFederados != null)
               {
                    String fecha;
                    Entidad unaEntidad = null;
                    EntidadDAL entidadDAL = new EntidadDAL();
                    for (int i = 0; i<listaFederados.size(); i++)
                    {
                        fecha = String.valueOf(listaFederados.get(i).getFechaPreAlta());
                        String[] arrFecha = fecha.split("-");
                        fecha = arrFecha[2] + "-" + arrFecha[1] + "-" + arrFecha[0];

                        unaEntidad = entidadDAL.getEntidad(listaFederados.get(i).getIdEntidad());
            %>
            <tr>
                <td class="texto_tablas"><%=unaEntidad.getDesCastellano()%></td>
                <td class="texto_tablas"><%=listaFederados.get(i).getNumFederado()%></td>
                <td class="texto_tablas"><%=listaFederados.get(i).getNombre()%></td>
                <td class="texto_tablas"><%=listaFederados.get(i).getApellido1()%></td>
                <td class="texto_tablas"><%=listaFederados.get(i).getApellido2()%></td>
                <td class="texto_tablas"><%=listaFederados.get(i).getDni()%></td>
                <td class="texto_tablas"><%=fecha%></td>
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
       
       <form autocomplete="off" action="excelPendientes.jsp" method="post">

	<div class="formulario_botones">
            <label><input name="enviar" type="submit" class="boton" id="alta" value="Exportar a Excel"></label>
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

