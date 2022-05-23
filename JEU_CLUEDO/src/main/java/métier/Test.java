package métier;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Fonctions F = new Fonctions();
		Scanner scanner = new Scanner(System.in);
		Plateau PlateauPrincipale = new Plateau();
//Les lieux de Plateaux 
	// les positions de chaque lieu 
		// Hall
		ArrayList<Position> PsL1 = new ArrayList<Position>();
		for(int k=19;k<25;k++) {
			for(int j=11;j<16;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL1.add(new Position(k, j));
				}
			}
		}
		
		// Bureau
		ArrayList<Position> PsL2 = new ArrayList<Position>();
		for(int k=21;k<26;k++) {
			for(int j=19;j<26;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL2.add(new Position(k, j));
				}
			}
		}
		
		// Bibliothéque
		ArrayList<Position> PsL3 = new ArrayList<Position>();
		for(int k=14;k<18;k++) {
			for(int j=19;j<26;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL3.add(new Position(k, j));
				}
			}
		}
		
		// Salle de jeux
		ArrayList<Position> PsL4 = new ArrayList<Position>();
		for(int k=9;k<12;k++) {
			for(int j=20;j<25;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL4.add(new Position(k, j));
				}
			}
		}
		
		// Terrasse
				ArrayList<Position> PsL5 = new ArrayList<Position>();
				for(int k=1;k<6;k++) {
					for(int j=21;j<25;j++) {
						if(PlateauPrincipale.getTableau()[k][j]==1) {
							PsL5.add(new Position(k, j));
						}
					}
				}
		// Salle de danse
		ArrayList<Position> PsL6 = new ArrayList<Position>();
		for(int k=2;k<7;k++) {
			for(int j=10;j<=16;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL6.add(new Position(k, j));
				}
			}
		}
		
		// cuisine
		ArrayList<Position> PsL7 = new ArrayList<Position>();
		for(int k=0;k<7;k++) {
			for(int j=0;j<7;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL7.add(new Position(k, j));
				}
			}
		}
		
		// Salle a manger
		ArrayList<Position> PsL8 = new ArrayList<Position>();
		for(int k=11;k<16;k++) {
			for(int j=2;j<8;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL8.add(new Position(k, j));
				}
			}
		}
		
		// Salon
		ArrayList<Position> PsL9 = new ArrayList<Position>();
		for(int k=20;k<25;k++) {
			for(int j=2;j<7;j++) {
				if(PlateauPrincipale.getTableau()[k][j]==1) {
					PsL9.add(new Position(k, j));
				}
			}
		}
// les positions des portes 
			// Hall 
			ArrayList<Position> PsPoL1 = new ArrayList<Position>();
			PsPoL1.add(new Position(19, 12));
			PsPoL1.add(new Position(19, 13));
			PsPoL1.add(new Position(19, 14));
			PsPoL1.add(new Position(21, 16));
			// Bureau 
			ArrayList<Position> PsPoL2 = new ArrayList<Position>();
			PsPoL2.add(new Position(21, 22));
			// Bibliothéque 
			ArrayList<Position> PsPoL3 = new ArrayList<Position>();
			PsPoL3.add(new Position(14, 22));
			PsPoL3.add(new Position(16, 18));		
			// Salle de jeux
			ArrayList<Position> PsPoL4 = new ArrayList<Position>();
			PsPoL4.add(new Position(10, 19));
			PsPoL4.add(new Position(12, 24));
			// Terrasse
			ArrayList<Position> PsPoL5 = new ArrayList<Position>();
			PsPoL5.add(new Position(5, 21));
			// Salle de danse
			ArrayList<Position> PsPoL6 = new ArrayList<Position>();
			PsPoL6.add(new Position(9, 6));
			PsPoL6.add(new Position(10, 7));
			PsPoL6.add(new Position(10, 13));
			PsPoL6.add(new Position(9, 14));		
			// Cuisine
			ArrayList<Position> PsPoL7 = new ArrayList<Position>();
			PsPoL7.add(new Position(7, 4));			
			// Salle a manger
			ArrayList<Position> PsPoL8 = new ArrayList<Position>();
			PsPoL8.add(new Position(13, 8));
			PsPoL8.add(new Position(16, 7));			
			// Salon
			ArrayList<Position> PsPoL9 = new ArrayList<Position>();
			PsPoL9.add(new Position(21, 7));
// les lieu 
		Lieu L1 = new Lieu("Hall", 4, PsPoL1, PsL1);
		Lieu L2 = new Lieu("Le bureau", 1, PsPoL2, PsL2);
		Lieu L3 = new Lieu("Bibliothéque", 2, PsPoL3, PsL3);
		Lieu L4 = new Lieu("Salle de jeux", 2, PsPoL4, PsL4);
		Lieu L5 = new Lieu("Terrasse", 1, PsPoL5, PsL5);
		Lieu L6 = new Lieu("Salle de danse", 4, PsPoL6, PsL6);
		Lieu L7 = new Lieu("Cuisine", 1, PsPoL7, PsL7);
		Lieu L8 = new Lieu("Salle à manger", 2, PsPoL8, PsL8);
		Lieu L9 = new Lieu("Le salon", 1, PsPoL9, PsL9);
		
		PlateauPrincipale.getLieuxPlateau().add(L1);
		PlateauPrincipale.getLieuxPlateau().add(L2);
		PlateauPrincipale.getLieuxPlateau().add(L3);
		PlateauPrincipale.getLieuxPlateau().add(L4);
		PlateauPrincipale.getLieuxPlateau().add(L5);
		PlateauPrincipale.getLieuxPlateau().add(L6);
		PlateauPrincipale.getLieuxPlateau().add(L7);
		PlateauPrincipale.getLieuxPlateau().add(L8);
		PlateauPrincipale.getLieuxPlateau().add(L9);
		
// Cartes lieux
		Carte CL1 = new CarteLieu(1, "Hall");
		Carte CL2 = new CarteLieu(2, "Le bureau");
		Carte CL3 = new CarteLieu(3, "Bibliothéque");
		Carte CL4 = new CarteLieu(4, "Salle de jeux");
		Carte CL5 = new CarteLieu(5, "Terrasse");
		Carte CL6 = new CarteLieu(6, "Salle de danse");
		Carte CL7 = new CarteLieu(7, "Cuisine");
		Carte CL8 = new CarteLieu(8, "Salle à manger");
		Carte CL9 = new CarteLieu(9, "Le salon");
// Cartes Armes
		Carte A1 = new CarteArme(10, "Dague");
		Carte A2 = new CarteArme(11, "Tuyau de plomb");
		Carte A3 = new CarteArme(12, "Clé");
		Carte A4 = new CarteArme(13, "Chandelier");
		Carte A5 = new CarteArme(14, "Revolver");
		Carte A6 = new CarteArme(15, "Corde");
// Cartes Suspects
		Carte S1 = new CarteSuspect(16, "Rouge");
		Carte S2 = new CarteSuspect(17, "Vert");
		Carte S3 = new CarteSuspect(18, "Noir");
		Carte S4 = new CarteSuspect(19, "Violet");
		Carte S5 = new CarteSuspect(20, "Bleu");
		Carte S6 = new CarteSuspect(21, "jaune");
		ArrayList<Carte> carteJoueur = new ArrayList<Carte>();
		ArrayList<Carte> Allcartes = new ArrayList<Carte>();
		Allcartes.add(CL1);
		Allcartes.add(CL2);
		Allcartes.add(CL3);
		Allcartes.add(CL4);
		Allcartes.add(CL5);
		Allcartes.add(CL6);
		Allcartes.add(CL7);
		Allcartes.add(CL8);
		Allcartes.add(CL9);
		Allcartes.add(A1);
		Allcartes.add(A2);
		Allcartes.add(A3);
		Allcartes.add(A4);
		Allcartes.add(A5);
		Allcartes.add(A6);
		Allcartes.add(S1);
		Allcartes.add(S2);
		Allcartes.add(S3);
		Allcartes.add(S4);
		Allcartes.add(S5);
		Allcartes.add(S6);
		
//Instantiation d'un jeu :
		Jeu jeuA = new Jeu();
		jeuA.setCartesJeu(Allcartes);
//Instantiation d'un Match :
		Match matchA = new Match();
		matchA.setJeu(jeuA);
		matchA.setEtatMatch("N"); // N : Non fini -------- F : Fini	
		matchA.setDateMatch(new Date(2021,12,18));
	System.out.println("********************************  Bien venue sur CLUEDO  *************************************");
		System.out.println("Donner le nombre de joueurs : ");
		int nombreJoueurs = scanner.nextInt();
		if(nombreJoueurs>=2 && nombreJoueurs<=6) {
			// le remplissage de l'envoloppe et la distribustion des cartes
			jeuA.distribuerCartes(nombreJoueurs);
			System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+                                                                                  ");
			System.out.println("+            "+jeuA.getCartesEnveloppe().get(0)+"                                  ");
			System.out.println("+            "+jeuA.getCartesEnveloppe().get(1)+"                                  ");
			System.out.println("+            "+jeuA.getCartesEnveloppe().get(2)+"                                  ");
			System.out.println("+                                                                                  ");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		}
		else {
			System.out.println("le nombre de joueurs doit etre entre 2 et 6 (=) !!!");
		}
		int indiceDetat = 0;
		int nbrDeplacements=0;
		int i=0 , j=0 , k=0 , l=0;
		// les cartes de l'enveloppe  
		//System.out.println("Les cartes de l'enveloppe : ");
		//System.out.println(jeuA.getCartesEnveloppe().toString());
		
		while(matchA.getEtatMatch().equals("N"))
			{
			if(indiceDetat==0) {
				matchA.setEtatMatch("N");
			}
			else {
				matchA.setEtatMatch("F");
				break;
			}
			while(true) 
			{	
				l=F.TourJeu(jeuA);
				//System.out.println("\nC'est le tour de joueur d'indice : "+l);
				//i=F.gererTour(jeuA, l);
				j=F.gererTourPlus(jeuA, l);
				//j=F.gererTourRepondre(jeuA, l, j);
				// -------------
				//System.out.println("C'est  : "+l+" "+j+"\n");
				System.out.println("C'est le tour de  joueur numéro : "+(l+1)+"\n");
				// Lancement de dés ou passage de secet @@@@
				
				if(F.isPassagesSecret(jeuA)) {
				System.out.println("Vous voulez utiliser le passage secret ?\n1 : Oui\n2 : Non\n");
				int secret = scanner.nextInt();
				if(secret==1) {
					F.passagesSecret(jeuA);
				}
				else {
					nbrDeplacements =jeuA.getJoueurs().get(l).lancerDes();
					System.out.println("\nVous avez obtenu : "+jeuA.getJoueurs().get(l).getNbrDeDeplacement()+"\n");
					for(int index =0 ; index<nbrDeplacements ;index++) {
						System.out.println("\n Donner la direction : U => UP | D =>Down | L =>LEFT | R =>RIGHT : \n");
						String c = scanner.next();
						F.daplacer(jeuA, PlateauPrincipale, c);
					}
					System.out.println("+++++++++++++++++++++** plateu de jeu **++++++++++++++++++++++\n");
					F.AffichageTabPlateau(PlateauPrincipale);
					System.out.println("\n");
					System.out.println("+++++++++++++++++++++*******************++++++++++++++++++++++\n");
				}
			}
			else {
				nbrDeplacements =jeuA.getJoueurs().get(l).lancerDes();
				System.out.println("\nVous avez obtenu : "+jeuA.getJoueurs().get(l).getNbrDeDeplacement()+"\n");
				for(int index =0 ; index<nbrDeplacements ;index++) {
					System.out.println("\n Donner la direction : U => UP | D =>Down | L =>LEFT | R =>RIGHT : \n");
					String c = scanner.next();
					F.daplacer(jeuA, PlateauPrincipale, c);
				}
				System.out.println("+++++++++++++++++++++** plateu de jeu **++++++++++++++++++++++\n");
				F.AffichageTabPlateau(PlateauPrincipale);
				System.out.println("\n");
				System.out.println("+++++++++++++++++++++*******************++++++++++++++++++++++\n");
			}
				
					// cartes joueurs
					System.out.println("++++++++++++++*** cartes joueurs ***++++++++++++++");
					System.out.println("\n"+jeuA.getJoueurs().get(l).getCartesJoueur().toString());
					// notes joueurs
					System.out.println("++++++++++++++*** notes joueurs ***+++++++++++++++");
					System.out.println("\n"+jeuA.getJoueurs().get(l).getNotesJoueur().toString());
					//System.out.println(F.idsDesCartesArmes(jeuA, jeuA.getJoueurs().get(l)));
					//System.out.println(F.idsDesCartesSuspect(jeuA, jeuA.getJoueurs().get(l)));
					/*ArrayList<Integer>  test=new ArrayList<Integer>();
					test.add(11);test.add(9);
					test.add(20);test.add(1);
					test.add(4);
					System.out.println("+++++++++++++  test  +++++++++++++++");
					System.out.println(F.sauvgarder(jeuA, jeuA.getJoueurs().get(l),test ));
					System.out.println("++++++++++++++++++++++++++++");
					F.idCarteCochees(jeuA.getJoueurs().get(l));*/
					
		if(F.lieuJoueur(PlateauPrincipale, jeuA.getJoueurs().get(l).getPositionActuelPion())!=null ) {
					// faire une hypoyhese
					System.out.println("\n Donner l'indice d'un suspect :");
					int SuspectIndex = scanner.nextInt();
					System.out.println("\n Donner l'indice d'un Arme :");
					int ArmeIndex = scanner.nextInt();
					ArrayList<Carte> Hypothese = new ArrayList<Carte>();
					Hypothese.add(jeuA.getCartesJeu().get(SuspectIndex));
					Hypothese.add(jeuA.getCartesJeu().get(ArmeIndex));
					jeuA.getJoueurs().get(l).questionner(PlateauPrincipale, jeuA,Hypothese);
					// affichage de l'hypothese 
					System.out.println("++++++++++++++*** hypothese ***++++++++++++++");
					System.out.println("\n"+jeuA.afficherHypothese(l));
					int f;
					for(f=0;f<nombreJoueurs-1;f++) {
						System.out.println("\nJe suis le joueur : "+(j+1));
						Carte cat = new Carte();
						cat = jeuA.getJoueurs().get(j).repondre(jeuA,jeuA.afficherHypothese(l) , 0);
						//System.out.println("\nVoila ma reponse : "+cat);
						if(cat !=null) {
							break;
						}
						else {
							j=F.gererTourRepondre(jeuA, l, j);
						}
					}
					// -----------------------------
					/*while(jeuA.getJoueurs().get(j).repondre(jeuA, Hypothese, 0)==null && f<nombreJoueurs-1) 
					{
						int aide=j;
						j=F.gererTourRepondre(jeuA, l, j);
						if(j==-1) {
							j=F.gererTourRepondre(jeuA, l, aide);
							break;
						}
						f++;
					}*/
					// -----------------------------
					// notes joueurs aprés la reponse 
					System.out.println("\n+++++++++++++*** notes joueurs aprés la reponse ***++++++++++++++++");
					System.out.println(jeuA.getJoueurs().get(l).getNotesJoueur().toString());
					//System.out.println("\n Donner l'indice de carte a montrer :");
					//int carteMontreIndex = scanner.nextInt();
					System.out.println("\n Vous voulez resoudre le crime : \n1==>Oui \n2==>Non");
					int reponse = scanner.nextInt();
					
					if(reponse==1) {
					System.out.println(F.CartesNonCocherMachine(jeuA.getJoueurs().get(l).getNotesJoueur().getCartesEtats()));
					System.out.println("\n Donner l'indice d'un Suspect, d'un Arme, et d'un Lieux : \n ");
					System.out.println("Lieux d'indice : ");
					int L = scanner.nextInt();
					System.out.println("Arme d'indice : ");
					int A = scanner.nextInt();
					System.out.println("Suspect d'indice : ");
					int S = scanner.nextInt();
					jeuA.getJoueurs().get(l).resoudreLeCrime(L, A, S);
					System.out.println("\nVotre solution est : "+jeuA.comparer(jeuA.getJoueurs().get(l).resoudreLeCrime(L, A, S)));
					System.out.println("Vous etes : "+jeuA.afficherResultat(l));
					indiceDetat++;
					break;
					}
					else {
						l=F.gererTour(jeuA, F.gererTour(jeuA, l));
						//System.out.println("\nhan l ha : "+l);
						//continue;
					}
					}
		else {
			l=F.gererTour(jeuA, F.gererTour(jeuA, l));
			System.out.println("Vous n'etes pas dans aucun lieu, essayer de deplacer !!");
			//continue;
		}
			}
		}
		System.out.println("Le Match est finie !!!");
		System.out.println("*****************************************  CLUEDO ************************************************");
	}

}