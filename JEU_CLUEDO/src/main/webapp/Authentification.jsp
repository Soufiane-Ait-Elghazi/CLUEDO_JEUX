<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification</title>
<link href="css/style2.css" rel="stylesheet">
</head>
<body>
 <div class="test">
	<div class="login-wrap">
		<div class="login-html">
			<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
				for="tab-1" class="tab">Se connecter</label> <input id="tab-2"
				type="radio" name="tab" class="sign-up"><label for="tab-2"
				class="tab">S'inscrire</label>
			<div class="login-form">
				<div class="sign-in-htm">
					<div class="group">
					<form action="seConnecter.servlet" method="get">
								<label for="user" class="label" >Username</label> 
								<input id="user"type="text" class="input" name="username">
								</div>
								<div class="group">
									<label for="pass" class="label">Password</label> 
									<input id="pass" type="password" class="input" data-type="password" name="password">
								</div>
								<div class="group">
									 <input id="check" type="checkbox" class="check" checked>
									 <label for="check"><span class="icon"></span>Remembre me</label>
								</div>
								<div class="group">
					            <input type="submit" class="button" value="Se connecter">
					</form>
						
					</div>
					<div class="hr"></div>
					<div class="foot-lnk">
						<a href="###">Mot de passe oublie?</a>
					</div>
				</div>
				<div class="sign-up-htm">
					<div class="group">
						<label for="user" class="label">Username</label> <input id="user"
							type="text" class="input">
					</div>
					<div class="group">
						<label for="pass" class="label">Password</label> <input id="pass"
							type="password" class="input" data-type="password">
					</div>
					<div class="group">
						<label for="pass" class="label">Confirm Password</label> <input
							id="pass" type="password" class="input" data-type="password">
					</div>
					<div class="group">
						<label for="pass" class="label">Email Address</label> <input
							id="pass" type="text" class="input">
					</div>
					<div class="group">
						<form>
						<input type="submit" class="button" value="S'inscrire" name="test">
						</form>
					</div>
					<div class="hr"></div>
					<div class="foot-lnk">
						<label for="tab-1">Deja un compte?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


</body>
</html>