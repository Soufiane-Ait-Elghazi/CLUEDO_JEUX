<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="javaScript/javaScript.js"></script>
<link href="css/style1.css" rel="stylesheet">
<title>PlayersNumber</title>
</head>
<body class="body2">
	<nav class="players">
		<h1><b>Nombre de Joueurs :</b></h1> 
		<form action="joueursnombre.servlet" method="get">
				<select id="playersNumber" name="nbr">
					<option value="2" selected>2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
				</select>
		       <input id="bttn" type="submit" value="valider">
		       
		</form>
		
	</nav>
</body>
</html>