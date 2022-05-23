package métier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Joueur extends Utilisateur{

	private int idJoueur;
	private String nomJoueur;
	private String coleurPion;
	private Notes notesJoueur;
	private ArrayList<Carte> cartesJoueur;
	private Position positionDepartPion;
	private Position positionActuelPion;
	private String etatJeu;
	private Boolean tourJoueur;
	private Boolean tourRepondre;
	private ArrayList<Carte> hypotheseJoueur = new ArrayList<Carte>();
	private Carte carteAfficher;
	private int nbrDeDeplacement;
	
	// constructeur
	
	public Joueur(String userName, String passWord, String emailAdresse, String niveau, int score) {
		super();
	}
	
	
	// -------------------------
	
	public Joueur() {
	}



	public Joueur(int idJoueur, String nomJoueur, String coleurPion, Notes notesJoueur, ArrayList<Carte> cartesJoueur,
			Position positionDepartPion, Position positionActuelPion, String etatJeu, Boolean tourJoueur,
			Boolean tourRepondre, ArrayList<Carte> hypotheseJoueur, Carte carteAfficher, int nbrDeDeplacement) {
		super();
		this.idJoueur = idJoueur;
		this.nomJoueur = nomJoueur;
		this.coleurPion = coleurPion;
		this.notesJoueur = notesJoueur;
		this.cartesJoueur = cartesJoueur;
		this.positionDepartPion = positionDepartPion;
		this.positionActuelPion = positionActuelPion;
		this.etatJeu = etatJeu;
		this.tourJoueur = tourJoueur;
		this.tourRepondre = tourRepondre;
		this.hypotheseJoueur = hypotheseJoueur;
		this.carteAfficher = carteAfficher;
		this.nbrDeDeplacement = nbrDeDeplacement;
	}



	public Boolean getTourRepondre() {
		return tourRepondre;
	}

	public void setTourRepondre(Boolean tourRepondre) {
		this.tourRepondre = tourRepondre;
	}

	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public String getColeurPion() {
		return coleurPion;
	}

	public void setColeurPion(String coleurPion) {
		this.coleurPion = coleurPion;
	}

	public Notes getNotesJoueur() {
		return notesJoueur;
	}

	public void setNotesJoueur(Notes notesJoueur) {
		this.notesJoueur = notesJoueur;
	}

	public ArrayList<Carte> getCartesJoueur() {
		return cartesJoueur;
	}

	public void setCartesJoueur(ArrayList<Carte> cartesJoueur) {
		this.cartesJoueur = cartesJoueur;
	}

	public Position getPositionDepartPion() {
		return positionDepartPion;
	}

	public void setPositionDepartPion(Position positionDepartPion) {
		this.positionDepartPion = positionDepartPion;
	}

	public Position getPositionActuelPion() {
		return positionActuelPion;
	}

	public void setPositionActuelPion(Position positionActuelPion) {
		this.positionActuelPion = positionActuelPion;
	}

	public String getEtatJeu() {
		return etatJeu;
	}

	public void setEtatJeu(String etatJeu) {
		this.etatJeu = etatJeu;
	}

	public Boolean getTourJoueur() {
		return tourJoueur;
	}

	public void setTourJoueur(Boolean tourJoueur) {
		this.tourJoueur = tourJoueur;
	}

	public ArrayList<Carte> getHypotheseJoueur() {
		return hypotheseJoueur;
	}

	public void setHypotheseJoueur(ArrayList<Carte> hypotheseJoueur) {
		this.hypotheseJoueur = hypotheseJoueur;
	}

	public Carte getCarteAfficher() {
		return carteAfficher;
	}

	public void setCarteAfficher(Carte carteAfficher) {
		this.carteAfficher = carteAfficher;
	}
	

	public int getNbrDeDeplacement() {
		return nbrDeDeplacement;
	}



	public void setNbrDeDeplacement(int nbrDeDeplacement) {
		this.nbrDeDeplacement = nbrDeDeplacement;
	}


	@Override
	public String toString() {
		return "Joueur [idJoueur=" + idJoueur + ", nomJoueur=" + nomJoueur + ", coleurPion=" + coleurPion
				+ ", notesJoueur=" + notesJoueur + ", cartesJoueur=" + cartesJoueur + ", positionDepartPion="
				+ positionDepartPion + ", positionActuelPion=" + positionActuelPion + ", etatJeu=" + etatJeu
				+ ", tourJoueur=" + tourJoueur + ", tourRepondre=" + tourRepondre + ", hypotheseJoueur="
				+ hypotheseJoueur + ", carteAfficher=" + carteAfficher + ", nbrDeDeplacement=" + nbrDeDeplacement + "]";
	}





	// methods
	Fonctions F = new Fonctions();

	public Notes voirNotes() {
		return this.notesJoueur;
	}

	public int lancerDes() {
		Random r = new Random();
		// Trois des
		int l = r.nextInt(12) + 2;
		this.setNbrDeDeplacement(l);
		return l;
	}

	public void questionner(Plateau p, Jeu jeu, ArrayList<Carte> hyp) {
		
		int a = hyp.get(0).getIdCarte(), b = hyp.get(1).getIdCarte();
		ArrayList<Carte> hypF = new ArrayList<Carte>();
		if (this.getTourJoueur() == true) {

			if ((a <= 9) && (b <= 9)) {
				System.out.println("Vous n'avez pas le droit de choisir le LIEU !! \n");
			} else if (((a >= 10 && a <= 15) && (b >= 10 && b <= 15)) || ((a >= 16 && a <= 21) && (b >= 16 && b <= 21))) {
				System.out.println("Choisir une carte pour chaque type de carte \n");
			}
			else {
				// test avec la position
				
				if(!(F.lieuJoueur(p,this.getPositionActuelPion())==null)) {
					hypF.add(F.carteLieu(jeu, F.lieuJoueur(p,this.getPositionActuelPion())));
					hypF.addAll(hyp);
					this.setHypotheseJoueur(hypF);
				}
				
			}
		}
	}

	public Carte repondre(Jeu jeu ,ArrayList<Carte> hypothese, int g) {
		
		ArrayList<Carte> cartesIdentiques = new ArrayList<Carte>();
		for (Carte c : this.getCartesJoueur()) {
			for (Carte C : hypothese) {
				if (F.ComparCartes(C, c))
					cartesIdentiques.add(C);
			}
		}
		int a = cartesIdentiques.size();
		int i=F.TourJeu(jeu);
		if (a == 0) {
			System.out.println("\nj'ai aucune carte\n");
			return null;
		} else if (a == 1) {
			System.out.println("\nj'ai une seule carte\n");
			System.out.println(cartesIdentiques);
			jeu.getJoueurs().get(i).setCarteAfficher(cartesIdentiques.get(0));
			HashMap<Carte, String> hm = new HashMap<Carte, String>();
			hm.putAll(jeu.getJoueurs().get(i).getNotesJoueur().getCartesEtats());
			jeu.getJoueurs().get(i).getNotesJoueur().setCartesEtats(F.coucher(hm, cartesIdentiques.get(0)));
			return cartesIdentiques.get(0);	
		}
		else {
			//System.out.println("cartesEdentiques  "+cartesIdentiques);
			Carte C = new Carte();
			C=jeu.getJoueurs().get(i).getHypotheseJoueur().get(g);
			if(cartesIdentiques.contains(C))
			{
				jeu.getJoueurs().get(i).setCarteAfficher(C);
				HashMap<Carte, String> hm = new HashMap<Carte, String>();
				hm.putAll(jeu.getJoueurs().get(i).getNotesJoueur().getCartesEtats());
				jeu.getJoueurs().get(i).getNotesJoueur().setCartesEtats(F.coucher(hm,C));
				return hypothese.get(g);
			}
		}
		return null;
	}

	public ArrayList<Carte> resoudreLeCrime(int A, int B, int C) {

		ArrayList<Carte> posibilities = new ArrayList<Carte>();

		if (this.getTourJoueur() == true) {
			posibilities.addAll(F.CartesNonCocherMachine(this.getNotesJoueur().getCartesEtats()));
			ArrayList<Carte> resudre = new ArrayList<Carte>();
			resudre.add(posibilities.get(A));
			resudre.add(posibilities.get(B));
			resudre.add(posibilities.get(C));
			return resudre;

		}

		return null;
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}


