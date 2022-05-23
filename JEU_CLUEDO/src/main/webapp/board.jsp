<%@page import="java.util.ArrayList"%>
<%@page import="métier.*"%>
<%
int nbr = (Integer) request.getAttribute("nbr");
ArrayList<Integer> idnotess = (ArrayList<Integer>) request.getAttribute("indexesC");
ArrayList<Integer> indexes = (ArrayList<Integer>) request.getAttribute("indexes");
int id = (Integer)request.getAttribute("joueurIndex");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet">
<link href="css/style1.css" rel="stylesheet">
<title>Board</title>
</head>
<body>
	<div id="divCartes">
	<!-- button notes -->
	<div class="Descrip">
		<table id="tableProfil">
			<tr>
			<td id="imgP"></td>
			<td><h3 id="Col"></h3></td>
			</tr>
			<tr>
			<td><button class="note"><a href="#demo"></a></button></td>
			<td><h3 id="Col">Il propose cette hypothese >>> </h3></td>
			</tr>
		</table>
	</div>

		<div id="demo" class="modal">
			<div class="modal_content">
				<h1 id="mesnotes">Ma Note :</h1>
				<div class="div001">
					<table class="note1">
						<tr>
							<td id="test">
								<table class="table001">
									<tr>
										<td class="titre" colspan="2"><h3>Les lieux</h3></td>
									</tr>
									<tr>
										<td><p>
												<strong>Hall</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id1"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Le bureau</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id2"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Bibliothéque</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id3"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Salle de jeux</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id4"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Terrasse</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id5"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Salle de danse</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id6"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Cuisine</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id7"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Salle à manger</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id8"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Le salon</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id9"></td>
									</tr>
								</table>
							</td>
							<td id="test">
								<table class="table001">
									<tr>
										<td class="titre" colspan="2"><h3>Les Armes</h3></td>
									</tr>
									<tr>
										<td><p>
												<strong>Dague</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id10"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Tuyau de plomb</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id11"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Clé</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id12"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Chandelier</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id13"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Revolver</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id14"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Corde</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id15"></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
									</tr>
								</table>
							</td>
							<td id="test">
								<table class="table001">
									<tr>
										<td class="titre" colspan="2"><h3>Les Suspects</h3></td>
									</tr>
									<tr>
										<td><p>
												<strong>Rouge</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id16"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Vert</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id17"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Blanc</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id18"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Violet</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id19"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Bleu</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id20"></td>
									</tr>
									<tr>
										<td><p>
												<strong>Jaune</strong>
											</p></td>
										<td><input class="inputNote" type="checkbox" id="id21"></td>
									</tr>
									<tr>
										<td></td>
										<td></td>
									</tr>
									<tr>
										<td colspan="2" rowspan="2"><form><input id="Sauvgarder" type="button" value="Sauvgarder"></form></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>

				<a href="#" class="modal_close">&times;</a>
			</div>
		</div>
		
		
		<!-- -------------------hypothese : choisir l'arme ------------------- -->
		
		<div id="demo1" class="modal1">
			<div class="modal_content1">
				<h1 id="mesnotes1">choisir carte Arme :</h1>
				<div class="divHypothse" >
					<table id="carteArme" >
						<tr >
							<td id="test11"></td>
							<td id="test11"></td>
							<td id="test11"></td>
						</tr>
						<tr>
							<td id="test11"></td>
							<td id="test11"></td>
							<td id="test11"></td>
						</tr>
					</table>
				</div>

				<a href="#" class="modal_close1">&times;</a>
			</div>
		</div>
		
		<!-------------------------- repondre ---------------------->
		
		<div id="demo2" class="modal1">
			<div class="modal_content1">
				<h1 id="mesnotes3">La carte montree :</h1>
				<div class="divHypothse" >
					<table id="carteMontree" >
						<tr >
							<td></td>
						</tr>
					</table>
				</div>

				<a href="#" class="modal_close1">&times;</a>
			</div>
		</div>
		
  			<!-------------------------- ||||||| repondre ||||||||||---------------------->
  			
  			<!-- ------------------resoudre ------------------------- -->
  			
  			<div id="demo3" class="modal1">
			<div class="modal_content1">
				<h1 id="mesnotes2"></h1>
				<div class="divHypothse" >
					<table id="ResoudreCartes" >
						<tr >
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr >
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr >
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>

				<a href="#" class="modal_close1">&times;</a>
			</div>
		</div>
  			
				<!-- -------------------hypothese : choisir le suspect ------------------- suspect -->
				
		
				<!-- meme table que les armes -->
		
		
				<!-- -------------table de l'hypothse----------------- -->
		<table id="hypothese">
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
		<div class="hmesCartes">
			<h2 id="MesCartesH2">Mes Cartes :</h2>
		</div>
		<table id="tabCartes">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>

			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>

			</tr>
		</table>
	</div>




	<div id="div1">
		<img class="board" alt="gg" src="images/Plateau/boardPrin.jpg">
		<table id="table">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>

		</table>
	</div>
	<br>
	<div class="deplacement">
	<div class="tete"><button id="Psecret">Passage Secret</button></div>
	<div class="tete" align="center">
		<table id="tab11">
			<tr>
				<td></td>
				<td>
					<form>
						<input type="button" id="btnU" value="UP">
					</form>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>
					<form>
						<input type="button" id="btnL" value="LEFT">
					</form>
				</td>
				<td>
					<form>
						<input type="button" id="btnD" value="DOWN">
					</form>
				</td>
				<td>
					<form>
						<input type="button" id="btnR" value="RIGHT">
					</form>
				</td>
			</tr>

		</table>
		</div>
		<table class="LDFHRB">
			<tr>
				<td>
					<button id="des" >
						<div>
							<div id="score1" class="divDes">
								<img class="imgDes" src='images/dices/dice1.png'>
							</div>
							<div id="score2" class="divDes">
								<img class="imgDes" src='images/dices/dice1.png'>
							</div>
							<div id="score" class="divDes">
								<img class="imgDes" src='images/dices/dice1.png'>
							</div>
						</div>
					</button>
				</td>
				<td>
					<button  id="hyp"><a class="a1" href="#demo1">Faire Hypothese</a></button>
					<!-- ------------------- hypothese ------------------------- -->
				</td>
				<td>
				<button id="resoudreCrime" class="resod"><a href="#demo3">Resoudre Le Crime</a></button>
				</td>
				<td>
					<button id="confermHyp" class="Verif"><a class="a2" href="#demo2"><!--  <img class="imgDes1" alt="" src="images/autres/iconVeri.png">-->Verifier Hypothese</a></button>
				</td>
			</tr>
		</table>
	</div>












</body>
<script type="text/javascript" src="javaScript/jquery-3.6.0.js"></script>
<script>
	var playersNumber = <%=nbr%>;
	var idnote = <%=idnotess%>;
	var indexes = <%=indexes%>;
	var idJ = <%=id%>;
</script>
<script type="text/javascript" src="javaScript/javaScript.js"></script>
</html>