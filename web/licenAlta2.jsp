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

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> LICENCIA Paso 2</h1>
    <%
         ArrayList<EstadoEconomico> listaEstadoEconomico = (ArrayList<EstadoEconomico>)session.getAttribute("listaEstadoEconomico");
         ArrayList<EstadoLicencia> listaEstadoLicencia = (ArrayList<EstadoLicencia>)session.getAttribute("listaEstadoLicencia");
         ArrayList<Entidad> listaEntidad = (ArrayList<Entidad>)session.getAttribute("listaEntidad");

         //Modificacion
         ArrayList<TipoTelefono> listaTipoTelefono = (ArrayList<TipoTelefono>)session.getAttribute("listaTipoTelefono");
         ArrayList<TipoEmail> listaTipoEmail = (ArrayList<TipoEmail>)session.getAttribute("listaTipoEmail");
         ArrayList<TipoDireccion> listaTipoDireccion = (ArrayList<TipoDireccion>)session.getAttribute("listaTipoDireccion");



         Entidad unaEntidad = (Entidad)session.getAttribute("unaEntidad");
         Federado unFederado = (Federado)session.getAttribute("unFederado");
         Grupo unGrupo = (Grupo)session.getAttribute("unGrupo");
         EstadoLicencia estadoLicencia = (EstadoLicencia)session.getAttribute("unEstadoLicencia");
         EstadoEconomico estadoEconomico = (EstadoEconomico)session.getAttribute("unEstadoEconomico");

         
       %>

       <!-- Alta Previa -->
       <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Federado</div>
  		<div class="msg_body_gris">

          <div class="formulario_formato">
	<div class="formulario_dobles">Entidad: </div>
	<div class="formulario_dobles_campos">
            <label><%=unaEntidad.getDesCastellano()%>
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Grupo: </div>
	<div class="formulario_dobles_campos">
            <label><%=unGrupo.getNombre()%>
	</label></div>
	</div>

         <div class="formulario_formato">
	<div class="formulario_dobles">Numero Federado: </div>
	<div class="formulario_dobles_campos">
            <label><%=unFederado.getNumFederado()%>
	</label></div>
	</div>

         <%
                if(unFederado.isHomolagada())
                {
            %>
                    <div class="formulario_formato">
                        <div class="formulario_dobles">Homologada</div>
                    </div>
            <%
                }
                else
                {
            %>
                    <div class="formulario_formato">
                        <div class="formulario_dobles">No Homologada</div>
                    </div>
            <%
                }
            %>


         <%
                String strFechaPreAlta = String.valueOf(unFederado.getFechaPreAlta());
                String[] arrFechaPreAlta = strFechaPreAlta.split("-");
                strFechaPreAlta = arrFechaPreAlta[2] + "-" + arrFechaPreAlta[1] + "-" + arrFechaPreAlta[1];
         %>

        <div class="formulario_formato">
	<div class="formulario_dobles">Fecha Pre Alta: </div>
	<div class="formulario_dobles_campos">
            <label><%=strFechaPreAlta%></label>
        </div>
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


            <%
                String strFechaNac = String.valueOf(unFederado.getFechaNac());
                String[] arrFechaNac = strFechaNac.split("-");
                strFechaNac = arrFechaNac[2] + "-" + arrFechaNac[1] + "-" + arrFechaNac[1];
            %>

        <div class="formulario_formato">
	<div class="formulario_dobles">Fecha Nacimiento: </div>
	<div class="formulario_dobles_campos">
            <label><%=strFechaNac%></label>
        </div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Sexo: </div>
	<div class="formulario_dobles_campos">
            <label><%=unFederado.getSexo()%></label>
        </div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Nacionalidad: </div>
	<div class="formulario_dobles_campos">
            <label><%=unFederado.getNacionalidad()%></label>
        </div>
	</div>

            <%
                if(unFederado.isResidente())
                {
            %>
                    <div class="formulario_formato">
                        <div class="formulario_dobles">Residente</div>
                    </div>
            <%
                }
                else
                {
            %>
                    <div class="formulario_formato">
                        <div class="formulario_dobles">No Residente</div>
                    </div>
            <%
                }
            %>


            <!-- Menor -->
            <%
                if(unFederado.isTutor())
                {
            %>
                    <div class="formulario_formato">
                        <div class="formulario_dobles">Menor</div>
                    </div>


                    <%
                        if(!unFederado.getTutorTipo().equals("0"))
                        {
                    %>
                        <div class="formulario_formato">
                        <div class="formulario_dobles">Tipo Tutor: </div>
                        <div class="formulario_dobles_campos">
                            <label><%=unFederado.getTutorTipo()%></label>
                        </div>
                        </div>
                    <%
                        }
                    %>


                    <%
                        if(!unFederado.getTutorNombre().equals(""))
                        {
                    %>
                        <div class="formulario_formato">
                        <div class="formulario_dobles">Nombre Tutor: </div>
                        <div class="formulario_dobles_campos">
                            <label><%=unFederado.getTutorNombre()%></label>
                        </div>
                        </div>
                    <%
                        }
                    %>

                    <%
                        if(!unFederado.getTutorApellido1().equals(""))
                        {
                    %>
                        <div class="formulario_formato">
                        <div class="formulario_dobles">Primer Apellido Tutor: </div>
                        <div class="formulario_dobles_campos">
                            <label><%=unFederado.getTutorApellido1()%></label>
                        </div>
                        </div>
                    <%
                        }
                    %>

                    <%
                        if(!unFederado.getTutorApellido2().equals(""))
                        {
                    %>
                        <div class="formulario_formato">
                        <div class="formulario_dobles">Segundo Apellido Tutor: </div>
                        <div class="formulario_dobles_campos">
                            <label><%=unFederado.getTutorApellido2()%></label>
                        </div>
                        </div>
                    <%
                        }
                    %>

                    <%
                        if(!unFederado.getDniTutor().equals(""))
                        {
                    %>
                        <div class="formulario_formato">
                        <div class="formulario_dobles">DNI Tutor: </div>
                        <div class="formulario_dobles_campos">
                            <label><%=unFederado.getDniTutor()%></label>
                        </div>
                        </div>
                    <%
                        }
                    %>

                    <%
                        if(!unFederado.getTutorNumFederado().equals(""))
                        {
                    %>
                        <div class="formulario_formato">
                        <div class="formulario_dobles">DNI Tutor: </div>
                        <div class="formulario_dobles_campos">
                            <label><%=unFederado.getTutorNumFederado()%></label>
                        </div>
                        </div>
                    <%
                        }
                    %>



            <%
                }
            %>


            <!-- FIN Menor -->


            <%
                if(unFederado.isHandicap())
                {
            %>
                    <div class="formulario_formato">
                        <div class="formulario_dobles">Handicap <%=unFederado.getNumHandicap()%></div>
                    </div>
            <%
                }
                else
                {
            %>
                    <div class="formulario_formato">
                        <div class="formulario_dobles">No Handicap</div>
                    </div>
            <%
                }
            %>


        <%
            if(!unFederado.getFormaPago().equals("0"))
            {
        %>

        <div class="formulario_formato">
	<div class="formulario_dobles">Forma de Pago: </div>
	<div class="formulario_dobles_campos">
            <label><%=unFederado.getFormaPago()%></label>
        </div>
	</div>

        <%
            }
        %>


        <%
            if(!unFederado.getNumCuenta().equals(""))
            {
        %>

        <div class="formulario_formato">
	<div class="formulario_dobles">Numero de Cuenta: </div>
	<div class="formulario_dobles_campos">
            <label><%=unFederado.getNumCuenta()%></label>
        </div>
	</div>
        <%
            }
        %>



         <div class="formulario_formato">
	<div class="formulario_dobles">Estado de la Licencia: </div>
	<div class="formulario_dobles_campos">
            <label><%=estadoLicencia.getEstado()%></label>
        </div>
	</div>

         <div class="formulario_formato">
	<div class="formulario_dobles">Estado Economico: </div>
	<div class="formulario_dobles_campos">
            <label><%=estadoEconomico.getEstado()%></label>
        </div>
	</div>



             <%
                if(unFederado.isNota1())
                {
            %>
                    <div class="formulario_formato">
                        <div class="formulario_dobles_campos">No deseo recibir información de la RFEG, ni de la FVG, ni F.T </div>
                    </div>
            <%
                }
            %>


            <%
                if(unFederado.isNota2())
                {
            %>
                    <div class="formulario_formato">
                        <div class="formulario_dobles_campos">No deseo recibir información de los patrocinadores de la RFEG, ni de la FVG ni F.T </div>
                    </div>
            <%
                }
            %>

            <%
                if(unFederado.isNota3())
                {
            %>
                    <div class="formulario_formato">
                        <div class="formulario_dobles_campos">No deseo recibir información sobre la Tarjeta Visa Golf </div>
                    </div>
            <%
                }
            %>

            <form autocomplete="off" action="licenAlta2MIBServlet" method="post">
                <div class="formulario_botones">
                    <label><input name="enviar" type="submit" class="boton" id="alta" value="ALTA" onclick="return validar()" ></label>
                    <label><input name="enviar" type="submit" class="boton" id="alta" value="Cancelar" onclick="return validar()" ></label>
                </div>
            </form>


        </div>
        <div class="ajustar"></div>
 	</div>



       <!-- FIN Alta Previa -->

       <!-- DIRECCION -->

         <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Direccion</div>
  		<div class="msg_body_gris">


       <%
            ArrayList<FederadoDireccion> listaFederadoDireccion = (ArrayList<FederadoDireccion>)session.getAttribute("listaFederadoDireccion");

       %>


         <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
            <th class="titulos_tablas_tx">Tipo de Direccion</th>
            <th class="titulos_tablas_tx">Domicilio</th>
            <th class="titulos_tablas_tx">Numero</th>
            <th class="titulos_tablas_tx">Escalera</th>
            <th class="titulos_tablas_tx">Piso</th>
            <th class="titulos_tablas_tx">Puerta</th>
            <th class="titulos_tablas_tx">Complemento</th>
            <th class="titulos_tablas_tx">CP</th>
            <th class="titulos_tablas_tx">Poblacion</th>
            <th class="titulos_tablas_tx">Provincia</th>
        </tr>
	</thead>

        <tbody>

            <% if (listaFederadoDireccion != null)
               {
                    TipoDireccionDAL tipoDireccionDAL = new TipoDireccionDAL();
                    TipoDireccion unTipoDireccion = null;
                    for (int i = 0; i<listaFederadoDireccion.size(); i++)
                    {
                        unTipoDireccion = tipoDireccionDAL.getTipoDireccion(listaFederadoDireccion.get(i).getTipoDireccion().getIdTipoDireccion());
            %>
            <tr>
                    <td class="texto_tablas_tx"><%=unTipoDireccion.getTipo()%></td>
                    <td class="texto_tablas_tx"><%=listaFederadoDireccion.get(i).getCalle()%></td>
                    <td class="texto_tablas_tx"><%=listaFederadoDireccion.get(i).getNumero()%></td>
                    <td class="texto_tablas_tx"><%=listaFederadoDireccion.get(i).getEscalera()%></td>
                    <td class="texto_tablas_tx"><%=listaFederadoDireccion.get(i).getPiso()%></td>
                    <td class="texto_tablas_tx"><%=listaFederadoDireccion.get(i).getPuerta()%></td>
                    <td class="texto_tablas_tx"><%=listaFederadoDireccion.get(i).getComplemento()%></td>
                    <td class="texto_tablas_tx"><%=listaFederadoDireccion.get(i).getCp()%></td>
                    <td class="texto_tablas_tx"><%=listaFederadoDireccion.get(i).getPoblacion()%></td>
                    <td class="texto_tablas_tx"><%=listaFederadoDireccion.get(i).getProvincia()%></td>

            </tr>

            <%
                    }
            %>
                <tr>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                </tr>

            <%
                }
                else
                {
            %>

            <tr>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
            </tr>
            <%
                }
            %>
	</tbody>

	</table>
	</div>

    <form autocomplete="off" action="licenAltaAnadirDireccionServlet" method="post">
        <div class="formulario_formato">
	<div class="formulario_dobles">Tipo de Direccion: </div>
	<div class="formulario_dobles_campos">
            <select name="tipoDireccion" id="tipoDireccion">

             <%
                if (listaTipoDireccion != null)
                {
                    for(int i = 0; i<listaTipoDireccion.size();i++)
                    {
             %>
                        <option name="tipoDireccion" value="<%=listaTipoDireccion.get(i).getIdTipoDireccion()%>" ><%=listaTipoDireccion.get(i).getTipo()%></option>
           <%
                    }
                }
            %>
            </select></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Domicilio: </div>
	<div class="formulario_dobles_campos">
            <label><input name="domicilio" type="text" class="campo_texto" id="domicilio" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Numero: </div>
	<div class="formulario_dobles_campos">
            <label><input name="numero" type="text" class="campo_texto" id="numero" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Escalera: </div>
	<div class="formulario_dobles_campos">
            <label><input name="escalera" type="text" class="campo_texto" id="escalera" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Piso: </div>
	<div class="formulario_dobles_campos">
            <label><input name="piso" type="text" class="campo_texto" id="piso" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Puerta: </div>
	<div class="formulario_dobles_campos">
            <label><input name="puerta" type="text" class="campo_texto" id="puerta" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Complemento: </div>
	<div class="formulario_dobles_campos">
            <label><input name="complemento" type="text" class="campo_texto" id="complemento" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">CP: </div>
	<div class="formulario_dobles_campos">
            <label><input name="cp" type="text" class="campo_texto" id="cp" size="50">
	</label></div>
	</div>

        <div class="formulario_formato">
	<div class="formulario_dobles">Poblacion: </div>
	<div class="formulario_dobles_campos">
            <label><input name="poblacion" type="text" class="campo_texto" id="poblacion" size="50">
	</label></div>
	</div>

         <div class="formulario_formato">
	<div class="formulario_dobles">Provincia: </div>
	<div class="formulario_dobles_campos">
            <select name="provincia" id="provincia">
			<option value="&#193;lava-Araba">&#193;lava-Araba</option>

			<option value="Albacete">Albacete</option>
			<option value="Alicante">Alicante</option>
			<option value="Almer&#237;a">Almer&#237;a</option>
			<option value="Asturias">Asturias</option>
			<option value="&#193;vila">&#193;vila</option>
			<option value="Badajoz">Badajoz</option>

			<option value="Barcelona">Barcelona</option>
                        <option value="Bizkaia" selected >Bizkaia</option>
			<option value="9">Burgos</option>
			<option value="Burgos">C&#225;ceres</option>
			<option value="C&#225;diz">C&#225;diz</option>

			<option value="Cantabria">Cantabria</option>
			<option value="Castell&#243;n">Castell&#243;n</option>
			<option value="Ceuta">Ceuta</option>
			<option value="Ciudad Real">Ciudad Real</option>
			<option value="C&#243;rdoba">C&#243;rdoba</option>

			<option value="Coru&#241;a, A">Coru&#241;a, A</option>
			<option value="Cuenca">Cuenca</option>
			<option value="Extranjero">Extranjero</option>
			<option value="Gipuzkoa">Gipuzkoa</option>
			<option value="Girona">Girona</option>
			<option value="Granada">Granada</option>

			<option value="Guadalajara">Guadalajara</option>
			<option value="Huelva">Huelva</option>
			<option value="Huesca">Huesca</option>
			<option value="Illes Balears">Illes Balears</option>
			<option value="Ja&#233;n">Ja&#233;n</option>
			<option value="Leon">Leon</option>

			<option value="Lleida">Lleida</option>
			<option value="Lugo">Lugo</option>
			<option value="Madrid">Madrid</option>
			<option value="M&#225;laga">M&#225;laga</option>
			<option value="Melilla">Melilla</option>
			<option value="Murcia">Murcia</option>

			<option value="Navarra">Navarra</option>
			<option value="Ourense">Ourense</option>
			<option value="Palencia">Palencia</option>
			<option value="Palmas, Las">Palmas, Las</option>
			<option value="Pontevedra">Pontevedra</option>
			<option value="Rioja, La">Rioja, La</option>

			<option value="Salamanca">Salamanca</option>
			<option value="Segovia">Segovia</option>
			<option value="Sevilla">Sevilla</option>
			<option value="Soria">Soria</option>
			<option value="Tarragona">Tarragona</option>
			<option value="Tenerife, S.C.">Tenerife, S.C.</option>

			<option value="Teruel">Teruel</option>
			<option value="Toledo">Toledo</option>
			<option value="Valencia">Valencia</option>
			<option value="Valladolid">Valladolid</option>
			<option value="Zamora">Zamora</option>
			<option value="Zaragoza">Zaragoza</option>


            </select></div>
	</div>


        <div class="formulario_botones">
            <label><input name="enviar" type="submit" class="boton" id="crear" value="AÑADIR DIRECCION" onclick="return validarDireccion()" ></label>
	</div>
        </form>

             </div>
            <div class="ajustar"></div>
 	</div>

       <!-- FIN DIRECCION -->


       <!-- TELEFONO -->

         <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Telefono</div>
  		<div class="msg_body_gris">


       <%
            ArrayList<FederadoTelefono> listaFederadoTelefono = (ArrayList<FederadoTelefono>)session.getAttribute("listaFederadoTelefono");

       %>


                     <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
            <th class="titulos_tablas_tx">Tipo de Telefono</th>
            <th class="titulos_tablas_tx">Telefono</th>
        </tr>
	</thead>

        <tbody>

            <% if (listaFederadoTelefono != null)
               {
                    TipoTelefonoDAL tipoTelefonoDAL = new TipoTelefonoDAL();
                    TipoTelefono unTipoTelefono = null;
                    for (int i = 0; i<listaFederadoTelefono.size(); i++)
                    {
                        unTipoTelefono = tipoTelefonoDAL.getTipoTelefono(listaFederadoTelefono.get(i).getTipoTelefono().getIdTipoTelefono());
            %>
            <tr>
                    <td class="texto_tablas_tx"><%=unTipoTelefono.getTipo()%></td>
                    <td class="texto_tablas_tx"><%=listaFederadoTelefono.get(i).getTelefono()%></td>

            </tr>

            <%
                    }
            %>
                <tr>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                </tr>

            <%
                }
                else
                {
            %>

            <tr>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
            </tr>
            <%
                }
            %>
	</tbody>

	</table>
	</div>

    <form autocomplete="off" action="licenAltaAnadirTelefonoServlet" method="post">
        <div class="formulario_formato">
	<div class="formulario_dobles">Tipo de Telefono: </div>
	<div class="formulario_dobles_campos">
            <select name="tipoTelefono" id="tipoTelefono">

             <%
                if (listaTipoTelefono != null)
                {
                    for(int i = 0; i<listaTipoTelefono.size();i++)
                    {
             %>
                        <option name="tipoTelefono" value="<%=listaTipoTelefono.get(i).getIdTipoTelefono()%>" ><%=listaTipoTelefono.get(i).getTipo()%></option>
           <%
                    }
                }
            %>
            </select></div>
	</div>


       <div class="formulario_formato">
	<div class="formulario_dobles">Telefono: </div>
	<div class="formulario_dobles_campos">
            <label><input name="telefono" type="text" class="campo_texto" id="telefono" size="50">
	</label></div>
	</div>


        <div class="formulario_botones">
            <label><input name="enviar" type="submit" class="boton" id="crear" value="AÑADIR TELEFONO" onclick="return validarTelefono()" ></label>
	</div>
        </form>

             </div>
            <div class="ajustar"></div>
 	</div>


       <!-- FIN TELEFONO -->

       <!-- EMAIL -->
     

     <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Email</div>
  		<div class="msg_body_gris">


       <%
            ArrayList<FederadoEmail> listaFederadoEmail = (ArrayList<FederadoEmail>)session.getAttribute("listaFederadoEmail");

       %>


                     <div class="capas_tablas_mm">

 	<table class="tablas_datos_tx" border="0" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
            <th class="titulos_tablas_tx">Tipo de Email</th>
            <th class="titulos_tablas_tx">Email</th>
        </tr>
	</thead>

        <tbody>

            <% if (listaFederadoEmail != null)
               {
                    TipoEmailDAL tipoEmailDAL = new TipoEmailDAL();
                    TipoEmail unTipoEmail = null;
                    for (int i = 0; i<listaFederadoEmail.size(); i++)
                    {
                        unTipoEmail = tipoEmailDAL.getTipoEmail(listaFederadoEmail.get(i).getTipoEmail().getIdTipoEmail());
            %>
            <tr>
                    <td class="texto_tablas_tx"><%=unTipoEmail.getTipo()%></td>
                    <td class="texto_tablas_tx"><%=listaFederadoEmail.get(i).getEmail()%></td>

            </tr>

            <%
                    }
            %>
                <tr>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
                </tr>

            <%
                }
                else
                {
            %>

            <tr>
                    <td class="texto_tablas_tx">&nbsp;</td>
                    <td class="texto_tablas_tx">&nbsp;</td>
            </tr>
            <%
                }
            %>
	</tbody>

	</table>
	</div>

    <form autocomplete="off" action="licenAltaAnadirEmailServlet" method="post">
        <div class="formulario_formato">
	<div class="formulario_dobles">Tipo de Email: </div>
	<div class="formulario_dobles_campos">
            <select name="tipoEmail" id="tipoEmail">

             <%
                if (listaTipoEmail!= null)
                {
                    for(int i = 0; i<listaTipoEmail.size();i++)
                    {
             %>
                        <option name="tipoEmail" value="<%=listaTipoEmail.get(i).getIdTipoEmail()%>" ><%=listaTipoEmail.get(i).getTipo()%></option>
           <%
                    }
                }
            %>
            </select></div>
	</div>

       
       <div class="formulario_formato">
	<div class="formulario_dobles">Email: </div>
	<div class="formulario_dobles_campos">
            <label><input name="email" type="text" class="campo_texto" id="email" size="50">
	</label></div>
	</div>
            
            
        <div class="formulario_botones">
            <label><input name="enviar" type="submit" class="boton" id="crear" value="AÑADIR EMAIL" onclick="return validarEmail()" ></label>
	</div>
        </form>

             </div>
            <div class="ajustar"></div>
 	</div>

       <!-- Fin EMAIL -->




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

