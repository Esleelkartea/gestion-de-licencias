<%--  
    Document   : configuracion
    Created on : 04-nov-2011, 9:54:43
    Author     : Julen
--%>



<%@page import="com.Negocio.Grupo"%>
<%@page import="com.Negocio.EstadoEconomico"%>
<%@page import="com.Negocio.EstadoLicencia"%>
<%@page import="com.Negocio.Federado"%>
<%@page import="com.Negocio.Entidad"%>
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

	<h1><img src="imagenes/carpeta.gif" width="30" height="30" /> Datos introducidos</h1>
     
        


        <!-- Actividad -->
        <div class="marco">
  		<div class="msg_head_gris">
    	<img src="imagenes/lapiz.gif" width="16" height="16" />Federado</div>
  		<div class="msg_body_gris">
 

        <%
         
         Entidad unaEntidad = (Entidad)session.getAttribute("unaEntidad");
         Federado unFederado = (Federado)session.getAttribute("unFederado");
         Grupo unGrupo = (Grupo)session.getAttribute("unGrupo");
         EstadoLicencia estadoLicencia = (EstadoLicencia)session.getAttribute("unEstadoLicencia");
         EstadoEconomico estadoEconomico = (EstadoEconomico)session.getAttribute("unEstadoEconomico");

       %>   

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


        </div>
        <div class="ajustar"></div>
 	</div>

        <form autocomplete="off" action="licenAltaFinalServlet" method="post">
            <div class="formulario_botones">
                <label><input name="enviar" type="submit" class="boton" id="volver" value="Alta" ></label>
                <label><input name="enviar" type="submit" class="boton" id="volver" value="Cancelar" onclick="cancelar()" ></label>
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

