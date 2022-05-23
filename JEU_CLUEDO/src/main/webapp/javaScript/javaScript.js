
var nbr = playersNumber;
var ids = indexes;
var idsnotes = idnote;
var test;
var idJoueur = idJ;
let armid = 0;
let suspectid = 0;
let lieuid = 0 ; 
let array =[];
let arrayRes = [];
let CartesArmesPossibles =[];
let CartesLieuxPossibles =[];
let carteSusResSelc=0;
let carteArmResSelc=0;
let carteLieResSelc=0;
let message = "";
let res = "";
let etat = "";
gererTourJeu(idJoueur+1);
checkedCartes(idsnotes);

function getPositionPion(identifiant) {
	var table = document.getElementById("table");
	var arrayLignes = table.rows;
	var longueur = arrayLignes.length;
	var i = 1;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;

		for (var j = 0; j < largeur; j++) {
			var parentElement = table.rows[i].cells[j];
			var firstChild = parentElement.hasChildNodes();
			if (firstChild) {
				var firstChild = parentElement.firstChild;
				var val = firstChild.id;
				if (val == identifiant) {
					var X = [i, j]
					return X;
				}
			}
		}
	}
}


function srcIndex(index) {
	let identifiant;
	switch (index) {
		case 0:
			identifiant = "blanc.png";
			return identifiant;
		case 1:
			identifiant = "violet.png";
			return identifiant;
		case 2:
			identifiant = "jaune.png";
			return identifiant;
		case 3:
			identifiant = "vert.png";
			return identifiant;
		case 4:
			identifiant = "bleu.png";
			return identifiant;
		case 5:
			identifiant = "rouge.png";
			return identifiant;
		default:
			break;
	}
}

function playerPositions(x) {
	switch (x) {
		case 2:
			createElement(0, 19, 25);
			createElement(1, 7, 25);
			break;
		case 3:
			createElement(0, 19, 25)
			createElement(1, 7, 25)
			createElement(2, 1, 16)
			break;
		case 4:
			createElement(0, 19, 25)
			createElement(1, 7, 25)
			createElement(2, 1, 16)
			createElement(3, 1, 10)
			break;
		case 5:
			createElement(0, 19, 25)
			createElement(1, 7, 25)
			createElement(2, 1, 16)
			createElement(3, 1, 10)
			createElement(4, 18, 1)
			break;
		case 6:
			createElement(0, 19, 25)
			createElement(1, 7, 25)
			createElement(2, 1, 16)
			createElement(3, 1, 10)
			createElement(4, 18, 1)
			createElement(5, 25, 10)
			break;

		default:
			alert("players number should be between 2 and 6 (=)!!!");
			break;
	}

}

function getPositionPion(identifiant) {
	var table = document.getElementById("table");
	var arrayLignes = document.getElementById("table").rows;
	var longueur = arrayLignes.length;
	var i = 1;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;

		for (var j = 0; j < largeur; j++) {
			var parentElement = table.rows[i].cells[j];
			var firstChild = parentElement.hasChildNodes();
			if (firstChild) {
				var firstChild = parentElement.firstChild;
				var val = firstChild.id;
				if (val == identifiant) {
					var X = [i, j]
					return X;
				}
			}
		}
	}
}




function createElement(index, L, C) {
	deleteElement(L, C)
	var oImg = document.createElement("img");
	var src = srcIndex(index);
	//alert(src);
	var id = indexIdentifiant(index);
	oImg.setAttribute('id', id + '');
	oImg.setAttribute('src', 'images/Pions/' + src);
	oImg.setAttribute('height', '80%');
	oImg.setAttribute('width', '80%');
	oImg.setAttribute('margin', 'auto');
	oImg.setAttribute('display', 'flex');
	oImg.setAttribute('padding', '0px');
	var table = document.getElementById("table");
	var arrayLignes = document.getElementById("table").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
			var parentElement = table.rows[i].cells[j];
			if (i == L && j == C) {
				parentElement.appendChild(oImg);
				break;
			}
		}
	}
}
function deleteElement(L, C) {
	var table = document.getElementById("table");
	var arrayLignes = document.getElementById("table").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
			if (i == L && j == C) {
				var parentElement = table.rows[i].cells[j];
				parentElement.removeChild;
				while (parentElement.firstChild) {
					parentElement.removeChild(parentElement.lastChild);
				}
				break;
			}
		}
	}
}
/*************| AJAX |**************/
$(document).ready(function() {
	$(document).on("click", "#btnL", function() {
		var k = $('#btnL').val();
		$.get(
			"deplacement.servlet",
			{ dep: k },
			function(responseText) {
				// $('#pa').text(responseText);
				//alert(responseText)
		let obj = JSON.parse(responseText);
				disabledbuttons(obj.nbrdep);
				$('#tourjeu').text(obj.joueurIndex);
				$('#tourreponse').text(obj.joueurIndexrep);
				if (hasChildDeferent(indexIdentifiant(obj.joueurIndex), obj.NL, obj.NC)) {
					//on récupère les données 
					var contenu1 = document.getElementById("table").rows[obj.OL].cells[obj.OC].innerHTML;//on copie le contenu de la cellule 1
					var contenu2 = document.getElementById("table").rows[obj.NL].cells[obj.NC].innerHTML;//on copie celui de la cellule 2
					//on remplace
					document.getElementById("table").rows[obj.OL].cells[obj.OC].innerHTML = contenu2;
					document.getElementById("table").rows[obj.NL].cells[obj.NC].innerHTML = contenu1;
				}
				else {
					deleteElement(obj.OL, obj.OC);
					createElement(obj.joueurIndex, obj.NL, obj.NC);
				}

			}
		);
	});
});


$(document).ready(function() {
	$(document).on("click", "#btnU", function() {
		var k = $('#btnU').val();
		$.get(
			"deplacement.servlet",
			{ dep: k },
			function(responseText) {
				//$('#pa').text(responseText);
			let obj = JSON.parse(responseText);
				disabledbuttons(obj.nbrdep);
				$('#tourjeu').text(obj.joueurIndex);
				$('#tourreponse').text(obj.joueurIndexrep);
				if (hasChildDeferent(indexIdentifiant(obj.joueurIndex), obj.NL, obj.NC)) {
					//on récupère les données 
					var contenu1 = document.getElementById("table").rows[obj.OL].cells[obj.OC].innerHTML;//on copie le contenu de la cellule 1
					var contenu2 = document.getElementById("table").rows[obj.NL].cells[obj.NC].innerHTML;//on copie celui de la cellule 2
					//on remplace
					document.getElementById("table").rows[obj.OL].cells[obj.OC].innerHTML = contenu2;
					document.getElementById("table").rows[obj.NL].cells[obj.NC].innerHTML = contenu1;
				}
				else {
					deleteElement(obj.OL, obj.OC);
					createElement(obj.joueurIndex, obj.NL, obj.NC);
				}

			}
		);
	});
});



$(document).ready(function() {
	$(document).on("click", "#btnR", function() {
		var k = $('#btnR').val();
		$.get(
			"deplacement.servlet",
			{ dep: k },
			function(responseText) {
				// $('#pa').text(responseText);
			let obj = JSON.parse(responseText);
			    disabledbuttons(obj.nbrdep);
				$('#tourjeu').text(obj.joueurIndex);
				$('#tourreponse').text(obj.joueurIndexrep);
				if (hasChildDeferent(indexIdentifiant(obj.joueurIndex), obj.NL, obj.NC)) {
					//on récupère les données 
					var contenu1 = document.getElementById("table").rows[obj.OL].cells[obj.OC].innerHTML;//on copie le contenu de la cellule 1
					var contenu2 = document.getElementById("table").rows[obj.NL].cells[obj.NC].innerHTML;//on copie celui de la cellule 2
					//on remplace
					document.getElementById("table").rows[obj.OL].cells[obj.OC].innerHTML = contenu2;
					document.getElementById("table").rows[obj.NL].cells[obj.NC].innerHTML = contenu1;
				}
				else {
					deleteElement(obj.OL, obj.OC);
					createElement(obj.joueurIndex, obj.NL, obj.NC);
				}

			}
		);
	});
});


$(document).ready(function() {
	$(document).on("click", "#btnD", function() {
		var k = $('#btnD').val();
		$.get(
			"deplacement.servlet",
			{ dep: k },
			function(responseText) {
				//$('#pa').text(responseText);
				let obj = JSON.parse(responseText);
				disabledbuttons(obj.nbrdep);
				$('#tourjeu').text(obj.joueurIndex);
				$('#tourreponse').text(obj.joueurIndexrep);
				if (hasChildDeferent(indexIdentifiant(obj.joueurIndex), obj.NL, obj.NC)) {
					//on récupère les données 
					var contenu1 = document.getElementById("table").rows[obj.OL].cells[obj.OC].innerHTML;//on copie le contenu de la cellule 1
					var contenu2 = document.getElementById("table").rows[obj.NL].cells[obj.NC].innerHTML;//on copie celui de la cellule 2
					//on remplace
					document.getElementById("table").rows[obj.OL].cells[obj.OC].innerHTML = contenu2;
					document.getElementById("table").rows[obj.NL].cells[obj.NC].innerHTML = contenu1;
				}
				else {
					deleteElement(obj.OL, obj.OC);
					createElement(obj.joueurIndex, obj.NL, obj.NC);
				}

			}
		);
	});
});



function dep(index) {
	var deplacement = "";
	switch (index) {
		case 1:
			deplacement = "LEFT";
			return deplacement;

		case 2:
			deplacement = "UP";
			return deplacement;

		case 3:
			deplacement = "RIGHT";
			return deplacement;

		case 4:
			deplacement = "DOWN";
			return deplacement;
		default:
			alert("!!!!!!!!!");
			break;
	}

}



//alert(deleteElement)



function hasChildDeferent(monIdentifiant, l, c) {
	var table = document.getElementById("table");
	var parentElement = table.rows[l].cells[c];
	var firstChild = parentElement.hasChildNodes();
	if (firstChild) {
		if (firstChild.id != monIdentifiant)
			return true;

		else
			return false;
	}
	return false;
}




function indexIdentifiant(index) {
	switch (index) {
		case 0:
			return "pionWhite";

		case 1:
			return "pionViolet";

		case 2:
			return "pionYellow";

		case 3:
			return "pionGreen";

		case 4:
			return "pionBlue";

		case 5:
			return "pionRed";

		default:
			break;
	}

}

//--------------------------------- les cartes de joueur ----------------------------------------

function srcCarte(idCarte) {
	let source;
	switch (idCarte) {
		case 1:
			source = "hall.png";
			return source;
		case 2:
			source = "bureau.png";
			return source;
		case 3:
			source = "bibliotheque.png";
			return source;
		case 4:
			source = "salle_de_jeux.png";
			return source;
		case 5:
			source = "terrasse.png";
			return source;
		case 6:
			source = "salle_de_danse.png";
			return source;
		case 7:
			source = "cuisine.png";
			return source;
		case 8:
			source = "salle_a_manger.png";
			return source;
		case 9:
			source = "salon.png";
			return source;
		case 10:
			source = "dague.png";
			return source;
		case 11:
			source = "tuyau_de_plomb.png";
			return source;
		case 12:
			source = "cle.png";
			return source;
		case 13:
			source = "chandelier.png";
			return source;
		case 14:
			source = "revolver.png";
			return source;
		case 15:
			source = "corde.png";
			return source;
		case 16:
			source = "rouge.png";
			return source;
		case 17:
			source = "vert.png";
			return source;
		case 18:
			source = "blanc.png";
			return source;
		case 19:
			source = "violet.png";
			return source;
		case 20:
			source = "bleu.png";
			return source;
		case 21:
			source = "jaune.png";
			return source;
		default:
			break;
	}
}


function createCartes(ids) {
	//alert(ids)
	deleteAllCartes()
	var c = 0;
	switch (ids.length) {
		
		case 3:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createCart(ids[c], i, j);
					
					c++;
				}
			}
			break;
		case 4:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 4; j++) {
					createCart(ids[c], i, j);
					c++;
				}
			}
			break;
		case 6:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 5; j++) {
					createCart(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 1; j++) {
					createCart(ids[c], i, j);
					c++;
				}
			}
			break;
		case 9:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 5; j++) {
					createCart(ids[c], i, j);
				
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 4; j++) {
					createCart(ids[c], i, j);
					c++;
				}
			}
			
			
			
		
			break;

		default:
			break;
	}
}



	
	
function createCart(id , L , C){
	var bttn = document.createElement("button");
	bttn.setAttribute('class', 'bt');
	bttn.setAttribute('id', id+'');
	bttn.setAttribute("onclick", "reply_clickRep(this.id)");
	var oImg = document.createElement("img");
	var src =srcCarte(id);
	oImg.setAttribute('src', 'images/Cartes/' + src);
	oImg.setAttribute('class', 'cat');
	bttn.appendChild(oImg);
	//bttn.setAttribute("disabled", true);
	var table = document.getElementById("tabCartes");
	var arrayLignes = document.getElementById("tabCartes").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
			var parentElement = table.rows[i].cells[j];
			if (i == L && j == C) {
				parentElement.appendChild(bttn);
				break;
			}
		}
	}
	
}



function deleteAllCartes(){
	var table = document.getElementById("tabCartes");
	var arrayLignes = document.getElementById("tabCartes").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
				var parentElement = table.rows[i].cells[j];
				while (parentElement.hasChildNodes()) {
					parentElement.removeChild(parentElement.lastChild);
				}
			}
		}
}



var something = (function() {
	var executed = false;
	return function() {
		if (!executed) {
			executed = true;
			playerPositions(nbr);//"do something"
			disabledbuttons(0);
			
		}
	};
})()


something(); // "do something" happens
something(); // nothing happens


var something2 = (function() {
	var executed = false;
	return function() {
		if (!executed) {
			executed = true;
			createCartes(ids);
			$('#pa1').text("C'est le tour de joueur : 0");
			//alert(joueurIndex)
		}
	};
})()

something2(); // "do something" happens
something2(); // nothing happens




$(document).ready(function() {
	$(document).on("click", "#des", function() {
		var k = $('#des').val();
		k=randomDice();
		
		$.get(
			"lancerLeDe.servlet",
			{ ind: k },
			function(responseText) {
			
				let obj = JSON.parse(responseText);
				
				test=obj.NotesCocheesids;
				gererTourJeu((obj.tour)+1);
				disabledbuttons(1);
				createCartes(obj.CartesIds);
				checkedCartes(obj.NotesCocheesids);
				
				
			}
		);
	});
});

//-------------------------- passage secret --------------------------
$(document).ready(function() {
	$(document).on("click", "#Psecret", function() {
		var k = 0;
		$.get(
			"passageSecret.servlet",
			{ ind: k },
			function(responseText) {
				//alert('test');
				let obj = JSON.parse(responseText); 
				let L=obj.newligne;
				let C=obj.newcolonne;
				let t=obj.tour;
				//alert(L);
				//alert(C);
				//alert(t);
				deleteElement(Number(obj.olligne),Number(obj.occolonne));
				createElement(Number(t), Number(L), Number(C)); 
			}
		);
	});
})


//--------------------------------------------------------------------


//------------------- hypothese --------------------------
var idsCartesSusHyp;
$(document).ready(function() {
	$(document).on("click", "#hyp", function() {
		var k = 0;
		$.get(
			"faireHypothese.servlet",
			{ ind: k },
			function(responseText) {
				//$('#tourjeu').text(responseText);
			
				let obj = JSON.parse(responseText); 
				lieuid=obj.CarteLieuId;
	
				createCartesArmeshypothese(obj.idsCartesArmHyp);
				idsCartesSusHyp = obj.idsCartesSusHyp;
				
				
			}
		);
	});
})

//---------------------------------------------------------



function disabledbuttons(nbrdep){
	if(nbrdep==0){
		$( "#des" ).attr( "disabled", false);
		$( "#btnL" ).attr( "disabled", true );
		$( "#btnU" ).attr( "disabled", true );
		$( "#btnR" ).attr( "disabled", true );
		$( "#btnD" ).attr( "disabled", true );
	}
	else{
		$( "#des" ).attr( "disabled", true);
		$( "#btnL" ).attr( "disabled", false );
		$( "#btnU" ).attr( "disabled", false );
		$( "#btnR" ).attr( "disabled", false );
		$( "#btnD" ).attr( "disabled", false );
	
	}
}

//----------------------- des ---------------------------


 function randomDice() {
               var diceImage1;
               var roll1 = Math.floor(Math.random() * 6)+1;
              if (roll1 === 1) {
                 diceImage1 = "<img class='imgDes' src='images/dices/dice1.png'>"; }
               else if (roll1 === 2) {
                 diceImage1 = "<img class='imgDes' src='images/dices/dice2.png'>"; }
               else if (roll1 === 3) {
                 diceImage1 = "<img class='imgDes' src='images/dices/dice3.png'>"; }
               else if (roll1 === 4) {
                 diceImage1 = "<img class='imgDes' src='images/dices/dice4.png'>"; }
               else if (roll1 === 5) {
                 diceImage1 = "<img class='imgDes' src='images/dices/dice5.png'>"; }
               else if (roll1 === 6) {
                 diceImage1 = "<img class='imgDes' src='images/dices/dice6.png'>"; }
               else { diceImage1 = "oups!"}

               var diceImage2;
               var roll2 = Math.floor(Math.random() * 6)+1;
              if (roll2 === 1) {
                 diceImage2 = "<img class='imgDes' src='images/dices/dice1.png'>"; }
               else if (roll2 === 2) {
                 diceImage2 = "<img class='imgDes' src='images/dices/dice2.png'>"; }
               else if (roll2 === 3) {
                 diceImage2 = "<img class='imgDes' src='images/dices/dice3.png'>"; }
               else if (roll2 === 4) {
                 diceImage2 = "<img class='imgDes' src='images/dices/dice4.png'>"; }
               else if (roll2 === 5) {
                 diceImage2 = "<img class='imgDes' src='images/dices/dice5.png'>"; }
               else if (roll2 === 6) {
                 diceImage2 = "<img class='imgDes' src='images/dices/dice6.png'>"; }
               else { diceImage2 = "oups!"}

               var diceImage;
               var roll = Math.floor(Math.random() * 6)+1;
              if (roll === 1) {
                 diceImage = "<img class='imgDes' src='images/dices/dice1.png'>"; }
               else if (roll === 2) {
                 diceImage = "<img class='imgDes' src='images/dices/dice2.png'>"; }
               else if (roll === 3) {
                 diceImage = "<img class='imgDes' src='images/dices/dice3.png'>"; }
               else if (roll === 4) {
                 diceImage = "<img class='imgDes' src='images/dices/dice4.png'>"; }
               else if (roll === 5) {
                 diceImage = "<img class='imgDes' src='images/dices/dice5.png'>"; }
               else if (roll === 6) {
                 diceImage = "<img class='imgDes' src='images/dices/dice6.png'>"; }
               else { diceImage = "oups!"}
              
               document.getElementById("score1").innerHTML = diceImage1;
               document.getElementById("score2").innerHTML = diceImage2;
               document.getElementById("score").innerHTML = diceImage;
			
				playMusic();
			
				return roll1+roll2+roll;
             }


//-------------------------------------- notes ---------------------------------------

function createNotes(id){
	$( "#"+"id"+id ).attr( "checked", true);
	$( "#"+"id"+id ).attr( "disabled", true);
}

function checkedCartes(arr){
		for(var t=1;t<=21;t++){
		$( "#"+"id"+t ).attr( "checked", false);
		$( "#"+"id"+t ).attr( "disabled", false);
		
	}
	for(var l=0;l<arr.length;l++){
		createNotes(arr[l]);
		}
	}
//----------------------- des sound ------------------------------

function playMusic(){
  var music = new Audio('./audios/des.mp3');
  music.play();
  }


//----------------------- creation de hypothese ----------------------------


//*****************| hyphothese |**************** */
 
  /// creation d'une carte dans l'hepothese les armes
  
  function createCartArmeHypothese(id , L , C ){
	document.getElementById('mesnotes1').innerHTML="choisir une carte Arme :";
	var bttn = document.createElement("button");
	bttn.setAttribute('class', 'bt');
	var oImg = document.createElement("img");
	var s =srcCarte(id);
	oImg.setAttribute('src', 'images/Cartes/' + s);
	oImg.setAttribute('class', 'cat');
	bttn.setAttribute('id',id+'');
	bttn.setAttribute("onclick", "reply_clickArme(this.id)");
	bttn.appendChild(oImg);
	var table = document.getElementById("carteArme");
	var arrayLignes = document.getElementById("carteArme").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
			var parentElement = table.rows[i].cells[j];
			if (i == L && j == C) {
				parentElement.appendChild(bttn);
				break;
			}
		}
	}
	
}
  
/// creation toutes les cartes arme dans l'hepothese;
  
  function createCartesArmeshypothese(ids) {
	deleteAllCartesArmes();
	var c = 0;
	switch (ids.length) {
		
		case 1:
					createCartArmeHypothese(ids[0], 0, 0);
					
		break;
		case 2:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 2; j++) {
					createCartArmeHypothese(ids[c], i, j);
					c++;
				}
			}
			break;
		case 3:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createCartArmeHypothese(ids[c], i, j);
					c++;
				}
			}
			break;
		case 4:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createCartArmeHypothese(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 1; j++) {
					createCartArmeHypothese(ids[c], i, j);
					c++;
				}
			}
			break;
		case 5:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createCartArmeHypothese(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 2; j++) {
					createCartArmeHypothese(ids[c], i, j);
					c++;
				}
			}
			break;
		case 6:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createCartArmeHypothese(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 3; j++) {
					createCartArmeHypothese(ids[c], i, j);
					c++;
				}
			}
			break;
		default:
			break;
	}
}
  
 
///suppression des cartes Armes dans l'hepothese;
   
  function deleteAllCartesArmes(){
	var table = document.getElementById("carteArme");
	var arrayLignes = document.getElementById("carteArme").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
				var parentElement = table.rows[i].cells[j];
				while (parentElement.hasChildNodes()) {
					parentElement.removeChild(parentElement.lastChild);
				}
			}
		}
}


/// creation d'une carte dans l'hepothese les suspect
  
  function createCartSuspectHypothese(id , L , C ){
	document.getElementById('mesnotes1').innerHTML="choisir une carte Suspect :";
	var bttn = document.createElement("button");
	bttn.setAttribute('class', 'bt');
	var oImg = document.createElement("img");
	var s =srcCarte(id);
	oImg.setAttribute('src', 'images/Cartes/' + s);
	oImg.setAttribute('class', 'cat');
	bttn.setAttribute('id',id+'');
	bttn.setAttribute("onclick", "reply_clickSuspect(this.id)");
	bttn.appendChild(oImg);
	var table = document.getElementById("carteArme");
	var arrayLignes = document.getElementById("carteArme").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
			var parentElement = table.rows[i].cells[j];
			if (i == L && j == C) {
				parentElement.appendChild(bttn);
				break;
			}
		}
	}
	
}
  
/// creation toutes les cartes Suspects dans l'hepothese;
  
  function createCartesSuspecthypothese(ids) {
	deleteAllCartesSuspects();
	var c = 0;
	switch (ids.length) {
		
		case 1:
					createCartSuspectHypothese(ids[0], 0, 0);
					
		break;
		case 2:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 2; j++) {
					createCartSuspectHypothese(ids[c], i, j);
					c++;
				}
			}
			break;
		case 3:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createCartSuspectHypothese(ids[c], i, j);
					c++;
				}
			}
			break;

	
		case 4:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createCartSuspectHypothese(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 1; j++) {
					createCartSuspectHypothese(ids[c], i, j);
					c++;
				}
			}
			break;
		case 5:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createCartSuspectHypothese(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 2; j++) {
					createCartSuspectHypothese(ids[c], i, j);
					c++;
				}
			}
			break;
		case 6:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createCartSuspectHypothese(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 3; j++) {
					createCartSuspectHypothese(ids[c], i, j);
					c++;
				}
			}
			break;
		default:
			break;
	}
}
  
 
///suppression des cartes suspects dans l'hepothese;
   
  function deleteAllCartesSuspects(){
	var table = document.getElementById("carteArme");
	var arrayLignes = document.getElementById("carteArme").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
				var parentElement = table.rows[i].cells[j];
				while (parentElement.hasChildNodes()) {
					parentElement.removeChild(parentElement.lastChild);
				}
			}
		}
}

/// variable global pour recuperer les id des cartes d'hypothese

 function reply_clickArme(clicked_id)
  {
      armid =clicked_id; 
	// tour pour choisir suspect 
	 createCartesSuspecthypothese(idsCartesSusHyp);  
  }

 function reply_clickSuspect(clicked_id)
  {
      suspectid =clicked_id;
	 // remplir table de hypothese
	 
       array =[lieuid,armid,suspectid];
       remplirtableHypothese(array)
		
  }

// ------------------------ remplir la table de l'hypothese -------------------------------

		// creation d'une carte dans table hypthese
  function createCartsHypothese(id , L , C ){
	var bttn = document.createElement("button");
	bttn.setAttribute('class', 'bt');
	var oImg = document.createElement("img");
	var s =srcCarte(id);
	oImg.setAttribute('src', 'images/Cartes/' + s);
	oImg.setAttribute('class', 'cat');
	bttn.appendChild(oImg);
	var table = document.getElementById("hypothese");
	var arrayLignes = document.getElementById("hypothese").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
			var parentElement = table.rows[i].cells[j];
			if (i == L && j == C) {
				parentElement.appendChild(bttn);
				break;
			}
		}
	}
	
}
		//vider la table hypothese
 function deleteAllCarteshypothese(){
	var table = document.getElementById("hypothese");
	var arrayLignes = document.getElementById("hypothese").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
				var parentElement = table.rows[i].cells[j];
				while (parentElement.hasChildNodes()) {
					parentElement.removeChild(parentElement.lastChild);
				}
			}
		}
}		
		
		// remplir la table hypothese
		
	function remplirtableHypothese(ids){
		
		// 3 ids : une pour chaque carte 
		deleteAllCarteshypothese();
				createCartsHypothese(Number(ids[0]) , 0 , 0 );
				createCartsHypothese(Number(ids[1]) , 0 , 1 );
				createCartsHypothese(Number(ids[2]) , 0 , 2 );
			
}
		
//***********************   sauvgarder   ******************************/	

function getcheckednotes(){
	let ar = [];
	var c=0;
	for(var i=1;i<=21;i++){
		if($('#'+'id'+i).prop('checked')){
			ar[c]=i;
			c++;
		}
	}

	return ar;
}






$(document).ready(function() {
	$(document).on("click", "#Sauvgarder", function() {
		var array1 = getcheckednotes();
		
		let myString = JSON.stringify(array1);
	
		$.get(
			"sauvgarder.servlet",
			{ checked: myString },
			function(responseText) {
				
		      let obj = JSON.parse(responseText);
			  checkedCartes(obj.array)
			}
		);
	});
});


/******************************************| repondre |**************************************************************/

let idrep;
 function reply_clickRep(clicked_id)
  {
      idrep =clicked_id; 
	  
  }



$(document).ready(function() {
	$(document).on("click", "#confermHyp", function() {
		$.get(
			"repondre.servlet",
			{ id1: array[0],
			  id2: array[1],
			  id3: array[2],
			},
			function(responseText) {	
		      let obj = JSON.parse(responseText);
			  message = obj.s;
			  if(obj.id!=0){
				createCarteMontree(obj.id,0,0);
			}
			 else{
				createMessage(message);
				}
			  //createCartMontree(id);
			}
		);
	});
});


//---------------------------| carte montree |---------------------------------------
// ------------------------ vider table des carte montree -----------------------
function delleteCarteMontree(){
	var table = document.getElementById("carteMontree");
	var arrayLignes = document.getElementById("carteMontree").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
				var parentElement = table.rows[i].cells[j];
				while (parentElement.hasChildNodes()) {
					parentElement.removeChild(parentElement.lastChild);
				}
			}
		}
}

// ---------------------------- pas de carte --------------------------------
	function createMessage(message){
		delleteCarteMontree();
		document.getElementById('mesnotes3').innerHTML="<br><br><hr><br><br>"+message+"<br><br><hr>";
}		
// --------------------------- creer carte montree ---------------------------

	function createCarteMontree(id,L,C){
	delleteCarteMontree();
	document.getElementById('mesnotes3').innerHTML="La carte montree : <br>"+message;
	var bttn = document.createElement("button");
	bttn.setAttribute('class', 'bt');
	var oImg = document.createElement("img");
	var s =srcCarte(id);
	oImg.setAttribute('src', 'images/Cartes/' + s);
	oImg.setAttribute('class', 'cat');
	bttn.appendChild(oImg);
	var table = document.getElementById("carteMontree");
	var arrayLignes = document.getElementById("carteMontree").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
			var parentElement = table.rows[i].cells[j];
			if (i == L && j == C) {
				parentElement.appendChild(bttn);
				break;
			}
		}
	}
	
		
		
		
		
	}






function  enabledCardsResponse(){
	
}
// -------------------------------- | resoudre | ----------------------------------------

$(document).ready(function() {
	$(document).on("click", ".resod", function() {
		var k=0;
		$.get(
			"resoudre.servlet",
			{ k: k},
			function(responseText) {	
		      let obj = JSON.parse(responseText);
/*			    alert("Lieux : "+obj.CartesLieuxPossibles);
				alert("armes :"+obj.CartesArmesPossibles);
				alert("Suspects :"+obj.CartesSuspectPossibles);*/
				CartesArmesPossibles = obj.CartesArmesPossibles;
				CartesLieuxPossibles = obj.CartesLieuxPossibles;
				createResoudreSuspects(obj.CartesSuspectPossibles);
				//createResoudreArmes(CartesArmesPossibles);
				//createResoudreLieux(CartesLieuxPossibles);
			}
		);
	});
});


// ------------------- create Cartes Resoudre Suspect ---------------------------------
function createResoudreSuspect(id , L , C ){
	document.getElementById('mesnotes2').innerHTML="Resoudre le Crime : <br>Q'il Suspect :";
	var bttn = document.createElement("button");
	bttn.setAttribute('class', 'bt1');
	var oImg = document.createElement("img");
	var s =srcCarte(id);
	oImg.setAttribute('src', 'images/Cartes/' + s);
	oImg.setAttribute('class', 'cat1');
	bttn.setAttribute('id',id+'');
	bttn.setAttribute("onclick", "reply_clickSuspectRes(this.id)");
	bttn.appendChild(oImg);
	var table = document.getElementById("ResoudreCartes");
	var arrayLignes = document.getElementById("ResoudreCartes").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
			var parentElement = table.rows[i].cells[j];
			if (i == L && j == C) {
				parentElement.appendChild(bttn);
				break;
			}
		}
	}
	
}


// ------------------- create Cartes Resoudre Arme ---------------------------------
function createResoudreArme(id , L , C ){
	document.getElementById('mesnotes2').innerHTML="Q'il Arme utilise :";
	var bttn = document.createElement("button");
	bttn.setAttribute('class', 'bt1');
	var oImg = document.createElement("img");
	var s =srcCarte(id);
	oImg.setAttribute('src', 'images/Cartes/' + s);
	oImg.setAttribute('class', 'cat1');
	bttn.setAttribute('id',id+'');
	bttn.setAttribute("onclick", "reply_clickArmeRes(this.id)");
	bttn.appendChild(oImg);
	var table = document.getElementById("ResoudreCartes");
	var arrayLignes = document.getElementById("ResoudreCartes").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
			var parentElement = table.rows[i].cells[j];
			if (i == L && j == C) {
				parentElement.appendChild(bttn);
				break;
			}
		}
	}
	
}



// ------------------- create Cartes Resoudre lieu ---------------------------------
function createResoudreLieu(id , L , C ){
	document.getElementById('mesnotes2').innerHTML="Dans q'il Lieu :";
	var bttn = document.createElement("button");
	bttn.setAttribute('class', 'res');
	var oImg = document.createElement("img");
	var s =srcCarte(id);
	oImg.setAttribute('src', 'images/Cartes/' + s);
	oImg.setAttribute('class', 'cat1');
	bttn.setAttribute('id',''+id);
	bttn.setAttribute("onclick", "reply_clickLieuRes(this.id)");
	bttn.appendChild(oImg);
	var table = document.getElementById("ResoudreCartes");
	var arrayLignes = document.getElementById("ResoudreCartes").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
			var parentElement = table.rows[i].cells[j];
			if (i == L && j == C) {
				parentElement.appendChild(bttn);
				break;
			}
		}
	}
	
}


//------------------vider la table de resoudre ---------------------------
 function deleteAllCartesResoudre(){
	var table = document.getElementById("ResoudreCartes");
	var arrayLignes = document.getElementById("ResoudreCartes").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
				var parentElement = table.rows[i].cells[j];
				while (parentElement.hasChildNodes()) {
					parentElement.removeChild(parentElement.lastChild);
				}
			}
		}
}		


// -------------------------- ||||||||||||||| --------------------------------
/// creation toutes les cartes Suspects dans l'hepothese;
  // --------------------------- Suspect ---------------------------------
  function createResoudreSuspects(ids) {
	deleteAllCartesResoudre();
	var c = 0;
	switch (ids.length) {
		
		case 1:
					createResoudreSuspect(ids[0], 0, 0);
					
		break;
		case 2:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 2; j++) {
					createResoudreSuspect(ids[c], i, j);
					c++;
				}
			}
			break;
		case 3:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreSuspect(ids[c], i, j);
					c++;
				}
			}
			break;

	
		case 4:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreSuspect(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 1; j++) {
					createResoudreSuspect(ids[c], i, j);
					c++;
				}
			}
			break;
		case 5:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreSuspect(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 2; j++) {
					createResoudreSuspect(ids[c], i, j);
					c++;
				}
			}
			break;
		case 6:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreSuspect(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreSuspect(ids[c], i, j);
					c++;
				}
			}
			break;
		default:
			break;
	}
}

// --------------------------- Armes ---------------------------------
  function createResoudreArmes(ids) {
	deleteAllCartesResoudre();
	var c = 0;
	switch (ids.length) {
		
		case 1:
					createResoudreArme(ids[0], 0, 0);
					
		break;
		case 2:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 2; j++) {
					createResoudreArme(ids[c], i, j);
					c++;
				}
			}
			break;
		case 3:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreArme(ids[c], i, j);
					c++;
				}
			}
			break;

	
		case 4:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreArme(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 1; j++) {
					createResoudreArme(ids[c], i, j);
					c++;
				}
			}
			break;
		case 5:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreArme(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 2; j++) {
					createResoudreArme(ids[c], i, j);
					c++;
				}
			}
			break;
		case 6:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreArme(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreArme(ids[c], i, j);
					c++;
				}
			}
			break;
		default:
			break;
	}
}


// --------------------------- liex ---------------------------------
  function createResoudreLieux(ids) {
	deleteAllCartesResoudre();
	var c = 0;
	switch (ids.length) {
		
		case 1:
					createResoudreLieu(ids[0], 0, 0);
					
		break;
		case 2:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 2; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			break;
		case 3:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			break;

	
		case 4:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 1; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			break;
		case 5:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 2; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			break;
		case 6:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			break;
		case 7:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			for (var i = 2; i < 3; i++) {
				for (var j = 0; j < 1; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			break;
		case 8:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			for (var i = 2; i < 3; i++) {
				for (var j = 0; j < 2; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			break;
		case 9:
			for (var i = 0; i < 1; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			for (var i = 1; i < 2; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			for (var i = 2; i < 3; i++) {
				for (var j = 0; j < 3; j++) {
					createResoudreLieu(ids[c], i, j);
					c++;
				}
			}
			break;
		default:
			break;
	}
}
// -------------------------- ||||||||||||||| --------------------------------










function reply_clickSuspectRes(clicked_id)
  {
		
      carteSusResSelc =clicked_id;
	  createResoudreArmes(CartesArmesPossibles);
  }

function reply_clickArmeRes(clicked_id)
  {
      carteArmResSelc= clicked_id;
	  createResoudreLieux(CartesLieuxPossibles);	
  }

function reply_clickLieuRes(clicked_id)
  {
      carteLieResSelc= clicked_id;
	  arrayRes =[Number(carteSusResSelc),Number(carteArmResSelc),Number(carteLieResSelc)];
	  //------------------------------------
	$(document).ready(function() {
	$(document).on("click", ".res", function() {
		$.get(
			"compare.servlet",
			{ idR1: arrayRes[0],
			  idR2: arrayRes[1],
			  idR3: arrayRes[2],
			},
			function(responseText) {	
		      	let obj = JSON.parse(responseText);
				deleteAllCartesResoudre();
				res=obj.res;
				etat=obj.etat;
				createResultat();
				//document.getElementById('mesnotes2').innerHTML="<br><hr><br>"+"Votre Solution est : "+obj.res+"<br> Vous etes : "+obj.etat+" <br><br><hr>";
			}
		);
	});
});
	  //----------------------------------
	//
	  	
		
  }

// ----------------------------------- ||||||||||||||| -----------------------------


function createResultat(){
	document.getElementById('mesnotes2').innerHTML="Votre resultat : ";
	var h2 = document.createElement("h2");
	let F="<hr color='red' size='10px'><br><br>"+"  Solution  : <br>"+res+"<br> Vous etes : <br>"+etat+" <br><br><hr color='red' size='10px'>";
	let V="<hr color='green' size='10px'><br><br>"+"  Solution  : <br>"+res+"<br> Vous etes : <br>"+etat+" <br><br><hr color='green' size='10px'>";
	if(res=='true')
	h2.innerHTML=V;
	else{
	h2.innerHTML=F;	
	}
	var table = document.getElementById("ResoudreCartes");
	var arrayLignes = document.getElementById("ResoudreCartes").rows;
	var longueur = arrayLignes.length;
	for (var i = 0; i < longueur; i++) {
		var arrayColonnes = arrayLignes[i].cells;
		var largeur = arrayColonnes.length;
		for (var j = 0; j < largeur; j++) {
			var parentElement = table.rows[i].cells[j];
			if (i == 1 && j == 1) {
				parentElement.appendChild(h2);
				break;
			}
		}
	}
	
}














// -------------------------------- | Profil | ---------------------------------

function nomJoueur(id){
	switch(id){
		case 1:
		return "MMe White";
		case 2:
		return "Mr Violet";
		case 3:
		return "Mr Jaune";
		case 4:
		return "Mr Vert";
		case 5:
		return "MMe Bleue";
		case 6:
		return "MMe Rouge";
	}
}

function photoJoueur(id){
	switch(id){
		case 1:
		return "blanc.png";
		case 2:
		return "violet.png";
		case 3:
		return "jaune.png";
		case 4:
		return "vert.png";
		case 5:
		return "bleu.png";
		case 6:
		return "rouge.png";
	}
}


//---------------------- || ----------------------------------
function gererTourJeu(idJoueur){
	document.getElementById('Col').innerHTML='Tour de Joueur '+nomJoueur(idJoueur);
	var img = document.createElement("img");
	img.setAttribute('class','Profil');
	img.setAttribute('src','images/players/'+photoJoueur(idJoueur));
	var table = document.getElementById('tableProfil');
	var parentElement = table.rows[0].cells[0];
	parentElement.removeChild;
	while (parentElement.firstChild) {
		parentElement.removeChild(parentElement.lastChild);
		}
	parentElement.appendChild(img);
	
}









		