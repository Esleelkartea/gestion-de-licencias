<%-- 
    Document   : index
    Created on : 11-oct-2011, 10:05:01
    Author     : Julen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Intranet Federaci&oacute;n de Golf de Bizkaia</title>
<link href="estilos/estilos.css" rel="stylesheet" type="text/css">

</head>

<body>
    <div id="contenedor">

	<div id="cabecera">
            <img src="imagenes/logotipo.png" alt="Federaci&oacute;n de Golf de Bizkaia" width="123" height="115" style="float:left;">
            <h1 style="float:right;">Federación de Golf de Bizkaia</h1><br/>
            <h1 style="float:right;">Bizkaiko Golf Federazioa</h1>
	</div>
<form method="post" name="" action="LoginServlet">

	<div class="login">

            <div class="contieneformulogin">
			<div class="formulogin">Usuario:</div>
			<div><label><input name="usuario" type="text" class="campo_texto" id="usuario" size="30"/>
		  </label></div>
            <div class="espacio"></div>
			<div class="formulogin" >Contrase&ntilde;a:</div>
			<div><label><input name="contrasena" type="password" class="campo_texto" id="contrasena" size="30"/>
		  </label></div>

		<div class="formulogin_bot">
		<input name="entrar" type="submit" class="boton" id="entrar" value="Entrar" /></div>
		</div>
            <%
                Boolean bError = (Boolean)session.getAttribute("errorLogin");
                if(bError != null && bError == true)
                {
           %>
                <span class="error">Login incorrecto!!!</span><br/>
           <%
                }
                session.setAttribute("erroLogin", null);
           %>

		<div class="espacio"></div>
        </div>
</form>

      <div id="pie">
    <div class="vcard">
        <div> <span class="name">Federación Vizcaina de Golf</span>-<span class="locality">Bilbao</span>-<span class="region">Bizkaia</span>-<span class="postal-code">48003</span></div>
	<div> <span class="tel">94 439 41 21</span>-<span class="email">info@bizkaiagolf.com</span></div>
    </div>
</div>
    </div>
</body>
</html>

