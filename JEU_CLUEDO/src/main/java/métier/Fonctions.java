package métier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Fonctions {
	public HashMap<Carte, String> coucher(HashMap<Carte, String> HM, Carte carte) {
		HashMap<Carte, String> map = new HashMap<Carte, String>(HM);
		for (Map.Entry m : map.entrySet()) {
			if (this.ComparCartes((Carte) m.getKey(), carte)) {
				m.setValue("VraiParMachine");
			}
		}
		return map;
	}

	public int gererTourPlus(Jeu jeu, int j) {
		int t = jeu.getJoueurs().size();
		if (j <= t && j >= 0) {
			if (j == t - 1) {
				return 0;
			} else if (j < t - 1 && j > 0) {
				return j + 1;
			} else {
				return j + 1;
			}
		} else {
			System.out.println("Erreur !!");
			return -1;
		}

	}

	public int gererTourMoins(Jeu jeu, int j) {
		int t = jeu.getJoueurs().size();
		if (j <= t && j >= 0) {
			if (j == t - 1) {
				return t - 2;
			} else if (j < t - 1 && j > 0) {
				return j - 1;
			} else {
				return t - 1;
			}
		} else {
			System.out.println("Erreur !!");
			return -1;
		}

	}

	public int gererTour(Jeu jeu, int j) {
		int t = jeu.getJoueurs().size();
		if (j <= t && j >= 0) {
			if (j == t - 1) {
				jeu.getJoueurs().get(j).setTourJoueur(true);
				jeu.getJoueurs().get(j - 1).setTourJoueur(false);
				return 0;
			} else if (j < t - 1 && j > 0) {
				jeu.getJoueurs().get(j).setTourJoueur(true);
				jeu.getJoueurs().get(j - 1).setTourJoueur(false);
				return j + 1;
			} else {
				jeu.getJoueurs().get(j).setTourJoueur(true);
				jeu.getJoueurs().get(t - 1).setTourJoueur(false);
				return j + 1;
			}
		} else {
			System.out.println("Erreur !!");
			System.out.println("Erreur !!");
			return -1;
		}

	}

	public boolean ComparCartes(Carte A, Carte B) {
		if ((A.getIdCarte() == B.getIdCarte()) && (A.getNomCarte() == B.getNomCarte())
				&& (A.getClass() == B.getClass()))
			return true;
		else
			return false;
	}

	public ArrayList<Carte> CartesNonCocherMachine(HashMap<Carte, String> N) {
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		HashMap<Carte, String> map = new HashMap<Carte, String>(N);
		for (Map.Entry m : map.entrySet()) {
			if (!(m.getValue().equals("VraiParMachine"))) {
				cartes.add((Carte) m.getKey());
			}
		}
		return cartes;
	}

	public int gererTourRepondre(Jeu jeu, int i, int j) {
		if (i != j) {
			if (jeu.getJoueurs().get(i).getTourJoueur().equals(true)) {
				jeu.getJoueurs().get(this.gererTourMoins(jeu, i)).setTourRepondre(false);
				jeu.getJoueurs().get(this.gererTourMoins(jeu, j)).setTourRepondre(false);
				jeu.getJoueurs().get(j).setTourRepondre(true);
				return this.gererTourPlus(jeu, j);
			}
			else
				return -1;
		}
		else {
			
			System.out.println("j====i !!");
			for (int k = 0; k < jeu.getJoueurs().size(); k++) {
				jeu.getJoueurs().get(k).setTourRepondre(false);
			}
			return -1;
		}
	}

	public int TourJeu(Jeu jeu) {
		int i = 0;
		for (Joueur j : jeu.getJoueurs()) {
			if (j.getTourJoueur().equals(true))
				return i;
			i++;
		}
		return i;

	}

	public int TourRepondreJeu(Jeu jeu) {
		int i = 0;
		for (Joueur j : jeu.getJoueurs()) {
			if (j.getTourRepondre().equals(true))
				return i;
			i++;
		}
		return i;

	}

	public void AffichageTabPlateau(Plateau p) {
		for (int i = 0; i < 27; i++) {
			for (int j = 0; j < 27; j++) {
				System.out.print(" " + p.getTableau()[i][j]);
			}
			System.out.println();
		}

	}

	public boolean ComparePositions(Position A, Position B) {
		if ((A.getColonne() == B.getColonne()) && A.getLigne() == B.getLigne()) {
			return true;
		}
		return false;

	}


	public int playerIndex(Jeu jeu , Position position) {
		ArrayList<Position> positionsAct = new ArrayList<Position>();
		int n = jeu.getJoueurs().size();
		for(int i =0 ; i<n;i++) {
			positionsAct.add(jeu.getJoueurs().get(i).getPositionActuelPion());
		}
		int j=0;
		for(Position P : positionsAct) {
			if(this.ComparePositions(P, position)) {
				return j;
			}
			j++;
		}
		return -1;
		
	}
	
	public Lieu lieuJoueur(Plateau plt, Position PosJoueur) {

		for(Lieu l:plt.getLieuxPlateau()) {
			for(Position po:l.getLieuPositions()) {
				if(this.ComparePositions(po, PosJoueur)) {
					return l;
				}
			}
		}
		return null;
		
	}
	
	public Carte carteLieu(Jeu jeu, Lieu l) {
		String noml = new String();
		noml=l.getNomLieu();
		for(Carte carte : jeu.getCartesJeu()) {
			if(carte.getNomCarte().equals(noml))
				return carte;
		}
			
		return null;
	}
	public Position setPosDepart(int indice) {
		Position position = new Position();
		switch(indice) {
		case 0:
			position.setLigne(19);
			position.setColonne(25);
			return position;
		case 1:
			position.setLigne(7);
			position.setColonne(25);
			return position;
		case 2:
			position.setLigne(1);
			position.setColonne(16);
			return position;
		case 3:
			position.setLigne(1);
			position.setColonne(10);
			return position;
		case 4:
			position.setLigne(18);
			position.setColonne(1);
			return position;
		case 5:
			position.setLigne(25);
			position.setColonne(10);
			return position;
		default:
			System.out.println("error 404");
			return position;
		}
	}
	
	
public void daplacer(Jeu  jeu ,Plateau p ,String c) {
	Position pos = new Position();
	switch(c) {
	case "U":
		pos.Up(p, jeu);
		break;
	case "D":
		pos.Down(p, jeu);
		break;
	case "R":
		pos.Right(p, jeu);
		break;
	case "L":
		pos.Left(p, jeu);
		break;
	
	default:
		System.out.println("valeur n'est pas valide !!");
	}
	
}

public void resoudrer(Joueur jou, int reponse) {
	switch(reponse) {
		case 1 :
			jou.resoudreLeCrime(reponse, reponse, reponse);
			break;
		case 2 :
			break;
		default:
			break;
			
	}
}
public void passagesSecret(Jeu jeu) {
	int i=0;
	i=this.TourJeu(jeu);
	// pour la cuisine c'est la position (1,6) et le bureau c'est la position (25,25)
	if(this.ComparePositions(jeu.getJoueurs().get(i).getPositionActuelPion(), new Position(1,6))) {
		jeu.getJoueurs().get(i).setPositionActuelPion(new Position(25, 25));
	}
	else if(this.ComparePositions(jeu.getJoueurs().get(i).getPositionActuelPion(), new Position(25,25))) {
		jeu.getJoueurs().get(i).setPositionActuelPion(new Position(1, 6));
	}
	// pour le salon c'est la position (25,1) et le terrasse c'est la position (1,25)
	else if(this.ComparePositions(jeu.getJoueurs().get(i).getPositionActuelPion(), new Position(25,1))) {
		jeu.getJoueurs().get(i).setPositionActuelPion(new Position(1, 25));
	}
	else if(this.ComparePositions(jeu.getJoueurs().get(i).getPositionActuelPion(), new Position(1,25))) {
		jeu.getJoueurs().get(i).setPositionActuelPion(new Position(25, 1));
	}
}

public boolean isPassagesSecret(Jeu jeu) {
	int j=this.TourJeu(jeu);
	Position Pos = new Position();
	Pos = jeu.getJoueurs().get(j).getPositionActuelPion();
	if((this.ComparePositions(Pos, new Position(1, 6))) || (this.ComparePositions(Pos, new Position(25, 25))) || (this.ComparePositions(Pos, new Position(1, 25))) || (this.ComparePositions(Pos, new Position(25, 1)))) {
		return true;
	}
	else 
		return false;
	
}

public ArrayList<Integer> idCarteJoueurs(Joueur joueur){
	ArrayList<Integer> res = new ArrayList<>();
	for(Carte c: joueur.getCartesJoueur()) {
		res.add(c.getIdCarte());	}
	return res;
}


public ArrayList<Integer> idCarteCochees(Joueur joueur){
	HashMap<Carte, String> map = new HashMap<Carte, String>(joueur.getNotesJoueur().getCartesEtats());
	ArrayList<Carte> noCochees = new ArrayList<Carte>();
	noCochees=this.CartesNonCocherMachine(map);
	ArrayList<Integer> idcartenoCochees = new ArrayList<Integer>();
	for(Carte c: noCochees) {
		idcartenoCochees.add(c.getIdCarte());	
		}
	System.out.println(idcartenoCochees.toString());
	ArrayList<Integer> ids = new ArrayList<Integer>();
	for(int k=1;k<=21;k++) {
		ids.add(k);
	}
	
	for(int j=0;j<idcartenoCochees.size();j++){
		for(int i=0;i<ids.size();i++) {
			if(ids.get(i)==idcartenoCochees.get(j)) {
				ids.remove(ids.get(i));
			}
				
		}
	}
	System.out.println(ids.toString());
	return ids;
}




public HashMap<Carte, String> decoucher(HashMap<Carte, String> HM, Carte carte) {
	HashMap<Carte, String> map = new HashMap<Carte, String>(HM);
	for (Map.Entry m : map.entrySet()) {
		if (this.ComparCartes((Carte) m.getKey(), carte)) {
			m.setValue("Faux");
		}
	}
	return map;
}

public  HashMap<Carte, String> sauvgarder(Jeu jeu,Joueur j, ArrayList<Integer> listIdsaCoucher){
	HashMap<Carte, String> map = new HashMap<Carte, String>();
	map = j.getNotesJoueur().getCartesEtats();
		for(int y=0;y<21;y++) {
			map=this.decoucher(map, jeu.getCartesJeu().get(y));
		}
			for(int i=0;i<listIdsaCoucher.size();i++) {
					map=this.coucher(map, jeu.getCartesJeu().get(listIdsaCoucher.get(i)-1));
				}
					
		for(Carte c :j.getCartesJoueur()) 
		{
			map=coucher(map, c);
		}
		j.getNotesJoueur().setCartesEtats(map);
		return j.getNotesJoueur().getCartesEtats();
}





public  ArrayList<Integer> idsDesCartesArmes(Jeu jeu,Joueur j){
	ArrayList<Integer> ids = new ArrayList<>();
	
			for(Carte c :jeu.getCartesJeu()) 
			{
				if(!(j.getCartesJoueur().contains(c)) && (c.getIdCarte()>=10) && (c.getIdCarte()<=15)) {
					ids.add(c.getIdCarte());
				}
			}	
	return ids;
			
}


public  ArrayList<Integer> idsDesCartesSuspect(Jeu jeu,Joueur j){
	ArrayList<Integer> ids = new ArrayList<>();
	
			for(Carte c : jeu.getCartesJeu()) 
			{
				if(!(j.getCartesJoueur().contains(c)) && (c.getIdCarte()>15)) {
					ids.add(c.getIdCarte());
				}
			}	
	return ids;
			
}








public ArrayList<Carte> cartesIds(Jeu jeu ,ArrayList<Integer> list){
	ArrayList<Carte> Cartes = new ArrayList<>();
	for(Carte c : jeu.getCartesJeu()) {
		for(Integer i : list) {
			 if(c.getIdCarte()==i) {
				 Cartes.add(c);
			 }
		}
	}
	return Cartes;
}





}

